# Inventory & Product Catalog

A console-based Java application for managing products in an inventory.

This project is part of a practical learning series focused on understanding
the Java Collection Framework through hands-on projects.

---

## 📌 Project Overview

The Inventory & Product Catalog allows users to manage product records through
a simple console-based menu.

The application supports basic inventory operations such as:

- Add a product
- View all products
- Find a product by ID
- Update product details
- Delete a product
- Remove products below a specific price
- Calculate total inventory value

The main focus of this project is understanding how and why a `Map`, especially
`HashMap`, can be used to model real-world data.

---

## 🚀 Features

- Add products
- Prevent duplicate Product IDs
- Find products using Product ID
- Update product details
- Delete products
- Remove products below a specified price
- Calculate total inventory value
- Display all products
- Handle invalid numeric input

---

## 🛠️ Technologies Used

- Java
- Java Collection Framework
- Map
- HashMap
- Iterator
- Map.Entry
- Scanner

---

## 📂 Project Structure

```text
inventoryproductcatalog/
│
├── Product.java
├── InventoryService.java
├── InventoryManager.java
└── InventoryServiceTest.java
```

### Product.java

Represents a single product.

Contains:

- Product ID
- Product name
- Product category
- Product price

Also provides getters, setters and a `toString()` implementation.

### InventoryService.java

Contains the main business logic of the application.

It manages the product collection and provides operations for:

- Adding products
- Finding products
- Updating products
- Removing products
- Displaying products
- Removing products based on price
- Calculating total inventory value

### InventoryManager.java

Acts as the console-based user interface.

Responsibilities include:

- Displaying the menu
- Reading user input
- Calling service methods
- Displaying results

### InventoryServiceTest.java

Used to manually test the inventory service and verify the behavior of the
`HashMap` operations.

---

# 🗺️ Why Map?

The main requirement of this application is:

> Find a Product using its Product ID.

This naturally represents a key-value relationship:

```text
Product ID → Product
```

For example:

```text
101 → MacBook Air
102 → Logitech Mouse
103 → Dell Monitor
```

Therefore, a `Map` is more suitable than a `List` for this particular
requirement.

Instead of searching through every product to find a specific ID, the ID can
be used directly as the key.

---

# 🧩 Collection Used

The main collection used in this project is:

```java
Map<Integer, Product> products = new HashMap<>();
```

Here:

```text
Integer → Key
Product → Value
```

So the data is represented as:

```text
Product ID → Product Object
```

---

# 🔥 Why HashMap?

`HashMap` was chosen because the application primarily requires:

- Key-based lookup
- Unique Product IDs
- Adding products
- Removing products
- No requirement for insertion order
- No requirement for sorted Product IDs

Therefore:

```java
Map<Integer, Product> products = new HashMap<>();
```

is a natural choice.

---

# ⚖️ HashMap vs LinkedHashMap vs TreeMap

Java provides multiple implementations of the `Map` interface.

### HashMap

```text
General-purpose Map
No guaranteed iteration order
```

Used in this project.

### LinkedHashMap

```text
Maintains insertion order
```

Would be useful if the inventory needed to display products in the same order
in which they were added.

### TreeMap

```text
Maintains keys in sorted order
```

Would be useful if the inventory needed Product IDs to always appear in
sorted order.

### Decision

```text
Need key → value lookup
        ↓
      Map

No insertion-order requirement
        ↓
    Not LinkedHashMap

No sorted-key requirement
        ↓
     Not TreeMap

        ↓
     HashMap
```

---

# 📚 Map Operations Practiced

## `put()`

Adds a key-value pair:

```java
products.put(product.getId(), product);
```

If the key already exists, `HashMap` replaces the old value.

Because our business rule does not allow duplicate Product IDs, the application
checks `containsKey()` before calling `put()`.

---

## `get()`

Finds a value using its key:

```java
Product product = products.get(productId);
```

For example:

```text
get(101)
    ↓
Product associated with 101
```

If the key does not exist, `get()` returns `null`.

---

## `containsKey()`

Checks whether a Product ID already exists:

```java
products.containsKey(productId);
```

This is used to prevent duplicate Product IDs.

---

## `remove()`

Removes a product using its Product ID:

```java
products.remove(productId);
```

---

## `size()`

Returns the number of key-value pairs in the Map:

```java
products.size();
```

---

## `isEmpty()`

Checks whether the inventory contains any products:

```java
products.isEmpty();
```

---

## `clear()`

Removes all entries from the Map:

```java
products.clear();
```

---

# 🔄 Map Views

A Map provides three important views of its contents:

```text
Map
│
├── keySet()
│      ↓
│     Keys
│
├── values()
│      ↓
│     Values
│
└── entrySet()
       ↓
     Key + Value
```

