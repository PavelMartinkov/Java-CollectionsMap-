package practice;
import java.util.Scanner;

public class Main {

    public static final String WRONG_NAME = "Неверный формат имени";
    public static final String WRONG_NUMBER = "Неверный формат номера";

    private static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер, имя или команду:");
        String LIST = "LIST";
        while (true) {
            String input = scanner.nextLine();
            if (input.contains(LIST)) {
                for (String contacts : phoneBook.getAllContacts()) {
                    System.out.println(contacts);
                }
            }

            else if (phoneBook.isName(input)) {
                if (phoneBook.getContactByName(input).contains(input)) {
                    System.out.println(phoneBook.getContactByName(input));
                }
                else if (phoneBook.getContactByName(input).isEmpty()) {
                    System.out.println("Такого имени в телефонной книге нет." + "\n" + "Введите номер телефона для абонента:" + input);
                    String input1 = scanner.nextLine();
                    if (phoneBook.isNumber(input1)) {
                        phoneBook.addContact(input1,input);
                        System.out.println("Контакт сохранен!");
                    } else if (input1.isEmpty()) {
                        System.out.println(WRONG_NAME);
                    }
                }
            }

            else if (phoneBook.isNumber(input)) {
                if (phoneBook.getContactByPhone(input).contains(input)) {
                    System.out.println(phoneBook.getContactByPhone(input));
                }
                else if (phoneBook.getContactByPhone(input).isEmpty()) {
                    System.out.println("Такого номера нет в телефонной книге." + "\n" + "Введите имя абонента для номера: " + input);
                    String input2 = scanner.nextLine();
                    if (phoneBook.isName(input2)) {
                        phoneBook.addContact(input,input2);
                        System.out.println("Контакт сохранен!");
                    } else if (input2.isEmpty()) {
                        System.out.println(WRONG_NUMBER);
                    }
                }
            }
        }
    }
}