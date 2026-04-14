# Spring 2026 Lab 12: APIs

See the handout at https://github.com/CMU-17-214/s2026/blob/main/labs/lab12.md.

## API Design Flows

### `DirManager`

Primary flows identified:
- **Fail fast (Q4)**: Users can easily ignore the return value, leading to silent failures.
    - `manager.newDir("test")` returns -1 on failure, but users might not check this value, causing silent errors.
- **APIs should be discoverable (U7)**: Users must consult documentation to learn what -1 and -2 mean. Exception types are self-documenting.

Optimized API design:

Explicitly throwing exceptions for error cases improves discoverability and encourages users to handle errors properly.
```java
public void newDirectory(String path) throws DirectoryExistsException, InvalidPathException {
    if (dirOps.checkDirectoryExists(path)) {
        throw new DirectoryExistsException(path);
    } else if (!dirOps.checkPathValid(path)) {
        throw new InvalidPathException(path);
    } else {
        dirOps.createDirectory(path);
    }
}
```

### `getBooks` method in `LibararyAccount`

Primary flows identified: there is no **input validation**, which violates the principle of **fail fast (Q4)** and **handle boundary conditions (Q5)**. For example:
- What if the provided ``userId` is `null` or empty?
- What if there is no colon `:` in the `userId` string?
- What if there are multiple colons `:` in the `userId` string?
- What if the extracted parameters `name` and `id` are empty or invalid?

Optimized API design:
Explicitly validating the input and throwing exceptions for invalid cases ensures that errors are caught early and provides clear feedback to users about what went wrong.
```java
public Book[] getBooks(String userId) {
    if (userId == null) {
        throw new IllegalArgumentException("User ID cannot be null");
    }
    
    String[] parts = userId.split(":", 2);
    if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
        throw new IllegalArgumentException(
            "User ID must be in format 'libraryID:userName', got: " + userId);
    }
    
    String libraryId = parts[0];
    String userName = parts[1];
    return libraryService.getBooks(userName, libraryId);        
}
```


### `Weather` class

Primary flows identified: the boolean parameter `inches` is not self-explanatory, which violates the principle of **APIs should be discoverable (U7)**.
- What does `inches` represent? What does it mean when it's `true` or `false`? 

Optimized API design:
Using an enum to represent the length scale makes the API more self-explanatory and discoverable, as users can easily understand the available options without needing to refer to documentation.
```java
public enum LengthScale {
    INCHES,
    MILLIMETERS
}

// In Weather class
public void setLengthScale(LengthScale lengthScale) {
    this.lengthScale = lengthScale;
}
```