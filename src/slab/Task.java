package slab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Task implements IConst {

    public static void main(String[] args) throws maxArrayCountException, maxNumber {
        //создане списка для чётных чисел
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] mylist = input.split(" ");
        Bob bob = new Bob();
        try {
            ArrayList<Integer> myar = bob.convertToIntegerList(mylist);
            Collections.sort(myar);
            System.out.println(myar);//вывод  списка
        } catch (maxArrayCountException|maxNumber|MyNumberFormatException e) {
            System.out.println(e);
       }
    }
}
