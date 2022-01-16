import java.util.ArrayList;

//Ways - хранилище всех возможных путей (Way) и методы по их созданию и движению
public class Ways {
    //массив путей(Way)
    private ArrayList<Way> ways = new ArrayList<Way>();
    //переданная локация в виде двумерного квадратного массива целочисленных значений
    private int[][] loc;

    //конструктор Ways. Принимает локацию в виде двумерного квадратного массива целочисленных значений
    public Ways(int[][] loc) {
        this.loc = loc;
        start();
    }

    //начало работы Ways. Создаёт 2 начальных пути - правый и нижний,
    //на которых вызывается метод для совершения следующего шага
    private void start() {
        nextStep(new Way(loc[0][0]), 1, 0, 'D');
        nextStep(new Way(loc[0][0]), 0, 1, 'R');
    }

    //метод, совершающий следующий шаг, принимает путь(Way), который программа уже прошла, делает следующий шаг
    // и записывает его в путь. Если возможно два пути движения - правый путь создаёт копию пути (Way) и пишет в неё.
    private void nextStep(Way way, int nextLine, int nextColumn, char turn){
        way.add(loc[nextLine][nextColumn], turn);
        if (nextLine == loc.length - 1 && nextColumn == loc[nextLine].length - 1) {
            way.safeToWays();
        } else if (nextLine == loc.length - 1) {
            nextStep(way, nextLine, nextColumn+1, 'R');
        } else if (nextColumn == loc[nextLine].length - 1) {
            nextStep(way, nextLine+1, nextColumn, 'D');
        } else {
            nextStep(new Way(way), nextLine, nextColumn+1, 'R');
            nextStep(way, nextLine+1, nextColumn, 'D');
        }
    };

    public String getResult() {
        int result = 0;
        for (int i = 1; i < ways.size() - 1; i++) {
            if (ways.get(result).SumResult < ways.get(i).SumResult) {
                result = i;
            }
        }
        return ways.get(result).toString();
    }

    public int getNumberOfWays() {
        return Way.WayNumber;
    }

    //Way - класс хранилище всех совершённых поворотов и пройденных результатов
    private class Way {
        private static int WayNumber = 0;
        private ArrayList<Integer> results;
        private ArrayList<Character> turns;
        private int SumResult;
        private int myNumber;

        //создание начального пути 1 стартовой точке
        private Way(int StartResults) {
            results = new ArrayList<>();
            turns = new ArrayList<>();
            results.add(StartResults);
            SumResult = StartResults;
            myNumber = WayNumber++;
        }

        //создание копии пути way
        private Way(Way way) {
            this.results = new ArrayList<>(way.results);
            this.turns = new ArrayList<>(way.turns);
            this.SumResult = way.SumResult;
            myNumber = WayNumber++;
        }

        //добавить следующую точку в путь
        private void add(int NextResult, char turn) {
            results.add(NextResult);
            turns.add(turn);
            this.SumResult += NextResult;
        }

        private void safeToWays() {
            ways.add(this);
        }

        public String toString() {
            return "\n" + myNumber + " " + results + " " + turns + " " + SumResult;
        }
    }
}
