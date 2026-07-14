# Trie (Prefix Tree) - Notes

## Core Concept

A Trie is a tree-like data structure designed for storing strings.

The main idea:

> Store characters as paths through a tree instead of storing complete strings.

---

# Structure

Each TrieNode contains:

```java
TrieNode[] children;
boolean endFlag;
```

Example:

Insert:

```text
cat
car
```

Creates:

```text
          root
            |
            c
            |
            a
          /   \
         t*    r*
```

The shared prefix:

```text
ca
```

only exists once.

---

# Character Storage

Important:

The TrieNode does **not** store a character.

The character comes from the array index.

Example:

```java
curr.children[2]
```

means:

```text
'c'
```

because:

```java
'c' - 'a' = 2
```

Mapping:

```text
a -> 0
b -> 1
c -> 2
...
z -> 25
```

---

# Insert Logic

Maintain a pointer:

```java
TrieNode curr = root;
```

For each character:

### 1. Convert character to index

```java
int index = character - 'a';
```

---

### 2. Check if child exists

```java
curr.children[index]
```

Two possibilities:

### Exists

Move:

```java
curr = curr.children[index];
```

---

### Does not exist

Create:

```java
TrieNode child = new TrieNode();
```

Attach:

```java
curr.children[index] = child;
```

Move:

```java
curr = child;
```

---

After all characters:

```java
curr.endFlag = true;
```

This marks a complete word.

---

# Search Logic

Search follows the exact same path as insertion.

Example:

Searching:

```text
dog
```

Traversal:

```text
root
 |
 d
 |
 o
 |
 g
```

If any node is missing:

```java
return false;
```

If the traversal completes:

```java
return curr.endFlag;
```

because reaching a node only proves the prefix exists.

---

# Search vs StartsWith

## Search

Question:

> Does this exact word exist?

Requires:

```java
endFlag == true
```

Example:

Inserted:

```text
apple
```

Search:

```text
app
```

Result:

```text
false
```

---

## StartsWith

Question:

> Does any word begin with this prefix?

Only requires:

```text
path exists
```

Example:

Inserted:

```text
apple
```

StartsWith:

```text
app
```

Result:

```text
true
```

---

# Common Mistakes

## Forgetting endFlag

Incorrect:

```text
"path exists = word exists"
```

A Trie stores prefixes as well as words.

Always check:

```java
curr.endFlag
```

for `search()`.

---

## Creating nodes but not connecting them

Wrong:

```java
TrieNode child = new TrieNode();
```

This creates a node but it is lost.

Correct:

```java
curr.children[index] = child;
```

The node must become part of the Trie.

---

## Storing characters in nodes

Not needed.

The array index already tells us the character.

Avoid:

```java
char value;
```

inside TrieNode.

---

# Interview Explanation

> "I implement the Trie using nodes containing an array of 26 child references and a boolean marking the end of a word. During insertion, I traverse each character, creating missing nodes and moving forward. Searching follows the same path but also checks the end flag to ensure a complete word exists. Prefix searching only requires the path to exist. Each operation runs in O(n) time where n is the length of the input string."
