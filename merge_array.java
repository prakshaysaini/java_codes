import java.util.Scanner;

public class merge_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the first array:");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Enter the size of the second array:");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[] arr3 = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];}}

        while (i < arr1.length) {
            arr3[k++] = arr1[i++];}
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];}
        System.out.println("Merged array:");
        for (int l = 0; l < arr3.length; l++) {
            System.out.print(arr3[l] + " ");
        }}}
    
