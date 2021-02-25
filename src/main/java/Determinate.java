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

    public Determinate getMinor(int minori, int minorj) {
        double data[][] = new double[getOrder() - 1][getOrder() - 1];
        int datai = 0, dataj = 0;
        for (int k = 0; k < getOrder(); k++) {
            if (minori == k) continue;
            for (int l = 0; l < getOrder(); l++) {
                if (minorj == l) continue;
                data[datai][dataj++] = get(k, l);
            }
            datai++;
            dataj = 0;
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
