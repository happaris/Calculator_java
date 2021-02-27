package com.company;

public class MyFunction {
    public static boolean operate(char ch) //Проверям является ли символ оператором
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    public static boolean RomNumb(char ch) //Проверям является ли символ римской цифрой
    {
        return ch == 'I' || ch == 'V' || ch == 'X' || ch == 'L' || ch == 'C' || ch == 'D' || ch == 'M' || ch == 'N';
    }
    public static boolean ArabNumb(char ch) //Проверям является ли символ арабской цифрой
    {
        return ch >= '0' && ch <= '9';
    }
    public static int CharArrToInt(char[] arr) //Преобразуем массив чаров в интовое значение
    {
        int sum;
        int flag;
        int i;

        i = 0;
        sum = 0;
        if (arr[i] == '-')
        {
            flag = -1;
            i++;
        } else flag = 1;
        if (arr[i] == '+')
            i++;
        while (ArabNumb(arr[i]))
        {
            sum = sum * 10 + (arr[i] - '0');
            i++;
        }
        return sum * flag;
    }


    public static int valid(char[] arr) //Проверяем корректной введеного выражения
    {
        int i;
        byte numb1;
        byte numb2;
        boolean flagonemin;
        boolean operant;

        flagonemin = false;
        operant = false;
        i = 0;
        numb1 = 0;
        numb2 = 0;
        if (arr.length == 0)
            return 3;
        while (i < arr.length)
        {
            if (ArabNumb(arr[i]) || RomNumb(arr[i]) || operate(arr[i]) || arr[i] == ' ')
            {
                if (arr[i] == '+' && !flagonemin)
                    if (ArabNumb(arr[i + 1]) || RomNumb(arr[i + 1]))
                        i++;
                    else if (operate(arr[i + 1]))
                        return 1;
                    else return 0;
                if (arr[i] == '-' && numb1 == 0 && !flagonemin)
                {
                    if (ArabNumb(arr[i + 1]) || RomNumb(arr[i + 1])) {
                        i++;
                        flagonemin = true;
                    }else return 0;
                }
                if (ArabNumb(arr[i]) || RomNumb(arr[i]) || operate(arr[i]))
                {
                    if (ArabNumb(arr[i]) && numb1 == 0)
                    {
                        numb1 = 1;
                        while (ArabNumb(arr[i]) && i != arr.length - 1)
                                i++;
                        while (arr[i] == ' ')
                            i++;
                        if (arr[i] != ' ' && !operate(arr[i]))
                            return 0;
                    }
                    if (RomNumb(arr[i]) && numb1 == 0)
                    {
                        numb1 = 2;
                        while (RomNumb(arr[i]) && i != arr.length - 1)
                            i++;
                        while (arr[i] == ' ')
                            i++;
                        if (arr[i] != ' ' && !operate(arr[i]))
                            return 0;
                    }
                    if (operate(arr[i]))
                    {
                        if (!operant)
                            operant = true;
                        else return 1;
                    }
                    if (ArabNumb(arr[i]) || RomNumb(arr[i]))
                    {
                        if (ArabNumb(arr[i]))
                        {
                            numb2 = 1;
                            while (ArabNumb(arr[i]) && i < arr.length - 1)
                                i++;
                            while (arr[i] == ' ' && i < arr.length - 1)
                                i++;
                            if (arr.length - 1 > i || (arr[i - 1] == ' ' && ArabNumb(arr[i - 1])))
                                return 0;
                        }
                        if (RomNumb(arr[i]))
                        {
                            numb2 = 2;
                            while (RomNumb(arr[i]) && i < arr.length - 1)
                                i++;
                            while (arr[i] == ' ' && i < arr.length - 1)
                                i++;
                            if (arr.length - 1 > i || (arr[i - 1] == ' ' && RomNumb(arr[i - 1])))
                                return 0;
                        }
                    }
                }
            i++;
            }else return 0;
        }
        if (numb1 != numb2)
            return 2;
        if (operate(arr[i - 1]))
            return 1;
        else if (arr[i - 1] != ' ' && !ArabNumb(arr[i - 1]) && !RomNumb(arr[i - 1]))
            return 0;
        return 4;
    }
    public static void calculate(char[] arr){
        int i;
        int j;
        int k;
        char[] numb1 = new char[arr.length * 2];
        char[] numb2 = new char[arr.length * 2];
        char operant;

        i = 0;
        j = 0;
        k = 0;
        numb1[i] = '0';
        numb2[i] = '0';
        operant = '0';
        while (arr[i] == ' ')
            i++;
        while (i < arr.length)
        {
            if (arr[i] == ' ' && i != arr.length - 1)
                i++;
            if (arr[i] == '+' && j == 0)
                i++;
            if (arr[i] == '-' && j == 0)
            {
                numb1[j] = arr[i];
                j++;
                i++;
            }
            if ((ArabNumb(arr[i]) || RomNumb(arr[i])) && operant == '0')
            {
                numb1[j] = arr[i];
                j++;
            }else if ((RomNumb(arr[i]) || ArabNumb(arr[i])))
            {
                numb2[k] = arr[i];
                k++;
            }
            if (operate(arr[i]) && numb1[j - 1] != '-')
                operant = arr[i];
            i++;
        }
        if (RomNumb(numb1[0]))
        {
            if (RomanNumb.valid(numb1) && RomanNumb.valid(numb2))
                result(numb1, numb2, operant);
            else
            {
                System.out.println("Error 4:  Invalid roman values!");
            }
        }else result(numb1, numb2, operant);
    } //Находим числа и оператор в выражении

    public static void result(char[] numb1, char[] numb2, char operant) //Находим результат введеного выражения
    {
        int i;
        int n1;
        int n2;
        int sum;
        boolean flag;

        i = 0;
        sum = 0;
        if (numb1[i] == '-')
            i++;
        if (ArabNumb(numb1[i]))
        {
            n1 = CharArrToInt(numb1);
            n2 = CharArrToInt(numb2);
            flag = true;
        }else
        {
            n1 = RomanNumb.RomNubToInt(numb1);
            n2 = RomanNumb.RomNubToInt(numb2);
            flag = false;
        }
        switch (operant)
        {
            case '+':
                sum = n1 + n2;
                break;
            case '-':
                sum = n1 - n2;
                break;
            case '*':
                sum = n1 * n2;
                break;
            case '/':
                if (n2 != 0)
                    sum = n1 / n2;
        }
            if (operant == '/' && n2 == 0)
                System.out.println("Error 5: Division by zero!");
            else{
                System.out.print(numb1);
                System.out.print(operant);
                System.out.print(numb2);
                System.out.print('=');
                if (flag)
                    System.out.println(sum);
                else
                    try {
                        System.out.println(RomanNumb.IntToRomNub(sum));
                    }catch (ArrayIndexOutOfBoundsException exc) {
                        System.out.println("Warning! the result of the operation is too long, the classical result is displayed:");
                        System.out.print(numb1);
                        System.out.print(operant);
                        System.out.print(numb2);
                        System.out.print('=');
                        System.out.println(sum);
                    }
                if (sum >= 1147483648 || sum <= -1147483648 || n1 >= 1147483648 || n2 >= 1147483648 || n1 <= -1147483648 || n2 <= -1147483648)
                    System.out.print("Warning: Type overflow possible!\nThe decision may be incorrect.");
            }
    }
}
