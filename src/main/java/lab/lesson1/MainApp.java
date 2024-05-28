package lab.lesson1;
public class MainApp {
    public static void printThreeWords() {
        System.out.println("Задание1:");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a;
        int b;
        a = 128;
        System.out.println("Задание2:");
        System.out.println("a = " + a);
        b = 2;
        System.out.println("b = " + b);
        int sum = a + b;
        // Проверка суммы и вывод сообщения
        if (sum >= 0) {
            System.out.println("Сумма положительная = " + sum);
        } else {
            System.out.println("Сумма отрицательная = " + sum);
        }
    }

    public static void printColor() {
        System.out.println("Задание3:");
        int value = 0;

        if (value <= 0) {
            System.out.println("Красный ->" + value);
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый ->" + value);
        } else {
            System.out.println("Зеленый ->" + value);
        }
    }

    public static void compareNumbers() {
        int a;
        int b;
        a = 0;
        System.out.println("Задание4:");
        System.out.println("a = " + a);
        b = 555;
        System.out.println("b = " + b);
        int sum = a + b;
        // Проверка суммы и вывод сообщения
        if (a >= b) {
            System.out.println("a >= b");
        } else if (a < b) {
            System.out.println("a < b");
        }
    }

    public static void summNumbers() {
        int a;
        int b;
        a = 8;
        System.out.println("Задание5:");
        System.out.println("a = " + a);
        b = 7;
        System.out.println("b = " + b);
        int sum = a + b;
        // Проверка суммы и вывод сообщения
        if (sum >= 10 && sum <= 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void testNumbers() {
        int number;
        number = -1;
        System.out.println("Задание6:");
        if (number >= 0) {
            System.out.println("Число " + number + " положительное");
        } else {
            System.out.println("Число " + number + " отрицательное");
        }
    }

    public static void isNegative() {
        int number;
        number = 8;
        System.out.println("Задание7:");
        if (number >= 0) {
            System.out.println("Число положительное " + number + " false");
        } else {
            System.out.println("Число отрицательное " + number + " true");
        }
    }

    public static void printString() {
        String str;
        int count;
        count = 8;
        str = "Задание8";
        System.out.println("Всего строк " + count);
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static void whatYear() {
        int year;
        year = 4000;
        System.out.println("Задание9:");
        if (year % 400 == 0) {
            System.out.println(year + " Высокосный год");
        } else if (year % 4 == 0) {
            System.out.println(year + " Высокосный год");
        } else if (year % 100 == 0) {
            System.out.println(year + " Не высокосный год");
        } else {
            System.out.println(year + " Не высокосный год");
        }

    }

    public static void changeNumber() {
        System.out.println("Задание10:");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < 10; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        for (int i : array) {
            System.out.println(i + " " );
        }
    }

    public static void fillNumbers() {
        System.out.println( " Задание11:");
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        for (int i : array) {
            System.out.println(i + " " );
        }
    }


    public static void moreNumbers() {
        System.out.println( " Задание12:");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < 12; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        for (int i : array) {
            System.out.println(i + " ");
        }
    }
    public static void massivSquare() {
        System.out.println( " Задание13:");
        int n = 5;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] updatedArray(int len, int initialValue) {
        System.out.println( " Задание14:");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
    // Главный метод для запуска программы
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        summNumbers();
        testNumbers();
        isNegative();
        printString();
        whatYear();
        changeNumber();
        fillNumbers();
        moreNumbers();
        massivSquare();
        int[] resultArray = updatedArray(5, 3);
        for (int value : resultArray) {
            System.out.print(value + " ");
        }
    }
}
