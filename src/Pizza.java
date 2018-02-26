import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.floor;

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

        int horizontalCut = (int) (floor(((double)(cuts[2] - cuts[0])) /2.0) + cuts[0]);
        int verticalCut = (int) (floor(((double)(cuts[3] - cuts[1])) /2.0) + cuts[1]);

        int upperLeftCorner = 0;
        int upperRightCorner = 0;
        int bottomLeftCorner = 0;
        int bottomRightCorner = 0;

        for (int i = cuts[0]; i < horizontalCut; i++) {
            for (int j = cuts[1]; j < verticalCut; j++) {
                upperLeftCorner += pizza[i][j];
            }
        }

        for (int i = horizontalCut; i < cuts[2]; i++) {
            for (int j = cuts[1]; j < verticalCut; j++) {
                upperRightCorner += pizza[i][j];
            }
        }

        for (int i = cuts[0]; i < horizontalCut; i++) {
            for (int j = verticalCut; j < cuts[3]; j++) {
                bottomLeftCorner += pizza[i][j];
            }
        }

        bottomRightCorner = score - (upperLeftCorner + upperRightCorner + bottomRightCorner);


        if(abs(upperLeftCorner + upperRightCorner) + abs(bottomLeftCorner + bottomRightCorner) <
                abs(upperLeftCorner + bottomLeftCorner) + abs(upperRightCorner + bottomRightCorner)) {
            int[] upperSlice = {cuts[0], cuts[1], horizontalCut, cuts[3]};
            int[] lowerSlice = {horizontalCut, cuts[1], cuts[2], cuts[3]};
            solver(upperSlice, upperLeftCorner + upperRightCorner);
            solver(upperSlice, bottomLeftCorner + bottomRightCorner);
        } else {
            int[] rightSlice = {cuts[0], cuts[1], cuts[2], verticalCut};
            int[] leftSlice = {cuts[0], verticalCut, cuts[2], cuts[3]};
            solver(rightSlice, upperRightCorner + bottomRightCorner);
            solver(leftSlice, upperLeftCorner + bottomLeftCorner );
        }
    }

    public static void main(String[] args){
        new Pizza().test();
    }

}
