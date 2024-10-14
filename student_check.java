import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String branch;
    double CGPA;

    void stuDetail(Scanner scanner) {
        System.out.print("Enter roll no: ");
        rollNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter branch: ");
        branch = scanner.nextLine();
        System.out.print("Enter CGPA: ");
        CGPA = scanner.nextDouble();
        scanner.nextLine(); 
    }

    boolean branchChange() {
        if (CGPA > 9 && branch.equalsIgnoreCase("ECE")) {
            branch = "CSE";
            return true;
        }
        return false;
    }

    void printStudentDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Branch: " + branch);
        System.out.println("CGPA: " + CGPA);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student s1 = new Student();
        Student s2 = new Student();

        System.out.println("Enter details for student 1:");
        s1.stuDetail(scanner);
        System.out.println("Enter details for student 2:");
        s2.stuDetail(scanner);

        System.out.println("Student 1 details:");
        s1.printStudentDetails();
        boolean changed = s1.branchChange();
        if (changed) {
            System.out.println("Branch changed to CSE");
        } else {
            System.out.println("Branch not changed");
        }

        System.out.println("Student 2 details:");
        s2.printStudentDetails();
        changed = s2.branchChange();
        if (changed) {
            System.out.println("Branch changed to CSE");
        } else {
            System.out.println("Branch not changed");
        }
    }
}