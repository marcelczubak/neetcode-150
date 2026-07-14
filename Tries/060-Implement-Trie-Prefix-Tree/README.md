# Implement Trie (Prefix Tree)

## Problem

Implement a Trie (Prefix Tree) data structure that supports:

* `insert(word)` - Inserts a word into the Trie.
* `search(word)` - Returns whether a complete word exists in the Trie.
* `startsWith(prefix)` - Returns whether any inserted word starts with the given prefix.

---

# Example

## Operations

```text
insert("apple")
search("apple")
search("app")
startsWith("app")
insert("app")
search("app")
```

## Output

```text
true
false
true
true
```

---

# Approach

## Key Idea

A Trie stores words character-by-character.

Instead of storing complete strings, each node represents a point in a path.

Example after inserting:

```text
apple
app
```

The Trie becomes:

```text
          root
            |
            a
            |
            p
            |
            p*
            |
            l
            |
            e*
```

`*` indicates:

```java
endFlag = true
```

meaning a complete word ends at this node.

---

# TrieNode Structure

Each node contains:

```java
TrieNode[] children;
boolean endFlag;
```

### children array

The array stores references to possible next characters.

```text
children[0]  -> a
children[1]  -> b
...
children[25] -> z
```

The character index is calculated using:

```java
int index = character - 'a';
```

The node itself does not store the character.

The character is determined by the array position used to reach the next node.

---

# Algorithm

## Insert

### Steps

1. Start at the root.
2. Traverse each character in the word.
3. Convert the character into an index.
4. If the child node does not exist:

   * Create a new TrieNode.
   * Attach it to the current node.
5. Move to the child node.
6. After processing all characters:

   * Mark the current node as the end of a word.

---

### Example

Insert:

```text
cat
```

Process:

```text
root

root.children[2] -> c

c.children[0] -> a

a.children[19] -> t
```

Finally:

```java
t.endFlag = true;
```

---

# Search

Search checks whether an **entire word** exists.

### Steps

1. Start from the root.
2. For each character:

   * Calculate the index.
   * Check if the child exists.
   * Move to the child.
3. After reaching the final character:

   * Return `endFlag`.

---

### Important Difference

A path existing does not mean a word exists.

Example:

Inserted:

```text
apple
```

Searching:

```text
app
```

The path exists:

```text
a -> p -> p
```

but:

```java
endFlag = false
```

therefore:

```text
false
```

---

# StartsWith

`startsWith()` works similarly to `search()`.

The only difference:

* `search()` requires the final node to have `endFlag = true`.
* `startsWith()` only requires that the path exists.

Example:

Inserted:

```text
apple
```

Searching:

```text
app
```

returns:

```text
true
```

because `"app"` is a valid prefix.

---

# Complexity Analysis

Let:

```text
n = length of input word/prefix
```

---

## Insert

Time:

```text
O(n)
```

Each character is processed once.

Space:

```text
O(n)
```

New TrieNodes are created for new characters.

---

## Search

Time:

```text
O(n)
```

Each character requires one child lookup.

Space:

```text
O(1)
```

No additional memory is used.

---

## StartsWith

Time:

```text
O(n)
```

Space:

```text
O(1)
```

---

# Advantages of Trie

## Fast Prefix Searching

A Trie is especially useful when many operations involve prefixes.

Examples:

* Autocomplete
* Spell checking
* Dictionary searches
* Search suggestions

---

## Shared Prefixes

Words with common prefixes reuse nodes.

Example:

```text
car
card
care
```

share:

```text
car
```

instead of storing each word separately.
