
package com.eonsahead.swing;


public class Vector {
    
    public final double elements[]; 
    //public double x;
    //public double y;
    //public double z;
    
    public Vector() {
        this.elements = new double[4];
        for (int i = 0; i < 4; i++){
            this.elements[i] = 0;
        } //for
    } //Vector()
    
    public Vector(int x, int y, int z) {
        this.elements = new double[4];
        this.set(0, x);
        this.set(1, y);
        this.set(2, z);
        this.set(3, 1);
    } //Vector( double, double, double )
    
    public void set(int index, double val) {
        this.elements[index] = val;
    } //set()
    
    public double get(int index) {
        return elements[index];
    } //get
    
    public double dot(Vector v) {
        double xProduct = this.get(0) * v.get(0);
        double yProduct = this.get(1) * v.get(1);
        double zProduct = this.get(2) * v.get(2);
        double sum = xProduct + yProduct + zProduct;
        return sum;
//        double sum = 0;
//        double product;
//        for (int i = 0; i < 4; i++) {
//            product = this.get(i) * v.get(i);
//            sum += product;
//        } //for
//        return sum;
    } //dot( double )
    
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } // magnitude()
    
    public Vector normalize() {
        Vector norm = new Vector();
        norm.set(0, (this.elements[0] /= magnitude()));
        norm.set(1, (this.elements[1] /= magnitude()));
        norm.set(2, (this.elements[2] /= magnitude()));
        return norm;
    } //normalize()
    
    public Vector cross(Vector v){
        Vector cross = new Vector();
        double crossX = (this.elements[1] * v.elements[2]) - (this.elements[2] * v.elements[1]);
        double crossY = (this.elements[2] * v.elements[0]) - (this.elements[0] * v.elements[2]);
        double crossZ = (this.elements[0] * v.elements[1]) - (this.elements[1] * v.elements[0]);
        cross.set(0, crossX);
        cross.set(1, crossY);
        cross.set(2, crossZ);
        return cross;
    } // cross( Vector )
} // Vector
