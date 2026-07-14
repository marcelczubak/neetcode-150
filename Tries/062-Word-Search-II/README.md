# Word Search II

## Problem

Given a 2D board of characters and a list of words, return all words that exist in the board.

A word can be constructed from letters of sequentially adjacent cells:

* Horizontally
* Vertically

A cell cannot be used more than once in a word.

---

## Example

### Input

```text
board =
[
 ["o","a","a","n"],
 ["e","t","a","e"],
 ["i","h","k","r"],
 ["i","f","l","v"]
]

words = ["oath","pea","eat","rain"]
```

### Output

```text
["eat","oath"]
```

---

# Approach

## Key Idea

Use:

1. A **Trie** to store all words.
2. DFS backtracking to explore the board.

The Trie allows us to quickly determine whether the current path on the board can form a valid word prefix.

---

# Why Not Search Each Word Separately?

A brute force solution would:

1. Pick a word.
2. Run DFS on the board.
3. Repeat for every word.

This repeats a lot of work.

Example:

```text
words:
apple
app
ape
apply
```

Many words share:

```text
app
```

A Trie stores this prefix once.

---

# Trie Structure

Each TrieNode contains:

```java
TrieNode[] children = new TrieNode[26];
String word;
```

The children array represents possible next characters.

Example:

```text
children[0] -> 'a'
children[1] -> 'b'
children[25] -> 'z'
```

---

# Why Store The Word In The Node?

Instead of reconstructing the path:

```text
a -> p -> p -> l -> e
```

we store:

```java
node.word = "apple";
```

when inserting.

When DFS reaches this node:

```java
if(node.word != null)
```

we can immediately add the answer.

---

# Algorithm

## Step 1: Build Trie

Insert every word into the Trie.

Example:

Words:

```text
cat
car
card
```

Trie:

```text
          root
            |
            c
            |
            a
          /   \
         t     r
               |
               d
```

---

## Step 2: Start DFS From Every Cell

Every board position could be the start of a word.

For every cell:

```java
dfs(board, row, col, trie.root)
```

---

## Step 3: DFS Traversal

At each cell:

### 1. Check bounds

Stop if:

* Outside board
* Already visited

---

### 2. Check Trie

Convert:

```java
char c
```

into:

```java
int index = c - 'a';
```

If:

```java
node.children[index] == null
```

there is no possible word with this prefix.

Stop immediately.

---

### 3. Move Trie Pointer

Move:

```java
node = node.children[index];
```

---

### 4. Check For Complete Word

If:

```java
node.word != null
```

a word has been found.

Add it to results.

---

### 5. Explore Neighbours

Search:

* Up
* Down
* Left
* Right

---

### 6. Backtrack

Temporarily mark:

```java
board[row][col] = '#';
```

After exploring:

```java
board[row][col] = originalCharacter;
```

This allows the cell to be reused for different paths.

---

# Optimization

After finding a word:

```java
node.word = null;
```

This prevents duplicate results.

Example:

```text
words = ["cat", "cat"]
```

Without clearing:

```text
["cat", "cat"]
```

With clearing:

```text
["cat"]
```

---

# Complexity Analysis

Let:

* `W` = number of words
* `L` = average word length
* `R` = number of board rows
* `C` = number of board columns

---

## Trie Construction

Time:

```text
O(W * L)
```

Each character of every word is inserted once.

Space:

```text
O(W * L)
```

Trie stores all characters.

---

## DFS Search

Worst case:

```text
O(R * C * 4^L)
```

because each cell can branch into four directions.

However, Trie pruning significantly reduces the search space by stopping invalid prefixes early.

Space:

```text
O(L)
```

for recursion depth.

---

# Key Takeaway

The main optimization is:

> Do not ask "does this path form a word?"

Instead ask:

> "Can this path still form any word prefix?"

The Trie allows us to stop exploring impossible paths immediately.
