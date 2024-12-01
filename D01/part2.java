package D01;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class part2 {
    static int similarity_check(int n, ArrayList<Integer> arr) {
        int occurences = 0;
        for (Integer current_int : arr) {
            if (current_int == n) {
                occurences++;
            }
        }
        return occurences;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls1 = new ArrayList<>();
        ArrayList<Integer> ls2 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Input : ");

        String dual = "ping";

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                switch (dual) {
                    case "ping":
                        ls1.add(sc.nextInt());
                        dual = "pong";
                        break;
                    case "pong":
                        ls2.add(sc.nextInt());
                        dual = "ping";
                        break;
                    default:
                        break;
                }
            } else {
                String input = sc.next();
                if (input.equals("end")) { break; }
            }
        }

        sc.close();

        int answer = 0;

        for (Integer current_int : ls1) {
            answer += similarity_check(current_int, ls2) * current_int;
        }

        System.out.println(answer);
    }
}