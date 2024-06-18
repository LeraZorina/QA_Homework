import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<String>> directory;

    public Phonebook() {
        directory = new HashMap<>();
    }

    public void add(String fio, String phone) {
        if (directory.containsKey(fio)) {
            var phoneNumber = directory.get(fio);
            phoneNumber.add(phone);
        } else {
            ArrayList<String> newContact = new ArrayList<>();
            newContact.add(phone);
            directory.put(fio, newContact);
        }
    }

    public void get(String fio) {
        if (directory.containsKey(fio)) {
            System.out.println(fio + " Телефон: " + directory.get(fio));
        } else {
            System.out.println("Такой фамилии нет в справочнике");
        }
    }
}