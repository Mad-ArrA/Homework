package Lesson2;
import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.print("Лекция 2:");
        CircleChoice();
        System.out.println("\nЗавершение работы программы . . .");
    }

    /**
     * Ф-ция для множественного выбора заданий
     */
    public static void CircleChoice(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите номер задания от 1 до 7 (номер 0 для выхода): ");
        int taskNumber = in.nextInt();
        switch (taskNumber){
            case(0): break;
            case(1): answ(1); task1(); CircleChoice(); break;
            case(2): answ(2); task2(); CircleChoice(); break;
            case(3): answ(3); task3(); CircleChoice(); break;
            case(4): answ(4); task4(); CircleChoice(); break;
            case(5): answ(5); task5(); CircleChoice(); break;
            case(6): answ(6);
                int[] arr = {2, 2, 2, 1, 2, 2, 10, 1};
                System.out.println(task6(arr));
                CircleChoice();
                break;
            case(7): answ(7);
                System.out.print("Введите величину смещения чисел массива\n" +
                        "(положительное число сместит - вправо, отрицательное - влево): ");
                int n = in.nextInt();
                task7(inputArr(),n);
                CircleChoice();
                break;
            default:
                System.out.print("Номер задания не найден. Попробуйте ещё раз . . .\n\n");
                CircleChoice();
                break;
        }
    }
    /**
     * Ф-ция вывода номера задания
     * @param x - номер задания
     */
    public static void answ(int x){
        System.out.print("Задание: " + x + ": \n");
    }

    /**
     * Создание массива пользователем
     * @return Выводит созданный массив
     */
    public static int[] inputArr(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int x = in.nextInt();
        System.out.print("Введите элементы массива через пробел: ");
        int[] arr = new int[x];
        for(int i = 0; i<x; i++){
            arr[i] = in.nextInt();
        }
        System.out.print("Ваш массив: [ ");
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.print("]");
        return arr;
    }

    /**
     * Создание массива рандомных чисел в диапазоне от -100 до 100
     * @param x - количество элементов массива
     * @return Выводит созданный массив
     */
    public static int[] randArr(int x){
        int[] arr = new int[x];
        for(int i = 0; i<arr.length; i++){
            arr[i] = (int) (Math.random()*(200+1)) - 100;
        }
        return arr;
    }

    //Задание 1
    public static void task1(){
        System.out.print("[ ");
        int[] mass = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for(int i = 0; i<mass.length; i++){
            if (mass[i] == 0) mass[i] = 1;
            else mass[i] = 0;
            System.out.print(mass[i] + ", ");
        }
        System.out.print("]");
    }

    //Задание 2
    public static void task2(){

        System.out.print("[ ");
        int[] mass = new int[8];
        int z = 0;
        for(int i = 0; i<mass.length; i++) {
        mass[i] = z;
        z=z+3;
        System.out.print(mass[i] + ", ");
        }
        System.out.print("]");
    }

    //Задание 3
    public static void task3(){

        System.out.print("[ ");
        int[] mass = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i<mass.length; i++){
            if(mass[i]<6) mass[i]*=2;
            System.out.print(mass[i] + ", ");
        }
        System.out.print("]");
    }

    //Задание 4
    public static void task4(){

        int[][] mass = new int[5][5];
        for(int i = 0; i<mass.length; i++){
           System.out.println();
            for(int z = 0; z<mass.length; z++){
                if(z == i) mass[i][z]=1;
                System.out.print(mass[i][z] + "\t");
            }
        }
    }

    //Задание 5
    public static void task5(){
        int[]mass = new int[10];
        System.out.print("Заданнный массив: [");
        for(int i = 0; i<mass.length; i++){
            mass[i] = (int) (Math.random()*(200+1)) - 100;
            System.out.print(mass[i] + ", ");
        }
        System.out.print("]\n");
        int min = mass[0];
        int max = mass[0];
        for(int i = 0; i<mass.length; i++){
            if(min>mass[i]) min = mass[i];
            if(max<mass[i]) max = mass[i];
        }
        System.out.println("Максимальное значение = " + max
                + "\nМинимальное значение = " + min);
    }

    //Задание 6
    public static boolean task6(int[] arr){
        boolean ans = false;
        for(int i = 0; i<arr.length; i++){ //Цикл проверки всех вариантов
            int sumLeft = 0;
            int sumRight = 0;
            int edge = 0; // граница между элементами равных сумм правой и левой части
            for(int y = 0; y<i+1; y++){ //Цикл суммирования левой части
                sumLeft+=arr[y];
                edge = y+1;
            }
            for(int z = i+1; z<arr.length; z++){ //Цикл суммирования правой части
                sumRight+=arr[z];
            }
            if(sumLeft == sumRight) { //Условие проверки равновесия суммы правой и левой частей
                for(int j = 0; j<arr.length; j++){
                    if(j==edge) System.out.print("|| ");
                    System.out.print(arr[j] + ", ");
                }
                System.out.printf("\nСумма: Слева = %d Справа = %d", sumLeft,sumRight);
                System.out.print("\nРезультат: ");
                ans = true;}
        }
        return ans;
    }

    //Задание 7
    public static void task7(int[] arr, int n){
        if(n<0){
            n*=-1; //n в моём случае - это количество единичных смещений в сторону,
            // для цикла сделал n положительным
        for(int u = 0; u<n; u++) { //Цикл смещения влево
            int x = arr[0];
            int z = arr.length - 1;
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[z] = x;
        }
        } else {
        for(int p = 0; p<n; p++){ //Цикл смещения вправо
            int x = arr[arr.length-1];
            for (int i = arr.length-1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = x;
            }
        }
        System.out.print("\nРезультат работы: [ ");
        for(int r = 0; r<arr.length; r++){ //Вывод результирующего массива
            System.out.print(arr[r] + ", ");
        }
        System.out.print("]");
    }
}
