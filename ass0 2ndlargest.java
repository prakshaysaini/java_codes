import java.util.Scanner;

public class secondmax{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("size-");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int m,m2;
        m = m2 = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            if (array[i] > m) {
                m2 = m;
                m = array[i];
            } else if (array[i] > m2 && array[i] != m) {
                m2 = array[i];
            }
        }
            System.out.println("ANS-"+ m2);
    }
}
