/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;

/**
 *
 * @author devonhobbs
 */
public class Complex {
    
    public double real;
    public double imaginary;
    
    Complex(double real, double imaginary){
       
    } //Complex(double, double)
    
    public double getReal(){
        return real;
    } //getReal()
    
    public double getImaginary(){
        return imaginary;
    } //getImaginary()
    
    public void setReal(double val){
        real = val;
    } //setReal(double)
    
    public void setImaginary(double val){
        imaginary = val;
    } //setImaginary(double)
    
    public Complex add(Complex c){       
        double sumReal = this.real + c.real;
        double sumImaginary = this.imaginary + c.imaginary;
        Complex sum = new Complex(sumReal, sumImaginary);
        return sum;
    } //add(Complex)
    
    public Complex multiply(Complex c){
       double first = this.real * c.real;
       double outer = this.real * c.imaginary;
       double inner = this.imaginary * c.real;
       double last = this.imaginary * c.imaginary;
       double realProduct = first - last;
       double imaginaryProduct = outer + inner;
       Complex product = new Complex(realProduct, imaginaryProduct);
       return product;
    } //multiply(Complex)
    
    public double magnitude(){
        double magnitude = Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
        return magnitude;
    } //magnitude()
} //Complex
