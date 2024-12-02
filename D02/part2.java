package D02;
import java.util.ArrayList;
import java.util.Scanner;

public class part2 {

    static boolean isSafe(ArrayList<Integer> arr){
        int gen_dir = (arr.get(0) - arr.get(1)) > 0 ? 1 : -1;
        String validation = "good";

        for(int i = 1; i < arr.size(); i++) {
            int current_dir = (arr.get(i-1) - arr.get(i)) > 0 ? 1 : -1;
            if (current_dir == gen_dir) {
                int level = Math.abs(arr.get(i - 1) - arr.get(i));
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
        return validation.equals("good");
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();
        ArrayList<Integer> temp_ls = new ArrayList<>();
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

            if (isSafe(ls)) {
                answer++;
            } else {
                for(int i = 0; i < ls.size(); i++) {
                    temp_ls = (ArrayList<Integer>) ls.clone();
                    temp_ls.remove(i);
                    if (isSafe(temp_ls)) {
                        answer++;
                        break;
                    }
                }
            }
            ls.clear();
        }
        sc.close();
        System.out.println(answer);
    }
}