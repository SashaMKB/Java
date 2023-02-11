package slab;

import java.util.ArrayList;

public class Bob implements IFunc, IConst {

    public ArrayList<Integer> convertToIntegerList(String[] mylist) throws maxNumber,maxArrayCountException,MyNumberFormatException {
        ArrayList<Integer> al = new ArrayList<>();
        if (mylist.length < maxArrayCount) throw new maxArrayCountException();
        else {
            for (String x : mylist) {//Вывод всех заданных параметров командной строки
                /* преобразвание строки, хранящейся в переменной "х" в целое число и добавление в список */
                if (x.contains("0")) throw new MyNumberFormatException();
                if (Integer.parseInt(x) > maxValue) throw new maxNumber();
                al.add(Integer.parseInt(x));//добавление в список чётно
            }
            return al;
        }
    }
}