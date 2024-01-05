Introduction

This project is a simple Snake Game implemented in Java. The game involves controlling a snake to eat food and grow longer while avoiding collisions with the snake's own body and the game boundaries. The project also includes a basic user authentication system and demonstrates the use of various object-oriented programming concepts such as classes, inheritance, polymorphism, encapsulation, abstraction, exception handling, file I/O, and more.

Classes & Objects
The project is structured around several classes:

Game: 
Manages the game logic, user input, and runs the main game loop.

Snake:
Represents the snake in the game, handling movement, growth, and direction changes.

Food:
Represents the food that the snake tries to eat, generating it at random positions.

User:
An abstract class representing a user, with subclasses RegisteredUser and UnregisteredUser.

Register: 
Manages user registration, loading, and saving user data to a file.

Login:
Handles user login and authentication.

Inheritance
Superclass/Subclass: The User class is the superclass, and RegisteredUser and UnregisteredUser are subclasses inheriting from it.
Constructor: Inherited constructors are used to initialize the superclass attributes.
Overloading Method: The User class has overloaded constructors.
Overriding Method: The RegisteredUser class overrides the authenticate method.

Polymorphism
Casting: Polymorphism is achieved through method overriding, for example, the toString and authenticate methods.

Encapsulation
Access Modifiers: Access modifiers like public, private, protected, and default are used to control the visibility of fields and methods in different classes.

Abstraction
Abstract Class or Interface: The User class is an abstract class with abstract methods, and RegisteredUser provides concrete implementations.

Exception Handling
Handling Wrong Input Exceptions: The project includes basic exception handling for file I/O operations and user input.

File I/O
Storing Information in a File: The Register class manages the loading and saving of user information to a file (users.txt).

Anonymous Inner Class or Functional Interface / Lambda Expression
Anonymous Inner Class: The KeyListener in the Game class is implemented using an anonymous inner class.

Static Method
At Least 1 Static Method: The Register class contains static methods for loading and saving users.

How to Play
Run the SnakeGame class.
Choose to register, login, or play as an unregistered user.

Enjoy playing the Snake Game!
