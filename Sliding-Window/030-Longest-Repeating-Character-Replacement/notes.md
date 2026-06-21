# 📝 Notes

---

## 🏷️ Pattern

Sliding Window + Frequency Map

---

## 🧠 Core Idea

We maintain a window:

```text
[left, right]
```

where we try to maximize:

```text
number of same characters after ≤ k replacements
```

---

## 🚀 Key Formula

Window is valid if:

```java
windowSize - maxFreq ≤ k
```

Where:

- `windowSize = right - left + 1`
- `maxFreq = count of most common character in window`

---

## 🔄 Algorithm Flow

### Step 1: Expand right

```java
for (int right = 0; right < s.length(); right++)
```

---

### Step 2: Update frequency map

```java
freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
```

---

### Step 3: Track max frequency

```java
maxFreq = Math.max(maxFreq, freqMap.get(c));
```

---

### Step 4: Check validity

```java
if (windowSize - maxFreq > k)
```

---

### Step 5: Shrink window if invalid

```java
freqMap.put(leftChar, freqMap.get(leftChar) - 1);
left++;
```

---

### Step 6: Update answer

```java
maxLength = Math.max(maxLength, windowSize);
```

---

## 🧪 Example

```text
s = "AABABBA", k = 1
```

Best window:

```text
"AABA" → replace B → "AAAA"
```

Answer = 4

---

## ⚠️ Common Mistakes

- Updating maxFreq incorrectly
- Trying to pre-check validity before expanding
- Forgetting to shrink window when invalid
- Tracking window size manually

---

## 🔄 Alternative Approaches

### ❌ Brute force
Try all substrings → O(n²)

### ❌ Backtracking replacements
Too slow and unnecessary

### ✅ Sliding window (optimal)
Maintain frequency + adjust window dynamically

---

## 🎯 Pattern Recognition

If you see:

- “replace k characters”
- “longest repeating substring”
- “maximize frequency in window”

Think:

✔ Sliding window  
✔ Frequency map  
✔ maxFreq trick  

---

## 🧩 Key Insight

We never explicitly choose which characters to replace.

We only track:

```text
how many characters are not the most frequent one
```

and ensure that count ≤ k.