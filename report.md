# Project Report: External Merge Sort for Large Employee Records

## Introduction
This project implements the External Merge Sort algorithm to efficiently sort a large dataset of employee records stored across multiple files. The dataset consists of 16 files, each containing 1,000 employee records, totaling 16,000 records. The goal is to demonstrate the effectiveness of External Merge Sort for handling large datasets that cannot fit entirely in memory.

## Algorithm Selection Rationale
External Merge Sort was chosen for this project due to its ability to handle large datasets efficiently. Traditional sorting algorithms, such as quicksort or mergesort, require the entire dataset to fit in memory, which is not feasible for large files. External Merge Sort divides the dataset into smaller chunks, sorts them in memory, and then merges the sorted chunks, making it suitable for this project.

## Implementation Details
The project is structured into several Java classes, each serving a specific purpose:

- **Main.java**: The entry point of the application, responsible for initializing the program, generating employee records, and orchestrating the external merge sort process.
- **Employee.java**: Defines the Employee class with fields for employee ID, last name, first name, department, and salary. It includes getter and setter methods for these fields.
- **EmployeeFileUtils.java**: Provides utility functions for reading from and writing to employee record files, including methods to read records from files and write sorted records back.
- **InMemorySorter.java**: Implements an in-memory sorting algorithm (e.g., quicksort) to sort individual employee record files before merging.
- **ExternalMergeSort.java**: Implements the External Merge Sort algorithm, handling the sorting of multiple files, merging sorted chunks, and managing memory usage during the merge process.
- **SortCriterion.java**: Defines constants for sorting criteria, such as sorting by employee ID or last name, to maintain consistency throughout the application.

## Data Structure Design Choices
The Employee class is designed to encapsulate all relevant fields for an employee record. The fields include:
- Employee ID (integer)
- Last Name (string)
- First Name (string)
- Department (string)
- Salary (float)

This structure allows for easy sorting and retrieval of employee records based on various criteria.

## Time Complexity Analysis
- **Sorting Individual Files**: The in-memory sorting algorithm (quicksort) has an average time complexity of O(n log n), where n is the number of records in a file.
- **Merging Sorted Files**: The merging process in External Merge Sort has a time complexity of O(n log k), where n is the total number of records and k is the number of sorted files being merged. This is efficient for large datasets as it minimizes the number of comparisons needed.

## Evaluation of External Merge Sort's Performance
The External Merge Sort algorithm was evaluated based on its ability to sort large datasets efficiently. The implementation successfully sorted the 16,000 employee records across multiple files, demonstrating the algorithm's effectiveness in managing memory usage and processing time. The project highlights the importance of using external sorting techniques for large datasets that exceed available memory.

## Conclusion
This project successfully implemented the External Merge Sort algorithm to sort a large dataset of employee records. The design choices and implementation details were carefully considered to ensure efficiency and correctness. The results demonstrate the effectiveness of External Merge Sort in handling large datasets, making it a valuable technique for applications requiring efficient data processing.