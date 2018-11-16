package com.company;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Phonebook {

    public static void main(String[] args) {

        Map<String, String> Book = new HashMap<String, String>();

        Book.put("59-57-43", "Suzuki");

        Book.put("45-69-21", "Mercedes");

        Book.put("74-89-96", "Ford");

        Book.put("32-63-54", "Mitsubishi");

        for (;;) {
            System.out.println("Введите команду: Добавить (add), Найти (find), Удалить (del), Показать список (list), Выйти из программы (exit)");

            Scanner scan = new Scanner(System.in);
            String function = scan.nextLine();

//добавялет номер
            if (function.equals("add")) {
                System.out.println("Введите номер(dd-dd-dd):");
                Scanner scan1 = new Scanner(System.in);
                Pattern pattern1 = Pattern.compile("[0-9]{1,2}[-]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}");
                String number1 = scan1.nextLine();
                Matcher matcher1 = pattern1.matcher(number1);
                boolean value1 = matcher1.find();
                for ( ; value1 == false; ) {
                    System.out.println("Неверный ввод!");
                    System.out.println("Введите номер(dd-dd-dd):");
                    number1 = scan1.nextLine();
                    matcher1 = pattern1.matcher(number1);
                    value1 = matcher1.find();
                }

                System.out.println("Введите имя (Латинские буквы и символы, максимум 15):");
                Scanner scan2 = new Scanner(System.in);
                Pattern pattern2 = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9]{1,14}$");
                String name1 = scan2.nextLine();
                Matcher matcher2 = pattern2.matcher(name1);
                boolean value2 = matcher2.find();
                for ( ; value2 == false; ) {
                    System.out.println("Неверный ввод!");
                    System.out.println("Введите имя (Латинские буквы и символы, максимум 15):");
                    name1 = scan2.nextLine();
                    matcher2 = pattern2.matcher(name1);
                    value2 = matcher2.find();
                }
                Book.put(number1, name1);
                System.out.println("Номер добавлен!");
            }


//Ищет номер
            else if (function.equals("find")) {
                System.out.println("Введите номер(dd-dd-dd):");
                Scanner scan3 = new Scanner(System.in);
                Pattern pattern3 = Pattern.compile("[0-9]{1,2}[-]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}");
                String attempt = scan3.nextLine();
                Matcher matcher3 = pattern3.matcher(attempt);
                boolean value3 = matcher3.find();

                for ( ; value3 == false; ){
                    System.out.println("Неверный ввод!");
                    System.out.println("Введите номер(dd-dd-dd):");
                    attempt = scan3.nextLine();
                    matcher3 = pattern3.matcher(attempt);
                    value3 = matcher3.find();
                }
                String number2 = Book.get(attempt);
                System.out.println(number2);

            }

//Удаляет номер
            else if (function.equals("del")) {
                System.out.println("Введите номер(dd-dd-dd):");
                Scanner scan4 = new Scanner(System.in);
                Pattern pattern4 = Pattern.compile("[0-9]{1,2}[-]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}");
                String number3 = scan4.nextLine();
                Matcher matcher4 = pattern4.matcher(number3);
                boolean value4 = matcher4.find();
                for ( ; value4 == false; ) {
                    System.out.println("Неверный ввод!");
                    System.out.println("Введите номер(dd-dd-dd):");
                    number3 = scan4.nextLine();
                    matcher4 = pattern4.matcher(number3);
                    value4 = matcher4.find();
                }
                Book.remove(number3);
                System.out.println("Номер удалён!");
            }
//Выводит список
            else if (function.equals("list")) {

                for(Map.Entry<String, String> entry: Book.entrySet())
                    System.out.println(entry.getKey() + " - " + entry.getValue());

            }
//Закрывает програму
            else if (function.equals("exit")) {
                System.out.println("До свидания!");
                break;
            }

        }
    }
}