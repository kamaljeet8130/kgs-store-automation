# Employee Skill Manager

A console-based Java application for managing unique employee skills.

This project is part of a practical learning series focused on understanding the
Java Collection Framework through hands-on projects.

---

## 📌 Project Overview

The Employee Skill Manager allows users to maintain a collection of unique
skills.

Each skill contains:

- Skill name
- Skill category

The application prevents duplicate skills and maintains the order in which
skills were added.

The project focuses on understanding the `Set` part of the Java Collection
Framework, especially `LinkedHashSet`.

---

## 🚀 Features

- Add a skill
- View all skills
- Check whether a skill exists
- Remove a skill
- Remove all skills belonging to a category
- Count unique skills
- Check whether the collection is empty
- Clear all skills
- Prevent duplicate skills
- Preserve insertion order

---

## 🛠️ Technologies Used

- Java
- Java Collection Framework
- Set
- LinkedHashSet
- Iterator
- Generics
- equals()
- hashCode()

---

## 📂 Project Structure

```text
EmployeeSkillManager/
│
├── Skill.java
├── SkillService.java
├── SkillServiceTest.java
├── SkillManager.java
└── README.md
```

### Skill.java

Represents a skill in the system.

Contains:

- Skill name
- Skill category
- `equals()`
- `hashCode()`
- `toString()`

Two `Skill` objects are considered equal when both their name and category
are equal.

---

### SkillService.java

Contains the business logic for managing skills.

Responsibilities:

- Add skills
- Check whether a skill exists
- Remove skills
- Display skills
- Count skills
- Remove skills by category
- Clear all skills

The service uses:

```java
Set<Skill> skills = new LinkedHashSet<>();
```

---

### SkillManager.java

Acts as the console UI and application entry point.

Responsibilities:

- Display menu
- Read user input
- Create `Skill` objects
- Call methods from `SkillService`
- Display results

The UI is intentionally kept minimal because the primary focus of this project
is understanding the Java Collection Framework rather than UI development.

---

### SkillServiceTest.java

Used to verify the behavior of the skill management logic.

Tests include:

- Adding unique skills
- Rejecting duplicate skills
- Checking whether a skill exists
- Removing skills
- Removing skills by category
- Counting skills
- Clearing skills

---

## 📚 Collection Used

The main collection used in this project is:

```java
Set<Skill> skills = new LinkedHashSet<>();
```

### Why `Set`?

The requirement is that every skill should be unique.

For example:

```text
Java
Selenium
Java
SQL
Selenium
```

should result in:

```text
Java
Selenium
SQL
```

A `Set` is designed to store unique elements.

Unlike a `List`, a `Set` does not allow duplicate elements according to its
equality rules.

---

## 🔗 Why LinkedHashSet?

There are several common `Set` implementations:

| Collection | Duplicates | Insertion Order | Sorted |
|------------|------------|------------------|--------|
| `HashSet` | ❌ | ❌ | ❌ |
| `LinkedHashSet` | ❌ | ✅ | ❌ |
| `TreeSet` | ❌ | ❌ | ✅ |

The project uses `LinkedHashSet` because the requirement is:

> Store unique skills while preserving the order in which they were added.

For example, if skills are added in this order:

```text
Java
Selenium
SQL
Playwright
```

iteration over the `LinkedHashSet` preserves that insertion order.

---

## 🧠 Set vs List

One important concept learned in this project is choosing a Collection based on
the business requirement.

### List

A `List` allows duplicates and maintains an ordered sequence.

Example:

```text
Java
SQL
Java
Selenium
SQL
```

A `List` can contain all five elements.

### Set

A `Set` is useful when duplicate elements should not be stored.

Example:

```text
Java
SQL
Java
Selenium
SQL
```

becomes conceptually:

```text
Java
SQL
Selenium
```

Therefore:

```text
Need duplicates?
        ↓
      List

Need uniqueness?
        ↓
       Set
```

---

## 🟰 equals() and hashCode()

Since `Skill` is a custom object, Java needs to know when two `Skill` objects
should be considered equal.

The project defines equality using:

```text
Skill name + Skill category
```

For example:

```text
Java + Programming
Java + Programming
```

are considered equal.

But:

```text
Java + Programming
Java + Testing
```

are considered different.

The project overrides both:

```java
equals()
hashCode()
```

because hash-based collections such as `HashSet` and `LinkedHashSet` depend on
consistent equality and hashing behavior.

### Important Rule

> If two objects are equal according to `equals()`, they must have the same
> `hashCode()`.

However, the reverse is not necessarily true.

Two different objects can have the same hash code. This situation is called a
**hash collision**.

---

## 🔍 How Hash-Based Set Uniqueness Works

A simplified mental model of a hash-based collection is:

```text
Object
   ↓
hashCode()
   ↓
Find possible location
   ↓
equals()
   ↓
Confirm whether it is equal
   ↓
Already exists?
   ├── Yes → Do not add
   └── No  → Add
```

For example:

```java
Skill skill1 = new Skill("Java", "Programming");
Skill skill2 = new Skill("Java", "Programming");
```

Although `skill1` and `skill2` are two different objects, our equality rule
considers them logically equal.

Therefore:

```java
Set<Skill> skills = new LinkedHashSet<>();

skills.add(skill1);
skills.add(skill2);
```

results in only one stored skill.

---

## 🔄 Iterator

The project uses `Iterator` when removing skills based on their category.

Example:

```java
Iterator<Skill> iterator = skills.iterator();

while (iterator.hasNext()) {

    Skill skill = iterator.next();

    if (skill.getCategory().equalsIgnoreCase(category)) {
        iterator.remove();
    }
}
```

### Why use Iterator?

Directly modifying a collection while traversing it can cause:

```text
ConcurrentModificationException
```

