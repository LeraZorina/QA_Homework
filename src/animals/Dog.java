package animals;

public class Dog extends Animal {
    private static int dogCount;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int length) {
        if (length <= 500) {
            System.out.println("Собака " + name + " пробежал(а) " + length + " м.");
        } else {
            System.out.println("Собака не может пробежать " + length + " м.");
        }
    }

    @Override
    public void swim(int length) {
        if (length <= 10) {
            System.out.println("Собака " + name + " проплыл(а) " + length + " м.");
        } else {
            System.out.println("Собака не может проплыть " + length + " м.");
        }
    }

    public static void getCountDog() {
        System.out.println("Всего создано " + dogCount + " собак");
    }
}