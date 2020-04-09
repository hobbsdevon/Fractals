/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eonsahead.swing;

import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author devonhobbs
 */
public class MatrixTest {
    
    double EPSILON = .0001;
    private final Random rng = new Random();
    
    public MatrixTest() {
    }

    @Test
    public void testGet() {
        System.out.println("get");
        int row = 0;
        int column = 0;
        Matrix instance = new Matrix();
        double expResult = 1.0;
        double result = instance.get(row, column);
        assertEquals(expResult, result, EPSILON);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSet() {
        System.out.println("set");
        int row = 0;
        int column = 0;
        double value = 0.0;
        double expResult = 0.0;
        Matrix instance = new Matrix();
        instance.set(row, column, value);
        assertEquals(expResult, instance.get(0, 0));
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIdentity() {
        System.out.println("identity");
        Matrix instance = new Matrix();
        instance.identity();
        double diagonalElement = 1.0;
        double nonDiagonalElement = 0.0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                double actual = instance.get(i, j);
                if (i == j) {
                    assertEquals(diagonalElement, actual, 1E-8);
                } // if
                else {
                    assertEquals(nonDiagonalElement, actual, 1E-8);
                } // else
            } // for
        } // for
    } // testIdentity()
    

    @Test
    public void testRotationX() {
        System.out.println("rotationX");
        double angle = Math.PI;
        Matrix instance = new Matrix();
        double exp1 = -1;
        double exp2 = 0;
        double exp3 = 0;
        double exp4 = -1;
        instance.rotationX(angle);
        assertEquals(exp1, instance.get(1, 1), EPSILON);
        assertEquals(exp2, instance.get(1, 2), EPSILON);
        assertEquals(exp3, instance.get(2, 1), EPSILON);
        assertEquals(exp4, instance.get(2, 2), EPSILON);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRotationY() {
        System.out.println("rotationY");
        double angle = Math.PI;
        Matrix instance = new Matrix();
        double exp1 = -1;
        double exp2 = 0;
        double exp3 = 0;
        double exp4 = -1;
        instance.rotationY(angle);
        assertEquals(exp1, instance.get(0, 0), EPSILON);
        assertEquals(exp2, instance.get(0, 2), EPSILON);
        assertEquals(exp3, instance.get(2, 0), EPSILON);
        assertEquals(exp4, instance.get(2, 2), EPSILON);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRotationZ() {
        System.out.println("rotationZ");
        double angle = Math.PI;
        double exp1 = -1;
        double exp2 = 0;
        double exp3 = 0;
        double exp4 = -1;
        Matrix instance = new Matrix();
        instance.rotationZ(angle);
        assertEquals(exp1, instance.get(0, 0), EPSILON);
        assertEquals(exp2, instance.get(0, 1), EPSILON);
        assertEquals(exp3, instance.get(1, 0), EPSILON);
        assertEquals(exp4, instance.get(1, 1), EPSILON);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testScale() {
        System.out.println("scale");
        double xFactor = 2.0;
        double yFactor = 2.0;
        double zFactor = 2.0;
        double expX = 2;
        double expY = 2;
        double expZ = 2;
        Matrix instance = new Matrix();
        instance.scale(xFactor, yFactor, zFactor);
        assertEquals(expX, instance.get(0, 0), EPSILON);
        assertEquals(expY, instance.get(1, 1), EPSILON);
        assertEquals(expX, instance.get(2, 2), EPSILON);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testTranslate() {
        double deltaX = this.rng.nextDouble();
        double deltaY = this.rng.nextDouble();
        double deltaZ = this.rng.nextDouble();
        
        Matrix forward = new Matrix();
        forward.translate(deltaX, deltaY, deltaZ);

        Matrix backward = new Matrix();
        backward.translate(-deltaX, -deltaY, -deltaZ);
        
        Matrix product = forward.multiply(backward);
        Matrix identity = new Matrix();
        identity.identity();
        
        for( int i = 0; i < 4; i++ ) {
            for( int j = 0; j < 4; j++ ) {
                double a = product.get(i,j);
                double b = identity.get(i,j);
                assertEquals( a, b, EPSILON);
            }
        }
    }
    

    @Test
    public void testMultiply_Matrix() {
        System.out.println("multiply");
        Matrix instance = new Matrix();
        Matrix otherMatrix = new Matrix();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                double r = rng.nextDouble();
                otherMatrix.set(i, j, r);
            } 
        } 
        Matrix result = instance.multiply(otherMatrix);
        for( int i = 0; i < 4; i++ ) {
            for( int j = 0; j < 4; j++ ) {
                double a = otherMatrix.get(i, j);
                double b = result.get(i, j);
                assertEquals( a, b, EPSILON );
            }
        }
    } 
    

    @Test
    public void testMultiply_Vector() {
        System.out.println("multiply");
        Vector v = new Vector(1, 0, 0, 0);
        Matrix instance = new Matrix();

        Vector result = instance.multiply(v);
        
        double expX = 1;
        double expY = 0;
        double expZ = 0;
        
        assertEquals(expX, result.get(0), EPSILON);
        assertEquals(expY, result.get(1), EPSILON);
        assertEquals(expZ, result.get(2), EPSILON);
        //fail("The test case is a prototype.");
    }

    
}
