import java.util.Arrays;
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

class Person {
    String name;
    int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
	return "Name: "+ name + " Age: " + age;
    }
}

class Student extends Person {
    String rollNumber;
    double cgpa;
    String branch;
    Faculty advisor;
    static String collegeID;

    static {
        collegeID = "IIITG-001";
    }

    public Student() {}

    public Student(String name, int age, String rollNumber, double cgpa, String branch, Faculty advisor) {
        super(name, age); 
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
        return ("Name: " + name + ", Age: " + age + ", Roll Number: " + rollNumber + 
               ", CGPA: " + cgpa + ", Branch: " + branch + 
               ", Advisor: " + (advisor != null ? advisor.toString() : "None") + 
               ", College ID=" + collegeID);
    }
}

public class CollegeSystem_with_person {
    static Student[] students = new Student[5];
    static Faculty[] faculties = new Faculty[2];
    static Person[] persons = new Person[5];  
    static int studentCount = 0;
    static int facultyCount = 0;
    static int personCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1) Add Student");
            System.out.println("2) Delete Student");
            System.out.println("3) Add Faculty");
            System.out.println("4) Delete Faculty");
            System.out.println("5) Update Student Record");
            System.out.println("6) Get Student Details");
            System.out.println("7) Get Advisor Details");
            System.out.println("8) Add Person Details");
            System.out.println("9) Get Person Details");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    deleteStudent(sc);
                    break;
                case 3:
                    addFaculty(sc);
                    break;
                case 4:
                    deleteFaculty(sc);
                    break;
                case 5:
                    updateStudentRecord(sc);
                    break;
                case 6:
                    getStudentDetails(sc);
                    break;
                case 7:
                    getAdvisorDetails(sc);
                    break;
                case 8:
                    addPerson(sc);
                    break;
                case 9:
                    getPersonDetails(sc);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    static void addStudent(Scanner sc) {
        if (studentCount < students.length) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter roll number: ");
            String rollNumber = sc.nextLine();
            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter branch: ");
            String branch = sc.nextLine();
            System.out.print("Enter advisor index (0 or 1): ");
            int advisorIndex = sc.nextInt();

            if (advisorIndex >= 0 && advisorIndex < facultyCount) {
                Faculty advisor = faculties[advisorIndex];
                students[studentCount] = new Student(name, age, rollNumber, cgpa, branch, advisor);
                studentCount++;
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Invalid advisor index.");
            }
        } else {
            System.out.println("Maximum number of students reached.");
        }
    }

  
    static void addFaculty(Scanner sc) {
        if (facultyCount < faculties.length) {
            System.out.print("Enter faculty name: ");
            String name = sc.nextLine();
            System.out.print("Enter employee ID: ");
            String empID = sc.nextLine();
            faculties[facultyCount] = new Faculty(name, empID);
            facultyCount++;
            System.out.println("Faculty added successfully.");
        } else {
            System.out.println("Maximum number of faculty members reached.");
        }
    }

    static void addPerson(Scanner sc) {
        if (personCount < persons.length) {
            System.out.print("Enter person's name: ");
            String name = sc.nextLine();
            System.out.print("Enter person's age: ");
            int age = sc.nextInt();
            sc.nextLine();

            persons[personCount] = new Person(name, age);
            personCount++;
            System.out.println("Person details added successfully.");
        } else {
            System.out.println("Maximum number of persons reached.");
        }
    }

    static void getPersonDetails(Scanner sc) {
        System.out.print("Enter index of person (0 - " + (personCount - 1) + "): ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index >= 0 && index < personCount) {
            persons[index].getDetails();
        } else {
            System.out.println("Invalid person index.");
        }
    }

static void deleteStudent(Scanner sc) {
        System.out.print("Enter roll number of student to delete: ");
        String rollNumber = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getRollNumber().equals(rollNumber)) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null;
                studentCount--;
                found = true;
                System.out.println("Student deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
 static void deleteFaculty(Scanner sc) {
        System.out.print("Enter employee ID of faculty to delete: ");
        String empID = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < facultyCount; i++) {
            if (faculties[i].empID.equals(empID)) {
                for (int j = 0; j < studentCount; j++) {
                    if (students[j].getAdvisor() != null && students[j].getAdvisor().empID.equals(empID)) {
                        students[j].setAdvisor(null);  // Remove advisor from students
                    }
                }

                for (int j = i; j < facultyCount - 1; j++) {
                    faculties[j] = faculties[j + 1];
                }
                faculties[facultyCount - 1] = null;
                facultyCount--;
                found = true;
                System.out.println("Faculty deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Faculty not found.");
        }
    }
static void updateStudentRecord(Scanner sc) {
        System.out.print("Enter roll number of student to update: ");
        String rollNumber = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getRollNumber().equals(rollNumber)) {
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new CGPA: ");
                double cgpa = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter new branch: ");
                String branch = sc.nextLine();
                students[i].updateDetails(name, cgpa, branch);
                found = true;
                System.out.println("Student record updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    static void getStudentDetails(Scanner sc) {
        System.out.print("Enter roll number of student: ");
        String rollNumber = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getRollNumber().equals(rollNumber)) {
                System.out.println(students[i].getDetails());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    static void getAdvisorDetails(Scanner sc) {
        System.out.print("Enter employee ID of advisor: ");
        String empID = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < facultyCount; i++) {
            if (faculties[i].empID.equals(empID)) {
                System.out.println(faculties[i].getDetails());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Faculty not found.");
        }
    }



    
}
