import java.util.Scanner;

// Class to represent a book
class Book {
    String title;
    String author;
    int year;

    // Constructor
    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

// Class to manage library operations
public class LibraryManagementSystem {
    static final int MAX_BOOKS = 100;
    static Book[] library = new Book[MAX_BOOKS];
    static int bookCount = 0;

    // Method to add book information
    static void addBook(String title, String author, int year) {
        if (bookCount < MAX_BOOKS) {
            library[bookCount] = new Book(title, author, year);
            bookCount++;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Method to display all books in the library
    static void displayBooks() {
        System.out.println("Books in the library:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". Title: " + library[i].title + ", Author: " + library[i].author + ", Year: " + library[i].year);
        }
    }

    // Method to list all books of a given author
    static void listBooksByAuthor(String author) { //lol
        System.out.println("Books by " + author + ":");
        for (int i = 0; i < bookCount; i++) {
            if (library[i].author.equals(author)) {
                System.out.println("- " + library[i].title);
            }
        }
    }

    // Method to list the count of books in the library
    static void countBooks() {
        System.out.println("Total books in the library: " + bookCount);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String author;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add book information");
            System.out.println("2. Display book information");
            System.out.println("3. List all books of a given author");
            System.out.println("4. List count of books in the library");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    scanner.nextLine(); // Consume newline character
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    addBook(title, authorName, year);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    System.out.print("Enter author name: ");
                    scanner.nextLine(); // Consume newline character
                    author = scanner.nextLine();
                    listBooksByAuthor(author);
                    break;
                case 4:
                    countBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
