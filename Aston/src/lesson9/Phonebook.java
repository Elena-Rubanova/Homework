package lesson9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private final Map<String, List<String>> phonebook = new HashMap<>();

    public void add(String surname, String number) {
        List<String> phones = phonebook.getOrDefault(surname, new ArrayList<>());
        phones.add(number);
        phonebook.put(surname, phones);
    }

    public List<String> get(String surname) {
        return phonebook.getOrDefault(surname, new ArrayList<>());
    }
}