Therefore, when removing the element currently being traversed, we use:

```java
iterator.remove();
```

The general flow is:

```text
Iterator
   ↓
hasNext()
   ↓
next()
   ↓
Check condition
   ↓
iterator.remove()
```

---

## 🧩 Set Operations Practiced

The project uses the following operations:

```java
add()
contains()
remove()
size()
isEmpty()
clear()
iterator()
```

### `add()`

Adds a skill if an equal skill does not already exist.

```java
skills.add(skill);
```

Returns:

```text
true  → skill was added
false → skill already existed
```

---

### `contains()`

Checks whether a skill exists.

```java
skills.contains(skill);
```

Returns:

```text
true  → skill exists
false → skill does not exist
```

---

### `remove()`

Removes a specific skill.

```java
skills.remove(skill);
```

Returns:

```text
true  → skill was removed
false → skill was not found
```

---

### `size()`

Returns the number of unique skills.

```java
skills.size();
```

---

### `isEmpty()`

Checks whether the Set contains any elements.

```java
skills.isEmpty();
```

Returns:

```text
true  → no skills exist
false → at least one skill exists
```

---

### `clear()`

Removes all skills.

```java
skills.clear();
```

After calling `clear()`, the Set contains no elements.

---

### `iterator()`

Allows the Set to be traversed.

```java
Iterator<Skill> iterator = skills.iterator();

while (iterator.hasNext()) {
    Skill skill = iterator.next();
}
```

---

## 🚫 No Index-Based Access

Unlike `List`, a `Set` does not provide index-based access.

For example:

```java
skills.get(0);
```

is invalid.

A `List` has positions:

```text
0 → Java
1 → SQL
2 → Selenium
```

A `Set` does not guarantee such indexes.

Instead, we iterate through its elements:

```java
for (Skill skill : skills) {
    System.out.println(skill);
}
```

---

## 🔄 HashSet vs LinkedHashSet

During the project, we also compared `HashSet` and `LinkedHashSet`.

### HashSet

Provides:

- Unique elements
- No guaranteed iteration order

Example:

```java
Set<Skill> skills = new HashSet<>();
```

The order in which elements are returned should not be relied upon.

---

### LinkedHashSet

Provides:

- Unique elements
- Insertion order

Example:

```java
Set<Skill> skills = new LinkedHashSet<>();
```

If elements are added as:

```text
Java
Selenium
SQL
Playwright
```

iteration preserves that insertion order.

---

## 🧱 Programming Against an Interface

The project declares the collection as:

```java
Set<Skill> skills = new LinkedHashSet<>();
```

rather than:

```java
LinkedHashSet<Skill> skills = new LinkedHashSet<>();
```

This is an example of programming against an interface.

The variable uses the general `Set` interface while the actual implementation is
`LinkedHashSet`.

This makes it easier to change the implementation later.

For example:

```java
Set<Skill> skills = new HashSet<>();
```

or:

```java
Set<Skill> skills = new LinkedHashSet<>();
```

The rest of the service can continue using common `Set` operations.

---

## 🖥️ Sample Usage

```text
==============================
     EMPLOYEE SKILL MANAGER
==============================
1. Add Skill
2. View Skills
3. Check Skill
4. Remove Skill
5. Remove Skills By Category
6. Clear Skills
7. Exit

Enter choice: 1

Enter skill name: Java
Enter category: Programming

Skill added successfully.
```

If the same skill is added again:

```text
Skill already exists.
```

---

## 🔄 Example Workflow

Suppose the following skills are added:

```text
Java       → Programming
Selenium   → Testing
SQL        → Database
Playwright → Testing
Postman    → Testing
```

The application stores:

```text
Java       → Programming
Selenium   → Testing
SQL        → Database
Playwright → Testing
Postman    → Testing
```

If the user tries to add:

```text
Java → Programming
```

again, the Set rejects the duplicate.

If the user chooses:

```text
Remove Skills By Category
```

and enters:

```text
Testing
```

the following skills are removed:

```text
Selenium
Playwright
Postman
```

The remaining skills are:

```text
Java       → Programming
SQL        → Database
```

---

## 🎯 What I Learned

Through this project, I learned:

- What a `Set` is
- Why `Set` is useful when uniqueness is required
- Difference between `List` and `Set`
- Difference between `HashSet` and `LinkedHashSet`
- How `LinkedHashSet` maintains insertion order
- How duplicate objects are detected
- Why `equals()` matters for custom objects
- Why `hashCode()` must be consistent with `equals()`
- How hash-based collections use hashing and equality
- How to use `add()`
- How to use `contains()`
- How to use `remove()`
- How to use `size()`
- How to use `isEmpty()`
- How to use `clear()`
- How to iterate over a Set
- Why Set does not provide index-based access
- How to safely remove elements using `Iterator`
- How to separate UI logic from business logic
- How to program against an interface
- How to choose a Collection based on business requirements

---

## 🧠 Key Takeaways

The main lessons from this project can be summarized as:

```text
Need unique elements?
        ↓
       Set
```

```text
Need unique elements
+
Need insertion order?
        ↓
  LinkedHashSet
```

```text
Custom objects in a hash-based Set?
        ↓
equals() + hashCode()
```

```text
Need to remove while iterating?
        ↓
Iterator.remove()
```

```text
Need index-based access?
        ↓
List
```

---

## 🏁 Conclusion

This project provided hands-on experience with the `Set` portion of the Java
Collection Framework.

The main focus was understanding how to maintain unique objects and how
different Set implementations provide different ordering guarantees.

The project specifically uses `LinkedHashSet` because it provides:

```text
Unique elements
+
Insertion order
```

The project also demonstrated why `equals()` and `hashCode()` are important
when storing custom objects in hash-based collections.
