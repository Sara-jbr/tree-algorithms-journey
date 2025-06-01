#  Tree Data Structure Practice

Welcome to my small **Tree Data Structure Practice** project!  
In this project, I’ve explored the usage of **trees** in solving a wide range of algorithmic and real-world challenges.  
Trees are essential structures in computer science — forming the basis of **file systems**, **compilers**, **search algorithms**, and more.

Here’s a breakdown of how **basic**, **intermediate**, and **advanced** tree types are used and applied in practical programming scenarios.

---

##  Introduction: What is a Tree?

A **Tree** is a non-linear, **hierarchical data structure** consisting of **nodes** and **edges**.

- It starts with a **root node** and branches out to **children nodes**.
- Each node (except the root) has exactly **one parent**.
- Trees are **acyclic graphs**, meaning they do **not contain cycles**.

Trees are ideal for representing **hierarchical data**, supporting **fast searching**, and enabling **structured recursion**.

---

##  Why Learn Trees?

Understanding trees is essential because:

- They power many **search** and **sort** operations.
- They model real-life structures like **organization charts**, **HTML/XML DOMs**, and **file systems**.
- Trees allow **fast insertion**, **deletion**, and **lookup** — especially when **balanced** (e.g., AVL or Red-Black Trees).
- Trees are foundational for **advanced algorithms** in **databases**, **compilers**, and **networks**.

> **Mastering trees = mastering the art of efficient organization and searching!**

---

##  Where Are Trees Used? (Real-World Examples)

| **Real-World Scenario**              | **How Tree Helps**                                                                 |
|--------------------------------------|-------------------------------------------------------------------------------------|
| **Filesystem Hierarchy**             | Represents folders and files as parent and child nodes.                            |
| **HTML/XML Document Structure**      | DOM is a tree where tags nest inside others.                                       |
| **Autocompletion Engines**           | Tries (prefix trees) are used to suggest words efficiently.                        |
| **Database Indexing (e.g., B-Trees)**| Enables fast range queries and insertions/deletions.                               |
| **Routing Algorithms in Networks**   | Builds shortest path trees from a source node.                                     |
| **Compilers**                        | Abstract Syntax Trees (ASTs) are used to parse and understand source code.         |
| **Game Development**                 | Behavior trees and decision trees drive AI and gameplay logic.                     |

> **In short:**  
Whenever you need to **structure**, **search**, or **navigate** hierarchical data — trees are the perfect tool.

---

##  Types of Trees

| **Type**              | **Description**                                                                 |
|------------------------|----------------------------------------------------------------------------------|
| 🔹 **Binary Tree**      | Each node has at most **2 children** (left and right).                          |
| 🔹 **Binary Search Tree** | Left child < Parent < Right child — for **efficient searching**.               |
| 🔹 **AVL Tree**         | A **self-balancing BST** — maintains height ≈ log(n).                          |
| 🔹 **Red-Black Tree**   | Another **self-balancing BST** — used in **Java’s TreeMap**, **C++ STL**, etc. |
| 🔹 **Segment Tree**     | Used for **fast range queries and updates**.                                   |
| 🔹 **Trie (Prefix Tree)** | Stores strings by prefix — ideal for **autocomplete**, **dictionaries**.       |
| 🔹 **N-ary Tree**       | Nodes can have **any number of children** — common in general hierarchies.     |
| 🔹 **B-Tree / B+ Tree** | Used in **database indexing** — optimized for **disk access**.                 |

---

##  Tree Traversals (Ways to Visit Nodes)

| **Traversal Type** | **Order**               | **Use Case**                                                |
|--------------------|--------------------------|--------------------------------------------------------------|
| **Preorder**       | Root → Left → Right      | Useful for **copying trees** or **prefix expression notation**. |
| **Inorder**        | Left → Root → Right      | Yields **sorted order** in **Binary Search Trees**.         |
| **Postorder**      | Left → Right → Root      | Useful in **deleting nodes** or **evaluating expressions**. |
| **Level Order**    | Breadth-First using Queue| Used in **shortest path**, and **serialization problems**.  |

---
