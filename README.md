# Library Management System using Java

The Library Management System is a console-based Java application developed using Object-Oriented Programming (OOP) concepts. This project is designed to manage books, members, and library transactions such as borrowing and returning books using a simple menu-driven interface. It is suitable for B.Tech academic submission, internship evaluation, and Java OOP practice.

The system allows managing books with details such as ISBN, title, author, genre, and availability status. Members can borrow available books, return borrowed books, and search books by title or author. Proper validation is implemented to ensure that a book cannot be borrowed if it is already issued.

This project is developed using Java language and core OOP principles including classes, objects, encapsulation, and collections. ArrayList is used to store book and member data, and Scanner is used for handling user input. The application runs completely in a console environment.

To run the project, install Java JDK (version 8 or above) on your system. Save the main file as LibraryManagementSystem.java. Compile the program using the command javac LibraryManagementSystem.java and run it using java LibraryManagementSystem.

The major features of this system include book management, member management, searching books by title or author, borrowing and returning books with availability validation, and a menu-driven interface. Getters and setters are used to maintain proper encapsulation and data security.

Sample Output:
===== LIBRARY MENU =====
1. View All Books
2. Search Book
3. Borrow Book
4. Return Book
5. Exit

Enter choice: 3  
Enter Member ID: M1  
Enter Book ISBN: 101  
Book borrowed successfully!

During the development of this project, challenges such as managing interaction between multiple classes, maintaining book availability, and designing a user-friendly menu were faced. This project helped in improving understanding of Java OOP concepts, collections framework, and real-world application logic.

This system can be further enhanced by adding file handling or database integration for permanent storage and by implementing a graphical user interface using JavaFX or Swing.

Author: Rohan kumar  
Course: B.Tech (3nd Year)

This project is developed for educational and internship purposes only.
