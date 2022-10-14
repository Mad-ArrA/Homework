package Lesson3;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    public static final String tBlue = "\u001B[34m"; // Цвет текста синий
    public static final String tGreen = "\u001B[32m"; // Цвет текста зелёный
    public static final String tYellow = "\u001B[33m"; //Цвет текста жёлтый
    public static final String tPurple = "\033[0;95m"; // Цвет текста фиолетовый
    public static final String tReset = "\u001B[0m"; // Цвет default


    public static void main(String[] args){
        System.out.println("Лекция 3.");
        mainMenu();
        System.out.println("Завершение программы...");
    }
    public static boolean equal(String word1, String word2){
        int equalCount = 0;
        if(word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) == word2.charAt(i)) {
                    equalCount++;
                }
            }
        }
        if(equalCount == word1.length() && equalCount == word2.length()){
            return true;
        }else return false;
    }

    static String rndWord; //Статическая переменная нужна в классе, чтобы не ругался task2(); Смысл в том, что пользователь может спокойно играть в огородника, а после победы
    //Перейти в главное меню и сыграть снова. Да, можно сделать выбор - начать заново, но у меня сейчас завал на работе и по учёбе, не могу долго над задачей посидеть.
    static int answCount; // Это счётчик, чтобы показать, сколько было отгадано букв

    public static void mainMenu(){
        System.out.print("<МЕНЮ> Выберете номер задания от 1 до 2 (0 - выход): ");
        boolean isNum = in.hasNextInt(); //Сделал чисто для проверки знаний после лекции, было интересно попробовать
        if(isNum){ // hasNextInt не хотел делать, т.к. в свич-кейс в любом случае сработает дефолт и я попрошу ввести число заново
            int choiceMenu = in.nextInt();
            switch (choiceMenu){
                case(0): break;
                case(1):
                    System.out.println(tBlue + "=========================================================================");
                    System.out.println("|| Приветствую игрок! Сыграешь со мной?                                " +
                            "||\n|| Правила просты. Я загадал число от 0 до 9, а ты должен его отгадать.||\n|| Запомни, тебя всего ТРИ попытки! Удачи <3                           ||");
                    System.out.println("=========================================================================");
                    task1();
                    break;
                case(2):
                    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
                    int numW = rnd.nextInt(words.length); // Рандомный выбор слова программой по индексу в массиве
                    rndWord = words[numW];
                    System.out.println(tPurple + "===========================================================================");
                    System.out.println("Приветствую! Это викторина огородника!\n" +
                            "Я загадал название плода(на английском), твоя задача его отгадать. Удачи <3");
                    System.out.println("===========================================================================" + tReset);
                    task2();
                    break;
                default:
                    System.out.println("Неверное значение. Попробуйте ещё раз!"); mainMenu();
            }
        } else {
            System.out.println("Неверный ввод, попробуйте ещё раз...");
            in.nextLine(); //Очистка буфера от зацикливания
            mainMenu();}
    }
    public static void yesOrNo(){ //Метод для выбора в игре task1
        System.out.print("Повторить игру еще раз? 1 – да / 0 – нет: ");
        String choice = in.next();
        switch (choice){
            case("1"):
                task1();
                break;
            case("0"):
                mainMenu();
                break;
            default:
                System.out.println("-> Неверное значение. Попробуйте ещё раз!");
                yesOrNo();
        }
    }
    public static void task1(){
        int z = 2;
        for(int i=0; i<3; i++){
            int x = rnd.nextInt(10); //Генераниция случайного числа
            //int x = 2; //раскоментить, если нужно будет проверить результат победы(при этом закоментить строку выше)
            System.out.print(tGreen + "Твой ответ: " + tReset);
            int y = in.nextInt(); //Ответ пользователя
            if(x == y){
                System.out.println(tYellow + "--<! Поздравляю, ты победил! Хочешь снова испытать удачу? !>--" + tReset);
                yesOrNo();
            }
            else{
                int joke = rnd.nextInt(4);
                switch (joke){
                    case(0):
                        System.out.println(tBlue + "- К сожалению, ответ неверный ;( Осталось попыток: " + z + tReset);
                        break;
                    case(1):
                        System.out.println(tBlue + "- Неверно. Может в следующий раз повезёт... Осталось попыток: " + z + tReset);
                        break;
                    case(2):
                        System.out.println(tBlue + "- Не угадал... Но ты не сдавайся! :D Осталось попыток: " + z + tReset);
                        break;
                    case(3):
                        System.out.println(tBlue + "- Итааак... НЕВЕРНО! Не расстраивайся, попробуй ещё ;3 Осталось попыток: " + z + tReset);
                        break;
                }

            }
            z--;
        }
        System.out.println(tBlue + "\nПопытки закончились, ты проиграл... Хочешь попробовать снова?" + tReset); in.nextLine(); yesOrNo();
    }
    public static void task2(){
        System.out.print(tGreen + "Твой ответ: " + tReset);
        String response = in.next();
        int x;
        if(equal(response, rndWord)){ //Для работы switch нужно число, булиновское выражение он принимать не хотел. Равность через if проверить тоже нельзя было, поэтому
            //написал функцию для проверки на то, что слова равны, сравнил их по длине и посимвольно
            x = 1;
        } else x = 0;
        switch (x){ //Сначала хотел сделать через обычный if-else, но к сожалению я не знаю, есть ли hasNext для String значений.
            // Проверка на то что это !hasNextInt помогает только с цифрами, а на знаки так же ругается. Решил использовать case с его дефолтом на все случаи.
            case(1):
                System.out.println(tYellow + "Отличная игра! Это слово: " + rndWord + "\nЕщё увидимся, пока!" + tReset);
                mainMenu();
                break;
            case(0):
                System.out.println(tPurple + "Почти получилось, осталось отгадать ещё пару букв!" + tReset);
                System.out.print("Слово: ");
                int kostyl; //Наверное можно было бы и лучше написать, но не смог.
                // Костыль нужен для сравнения длинны слов, чтобы у меня цикл не выбивал ошибку выхода за границы массива
                if (response.length() > rndWord.length()) {
                    kostyl = rndWord.length();
                } else {
                    kostyl = response.length();
                }
                answCount = 0;
                    for(int i = 0; i < kostyl; i++){
                        if(rndWord.charAt(i) == response.charAt(i)){
                            System.out.print(rndWord.charAt(i));
                            answCount++;
                        }
                        else System.out.print("#");
                    }
                    for(int i = 0; i < 15-kostyl; i++){
                        System.out.print("#");
                    }
                System.out.print("\nБукв отгадано: " + answCount);
                System.out.println("\n=================================================");
                task2();
                break;
        }
    }
}
