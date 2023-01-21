import java.util.Random;


public class Matrix {
    Complex[][] matrix;
    int n, m;
    Matrix(int n, int m) {
        this(n, m, new Complex());
    }
    Matrix(int n, int m, double val) {
        this(n, m, new Complex(val, 0));
    }
    Matrix(int n, int m, Complex val) {
        this.n = n; this.m = m;
        matrix = new Complex[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { matrix[i][j] = new Complex(val); }
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
            for (int j = 0; j < m; j++) { System.out.printf(" %-8s", matrix[i][j].asString()); }
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
    void fillRandInt() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j].real = random.nextInt() % 10;
            }
        }
    }
    void fillRandDouble() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j].real = random.nextDouble();
            }
        }
    }
    void fillRandComplex() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j].real = random.nextInt() % 10;
                matrix[i][j].imag = random.nextInt() % 10;
            }
        }
    }

    void add(Matrix second) {
        if (this.n != second.n || this.m != second.m) {
            System.out.println("DimensionError(+): matrices have different dim");
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { this.matrix[i][j].add(second.matrix[i][j]); }
        }
    }

    void sub(Matrix second) {
        if (this.n != second.n || this.m != second.m) {
            System.out.println("DimensionError(-): matrices have different dim");
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { this.matrix[i][j].sub(second.matrix[i][j]); }
        }
    }

    Matrix sum(Matrix second) {
        if (this.n != second.n || this.m != second.m) {
            System.out.println("DimensionError(+): matrices have different dim, zero matrix returned");
            return new Matrix(1, 1);
        }
        Matrix temp = new Matrix(this.n, this.m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { temp.matrix[i][j] = this.matrix[i][j].sum(second.matrix[i][j]); }
        }
        return temp;
    }

    Matrix diff(Matrix second){
        if (this.n != second.n || this.m != second.m) {
            System.out.println("DimensionError(-): matrices have different dim, zero matrix returned");
            return new Matrix(1, 1);
        }
        Matrix temp = new Matrix(this.n, this.m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { temp.matrix[i][j] = this.matrix[i][j].diff(second.matrix[i][j]); }
        }
        return temp;
    }

    Matrix mul(Matrix second) {
        if (this.m != second.n) {
            System.out.println("DimensionError(*): matrices have wrong dim, zero matrix returned");
            return new Matrix(1, 1);
        }
        Matrix temp = new Matrix(this.n, second.m);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < second.m; ++j) {
                temp.matrix[i][j] = new Complex();
                for (int k = 0; k < this.m; ++k) {
                    temp.matrix[i][j] = temp.matrix[i][j].sum(this.matrix[i][k].mul(second.matrix[k][j]));
                }
            }
        }
        return temp;
    }

    void mul_number(Complex number) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { this.matrix[i][j] = this.matrix[i][j].mul(number); }
        }
    }
    void mul_number(double number) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { this.matrix[i][j].real *= number; this.matrix[i][j].imag *= number; }
        }
    }

    void T() {
        Matrix temp = new Matrix(this.m, this.n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { temp.matrix[i][j] = this.matrix[j][i]; }
        }
        matrix = new Complex[m][n];
        for (int i = 0; i < temp.n; i++) {
            System.arraycopy(temp.matrix[i], 0, matrix[i], 0, temp.m);
        }
        this.n = temp.n; this.m = temp.m;
    }

    void pow(int n) {
        if (this.n != this.m) {
            System.out.println("DimensionError(pow): pow available only for square matrix");
            return;
        }
        Matrix temp = new Matrix(this);
        for (int i = 0; i < n - 1; i++) {
            temp = temp.mul(this);
        }
        for (int i = 0; i < this.n; i++) {
            System.arraycopy(temp.matrix[i], 0, matrix[i], 0, this.n);
        }
    }

    Complex determinant() {
        if (this.n != this.m) {
            System.out.println("DimensionError(det): determinant available only for square matrix");
            System.exit(0);
        }
        final Complex det = new Complex(0, 0);
        if (this.n == 1) return matrix[0][0];
        else {
            Complex minus1 = new Complex(-1, 0);
            for (int i = 0; i < this.m; i++) {
                det.add(minus1.pow(i).mul(minor(this, 0, i).determinant().mul(this.matrix[0][i])));
            }
        }
        return det;
    }

    private Matrix minor(Matrix matrix, int row, int col) {
        Matrix temp = new Matrix(matrix.n - 1, matrix.m - 1);
        int flag_row = 0, flag_col;
        for (int i = 0; i < matrix.n; i++) {
            if (i == row) {flag_row = 1; continue;}
            flag_col = 0;
            for (int j = 0; j < matrix.m; j++) {
                if (j == col) { flag_col = 1; continue; }
                temp.matrix[i - flag_row][j - flag_col] = matrix.matrix[i][j];
            }
        }
        return temp;
    }

    Matrix inverse() {
        if (this.n != this.m) {
            System.out.println("DimensionError(inv): inverse matrix available only for square matrix");
            return this;
        }
        if (this.n == 1) {
            System.out.println("DimensionError(inv): too small matrix");
            return this;
        }
        Complex det = this.determinant();
        if (det.real == 0 && det.imag == 0) {
            System.out.println("MathError(inv): inverse matrix is NOT available for singular matrix");
            return this;
        }
        final Matrix minor_matrix = new Matrix(this.n, this.m);
        Complex minus1 = new Complex(-1, 0);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                minor_matrix.matrix[i][j] = minor(this, i, j).determinant().mul(minus1.pow(i + j));
            }
        }
        Complex a = new Complex(1, 0);
        minor_matrix.T();
        minor_matrix.mul_number(a.div(det));
        return minor_matrix;
    }
}
