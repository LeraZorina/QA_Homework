package animals;

public class Cat extends Animal {
    private boolean satiety;
    public Cat(String name) {
        super(name);
        satiety = false;
    }

    @Override
    public void run(int length) {
        if (length <= 200) {
            System.out.println("Кот " + name + " пробежал " + length + " м.");
        } else {
            System.out.println("Кот не может пробежать " + length + " м.");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кот не умеет плавать");
    }

    public void infoCat() {
        if (satiety) {
            System.out.println("Кот " + name + " сытый");
        } else {
            System.out.println("Кот " + name + " голодный ");
        }
    }

    public void eat(Bowl bowl, int countFood) {
        satiety = bowl.minusFood(countFood);
    }
}
