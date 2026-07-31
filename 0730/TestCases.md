# Test Cases Report

## 系統名稱
RepairSchedulingSystem

---

# Test Case 01

### 功能
新增維修工作

### 輸入

```text
R001 Printer Priority=3
```

### 預期結果

```text
新增成功
```

### 實際結果

```text
新增成功
```

### 狀態

 通過

---

# Test Case 02

### 功能
新增多筆工作

### 輸入

```text
R001 Printer
R002 Laptop
R003 Projector
```

### 預期結果

```text
全部加入資料庫
```

### 實際結果

```text
全部加入成功
```

### 狀態

 通過

---

# Test Case 03

### 功能
重複編號測試

### 輸入

```text
R001
```

### 預期結果

```text
顯示重複編號
禁止新增
```

### 實際結果

```text
重複編號：R001
```

### 狀態

 通過

---

# Test Case 04

### 功能
Merge Sort 排序

### 操作

```text
執行 mergeSort()
```

### 預期結果

```text
依優先等級由高到低排序
```

### 實際結果

```text
Priority 5
Priority 5
Priority 4
Priority 3
Priority 2
```

### 狀態

 通過

---

# Test Case 05

### 功能
相同優先等級排序

### 測試資料

```text
R002 Priority=5 Order=2
R004 Priority=5 Order=4
```

### 預期結果

```text
保持登記順序
```

### 實際結果

```text
R002
R004
```

### 狀態

 通過

---

# Test Case 06

### 功能
Queue 等待工作

### 操作

```text
offer()
peek()
```

### 預期結果

```text
顯示第一筆等待工作
```

### 實際結果

```text
R002 Laptop
```

### 狀態

 通過

---

# Test Case 07

### 功能
Queue 空集合測試

### 操作

```text
emptyQueue
```

### 預期結果

```text
Queue 為空
```

### 實際結果

```text
Queue 為空
```

### 狀態

 通過

---

# Test Case 08

### 功能
完成工作

### 操作

```text
poll()
push()
```

### 預期結果

```text
等待工作減少
完成工作增加
```

### 實際結果

```text
正常完成
```

### 狀態

 通過

---

# Test Case 09

### 功能
Stack 復原工作

### 操作

```text
pop()
offer()
```

### 預期結果

```text
最近完成工作回到等待區
```

### 實際結果

```text
已復原成功
```

### 狀態

 通過

---

# Test Case 10

### 功能
空 Stack 測試

### 操作

```text
emptyStack
```

### 預期結果

```text
Stack 為空
```

### 實際結果

```text
Stack 為空
```

### 狀態

 通過

---

# Test Case 11

### 功能
設備名稱搜尋

### 輸入

```text
Printer
```

### 預期結果

```text
顯示 Printer 維修工作
```

### 實際結果

```text
Printer 工作被找到
```

### 狀態

 通過

---

# Test Case 12

### 功能
設備名稱不存在

### 輸入

```text
Server
```

### 預期結果

```text
找不到資料
```

### 實際結果

```text
找不到資料
```

### 狀態

 通過

---

# Test Case 13

### 功能
單筆資料測試

### 測試資料

```text
R001 Printer
```

### 預期結果

```text
系統正常運作
```

### 實際結果

```text
正常
```

### 狀態

 通過
---

# Test Case 14

### 功能
空資料測試

### 操作

```text
allTasks = empty
```

### 預期結果

```text
顯示無資料
```

### 實際結果

```text
無例外錯誤
```

### 狀態

 通過

---

# Test Case 15

### 功能
統計功能

### 操作

```text
顯示全部工作數
顯示等待工作數
顯示完成工作數
```

### 預期結果

```text
統計數字正確
```

### 實際結果

```text
全部工作數：5
等待工作數：4
完成工作數：1
```

### 狀態

 通過

---

# 修正紀錄

## 測試項目

重複編號檢查

### 問題

初版程式允許加入相同編號：

```text
R001
R001
```

### 修正內容

新增：

```java
isDuplicateId()
```

方法。

### 修正後測試結果

```text
重複編號：R001
新增失敗
```

### 狀態

 修正完成並重新測試通過

---

# 測試總結

| 項目 | 數量 |
|------|------|
| 測試案例總數 | 15 |
| 通過數 | 15 |
| 未通過數 | 0 |
| 修正案例數 | 1 |

## 最終結果

 所有測試案例通過

 已完成空資料測試

 已完成單筆資料測試

 已完成重複資料測試

 已完成找不到資料測試

 已完成 Queue / Stack 復原測試

 系統功能運作正常