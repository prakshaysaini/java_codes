import java.util.*;

class Book {
    int bookid;
    String booktitle;
    int yop;
    String autname;
    String pubname;
    int avcopies;
    int totcopies;

    public Book() {
    }

    public void setDetails(int id, String title, int year, String aut, String pub, int count) {
        this.bookid = id;
        this.booktitle = title;
        this.yop = year;
        this.autname = aut;
        this.pubname = pub;
        this.avcopies = count;
        this.totcopies = count;
    }

    public void getDetails() {
        System.out.println("Book ID: " + this.bookid);
        System.out.println("Book Title: " + this.booktitle);
        System.out.println("Year of Publication: " + this.yop);
        System.out.println("Author Name: " + this.autname);
        System.out.println("Publisher Name: " + this.pubname);
        System.out.println("Available Copies: " + this.avcopies);
        System.out.println("Total Copies: " + this.totcopies);
    }

    public void issue() {
        if (this.avcopies > 0) {
            this.avcopies--;
            System.out.println("Book issued successfully.");
    System.out.println("No of total copies."+this.totcopies);
    System.out.println("No of available copies."+this.avcopies);
        } else {
            System.out.println("Book not available for issuing.");
        }
    }

    public void retur() {
        this.avcopies++;
        System.out.println("Book returned successfully.");
  System.out.println("No of total copies."+this.totcopies);
  System.out.println("No of available copies."+this.avcopies);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int no = sc.nextInt();
        sc.nextLine(); 

        Book[] arr = new Book[no];
        for (int i = 0; i < no; i++) {
            arr[i] = new Book(); 
        }

        int choice, j = 0;
        int id, year, cop;
        String title, aut, pub;

        do {
            System.out.println("1. Set book details");
            System.out.println("2. Get book details");
            System.out.println("3. Issue book");
            System.out.println("4. Return book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    if (j < no) {
                        System.out.print("Enter Book Id: ");
                        id = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Enter Book Title: ");
                        title = sc.nextLine();
                        System.out.print("Enter Year of Publication: ");
                        year = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Enter Author Name: ");
                        aut = sc.nextLine();
                        System.out.print("Enter Publisher Name: ");
                        pub = sc.nextLine();
                        System.out.print("Enter Number of Copies: ");
                        cop = sc.nextInt();
                        sc.nextLine(); 
                        arr[j].setDetails(id, title, year, aut, pub, cop);
                        j++;
                    } else {
                        System.out.println("Library is full.");
                    }
                    break;
case 2:
                    System.out.print("Enter book ID: ");
                    id = sc.nextInt();
                    sc.nextLine(); 
                    boolean found = false;
                    for (int i = 0; i < no; i++) {
                        if (arr[i].bookid == id) {
                            arr[i].getDetails();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter book ID: ");
                    id = sc.nextInt();
                    sc.nextLine(); 
                    found = false;
                    for (int i = 0; i < no; i++) {
                        if (arr[i].bookid == id) {
                            arr[i].issue();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter book ID: ");
                    id = sc.nextInt();
                    sc.nextLine(); 
                    found = false;
                    for (int i = 0; i < no; i++) {
                        if (arr[i].bookid == id) {
                            arr[i].retur();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}