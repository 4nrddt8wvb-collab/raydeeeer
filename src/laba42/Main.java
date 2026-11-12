package laba42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        PriorityQueueImpl pq = new PriorityQueueImpl();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("enqueue ")) {
                int value = Integer.parseInt(line.substring("enqueue ".length()).trim());
                pq.enqueue(value);
            } else if (line.equals("dequeue-max")) {
                long[] result = pq.dequeueMaxWithInfo();
                if (result == null) {
                    out.append('*').append('\n');
                } else {
                    out.append(result[0])
                            .append(' ')
                            .append(result[1])
                            .append('\n');
                }
            } else if (line.startsWith("inc ")) {
                String[] parts = line.split("\\s+");
                long operation = Long.parseLong(parts[1]);
                int addition = Integer.parseInt(parts[2]);
                pq.increment(operation, addition);
            }
        }

        System.out.print(out);
    }
}