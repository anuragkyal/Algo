package strings;

import java.util.Random;

/**
 * Created by anurag on 10/31/14.
 */
public class Rotate90 {
    public int[][] rotate90(int[][] m){
        int mid = (m.length)/2;
        int l = m.length;

        for(int k=0; k<3; k++){
            for(int i=0; i<mid; i++){
                if(k==0) {
                    for (int j = 0; j < mid; j++) {
                        int temp = m[i][j];
                        m[i][j] = m[j][l-1-i];
                        m[j][l-1-i] = temp;
                    }
                }else if(k == 1){
                    for (int j = 0; j < mid; j++) {
                        int temp = m[i][j];
                        m[i][j] = m[l-1-i][l-1-j];
                        m[l-1-i][l-1-j] = temp;
                    }
                }else if(k == 2){
                    for (int j = 0; j < mid; j++) {
                        int temp = m[i][j];
                        m[i][j] = m[l-1-j][i];
                        m[l-1-j][i] = temp;
                    }
                }
            }

            //Only if M is odd
            if(l%2 != 0) {
                for (int i = 0; i < mid; i++) {
                    if (k == 0) {
                        int temp = m[i][mid];
                        m[i][mid] = m[mid][l - 1 - i];
                        m[mid][l - 1 - i] = temp;
                    } else if (k == 1) {
                        int temp = m[i][mid];
                        m[i][mid] = m[l - 1 - i][mid];
                        m[l - 1 - i][mid] = temp;
                    } else {
                        int temp = m[i][mid];
                        m[i][mid] = m[mid][i];
                        m[mid][i] = temp;
                    }
                }
            }
        }

        return m;
    }

    public static void main(String args[]){
        int M = 4;
        Random random = new Random();
        int[][] m = new int[M][M];

        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                m[i][j] = Math.abs(random.nextInt()) % 10;
            }
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        Rotate90 rotate90 = new Rotate90();
        int[][] n = rotate90.rotate90(m);

        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }
}
