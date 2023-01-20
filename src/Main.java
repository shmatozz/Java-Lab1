import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        DecimalFormat round = new DecimalFormat("#.###");   // Для округления дробных чисел

        Complex number1 = new Complex(1, 3);    // Число 1
        Complex number2 = new Complex(2, 4);    // Число 2
        Complex test = new Complex(number2);    // Тестовая переменная

        System.out.print("number1 = "); number1.print();
        System.out.print("number2 = "); number2.print();
        System.out.print("\nCopy of number2 = "); test.print();

        System.out.print("number2 + number1 = ");   // Testing +
        number2.add(number1).print();

        System.out.print("number2 - number1 = ");   // Testing -
        number2.dec(number1).print();

        System.out.print("number2 * number1 = ");   // Testing *
        number2.mul(number1).print();

        System.out.print("number2 / number1 = ");   // Testing /
        number2.div(number1).print();

        System.out.printf("|number1| = " + round.format(number1.abs()) + '\n');    // Testing abs
        System.out.printf("Arg(number1) = " + round.format(number2.arg()) + '\n');    // Testing arg

        System.out.print("number1^3 = ");   // Testing pow
        number1.pow(3).print();
        System.out.print("number2^2 = ");
        number2.pow(2).print();

        System.out.print("number1^(1/2) = ");
        number1.sqrt(2).print();
        System.out.print("number2^(1/3) = ");
        number2.sqrt(3).print();
    }
}