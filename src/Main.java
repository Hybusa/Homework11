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
        getDeliveryDaysByDistance(getRandomNumberInRange(0, 150));
    }

    private static void getDeliveryDaysByDistance(int deliveryDistance) {
        int noDays = 1;

        if (deliveryDistance > 100) {
            System.out.println("Доставки нет");
            return;
        }
        if (deliveryDistance > 20)
            noDays++;
        if (deliveryDistance > 60)
            noDays++;

        System.out.println("Потребуется дней: " + noDays);

        System.out.println();
    }

    private static void task2() {
        System.out.println("Задание 2:");
        getAppVersionMessage();
    }

    private static void task1() {
        System.out.println("Задание 1:");
        System.out.println("Проверка на високостность");
        checkLeapYear(inputCheckNumberInRange(1500, 2500));
    }


    public static void checkLeapYear(int year) {


        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            System.out.println(year + " год ялвяется высокосным.");
        else
            System.out.println(year + " год не ялвяется высокосным.");

        System.out.println();
    }

    public static int inputCheckNumberInRange(int min, int max) {
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

    public static void getAppVersionMessage() {

        String clientOS = checkOSInput("iOS", "Android");
        System.out.println("Год произвосдства вашего аппрата");
        int clientDeviceYear = inputCheckNumberInRange(2007, LocalDate.now().getYear());

        if (clientOS.equalsIgnoreCase("iOS")) {
            if (clientDeviceYear < CURRENT_YEAR)
                System.out.println("Установите облегченную версию приложения для iOS по ссылке");
            else
                System.out.println("Установите версию приложения для iOS по ссылке");
        }
        if (clientOS.equalsIgnoreCase("Android")) {
            if (clientDeviceYear < CURRENT_YEAR)
                System.out.println("Установите облегченную версию приложения для Android по ссылке");
            else
                System.out.println("Установите версию приложения для Android по ссылке");
        }

        System.out.println();
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

    public static int getRandomNumberInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}