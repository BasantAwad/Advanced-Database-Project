import java.util.Comparator;
import java.util.List;

public class InMemorySorter {
    public static void sort(Employee[] employees) {
        quickSort(employees, 0, employees.length - 1);
    }

    private static void quickSort(Employee[] employees, int low, int high) {
        if (low < high) {
            int pi = partition(employees, low, high);
            quickSort(employees, low, pi - 1);
            quickSort(employees, pi + 1, high);
        }
    }

    private static int partition(Employee[] employees, int low, int high) {
        Employee pivot = employees[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (employees[j].getEmployeeId() < pivot.getEmployeeId()) {
                i++;
                swap(employees, i, j);
            }
        }
        swap(employees, i + 1, high);
        return i + 1;
    }

    private static void swap(Employee[] employees, int i, int j) {
        Employee temp = employees[i];
        employees[i] = employees[j];
        employees[j] = temp;
    }

    public List<Employee> sort(List<Employee> employees, Comparator<Employee> comparator) {
        employees.sort(comparator);
        return employees;
    }
}