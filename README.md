# Sorting & Searching Algorithms — Complexity Analysis

Experimental analysis of **Bubble Sort**, **Quick Sort**, and **sequential matrix search** in Java, comparing theoretical time complexity (O(n²), O(n log n), O(m×n)) against measured comparisons and swaps across varying input sizes.

This project was developed as part of the Data Structures course (Estruturas de Dados) at Centro Universitário do Distrito Federal (UDF), and expanded here with a portfolio-oriented focus on experimental performance measurement rather than just algorithm implementation.

## Overview

Most tutorials stop at "here's how Bubble Sort works." This project goes further: it **instruments** each algorithm to count comparisons and swaps in real time, then runs controlled experiments across multiple input sizes to observe how theoretical complexity plays out in practice.

## What's inside

| Module | Description |
|---|---|
| `SortingUtils.java` | Bubble Sort and Quick Sort implementations with built-in operation counters (comparisons and swaps) |
| `Main.java` | Runs sorting experiments across array sizes of 10, 20, and 1,000 elements, using identical input data for a fair comparison between algorithms |
| `BuscaSequencial.java` | Sequential search in a 2D matrix, counting comparisons and reporting the position (row/column) where a value is found |
| `HandsOn1.java` | Array investigation: reads 10 temperatures, computes average, max/min values and their indices, and counts array traversal operations |
| `HandsOn2.java` | 2D matrix applied to sensor monitoring: 5 sensors × 24 hourly readings, computing per-sensor and overall averages, peak temperature and its location, and threshold-based counting |

## Key results

Running both sorting algorithms on identical randomly generated arrays (fixed seed for reproducibility):

| Size | Bubble Sort — Comparisons | Bubble Sort — Swaps | Quick Sort — Comparisons | Quick Sort — Swaps |
|---|---|---|---|---|
| 10 | 45 | 19 | 36 | 10 |
| 20 | 190 | 95 | 120 | 27 |
| 1,000 | 499,500 | 253,113 | 13,466 | 2,690 |

At 1,000 elements, Bubble Sort performs **~47x more operations** than Quick Sort to produce the exact same sorted output — a concrete illustration of why O(n²) vs O(n log n) matters in practice, not just in theory.

Sequential search in matrices follows the expected O(m × n) pattern: a 100×100 matrix (10,000 elements) requires up to 10,000 comparisons in the worst case (value at the end, or value not present), while a value found at the first position takes just 1 comparison, regardless of matrix size.

## How to run

Each file is a standalone `public class` with its own `main` method. Compile and run individually:

```bash
javac SortingUtils.java Main.java
java Main
```

```bash
javac BuscaSequencial.java
java BuscaSequencial
```

```bash
javac HandsOn1.java
java HandsOn1
```

```bash
javac HandsOn2.java
java HandsOn2
```

`BuscaSequencial`, `HandsOn1`, and `HandsOn2` prompt for input via the terminal (matrix dimensions, values to search, temperatures, etc).

## Design notes

- **Fixed random seeds** (`new Random(51)`) are used throughout to make results reproducible across runs — important for experimental comparison, same idea as `random_state` in scikit-learn.
- **Static counters** in `SortingUtils` accumulate comparisons/swaps across recursive `quickSort` calls, reset via `resetCounters()` before each run.
- **Identical input copies** (`Arrays.copyOf`) are used for both algorithms in each experiment, since both `bubbleSort` and `quickSort` mutate arrays in place — without this, the second algorithm would sort already-sorted data.
## What this project demonstrates

Two algorithms can produce the exact same output and still perform wildly different amounts of work to get there. Comparing only final results hides this entirely — you need to measure the operations themselves to understand real-world efficiency, which is the core idea this project sets out to explore across both 1D (arrays) and 2D (matrices) data structures.

## Author

Danilo Tavares Lima — Software Engineering student at UDF, Brasília.