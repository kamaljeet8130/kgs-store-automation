


# Student Record Manager

A console-based Java application for managing student records.

This project is part of a practical learning series focused on understanding the
**Java Collection Framework** through hands-on projects.

---

## 📌 Project Overview

The Student Record Manager allows users to manage student records through a
simple console-based menu.

The application supports basic CRUD operations:

- **Create** → Add a student
- **Read** → View and find students
- **Update** → Update student information
- **Delete** → Remove a student

---

## 🚀 Features

- Add a new student
- View all students
- Find a student by ID
- Update student details
- Delete a student
- Prevent duplicate student IDs
- Validate student information
- Handle invalid numeric input
- Safely remove students while iterating

---

## 🛠️ Technologies Used

- **Java**
- **Java Collection Framework**
- **ArrayList**
- **List**
- **Iterator**
- **Scanner**

---

## 📂 Project Structure

```text
StudentRecordManager/
│
├── src/
│   └── studentrecordmanager/
│       ├── Student.java
│       ├── StudentService.java
│       └── StudentManager.java
│
└── README.md
````

### `Student.java`

Represents a single student object.

Contains:

* Student ID
* Name
* Age
* Course

Also overrides:

* `toString()`
* `equals()`
* `hashCode()`

### `StudentService.java`

Contains the main business logic and manages the student collection.

Responsibilities:

* Add students
* Find students
* Display students
* Update students
* Delete students
* Validate student data

### `StudentManager.java`

Acts as the console UI and application entry point.

Responsibilities:

* Display menu
* Read user input
* Call appropriate service methods
* Display results

---

## 📚 Collection Used

The main collection used in this project is:

```java
List<Student> students = new ArrayList<>();
```

### Why `List`?

A `List` is suitable because we need:

* Ordered elements
* Index-based operations
* Easy traversal
* The ability to maintain elements in a specific order

A `List` also allows duplicate elements. However, our application prevents
duplicate **student IDs** through business validation.

### Why `ArrayList`?

`ArrayList` is a general-purpose implementation of the `List` interface.

It provides:

* Efficient index-based access
* Dynamic resizing
* Simple iteration
* Good performance for the operations required by this application

Therefore, `ArrayList` is a suitable choice for this project.

---

## ⚖️ ArrayList vs LinkedList

Both `ArrayList` and `LinkedList` implement the `List` interface.

### ArrayList

* Backed by a resizable array
* Fast index-based access
* Good general-purpose `List` implementation
* Used as the final implementation in this project

### LinkedList

* Uses linked nodes
* Slower index-based access
* Can be useful for certain insertion/removal operations
* Also implements `Deque`

The project was temporarily tested with `LinkedList` to understand the practical
difference between the two implementations.

---

## 🔄 Traversing the Collection

The project uses an enhanced `for` loop to display students:

```java
for (Student student : students) {
    System.out.println(student);
}
```

The project also uses `Iterator` when removing a student while traversing:

```java
Iterator<Student> iterator = students.iterator();

while (iterator.hasNext()) {

    Student student = iterator.next();

    if (student.getId() == studentId) {
        iterator.remove();
    }
}
```

### Why use `Iterator` for removal?

Directly modifying a collection while traversing it can cause a
`ConcurrentModificationException`.

Using:

```java
iterator.remove();
```

provides a safe way to remove the element currently being traversed.

---

## 🧩 Collection Methods Practiced

During this project, the following `List` operations were practiced:

```text
add()
add(index, element)
get()
set()
remove()
contains()
indexOf()
lastIndexOf()
size()
isEmpty()
clear()
```

### Quick Reference

| Method                | Purpose                                | Modifies List? |
| --------------------- | -------------------------------------- | -------------- |
| `add(element)`        | Adds an element at the end             | Yes            |
| `add(index, element)` | Inserts an element at a specific index | Yes            |
| `get(index)`          | Retrieves an element                   | No             |
| `set(index, element)` | Replaces an element                    | Yes            |
| `remove(index)`       | Removes an element by index            | Yes            |
| `remove(object)`      | Removes an element by object           | Yes            |
| `contains(object)`    | Checks whether an element exists       | No             |
| `indexOf(object)`     | Returns the first matching index       | No             |
| `lastIndexOf(object)` | Returns the last matching index        | No             |
| `size()`              | Returns number of elements             | No             |
| `isEmpty()`           | Checks whether the List is empty       | No             |
| `clear()`             | Removes all elements                   | Yes            |

---

## 🏗️ Collection Framework Hierarchy

A simplified view of the Java Collection Framework:

```text
Iterable
   │
   ▼
