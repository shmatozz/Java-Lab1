import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        DecimalFormat round = new DecimalFormat("#.###");   // Для округления дробных чисел

        System.out.println("--- Complex numbers ---");
        Complex number1 = new Complex(1, -2);    // Число 1
        Complex number2 = new Complex(2, -4);    // Число 2
        Complex test = new Complex(number2);    // Тестовая переменная

        System.out.print("number1 = "); number1.println();
        System.out.print("number2 = "); number2.println();
        System.out.print("\nCopy of number2 = "); test.println();

        System.out.print("number2 + number1 = ");   // Testing +
        number2.sum(number1).println();

        System.out.print("number2 - number1 = ");   // Testing -
        number2.diff(number1).println();

        System.out.print("number2 * number1 = ");   // Testing *
        number2.mul(number1).println();

        System.out.print("number2 / number1 = ");   // Testing /
        number2.div(number1).println();

        System.out.printf("|number1| = " + round.format(number1.abs()) + '\n');    // Testing abs
        System.out.printf("Arg(number1) = " + round.format(number2.arg()) + '\n');    // Testing arg

        System.out.print("number1^3 = ");   // Testing pow
        number1.pow(3).println();
        System.out.print("number2^2 = ");
        number2.pow(2).println();

        System.out.print("number1^(1/2) = ");   // Testing sqrt
        number1.sqrt(2).println();
        System.out.print("number2^(1/3) = ");
        number2.sqrt(3).println();


        System.out.println("\n--- Matrix ---");
        Matrix matrix1 = new Matrix(3, 3), matrix2 = new Matrix(3, 3);
        matrix1.fillRandInt();
        matrix2.fillRandInt();
        System.out.println("matrix1:"); matrix1.print();
        System.out.println("det(matrix1):");   // Testing determinant
        matrix1.determinant().println();
        System.out.println("matrix2:"); matrix2.print();
        System.out.println("det(matrix2):");   // Testing determinant
        matrix2.determinant().println();

        System.out.println("\nmatrix1 += matrix2 (in-place):");
        matrix1.add(matrix2);   // In-place addition
        matrix1.print();

        System.out.println("matrix1 -= matrix2 (in-place):");
        matrix1.sub(matrix2);   // In-place subtraction
        matrix1.print();

        System.out.println("matrix1 + matrix2 (returns new matrix):");   // Testing sum(+) of matrices, returns new matrix
        matrix1.sum(matrix2).print();

        System.out.println("matrix1 - matrix2 (returns new matrix):");   // Testing diff(-) of matrices, returns new matrix
        matrix1.diff(matrix2).print();

        System.out.println("matrix1 * matrix2 (returns new matrix):");   // Testing mul(*) of matrices, returns new matrix
        matrix1.mul(matrix2).print();

        System.out.println("matrix1 * 5:");   // Testing mul(*) on const of matrix
        matrix1.mul_number(5);
        matrix1.print();
        matrix1.mul_number(0.2);

        System.out.println("Transposed matrix1:");   // Testing transposing of matrix
        matrix1.T();
        matrix1.print();

        System.out.println("(matrix2)^2:");   // Testing pow of matrix
        matrix2.pow(2);
        matrix2.print();

        System.out.println("matrix1.inv:");   // Testing inversion of matrix
        Matrix matrix1_inv = matrix1.inverse();
        matrix1_inv.print();

        System.out.println("matrix1 * matrix1.inv = E:");   // E - unit matrix (Еденичная матрица)
        matrix1.mul(matrix1_inv).print();
    }

}