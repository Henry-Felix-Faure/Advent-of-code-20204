package D01;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class main {
    static int min_and_pop(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        arr.remove((Integer) min);
        return min;
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

        while (!ls1.isEmpty() && !ls2.isEmpty()) {
            answer = answer + Math.abs(min_and_pop(ls2) - min_and_pop(ls1));
        }

        System.out.println(answer);
    }
}