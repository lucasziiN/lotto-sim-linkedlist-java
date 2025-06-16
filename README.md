# Java Linked List & Lottery Simulator – COMPX201 Assignment

This project implements a **custom singly linked list of Strings** and uses it to build a **lottery simulator**, written in Java. It was developed for COMPX201 (Data Structures & Algorithms) at the University of Waikato (2024).

---

## 🧵 Part One – `StrLinkedList`

A complete Java class for managing a dynamic, singly linked list of strings.

### ✅ Features
- `isEmpty()` – check if list is empty
- `getLength()` – count number of nodes
- `hasValue(String s)` – check if value exists
- `getValueAt(int i)` – return value at index
- `add(String s)` – insert at head
- `remove(String s)` – remove first occurrence of value
- `print()` – print list in `A->B->C->` format

### 🔧 Implementation
- Inner `Node` class
- Head pointer for list start
- Supports dynamic growth
- Written in `StrLinkedList.java`

---

## 🎲 Part Two – `LottoDraw`

A lottery simulator using the custom list class, designed to:

### 🎟️ Features
1. Store 40 possible lottery numbers as strings in a list
2. Randomly draw 6 **winning numbers**
3. Generate 100 lottery tickets (each with 6 unique numbers)
4. Calculate prize money per ticket based on matches:
   - 2 matches: $10
   - 3: $100
   - 4: $1,000
   - 5: $10,000
   - 6: $100,000
5. Calculate:
   - Total prize payout
   - Ticket revenue ($10 per ticket)
   - Profit for fundraiser

### ⚙️ Implementation Notes
- Random selection avoids duplicates
- Uses multiple `StrLinkedList` instances for numbers and tickets
- All constants (e.g. ticket cost, draw size) configurable

---

## 🧪 Sample Output
```plaintext
Winning numbers: [12, 23, 1, 38, 5, 17]

Ticket #1: [3, 5, 17, 22, 11, 8] → Matches: 2 → Prize: $10.00  
...
Total Sales: $1,000.00  
Total Prizes: $140.00  
Profit: $860.00

``` 

---

## 📂 File Structure
project/
├── StrLinkedList.java       # Custom linked list class
├── LottoDraw.java           # Lottery simulation driver
├── Node (inner class)       # Node structure for list
└── README.md

---

## 👨‍🎓 Author
Lucas Oda
University of Waikato
COMPX201 – Data Structures & Algorithms
March 2024

## 📜 License
For educational use only.
