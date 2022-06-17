package practice;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    TreeMap<String, String> treeMap = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (isNumber(phone) && isName(name)) {
            treeMap.put(phone, name);
        }
    }
    // проверьте корректность формата имени и телефона
    // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
    // если такой номер уже есть в списке, то перезаписать имя абонента


    public boolean isNumber(String number) {
        String regexNumber = "[\\d]+";
        Pattern pattern = Pattern.compile(regexNumber);
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isName(String name) {
        String regexName = "[\\D]+";
        Pattern pattern = Pattern.compile(regexName);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public String getContactByPhone(String phone) {
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            if (entry.getKey().equals(phone)) {
                return entry.getValue() + " - " + entry.getKey();
            }
        }
        return "";

        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
    }

    public Set<String> getContactByName(String name) {

        TreeSet<String> treeSet = new TreeSet<>();

        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            if (entry.getValue().equals(name)) {
                 treeSet.add(entry.getValue() + " - " + entry.getKey());
                for (String newSet : treeSet) {
                    System.out.println(newSet);
                }
            }
        }
        return treeSet;

        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
    }

    public Set<String> getAllContacts() {
        TreeSet<String> treeSet = new TreeSet<>();
        TreeMap<String, String> treeMap1 = new TreeMap<>();

        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (treeMap1.containsKey(value)) {
                for (Map.Entry<String, String> entry1 : treeMap1.entrySet()) {
                    if (entry1.getKey().equals(value)) {
                        treeMap1.put(entry1.getKey(), entry1.getValue() + ", " + key);
                    }
                }
            } else {
                treeMap1.put(value, key);
            }
        }
        for (Map.Entry<String, String> entry2 : treeMap1.entrySet()) {
            treeSet.add(entry2.getKey() + " - " + entry2.getValue());
        }

        return treeSet;

        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}