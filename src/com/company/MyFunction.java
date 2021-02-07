package com.company;

public class MyFunction {
    private static boolean operate(char ch) //Проверям является ли символ оператором
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    private static boolean RomNumb(char ch) //Проверям является ли символ римской цифрой
    {
        return ch == 'I' || ch == 'V' || ch == 'X' || ch == 'L' || ch == 'C' || ch == 'D' || ch == 'M' || ch == 'N';
    }
    private static boolean ArabNumb(char ch) //Проверям является ли символ арабской цифрой
    {
        return ch >= '0' && ch <= '9';
    }
    private static int CharArrToInt(char[] arr) //Преобразуем массив чаров в интовое значение
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
        }
            else flag = 1;
        while (ArabNumb(arr[i]))
        {
            sum = sum * 10 + (arr[i] - '0');
            i++;
        }
        return sum * flag;
    }
    private static int RomNubToInt(char[] str) //Преобразуем римское число в массиве в целое число
    {
        int i;
        int sum;
        int flag;

        flag = 1;
        i = 0;
        sum = 0;
        if (str[i] == '-')
            flag = -1;
        if (str[i] == 'N')
            return sum;
        while (str[i] != '\0')
        {
            if (str[i] == 'M')
                sum += 1000;
            if (str[i] == 'D')
                sum += 500;
            if (str[i] == 'C')
            {
                if (str[i + 1] == 'M')
                {
                    sum += 900;
                    i++;
                }else
                if (str[i + 1] == 'D')
                {
                    sum += 400;
                    i++;
                }else
                    sum += 100;
            }
            if (str[i] == 'L')
                sum += 50;
            if (str[i] == 'X')
            {
                if (str[i + 1] == 'C')
                {
                    sum += 90;
                    i++;
                }else
                if (str[i + 1] == 'L')
                {
                    sum += 40;
                    i++;
                }else
                    sum += 10;
            }
            if (str[i] == 'V')
            {
                if (str[i + 1] == 'I' && str[i + 2] != 'I')
                {
                    sum += 6;
                    i += 2;
                }else
                if (str[i + 1] == 'I' && str[i + 2] == 'I' && str[i + 3] != 'I')
                {
                    sum += 7;
                    i += 3;
                }else
                if (str[i + 1] == 'I' && str[i + 2] == 'I' && str[i + 3] == 'I')
                {
                    sum += 8;
                    i += 4;
                }else
                    sum += 5;
            }
            if (str[i] == 'I')
            {
                if (str[i + 1] == 'I' && str[i + 2] == '\0')
                {
                    sum += 2;
                    i += 2;
                }else
                if (str[i + 1] == 'I' && str[i + 2] == 'I')
                {
                    sum += 3;
                    i += 3;
                }else
                if (str[i + 1] == 'X')
                {
                    sum += 9;
                    i += 2;
                }else
                if (str[i + 1] == 'V')
                {
                    sum += 4;
                    i += 2;
                }else
                    sum += 1;
            }
            i++;
        }
        return sum * flag;
    }
    private static char[] IntToRomNub(int numb)  // Преобразуем целое число в римское
    {
        char[] sum= new char[10];
        int i;
        int k;

        i = 0;
        if (numb == 0) {
            sum[i] = 'N';
            return (sum);
        }
        if (numb < 0)
        {
            sum[i] = '-';
            numb *= -1;
            i++;
        }
        k = numb / 1000;
        while (k != 0) {
            sum[i] = 'M';
            k--;
            i++;
        }
        numb %= 1000;
        k = numb / 100;
        if (k == 9) {
            sum[i++] = 'C';
            sum[i++] = 'M';
            k -= 9;
        }
        if (k >= 5) {
            sum[i++] = 'D';
            k -= 5;
        }
        if (k == 4) {
            sum[i++] = 'C';
            sum[i++] = 'D';
            k -= 4;
        }
        while (k != 0) {
            sum[i] = 'C';
            k--;
            i++;
        }
        numb %= 100;
        k = numb / 10;
        if (k == 9) {
            sum[i++] = 'X';
            sum[i++] = 'C';
            k -= 9;
            numb -= 90;
        }
        if (k >= 5) {
            sum[i++] = 'L';
            k -= 5;
        }
        if (k == 4) {
            sum[i++] = 'X';
            sum[i++] = 'L';
            k -= 4;
        }
        while (k != 0) {
            sum[i] = 'X';
            k--;
            i++;
        }
        numb %= 10;
        if (numb == 1) {
            sum[i++] = 'I';
        }
        if (numb == 2) {
            sum[i++] = 'I';
            sum[i++] = 'I';
        }
        if (numb == 3) {
            sum[i++] = 'I';
            sum[i++] = 'I';
            sum[i++] = 'I';
        }
        if (numb == 4) {
            sum[i++] = 'I';
            sum[i++] = 'V';
        }
        if (numb == 5) {
            sum[i++] = 'V';
        }
        if (numb == 6) {
            sum[i++] = 'V';
            sum[i++] = 'I';
        }
        if (numb == 7) {
            sum[i++] = 'V';
            sum[i++] = 'I';
            sum[i++] = 'I';
        }
        if (numb == 8) {
            sum[i++] = 'V';
            sum[i++] = 'I';
            sum[i++] = 'I';
            sum[i++] = 'I';
        }
        if (numb == 9) {
            sum[i++] = 'I';
            sum[i++] = 'X';
        }
        sum[i] = '\0';
        return sum;
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
                        while (ArabNumb(arr[i]))
                            i++;
                        if (arr[i] != ' ' && !operate(arr[i]))
                            return 0;
                        while (arr[i] == ' ')
                            i++;
                        if (!operate(arr[i]))
                            return 0;
                    }
                    if (RomNumb(arr[i]) && numb1 == 0)
                    {
                        numb1 = 2;
                        while (RomNumb(arr[i]))
                            i++;
                        if (arr[i] != ' ' && !operate(arr[i]))
                            return 0;
                        while (arr[i] == ' ')
                            i++;
                        if (!operate(arr[i]))
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
                            if (arr.length - 1 > i || (arr[i - 1] == ' ' && ArabNumb(arr[i])))
                                return 0;
                        }
                        if (RomNumb(arr[i]))
                        {
                            numb2 = 2;
                            while (RomNumb(arr[i]) && i < arr.length - 1)
                                i++;
                            while (arr[i] == ' ' && i < arr.length - 1)
                                i++;
                            if (arr.length - 1 > i || (arr[i - 1] == ' ' && RomNumb(arr[i])))
                                return 0;
                        }
                    }
                }
            i++;
            }else return 0;
        }
        if (numb1 != numb2)
            return 2;
        return 4;
    }
    public static void calculate(char[] arr){
        int i;
        int j;
        int k;
        char[] numb1 = new char[arr.length];
        char[] numb2 = new char[arr.length];
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
        result(numb1, numb2, operant);
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
            n1 = RomNubToInt(numb1);
            n2 = RomNubToInt(numb2);
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
                if (n2 == 0)
                {
                    System.out.println("Error 5: Division by zero!");
                }else sum = n1 / n2;
        }

        //if (n1 <= 10 && n2 <= 10 && n1 >= 1 && n2 >= 1)
        //{
            System.out.print(numb1);
            System.out.print(operant);
            System.out.print(numb2);
            System.out.print('=');
            if (flag)
                System.out.print(sum);
            else
                System.out.print(IntToRomNub(sum));
        //}else
         //   System.out.println("Error 4: Invalid values!");
    }
}
