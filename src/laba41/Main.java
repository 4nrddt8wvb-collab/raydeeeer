package laba41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack<Integer> stack = new MinStackImp1();
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (line.startsWith("push")) {
                int value = Integer.parseInt(line.substring(5).trim());
                stack.push(value);
            } else if (line.equals("pop")) {
                stack.pop();
            } else if (line.equals("top")) {
                sb.append(stack.top()).append('\n');
            } else if (line.equals("min")) {
                sb.append(stack.min()).append('\n');
            }
        }

        System.out.print(sb);
    }
}