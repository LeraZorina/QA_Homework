import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, String> directory;

    public Phonebook() {
        directory = new HashMap<>();
    }

    public void add(String fio, String phone) {
        if (directory.containsKey(phone)) {
            System.out.println("Контакт с таким номером есть в справочнике:" + directory.get(phone) + " " + phone);
        } else {
            directory.put(phone, fio);
        }
    }

    public void get(String fio) {
        ArrayList<String> allPhones = new ArrayList<>();
        for (String key : directory.keySet()) {
            if (directory.get(key).equals(fio)) {
                allPhones.add(key);
            }
        }
        if (allPhones.isEmpty()) {
            System.out.println("Такой фамилии нет в справочнике");
        } else {
            System.out.println(fio + ": Телефон " + allPhones);
        }
    }
}