Collection
   ├── List
   ├── Set
   └── Queue

List
   ├── ArrayList
   ├── LinkedList
   └── Vector
```

### Important Distinction

* **`Collection`** represents a general group of objects.
* **`List`** represents an ordered collection with index-based operations.
* **`ArrayList`** is a concrete implementation of `List`.

The project uses:

```java
List<Student> students = new ArrayList<>();
```

Here:

* `List` → defines the required behavior
* `ArrayList` → provides the actual implementation

This is an example of **programming to an interface**.

---

## 🔁 Enhanced For Loop vs Iterator

### Enhanced For Loop

Used when we simply want to traverse the collection:

```java
for (Student student : students) {
    System.out.println(student);
}
```

It provides simple and readable traversal.

### Iterator

Used when we need explicit control over traversal:

```java
Iterator<Student> iterator = students.iterator();

while (iterator.hasNext()) {
    Student student = iterator.next();
}
```

An `Iterator` is particularly useful when elements need to be safely removed
while traversing the collection.

Conceptually:

```text
Enhanced For Loop
        │
        ▼
   Simple traversal


Iterator
        │
        ▼
Explicit traversal control
        │
        ▼
Safe removal using iterator.remove()
```

---

## 🟰 equals() and hashCode()

The project defines student equality using the **student ID**.

Two `Student` objects are considered logically equal when they have the same ID.

Example:

```text
Student 1 → ID: 101, Name: Kamal
Student 2 → ID: 101, Name: Rahul
```

These students are considered equal because the ID uniquely identifies a student.

### `equals()`

The `equals()` method compares student IDs:

```java
@Override
public boolean equals(Object o) {

    if (this == o) {
        return true;
    }

    if (!(o instanceof Student)) {
        return false;
    }

    Student student = (Student) o;

    return id == student.id;
}
```

### `hashCode()`

The `hashCode()` method is also based on the student ID:

```java
@Override
public int hashCode() {
    return Integer.hashCode(id);
}
```

This follows the Java rule:

> If two objects are equal according to `equals()`, they must have the same
> hash code.

This concept becomes especially important when working with hash-based
collections such as `HashSet` and `HashMap`.

---

## 🧬 Generics

The project uses generics:

```java
List<Student> students = new ArrayList<>();
```

`Student` specifies the type of elements that the List can contain.

This provides type safety.

For example:

```java
students.add(new Student(...));
```

is valid, while adding an unrelated type is prevented by the compiler.

---

## ✅ Validation Rules

A student can be added or updated only when:

* ID is greater than `0`
* ID is unique when adding
* Name is not blank
* Age is between `5` and `100`
* Course is not blank

Invalid input is rejected instead of being stored.

---

## 🖥️ Sample Usage

```text
================================
     STUDENT RECORD MANAGER
================================
1. Add Student
2. View Students
3. Find Student
4. Update Student
5. Delete Student
6. Exit

Enter choice: 1

Enter student ID: 101
Enter student name: Kamal
Enter student age: 26
Enter student course: Computer Science

Student added successfully.
```

---

## 🧠 Key Learning

Through this project, I learned:

* What the Java Collection Framework is
* Difference between `Collection`, `List`, and `ArrayList`
* How `ArrayList` works as a `List` implementation
* How to perform CRUD operations using a `List`
* Difference between `ArrayList` and `LinkedList`
* How to traverse collections using enhanced `for` loops
* How `Iterator` works
* Why `Iterator.remove()` is useful
* Difference between `==` and `equals()`
* Why `hashCode()` must be consistent with `equals()`
* How generics provide type safety
* How to program against an interface
* How to separate UI logic from business/collection logic
* How collection choice should depend on application requirements

---

## 🎯 Project Learning Focus

The main purpose of this project was **not** to build a complex application.

The purpose was to understand how the `List` part of the Java Collection
Framework works in a practical scenario.

The project helped demonstrate:

```text
Requirement
     │
     ▼
Choose Collection
     │
     ▼
List
     │
     ▼
Choose Implementation
     │
     ▼
ArrayList
     │
     ▼
Perform CRUD Operations
     │
     ▼
Traverse Using for-each / Iterator
```

---

## 🏁 Conclusion

This project provided hands-on experience with the `List` part of the Java
Collection Framework.

The main focus was understanding not only **how** to use `ArrayList`, but also
**why** a particular collection is appropriate for a given requirement.

