/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eonsahead.swing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author devonhobbs
 */
public class VectorTest {
    
    double EPSILON = 0.0001; 
    
    public VectorTest() {
        
    }

    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        double val = 3.0;
        Vector instance = new Vector();
        instance.set(index, val);
        double expResult = 3.0;
        double result = instance.get(0);        
        assertEquals(expResult, result, EPSILON);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        Vector instance = new Vector();
        double expResult = 0.0;
        double result = instance.get(index);
        assertEquals(expResult, result, EPSILON);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testDot() {
        System.out.println("dot");
        Vector a = new Vector(1, 0, 0, 0);
        Vector b = new Vector(0, 1, 0, 0);
        double expResult = 0.0;
        double result = a.dot(b);
        assertEquals(expResult, result, EPSILON);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testMagnitude() {
        System.out.println("magnitude");
        Vector a = new Vector(1, 0, 0, 0);
        double expResult = 1;
        double result = a.magnitude();
        assertEquals(expResult, result, EPSILON);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testNormalize() {
        System.out.println("normalize");
        Vector c = new Vector(2, 0, 0, 0);
        c.normalize();
        double expX = 1;
        double expY = 0;
        double expZ = 0;
        double expH = 0;
        assertEquals(expX, c.get(0));
        assertEquals(expY, c.get(1));
        assertEquals(expZ, c.get(2));
        assertEquals(expH, c.get(3));
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCross() {
        System.out.println("cross");
        Vector a = new Vector(1, 0, 0, 0);
        Vector c = new Vector(3, 9, 4, 0);
        Vector result = a.cross(c);
        double expX = 0;
        double expY = -4;
        double expZ = 9;
        double expH = 0;
        assertEquals(expX, result.get(0));
        assertEquals(expY, result.get(1));
        assertEquals(expZ, result.get(2));
        assertEquals(expH, result.get(3));
        ///fail("The test case is a prototype.");
    }
    
}
