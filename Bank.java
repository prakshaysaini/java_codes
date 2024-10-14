import java.util.Scanner;

class Account {
    int accountNumber;
    String accountType;
    String serviceBranchIFSC;
    float minimumBalance;
    float availableBalance;
    int customerID;
    String customerName;
    static int totalAccountCreated = 0;
    int year;
    Scanner scanner = new Scanner(System.in);

    Account() {}

    public void setDetails() {
        System.out.print("Enter account number: ");
        this.accountNumber = scanner.nextInt();
        scanner.nextLine();   

        System.out.print("Enter account type: ");
        this.accountType = scanner.nextLine();

        System.out.print("Enter Service Branch IFSC: ");
        this.serviceBranchIFSC = scanner.nextLine();

        System.out.print("Enter minimum balance: ");
        this.minimumBalance = scanner.nextFloat();

        System.out.print("Enter available balance: ");
        this.availableBalance = scanner.nextFloat();

        System.out.print("Enter customer ID: ");
        this.customerID = scanner.nextInt();
        scanner.nextLine();   

        System.out.print("Enter customer name: ");
        this.customerName = scanner.nextLine();

	System.out.print("Enter year of creation:  ");
        this.year = scanner.nextInt();

        totalAccountCreated++;
    }

    public void getDetails() {
        System.out.println("Account number: " + this.accountNumber);
        System.out.println("Account Type: " + this.accountType);
        System.out.println("Service branch IFSC: " + this.serviceBranchIFSC);
        System.out.println("Minimum Balance: " + this.minimumBalance);
        System.out.println("Available Balance: " + this.availableBalance);
        System.out.println("Customer ID: " + this.customerID);
        System.out.println("Customer Name: " + this.customerName);
	System.out.println("Account creation year: " + this.year);
    } 

    public void updateDetails() {
        int a;
        do {
            System.out.println("Enter choice to update:");
            System.out.println("1-Account Type \n2-IFSC \n3-Min balance \n4-Available balance \n5-Name \n6-EXIT");
            a = scanner.nextInt();
            scanner.nextLine();   
            switch (a) {
                case 1:
                    System.out.print("Enter new account type: ");
                    this.accountType = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Enter new IFSC: ");
                    this.serviceBranchIFSC = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Enter new minimum balance: ");
                    this.minimumBalance = scanner.nextFloat();
                    break;
                case 4:
                    System.out.print("Enter new available balance: ");
                    this.availableBalance = scanner.nextFloat();
                    break;
                case 5:
                    System.out.print("Enter new name: ");
                    this.customerName = scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Exiting update menu...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (a != 6);
    }

    public void getBalance() {
        System.out.println("Available Balance: " + this.availableBalance);
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        float amount = scanner.nextFloat();
        this.availableBalance += amount;
        System.out.println("Amount deposited successfully.");
        this.getBalance();
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        float amount = scanner.nextFloat();
        if (this.availableBalance - this.minimumBalance < amount) {
            System.out.println("Insufficient funds, transaction aborted.");
        } else {
            this.availableBalance -= amount;
            System.out.println("Amount withdrawn successfully.");
            this.getBalance();
        }
    }

    public static void totalAccount() {
        System.out.println("Total accounts created: " + totalAccountCreated);
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total number of accounts: ");
        int num = scanner.nextInt();
        Account[] arr = new Account[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter details for account #" + (i + 1));
            arr[i] = new Account();
            arr[i].setDetails();
        }

        int choice;
        do {
            System.out.println("Enter choice: \n1-Update Details \n2-Get Details \n3-Deposit \n4-Withdraw \n5-Total accounts \n6-Compare accounts  \n7-Check no. of account at a point in time \n8-EXIT");
            choice = scanner.nextInt();
            scanner.nextLine();   
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter account number: ");
                int accNum = scanner.nextInt();

                boolean accountFound = false;
                for (int i = 0; i < num; i++) {
                    if (arr[i].accountNumber == accNum) {
                        accountFound = true;
                        switch (choice) {
                            case 1:
                                arr[i].updateDetails();
                                break;
                            case 2:
                                arr[i].getDetails();
                                break;
                            case 3:
                                arr[i].deposit();
                                break;
                            case 4:
                                arr[i].withdraw();
                                break;
                        }
                        break;
                    }
                }

                if (!accountFound) {
                    System.out.println("Account not found");
                }
            } else if (choice == 5) {
                Account.totalAccount();
            } else if (choice == 6) {
                int a1 = -1, a2 = -1;
                float balance1 = 0, balance2 = 0;
                String name1 = "", name2 = "";
		Account aa=new Account(),bb=new Account();
                System.out.print("Enter 1st account number: ");
                a1 = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    if (arr[i].accountNumber == a1) {
			aa=arr[i];
                        name1 = arr[i].customerName;
                        balance1 = arr[i].availableBalance;
                        break;
                    }
                }

                System.out.print("Enter 2nd account number: ");
                a2 = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    if (arr[i].accountNumber == a2) {
			bb=arr[i]; 
                        name2 = arr[i].customerName;
                        balance2 = arr[i].availableBalance;
                        break;
                    }
                }

                if (balance1 > balance2) {
                    System.out.println(name1 + " is richer than " + name2 + " by $" + (balance1 - balance2));
			aa.getDetails();
                } else {
                    System.out.println(name2 + " is richer than " + name1 + " by $" + (balance2 - balance1));
			bb.getDetails();
                }
            }
		else if(choice==7){
		System.out.println("Enter the Year: ");
		int y=scanner.nextInt();
	int c=0;
		for(int i=0;i<num;i++){
		if(arr[i].year<=y) c++;
}
	System.out.println("Total accounts in year " + y +" = " + c);	
}
		 else if (choice != 8) {
                System.out.println("Invalid choice");
            }

        } while (choice != 8);

        System.out.println("Exiting Bank...");
        scanner.close();
    }
}
