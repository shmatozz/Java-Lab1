import java.text.DecimalFormat;
import java.util.Scanner;

public class ComplexIO {
    private static final DecimalFormat round = new DecimalFormat("#.###");
    private static final double error = Math.pow(10, -10);

    static void get(Complex number) {
        Scanner in = new Scanner(System.in);
        System.out.print("real and imag: ");
        number.setReal(in.nextDouble());
        number.setImag(in.nextDouble());
    }

    /**
     * Вывод числа без переноса строки
     */
    void print(Complex number) {
        if (number.getReal() == 0 && number.getImag() != 0) {
            System.out.print(round.format(number.getImag()) + "j ");
        } else if (number.getImag() > 0) {
            System.out.print(round.format(number.getReal()) + " + " + round.format(number.getImag()) + "j ");
        } else if (number.getImag() < 0){
            System.out.print(round.format(number.getReal()) + " - " + (round.format(number.getImag() * -1)) + "j ");
        } else {
            System.out.print(round.format(number.getReal()) + " ");
        }
    }

    /**
     * Вывод числа с переносом строки
     */
    static void println(Complex number) {
        if (Math.abs(number.getReal()) < error && Math.abs(number.getImag()) > error) {
            System.out.println(round.format(number.getImag()) + "j");
        } else if (number.getImag() > error) {
            System.out.println(round.format(number.getReal()) + " + " + round.format(number.getImag()) + "j");
        } else if (number.getImag() < -error){
            System.out.println(round.format(number.getReal()) + " - " + (round.format(number.getImag() * -1)) + "j");
        } else {
            if (Math.abs(number.getReal()) < error && number.getReal() < 0) number.setReal(0);
            System.out.println(round.format(number.getReal()));
        }
    }

    /**
     * Вывод в тригонометрической форме
     */
    static void printTrig(Complex number) {
        System.out.printf("%.3f * (cos(%.3f) + j*sin(%.3f))\n", number.abs(), number.arg(), number.arg());
    }

    /**
     * Вывод в показательной форме
     */
    static void printExp(Complex number) {
        System.out.printf("%.3f * e^(j * %.3f)\n", number.abs(), number.arg());
    }

    /**
     * Запись числа в String
     * @return строка с алгебраической записью числа
     */
    static String asString(Complex number) {
        if (Math.abs(number.getReal()) < error && Math.abs(number.getImag()) > error) {       // real = 0 & imag != 0
            return round.format(number.getImag()) + "j ";
        } else if (number.getImag() > error) {     // imag > 0
            return round.format(number.getReal()) + " + " + round.format(number.getImag()) + "j ";
        } else if (number.getImag() < -error){     // imag < 0
            return round.format(number.getReal()) + " - " + (round.format(number.getImag() * -1)) + "j ";
        } else {
            if (Math.abs(number.getReal()) < error && number.getReal() < 0) number.setReal(0);
            return round.format(number.getReal()) + " ";
        }
    }
}
