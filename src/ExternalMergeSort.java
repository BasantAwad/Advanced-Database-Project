import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ExternalMergeSort {

    public void sortFiles(String[] inputFiles, String outputFile) throws Exception {
        // Step 1: Sort individual files
        for (String inputFile : inputFiles) {
            sortIndividualFile(inputFile);
        }

        // Step 2: Merge sorted files
        mergeSortedFiles(inputFiles, outputFile, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int deptCompare = e1.getDepartment().compareTo(e2.getDepartment());
                if (deptCompare != 0) return deptCompare;
                // For salary descending, compare e2 to e1
                return Float.compare(e2.getSalary(), e1.getSalary());
            }
        });
    }

    private void sortIndividualFile(String inputFile) throws Exception {
        // Read records from the file
        List<Employee> employees = EmployeeFileUtils.readEmployeesFromFile(inputFile);

        // Sort the records in memory
        InMemorySorter sorter = new InMemorySorter();
        List<Employee> sortedEmployees = sorter.sort(employees, BY_DEPARTMENT_THEN_SALARY);

        // Write sorted records back to the file
        EmployeeFileUtils.writeEmployeesToFile(sortedEmployees, inputFile);
    }

    private void mergeSortedFiles(String[] inputFiles, String outputFile, Comparator<Employee> comparator) throws Exception {
        class EmployeeEntry {
            Employee employee;
            int fileIndex;
            EmployeeEntry(Employee employee, int fileIndex) {
                this.employee = employee;
                this.fileIndex = fileIndex;
            }
        }

        PriorityQueue<EmployeeEntry> minHeap = new PriorityQueue<>(
            (e1, e2) -> comparator.compare(e1.employee, e2.employee)
        );
        List<BufferedReader> readers = new ArrayList<>();

        // Initialize readers and heap
        for (int i = 0; i < inputFiles.length; i++) {
            BufferedReader reader = new BufferedReader(new FileReader(inputFiles[i]));
            readers.add(reader);
            reader.readLine(); // Skip header
            String line = reader.readLine();
            if (line != null) {
                Employee employee = EmployeeFileUtils.parseEmployee(line);
                minHeap.offer(new EmployeeEntry(employee, i));
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write("EmployeeID,LastName,FirstName,Department,Salary");
        writer.newLine();

        while (!minHeap.isEmpty()) {
            EmployeeEntry entry = minHeap.poll();
            writer.write(EmployeeFileUtils.formatEmployee(entry.employee));
            writer.newLine();

            BufferedReader reader = readers.get(entry.fileIndex);
            String line = reader.readLine();
            if (line != null) {
                Employee employee = EmployeeFileUtils.parseEmployee(line);
                minHeap.offer(new EmployeeEntry(employee, entry.fileIndex));
            }
        }

        for (BufferedReader reader : readers) reader.close();
        writer.close();
    }

    public static final Comparator<Employee> BY_ID =
        Comparator.comparingInt(Employee::getEmployeeId);

    public static final Comparator<Employee> BY_SALARY =
        Comparator.comparing(Employee::getSalary).reversed();

    public static final Comparator<Employee> BY_DEPARTMENT_THEN_SALARY =
        Comparator.comparing(Employee::getDepartment)
                  .thenComparing(Comparator.comparing(Employee::getSalary).reversed());

    public static final Comparator<Employee> BY_FIRSTNAME_INITIAL =
        Comparator.comparing((Employee e) -> e.getFirstName().substring(0, 1));

    public static void main(String[] args) throws Exception {
        String[] inputFiles = {
               "Data/employees_1.csv",
                "Data/employees_2.csv",
                "Data/employees_3.csv",
                "Data/employees_4.csv",
                "Data/employees_5.csv",
                "Data/employees_6.csv",
                "Data/employees_7.csv",
                "Data/employees_8.csv",
                "Data/employees_9.csv",
                "Data/employees_10.csv",
                "Data/employees_11.csv",
                "Data/employees_12.csv",
                "Data/employees_13.csv",
                "Data/employees_14.csv",
                "Data/employees_15.csv",
                "Data/employees_16.csv"
        };

        ExternalMergeSort sorter = new ExternalMergeSort();

        // Sort by EmployeeID
        sorter.sortFiles(inputFiles, "Data/sorted_by_id.csv", BY_ID);

        // Sort by Salary (descending)
        sorter.sortFiles(inputFiles, "Data/sorted_by_salary.csv", BY_SALARY);

        // Sort by Department, then Salary (descending)
        sorter.sortFiles(inputFiles, "Data/sorted_by_department.csv", BY_DEPARTMENT_THEN_SALARY);

        // Sort by First Name initial letter
        sorter.sortFiles(inputFiles, "Data/sorted_by_firstname_initial.csv", BY_FIRSTNAME_INITIAL);
    }

    // Add this overloaded method:
    public void sortFiles(String[] inputFiles, String outputFile, Comparator<Employee> comparator) throws Exception {
        // Step 1: Sort individual files (by the same comparator)
        for (String inputFile : inputFiles) {
            List<Employee> employees = EmployeeFileUtils.readEmployeesFromFile(inputFile);
            employees.sort(comparator);
            EmployeeFileUtils.writeEmployeesToFile(employees, inputFile);
        }
        // Step 2: Merge sorted files
        mergeSortedFiles(inputFiles, outputFile, comparator);
    }
}