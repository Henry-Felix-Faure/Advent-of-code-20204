package D02;
import java.util.ArrayList;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Input : ");

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                Scanner sc_line = new Scanner(sc.nextLine());
                while(sc_line.hasNextInt()) {
                    ls.add(sc_line.nextInt());
                }
                sc_line.close();
            } else { break; }

            System.out.println(ls);

            // code
            int gen_dir = (ls.get(0) - ls.get(1)) > 0 ? 1 : -1;
            String validation = "good";

            for(int i = 1; i < ls.size(); i++) {
                int current_dir = (ls.get(i-1) - ls.get(i)) > 0 ? 1 : -1;
                if (current_dir == gen_dir) {
                    int level = Math.abs(ls.get(i - 1) - ls.get(i));
                    if (level < 1 || level > 3) {
                        validation = "bad";
                        break;
                    }
                }
                else {
                    validation = "bad";
                    break;
                }

            }
            if(validation.equals("good")) {
                answer++;
            }

            ls.clear();
        }

        sc.close();

        System.out.println(answer);
    }
}