# External Merge Sort for Large Employee Records

## Project Overview
This project implements the External Merge Sort algorithm to efficiently sort a large dataset of employee records stored across multiple files. The dataset consists of 16 files, each containing 1,000 employee records, totaling 16,000 records.

## Features
- Sorts employee records by **Employee ID**, **Salary**, **Department (then Salary)**, or **First Name Initial**.
- Outputs four sorted files:  
  - `sorted_by_id.csv`  
  - `sorted_by_salary.csv`  
  - `sorted_by_department.csv`  
  - `sorted_by_firstname_initial.csv`
- Handles datasets too large to fit in memory using external sorting techniques.

## Project Structure
- **src/**: Contains the source code files.
  - **Employee.java**: Defines the Employee class.
  - **EmployeeFileUtils.java**: Utility functions for file operations.
  - **InMemorySorter.java**: In-memory sorting logic.
  - **ExternalMergeSort.java**: External Merge Sort implementation.
  - **constants/SortCriterion.java**: Constants for sorting criteria.
- **Data/**: Directory containing 16 employee record files and output files.
- **README.md**: Project documentation.
- **report.md**: Project summary and evaluation.
- **DATABASE.md**: Database and data structure explanation.

## Setup Instructions
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

## Usage Guidelines
- The program reads all employee records from the `Data` directory.
- Sorting is performed for each criterion, and results are written to separate output files.
- No external libraries are required.

## Conclusion
This project demonstrates the implementation of the External Merge Sort algorithm for handling large datasets efficiently. The modular design allows for easy testing and maintenance, ensuring that the sorting process is both effective and scalable.