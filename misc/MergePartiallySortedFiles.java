import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

class MergePartiallySortedFiles {

    public static void main(String... args) throws FileNotFoundException {
        mergePartiallySortedFiles(new File("a.txt"), new File("b.txt"), new File("/dev/stdout"), 40);
    }

    public static void mergePartiallySortedFiles(File f1, File f2, File output, int maxDisplacement) throws FileNotFoundException {
        writeFile(merge(sorted(fileIterator(f1), maxDisplacement), sorted(fileIterator(f2), maxDisplacement)), output);
    }

    private static Iterable<String> fileIterator(File f) throws FileNotFoundException {
        final BufferedReader reader = new BufferedReader(new FileReader(f));
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return new Iterator<String>() {

                    private String next;

                    {
                        try {
                            next = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    public boolean hasNext() {
                        return next != null;
                    }

                    public String next() {
                        String current = next;
                        try {
                            next = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return current;
                    }

                    @Override
                    public void remove() {

                    }
                };
            }
        };
    }

    private static void writeFile(Iterable<String> i, File output) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(output));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<String> it = i.iterator();
        try {
            while (it.hasNext()) {
                writer.write(it.next());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Iterable<String> sorted(Iterable<String> input, final int maxDisplacement) {
        final PriorityQueue<String> buffer = new PriorityQueue<String>();
        final Iterator<String> it = input.iterator();
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    public boolean hasNext() {
                        return it.hasNext() || buffer.size() != 0;
                    }

                    public String next() {
                        while (buffer.size() < maxDisplacement && it.hasNext()) {
                            buffer.offer(it.next());
                        }
                        return buffer.poll();
                    }

                    @Override
                    public void remove() {

                    }
                };
            }
        };
    }


    public static Iterable<String> merge(Iterable<String> i1, Iterable<String> i2) {

        class PeekingIterator {

            private String next;
            private Iterator<String> it;

            public PeekingIterator(Iterator it) {
                this.it = it;
                updateNext();
            }

            public boolean hasNext() {
                return next != null;
            }

            public String next() {
                String current = next;
                updateNext();
                return current;
            }

            public String peek() {
                return next;
            }

            private void updateNext() {
                next = it.hasNext() ? it.next() : null;
            }

        }

        final PeekingIterator it1 = new PeekingIterator(i1.iterator());
        final PeekingIterator it2 = new PeekingIterator(i2.iterator());
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return new Iterator<String>() {

                    public boolean hasNext() {
                        return it1.hasNext() || it2.hasNext();
                    }

                    public String next() {
                        if (it1.hasNext() && it2.hasNext()) {
                            if (it1.peek().compareTo(it2.peek()) < 0) return it1.next();
                            else return it2.next();
                        }
                        if (it1.hasNext()) return it1.next();
                        if (it2.hasNext()) return it2.next();
                        throw new NoSuchElementException();
                    }

                    @Override
                    public void remove() {
                    }
                };
            }
        };
    }

}
