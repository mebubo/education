package c11_sorting_and_searching.e11_07;

public class Person implements Comparable<Person> {
    int height;
    int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person o) {
        if (this.height != o.height) {
            return ((Integer) this.height).compareTo(o.height);
        } else {
            return ((Integer) this.weight).compareTo(o.weight);
        }
    }

    public boolean canBeUnder(Person o) {
        return height > o.height && weight > o.weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (height != person.height) return false;
        if (weight != person.weight) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + weight;
        return result;
    }
}
