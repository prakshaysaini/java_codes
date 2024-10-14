import java.util.*;

class student {
    String name;
    int roll;
    String birthyear;

    public student(String name, int roll, String birthyear) {
        this.name = name;
        this.roll = roll;
        this.birthyear = birthyear;
    }

    public String firstName() {
        return name.split(" ")[0];
    }

    public String title() {
        return name.split(" ")[1];
    }

    public int roll() {
        return roll;
    }

    public String birthyear() {
        return birthyear;
    }

    public String toString() {
        return "Student{name='" + name + "', roll=" + roll + ", birthyear='" + birthyear + "'}";
    }
}

public class sortStudents {

	public static void sort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

	public static void sort_int(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j]<arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    	public static void main(String[] args) {

        ArrayList<student> stu = new ArrayList<>();

        stu.add(new student("Prakshay Saini", 149, "2005"));
        stu.add(new student("Mohit Kumawat", 130, "2006"));
        stu.add(new student("Radhika Garg", 169, "2004"));
        stu.add(new student("Lalit Rao", 120, "2003"));
        stu.add(new student("Rahul Yadav", 148, "2007"));

        student[] ans = new student[5]; 

        String[] fname = new String[5];
        for (int i = 0; i < 5; i++) {
            fname[i] = stu.get(i).firstName(); 
        }
        sort(fname); 

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (stu.get(j).firstName().equals(fname[i])) { 
                    ans[i] = stu.get(j); 
                    break;
                }
            }
        }
	System.out.println("Sorting with 1st Name");
        for (int i = 0; i < 5; i++) {
            System.out.println(ans[i].toString());
        }
	String[] title = new String[5];
        for (int i = 0; i < 5; i++) {
            title[i] = stu.get(i).title(); 
        }
        sort(title); 
	for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (stu.get(j).title().equals(title[i])) { 
                    ans[i] = stu.get(j); 
                    break;
                }
            }
        }
	System.out.println("Sorting with Title");
        for (int i = 0; i < 5; i++) {
            System.out.println(ans[i].toString());
        }

	String[] birthyear = new String[5];
        for (int i = 0; i < 5; i++) {
            birthyear[i] = stu.get(i).birthyear(); 
        }
        sort(birthyear); 
	for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (stu.get(j).birthyear().equals(birthyear[i])) { 
                    ans[i] = stu.get(j); 
                    break;
                }
            }
        }
	System.out.println("Sorting with BirthYear");
        for (int i = 0; i < 5; i++) {
            System.out.println(ans[i].toString());
        }

	int[] roll = new int[5];
        for (int i = 0; i < 5; i++) {
            roll[i] = stu.get(i).roll(); 
        }
        sort_int(roll);
	for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (stu.get(j).roll() == (roll[i])) {
                    ans[i] = stu.get(j); 
                    break;
                }
            }
        }
	System.out.println("Reverse with Roll");
        for (int i = 0; i <5; i++) {
            System.out.println(ans[i].toString());
        }


	
	
    }

    
    
}
