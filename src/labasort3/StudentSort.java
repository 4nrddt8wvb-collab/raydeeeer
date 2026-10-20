package labasort3;

import java.util.ArrayList;
import java.util.List;

public class StudentSort implements Sort<Student> {

    @Override
    public void sort(List<Student> students) {
        insertionSortByAge(students);
        mergeSortByName(students, 0, students.size() - 1);
    }

    private void insertionSortByAge(List<Student> list) {
        for (int i = 1; i < list.size(); i++) {
            Student key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).getAge() > key.getAge()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    private void mergeSortByName(List<Student> list, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortByName(list, left, mid);
        mergeSortByName(list, mid + 1, right);
        mergeByName(list, left, mid, right);
    }

    private void mergeByName(List<Student> list, int left, int mid, int right) {
        List<Student> leftPart = new ArrayList<>(list.subList(left, mid + 1));
        List<Student> rightPart = new ArrayList<>(list.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < leftPart.size() && j < rightPart.size()) {
            if (leftPart.get(i).getName().compareTo(rightPart.get(j).getName()) <= 0) {
                list.set(k++, leftPart.get(i++));
            } else {
                list.set(k++, rightPart.get(j++));
            }
        }
        while (i < leftPart.size()) list.set(k++, leftPart.get(i++));
        while (j < rightPart.size()) list.set(k++, rightPart.get(j++));
    }
}