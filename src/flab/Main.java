package flab;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();//создане списка для чётных чисел
        for (String x : args) {//Вывод всех заданных параметров командной строки
            /* преобразвание строки, хранящейся в переменной "х" в целое число и добавление в список */
            al.add((Integer.parseInt(x)));//добавление в список чётно
        }
        Collections.sort(al);
        System.out.println(al);//вывод  списка
    }
}