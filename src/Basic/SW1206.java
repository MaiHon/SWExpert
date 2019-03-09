package Basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SW1206 {
    public static void main(String [] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("./src/input_building.txt"));
        Scanner sc = new Scanner(System.in);

        int building[];

        for (int i=1; i<11; i++) {
            int space = 0;
            int buildingNum = sc.nextInt();
            building = new int[buildingNum];

            for(int j=0; j<buildingNum; j++) {
                building[j] = sc.nextInt();
            }

            for(int k=2; k<buildingNum-1; k++) {
                if(building[k-1]<building[k] && building[k]>building[k+1]) {
                    if(building[k-2]<building[k] && building[k]>building[k+2]) {
                        space += building[k] - Math.max(Math.max(building[k+2], building[k+1]), Math.max(building[k-1], building[k-2]));
                    }
                }
            }
            System.out.println("#" + i + " " + space);
        }
    }
}