/**
 * Комплексные числа
 */
public class Complex {
    /**
     * Действительная и мнимая части
     */
    private double real, imag;

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
     * Сеттер действительной части
     * @param real действительная часть
     */
    void setReal(double real) {
        this.real = real;
    }

    /**
     * Геттер действительной части
     * @return действительная часть числа
     */
    double getReal() {
        return this.real;
    }

    /**
     * Геттер мнимой части
     * @return мнимая часть числа
     */
    double getImag() {
        return this.imag;
    }

    /**
     * Сеттер мнимой части
     * @param imag мнимая часть
     */
    void setImag(double imag) {
        this.imag = imag;
    }

    /**
     * Добавление(+) к объекту
     * @param second добавляемое число
     */
    void add(Complex second) {
        this.real += second.getReal();
        this.imag += second.getImag();
    }

    /**
     * Вычитание(-) из объекта
     * @param second вычитаемое число
     */
    void sub(Complex second) {
        this.real -= second.getReal();
        this.imag -= second.getImag();
    }

    /**
     * Сумма двух чисел
     * @param second второе слагаемое
     * @return сумма чисел
     */
    Complex sum(Complex second) {
        Complex temp = new Complex(this.real + second.getReal(), this.imag + second.getImag());
        return temp;
    }

    /**
     * Разность двух чисел
     * @param second вычитаемое
     * @return разность чисел
     */
    Complex diff(Complex second) {
        Complex temp = new Complex(this.real - second.getReal(), this.imag - second.getImag());
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
}