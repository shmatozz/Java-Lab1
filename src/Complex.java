import java.text.DecimalFormat;
import java.util.Scanner;

public class Complex {
    static DecimalFormat round = new DecimalFormat("#.###");
    static double error = 0.0000000000001;

    double real, imag;
    Complex() {
        this(0, 0);
    }
    Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }
    Complex(Complex second) {
        this.real = second.real;
        this.imag = second.imag;
    }


    void get() {
        Scanner in = new Scanner(System.in);
        System.out.print("real and imag: ");
        this.real = in.nextDouble();
        this.imag = in.nextDouble();
    }
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

    void add(Complex second) {
        this.real += second.real;
        this.imag += second.imag;
    }

    void sub(Complex second) {
        this.real -= second.real;
        this.imag -= second.imag;
    }

    Complex sum(Complex second) {
        Complex temp = new Complex();
        temp.real = this.real + second.real;
        temp.imag = this.imag + second.imag;
        return temp;
    }

    Complex diff(Complex second) {
        Complex temp = new Complex();
        temp.real = this.real - second.real;
        temp.imag = this.imag - second.imag;
        return temp;
    }

    Complex mul(Complex second) {
        Complex temp = new Complex();
        temp.real = this.real * second.real - this.imag * second.imag;
        temp.imag = this.real * second.imag + this.imag * second.real;
        return temp;
    }

    Complex div(Complex second) {
        Complex temp = new Complex();
        temp.real = (this.real * second.real + this.imag * second.imag) / (Math.pow(second.real, 2) + Math.pow(second.imag, 2));
        temp.imag =  (second.real * this.imag - this.real * second.imag) / (Math.pow(second.real, 2) + Math.pow(second.imag, 2));
        return temp;
    }

    double abs() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    double arg() {
        if (this.real > 0) return Math.atan(this.imag / this.real);
        else if (this.real < 0 && this.imag >= 0) return Math.PI + Math.atan(this.imag / this.real);
        else if (this.real < 0 && this.imag < 0) return -Math.PI + Math.atan(this.imag / this.real);
        else if (this.real == 0 && this.imag > 0) return Math.PI / 2;
        else return -Math.PI / 2;
    }

    Complex pow(int n) {
        Complex temp = new Complex(this);
        temp.real = Math.pow(this.abs(), n) * Math.cos(n * this.arg());
        temp.imag = Math.pow(this.abs(), n) * Math.sin(n * this.arg());
        return temp;
    }

    Complex sqrt(int n) {
        Complex temp = new Complex();
        temp.real = Math.pow(this.abs(), 1.0/n) * Math.cos(this.arg() / n);
        temp.imag = Math.pow(this.abs(), 1.0/n) * Math.sin(this.arg() / n);
        return temp;
    }

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