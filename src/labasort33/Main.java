package labasort33;

// Main.java
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {

    private static <T extends Comparable<T>> void check(String label, List<T> data) {
        System.out.println("=== " + label + " ===");
        System.out.println("До:    " + data);
        new GenericMergeSort<T>().sort(data);
        System.out.println("После: " + data);
        System.out.println();
    }

    public static void main(String[] args) {


        check("Integer", new ArrayList<>(Arrays.asList(5, 2, 8, 1, 4, 2, 7, 3)));


        check("String", new ArrayList<>(
                Arrays.asList("adsa", "pddjf", "aadff", "aasdf", "dfffg", "aaade")));


        check("LocalDateTime", new ArrayList<>(Arrays.asList(
                LocalDateTime.of(2024, 5, 1, 12, 0),
                LocalDateTime.of(2023, 11, 20, 8, 30),
                LocalDateTime.of(2025, 1, 15, 18, 45),
                LocalDateTime.of(2025, 11, 20, 8, 0)
        )));


        check("Student", new ArrayList<>(Arrays.asList(
                new Student("Alice",   20),
                new Student("Bob",     19),
                new Student("Charlie", 20),
                new Student("Diana",   18),
                new Student("Alice",   18)
        )));

        check("UUID", new ArrayList<>(Arrays.asList(
                UUID.fromString("c9bf9e57-1685-4c89-bafb-ff5af830be8a"),
                UUID.fromString("3f2504e0-4f89-11d3-9a0c-0305e82c3301"),
                UUID.fromString("00000000-0000-0000-0000-000000000001"),
                UUID.fromString("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
        )));
    }
}