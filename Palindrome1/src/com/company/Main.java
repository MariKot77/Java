package com.company;
import java.util.Scanner;//подключаем класс сканера для получения информации от пользователя

public class Main
{
    public static void main(String[] args)
    {
        String st="";//создаем переменную для записи отдельных слов, записывем пустую строку
        char wd;//создаем переменную для записи отдельных букв
        Scanner in = new Scanner(System.in);//создаем переменную типа Scanner для использования методов класса
        System.out.println("Введите слова одной строкой через пробел");//получаем информацию от пользователя
        String s = in.nextLine();//считываем всю строку
        if(s.length() != 0)//если в строке есть символы, то
        {
            //проходим по всем символам, записывая в переменную wd целые слова (до пробела)
            for (int i = 0; i < s.length(); i++)
            {
                wd = s.charAt(i);
                if (wd == ' ')//если символ является пробелом (слово закончилось)
                {
                    System.out.println(st);//выводим его
                    if(isPalindrom(st))//проверяем является ли слово полиндромом
                        System.out.println('T');//если да, то пишем true
                    else
                        System.out.println('F');//иначе false
                    st = "";//очищаем переменную со словом
                }
                else//если символ не пробел, то добавляем его к остальным буквам слова
                    st+=wd;
            }
            //так как после последнего слова пробела нет, его нужно проверить отдельно
            System.out.println(st);
            if(isPalindrom(st))
                System.out.println('T');
            else
                System.out.println('F');
        }
    }

    public static String reverseString(String s)//метод для переворачивания слова
    {
        String up="";//создаем переменную для записи перевернутого слова
        for(int i=s.length()-1; i>=0; i--)//находим количество букв в слове
            up+=s.charAt(i);//записываем буквы с конца
        return (up);
    }

    public static boolean isPalindrom(String s)//метод для проверки слова как палиндрома
    {
        return s.equals(reverseString(s));//возвращаем результат сравнение слова и результата переворачивающего метода
    }
}


