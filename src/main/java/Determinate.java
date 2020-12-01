public class Determinate {
    private double data[][];

    public Determinate(double data[][]) {
        this.data = data;
    }

    public double get(int i, int j) {
        return data[i][j];
    }

    public int getOrder() {
        return data.length;
    }

    public double calc() {
        double result = 0;
        if (getOrder() == 2) {
            result = data[0][0] * data[1][1] - data[0][1] * data[1][0];
        } else {
            for (int i = 0; i < getOrder(); i++) {
                result += get(0, i) * getAIndex(0, i) * getMinor(0, i).calc();
            }
        }
        return result;
    }

    public int getAIndex(int i, int j) {
        return (int) Math.pow(-1, i + j);
    }

    public Determinate getMinor(int i, int j) {
        double data[][] = new double[getOrder() - 1][getOrder() - 1];
        int i1 = 0, j2 = 0;
        for (int k = 0; k < getOrder(); k++) {
            if (i == k) continue;
            for (int l = 0; l < getOrder(); l++) {
                if (j == l) continue;
                data[i1][j2++] = get(k, l);
            }
            i1++;
            j2 = 0;
        }
        return new Determinate(data);
    }

    public void print() {
        for (double[] a: data) {
            for (double b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
