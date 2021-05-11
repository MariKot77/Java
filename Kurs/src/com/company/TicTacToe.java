package com.company;
import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    final char SIGN_X = 'X';
    final char SIGN_O = 'O';
    final char SIGN_EMPTY = '*';
    char[][] display;
    Random random;
    Scanner scanner;

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    // конструктор: инициализация полей
    TicTacToe() {
        random = new Random();
        scanner = new Scanner(System.in);
        display = new char[5][5];
    }

    // игровая логика
    //Идет цикл: ход человека -> проверка(если победа или ничья, то выходим из цикла), ход компа -> проверка(если победа или ничья, то выходим из цикла)
    void game() {
        initTable();
        while (true) {
            turnHuman();
            if (checkWin(SIGN_X)) {
                System.out.println("Ты выиграл!");
                break;
            }
            if (TableFull()) {
                System.out.println("Проиграл(((");
                break;
            }
            turnAI();
            printTable();
            if (checkWin(SIGN_O)) {
                System.out.println("Выиграл комп!");
                break;
            }
            if (TableFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
        printTable();
    }

    // метод обеспечивает начальную инициализацию игровой таблицы, заполняя её ячейки «пустыми» символами
    void initTable() {
        for (int row = 0; row < 5; row++)
            for (int col = 0; col < 5; col++)
                display[row][col] = SIGN_EMPTY;
    }

    //метод показывает текущее состояние таблицы
    void printTable() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++)
                System.out.print(display[row][col] + " ");
            System.out.println();
        }
    }

    //ход человека
    void turnHuman() {
        int x, y;
        do {
            System.out.println("Введите координаты вашего хода(1..5)(столбик, строчка)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!checkBox(x, y));
        display[y][x] = SIGN_X;
    }

    //проверка ячейки, чтоб была не занята и входила в нашу таблицу 5х5
    boolean checkBox(int x, int y) {
        if (x < 0 || y < 0 || x >= 5|| y >= 5)
            return false;
        return display[y][x] == SIGN_EMPTY;
    }

    //метод, для "хода" компьютера с проверкой
    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(5);
            y = random.nextInt(5);
        } while (!checkBox(x, y));
        display[y][x] = SIGN_O;
    }

    //метод проверки на победы в пять подряд по горизонтали, вертикали или диагонали
    boolean checkWin(char dot) {
        for (int i = 0; i < 5; i++)
            if ((display[i][0] == dot && display[i][1] == dot &&
                    display[i][2] == dot && display[i][3] == dot && display[i][4] == dot) ||
                    (display[0][i] == dot && display[1][i] == dot &&
                            display[2][i] == dot && display[3][i] == dot && display[4][i] == dot))
                return true;
        if ((display[0][0] == dot && display[1][1] == dot &&
                display[2][2] == dot && display[3][3] == dot && display[4][4] == dot) ||
                (display[4][0] == dot && display[3][1] == dot &&
                        display[2][2] == dot&& display[1][3] == dot && display[0][4] == dot))
            return true;
        return false;
    }

    //метод проверки ничьи, пока не закончились пустые клетки играем
    boolean TableFull() {
        for (int row = 0; row < 5; row++)
            for (int col = 0; col < 5; col++)
                if (display[row][col] == SIGN_EMPTY)
                    return false;
        return true;
    }
}