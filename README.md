<p align="center"><img src="https://raw.githubusercontent.com/BasantAwad/BasantAwad/main/assets/introduction-banner.svg" alt="Terminal-inspired project banner" width="100%" /></p>

<!-- terminal-badges -->
<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Algorithms-8B5CF6?style=flat-square&logo=java&logoColor=white" alt="Algorithms" />
  <img src="https://img.shields.io/badge/External%20Sort-06B6D4?style=flat-square&logo=files&logoColor=111827" alt="External Sort" />
</p>

<p align="center"><img src="https://raw.githubusercontent.com/BasantAwad/BasantAwad/main/assets/introduction-banner.svg" alt="Animated terminal profile for Basant Awad Mohamed" width="100%" /></p>

# External Merge Sort for Large Employee Records

A Java implementation of external merge sort for employee records that do not fit comfortably in memory. The project compares sorting criteria and writes reproducible CSV outputs for each result.

## What it demonstrates

- External sorting over 16 input files containing 16,000 employee records.
- Sorting by employee ID, salary, department then salary, and first-name initial.
- Separation between domain models, file utilities, in-memory sorting, and external merge logic.
- A practical example of handling large datasets with bounded memory.

## Technology

Java, CSV file processing, external merge sort, object-oriented design.

## Run

Place the input CSV files in `Data/`, then compile and execute:

```bash
javac -d bin src/*.java
java -cp bin ExternalMergeSort
```

Sorted files are written back to `Data/` using the criterion-specific filenames described in the source documentation.

## Repository map

`src/Employee.java` defines the record model, `EmployeeFileUtils.java` handles file operations, `InMemorySorter.java` provides the baseline sorter, and `ExternalMergeSort.java` coordinates chunking and merging. See `DATABASE.md` and `report.md` for the design discussion.
