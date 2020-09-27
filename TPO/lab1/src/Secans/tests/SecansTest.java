package Secans.tests;
/*
Для создания тестового покрытия были выделены классы эквивалентности, то есть промежутки, где функция меняется схожим образом:
1. (-3Pi/2+2Pin; -Pi/2+2Pin), где n принадлежит Z.
2. (-Pi/2+2Pin; Pi/2+2Pin), где n принадлежит Z.
3. Точки, в которых функция неопределена: Pi/2 + Pin, где n принадлежит Z.
 */

import Secans.Secans;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SecansTest {

    private double EPS;

    private boolean EPS_Equals(double a, double b, double EPS) {
        return Math.abs(b - a) < EPS;
    }

    @Before
    public void SetUp() {
        EPS = Math.pow(1 ,-5);
    }
    @Test
    public void testCalcSec1() {
        
        try {
            assertTrue("test first interval. sec(-PI) = -1", EPS_Equals(1/Math.cos(-Math.PI), Secans.calcSec(-Math.PI), EPS));}
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec2() {

        try {
            assertTrue("test first interval. sec(PI) = -1", EPS_Equals(1/Math.cos(Math.PI), Secans.calcSec(Math.PI), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec3() {
        try {
            assertTrue("test first interval. sec(3PI) = -1", EPS_Equals(1/Math.cos(3*Math.PI), Secans.calcSec(3*Math.PI), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec4() {
        try {
            assertTrue("test second interval. sec(0) = 1", EPS_Equals(1/Math.cos(0.0), Secans.calcSec(0.0), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec5() {
        try {
            assertTrue("test second interval. sec(2PI) = 1", EPS_Equals(1/Math.cos(2*Math.PI), Secans.calcSec(2*Math.PI), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec6() {
        try {
            assertTrue("test second interval. sec(-2PI) = 1", EPS_Equals(1/Math.cos(-2*Math.PI), Secans.calcSec(-2*Math.PI), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec7() {
        try {
            final double EPS = 1.0e-5, FAKE_INFINITY = 1.0e8;
            assertTrue("testing in undefined point sec(Pi/2)", EPS_Equals(FAKE_INFINITY, Secans.calcSec(Math.PI / 2), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec8() {
        try {
            final double FAKE_INFINITY = 1.0e8;
            assertTrue("testing in undefined point sec(-Pi/2)", EPS_Equals(FAKE_INFINITY, Secans.calcSec(-Math.PI / 2), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec9() {
        try {
            final double FAKE_INFINITY = 1.0e8;
            assertTrue("testing in undefined point sec(3*Pi/2)", EPS_Equals(FAKE_INFINITY, Secans.calcSec(Math.PI / 2 * 3), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
    @Test
    public void testCalcSec10() {
        try {
            assertTrue("test second interval. sec(2PI) = 1", EPS_Equals(1/Math.cos(5*Math.PI/6), Secans.calcSec(5*Math.PI/6), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec11() {
        try {
            assertTrue("test second interval. sec(2PI) = 1", EPS_Equals(1/Math.cos(17*Math.PI/6), Secans.calcSec(17*Math.PI/6), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec12() {
        try {
            assertTrue("test second interval. sec(-2PI) = 1", EPS_Equals(1/Math.cos(-5*Math.PI/6), Secans.calcSec(-5*Math.PI/6), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }


    @Test
    public void testCalcSec13() {
        try {
            assertTrue("test second interval. sec(2PI) = 1", EPS_Equals(1/Math.cos(5*Math.PI/6), Secans.calcSec(5*Math.PI/6), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec14() {
        try {
            assertTrue("test second interval. sec(2PI) = 1", EPS_Equals(1/Math.cos(Math.PI/3), Secans.calcSec(Math.PI/3), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec15() {
        try {
            assertTrue("test second interval. sec(-2PI) = 1", EPS_Equals(1/Math.cos(7*Math.PI/3), Secans.calcSec(7*Math.PI/3), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void testCalcSec16() {
        try {
            assertTrue("test second interval. sec(-2PI) = 1", EPS_Equals(1/Math.cos(10*Math.PI/3), Secans.calcSec(10*Math.PI/3), EPS));
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
