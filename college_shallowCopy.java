import java.util.Scanner;

class Faculty {
    String name;
    String empID;

    public Faculty(String name, String empID) {
        this.name = name;
        this.empID = empID;
    }

    public String getDetails() {
        return "Name: " + name + ", Employee ID: " + empID;
    }

    public String toString() {
        return name + " (" + empID + ")";
    }
}

class Student {
    String name;
    String rollNumber;
    double cgpa;
    String branch;
    Faculty advisor;
    static String collegeID;

    static {
        collegeID = "IIITG-001";
    }

    public Student() {
    }

    public Student(String name, String rollNumber, double cgpa, String branch, Faculty advisor) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.cgpa = cgpa;
        this.branch = branch;
        this.advisor = advisor;
    }

    public void updateDetails(String name, double cgpa, String branch) {
        this.name = name;
        this.cgpa = cgpa;
        this.branch = branch;
    }

    public Faculty getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Faculty advisor) {
        this.advisor = advisor;
    }

    public void setDetails(String name, String rollNumber, double cgpa, String branch) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.cgpa = cgpa;
        this.branch = branch;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getDetails() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nCGPA: " + cgpa +
                "\nBranch: " + branch + "\nAdvisor: " + (advisor != null ? advisor.toString() : "None") + 
                "\nCollege ID=" + collegeID;
    }

    public Student shallowCopy() {
        return new Student(this.name, this.rollNumber, this.cgpa, this.branch, this.advisor);
    }
}

public class college_shallowCopy {
    public static void main(String[] args) {

        Faculty advisor = new Faculty("Arijit", "123");

        Student originalStudent = new Student("Sunny", "2301149", 8.2, "CSE", advisor);

        Student shallowCopiedStudent = originalStudent.shallowCopy();


        System.out.println("Original Student Details:");
        System.out.println(originalStudent.getDetails());

        System.out.println("Shallow Copied Student Details:");
        System.out.println(shallowCopiedStudent.getDetails());

        System.out.println("\nModifying the advisor's name and roll for both students...");
        advisor.name = "Arijit";
	originalStudent.rollNumber="69";

        System.out.println("\nOriginal Student Details (after modifying advisor):");
        System.out.println(originalStudent.getDetails());

        System.out.println("Shallow Copied Student Details (after modifying advisor):");
        System.out.println(shallowCopiedStudent.getDetails());
    }
}
