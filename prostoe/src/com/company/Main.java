package com.company;

public class Main
{
    public static void main(String[] args)
    {
        for(int i = 2; i<=100; i++)//проходим по всей сотне
            if(isPrime(i)) //проверяем, является ли число простым, если да, то выводим
            {
                System.out.print(i);
                System.out.print(' ');
            }
    }
    public static boolean isPrime(int a)//метод для проверки, если есть хотя бы один делитель, то возвращаем false, иначе true
    {
        for(int i=2; i<a; i++)//проходим по всем числам меньше проверяемого числа
            if(a%i==0) return false;
        return true;
    }
}

