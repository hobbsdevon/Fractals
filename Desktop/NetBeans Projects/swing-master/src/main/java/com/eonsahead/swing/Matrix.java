package com.eonsahead.swing;

import java.util.HashSet;

/**
 * Model Matrices
 * @author devonhobbs
 */
public class Matrix {

    private final double[][] elements;

    /**
     * Makes a 4x4 identity matrix
     */
    public Matrix() {
        this.elements = new double[4][4];
        this.identity();
    } // Matrix()
    
    /**
     * Gets the value of a certain element in the matrix
     * @param row Which row you check
     * @param column Which column you check
     * @return The value of the element at that row and column number
     */
    public double get(int row, int column) {
        return this.elements[row][column];
    } // get( int, int )

    /**
     * Sets the value of a certain element in the matrix
     * @param row Which row you want to change
     * @param column Which column you want to change
     * @param value The value you wish to input at that row and column number
     */
    public void set(int row, int column, double value) {
        this.elements[row][column] = value;
    } // set( int, int, double )

    /**
     * Makes this matrix an identity matrix
     */
    public final void identity() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    this.set(i, j, 1.0);
                } // if
                else {
                    this.set(i, j, 0.0);
                } // else
            } // for
        } // for
    } // identity()

    /**
     * Rotates this matrix about the X axis
     * @param angle The angle you wish to rotate by
     */
    public void rotationX(double angle) {
        this.identity();
        this.set(1, 1, Math.cos(angle));
        this.set(1, 2, Math.sin(angle));
        this.set(2, 1, -Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    } // rotationX( double )

    /**
     * Rotates this matrix about the Y axis
     * @param angle The angle you wish to rotate by
     */
    public void rotationY(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 2, -Math.sin(angle));
        this.set(2, 0, Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    } // rotationY( double )

    /**
     * Rotates this matrix about the Z axis
     * @param angle The angle you wish to rotate by
     */
    public void rotationZ(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 1, -Math.sin(angle));
        this.set(1, 0, Math.sin(angle));
        this.set(1, 1, Math.cos(angle));
    } // rotationZ( double )

    /**
     * Scales this matrix
     * @param xFactor How much you wish to scale it in the X direction
     * @param yFactor How much you wish to scale it in the Y direction
     * @param zFactor How much you wish to scale it in the Z direction
     */
    public void scale(double xFactor, double yFactor, double zFactor) {
        this.identity();
        this.set(0, 0, (xFactor));
        this.set(1, 1, (yFactor));
        this.set(2, 2, (zFactor));
    } // scale( double )

    /**
     * Moves, or translates, this vector
     * @param xVal How much you wish to move it in the X direction
     * @param yVal How much you wish to move it in the Y direction
     * @param zVal How much you wish to move it in the Z direction
     */
    public void translate(double xVal, double yVal, double zVal) {
        this.identity();
        this.set(0, 0, (zVal));
        this.set(1, 1, (yVal));
        this.set(2, 2, (zVal));
    } // translate( double, double, double )

    /**
     * Computes the product of two matrices
     * @param otherMatrix The other matrix you wish to multiply
     * @return A third matrix which is the product of this matrix and otherMatrix
     */
    public Matrix multiply(Matrix otherMatrix) {
        Matrix product = new Matrix();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                double sum = 0.0;
                for (int k = 0; k < 4; k++) {
                    sum += this.elements[row][k]
                            * otherMatrix.elements[k][column];
                } // for
                product.set(row, column, sum);
            } // for
        } // for
        return product;
    } // multiply( Matrix )

    /**
     * Computes the product of a matrix and a vector
     * @param v The vector you wish to multiply this matrix by
     * @return Another vector which is the product of this matrix and vector v
     */
    public Vector multiply(Vector v) {
        Vector product = new Vector();
        double productX = this.elements[0][0] * v.elements[0] + this.elements[0][1] * v.elements[1]
                + this.elements[0][2] * v.elements[2];
        double productY = this.elements[1][0] * v.elements[0] + this.elements[1][1] * v.elements[1]
                + this.elements[1][2] * v.elements[2];
        double productZ = this.elements[2][0] * v.elements[0] + this.elements[2][1] * v.elements[1]
                + this.elements[2][2] * v.elements[2];
        v.set(0, productX);
        v.set(1, productY);
        v.set(2, productZ);

        return v;
    } // multiply( Vector )

    private String rowToString(int row) {
        StringBuilder result = new StringBuilder();
        result.append("( ");
        for (int i = 0; i < 3; i++) {
            result.append(this.get(row, i));
            result.append(",");
        } // for
        result.append(this.get(row, 3));
        result.append(" )");
        return result.toString();
    } // rowToString( int )

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < 4; i++) {
            result.append(rowToString(i));
        } //
        result.append(" ]");
        return result.toString();
    } // toString()

    /**
     * Supplies arguments for an array of string objects
     * @param args
     */
    public static void main(String[] args) {
        Matrix identity = new Matrix();
        System.out.println("identity = " + identity);

        Matrix product = identity.multiply(identity);
        System.out.println("product = " + product);

        Matrix ccw = new Matrix();
        ccw.rotationZ(Math.PI / 4);
        System.out.println("counter-clockwise rotation = " + ccw);

        Matrix cw = new Matrix();
        cw.rotationZ(-Math.PI / 4);
        System.out.println("clockwise rotation = " + cw);

        Matrix netRotation = ccw.multiply(cw);
        System.out.println("net rotation = " + netRotation);
    } // main( String [] )

} // Matrix
