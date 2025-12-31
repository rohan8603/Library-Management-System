import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String isbn, String title, String author, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void displayInfo() {
        System.out.println("ISBN   : " + isbn);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Genre  : " + genre);
        System.out.println("Status : " + (isAvailable ? "Available" : "Borrowed"));
        System.out.println("----------------------------------");
    }
}

class Member {
    private String memberId;
    private String name;
    private String contact;
    private ArrayList<Book> borrowedBooks;

    public Member(String memberId, String name, String contact) {
        this.memberId = memberId;
        this.name = name;
        this.contact = contact;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() { return memberId; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    public boolean borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            return true;
        }
        return false;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }

    public void searchBooks(String keyword) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                book.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching books found!");
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book book : books) {
            book.displayInfo();
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Sample Data
        library.addBook(new Book("101", "Java Basics", "James Gosling", "Programming"));
        library.addBook(new Book("102", "Python Guide", "Guido van Rossum", "Programming"));
        library.addMember(new Member("M1", "Rohan", "9999999999"));

        int choice;
        do {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;

                case 2:
                    System.out.print("Enter title/author keyword: ");
                    String keyword = sc.nextLine();
                    library.searchBooks(keyword);
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    String mid = sc.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String bisbn = sc.nextLine();

                    Member member = library.findMemberById(mid);
                    Book book = library.findBookByIsbn(bisbn);

                    if (member != null && book != null) {
                        if (member.borrowBook(book)) {
                            System.out.println("Book borrowed successfully!");
                        } else {
                            System.out.println("Book not available!");
                        }
                    } else {
                        System.out.println("Invalid member or book!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    mid = sc.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    bisbn = sc.nextLine();

                    member = library.findMemberById(mid);
                    book = library.findBookByIsbn(bisbn);

                    if (member != null && book != null) {
                        if (member.returnBook(book)) {
                            System.out.println("Book returned successfully!");
                        } else {
                            System.out.println("This book was not borrowed!");
                        }
                    } else {
                        System.out.println("Invalid member or book!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Library System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
