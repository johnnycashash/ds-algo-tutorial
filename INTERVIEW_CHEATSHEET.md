# 🎯 Interview Revision Cheat-Sheet

> Quick-revision guide for DS, Algorithms, Design Patterns, Java 8, and Multithreading.  
> Read this **30 minutes before** your interview.

---

## 📦 DATA STRUCTURES

### Array
| Op | Time |
|---|---|
| Access by index | O(1) |
| Insert/Delete at end | O(1) amortised |
| Insert/Delete at arbitrary index | O(n) |
| Search (unsorted) | O(n) |

**Key points:** Fixed size, contiguous memory. Java arrays are zero-indexed.

### Linked List
| Op | Time |
|---|---|
| Insert/Delete at head | O(1) |
| Insert/Delete at tail (no ref) | O(n) |
| Search | O(n) |

**Three classic problems:**
1. **Reverse** → 3 pointers: `prev`, `current`, `next`. Walk and flip.
2. **Find middle** → Slow (1 step) + Fast (2 steps). When fast reaches end, slow is at middle.
3. **Detect cycle** → Floyd's: slow/fast. If they meet → cycle.

```
Reverse:  null ← 1 ← 2 ← 3   (prev walks right)
Middle:   slow→1→2→3  fast→1→→3→→5  → slow at 3
Cycle:    slow meets fast → cycle exists
```

### Stack (LIFO)
| Op | Time |
|---|---|
| push / pop / peek | O(1) |

**Backed by:** Array or LinkedList.  
**MinMax Stack trick:** Store `{data, currentMin, currentMax}` per entry.

### Queue (FIFO)
| Op | Time |
|---|---|
| enqueue / dequeue / peek | O(1) |

**Circular array:** `back = (back + 1) % length` → wraps around, no wasted space.

### HashMap (Custom)
| Op | Average | Worst |
|---|---|---|
| put / get / remove | O(1) | O(n) |

**How it works:**
1. `hash(key) % buckets.length` → bucket index  
2. Each bucket = singly linked list (separate chaining)  
3. Walk the chain to find/insert  

**Bug to avoid:** `key.hashCode()` can be NEGATIVE → use `Math.abs(hashCode) % length`.

### HashSet (Custom)
**Secret:** It's just a HashMap where every key maps to a DUMMY object!  
This is exactly how `java.util.HashSet` works.

### Binary Search Tree
| Op | Average | Worst (skewed) |
|---|---|---|
| Search/Insert | O(log n) | O(n) |

**Property:** Left < Parent < Right

**Traversals (memorise the order of "visit root"):**

| Name | Order | Mnemonic | Use |
|---|---|---|---|
| Pre-order | **Root** → L → R | NLR | Copy tree |
| In-order | L → **Root** → R | LNR | **Sorted output** |
| Post-order | L → R → **Root** | LRN | Delete tree |
| Level-order | BFS with Queue | - | Print by level |

```java
void inorder(Node root) {
    if (root == null) return;
    inorder(root.left);
    print(root.data);    // ← visit root in the MIDDLE
    inorder(root.right);
}
```

---

## 🔍 ALGORITHMS

### Binary Search
```java
int lo = 0, hi = arr.length - 1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;   // avoids overflow!
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) lo = mid + 1;
    else                        hi = mid - 1;
}
```
**Time:** O(log n) — only works on **sorted** arrays.

### Bubble Sort
- Compare adjacent, swap if wrong order. Largest "bubbles" to end each pass.
- **Time:** O(n²) — **Optimisation:** `swapped` flag for early exit → O(n) best case.

### Merge Sort
- Divide in half recursively → merge sorted halves.
- **Time:** O(n log n) always. **Space:** O(n). **Stable:** YES.

### Kadane's Algorithm (Max Subarray Sum)
```java
currentMax = max(arr[i], currentMax + arr[i])  // extend or restart?
globalMax  = max(globalMax, currentMax)
```
**Time:** O(n). LeetCode #53.

### Sliding Window Pattern
- Two pointers: `left` and `right`. Expand `right`, shrink `left` when condition breaks.
- Used for: Longest substring without repeats, subarray sum, anagram search.

### Prefix Sum + HashMap Pattern
- For "subarray sum equals K": store prefix sums in a map.
- If `(currentSum - k)` exists in map → found a subarray.

---

## 🏗️ DESIGN PATTERNS

### Creational

| Pattern | One-liner | Key Class |
|---|---|---|
| **Singleton** | One instance, globally accessible | `ApplicationContext` |
| **Factory** | Client says WHAT, factory decides HOW | `PrinterFactory.getPrinter("laser")` |
| **Abstract Factory** | Factory of factories | `PrinterAbstractFactory.getPrinter(factory)` |
| **Builder** | Step-by-step construction, fluent API | `new Computer.Builder(16,512).build()` |
| **Prototype** | Clone existing object (deep copy!) | `order.clone()` |

**Singleton pitfalls:**
```
Double-checked locking: volatile + 2 null checks inside synchronized
Breaking: Reflection, Cloning, Serialization → BEST FIX: Enum singleton
```

