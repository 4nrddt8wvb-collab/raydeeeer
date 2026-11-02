package labasort33;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge()  { return age; }

    @Override
    public int compareTo(Student other) {
        int cmp = Integer.compare(this.age, other.age);
        if (cmp != 0) return cmp;
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}