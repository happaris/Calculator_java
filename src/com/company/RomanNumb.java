package com.company;

public class RomanNumb {
    private static int prior(char c)
    {

        if (c == 'I')
            return 1;
        if (c == 'V')
            return 2;
        if (c == 'X')
            return 3;
        if (c == 'L')
            return 4;
        if (c == 'C')
            return 5;
        if (c == 'D')
            return 6;
        if (c == 'M')
            return 7;
        return 0;
    }
    public  static boolean valid(char[] arr)
    {
        int k;
        int i;
        boolean flag;

        flag = false;
        i = 1;
        k = 1;
        while (arr[i] != '\0')
        {
            if (arr[i] == 'N')
                flag = true;
            if (prior(arr[i]) < prior(arr[i - 1]))
            {
                i++;
                k = 0;
            }
            else if ((prior(arr[i]) == prior(arr[i - 1])) && k < 3)
            {
                i++;
                k++;
            }else
            {
                if (arr[i - 1] == 'I' && (arr[i] == 'V' || arr[i] == 'X'))
                    i += 2;
                else if (arr[i - 1] == 'X' && (arr[i] == 'L' || arr[i] == 'C'))
                    i += 2;
                else if (arr[i - 1] == 'C' && (arr[i] == 'D' || arr[i] == 'M'))
                    i += 2;
                else return false;
            }
        }
        return !flag || i <= 1;
    }
    public static char[] IntToRomNub(int numb)  // Преобразуем целое число в римское
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
    public static int RomNubToInt(char[] str) //Преобразуем римское число в массиве в целое число
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
                if (str[i + 1] == 'I' && str[i + 2] != 'I')
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

}
