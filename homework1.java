package ru.geekbrains.homework1;

public class homework1 {
    public static void main(String[] args){
        /**
         * Задание 2
         */
        int var1_1 = 2147483647;
        short var1_2 = 32767;
        double var1_3 = 310.17052325 ;
        float var1_4 = 310.123312318f;
        long var1_5 = 9223372036854775807L;
        boolean var1_6 = false;
        boolean var1_7 = true;
        char var1_8 = 50;
        String var1_9 = "Hello";

        //Задание 3
        float var3_1 = 12.225f;
        float var3_2 = 52.759f;
        float var3_3 = 36.789f;
        float var3_4 = 3.489f;
        float sum = task3(var3_1, var3_2, var3_3, var3_4);
        System.out.println("Задание 3");
        System.out.printf("Результат выражения: %.3f * (%.3f + (%.3f / %.3f)) = %.3f\n\n", var3_1, var3_2, var3_3, var3_4, sum);

        //Задание 4
        int var4_1 = 13;
        int var4_2 = 3;
        boolean sum4 = task4(var4_1, var4_2);
        System.out.println("Задание 4");
        System.out.println("Результат выражения: " + sum4 + "\n");

        //Задание 5
        int var5_1 = 0;
        isPosOrNeg(var5_1);

        //Задание 6
        int var6_1 = 0;
        boolean check = isPosOrNegNext(var6_1);
        System.out.println("Задание 6");
        System.out.println("Результат проверки: " + check + "\n");

        //Задание 7
        String name = "Аркадий!";
        nameString(name);

        //Задание 8
        int var8_1 = 2000;
        year(var8_1);
    }

    /**
     * Задание 3.
     * @param a Первое число
     * @param b Второе число
     * @param c Третье число
     * @param d Четвёртое число
     * @return Результат
     */
    static float task3(float a, float b, float c, float d){
        float result = a * (b + (c / d));
        return result;
    }

    /**
     * Задание 4
     * @param var4_1 Первое число
     * @param var4_2 Второе число
     * @return Результат сравнения
     */
    static boolean task4(int var4_1, int var4_2) {
        int sum4 = var4_1 + var4_2;
        if (sum4 > 10 && sum4 <= 20) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Задание 5
     * @param var5_1 Сравнение числа
     */
    public static void isPosOrNeg(int var5_1) {
        System.out.println("Задание 5");
        if(var5_1 >= 0) {
            System.out.println("Число положительное\n");
        } else {
            System.out.println("Число отрицательное\n");
        }
    }

    /**
     * Задание 6
     * @param var6_1 Сравнение числа
     * @return Результат проверки
     */
    public static boolean isPosOrNegNext(int var6_1) {
        if(var6_1 >= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Задание 7
     * @param name Строка
     */
    public static void nameString(String name) {
        System.out.println("Задание 7");
        System.out.println("Привет, " + name + "\n");
    }

    /**
     * Задание 8 *
     * @param var8_1 Проверка високосного года
     */
    public static void year(int var8_1) {
        System.out.println("Задание 8 *");
        if((var8_1 % 4 == 0 && var8_1 % 100 != 0) || (var8_1 % 400 == 0)) {
            System.out.println("Високосный год");
        }
        else {
            System.out.println("Невисокосный год");
        }
    }
}


