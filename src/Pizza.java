import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
    Scanner scan = new Scanner(System.in);
    int R;
    int C;
    int L;
    int H;
    int[][] pizza;
    ArrayList<int[]> solution = new ArrayList<>();

    void readinator() {
        R = scan.nextInt();
        C = scan.nextInt();
        L = scan.nextInt();
        H = scan.nextInt();

        pizza = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; i < C; i++) {
                if(scan.next() == "T" ) {

                }
            }
        }
    }

    void solver(int[] cuts, int score) {
        int size = (cuts[2] - cuts[0])*(cuts[3] - cuts[1]);
        if(size <= H) {
            if((score >= - (size - 2*L)) && score <= (size - 2*L)) {
                solution.add(cuts);
            }
        }
    }
}
