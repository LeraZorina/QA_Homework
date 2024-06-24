import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Words {
    String[] words;

    public Words(String[] words) {
        this.words = words;
    }

    public void uniqueWords() {
        Set<String> setWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова в массиве: ");
        for (String word : setWords) {
            System.out.println(word);
        }
    }

    public void wordCount() {
        HashMap<String, Integer> hashCount = new HashMap<>();
        for (String word : words) {
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
    }
}
