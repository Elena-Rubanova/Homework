import lesson9.Phonebook;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //задание1
        List<String> words = Arrays.asList("Собака", "Кот", "Жираф", "Осел", "Верблюд",
                "Кот", "Лошадь", "Лошадь", "Олень", "Жираф",
                "Собака", "Верблюд", "Жираф", "Лев", "Тигр",
                "Панда", "Баран", "Олень", "Волк", "Жираф");

        Set<String> unique = new HashSet<>(words);

        System.out.println("Первоначальный массив:" + "\n" + words + "\n");
        System.out.println("Уникальные слова:" + "\n" + unique + "\n");
        System.out.println("Слово встречается:");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key) + " раз(а)");
        }

        System.out.println();

        //задание 2
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "+375293399569");
        phonebook.add("Петров", "+375444585263");
        phonebook.add("Сидоров", "+375335865752");
        phonebook.add("Иванова", "+375259995588");
        phonebook.add("Иванов", "+375295588369");

        String surname = "Петров";

        List<String> phones = phonebook.get(surname);

        if (phones.isEmpty()) {
            System.out.println("Номер телефона по фамилии " + surname + " не найден.");
        } else {
            System.out.println("Номер(а) телефона(ов) по фамилии " + surname + ":");
            phones.forEach(System.out::println);
        }
    }
}

