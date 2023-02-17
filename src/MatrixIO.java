import java.util.Random;

public class MatrixIO {
    /**
     * Заполнение матрицы
     */
    void fill(Matrix matrix) {
        for (int i = 0; i < matrix.n; i++) {
            System.out.println("Row " + (i + 1));
            for (int j = 0; j < matrix.m; j++) {
                System.out.print("matrix[" + i + ']' + '[' + j + "] = ");
                ComplexIO.get(matrix.matrix[i][j]);
            }
        }
    }

    /**
     * Заполнение случайными целыми числами
     */
    static void fillRandInt(Matrix matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.n; i++) {
            for (int j = 0; j < matrix.m; j++) {
                matrix.set(i, j, new Complex(random.nextInt() % 10, 0));
            }
        }
    }

    /**
     * Заполнение случайными вещественными числами
     */
    void fillRandDouble(Matrix matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.n; i++) {
            for (int j = 0; j < matrix.m; j++) {
                matrix.set(i, j, new Complex(random.nextDouble(), 0));
            }
        }
    }

    /**
     * Заполнение случайными комплексными числами
     */
    static void fillRandComplex(Matrix matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.n; i++) {
            for (int j = 0; j < matrix.m; j++) {
                matrix.set(i, j, new Complex(random.nextInt() % 10, random.nextInt() % 10));
            }
        }
    }

    /**
     * Вывод матрицы
     */
    static void print(Matrix matrix) {
        for (int i = 0; i < matrix.n; i++) {
            for (int j = 0; j < matrix.m; j++) { System.out.printf(" %-8s", ComplexIO.asString(matrix.matrix[i][j])); }
            System.out.print('\n');
        }
    }
}
