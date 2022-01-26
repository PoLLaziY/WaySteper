import java.io.IOException;

import static java.lang.Thread.sleep;

public class WaySteper {
    public static void main(String[] args) throws IOException {
        System.in.read();
        new Thread(() -> {

        long start = System.currentTimeMillis();
        LocationReader l = new LocationReader("src/input.txt");
        Ways ways = new Ways(l.getLocation());
            new Thread(() -> {
                while (true) {
                    System.out.println("Ways number is " + ways.getNumberOfWays());
                    System.out.println("Best way if " + ways.getResult());
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            ways.start();
        }).start();


    }
}
