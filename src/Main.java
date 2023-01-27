import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    final static int CURRENT_YEAR = LocalDate.now().getYear();

    public static void main(String[] args) {

        task1();
        task2();
        task3();
    }

    private static void task3() {
        System.out.println("Задание 3:");
        System.out.println(getDeliveryDaysByDistance(getRandomNumberInRange(0, 150)));
        System.out.println();
    }

    private static void task2() {
        System.out.println("Задание 2:");
        System.out.println(getAppVersionMessage());
        System.out.println();
    }

    private static void task1() {
        System.out.println("Задание 1:");
        System.out.println("Проверка на високостность");
        System.out.println(checkLeapYear(inputCheckNumberInRange(1500, 2500)));
        System.out.println();
    }

    private static String getDeliveryDaysByDistance(int deliveryDistance) {
        int noDays = 1;

        if (deliveryDistance > 100)
            return ("Доставки нет");
        if (deliveryDistance > 20)
            noDays++;
        if (deliveryDistance > 60)
            noDays++;

        return ("Потребуется дней: " + noDays);
    }


    private static String checkLeapYear(int year) {

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return (year + " год ялвяется высокосным.");
        else
            return (year + " год не ялвяется высокосным.");
    }

    private static int inputCheckNumberInRange(int min, int max) {
        System.out.println("Введите год от " + min + " до " + max);
        int number;

        while (true) {
            Scanner myInput = new Scanner(System.in);
            if (!myInput.hasNextInt()) {
                System.out.println("Введите число!");
                continue;
            }

            number = myInput.nextInt();

            if (number > min && number <= max)
                break;
            else
                System.out.println("Введите поравильное значение!");
        }
        return number;
    }

    private static String getAppVersionMessage() {

        String clientOS = checkOSInput("iOS", "Android");
        System.out.println("Год произвосдства вашего аппрата");
        int clientDeviceYear = inputCheckNumberInRange(2007, CURRENT_YEAR);

        if (clientOS.equalsIgnoreCase("iOS")) {
            if (clientDeviceYear < CURRENT_YEAR)
                return("Установите облегченную версию приложения для iOS по ссылке");
            else
                return("Установите версию приложения для iOS по ссылке");
        }
        if (clientOS.equalsIgnoreCase("Android")) {
            if (clientDeviceYear < CURRENT_YEAR)
                return("Установите облегченную версию приложения для Android по ссылке");
            else
                return("Установите версию приложения для Android по ссылке");
        }

       return ("Error");
    }

    private static String checkOSInput(String one, String two) {
        System.out.println("Введите называниие вашей операционной системы " + one + " или " + two);
        String typeOS;

        while (true) {
            Scanner myInput = new Scanner(System.in);
            if (!myInput.hasNextLine()) {
                System.out.println("Введите название!");
                continue;
            }

            typeOS = myInput.next();

            if (typeOS.equalsIgnoreCase(one) || typeOS.equalsIgnoreCase(two))
                break;
            else
                System.out.println("Введите поравильное значение!");
        }
        return typeOS;
    }

    private static int getRandomNumberInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}