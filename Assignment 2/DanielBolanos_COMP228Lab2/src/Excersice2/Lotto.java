package Excersice2;

import java.util.Random;

public class Lotto {
    Random random = new Random();
    int[] loto = new int[3];

    public Lotto() {
        for(int i=0;i<3;i++){
            loto[i]=random.nextInt(9);
        }
    }

    public int[] getLotto() {
        return loto;
    }
}
