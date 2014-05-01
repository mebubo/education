package c03_stacks_and_queues;

import java.util.LinkedList;

public class E03_07 {
    public static interface Animal {}
    public static class Dog implements Animal {}
    public static class Cat implements Animal {}

    private LinkedList<AnimalWithOrder<Dog>> dogs = new LinkedList<>();
    private LinkedList<AnimalWithOrder<Cat>> cats = new LinkedList<>();

    private int order;

    private static class AnimalWithOrder<T extends Animal> {
        private T animal;
        private int order;

        private AnimalWithOrder(T animal, int order) {
            this.animal = animal;
            this.order = order;
        }
    }

    public void enqueue(Animal animal) {
        if (animal instanceof Dog) {
            dogs.add(new AnimalWithOrder<>((Dog) animal, order++));
        } else if (animal instanceof Cat) {
            cats.add(new AnimalWithOrder<>((Cat) animal, order++));
        } else {
            throw new RuntimeException("Unsupported animal");
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            return null;
        }
        if (dogs.isEmpty()) {
            return cats.poll().animal;
        }
        if (cats.isEmpty()) {
            return dogs.poll().animal;
        }
        int catOrder = cats.peek().order;
        int dogOrder = dogs.peek().order;
        if (catOrder <= dogOrder) {
            return cats.poll().animal;
        }
        return dogs.poll().animal;
    }

    public Dog dequeueDog() {
        return dogs.isEmpty() ? null : dogs.poll().animal;
    }

    public Cat dequeueCat() {
        return cats.isEmpty() ? null : cats.poll().animal;
    }
}
