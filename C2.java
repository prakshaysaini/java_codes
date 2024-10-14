import java.util.Scanner;
Scanner scanner = new Scanner(System.in);
class faculty{
	String name;
	int empID;
	

	faculty(){}
	
	public void setDetails(){
	System.out.print("Enter Faculty name  ");
	this.name=scanner.nextLine();
	System.out.print("Enter Faculty ID: ");
	this.empID = scanner.nextInt();
	}
	

	public void toString(){
	System.out.print("Faculty name: " + this.name + "\n Faculty ID: " + this.empID +"\n");
	}
}

class student{
	String name;
	int rollNo;
 	double cgpa;
	faculty facultyAdvisor;
	String branch;
	String collegeID;
	
	student() {}
	student(faculty) {
	student.facultyAdvisor=faculty;
	}

	public void updateStudent(){
	
	System.out.print("Enter choice to update: \n 1-Name \n 2-Roll no. \n 3-CGPA \n4-Faculty advisor \n5-Branch \n");
	int choice=scanner.nextInt();
	switch(choice){
	case 1:
		System.out.print("Enter updated name: ");
		this.name=scanner.nextLine();
		break;
	case 2:
		System.out.print("Enter new roll no. : ");
		this.rollNo = scanner.nextInt();
		break;
	case 3: 
		System.out.print("Enter updated CGPA: ");
		this.cgpa=scanner.nextInt();
		break;
	case 4:
		System.out.print("Enter new Faculty advisor: ");
		
		break;
	case 5:
		System.out.print("Enter updated branch: ");
	default: 
		System.out.print("Invalid choice ");
}


	public void getStudentDetails(){
	
	System.out.print("Name = " + this.name);
	System.out.print("\nRoll no= " + this.rollNo);
	System.out.print("\nCGPA= " + this.cgpa);
	System.out.print("\nFaculty advisor: "+ this.facultyAdvisor );
	System.out.print("\nBranch: " + this.branch);

}

	public void getFaculty(){
	System.out.print("Student faculty advisor-> " + this.facultyAdvisor);
	}

	
}
public class CollegeSystem {

	public void addStudent(Scanner sc){
	System.out.print("Enter name");
	String name=system.nextLine();	
	System.out.print("Enter Roll no: ");
	int roll= scanner.nextInt();
	System.out.print("Enter Cgpa: ");
	int cgpa=scanner.nextInt();


}


      static Student[] students = new Student[5];
      static Faculty[] faculties = new Faculty[2];
      static int studentCount = 0;
      static int facultyCount = 0;

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
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline


public void updateStudentRecord(Scanner sc){
	System.out.printLine("Enter choice: \n1-Name\2-CGPA\n3-Faculty Advisor\n4-Branch");
	int choice=sc.nextInt();
	switch(choice){

	case 1:
		System.out.print("Enter NEW name: ");
		this.name=sc.nextLine();
		break;
	case 2: 
		System.out.print("Enter new CGPA : ");
		this.cgpa=sc.nextInt();
		break;
	case 3:
		System.out.print("Enter new faculty advisor: ");
		this.
}


}
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
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
























	

	
	