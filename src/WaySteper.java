import java.io.*;
import java.util.Scanner;

public class WaySteper {
    public static void main(String[] args) throws FileNotFoundException {
        int[][] loc = new int[10][10];
        Scanner s = new Scanner(new FileInputStream("src/input.txt"));
        int j = 0;
        while (s.hasNextLine()) {
            String[] line = s.nextLine().split(";");
            for (int i = 0; i < 10; i++) {
                loc[j][i] = Integer.parseInt(line[i]);
                if (i == 9 && j < 9) j++;
            }
        }
        long start = System.currentTimeMillis();
        Ways ways = new Ways(loc);
        ways.start();
        ways.getResult();
        System.out.println(System.currentTimeMillis()-start + " ms");
        System.out.println(ways.getNumberOfWays());
    }

}
