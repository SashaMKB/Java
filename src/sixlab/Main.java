package sixlab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        int number_of_friends = scan1.nextInt();
        List<Integer> all_numbers = new ArrayList<>();
        for (int i = 0; i < number_of_friends; i++) {
            Scanner scan = new Scanner(System.in);
            String  input = scan.nextLine();
            String[] str = input.split(" ");
            for (String x: str) {
                all_numbers.add(Integer.parseInt(x));
            }
        }
        List<Integer> final_numbers = new ArrayList<>();
        int number = 0;
        for (int i = 0; i < all_numbers.size(); i++) {
            for (int j = i + 6; j < all_numbers.size(); j++) {
                number = all_numbers.get(i) +  all_numbers.get(j);
                if(!all_numbers.contains(number)) {
                    final_numbers.add(number);
                }
            }
        }
        System.out.println(final_numbers.size());
    }
}
