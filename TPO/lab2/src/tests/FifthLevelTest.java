package tests;

import functions.*;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Double.NaN;
import static org.junit.Assert.assertEquals;

public class FifthLevelTest {
    static double EPSILON = 0.005;
    static double PERIOD = 2 * Math.PI;
    static final double PI = Math.PI;
    double PRECISION = 1E-3;
    static Functions f = new Functions();
    static SystemSolver ss = new SystemSolver(f);

    @Test
    public void firstAreaTest() {
        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(-2 * PI - EPSILON), PRECISION);
        assertEquals(12.77515403, ss.solveSystem(-4.00), PRECISION);
        assertEquals(12.77515403, ss.solveSystem(-4.00 - PERIOD), PRECISION);

        assertEquals(5.821610467, ss.solveSystem(-5.00), PRECISION);
        assertEquals(5.821610467, ss.solveSystem(-5.00 - PERIOD), PRECISION);

        assertEquals(361.5328096, ss.solveSystem(-6.00), PRECISION);
        assertEquals(361.5328096, ss.solveSystem(-6.00 - PERIOD), PRECISION);
    }

    @Test
    public void firstGapTest() {
        assertEquals(Double.NaN, ss.solveSystem(-PI), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(-PI - PERIOD), PRECISION);

        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(- PI - EPSILON), PRECISION);
        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(- PI + EPSILON), PRECISION);
        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(- PI - EPSILON - PERIOD), PRECISION);
        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(- PI + EPSILON - PERIOD), PRECISION);
    }

    @Test
    public void secondAreaTest() {
        assertEquals(107.6057931, ss.solveSystem(-2.25), PRECISION);
        assertEquals(107.6057931, ss.solveSystem(-2.25 - PERIOD), PRECISION);

        assertEquals(0.00253828, ss.solveSystem(-2.65), PRECISION);
        assertEquals(0.00253828, ss.solveSystem(-2.65 - PERIOD), PRECISION);

        assertEquals(67.39837551, ss.solveSystem(-2.90), PRECISION);
        assertEquals(67.39837551, ss.solveSystem(-2.90 - PERIOD), PRECISION);
    }

    @Test
    public void secondGapTest() {
        assertEquals(Double.NaN, ss.solveSystem(-PI/2), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(-PI/2 - PERIOD), PRECISION);

        assertEquals(Double.NaN, ss.solveSystem(- PI/2 - EPSILON), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(- PI/2 + EPSILON), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(- PI/2 - EPSILON - PERIOD), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(- PI/2 + EPSILON - PERIOD), PRECISION);
    }

    @Test
    public void thirdAreaTest() {
        assertEquals(107.6057930, ss.solveSystem(-2.25), PRECISION);
        assertEquals(107.6057930, ss.solveSystem(-2.25 - PERIOD), PRECISION);

        assertEquals(0.00253829, ss.solveSystem(-2.65), PRECISION);
        assertEquals(0.00253829, ss.solveSystem(-2.65 - PERIOD), PRECISION);

        assertEquals(67.39837552, ss.solveSystem(-2.90), PRECISION);
        assertEquals(67.39837552, ss.solveSystem(-2.90 - PERIOD), PRECISION);
    }

    @Test
    public void zeroAreaTest() {
        assertEquals(Double.NaN, ss.solveSystem(0.0), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(0.0 - PERIOD), PRECISION);

        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(0.0 - EPSILON), PRECISION);
        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(0.0 - EPSILON - PERIOD), PRECISION);

        assertEquals(Double.NaN, ss.solveSystem(0.0 + 1E-10), PRECISION);
    }

    @Test
    public void secondFunctionTest() {
        //Значение между 0 и перегибом
        assertEquals(-0.748515, ss.solveSystem(0.50), PRECISION);
        // Значение в точке перегиба
        assertEquals(-0.731706554, ss.solveSystem(1.000000000001), PRECISION);
        //Значение в точке пересечения оси Ох
        assertEquals(0.0, ss.solveSystem(11.455), PRECISION);
        //Значения на возрастающей кривой после пересечения
        assertEquals(0.270635059, ss.solveSystem(15.0), PRECISION);
        assertEquals(1.254119185, ss.solveSystem(30.0), PRECISION);
    }
}
