# Find Median From Data Stream - Notes

## Pattern

Two Heaps

The goal is to maintain the median of a continuously changing set of numbers without sorting the entire collection after every insertion.

Split the numbers into two halves:

Smaller Half | Larger Half

Maintain:

- Max Heap -> stores the smaller half
- Min Heap -> stores the larger half

The median is always found at the boundary between these two heaps.

---

# Data Structures

## Max Heap

Stores the smaller half of numbers.

Why a max heap?

Because we need quick access to the largest number in the smaller half.

Example:

Numbers:
1 2 3

Max Heap:

        3
       / \
      2   1

The root:

maxHeap.peek()

is one of the median candidates.

---

## Min Heap

Stores the larger half of numbers.

Why a min heap?

Because we need quick access to the smallest number in the larger half.

Example:

Numbers:
4 5 6

Min Heap:

        4
       / \
      5   6

The root:

minHeap.peek()

is one of the median candidates.

---

# addNum()

When a new number arrives:

## Step 1: Choose Heap

Compare the new number with:

maxHeap.peek()

This represents the boundary between the two halves.

Rules:

If the number belongs to the larger half:

    Add to minHeap

Otherwise:

    Add to maxHeap

Example:

Current:

maxHeap:

1 2 3

minHeap:

7 8

Insert:

10

10 belongs in the larger half:

minHeap

---

## Step 2: Balance The Heaps

The heaps must always satisfy:

|maxHeap.size() - minHeap.size()| <= 1

The difference between the heap sizes can never exceed 1.

Example:

Before:

maxHeap:

1 2 3 4

minHeap:

8

The max heap contains too many elements.

Move:

4

to the min heap.

After:

maxHeap:

1 2 3

minHeap:

4 8

---

# findMedian()

There are two possible cases.

## Odd Number Of Elements

One heap contains one extra element.

The median is the root of that heap.

Example:

Numbers:

1 2 3 4 5

maxHeap:

1 2 3

minHeap:

4 5

Median:

3

Return:

maxHeap.peek()

---

## Even Number Of Elements

Both heaps have equal size.

The median is the average of both heap roots.

Example:

Numbers:

1 2 3 4

Middle values:

2 and 3

Median:

(2 + 3) / 2 = 2.5

Implementation:

(maxHeap.peek() + minHeap.peek()) / 2.0

Important:

Use 2.0 instead of 2.

Using integer division:

5 / 2 = 2

Using floating point division:

5 / 2.0 = 2.5

---

# Common Mistakes

## 1. Using poll() Instead Of peek()

Wrong:

maxHeap.poll()

poll() removes the element from the heap.

Calling findMedian repeatedly would destroy the data structure.

Correct:

maxHeap.peek()

peek() only reads the value.

---

## 2. Integer Division

Wrong:

(maxHeap.peek() + minHeap.peek()) / 2

Java performs integer division.

Example:

5 / 2 = 2

Correct:

(maxHeap.peek() + minHeap.peek()) / 2.0

Result:

2.5

---

## 3. Misunderstanding Heap Roles

The max heap does NOT store the largest values.

It stores:

smaller half

The min heap stores:

larger half

Visual:

          Median

    maxHeap | minHeap

    smaller | larger
     half   |  half

---

# Complexity

Let:

n = number of inserted values

## addNum()

Heap insertion:

O(log n)

Balancing:

O(log n)

Total:

O(log n)

---

## findMedian()

Only accesses heap roots:

O(1)

---

## Space Complexity

Both heaps store all values:

O(n)

---

# Key Insight

This problem is not about sorting.

Sorting every time would be inefficient.

Instead, maintain two balanced halves.

Process:

Incoming number

        |

Choose correct heap

        |

Balance heaps

        |

Read median from heap tops

---

# Pattern Recognition

When you see:

- A stream of numbers
- Need the current median
- Values are continuously inserted

Think:

Two Heaps

The median always sits between:

maxHeap.peek()

and

minHeap.peek()