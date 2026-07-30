# Detect Squares Notes

## Pattern

- HashMap
- Geometry
- Frequency Counting

---

# Core Insight

The query point is fixed.

Instead of searching for all possible squares, search for every possible **diagonal corner**.

Once the diagonal is known, the remaining two corners are uniquely determined.

---

# Data Structure

Store:

```java
Map<String,Integer>
```

Key:

```
"x,y"
```

Value:

```
frequency
```

Example:

```
(3,2)
```

stored twice becomes:

```
"3,2" -> 2
```

---

# Why Frequencies Matter

Duplicate points count as different points.

Example:

```
(3,2)
```

appears:

```
3 times
```

Every occurrence can participate in a different square.

Therefore frequencies must be multiplied.

---

# Valid Diagonal

Given:

```
Query:

(x1,y1)

Candidate:

(x2,y2)
```

Compute:

```java
xDiff = abs(x1-x2);

yDiff = abs(y1-y2);
```

A valid square requires:

```java
xDiff == yDiff
```

and:

```java
xDiff != 0
```

Otherwise:

- not a square
- same point

---

# Remaining Corners

Once the diagonal is chosen:

```
(x1,y2)

(x2,y1)
```

These are the only possible remaining corners.

Check whether both exist.

---

# Counting Squares

If:

```
top-left frequency = a

bottom-right frequency = b

diagonal frequency = c
```

Then:

```
a × b × c
```

new squares are formed.

---

# Example

Query:

```
(11,10)
```

Diagonal:

```
(3,2)
```

Other corners:

```
(11,2)

(3,10)
```

All exist.

Square found.

---

# Why Geometry Works

For an axis-aligned square:

```
width == height
```

Therefore:

```java
abs(x1-x2) == abs(y1-y2)
```

This single check filters every possible diagonal.

---

# Common Mistakes

## Forgetting duplicates

Using:

```java
Set<Point>
```

is incorrect.

Need:

```java
Map<Point,Integer>
```

because duplicate points count multiple times.

---

## Forgetting zero-length diagonals

Reject:

```java
xDiff == 0
```

Otherwise the query point would be paired with itself.

---

## Forgetting to multiply frequencies

Wrong:

```java
answer++;
```

Correct:

```java
answer +=

freq(diagonal)

*

freq(corner1)

*

freq(corner2);
```

---

## Using Euclidean distance

No square root calculations are needed.

Simply compare:

```java
abs(dx)

==

abs(dy)
```

---

# Interview Explanation

"I store every point together with its frequency in a HashMap. During a query, I iterate over every stored point and treat it as a possible diagonal of an axis-aligned square. A valid diagonal must have equal horizontal and vertical distance from the query point. Once I identify a valid diagonal, the other two corners are uniquely determined. If both exist, I multiply the frequencies of all three stored points to count every possible square."

---

# Complexity

add():

```
O(1)
```

count():

```
O(n)
```

where `n` is the number of distinct stored points.

Space:

```
O(n)
```

---

# Possible Improvement

Instead of encoding points as strings:

```java
"x,y"
```

many implementations use:

```java
Map<Integer, Map<Integer,Integer>>
```

or a custom `Point` class.

This avoids repeated:

```java
split()

parseInt()
```

during every query and improves performance, while keeping the same overall algorithm.