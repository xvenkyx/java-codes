package prac;
import java.util.Scanner;
public class Rotations {

    public static void areRotations(String str1, String str2) {
        if (str1.length()!= str2.length()) {
            System.out.println("Not rotations");
            return;
        }
        String concat = str1 + str1;
        if (concat.contains(str2)) {
            System.out.println("Rotations");
        } else {
            System.out.println("Not rotations");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        areRotations(str1, str2);
        scanner.close();
    }
}
