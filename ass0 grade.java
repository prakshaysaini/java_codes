import java.util.Scanner;

public class grade{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter marks- ");
        int marks = scanner.nextInt();

        String grade;
        if (marks >= 90) {
            System.out.println("AA");
        } else if (marks >= 80) {
            System.out.println("AB");
        } else if (marks >= 70) {
            System.out.println("BB");
        } else {
            System.out.println("F");
        }

       

        scanner.close();
    }
}
