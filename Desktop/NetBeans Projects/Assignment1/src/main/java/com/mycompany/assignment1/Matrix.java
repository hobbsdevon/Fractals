/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment1;

/**
 *
 * @author devonhobbs
 */
public class Matrix {
    
    public double e00;
    public double e01;
    public double e10;
    public double e11;
    public double p00;
    public double p01;
    public double p10;
    public double p11;
    
    public Matrix(double e00, double e01, double e10, double e11){
        
    }//Matrix(double, double, double, double)
    
    public Matrix mult(double e00, double e01, double e10, double e11){
        double p00 = this.e00 * e00 + this.e01 * e10;
        double p01 = this.e00 * e01 + this.e01 * e11;
        double p10 = this.e10 * e00 + this.e11 * e10;
        double p11 = this.e10 * e00 + this.e11 * e11;
        
        Matrix p = new Matrix(p00, p01, p10, p11);
        
        return p;
    }//mult
    
    @Override
    public String toString(){
        return p00 + ", " + p01 + ", " + p10 + ", " + p11;
    }
}//Matrix
