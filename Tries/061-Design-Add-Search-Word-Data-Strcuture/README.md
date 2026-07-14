# Design Add and Search Words Data Structure

## Problem

Design a data structure that supports adding words and searching for words.

The search operation supports the wildcard character:

```text
.
```

which can represent **any lowercase letter**.

---

## Example

### Operations

```text
addWord("bad")
addWord("dad")
addWord("mad")

search("pad")
search("bad")
search(".ad")
search("b..")
```

### Output

```text
false
true
true
true
```

---

# Approach

## Key Idea

Use a **Trie (Prefix Tree)** to store all added words.

Each TrieNode contains:

* An array of 26 children.
* A boolean indicating whether a complete word ends at this node.

```java
TrieNode[] children = new TrieNode[26];
boolean endOfWord;
```

The trie allows normal character searches in:

```text
O(n)
```

time, where `n` is the length of the word.

---

# Data Structure

Example after inserting:

```text
bad
dad
mad
```

Trie:

```text
          root
            |
            a
            |
            d*
          / | \
         b  d  m
```

`*` represents:

```text
endOfWord = true
```

---

# Algorithm

## addWord()

1. Start from the root.
2. Traverse each character.
3. Convert the character into an array index:

```java
index = character - 'a';
```

4. Create missing nodes.
5. Move to the next node.
6. Mark the final node:

```java
endOfWord = true;
```

---

# search()

Search uses **DFS recursion** because of the wildcard character.

There are two cases.

---

## Case 1: Normal Character

Example:

```text
search("bad")
```

Follow the corresponding child.

```java
node.children[index]
```

If the child does not exist:

```text
return false
```

Otherwise continue recursively.

---

## Case 2: Wildcard Character

Example:

```text
search(".ad")
```

The `.` can represent any character.

Therefore:

1. Try every possible child.
2. Continue searching from each child.
3. If any path produces a valid word, return `true`.

Example:

```text
        root
       / | \
      b  d  m
      |  |  |
      a  a  a
      d  d  d
```

`.` can choose:

```text
b
d
m
```

---

# Complexity Analysis

Let:

* `n` = length of the word
* `26` = number of possible children per node

---

## addWord()

Time:

```text
O(n)
```

Each character is processed once.

Space:

```text
O(n)
```

New nodes are created for new characters.

---

## search()

Without wildcards:

```text
O(n)
```

With wildcards:

```text
O(26^n)
```

In the worst case, every `.` explores every possible branch.

Space:

```text
O(n)
```

For the recursion stack.
