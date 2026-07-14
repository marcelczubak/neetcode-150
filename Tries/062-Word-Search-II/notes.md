# Word Search II - Notes

## Main Insight

This problem combines two concepts:

1. Trie
2. Backtracking DFS

The Trie prevents unnecessary board exploration.

---

# Why Trie?

Imagine:

```text
words =
[
"apple",
"app",
"application"
]
```

A normal DFS would repeatedly search:

```text
a -> p -> p
```

The Trie shares this prefix:

```text
          root
            |
            a
            |
            p
            |
            p
```

Now one DFS traversal can discover multiple words.

---

# TrieNode Design

```java
class TrieNode {

    TrieNode[] children = new TrieNode[26];

    String word;
}
```

Unlike a normal Trie:

```java
boolean endFlag;
```

we store:

```java
String word;
```

Why?

Because when DFS reaches the end of a word, we already know the answer.

No need to rebuild the string.

---

# Adding Words

Example:

Insert:

```text
eat
```

Process:

```text
root

e
 |
 a
 |
 t
```

At the final node:

```java
node.word = "eat";
```

---

# DFS State

The helper should track:

```java
dfs(
    board,
    row,
    col,
    TrieNode node,
    result
)
```

## row / col

Current board location.

---

## node

Current Trie position.

Meaning:

> What prefix have we matched so far?

---

## result

Stores completed words.

---

# DFS Process

At every cell:

## 1. Validate Position

Stop if:

```text
outside board
```

---

## 2. Match Character With Trie

Example:

Board:

```text
c
```

Calculate:

```java
int index = 'c' - 'a';
```

Check:

```java
node.children[index]
```

If null:

```text
No words begin this way
```

Stop.

---

## 3. Move Trie Pointer

```java
node = node.children[index];
```

---

## 4. Check Word

If:

```java
node.word != null
```

Found a complete word.

Add:

```java
result.add(node.word);
```

---

## 5. Mark Visited

Before exploring:

```java
board[row][col] = '#';
```

This prevents:

```text
A -> B -> A
```

using the same cell twice.

---

## 6. Explore Neighbours

Recursive calls:

```java
up
down
left
right
```

---

## 7. Restore

After recursion:

```java
board[row][col] = original;
```

This is backtracking.

---

# Common Mistakes

## Forgetting To Restore The Board

Wrong:

```java
board[row][col] = '#';
```

and never change it back.

Result:

Other searches cannot use that cell.

Correct:

```java
char temp = board[row][col];

board[row][col] = '#';

dfs(...);

board[row][col] = temp;
```

---

## Searching Every Word Separately

Too slow:

```text
for every word:
    run DFS
```

The Trie combines all searches.

---

## Not Stopping Invalid Prefixes

Important optimization:

Example:

Trie:

```text
cat
```

Board path:

```text
dog
```

After seeing:

```text
d
```

stop immediately.

There is no word beginning with `d`.

---

## Duplicate Results

If multiple paths find the same word:

```text
cat
cat
```

prevent duplicates by:

```java
node.word = null;
```

after adding.

---

# Interview Explanation

> "I store all words in a Trie so that DFS can efficiently check whether the current board path matches any possible word prefix. I start DFS from every board cell, moving through Trie nodes as characters match. When a Trie node contains a stored word, I add it to the result. I mark cells as visited during traversal and restore them during backtracking. The Trie allows early pruning of invalid paths, avoiding unnecessary searches."
