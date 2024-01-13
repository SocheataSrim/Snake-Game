# Snake Game

## Table of Content

- [Introduction](#introduction)
- [Classes & Objects](#classes--objects)
- [Inheritance](#inheritance)
- [Polymorphism](#polymorphism)
- [Encapsulation](#encapsulation)
- [Abstraction](#abstraction)
- [Exception Handling](#exception-handling)
- [File I/O](#file-io)
- [Anonymous Inner Class](#anonymous-inner-class)
- [Static Method](#static-method)
- [How to Play?](#how-to-play)

## Introduction

This project is a simple Snake Game implemented in Java. The game involves controlling a snake to eat food and grow longer while avoiding collisions with the snake's own body and the game boundaries. The project also includes a basic user authentication system and demonstrates the use of various object-oriented programming concepts such as classes, inheritance, polymorphism, encapsulation, abstraction, exception handling, file I/O, and more.

## Object-Oriented Programming Concept

### Classes & Objects:

Class: A class is a blueprint or a template for creating objects. It defines a set of attributes and methods that characterize any object created from that class.

The project is structured around 9 classes:

- Game: Manages the game logic, movement input, and handle the game loop for each level.
- Snake: Represents the snake in the game, handling movement, growth, and direction changes.
- Food: Represents the food that the snake tries to eat, generating it at random positions.
- User: An abstract class representing a user, with subclasses RegisteredUser and UnregisteredUser.
- RegisteredUser: Inherits from User and adds methods for logging in as a registered user with some additional perks to the game
- UnregisteredUser: Inherits from User and adds methods for logging in as a guest.
- Register: Manages user registration, loading, and saving user data to a file.
- Login: Handles user login and authentication.
- SnakeGame: Run the snake game program

### Inheritance:

#### Superclass/Subclass:

The User class serves as a super class for both registered and unregistered users. The subclasses RegisteredUser and UnregisteredUser extend User to inherit its common attributes and methods while providing their own specific implementations. We use this approach because both registered and unregistered user are still considered as user. It is just that unregistered user or guest just required a player name as input. Additionally, it promoted code reusablity as we can use the methods in the User class.

#### Constructor:

In Java, when a subclass is created, it inherits the attributes and methods of its superclass. However, the constructor of the superclass is not automatically inherited by the subclass. This is because a constructor is a special type of method used to initialize the object's state, and it is not inherited like regular methods. Instead, the subclass needs to explicitly call one of the constructors of the superclass using the ‘super’ keyword.

In the User class, there is a constructor that takes two parameters (name and password) and initializes the corresponding fields of the class. Now, when you create subclasses like RegisteredUser and UnregisteredUser, you will need to ensure that the superclass constructor is called.

#### Overriding Method:

By using overriding methods, Subclasses can provide specific implementations for methods defined in the superclass. This allows customization of behavior for specific subclasses while still maintaining a common interface defined by the superclass.

In the RegisteredUser class, the authenticate method is overridden using the @Override annotation. The overridden authenticate method in RegisteredUser has a specific implementation. It checks whether the provided name and password match any registered users in the system. If a match is found, it prints "Login successful!" and returns true; otherwise, it prints "Login failed!" and returns false.

When you have a RegisteredUser object and you call the authenticate method on it, the overridden method in RegisteredUser will be executed, providing a behavior specific to registered users.

### Polymorphism:

Polymorphism is refered to the concept of a function or method that can work with different types of data and objects. In the User class, we have an abstract authenticate method and an overridden toString method. The RegisteredUser class extends User and provides specific implementations for the authenticate method.

- Example:

  ```java
  RegisteredUser registeredUser = new RegisteredUser(tmpName, tmpPassword);
  boolean result = registeredUser.authenticate();

  UnregisteredUser unregisteredUser = new UnregisteredUser(tmpName);
  boolean result = unregisteredUser.authenticate();
  ```

### Encapsulation:

All of our attributes in each classes are ** Private ** as they are the properties belonging to their respective class and we don't want them to be modify from other class. We mostly want to get their value to use for the game logic only and we can achieve that using the getter methods.

### Abstraction:

The User class is an abstract class with abstract methods, and RegisteredUser provides concrete implementations. In this case, in the RegisteredUser class, we extend the abstract class User and provide concrete implementations for the abstract methods (authenticate and playGame). The constructor of the RegisteredUser class also calls the constructor of the superclass (super(name, password)).

- Example:

  ```java
  // Abstraction in User.java

  abstract class User {
      private String name;
      private String password;

      public abstract boolean authenticate();
  }
  ```

  ```java
  // Implement the authenticate method in RegisteredUser.java

  class RegisteredUser extends User {
      public RegisteredUser(String name, String password) {
          super(name, password);
      }

      @Override
      public boolean authenticate() {
          List<RegisteredUser> users = Register.getUsers();
          for (RegisteredUser registeredUser : users) {
              if (registeredUser.getName().equals(getName()) && registeredUser.getPassword().equals(getPassword())) {
                  System.out.println("Login successful!");
                  return true;
              }
          }
          System.out.println("Login failed!");
          return false;
      }
  }
  ```

### Exception Handling:

The project includes basic exception handling for file I/O operations and user input. When working with file I/O operations, various exceptions can occur, such as FileNotFoundException, IOException, or SecurityException. It's important to handle these exceptions to prevent your program from crashing and to provide meaningful error messages to the user.

- File Not Found (IOException):

  - Purpose:
    - Handles situations where the specified file path is incorrect or the file is not found.
    - Prevents the application from crashing and provides an error message.
  - Example:

    ```java
    // Exception handling for file not found in Register.java

    private static void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            // ... (reading logic)
        } catch (IOException e) {
            System.out.println(FILE_PATH + " does't exist.");
        }
    }
    ```

When dealing with user input, exceptions can be thrown if the input does not match the expected format or if an operation fails. Common exceptions for handling user input include NumberFormatException, InputMismatchException, or custom exceptions that you define.

- Wrong Input Data Type (NumberFormatException):

  - Purpose:
    - Catches errors when users enter non-numeric data that needs to be converted to a number.
    - Informs users of the mistake, clears input fields, and avoids program crashes.
  - Example:

    ```java
    // Exception handling for wrong input data type in SnakeGame.java

    // Print out the registration/login screen
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Play as Unregistered User");
        System.out.println("4. Quit");

        // Input error handling
        while (true) {
            try {
                System.out.print("Enter your option (1 - 4): ");
                choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.nextLine();
            }
        }
    ```

### File I/O:

The Register class manages the loading and saving of user information to a file (users.txt). In Java, managing the loading and saving of information to a file involves using classes from the java.io package, such as File, FileReader, FileWriter, BufferedReader, and BufferedWriter.

- Example:

  ```java

  class Register {
      private static final String FILE_PATH = "users.txt";

      private static void saveUsers() {
          try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
              // ... (writing logic)
          } catch (IOException e) {
              e.printStackTrace();
          }
      }

  }
  ```

### Anonymous Inner Class:

Anonymous inner classes are often used when a short, one-time-use class is needed, such as for event handling or implementing interfaces with a small number of methods.The KeyListener in the Game class is implemented using an anonymous inner class.

- Example:
  ```java
  class Game extends JFrame {
      addKeyListener(new KeyListener() {
          @Override
          public void keyPressed(KeyEvent e) {
          // ... (keyPressed logic)
          }
          // ... (other KeyListener methods)
      });
  }
  ```

### Static Method:

They can be called on the class itself, without the need to create an instance of the class. Static methods are often used for utility functions, operations that are not dependent on instance-specific data, or for providing common functionality that should be shared among all instances of the class. The Register class contains static methods for loading and saving users.
loadUsers and saveUsers are static methods in the Register class.
They are static because they are associated with the class itself, not with instances of the class. This means you can call these methods using Register.loadUsers() and Register.saveUsers(users) without creating an instance of Register.

- Example:
  ```java
  class Login {
      private static List<RegisteredUser> users = Register.getUsers();
      // ... (methods)
  }
  ```

## How to Play?

Run the SnakeGame class. Choose to register, login, or play as an unregistered user. Enjoy playing the Snake Game!
