package Lesson15;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Matrix20.
        // Дана матрица размера M × N. Для каждого столбца матрицы найти
        //произведение его элементов.
//        final int n = 4;
//        final int m = 5;
//        int[][] mas = new int[n][m];
//        fillMatrix(mas,2,10);
//        System.out.println(Arrays.deepToString(mas));
        //task20(mas);
        // Найти сумму элементов главной диагонали матрицы
        //System.out.println(taskL1(mas));
        final char xSymbol = 'X';
        final char oSymbol = 'O';
        final int size = 3;
        char[][] field = new char[size][size];
        //сделать пустое поле - заполнить его пробелами
        initField(field);
        printField(field);
        //игровой цикл
        //запросить куда ставить крестик
        //если координаты правильные - записать в поле
        //for(;;);

        //игровой цикл
        while (true){ //бесконечный цикл
        //ход крестиков
            turn(field,xSymbol);
            //вывести поле
            printField(field);
        //если победа крестиков - конец игры - прервать цикл
            if (checkWin(field,xSymbol)){
                System.out.println("ВЫИГРАЛИ КРЕСТИКИ!!!");
                //xWinMessage
                break;
            }
        //ничья - конец игры - прервать цикл
            if (checkDraw(field)){
                System.out.println("НИЧЬЯ!!!");
                break;
            }

        //ход ноликов
            turn(field,oSymbol);
            //вывести поли
            printField(field);
        //если победа ноликов - конец игры - прервать цикл
            if (checkWin(field,oSymbol)){
                System.out.println("ВЫИГРАЛИ НОЛИКИ!!!");
                //xWinMessage
                break;
            }
        //ничья - конец игры - прервать цикл
            if (checkDraw(field)){
                System.out.println("НИЧЬЯ!!!");
                break;
            }
    }


    }

    static boolean checkDraw(char[][] field){
        boolean result = true;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == ' '){
                    result =false;
                    break;
                }
            }
        }
        return result;
    }

    static boolean checkWin(char[][] field, char symbol) {
        boolean result = false;
        // если в любой строке три одинаковых символа
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == field[i][1]&&field[i][1]==field[i][2]&&field[i][2]==symbol) {
                result = true;
                break;
            }
        }
        // если в любом столбе три одинаковых символа
        for (int j = 0; j < field[0].length; j++) { // field[0].length берёт длинну столбица
            if (field[0][j] == field[1][j]&&field[1][j]==field[2][j]&&field[2][j]==symbol) {
                result = true;
                break;
            }
        }
        //если на главной диагонали три одинаковых символа
        if (field[0][0] == field[1][1]&&field[1][1]==field[2][2]&&field[2][2]==symbol)
            result = true;
        //если на побочной диагонали три одинаковых символа
        else if (field[2][0] == field[1][1]&&field[1][1]==field[0][2]&&field[1][1]==symbol)
            result = true;

        return result;
    }

    static void turn(char[][] field, char symbol) {
        Scanner in = new Scanner(System.in);
        int row = 0;
        int column = 0;
        do{
            System.out.print("Введите номер строки: ");
            row = in.nextInt();
            System.out.print("Введите номер столбица: ");
            column = in.nextInt();
        }while(row<0||row>2||column<0||column>2||field[row][column]!=' ');
        field[row][column] = symbol;
    }

    static void printField(char[][] field){
        //повторили для всех строк
        for(int i=0;i< field.length;i++) {
            //напечатали строку-разделитель поля
            printLineSeparator();
            //напечатали одну строку поля
            for (int j = 0; j < field[i].length; j++) {
                System.out.print("| " + field[i][j] + " ");
            }
            System.out.println('|');
        }
        //напечатали строку-разделитель поля
        printLineSeparator();
    }

    static void printLineSeparator(){
        for (int k = 0; k < 3; k++) {
            System.out.print("|---");
        }
        System.out.println('|');
    }

    static void initField(char[][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j]=' ';
            }
        }
    }

    static int taskL1(int[][] fmas){
        int sum=0;
        for (int a = 0; a < fmas.length; a++) {
            sum+=fmas[a][a];
        }
        return sum;
    }

    //Функция под 20 матрикс
    static void task20(int[][] fmas){
        for (int k = 0; k < fmas[0].length; k++) {
            int p=1;
            for (int i = 0; i < fmas.length; i++) {
                p*=fmas[i][k];
        }
        System.out.println(p);
        }
    }

    //функция которая заполняет двумерный массив!!! (меняет матрицу (ничего не возвращает) )
    static void fillMatrix(int[][] arr, int left, int right){
        Random gen = new Random();
        for (int i = 0; i < arr.length; i++) {    //arr.lenght перебирает количество строк в матрице
            for (int j = 0; j < arr[i].length; j++) {   //arr[i].lenght кол-во столбцов в строке
                arr[i][j] = gen.nextInt(right-left+1)+left;
            }
        }
    }


}
