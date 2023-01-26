import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Комплексные числа
 */
public class Complex {
    static DecimalFormat round = new DecimalFormat("#.###");
    static double error = Math.pow(10, -10);
    /**
     * Действительная и мнимая части
     */
    double real, imag;

    /**
     * Конструктор по умолчанию
     */
    Complex() {
        this(0, 0);
    }

    /**
     * Конструктор с параметрами
     *
     * @param real действительная часть
     * @param imag мнимая часть
     */
    Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * Конструктор копирования
     *
     * @param second копируемое число
     */
    Complex(Complex second) {
        this.real = second.real;
        this.imag = second.imag;
    }

    /**
     * Ввод комплексного числа
     */
    void get() {
        Scanner in = new Scanner(System.in);
        System.out.print("real and imag: ");
        this.real = in.nextDouble();
        this.imag = in.nextDouble();
    }

    /**
     * Добавление(+) к объекту
     * @param second добавляемое число
     */
    void add(Complex second) {
        this.real += second.real;
        this.imag += second.imag;
    }

    /**
     * Вычитание(-) из объекта
     * @param second вычитаемое число
     */
    void sub(Complex second) {
        this.real -= second.real;
        this.imag -= second.imag;
    }

    /**
     * Сумма двух чисел
     * @param second второе слагаемое
     * @return сумма чисел
     */
    Complex sum(Complex second) {
        Complex temp = new Complex();
        temp.real = this.real + second.real;
        temp.imag = this.imag + second.imag;
        return temp;
    }

    /**
     * Разность двух чисел
     * @param second вычитаемое
     * @return разность чисел
     */
    Complex diff(Complex second) {
        Complex temp = new Complex();
        temp.real = this.real - second.real;
        temp.imag = this.imag - second.imag;
        return temp;
    }

    /**
     * Умножение
     * @param second второй множитель
     * @return произведение чисел
     */
    Complex mul(Complex second) {
        Complex temp = new Complex();
        temp.real = this.real * second.real - this.imag * second.imag;
        temp.imag = this.real * second.imag + this.imag * second.real;
        return temp;
    }

    /**
     * Деление
     * @param second числитель
     * @return часное двух чисел
     */
    Complex div(Complex second) {
        Complex temp = new Complex();
        temp.real = (this.real * second.real + this.imag * second.imag) / (Math.pow(second.real, 2) + Math.pow(second.imag, 2));
        temp.imag =  (second.real * this.imag - this.real * second.imag) / (Math.pow(second.real, 2) + Math.pow(second.imag, 2));
        return temp;
    }

    /**
     * Модуль комлексного числа
     * @return модуль числа
     */
    double abs() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    /**
     * Аргумент комплексного числа
     * @return аргумент числа
     */
    double arg() {
        if (this.real > 0) return Math.atan(this.imag / this.real);
        else if (this.real < 0 && this.imag >= 0) return Math.PI + Math.atan(this.imag / this.real);
        else if (this.real < 0 && this.imag < 0) return -Math.PI + Math.atan(this.imag / this.real);
        else if (this.real == 0 && this.imag > 0) return Math.PI / 2;
        else return -Math.PI / 2;
    }

    /**
     * Возведение в степень
     * @param n степень
     * @return число возведённое в степень n
     */
    Complex pow(int n) {
        Complex temp = new Complex(this);
        temp.real = Math.pow(this.abs(), n) * Math.cos(n * this.arg());
        temp.imag = Math.pow(this.abs(), n) * Math.sin(n * this.arg());
        return temp;
    }

    /**
     * Корень
     * @param n степень корня
     * @return корень n-ой степени из числа
     */
    Complex root(int n) {
        Complex temp = new Complex();
        temp.real = Math.pow(this.abs(), 1.0/n) * Math.cos(this.arg() / n);
        temp.imag = Math.pow(this.abs(), 1.0/n) * Math.sin(this.arg() / n);
        return temp;
    }

    /**
     * Вывод числа без переноса строки
     */
    void print() {
        if (this.real == 0 && this.imag != 0) {
            System.out.print(round.format(imag) + "j ");
        } else if (this.imag > 0) {
            System.out.print(round.format(real) + " + " + round.format(imag) + "j ");
        } else if (this.imag < 0){
            System.out.print(round.format(real) + " - " + (round.format(imag * -1)) + "j ");
        } else {
            System.out.print(round.format(real) + " ");
        }
    }

    /**
     * Вывод числа с переносом строки
     */
    void println() {
        if (Math.abs(this.real) < error && Math.abs(this.imag) > error) {
            System.out.println(round.format(imag) + "j");
        } else if (this.imag > error) {
            System.out.println(round.format(real) + " + " + round.format(imag) + "j");
        } else if (this.imag < -error){
            System.out.println(round.format(real) + " - " + (round.format(imag * -1)) + "j");
        } else {
            if (Math.abs(real) < error && real < 0) this.real = 0;
            System.out.println(round.format(real));
        }
    }

    /**
     * Вывод в тригонометрической форме
     */
    void printTrig() {
        System.out.printf("%.3f * (cos(%.3f) + j*sin(%.3f))\n", this.abs(), this.arg(), this.arg());
    }

    /**
     * Вывод в показательной форме
     */
    void printExp() {
        System.out.printf("%.3f * e^(j * %.3f)\n", this.abs(), this.arg());
    }

    /**
     * Запись числа в String
     * @return строка с алгебраической записью числа
     */
    String asString() {
        if (Math.abs(this.real) < error && Math.abs(this.imag) > error) {       // real = 0 & imag != 0
            return round.format(imag) + "j ";
        } else if (this.imag > error) {     // imag > 0
            return round.format(real) + " + " + round.format(imag) + "j ";
        } else if (this.imag < -error){     // imag < 0
            return round.format(real) + " - " + (round.format(imag * -1)) + "j ";
        } else {
            if (Math.abs(real) < error && real < 0) this.real = 0;
            return round.format(real) + " ";
        }
    }
}