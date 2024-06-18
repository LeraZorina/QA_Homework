import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Задание №1\n");
        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add("солнце");
        wordsList.add("небо");
        wordsList.add("река");
        wordsList.add("огонь");
        wordsList.add("река");
        wordsList.add("река");
        wordsList.add("воздух");
        wordsList.add("солнце");
        wordsList.add("огонь");
        wordsList.add("песок");
        wordsList.add("туман");
        wordsList.add("дождь");
        Set<String> setWords = new HashSet<>(wordsList);
        System.out.println("Уникальные слова в массиве: ");
        for (String word : setWords) {
            System.out.println(word);
        }
        HashMap<String, Integer> hashCount = new HashMap<>();
        for (String word : wordsList) {
            if (hashCount.containsKey(word)) {
                hashCount.put(word, hashCount.get(word) + 1);
            } else {
                hashCount.put(word, 1);
            }
        }
        System.out.println("Подсчет количества слов: ");
        for (String word : hashCount.keySet()) {
            System.out.println(word + "-" + hashCount.get(word));
        }
        System.out.println("\n Задание №2\n");
        Phonebook phonebook = new Phonebook();
        phonebook.add("Ежова", "89618114222");
        phonebook.add("Ежова", "89605100568");
        phonebook.get("Ежова");
        phonebook.get("Иванов");
    }
}