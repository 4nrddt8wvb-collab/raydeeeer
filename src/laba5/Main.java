package laba5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMapImpl<String> map = new HashMapImpl<>();
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String command = parts[0];
            switch (command) {
                case "put":
                    map.put(parts[1], parts[2]);
                    break;
                case "delete":
                    map.delete(parts[1]);
                    break;
                case "get":
                    String value = map.getValue(parts[1]);
                    output.append(value == null ? "null" : value).append('\n');
                    break;
                default:

                    break;
            }
        }
        System.out.print(output);
    }
}