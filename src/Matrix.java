public class Matrix {
    Complex[][] matrix;
    int n, m;
    Matrix(int n, int m) {
        this.n = n; this.m = m;
        matrix = new Complex[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { matrix[i][j] = new Complex(); }
        }
    }
    Matrix(Matrix second) {
        this.n = second.n; this.m = second.m;
        matrix = new Complex[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(second.matrix[i], 0, matrix[i], 0, m);
        }
    }

    void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { matrix[i][j].print(); }
            System.out.print('\n');
        }
    }
    void fill() {
        for (int i = 0; i < n; i++) {
            System.out.println("Row " + (i + 1));
            for (int j = 0; j < m; j++) {
                System.out.print("matrix[" + i + ']' + '[' + j + "] = ");
                matrix[i][j].get();
            }
        }
    }

    Matrix sum(Matrix second) {
        Matrix temp = new Matrix(this.n, this.m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { temp.matrix[i][j] = this.matrix[i][j].add(second.matrix[i][j]); }
        }
        return temp;
    }

    Matrix mul(Matrix second) {
        Matrix temp = new Matrix(this.n, second.m);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < second.m; ++j) {
                temp.matrix[i][j] = new Complex();
                for (int k = 0; k < this.m; ++k) {
                    temp.matrix[i][j] = temp.matrix[i][j].add(this.matrix[i][k].mul(second.matrix[k][j]));
                }
            }
        }
        return temp;
    }
}
