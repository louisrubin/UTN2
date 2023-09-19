package POO.Ejer6;
public class MyComplex {
    private double real = 0.0, imag = 0.0;

    public MyComplex() {

    }
    public MyComplex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "("+real+"+"+imag+")";
    }
    public boolean isReal(){
        // verifica que el numero no sea un Not-a-Number (NaN)
        return ! Double.isNaN(real);
    }
    public boolean isImaginary(){
        // verifica que la imagen no sea un Not-a-Number (NaN)
        return ! Double.isNaN(imag);
    }
    public  boolean equals(double real, double imag){
        return real == imag;
    }
    public boolean equals(MyComplex complex){
        return (real == complex.real && imag == complex.imag);
    }
    public double magnitude(){
        // se debe multiplicar el valor en grados por PI/180
        return real * Math.PI / 180;
    }
    public double argument(){
        // se debe multiplicar el valor en grados por PI/180
        return imag * Math.PI / 180;
    }

    public MyComplex add()


    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }
}
