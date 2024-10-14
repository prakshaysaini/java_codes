import java.util.Scanner;

public class Addition {

    public int add() {
        Scanner sc = new Scanner(System.in);
	System.out.print("Enter no. of numbers ");
        int a = sc.nextInt();
       	int ans=0;
        for(int i=0;i<a;i++){
	System.out.print("Enter no. ");
        int b = sc.nextInt();
	ans += b;}

	return ans;

    }

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("1st- NO ARGUMENT ");
        Addition obj = new Addition();
        System.out.println("Sum (no arguments): " + obj.add());
	System.out.println("2nd- 2 ARGUMENTs ");
	System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();
        System.out.println("Sum (2 arguments): " + obj.add(a, b));
	System.out.println("3rd- 3 ARGUMENTs ");
	System.out.println("Enter 3rd number ");
	int c=sc.nextInt();
        System.out.println("Sum (3 arguments): " + obj.add(a,b,c));
    }
}
