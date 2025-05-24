# Advanced Database Project: External Merge Sort

## Overview

This project demonstrates an **External Merge Sort** implementation in Java, designed for sorting large datasets that cannot fit entirely into memory. The project works with employee data stored in multiple `.csv` files located in the `Data` folder. Sorting is performed based on multiple fields, and the results are written to separate output files for each criterion.

---

## How External Merge Sort Works

External Merge Sort is a two-phase algorithm:

### 1. **Sort Phase (Run Generation)**
- Each input file is read into memory.
- The records are sorted using an in-memory sorting algorithm, according to the selected criterion.
- The sorted records are written back to the same file (or a temporary file).

### 2. **Merge Phase**
- All sorted files are merged into a single sorted output file.
- A **min-heap (priority queue)** is used to efficiently select the next record among the current candidates from each file, according to the chosen comparator.
- The process continues until all records are merged into the output.

---

## Project / Code Structure

### 1. `Employee.java`
- **Purpose:**  
  Represents an employee record with fields such as `employeeId`, `firstName`, `lastName`, `department`, and `salary`.
- **Role in Project:**  
  Acts as the data model for all sorting and file operations.

### 2. `EmployeeFileUtils.java`
- **Purpose:**  
  Provides utility methods for reading and writing employee records to and from files.
- **Role in Project:**  
  Abstracts file I/O and parsing logic.

### 3. `InMemorySorter.java`
- **Purpose:**  
  Handles the in-memory sorting of employee records using a flexible comparator.
- **Role in Project:**  
  Used during the first phase of external merge sort to sort each chunk (file) in memory before merging.

### 4. `ExternalMergeSort.java`
- **Purpose:**  
  Implements the external merge sort algorithm for large datasets.
- **Role in Project:**  
  The main driver for sorting large datasets that do not fit into memory, supporting multiple sorting criteria and output files.

### 5. `constants/SortCriterion.java`
- **Purpose:**  
  Holds string constants for different sort criteria.

### 6. `Data/` Folder
- **Purpose:**  
  Stores all input and output `.csv` files.

---

## Output Files

After running the project, you will get the following output files in the `Data` folder:

- `sorted_by_id.csv` — Sorted by Employee ID (ascending)
- `sorted_by_salary.csv` — Sorted by Salary (descending)
- `sorted_by_department.csv` — Sorted by Department (A-Z), then Salary (descending)
- `sorted_by_firstname_initial.csv` — Sorted by the initial letter of First Name (A-Z)

---

## Data Structure Explanation

### Employee Record Structure

The core data structure in this project is the `Employee` class, which models each employee record as an object with the following fields:

- **employeeId** (`int`)
- **firstName** (`String`)
- **lastName** (`String`)
- **department** (`String`)
- **salary** (`float`)

Each employee record is stored as a line in a `.csv` file, with fields separated by commas.

### In-Memory Data Structures

- **List\<Employee\>:**  
  Used to hold all employee records from a file during the in-memory sort phase.
- **PriorityQueue\<Employee\>:**  
  Used during the merge phase to efficiently select the next employee record from among the current candidates from each file, according to the chosen comparator.
- **BufferedReader / BufferedWriter:**  
  Used for efficient reading and writing of large files line by line.

---

## How to Run

1. Place your 16 `.csv` employee data files in the `Data` folder.
2. Compile the Java source files:
   ```sh
   javac -d bin src/*.java
   ```
3. Run the main class:
   ```sh
   java -cp bin ExternalMergeSort
   ```
4. The sorted outputs will be written to the `Data` folder as described above.

---

## References

- [Database System Concepts, Silberschatz et al.](https://www.db-book.com/)
- [External Sorting - Wikipedia](https://en.wikipedia.org/wiki/External_sorting)

---

**Summary:**  
The project uses efficient data structures (`Employee` objects, lists, and priority queues) to process large datasets, enabling scalable and memory-efficient sorting suitable for advanced database applications.