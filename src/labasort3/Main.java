package labasort3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        if (first == null) return;
        first = first.trim();
        if (first.isEmpty()) return;

        int n = Integer.parseInt(first);
        List<Student> students = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line == null) break;
            line = line.trim();
            int sep = line.lastIndexOf(' ');
            String name = line.substring(0, sep);
            int age = Integer.parseInt(line.substring(sep + 1));
            students.add(new Student(name, age));
        }

        new StudentSort().sort(students);

        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.getName()).append(' ').append(s.getAge()).append('\n');
        }
        System.out.print(sb);
    }
}