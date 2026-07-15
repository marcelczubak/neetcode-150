# Design Twitter

## Problem

Design a simplified version of Twitter where users can:

- Post tweets
- Follow and unfollow other users
- Retrieve their news feed containing the 10 most recent tweets from themselves and users they follow

The challenge is efficiently merging tweets from multiple users while maintaining chronological order.

---

# Approach

## Data Structures Used

### 1. HashMap: Follow Relationships

```java
Map<Integer, Set<Integer>> followMap;
```

Stores:

```
User -> Users they follow
```

Example:

```
1 -> {2,3,4}
```

Meaning:

- User 1 follows users 2, 3, and 4.

A `HashSet` is used because:
- Duplicate follows should not exist.
- Removing a follow is O(1) average.

---

### 2. HashMap: Tweet Storage

```java
Map<Integer, List<Tweet>> tweetMap;
```

Stores:

```
User -> List of tweets
```

Each tweet stores:

```java
class Tweet {
    int timestamp;
    int tweetId;
}
```

The timestamp allows tweets to be ordered chronologically.

Example:

```
User 1:

[
 Tweet(1, 101),
 Tweet(2, 102),
 Tweet(3, 103)
]
```

Tweets are naturally sorted because they are appended in posting order.

---

# Posting Tweets

## Idea

When a user posts a tweet:

1. Increment global timestamp.
2. Create a Tweet object.
3. Add it to the user's tweet list.

Example:

```
postTweet(1,100)

time = 1

tweetMap:

1 -> [
      (timestamp=1, id=100)
    ]
```

## Complexity

```
Time: O(1)
Space: O(T)
```

where T is the number of tweets.

---

# Getting the News Feed

## Key Insight

This problem is similar to:

```
Merge K Sorted Lists
```

Each user's tweets are already sorted by timestamp.

Example:

```
User 1:
100 -> 80 -> 50

User 2:
120 -> 90

User 3:
110 -> 70
```

We need the 10 newest tweets across all lists:

```
120,110,100,90,80...
```

---

# Max Heap Approach

Use a max heap:

```java
PriorityQueue<HeapEntry>
```

The heap stores:

```java
class HeapEntry {
    int userId;
    int tweetIndex;
    Tweet tweet;
}
```

Why store the index?

Because after removing a tweet, we need to access that user's next oldest tweet.

Example:

```
User 1:

index:
0    1    2
50   80   100
          ^
          removed

Next candidate:
index 1 -> 80
```

---

# Algorithm

## Step 1: Find Relevant Users

The feed contains:

- The user's own tweets
- Tweets from followed users

Example:

```
User 1 follows:

2,3
```

Users considered:

```
1,2,3
```

A `Set` is used to avoid duplicates caused by:

```
follow(1,1)
```

---

## Step 2: Add Latest Tweet From Each User

For each user:

1. Get their newest tweet.
2. Add it to the max heap.

Example:

```
Heap:

User 2 -> 120
User 3 -> 110
User 1 -> 100
```

The heap always contains the best current candidate from each user.

---

## Step 3: Build Feed

While:

```
feed size < 10
and heap is not empty
```

Repeat:

1. Remove newest tweet from heap.
2. Add tweet ID to result.
3. Move backwards in that user's tweet list.
4. Add their next tweet to the heap.

Example:

Before:

```
Heap:

120
110
100
```

Remove:

```
120
```

Then add the same user's next tweet:

```
90
```

Heap becomes:

```
110
100
90
```

Continue until we have 10 tweets.

---

# Heap Comparator

Java PriorityQueue is a min heap by default.

To create a max heap:

```java
(a,b) -> Integer.compare(
    b.tweet.timestamp,
    a.tweet.timestamp
)
```

This ensures:

```
Newest timestamp = highest priority
```

---

# Edge Cases

## Self Follow

Example:

```
follow(1,1)
```

Without protection:

```
users = [1,1]
```

The same tweet could be added twice.

Solution:

Use:

```java
Set<Integer> users
```

instead of:

```java
List<Integer> users
```

This removes duplicates.

---

## User With No Tweets

A followed user may exist but have never tweeted.

Always check:

```java
tweets != null && !tweets.isEmpty()
```

before adding to the heap.

---

## Empty Follow List

A user may follow nobody.

Avoid:

```java
followMap.get(userId)
```

directly because it can return null.

---

# Complexity Analysis

Let:

- F = number of users followed
- T = total tweets

## postTweet()

```
Time: O(1)
```

---

## follow()

```
Time: O(1)
```

---

## unfollow()

```
Time: O(1)
```

---

## getNewsFeed()

Adding users to heap:

```
O(F log F)
```

Extracting 10 tweets:

```
O(10 log F)
```

Overall:

```
O(F log F)
```

Space:

```
O(T + F)
```

for storing tweets and follow relationships.

---

# Key Takeaways

- This problem is not about sorting all tweets.
- Each user's tweets are already sorted.
- Treat each user's timeline as a sorted list.
- Use a max heap to efficiently merge multiple timelines.
- Store the tweet index so you can retrieve the next candidate after removing one.

The main pattern:

```
Multiple sorted sources
        |
        v
    Priority Queue
        |
        v
 Efficient top K extraction
```