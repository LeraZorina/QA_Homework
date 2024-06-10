package animals;

public abstract class Animal {
    String name;
    private static int animalCount;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int length);

    public abstract void swim(int length);

    public static void getCount() {
        System.out.println("Всего создано " + animalCount + " животных");
    }
}

