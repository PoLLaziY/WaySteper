public class WaySteper {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        LocationReader l = new LocationReader("src/input.txt");
        Ways ways = new Ways(l.getLocation());
        System.out.println(ways.getNumberOfWays());
        System.out.println(ways.getResult());
        System.out.println(System.currentTimeMillis() - start);
    }
}
