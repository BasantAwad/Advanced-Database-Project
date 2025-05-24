import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileUtils {

    // Reads all employees from a file and returns a list of Employee objects
    public static List<Employee> readEmployeesFromFile(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip header
                    continue;
                }
                employees.add(parseEmployee(line));
            }
        }
        return employees;
    }

    // Writes a list of Employee objects to a file
    public static void writeEmployeesToFile(List<Employee> employees, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("EmployeeID,LastName,FirstName,Department,Salary"); // Write header
            writer.newLine();
            for (Employee employee : employees) {
                writer.write(formatEmployee(employee));
                writer.newLine();
            }
        }
    }

    // Parses a line from the file into an Employee object
    public static Employee parseEmployee(String line) {
        String[] parts = line.split(",");
        int employeeId = Integer.parseInt(parts[0]);
        String lastName = parts[1];
        String firstName = parts[2];
        String department = parts[3];
        float salary = Float.parseFloat(parts[4]);
        return new Employee(employeeId, lastName, firstName, department, salary);
    }

    // Converts an Employee object into a string suitable for writing to a file
    public static String formatEmployee(Employee employee) {
        return employee.getEmployeeId() + "," +
               employee.getLastName() + "," +
               employee.getFirstName() + "," +
               employee.getDepartment() + "," +
               employee.getSalary();
    }
}