import java.util.Scanner;

class Book {
    int bookId;
    String bookTitle;
    int yearOfPublication;
    String authorName;
    String publisherName;
    int numberOfAvailableCopies;
    int totalCopies;

    Book() {
        this.bookId = 0;
        this.bookTitle = "";
        this.yearOfPublication = 0;
        this.authorName = "";
        this.publisherName = "";
        this.numberOfAvailableCopies = 0;
        this.totalCopies = 0;
    }

    Book(int totalCopies) {
        this.totalCopies = totalCopies;
        this.numberOfAvailableCopies = totalCopies;
    }

    void setDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        this.bookId = scanner.nextInt();
        System.out.print("Enter book title: ");
        this.bookTitle = scanner.next();
        System.out.print("Enter year of publication: ");
        this.yearOfPublication = scanner.nextInt();
        System.out.print("Enter author name: ");
        this.authorName = scanner.next();
        System.out.print("Enter publisher name: ");
        this.publisherName = scanner.next();
        System.out.print("Enter total copies: ");
        this.totalCopies = scanner.nextInt();
        this.numberOfAvailableCopies = this.totalCopies;
    }

    void setDetails(int id, String title, int year, String author, String publisher, int count) {
        this.bookId = id;
        this.bookTitle = title;
        this.yearOfPublication = year;
        this.authorName = author;
        this.publisherName = publisher;
        this.totalCopies = count;
        this.numberOfAvailableCopies = count;
    }

    void getDetails(int id) {
        if (this.bookId == id) {
            System.out.println("Book ID: " + this.bookId);
            System.out.println("Book Title: " + this.bookTitle);
            System.out.println("Year of Publication: " + this.yearOfPublication);
            System.out.println("Author Name: " + this.authorName);
            System.out.println("Publisher Name: " + this.publisherName);
            System.out.println("Total Copies: " + this.totalCopies);
            System.out.println("Available Copies: " + this.numberOfAvailableCopies);
        } else {
            System.out.println("Book not found.");
        }
    }

    void issue(int id) {
        if (this.bookId == id && this.numberOfAvailableCopies > 0) {
            this.numberOfAvailableCopies--;
            System.out.println("Book issued successfully.");
        } else if (this.bookId == id && this.numberOfAvailableCopies == 0) {
            System.out.println("Not available.");
        } else {
            System.out.println("Book not found.");
        }
    }

    void returnBook(int id) {
        if (this.bookId == id) {
            this.numberOfAvailableCopies++;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = scanner.nextInt();
        Book[] bookArray = new Book[n];

        for (int i = 0; i < n; i++) {
            bookArray[i] = new Book();
            bookArray[i].setDetails();
        }

        int choice;
        do {
            System.out.println("1. Set book details");
            System.out.println("2. Get book details");
            System.out.println("3. Issue book");
            System.out.println("4. Return book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
switch (choice) {
                case 1:
                    for (int i = 0; i < bookArray.length; i++) {
                        bookArray[i].setDetails();
                    }
                    break;
                case 2:
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    for (int i = 0; i < bookArray.length; i++) {
                        bookArray[i].getDetails(id);
                    }
                    break;
                case 3:
                    System.out.print("Enter book ID: ");
                    int issueId = scanner.nextInt();
                    for (int i = 0; i < bookArray.length; i++) {
                        bookArray[i].issue(issueId);
                    }
                    break;
                case 4:
                    System.out.print("Enter book ID: ");
                    int returnId = scanner.nextInt();
                    for (int i = 0; i < bookArray.length; i++) {
                        bookArray[i].returnBook(returnId);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        scanner.close();
    }
}