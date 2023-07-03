
/*Java: знакомство и как пользоваться базовым API (семинары)
Урок 4. Хранение и обработка данных ч1: приоритетные коллекции

Задание:
Организовать ввод и и хранение данных пользователей: ФИО; возраст и пол
Вывод - в формате: фамилия И.О.; возраст; пол.
Добавить возможность выхода или вывода списка отсортированного по возрасту!)
*реализовать сортировку по возрасту с использованием индексов
*реализовать сортировку по возрасту и полу с использованием индексов

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  30.06.2023
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Task_4 {
    private static ArrayList<String[]> people = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "utf-8");
        int choice;
        // меню
        do {
            System.out.println("Меню программы:");
            System.out.println("1. Ввод данных");
            System.out.println("2. Вывод данных по возрасту");
            System.out.println("3. Вывод данных по возрасту и полу");
            System.out.println("4. Вывод данных по фамилии");
            System.out.println("5. Выход");

            System.out.print("Ваш выбор: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addData(scanner);
                    break;
                case 2:
                    sortByAge();
                    printData();
                    break;
                case 3:
                    sortByAgeAndGender();
                    printData();
                    break;
                case 4:
                    sortByLastName();
                    printData();
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Некорректный выбор, попробуйте снова.");
                    break;
            }
        } while (choice != 5);
        scanner.close();
    }

    private static void addData(Scanner scanner) {

        System.out.print("Введите данные в формате: <фамилия;имя;отчество;возраст;пол(М/Ж)>. Выход - пустая строка: ");
        scanner.nextLine();
        String data = scanner.nextLine();

        String[] person = data.split(";");
        System.out.println(" ");
        people.add(person);
    }

    private static void sortByAge() { // сортировка по возрасту
        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = 0; j < people.size() - 1 - i; j++) {
                int age1 = Integer.parseInt(people.get(j)[3]);
                int age2 = Integer.parseInt(people.get(j + 1)[3]);
                if (age1 > age2) {
                    String[] temp = people.get(j);
                    people.set(j, people.get(j + 1));
                    people.set(j + 1, temp);
                }
            }
        }
    }

    private static void sortByAgeAndGender() { // сортировка по возрасту и полу
        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = 0; j < people.size() - 1 - i; j++) {
                int age1 = Integer.parseInt(people.get(j)[3]);
                int age2 = Integer.parseInt(people.get(j + 1)[3]);
                String gender1 = people.get(j)[4];
                String gender2 = people.get(j + 1)[4];
                if (age1 > age2 || (age1 == age2 && gender1.compareTo(gender2) > 0)) {
                    String[] temp = people.get(j);
                    people.set(j, people.get(j + 1));
                    people.set(j + 1, temp);
                }
            }
        }
    }

    private static void sortByLastName() { // сортировка по фио
        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = 0; j < people.size() - 1 - i; j++) {
                String lastName1 = people.get(j)[0];
                String lastName2 = people.get(j + 1)[0];
                if (lastName1.compareTo(lastName2) > 0) {
                    String[] temp = people.get(j);
                    people.set(j, people.get(j + 1));
                    people.set(j + 1, temp);
                }
            }
        }
    }

    private static void printData() { // вывод в консоль
        System.out.println("Данные:");
        for (String[] person : people) {
            String lastName = person[0];
            String initials = person[1].charAt(0) + "." + person[2].charAt(0) + ".";
            int age = Integer.parseInt(person[3]);
            String gender = person[4];
            System.out.println(lastName + "; " + initials + "; " + age + "; " + gender);
        }
    }
}

/*
 * Пример применения:
 * Меню программы:
 * 1. Ввод данных
 * 2. Вывод данных по возрасту
 * 3. Вывод данных по возрасту и полу
 * 4. Вывод данных по фамилии
 * 5. Выход
 * Ваш выбор: 1
 * Введите данные в формате <фамилия;имя;отчество;возраст;пол(М/Ж)>. Выход -
 * пустая строка: Иванов;Игорь;Павлович;35;М
 * 
 * Меню программы:
 * 1. Ввод данных
 * 2. Вывод данных по возрасту
 * 3. Вывод данных по возрасту и полу
 * 4. Вывод данных по фамилии
 * 5. Выход
 * Ваш выбор: 1
 * Введите данные в формате <фамилия;имя;отчество;возраст;пол(М/Ж)>. Выход -
 * пустая строка: Гончарова;Татьяна;Михайловна;42;Ж
 * 
 * Меню программы:
 * 1. Ввод данных
 * 2. Вывод данных по возрасту
 * 3. Вывод данных по возрасту и полу
 * 4. Вывод данных по фамилии
 * 5. Выход
 * Ваш выбор: 1
 * Введите данные в формате <фамилия;имя;отчество;возраст;пол(М/Ж)>. Выход -
 * пустая строка: Пузиков;Виталий;Семенович;39;М
 * 
 * Меню программы:
 * 1. Ввод данных
 * 2. Вывод данных по возрасту
 * 3. Вывод данных по возрасту и полу
 * 4. Вывод данных по фамилии
 * 5. Выход
 * 
 * Ваш выбор: 4
 * Данные:
 * Гончарова; Т.М.; 42; Ж
 * Иванов; И.П.; 35; М
 * Пузиков; В.С.; 39; М
 * 
 * Меню программы:
 * 1. Ввод данных
 * 2. Вывод данных по возрасту
 * 3. Вывод данных по возрасту и полу
 * 4. Вывод данных по фамилии
 * 5. Выход
 * Ваш выбор: 5
 * Выход из программы.
 */