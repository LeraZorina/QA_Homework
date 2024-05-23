import java.util.ArrayList;

public class Park {
    public ArrayList<Attraction> attractions;
    private final int sizePark;

    public Park(int size) {
        sizePark = size;
        attractions = new ArrayList<Attraction>();
    }

    public void addAttraction(String name, String workingHours, int price) {
        if (sizePark == attractions.size()) {
            System.out.println("Нельзя добавить больше аттракционов");
            return;
        }
        Attraction newAttraction = new Attraction(name, workingHours, price);
        attractions.add(newAttraction);
        System.out.println("Добавлен аттракцион - " + newAttraction.name);
    }

    public void getInformation() {
        for (Attraction attraction : attractions)
            attraction.infoAttr();
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void infoAttr() {
            System.out.println("Название аттракциона: " + name + "; Часы работы: " + workingHours
                    + "; Стоимость: " + price);
        }
    }
}
