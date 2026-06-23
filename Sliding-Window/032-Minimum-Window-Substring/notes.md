# 📝 Notes

---

## 🏷️ Pattern

Hard Sliding Window (Minimum Covering Substring)

---

## 🧠 Core Idea

We want the smallest substring of `s` that contains all characters of `t`.

We track:

```text
freqTarget → required counts
freqCurrent → window counts
```

---

## 🔑 Key Variables

```java
Map<Character, Integer> freqTarget;
Map<Character, Integer> freqCurrent;

int have = 0;
int need = freqTarget.size();

int left = 0;
int minLength = Integer.MAX_VALUE;
int startIndex = 0;
```

---

## 🚀 Algorithm Flow

### Step 1: Build target frequency map

```java
for (char c : t.toCharArray()) {
    freqTarget.put(c, freqTarget.getOrDefault(c, 0) + 1);
}
```

---

### Step 2: Expand right pointer

```java
for (int right = 0; right < s.length(); right++)
```

Add character to window:

```java
freqCurrent.put(c, freqCurrent.getOrDefault(c, 0) + 1);
```

---

### Step 3: Update `have`

```java
if (freqTarget.containsKey(c) &&
    freqCurrent.get(c).equals(freqTarget.get(c))) {
    have++;
}
```

---

### Step 4: Shrink while valid

```java
while (have == need)
```

---

### Step 5: Update minimum window

```java
if (right - left + 1 < minLength) {
    minLength = right - left + 1;
    startIndex = left;
}
```

---

### Step 6: Remove left character

```java
char toRemove = s.charAt(left);

if (freqTarget.containsKey(toRemove) &&
    freqCurrent.get(toRemove).equals(freqTarget.get(toRemove))) {
    have--;
}

freqCurrent.put(toRemove, freqCurrent.get(toRemove) - 1);
left++;
```

---

### Step 7: Return result

```java
return minLength == Integer.MAX_VALUE
    ? ""
    : s.substring(startIndex, startIndex + minLength);
```

---

## 🧪 Example

```text
s = "ADOBECODEBANC"
t = "ABC"
```

Valid windows:

```text
ADOBEC
BANC  ← smallest valid window
```

Answer:

```text
"BANC"
```

---

## ⚠️ Common Mistakes

- Not shrinking window after it becomes valid
- Incorrect `have` tracking
- Forgetting duplicate counts matter (not just presence)
- Not updating minimum window properly
- Returning uninitialized result string

---

## 🎯 Pattern Recognition

If you see:

- “minimum substring”
- “contains all characters”
- “smallest window”
- “cover all requirements”

Think:

✔ Sliding window  
✔ Frequency maps  
✔ Expand → shrink strategy  
✔ `have / need` tracking  

---

## 🧩 Key Insight

The trick is:

> Once the window becomes valid, shrink it as much as possible without breaking validity.

That is what produces the minimum window.