import java.util.Scanner;

public class MeiTuan_Autumn_Test_25_04_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().split("\\s+");
        int count = 0;
        for (String name : names) {
            if (Character.isUpperCase(name.charAt(0))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
