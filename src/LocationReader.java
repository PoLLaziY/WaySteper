import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class LocationReader {
    private ArrayList<ArrayList> location = new ArrayList<>();
    private final String file;
    private int[][] loc;

    public LocationReader(String file) {
        this.file = file;
        location.add(new ArrayList<Integer>());
        this.loc = inicializedLoc();
    }

    private int[][] inicializedLoc() {
        InputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int bt;
        int solution = 0;
        int i = 0;
        try {
            while ((bt = in.read()) != -1) {
                if (bt >= '0' && bt <= '9') {
                    solution *= 10;
                    solution += bt - '0';
                }
                if (bt == ';' || bt == ' ' || bt == ',' || bt == '.') {
                    location.get(i).add(solution);
                    solution = 0;
                }
                if (bt == '\n') {
                    location.get(i).add(solution);
                    location.add(new ArrayList<Integer>());
                    solution = 0;
                    i++;
                }
            }
            location.get(i).add(solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[][] loc = new int[location.size()][];
        for (int j = 0; j < location.size(); j++) {
            loc[j] = new int[location.get(j).size()];
            for (int k = 0; k < location.get(j).size(); k++) {
                loc[j][k] = (int) location.get(j).get(k);
            }
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loc;
    }

    public int[][] getLocation() {
        return this.loc;
    }
}
