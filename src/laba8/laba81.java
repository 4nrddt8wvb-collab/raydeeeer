package laba8;
import java.io.*;
import java.util.*;

public class laba81 {
    public static void main(String[] args) throws IOException {
        //ввод
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(FileDescriptor.in), 1 << 16));//64кб
        //вывод
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16));
        int n = nextInt(in);//читаем кол элем(некстлин парсит число из байт потока
        // (подкл к ист,извл,очист и нормал,сох))

        long[] pref = new long[n + 1];//мас преф сум

        for (int k = 0; k < n; k++) {
            pref[k + 1] = pref[k] + nextInt(in);
        }// на кажд итер читаем а(к) и доб к сум

        while (true) {//запр
            int i = nextIntOrEOF(in);
            if (i == Integer.MIN_VALUE) break; // конец ввода даных больше нет
            int j = nextInt(in);

            out.print(pref[j + 1] - pref[i]);

            out.print('\n');
        }

        out.flush();// сброс буфера
    }
//если ввод оборвался кидаем искл
    private static int nextInt(DataInputStream in) throws IOException {
        int ret = nextIntOrEOF(in);
        if (ret == Integer.MIN_VALUE) {
            throw new EOFException("Unexpected end of input");
        }
        return ret;
    }
//пропуск разделителей
    private static int nextIntOrEOF(DataInputStream in) throws IOException {
        int c;
        do {
            c = in.read();
        } while (c != -1 && c <= ' ');

        if (c == -1) return Integer.MIN_VALUE;//конец ввода
//обраб знака(числа могут быть отр)
        boolean negative = false;
        if (c == '-') {
            negative = true;
            c = in.read();
        }

        int result = 0;
        while (c > ' ') {
            result = result * 10 + (c - '0');
            c = in.read();
        }

        return negative ? -result : result;
    }
}
