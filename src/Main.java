import animals.Animal;
import animals.Bowl;
import animals.Cat;
import animals.Dog;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Triangle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1\n");
        Dog dog = new Dog("Чарли");
        dog.run(250);
        Cat[] catsArray = new Cat[3];
        catsArray[0] = new Cat("Снежинка");
        catsArray[1] = new Cat("Фантик");
        catsArray[2] = new Cat("Джессика");
        Bowl bowl = new Bowl();
        bowl.addFood(200);
        catsArray[0].eat(bowl, 50);
        catsArray[1].eat(bowl, 100);
        catsArray[2].eat(bowl, 70);
        for (Cat cat : catsArray) {
            cat.infoCat();
        }
        catsArray[0].swim(15);
        Animal.getCount();
        Cat.getCountCat();
        Dog.getCountDog();
        System.out.println("\nЗадание №2\n");
        Circle circle = new Circle(5);
        circle.setFill("Зеленый");
        circle.setBorderColor("Красный");
        Rectangle rectangle = new Rectangle(6, 8);
        rectangle.setFill("Белый");
        rectangle.setBorderColor("Черный");
        Triangle triangle = new Triangle(8, 12, 10);
        triangle.setFill("Коричневый");
        triangle.setBorderColor("Желтый");
        circle.infoCircle();
        rectangle.infoRectangle();
        triangle.infoTriangle();
    }
}