# Advanced Database Project: External Merge Sort

## Overview

This project demonstrates an **External Merge Sort** implementation in Java, designed for sorting large datasets that cannot fit entirely into memory. This is a fundamental technique in advanced database systems, where efficient processing of large files is essential.

The project works with employee data stored in multiple `.xls` files (CSV-formatted, not true Excel binaries) located in the `Data` folder. The sorting is performed based on the `employeeId` field.

---

## How External Merge Sort Works

External Merge Sort is a two-phase algorithm:

### 1. **Sort Phase (Run Generation)**
- Each input file is read into memory.
- The records are sorted using an in-memory sorting algorithm.
- The sorted records are written back to the same file.

### 2. **Merge Phase**
- All sorted files are merged into a single sorted output file.
- A **min-heap (priority queue)** is used to efficiently select the smallest record among the current candidates from each file.
- The process continues until all records are merged into the output.

---

## Project / Code Structure

### 1. `Employee.java`
- **Purpose:**  
  Represents an employee record with fields such as `employeeId`, `firstName`, `lastName`, `department`, and `salary`.
- **Key Methods:**  
  - Getters and setters for each field.
  - `toString()` for easy string representation.
- **Role in Project:**  
  Acts as the data model for all sorting and file operations.

---

### 2. `EmployeeFileUtils.java`
- **Purpose:**  
  Provides utility methods for reading and writing employee records to and from files.
- **Key Methods:**  
  - `readEmployeesFromFile(String filePath)`: Reads all employee records from a file and returns a list of `Employee` objects.
  - `writeEmployeesToFile(List<Employee> employees, String filePath)`: Writes a list of `Employee` objects to a file.
  - `parseEmployee(String line)`: Parses a line from the file into an `Employee` object.
  - `formatEmployee(Employee employee)`: Converts an `Employee` object into a string suitable for writing to a file.
- **Role in Project:**  
  Abstracts file I/O and parsing logic, making the main sorting code cleaner and more modular.

---

### 3. `InMemorySorter.java`
- **Purpose:**  
  Handles the in-memory sorting of employee records.
- **Key Methods:**  
  - `sort(List<Employee> employees)`: Sorts the list of employees, typically by `employeeId`.
- **Role in Project:**  
  Used during the first phase of external merge sort to sort each chunk (file) in memory before merging.

---

### 4. `ExternalMergeSort.java`
- **Purpose:**  
  Implements the external merge sort algorithm for large datasets.
- **Key Methods:**  
  - `sortFiles(String[] inputFiles, String outputFile)`: Coordinates the sorting and merging process.
  - `sortIndividualFile(String inputFile)`: Sorts a single file in memory.
  - `mergeSortedFiles(String[] inputFiles, String outputFile)`: Merges all sorted files into a single sorted output file using a min-heap.
- **Role in Project:**  
  The main driver for sorting large datasets that do not fit into memory, demonstrating a core advanced database technique.

---

### 5. `Data/` Folder
- **Purpose:**  
  Stores all input and output `.xls` files (CSV-formatted).
- **Role in Project:**  
  Acts as the data source and destination for the sorting process.

---

## Why This Satisfies Advanced Database Requirements

- **Handles Large Datasets:**  
  Designed for files that are too large to fit into memory, a common scenario in database systems.

- **Efficient I/O:**  
  Minimizes disk reads and writes by processing data in chunks and merging efficiently.

- **Scalable:**  
  Can handle any number of input files and large volumes of data.

- **Database Principles:**  
  Implements a real-world algorithm used in database query processing and indexing.

---

## How to Run

1. Place your 16 `.xls` (CSV-formatted) employee data files in the `Data` folder.
2. Compile the Java source files:
   ```sh
   javac -d bin src/*.java
   ```
3. Run the main class:
   ```sh
   java -cp bin ExternalMergeSort
   ```
4. The sorted output will be written to `Data/sorted_employees.xls`.

---

## Notes

- The `.xls` files are treated as CSV files (plain text, comma-separated).
- No external libraries are required for Excel file handling.
- Adjust `BUFFER_SIZE` if you want to experiment with different memory constraints.

---

## File List

- `src/Employee.java` - Employee data model.
- `src/EmployeeFileUtils.java` - Utilities for reading/writing employee records.
- `src/InMemorySorter.java` - In-memory sorting logic.
- `src/ExternalMergeSort.java` - Main external merge sort logic.
- `Data/` - Folder containing input and output `.xls` files.

---

## References

- [Database System Concepts, Silberschatz et al.](https://www.db-book.com/)
- [External Sorting - Wikipedia](https://en.wikipedia.org/wiki/External_sorting)

---

## Data Structure Explanation

### Employee Record Structure

The core data structure in this project is the `Employee` class, which models each employee record as an object with the following fields:

- **employeeId** (`int`):  
  A unique identifier for each employee. This field is used as the primary key and is the basis for sorting.

- **firstName** (`String`):  
  The employee's first name.

- **lastName** (`String`):  
  The employee's last name.

- **department** (`String`):  
  The department in which the employee works.

- **salary** (`float`):  
  The employee's salary.

Each employee record is stored as a line in a `.xls` file (CSV format), with fields separated by commas. For example:
```
1001,Smith,John,Engineering,75000.0
```

### In-Memory Data Structures

- **List\<Employee\>:**  
  Used to hold all employee records from a file during the in-memory sort phase. This allows efficient sorting using Java's built-in sorting algorithms.

- **PriorityQueue\<Employee\>:**  
  Used during the merge phase to efficiently select the smallest (by `employeeId`) employee record from among the current candidates from each file. This data structure ensures that the merge operation always proceeds in sorted order.

- **BufferedReader / BufferedWriter:**  
  Used for efficient reading and writing of large files line by line, minimizing memory usage.

### File Structure

- **Input Files:**  
  Each input file in the `Data/` folder contains multiple employee records, one per line, in CSV format with a `.xls` extension.

- **Output File:**  
  The merged and fully sorted employee records are written to a single output file, also in CSV format with a `.xls` extension.

---

**Summary:**  
The project uses simple, efficient data structures (`Employee` objects, lists, and priority queues) to represent and process large datasets, enabling scalable and memory-efficient sorting suitable for advanced database applications.