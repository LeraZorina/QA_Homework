import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("Метод №1");
        printThreeWords();
        System.out.println("\nМетод №2");
        checkSumSign();
        System.out.println("\nМетод №3");
        printColor();
        System.out.println("\nМетод №4");
        compareNumbers();
        System.out.println("\nМетод №5");
        System.out.println(sumWithin(5, 20));
        System.out.println("\nМетод №6");
        checkNumber(60);
        System.out.println("\nМетод №7");
        System.out.println(returnNumber(-15));
        System.out.println("\nМетод №8");
        printString("Тестировщик ПО", 4);
        System.out.println("\nМетод №9");
        System.out.println(whatYear(2100));
        System.out.println("\nМетод №10");
        arrayOne();
        System.out.println("\nМетод №11");
        arrayTwo();
        System.out.println("\nМетод №12");
        arrayThree();
        System.out.println("\nМетод №13");
        squareArray();
        System.out.println("\nМетод №14");
        newArray(6, 2);

    }

    static void printThreeWords() {

        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    static void checkSumSign() {
        int a = 20;
        int b = 16;
        var c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        int a = 15;
        int b = 50;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    static boolean sumWithin(int a, int b) {
        int c = a + b;
        return c >= 10 && c <= 20;
    }

    static void checkNumber(int num) {
        if (num >= 0) {
            System.out.println("Число " + num + " положительное");
        } else {
            System.out.println("Число " + num + " отрицательное ");
        }
    }

    static boolean returnNumber(int b) {
        return b < 0;
    }

    static void printString(String strPrint, int count) {

        for (int i = 0; i < count; i++) {
            System.out.println(strPrint);
        }
    }

    static boolean whatYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    static void arrayOne() {
        int[] arr = {1, 0, 0, 0, 1, 0, 1, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.println("arr[" + i + "]=" + arr[i]);
        }
    }

    static void arrayTwo() {
        int len = 100;
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void arrayThree() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void squareArray() {
        int len = 15;
        int[][] arr = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j || i == len - j - 1) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    static void newArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}


