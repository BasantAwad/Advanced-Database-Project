# External Merge Sort for Large Employee Records

## Project Overview
This project implements the External Merge Sort algorithm to efficiently sort a large dataset of employee records stored across multiple files. The dataset consists of 16 files, each containing 1,000 employee records, totaling 16,000 records.

## Objectives
- Implement the External Merge Sort algorithm in Java.
- Design a data structure for employee records, including fields such as employee ID, name, department, and salary.
- Generate random employee records and store them in multiple files.
- Provide utility functions for file handling, sorting, and merging.
- Measure and analyze the time complexity of sorting and merging operations.

## Project Structure
- **src/**: Contains the source code files.
  - **Main.java**: Entry point of the application.
  - **Employee.java**: Defines the Employee class with relevant fields and methods.
  - **EmployeeGenerator.java**: Generates random employee records and writes them to files.
  - **EmployeeFileUtils.java**: Utility functions for file operations.
  - **InMemorySorter.java**: Implements an in-memory sorting algorithm.
  - **ExternalMergeSort.java**: Implements the External Merge Sort algorithm.
  - **constants/SortCriterion.java**: Defines constants for sorting criteria.
  
- **data/**: Directory containing 16 employee record files.

- **tests/**: Contains unit tests for various components of the project.
  - **EmployeeTest.java**: Tests for the Employee class.
  - **EmployeeGeneratorTest.java**: Tests for the EmployeeGenerator class.
  - **EmployeeFileUtilsTest.java**: Tests for the EmployeeFileUtils class.
  - **InMemorySorterTest.java**: Tests for the InMemorySorter class.
  - **ExternalMergeSortTest.java**: Tests for the ExternalMergeSort class.

- **README.md**: Documentation for the project.

- **report.md**: Summary of the project, including algorithm rationale, implementation details, and performance evaluation.

## Setup Instructions
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the Java files using a Java compiler.
4. Run the `Main` class to execute the External Merge Sort process.

## Usage Guidelines
- The program will automatically generate employee records and store them in the `data` directory.
- The sorting will be performed based on the specified criterion (e.g., Employee ID or Last Name).
- The sorted records will be written back to the files in the `data` directory.

## Conclusion
This project demonstrates the implementation of the External Merge Sort algorithm for handling large datasets efficiently. The modular design allows for easy testing and maintenance, ensuring that the sorting process is both effective and scalable.