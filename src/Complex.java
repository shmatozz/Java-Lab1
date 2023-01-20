import java.text.DecimalFormat;

public class Complex {
    static DecimalFormat round = new DecimalFormat("#.###");
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


    void print() {
        if (this.imag > 0) {
            System.out.println(round.format(real) + " + " + round.format(imag) + "j");
        } else {
            System.out.println(round.format(real) + " - " + (round.format(imag * -1)) + "j");
        }
    }

    Complex add(Complex second) {
        Complex temp = new Complex();
        temp.real = this.real + second.real;
        temp.imag = this.imag + second.imag;
        return temp;
    }

    Complex dec(Complex second) {
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
        return Math.atan(this.imag / this.real);
    }

    Complex pow(int n) {
        Complex temp = new Complex();
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
}