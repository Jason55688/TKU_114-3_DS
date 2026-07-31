# System Design Explanation

## 系統名稱
RepairSchedulingSystem（維修工作排程系統）

---

# 功能一：儲存全部維修工作

## 使用資料結構

ArrayList<RepairTask>

## 對應程式

RepairSchedulingSystem.java

```java
ArrayList<RepairTask> allTasks =
        new ArrayList<>();
```

## 原因

系統需要保存所有維修工作資料。

ArrayList 具有：

- 動態增加資料
- 可使用索引快速存取
- 適合維護完整歷史紀錄

## 為何不使用其他方法

Queue 只能先進先出。

Stack 只能後進先出。

兩者都不適合保存全部工作資料。

---

# 功能二：管理等待維修工作

## 使用資料結構

Queue<RepairTask>

## 對應程式

RepairSchedulingSystem.java

```java
Queue<RepairTask> waitingQueue =
        new LinkedList<>();
```

## 使用方法

```java
offer()
poll()
peek()
```

## 原因

維修工作必須依照登記順序處理。

Queue 使用 FIFO（First In First Out）。

最符合等待工作排程需求。

## 為何不使用 Stack

Stack 為 LIFO。

後加入的工作會先被處理。

不符合工作排程需求。

---

# 功能三：完成工作與復原功能

## 使用資料結構

Stack<RepairTask>

## 對應程式

RepairSchedulingSystem.java

```java
Stack<RepairTask> completedStack =
        new Stack<>();
```

## 使用方法

```java
push()
pop()
peek()
```

## 原因

最近完成的工作最可能被復原。

Stack 使用 LIFO。

非常適合實作 Undo 功能。

## 為何不使用 Queue

Queue 只能取得最早完成的工作。

無法快速復原最近完成的工作。

---

# 功能四：依優先等級排序

## 使用演算法

Merge Sort

## 對應程式

RepairAlgorithms.java

```java
mergeSort()
merge()
```

## 原因

Merge Sort 特色：

- 演算法穩定
- 排序效率高
- 時間複雜度 O(n log n)

適合大量維修工作排序。

## 為何不使用 Selection Sort

Selection Sort：

```text
O(n²)
```

資料量增加時效率較差。

---

# 功能五：依設備名稱搜尋

## 使用演算法

Sequential Search

## 對應程式

RepairAlgorithms.java

```java
searchByEquipment()
```

## 原因

設備名稱沒有排序。

必須逐筆比對：

```java
contains()
```

才能找到符合資料。

## 為何不使用 Binary Search

Binary Search 必須建立在已排序資料上。

設備名稱未排序。

因此無法直接使用。

---

# 功能六：依工作編號搜尋

## 使用演算法

Binary Search

## 對應方法

```java
binarySearch()
```

## 原因

工作編號可事先排序。

Binary Search：

```text
O(log n)
```

搜尋速度非常快。

## 為何不使用 Sequential Search

Sequential Search：

```text
O(n)
```

需要逐筆比較。

資料量大時計算成本較高。

---

# 資料結構比較

## ArrayList

優點：

- 動態增加資料
- 快速索引存取

用途：

```java
ArrayList<RepairTask>
```

保存全部維修資料。

---

## Queue

優點：

- FIFO
- 適合排隊系統

用途：

```java
Queue<RepairTask>
```

管理等待維修工作。

---

## Stack

優點：

- LIFO
- 適合復原操作

用途：

```java
Stack<RepairTask>
```

管理完成工作紀錄。

---

# 搜尋演算法比較

## Sequential Search

時間複雜度：

```text
O(n)
```

特色：

- 不需要排序
- 適合少量資料

使用方法：

```java
searchByEquipment()
```

---

## Binary Search

時間複雜度：

```text
O(log n)
```

特色：

- 必須排序後使用
- 搜尋速度快

使用方法：

```java
binarySearch()
```

---

# 排序演算法比較

## Merge Sort

時間複雜度：

```text
O(n log n)
```

特色：

- 穩定排序
- 適合大量資料

使用方法：

```java
mergeSort()
merge()
```

---

# Method 對照表

| 功能 | Method |
|--------|--------|
| 儲存全部資料 | ArrayList<RepairTask> |
| 加入等待工作 | offer() |
| 取得下一筆工作 | peek() |
| 完成工作 | poll() |
| 記錄完成工作 | push() |
| 復原工作 | pop() |
| 工作排序 | mergeSort() |
| 合併排序區段 | merge() |
| 設備名稱搜尋 | searchByEquipment() |
| 工作編號搜尋 | binarySearch() |

---

# 結論

本系統同時使用：

- ArrayList
- Queue
- Stack
- Sequential Search
- Binary Search
- Merge Sort

各資料結構與演算法皆依照實際需求選擇。

透過適當的資料結構搭配演算法，可以提高系統的可維護性、搜尋效率以及整體執行效能。