---

## `keySet()`

Used when only the keys are required.

```java
for (Integer productId : products.keySet()) {
    System.out.println(productId);
}
```

Example:

```text
101
102
103
```

---

## `values()`

Used when only the Product objects are required.

```java
for (Product product : products.values()) {
    System.out.println(product);
}
```

This was also used to calculate the total inventory value.

```java
double total = 0;

for (Product product : products.values()) {
    total += product.getPrice();
}
```

---

## `entrySet()`

Used when both the key and value are required.

```java
for (Map.Entry<Integer, Product> entry : products.entrySet()) {

    System.out.println(
        entry.getKey() + " → " + entry.getValue()
    );
}
```

---

# 🧩 Map.Entry

A `Map.Entry` represents one key-value pair.

For example:

```text
101 → MacBook Air
```

can be represented as:

```java
Map.Entry<Integer, Product>
```

The key can be retrieved using:

```java
entry.getKey();
```

and the value using:

```java
entry.getValue();
```

---

# 🔁 Iterator

The project also demonstrates using an `Iterator` with a Map.

A Map itself does not directly provide an `iterator()` because `Map` is not a
subtype of `Collection`.

Instead, we obtain an Iterator from a Map view such as `entrySet()`:

```java
Iterator<Map.Entry<Integer, Product>> iterator =
        products.entrySet().iterator();
```

Then:

```java
while (iterator.hasNext()) {

    Map.Entry<Integer, Product> entry = iterator.next();

    // process entry
}
```

---

# 🗑️ Safe Removal During Iteration

The project uses `Iterator.remove()` when removing products while traversing
the Map.

For example, products below a certain price can be removed safely:

```java
Iterator<Map.Entry<Integer, Product>> iterator =
        products.entrySet().iterator();

while (iterator.hasNext()) {

    Map.Entry<Integer, Product> entry = iterator.next();

    if (entry.getValue().getPrice() < price) {
        iterator.remove();
    }
}
```

Directly modifying the Map while iterating can result in
`ConcurrentModificationException`.

Using `Iterator.remove()` provides the appropriate way to remove the current
entry during iteration.

---

# 🧠 Important Concepts Learned

Through this project, I learned:

- What a `Map` represents
- Difference between `Map` and `Collection`
- Key-value relationships
- Why Map keys must be unique
- How `HashMap` handles duplicate keys
- `put()`
- `get()`
- `containsKey()`
- `remove()`
- `keySet()`
- `values()`
- `entrySet()`
- `Map.Entry`
- Iterating over a Map
- Using `Iterator` with `entrySet()`
- Safe removal using `Iterator.remove()`
- Difference between `HashMap`, `LinkedHashMap`, and `TreeMap`
- `HashMap` null-key and null-value behavior
- Wrapper classes such as `Integer`
- Autoboxing and unboxing
- Using `final` references
- Separating UI logic from business logic

---

# 🏗️ Application Design

The application follows a simple separation of responsibilities:

```text
User
 │
 ▼
InventoryManager
 │
 │  User interaction
 ▼
InventoryService
 │
 │  Business logic
 ▼
HashMap<Integer, Product>
 │
 ▼
Product
```

This keeps the Collection implementation inside the service layer rather than
mixing it with console/UI code.

---

# 🧪 Example

```text
================================
      INVENTORY MANAGEMENT
================================
1. Add Product
2. View Products
3. Find Product
4. Update Product
5. Delete Product
6. Remove Products Below Price
7. Calculate Total Inventory Value
8. Exit
```

Example product:

```text
101 | MacBook Air | Laptop | ₹85000
```

Finding the product:

```text
Enter Product ID: 101

Product found:
101 | MacBook Air | Laptop | ₹85000
```

---

# 🎯 Key Learning

The main lesson from this project is:

> **Choose a Collection based on the problem you are solving, not simply based
> on the Collection you know.**

For this project, the requirement:

```text
Product ID → Product
```

naturally led to:

```text
Map
 ↓
HashMap
```

If the requirement instead required only unique elements, a `Set` would be a
better choice.

If insertion order were important, `LinkedHashMap` could be considered.

If sorted keys were required, `TreeMap` could be considered.

---

# 🏁 Conclusion

This project provided hands-on experience with the `Map` portion of the Java
Collection Framework.

The focus was not only on learning `HashMap` syntax, but on understanding:

- Why a Map fits the problem
- How key-based lookup works
- How different Map views work
- How to iterate over Map entries
- How to safely remove entries during iteration
- How different Map implementations solve different requirements

The next projects will continue exploring other parts of the Java Collection
Framework through practical applications.