# Word Dictionary - Trie With Wildcard Search Notes

## Core Idea

This problem extends the standard Trie by adding support for:

```text
.
```

The wildcard means:

> "This position can contain any letter."

A normal Trie traversal is deterministic:

```text
character → one child
```

A wildcard creates multiple possible paths:

```text
. → try every child
```

This is why DFS is required.

---

# Trie Structure

Each node contains:

```java
TrieNode[] children = new TrieNode[26];
boolean endOfWord;
```

The index represents the character:

```text
children[0]  = 'a'
children[1]  = 'b'
...
children[25] = 'z'
```

Nodes do not store characters directly.

The path through the tree represents the word.

---

# addWord()

Example:

Insert:

```text
cat
```

Process:

```
root
 |
 c
 |
 a
 |
 t*
```

The final node has:

```java
endOfWord = true;
```

This distinguishes:

```
ca
```

from:

```
cat
```

---

# Why DFS For Search?

Without wildcards:

```text
search("cat")
```

has one possible path:

```
c → a → t
```

With:

```text
search(".at")
```

the first character could be:

```
bat
cat
dat
...
```

We need to explore multiple possibilities.

DFS naturally handles this:

```
Try option 1
    |
    fail?
    |
Try option 2
    |
    success?
```

---

# Recursive DFS Breakdown

Method:

```java
dfs(word, index, node)
```

Parameters:

### word

The word being searched.

---

### index

The current character being processed.

Example:

```
"b.."

index = 0 → 'b'
index = 1 → '.'
index = 2 → '.'
```

---

### node

The current TrieNode.

---

# Base Case

```java
if(index == word.length())
    return node.endOfWord;
```

Meaning:

"We processed the entire search string."

Now we need to check:

> Does a real word end here?

---

# Wildcard Case

When:

```java
c == '.'
```

We cannot choose a single child.

Instead:

```java
for(TrieNode child : node.children)
```

Try every possible letter.

If any recursive call succeeds:

```java
return true;
```

Otherwise:

```java
return false;
```

---

# Normal Character Case

Example:

```text
search("cat")
```

Current character:

```java
c
```

Convert:

```java
int index = c - 'a';
```

Check:

```java
node.children[index]
```

If missing:

```
false
```

Otherwise continue:

```java
dfs(word, index + 1, child)
```

---

# Common Mistakes

## Forgetting endOfWord

Incorrect:

```
path exists → true
```

Example:

Inserted:

```
apple
```

Search:

```
app
```

The path exists, but the word does not.

Need:

```java
node.endOfWord
```

---

## Treating '.' as a normal character

Wrong:

```java
index = '.' - 'a';
```

`.` is not stored in the Trie.

It represents:

```
all possible children
```

---

## Using BFS

BFS can work, but DFS is much more natural because:

* A wildcard branches into many possibilities.
* We only need to know if one valid path exists.
* Recursive DFS matches the Trie structure.

---

# Interview Explanation

> "I use a Trie to store all inserted words. Searching normally follows the Trie path, but when encountering a wildcard '.', I perform DFS and recursively try every possible child. The recursion tracks the current node and character index, and once all characters are consumed I check whether a complete word ends at that node. This gives O(n) time for normal searches, while wildcard searches can explore multiple branches."
