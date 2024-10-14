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

    // Deep copy constructor
    public Student(Student other) {
        this.name = other.name;
        this.rollNumber = other.rollNumber;
        this.cgpa = other.cgpa;
        this.branch = other.branch;
        // Perform a deep copy of the advisor
        if (other.advisor != null) {
            this.advisor = new Faculty(other.advisor.name, other.advisor.empID);
        }
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

    public String getRollNumber() {
        return rollNumber;
    }

    public String getDetails() {
        return "\n\nName: " + name + "\nRoll Number: " + rollNumber + "\nCGPA: " + cgpa +
                "\nBranch: " + branch + "\nAdvisor: " + (advisor != null ? advisor.toString() : "None") +
                "\nCollege ID=" + collegeID;
    }
}


public class college_deepCopy {
    public static void main(String[] args) {
        Faculty faculty1 = new Faculty("Sanjay", "987");
        Student originalStudent = new Student("Sunny", "2301149", 9.1, "CSE", faculty1);


        Student copiedStudent = new Student(originalStudent);

        System.out.println("Original Student Details: " + originalStudent.getDetails());
        System.out.println("Copied Student Details: " + copiedStudent.getDetails());

        originalStudent.getAdvisor().name = "Arijit";
        originalStudent.getAdvisor().empID = "999";

        System.out.println("\nAfter modifying the faculty advisor of the original student:");
        System.out.println("Original Student Details: " + originalStudent.getDetails());
        System.out.println("Copied Student Details: " + copiedStudent.getDetails());
    }
}