### Structural

| Pattern | One-liner | Example |
|---|---|---|
| **Adapter** | Makes incompatible interface compatible | PencilAdapter wraps Pencil, implements Pen |
| **Facade** | Simplified API over complex subsystem | TravelFacade.travel() calls Flight + Hotel + Restaurant |
| **Proxy** | Controls access to real object | VpnProxy blocks certain URLs before delegating |

### Behavioural

| Pattern | One-liner | Key Difference |
|---|---|---|
| **Observer** | Subject notifies observers directly | Subject ──► Observer (tight coupling) |
| **Pub/Sub** | Publisher → EventBus → Subscriber | Fully decoupled via topics |
| **Strategy** | Swap algorithms at runtime | Interface injection: DataSource, Processor, DataSink |
| **Template** | Skeleton in base class, details in subclass | `washClothes()` calls abstract `openDoor()`, `putClothes()` |

---

## ☕ JAVA 8 ESSENTIALS

### Stream Operations
```java
// Filter + Map + Collect
list.stream().filter(x -> ...).map(x -> ...).collect(Collectors.toList());

// FlatMap (flatten nested lists)
nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());

// toMap with duplicate handling
words.stream().collect(Collectors.toMap(w -> w.charAt(0), w -> w, (a,b) -> a+","+b));

// GroupingBy + Counting
str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));

// Reduce
list.stream().map(String::length).reduce(0, Integer::sum);
```

### Functional Interfaces
| Interface | Method | Description |
|---|---|---|
| `Predicate<T>` | `test(T)→boolean` | Filter |
| `Function<T,R>` | `apply(T)→R` | Transform |
| `Consumer<T>` | `accept(T)→void` | Side effect |
| `Supplier<T>` | `get()→T` | Factory |

---

## 🧵 MULTITHREADING

### CompletableFuture
```java
supplyAsync(() -> value)           // async task returning value
  .thenApply(v -> transform(v))    // map
  .thenCompose(v -> anotherCF(v))  // flatMap
  .thenCombine(otherCF, (a,b)->a+b)// combine two CFs
  .exceptionally(ex -> fallback)   // error handling
  .handle((val, ex) -> ...)        // both success & failure
  .thenAccept(v -> consume(v))     // terminal (void)
  .join()                          // block & get result
```

### Fail-Fast vs Fail-Safe
| | Fail-Fast | Fail-Safe |
|---|---|---|
| Collections | ArrayList, HashMap | CopyOnWriteArrayList, ConcurrentHashMap |
| Modification during iteration | ConcurrentModificationException | No exception (works on snapshot) |
| Fix | Use `iterator.remove()` | – |

### Custom Thread Pool
```
BlockingQueue<Task> + Worker[] threads
Worker loop: while(!shutdown) { queue.take().run(); }
shutdown(): set volatile flag + interrupt all workers
```

---

## 🔢 COMMON INTERVIEW PROBLEMS QUICK-REF

| # | Problem | Technique | Time | Space |
|---|---|---|---|---|
| 1 | Max subarray sum | Kadane's | O(n) | O(1) |
| 2 | Subarray sum = K | Prefix sum + HashMap | O(n) | O(n) |
| 3 | Longest substring no repeats | Sliding window + Set | O(n) | O(n) |
| 4 | Kth largest element | Min-heap of size k | O(n log k) | O(k) |
| 5 | Move zeroes to end | Two pointers (insertPos) | O(n) | O(1) |
| 6 | Group anagrams | Sort key + HashMap | O(nk log k) | O(nk) |
| 7 | Single number | XOR all elements | O(n) | O(1) |
| 8 | LCS (subsequence) | 2D DP | O(nm) | O(nm) |
| 9 | LCS (substring) | 2D DP (reset to 0) | O(nm) | O(nm) |
| 10 | Reverse linked list | 3 pointers | O(n) | O(1) |
| 11 | Detect cycle | Floyd's slow/fast | O(n) | O(1) |
| 12 | Rotate array | Three reverses | O(n) | O(1) |
| 13 | Check anagram | Frequency array[26] | O(n) | O(1) |
| 14 | First unique char | Frequency array[26] | O(n) | O(1) |
| 15 | Palindrome check | Two pointers | O(n) | O(1) |

---

## 💡 INTERVIEW TIPS

1. **Always clarify:** input size, sorted?, duplicates?, negative numbers?
2. **Start brute force**, then optimise. Say your thought process out loud.
3. **State complexity** before coding: "This is O(n) time, O(1) space."
4. **Edge cases:** empty input, single element, all same, all negative.
5. **HashMap** solves most "find pair/count/group" problems.
6. **Sorting** often simplifies problems (think binary search after sort).
7. **Two pointers** for array/string: same direction or opposite ends.
8. **Stack** for matching/nesting problems (parentheses, undo).
9. **Queue (BFS)** for level-order or shortest path.
10. **Heap** for "top K" or "kth largest" problems.

---

*Good luck! 🚀 You've got this.*

