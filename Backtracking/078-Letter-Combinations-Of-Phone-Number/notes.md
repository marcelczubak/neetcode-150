# Letter Combinations of a Phone Number

## Problem

Given a string containing digits from `2-9`, return all possible letter combinations that the number could represent.

The mapping follows the phone keypad:

```
2 -> abc
3 -> def
4 -> ghi
5 -> jkl
6 -> mno
7 -> pqrs
8 -> tuv
9 -> wxyz
```

Each digit can represent multiple characters, so the goal is to generate every possible combination.

---

## Example

### Input

```
digits = "23"
```

### Output

```
[
 "ad",
 "ae",
 "af",
 "bd",
 "be",
 "bf",
 "cd",
 "ce",
 "cf"
]
```

---

# Approach

## Backtracking

This problem is solved using backtracking because each digit creates multiple choices.

At each recursive step:

1. Look at the current digit.
2. Retrieve all possible letters for that digit.
3. Choose one letter.
4. Move to the next digit.
5. Undo the choice and try another letter.

The recursion explores every possible path until a complete combination is created.

Example:

```
             ""
        /     |     \
       a      b      c
     / | \   /|\    /|\
    d  e f  d e f  d e f
```

Each leaf represents a valid answer.

---

# Algorithm

1. Create a mapping between digits and their corresponding letters.
2. Start backtracking from the first digit.
3. Maintain:
   - `StringBuilder combination` for the current combination.
   - `digitsIndex` to track which digit is being processed.
4. If all digits have been processed:
   - Add the current combination to the result.
5. Otherwise:
   - Try every possible letter for the current digit.
   - Append the letter.
   - Recursively process the next digit.
   - Remove the letter after returning.

---

# Complexity Analysis

Let:

- `n` = number of digits
- Maximum choices per digit = 4

## Time Complexity

```
O(4^n * n)
```

There are at most `4^n` possible combinations.

Each combination requires `O(n)` time to construct.

---

## Space Complexity

```
O(n)
```

The recursion depth is equal to the number of digits.

---

# Backtracking Template

Most backtracking problems follow:

```
Choose
↓
Explore
↓
Undo
```

For this problem:

```java
combination.append(letter);

backtrack(...);

combination.deleteCharAt(
    combination.length() - 1
);
```

---

# Common Mistakes

## 1. Passing a new StringBuilder

Incorrect:

```java
backtrack(result, new StringBuilder(), digits, index + 1);
```

This loses all previous choices.

Correct:

```java
backtrack(result, combination, digits, index + 1);
```

---

## 2. Forgetting to undo the choice

Incorrect:

```java
combination.append(letter);
backtrack(...);
```

The next branch will contain previous letters.

Correct:

```java
combination.append(letter);

backtrack(...);

combination.deleteCharAt(
    combination.length() - 1
);
```

---

## 3. Incorrect base case

Stop when all digits have been processed:

```java
if (digitsIndex == digits.length()) {
    result.add(combination.toString());
    return;
}
```

---

# Pattern Recognition

This is a backtracking problem.

Similar problems:

- Subsets
- Permutations
- Combination Sum
- Generate Parentheses
- Palindrome Partitioning

The main difference is the available choices:

```
Subsets:
    Include / exclude

Permutations:
    Choose unused elements

Phone combinations:
    Choose one letter from the current digit
```