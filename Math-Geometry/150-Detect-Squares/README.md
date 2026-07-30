# Detect Squares

## Problem

Design a data structure that supports two operations:

- `add(point)` — Add a point to the data structure.
- `count(point)` — Return the number of axis-aligned squares that can be formed using the given query point.

Points may be added multiple times, and duplicate points count as distinct points.

An axis-aligned square has sides parallel to the x and y axes.

---

## Example

### Operations

```text
add([3,10])
add([11,2])
add([3,2])

count([11,10])
```

### Output

```text
1
```

### Explanation

The square consists of:

```text
(3,10)
(11,10)
(3,2)
(11,2)
```

---

# Approach

## HashMap + Enumerate Diagonals

The query point is fixed.

Every square can be uniquely identified by its **diagonal corner**.

Instead of searching for every possible square, iterate through every stored point and treat it as a possible diagonal.

For each candidate diagonal:

- The horizontal distance must equal the vertical distance.
- The distance must be non-zero.

If both conditions hold, compute the remaining two corners and check whether they exist.

---

## Algorithm

### Data Structure

Store every point and its frequency:

```java
Map<String, Integer> points;
```

Key format:

```
"x,y"
```

Example:

```
"3,10"
```

maps to:

```
frequency
```

This naturally handles duplicate points.

---

### add(point)

Convert the point into its string key.

Increment its frequency.

Example:

```
(3,2)
```

added twice becomes:

```
"3,2" -> 2
```

---

### count(point)

Iterate over every stored point.

Treat each one as a possible diagonal corner.

For every candidate:

Compute:

```
xDiff = |x1 - x2|

yDiff = |y1 - y2|
```

A valid diagonal satisfies:

```
xDiff == yDiff

and

xDiff != 0
```

---

### Compute Remaining Corners

Given:

```
Query:

(x1,y1)

Diagonal:

(x2,y2)
```

The other two corners are:

```
(x1,y2)

(x2,y1)
```

If both exist in the HashMap:

```
square found
```

---

### Counting Duplicates

Suppose:

```
top-left exists twice

bottom-right exists three times

diagonal exists twice
```

Then:

```
2 × 3 × 2 = 12
```

different squares are possible.

Therefore:

```java
frequency(topLeft)
*
frequency(bottomRight)
*
frequency(diagonal)
```

is added to the answer.

---

# Example Walkthrough

Stored points:

```
(3,10)

(11,2)

(3,2)
```

Query:

```
(11,10)
```

Possible diagonal:

```
(3,2)
```

Distance:

```
|11-3| = 8

|10-2| = 8
```

Valid square.

Other two corners:

```
(11,2)

(3,10)
```

Both exist.

Answer:

```
1
```

---

# Why This Works

For an axis-aligned square:

- Opposite corners always have equal horizontal and vertical distance.
- Once the diagonal is chosen, the remaining two corners are uniquely determined.

Therefore checking every stored point as a diagonal guarantees every possible square is considered exactly once.

---

# Complexity

Let:

```
n = number of distinct stored points
```

## add()

HashMap insertion:

```
O(1)
```

---

## count()

Iterate through every stored point:

```
O(n)
```

HashMap lookups are constant time.

---

## Space Complexity

HashMap stores every distinct point.

```
O(n)
```

---

# Pattern Recognition

When you see:

- geometry
- duplicate points
- frequent insertions
- repeated queries

Think:

```
HashMap + Geometry
```

---

# Related Problems

- Valid Sudoku
- Number of Islands
- K Closest Points to Origin
- Max Points on a Line