package core.lecture2_06_Defining_classes.practice;

public class Complex {
	private final double re; // the real part
	private final double im; // the imaginary part

	// sample client for testing
	public static void main(String[] args) {
		Complex a = new Complex(8.0, 87.0);
		Complex b = new Complex(0.0, 0.0);
		System.out.println("a            = " + a);
		System.out.println("b            = " + b);
		System.out.println("Re(a)        = " + a.getRe());
		System.out.println("Im(a)        = " + a.getIm());
		System.out.println("a * number   = " + a.multiply(5.0));
		System.out.println("a / number   = " + a.divides(4.6));
		System.out.println("b + a        = " + b.plus(a));
		System.out.println("a - b        = " + a.minus(b));
		System.out.println("a * b        = " + a.multiply(b));
		System.out.println("b * a        = " + b.multiply(a));
		System.out.println("a / b        = " + a.divides(b));		
		System.out.println("conj(a)      = " + a.conjugate());
		System.out.println("|a|          = " + a.abs());
		System.out.println("tan(a)       = " + a.tan());
	}

	// create a new object with the given real and imaginary parts
	public Complex(double real, double imag) {
		re = real;
		im = imag;
	}

	// return a string representation of the invoking Complex object
	public String toString() {
		if (im == 0)
			return re + "";
		if (re == 0)
			return im + "i";
		if (im < 0)
			return re + " - " + (-im) + "i";
		return re + " + " + im + "i";
	}

	// return abs/modulus/magnitude and angle/phase/argument
	public double abs() {
		return Math.hypot(getRe(), getIm());
	} // Math.sqrt(re*re + im*im)

	public double phase() {
		return Math.atan2(getRe(), getIm());
	} // between -pi and pi

	// return a new Complex object whose value is (this + b)
	public Complex plus(Complex b) {
		double real = this.getRe() + b.getRe();
		double imag = this.getIm() + b.getIm();
		return new Complex(real, imag);
	}

	// return a new Complex object whose value is (this - b)
	public Complex minus(Complex b) {
		double real = this.getRe() - b.getRe();
		double imag = this.getIm() + b.getIm();
		return new Complex(real, imag);
	}

	// return a new Complex object whose value is (this * b)
	public Complex multiply(Complex b) {
		double real = this.getRe() * b.getRe() - this.getIm() * b.getIm();
		double imag = this.getRe() * b.getIm() + this.getIm() * b.getRe();
		return new Complex(real, imag);
	}

	// scalar multiplication
	// return a new object whose value is (this * alpha)
	public Complex multiply(double alpha) {
		return new Complex(alpha * this.getRe(), alpha * this.getIm());
	}

	// return a new Complex object whose value is the conjugate of this
	public Complex conjugate() {
		return new Complex(this.getRe(), -this.getIm());
	}

	// return a new Complex object whose value is the reciprocal of this
	public Complex reciprocal() {
		double scale = this.getRe() * this.getRe() + this.getRe() * this.getIm();
		return new Complex(this.getRe() / scale, -this.getRe() / scale);
	}
	
	public Complex divides(double b) {
		if(b == 0) {
			return null;
		} else {
			return new 	Complex(this.getRe()/b, this.getIm()/b);
		}
	}

	// return a / b
	public Complex divides(Complex b) {		
		double numerator = b.getRe() * b.getRe() - b.getIm() * b.getIm();
		Complex temp;
		if(numerator == 0) {
			return null;
		} else {
			temp = new Complex(b.getRe(), -b.getIm());
			return this.multiply(temp).divides(numerator);
		}
	}

	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}

	// return a / b
	public Complex dividesNew(Complex b) {
		Complex с = null;
		double scale = re * re + im * im;
		if (scale == 0) {
			return null;
		} else {
			с = new Complex(re / scale, -im / scale);
			return b.multiply(с);
		}
	}

	// return a new Complex object whose value is the complex exponential of
	// this
	public Complex exp() {
		return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re)
				* Math.sin(im));
	}

	// return a new Complex object whose value is the complex sine of this
	public Complex sin() {
		return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re)
				* Math.sinh(im));
	}

	// return a new Complex object whose value is the complex cosine of this
	public Complex cos() {
		return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re)
				* Math.sinh(im));
	}

	// return a new Complex object whose value is the complex tangent of this
	public Complex tan() {
		return sin().divides(cos());
	}

	// System.out.println("(a / b) * b  = " + a.divides(b).multiply(b));
	// a static version of plus
	public static Complex plus(Complex a, Complex b) {
		double real = a.re + b.re;
		double imag = a.im + b.im;
		Complex sum = new Complex(real, imag);
		return sum;
	}
}
