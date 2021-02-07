//Простой калькулятор для арабских и римских цифр на джава, справка по работе программы в README.txt
package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] array;
        String str;

        Scanner scan = new Scanner(System.in);
        System.out.println("Type an expression:");
        str = scan.nextLine();
        array = str.toCharArray();
        switch (MyFunction.valid(array)){
            case 0:
                System.out.println("Error 0:  Incorrect expression!");
                break;
            case 1:
                System.out.println("Error 1:  Check the signs!");
                break;
            case 2:
                System.out.println("Error 2:  Invalid values!");
                break;
            case 3:
                System.out.println("Error 3:  Empty Expression!");
                break;
            case 4:
                MyFunction.calculate(array);
        }
    }
}
