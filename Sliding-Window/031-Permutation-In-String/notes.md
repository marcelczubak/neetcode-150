# 📝 Notes

---

## 🏷️ Pattern

Fixed-Size Sliding Window

---

## 🧠 Core Idea

A permutation has:

```text
same characters
same frequencies
```

So instead of generating permutations:

```text
Compare frequency counts.
```

---

## Frequency Arrays

For lowercase English letters:

```java
int[] freq = new int[26];
```

Character index:

```java
c - 'a'
```

Examples:

```text
'a' -> 0
'b' -> 1
'z' -> 25
```

---

## Step 1: Count s1

```java
for (char c : s1.toCharArray()) {
    freqCount[c - 'a']++;
}
```

This represents the target frequencies.

---

## Step 2: Build First Window

Window size:

```text
s1.length()
```

Example:

```text
s1 = "ab"
s2 = "eidbaooo"
```

Initial window:

```text
ei
```

Count frequencies for the first window.

---

## Step 3: Compare Arrays

```java
Arrays.equals(freqCount, windowFreq)
```

If true:

```text
Permutation found
```

---

## Step 4: Slide Window

Remove left character:

```java
windowFreq[s2.charAt(left) - 'a']--;
```

Add right character:

```java
windowFreq[s2.charAt(right) - 'a']++;
```

Move pointers:

```java
left++;
right++;
```

Window size remains constant.

---

## Window Visualization

```text
s2 = eidbaooo
```

```text
ei
 id
  db
   ba ← match
    ao
     oo
      oo
```

---

## ⚠️ Common Mistakes

### Off-by-one error

Wrong:

```java
right++;
windowFreq[s2.charAt(right)]++;
```

Can access beyond the string.

Correct:

```java
windowFreq[s2.charAt(right)]++;
right++;
```

---

### Forgetting last window

Must check:

```java
return Arrays.equals(freqCount, windowFreq);
```

after loop ends.

---

### Generating permutations

Too slow:

```text
O(n!)
```

Not required.

Use frequency counting instead.

---

## 🎯 Pattern Recognition

If you see:

- permutation
- anagram
- fixed substring length
- character counts

Think:

✔ Sliding window of fixed size  
✔ Frequency arrays  
✔ Compare counts  

---

## 🧩 Key Insight

The problem is NOT:

```text
Find a permutation.
```

The problem is:

```text
Find a window whose frequency count matches s1.
```

Once the counts match:

```text
A permutation exists.
```