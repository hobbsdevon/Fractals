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
public class Vector {
    
    public double v01;
    public double v02;
    public double p01;
    public double p02;
    
    public Vector(double v01, double v02){
        
    }
    
    public Vector mult(double e00, double e01, double e10, double e11){
        double p01 = this.v01 * e00 + this.v01 * e01;
        double p02 = this.v02 * e10 + this.v02 * e11;
        
        Vector product = new Vector(p01, p02);
        
        return product;
    }
    
    @Override
    public String toString(){
        System.out.println(v01);
        return p01 + ", " + p02;
    }
    
    public static void main(String[] args){
       Matrix a = new Matrix(3, 2, 1, 5);
       Matrix product = a.mult(6, 2, 4, 8);
       System.out.println(product);
       
       Vector v = new Vector(3, 9);
       Vector p = v.mult(3, 2, 1, 5);
       System.out.println(p);
       
       
    }
            
            
}
