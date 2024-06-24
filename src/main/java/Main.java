import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Задание №1\n");
        String[] newWords = new String[]{"солнце", "небо", "река", "огонь", "река", "река",
                "воздух", "солнце", "огонь", "песок", "туман", "дождь"};
        Words words = new Words(newWords);
        words.uniqueWords();
        words.wordCount();
        System.out.println("\n Задание №2\n");
        Phonebook phonebook = new Phonebook();
        phonebook.add("Ежова", "89618114222");
        phonebook.add("Ежова", "89605100568");
        phonebook.get("Ежова");
        phonebook.get("Иванов");
    }
}