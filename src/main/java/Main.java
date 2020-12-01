public class Main {
    public static void main(String[] args) {
        double[][] val = {
                {5, -4, 3},
                {7, 2, -1},
                {9, 0, 4},
        };

        Determinate determinate = new Determinate(val);
        System.out.println(determinate.calc());
    }
}
