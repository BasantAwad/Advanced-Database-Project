# Project Report: External Merge Sort for Large Employee Records

## Introduction
This project implements the External Merge Sort algorithm to efficiently sort a large dataset of employee records stored across multiple files. The dataset consists of 16 files, each containing 1,000 employee records, totaling 16,000 records. The goal is to demonstrate the effectiveness of External Merge Sort for handling large datasets that cannot fit entirely in memory.

## Problem Statement
The main issue addressed in this project is the challenge of sorting datasets that are too large to fit into the available main memory (RAM). Traditional in-memory sorting algorithms become impractical or impossible when the dataset size exceeds memory limits, leading to excessive paging or program failure. In real-world database and data processing scenarios, it is common to encounter such large datasets. Therefore, an efficient external sorting algorithm is required to process and sort the data by various criteria without exceeding memory constraints.


## Algorithm Selection Rationale
External Merge Sort was chosen for this project due to its ability to handle large datasets efficiently. Traditional sorting algorithms require the entire dataset to fit in memory, which is not feasible for large files. External Merge Sort divides the dataset into smaller chunks, sorts them in memory, and then merges the sorted chunks, making it suitable for this project.

## Implementation Details
The project is structured into several Java classes, each serving a specific purpose:

- **Employee.java**: Defines the Employee class with fields for employee ID, last name, first name, department, and salary.
- **EmployeeFileUtils.java**: Provides utility functions for reading from and writing to employee record files.
- **InMemorySorter.java**: Implements in-memory sorting using a flexible comparator.
- **ExternalMergeSort.java**: Implements the External Merge Sort algorithm, handling sorting and merging for multiple criteria.
- **constants/SortCriterion.java**: Defines constants for sorting criteria.

## Sorting Criteria
The project supports sorting employee records by:
- Employee ID (ascending)
- Salary (descending)
- Department (A-Z), then Salary (descending)
- First Name initial (A-Z)

Each criterion produces a separate output file.

## Data Structure Design Choices
The Employee class encapsulates all relevant fields for an employee record:
- Employee ID (integer)
- Last Name (string)
- First Name (string)
- Department (string)
- Salary (float)

This structure allows for easy sorting and retrieval of employee records based on various criteria.

## Time Complexity Analysis
- **Sorting Individual Files**: O(n log n) per file, where n is the number of records in a file.
- **Merging Sorted Files**: O(N log k), where N is the total number of records and k is the number of sorted files.

## Evaluation of External Merge Sort's Performance
The External Merge Sort algorithm successfully sorted the 16,000 employee records across multiple files for all criteria. The implementation demonstrates efficient memory usage and processing time, highlighting the importance of external sorting for large datasets.

## Conclusion
This project successfully implemented the External Merge Sort algorithm to sort a large dataset of employee records by multiple criteria. The results demonstrate the effectiveness of External Merge Sort in handling large datasets, making it a valuable technique for applications requiring efficient data processing.