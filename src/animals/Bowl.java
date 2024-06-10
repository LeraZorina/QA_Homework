package animals;

public class Bowl {
    public int amountOfFood;

    public void addFood(int quantity) {
        amountOfFood = amountOfFood + quantity;
    }

    public boolean minusFood(int count) {
        if (count <= amountOfFood) {
            amountOfFood = amountOfFood - count;
            return true;
        }
        return false;
    }
}
