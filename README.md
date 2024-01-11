Introduction

This project is a simple Snake Game implemented in Java. The game involves controlling a snake to eat food and grow longer while avoiding collisions with the snake's own body and the game boundaries. The project also includes a basic user authentication system and demonstrates the use of various object-oriented programming concepts such as classes, inheritance, polymorphism, encapsulation, abstraction, exception handling, file I/O, and more.


Classes & Objects:

Class: A class is a blueprint or a template for creating objects. It defines a set of attributes and methods that characterize any object created from that class.

The project is structured around several classes:

Game: Manages the game logic, user input, and runs the main game loop.
Snake: Represents the snake in the game, handling movement, growth, and direction changes.
Food: Represents the food that the snake tries to eat, generating it at random positions.
User: An abstract class representing a user, with subclasses RegisteredUser and UnregisteredUser.
Register: Manages user registration, loading, and saving user data to a file.
Login: Handles user login and authentication.

class Food {
    // ... (attributes and methods)
}

class Game extends JFrame {
    // ... (attributes and methods)
}

class Login {
    // ... (methods)
}

class Register {
    // ... (methods)
}

class RegisteredUser extends User {
    // ... (constructor and overridden method)
}

class Snake {
    // ... (attributes and methods)
}

class SnakeGame {
    // ... (main method)
}

class UnregisteredUser extends User {
    // ... (constructor and overridden method)
}

abstract class User {
    // ... (attributes, methods, and abstract method)
}


Object: An object is an instance of a class. 

Food food = new Food(width, height, "Red");
Game level1 = new Game(1, 20, 750, 20, 20);
Login login = new Login();
Register register = new Register();
RegisteredUser user = new RegisteredUser(tmpName, tmpPassword);
Snake snake = new Snake(30, "Green");
UnregisteredUser unregisteredUser = new UnregisteredUser(tmpName);



Inheritance Superclass/Subclass: 
The User class serves as a common base class for both registered and unregistered users. The subclasses RegisteredUser and UnregisteredUser extend User to inherit its common attributes and methods while providing their own specific implementations where necessary. This approach promotes code reuse and helps organize the code in a hierarchical and modular manner.

class RegisteredUser extends User {
    // ... (constructor and overridden method)
}

class UnregisteredUser extends User {
    // ... (constructor and overridden method)
}

Constructor:
In Java, when a subclass is created, it inherits the attributes and methods of its superclass. However, the constructor of the superclass is not automatically inherited by the subclass. This is because a constructor is a special type of method used to initialize the object's state, and it is not inherited like regular methods. Instead, the subclass needs to explicitly call one of the constructors of the superclass using the ‘super’ keyword.

In the User class, there is a constructor that takes two parameters (name and password) and initializes the corresponding fields of the class. Now, when you create subclasses like RegisteredUser and UnregisteredUser, you need to ensure that the superclass constructor is called.

Overloading Method: 
	In Java, method overloading is a feature that allows a class to have multiple methods with the same name, but with different parameter lists.

This is a parameterized constructor that takes two parameters (name and password) and initializes the corresponding fields of the User class.
Now, let's say you want to provide a way to create a User object without specifying a password. You can achieve this by overloading the constructor with a version that takes only the name parameter and sets the password to null. 


Overriding Method: 
By using overriding methods, Subclasses can provide specific implementations for methods defined in the superclass. This allows customization of behavior for specific subclasses while still maintaining a common interface defined by the superclass.

In the RegisteredUser class, the authenticate method is overridden using the @Override annotation. This annotation is not strictly necessary but is good practice to indicate to the compiler and other developers that the intention is to override a method from the superclass.
The overridden authenticate method in RegisteredUser has a specific implementation. It checks whether the provided name and password match any registered users in the system. If a match is found, it prints "Login successful!" and returns true; otherwise, it prints "Login failed!" and returns false.

When you have a RegisteredUser object and you call the authenticate method on it, the overridden method in RegisteredUser will be executed, providing a behavior specific to registered users.

Polymorphism Casting: 
Polymorphism is achieved through method overriding, for example, the toString and authenticate methods. In the User class, we have an abstract authenticate method and an overridden toString method. The RegisteredUser class extends User and provides specific implementations for the authenticate method.

RegisteredUser registeredUser = new RegisteredUser(tmpName, tmpPassword);
boolean result = registeredUser.authenticate();

Encapsulation Access Modifiers:
Access modifiers like public, private, protected, and default are used to control the visibility of fields and methods in different classes. These modifiers control which parts of a program can access a particular member, providing a mechanism for encapsulation.
Public:
Visibility: Public members are accessible from any other class.
Private:
Visibility: Private members are only accessible within the same class.
Protected:
Visibility: Protected members are accessible within the same class, its subclasses, and classes in the same package.
Default (Package-Private):

Visibility: If no access modifier is specified (default), the member is accessible only within the same package.
class Food {
    private int width;
    private int height;
    public int foodX;
    public int foodY;
    private String color;
    // ... (constructor and methods)
}

class Snake {
    private int[] snakeX;
    private int[] snakeY;
    private int length = 0;
    private char direction = 'd';
    private String color;
    // ... (constructor and methods)
}


Abstraction Abstract Class or Interface: 
The User class is an abstract class with abstract methods, and RegisteredUser provides concrete implementations. In this case, In the RegisteredUser class, we extend the abstract class User and provide concrete implementations for the abstract methods (authenticate and playGame). The constructor of the RegisteredUser class also calls the constructor of the superclass (super(name, password)).

abstract class User {
    protected String name;
    protected String password;

    public abstract boolean authenticate();
    // ... (other methods)
}

Exception Handling Handling Wrong Input Exceptions: 
The project includes basic exception handling for file I/O operations and user input.When working with file I/O operations, various exceptions can occur, such as FileNotFoundException, IOException, or SecurityException. It's important to handle these exceptions to prevent your program from crashing and to provide meaningful error messages to the user.
When dealing with user input, exceptions can be thrown if the input does not match the expected format or if an operation fails. Common exceptions for handling user input include NumberFormatException, InputMismatchException, or custom exceptions that you define.

class Register {
    // ... (other methods)

    private static void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            // ... (reading logic)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

File I/O Storing Information in a File: 
The Register class manages the loading and saving of user information to a file (users.txt). In Java, managing the loading and saving of information to a file involves using classes from the java.io package, such as File, FileReader, FileWriter, BufferedReader, and BufferedWriter. 

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


Anonymous Inner Class or Functional Interface / Lambda Expression Anonymous Inner Class:
Anonymous inner classes are often used when a short, one-time-use class is needed, such as for event handling or implementing interfaces with a small number of methods.The KeyListener in the Game class is implemented using an anonymous inner class.

class Game extends JFrame {
    addKeyListener(new KeyListener() {
        @Override
        public void keyPressed(KeyEvent e) {
            // ... (keyPressed logic)
        }
        // ... (other KeyListener methods)
    });
}

Static Method At Least 1 Static Method: 
They can be called on the class itself, without the need to create an instance of the class. Static methods are often used for utility functions, operations that are not dependent on instance-specific data, or for providing common functionality that should be shared among all instances of the class. The Register class contains static methods for loading and saving users.
loadUsers and saveUsers are static methods in the Register class.
They are static because they are associated with the class itself, not with instances of the class. This means you can call these methods using Register.loadUsers() and Register.saveUsers(users) without creating an instance of Register.


class Login {
    private static List<RegisteredUser> users = Register.getUsers();
    // ... (methods)
}

How to Play Run the SnakeGame class. Choose to register, login, or play as an unregistered user.
Enjoy playing the Snake Game!

