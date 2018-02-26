import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
    Scanner scan = new Scanner(System.in);
    int R;
    int C;
    int L;
    int H;
    int[][] pizza; //M = 1, T = -1
    ArrayList<int[]> solution = new ArrayList<>();

    void readinator() {
        R = scan.nextInt();
        C = scan.nextInt();
        L = scan.nextInt();
        H = scan.nextInt();

        pizza = new int[R][C];
        System.out.println(R + " " + C);
        for (int i = 0; i < R; i++) {
            String line = scan.next();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < C; j++) {
                if(charArray[i] == 'T') {
                    pizza[i][j] = -1;
                } else {
                    pizza[i][j] = 1;
                }
            }
        }
    }

    void printPizza(int[][] p){
        for(int i = 0; i < p.length; i++){
            for (int j = 0; j < p[0].length; j++){
                System.out.print(p[i][j] + " | ");
            }
            System.out.println("|");

        }
    }

    void test(){
        readinator();
        printPizza(pizza);
    }

    void solver(int[] cuts, int score) {
        int size = (cuts[2] - cuts[0])*(cuts[3] - cuts[1]);
        if(size <= H) {
            if((score >= - (size - 2*L)) && score <= (size - 2*L)) {
                solution.add(cuts);
            }
        }
    }

    public static void main(String[] args){
        new Pizza().test();
    }

}
