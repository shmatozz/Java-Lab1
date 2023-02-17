import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        DecimalFormat round = new DecimalFormat("#.###");   // Для округления дробных чисел

        System.out.println("--- Complex numbers ---");
        Complex number1 = new Complex(1, -2);    // Число 1
        Complex number2 = new Complex(2, -4);    // Число 2
        Complex test = new Complex(number2);    // Тестовая переменная

        System.out.print("number1 = ");           ComplexIO.println(number1);
        System.out.print("trig number1 = ");      ComplexIO.printTrig(number1);
        System.out.print("exp number1 = ");       ComplexIO.printExp(number1);
        System.out.print("number2 = ");           ComplexIO.println(number2);
        System.out.print("trig number2 = ");      ComplexIO.printTrig(number2);
        System.out.print("exp number2 = ");       ComplexIO.printExp(number2);
        System.out.print("\nCopy of number2 = "); ComplexIO.println(test);

        System.out.print("number2 + number1 = ");   // Testing +
        ComplexIO.println(number2.sum(number1));   // 'sum' return new object

        System.out.print("number2 - number1 = ");   // Testing -
        ComplexIO.println(number2.diff(number1));   // 'diff' return new object

        System.out.print("number2 * number1 = ");   // Testing *
        ComplexIO.println(number2.mul(number1));   // 'mul' return new object

        System.out.print("number2 / number1 = ");   // Testing /
        ComplexIO.println(number2.div(number1));   // 'div' return new object

        System.out.printf("|number1| = " + round.format(number1.abs()) + '\n');    // Testing abs
        System.out.printf("Arg(number1) = " + round.format(number2.arg()) + '\n');    // Testing arg

        System.out.print("number1^3 = ");   // Testing pow
        ComplexIO.println(number1.pow(3));
        System.out.print("number2^2 = ");
        ComplexIO.println(number2.pow(2));

        System.out.print("number1^(1/2) = ");   // Testing root
        ComplexIO.println(number1.root(2));   // 'root' return new object
        System.out.print("number2^(1/3) = ");
        ComplexIO.println(number2.root(3));


        System.out.println("\n--- Matrix ---");
        Matrix matrix1 = new Matrix(3, 3), matrix2 = new Matrix(3, 3);
        MatrixIO.fillRandInt(matrix1);
        MatrixIO.fillRandComplex(matrix2);
        System.out.println("matrix1:"); MatrixIO.print(matrix1);
        System.out.println("det(matrix1):");   // Testing determinant
        ComplexIO.println(matrix1.determinant());

        System.out.println("matrix2:"); MatrixIO.print(matrix2);
        System.out.println("det(matrix2):");   // Testing determinant
        ComplexIO.println(matrix2.determinant());

        System.out.println("matrix1 + matrix2 (returns new matrix):");   // Testing sum(+) of matrices, returns new matrix
        MatrixIO.print(matrix1.sum(matrix2));

        System.out.println("matrix1 - matrix2 (returns new matrix):");   // Testing diff(-) of matrices, returns new matrix
        MatrixIO.print(matrix1.diff(matrix2));

        System.out.println("matrix1 * matrix2 (returns new matrix):");   // Testing mul(*) of matrices, returns new matrix
        MatrixIO.print(matrix1.mul(matrix2));

        System.out.println("matrix1 * 5:");   // Testing mul(*) on const of matrix
        matrix1.mul_number(5);
        MatrixIO.print(matrix1);
        matrix1.mul_number(0.2);

        System.out.println("Transposed matrix1:");   // Testing transposing of matrix
        matrix1.T();
        MatrixIO.print(matrix1);

        System.out.println("(matrix2)^2:");   // Testing pow of matrix
        matrix2.pow(2);
        MatrixIO.print(matrix2);

        System.out.println("matrix1.inv:");   // Testing inversion of matrix
        Matrix matrix1_inv = matrix1.inverse();
        MatrixIO.print(matrix1_inv);

        System.out.println("matrix1 * matrix1.inv = E:");   // E - unit matrix (Еденичная матрица)
        MatrixIO.print(matrix1.mul(matrix1_inv));

    }
}
