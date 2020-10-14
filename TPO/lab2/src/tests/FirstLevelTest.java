package tests;

import functions.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

public class FirstLevelTest {
    static double EPSILON = 0.005;
    static double PERIOD = 2 * Math.PI;
    static final double PI = Math.PI;
    double PRECISION = 1E-4;
    static SystemSolver ss;

    @BeforeClass
    public static void createMock() {
        ss = Mockito.mock(SystemSolver.class, CALLS_REAL_METHODS);

        // Значения на Первой части графика + период (до и после экстремума)
        Mockito.when(ss.f2(-4.00)).thenReturn(12.77515403);
        Mockito.when(ss.f2(-4.00 - PERIOD)).thenReturn(12.77515403);

        Mockito.when(ss.f2(-5.00)).thenReturn(5.821610467);
        Mockito.when(ss.f2(-5.00 - PERIOD)).thenReturn(5.821610467);

        Mockito.when(ss.f2(-6.00)).thenReturn(361.5328096);
        Mockito.when(ss.f2(-6.00 - PERIOD)).thenReturn(361.5328096);

        // Граничное значение между Первой и Второй частями и окрестности точки -PI
        Mockito.when(ss.f2(- PI)).thenReturn(Double.NaN);
        Mockito.when(ss.f2(- PI - PERIOD)).thenReturn(Double.NaN);

        Mockito.when(ss.f2(- PI - EPSILON)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(ss.f2(- PI + EPSILON)).thenReturn(Double.POSITIVE_INFINITY);

        Mockito.when(ss.f2(- PI + EPSILON - PERIOD)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(ss.f2(- PI - EPSILON - PERIOD)).thenReturn(Double.POSITIVE_INFINITY);

        // Значения на Второй части графика + период (до и после экстремума)
        Mockito.when(ss.f2(-2.25)).thenReturn(107.6057931);
        Mockito.when(ss.f2(-2.25 - PERIOD)).thenReturn(107.6057931);

        Mockito.when(ss.f2(-2.65)).thenReturn(0.00253829);
        Mockito.when(ss.f2(-2.65 - PERIOD)).thenReturn(0.00253829);

        Mockito.when(ss.f2(-2.90)).thenReturn(67.39837552);
        Mockito.when(ss.f2(-2.90 - PERIOD)).thenReturn(67.39837552);

        // Граничное значение между Второй и Третьей частями и окрестности точки PI/2
        Mockito.when(ss.f2(- PI/2)).thenReturn(Double.NaN);
        Mockito.when(ss.f2(- PI/2 - PERIOD)).thenReturn(Double.NaN);

        Mockito.when(ss.f2(- PI/2 - EPSILON)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(ss.f2(- PI/2 + EPSILON)).thenReturn(Double.POSITIVE_INFINITY);

        Mockito.when(ss.f2(- PI/2 + EPSILON - PERIOD)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(ss.f2(- PI/2 - EPSILON - PERIOD)).thenReturn(Double.POSITIVE_INFINITY);

        // Значения на Третьей части графика + период (до и после экстремума)
        Mockito.when(ss.f2(-0.3)).thenReturn(13.68599);
        Mockito.when(ss.f2(-0.3 - PERIOD)).thenReturn(13.68599);

        Mockito.when(ss.f2(-0.6)).thenReturn(0.090227648);
        Mockito.when(ss.f2(-0.6 - PERIOD)).thenReturn(0.090227648);

        Mockito.when(ss.f2(-0.9)).thenReturn(131.1873375);
        Mockito.when(ss.f2(-0.9 - PERIOD)).thenReturn(131.1873375);

        // Значения около 0 и в эпсилон-окрестности от 0 + период
        Mockito.when(ss.f2(0.0)).thenReturn(Double.NaN);
        Mockito.when(ss.f2(0.0 - PERIOD)).thenReturn(Double.NaN);
        Mockito.when(ss.f2(0.0 - EPSILON)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(ss.f2(0.0 - EPSILON - PERIOD)).thenReturn(Double.POSITIVE_INFINITY);

        // Вторая функция (периода нет)
        // Левая граничная точка стремится к минус бесконечности
        Mockito.when(ss.f1(0.0 + EPSILON)).thenReturn(Double.NEGATIVE_INFINITY);

        //Значение между 0 и перегибом
        Mockito.when(ss.f1(0.50)).thenReturn(-0.747549086);

        // Значение в точке перегиба
        Mockito.when(ss.f1(1.0)).thenReturn(-0.731706554);

        //Значение в точке пересечения оси Ох
        Mockito.when(ss.f1(11.455)).thenReturn(0.0);

        //Значения на возрастающей кривой после пересечения
        Mockito.when(ss.f1(15.0)).thenReturn(0.270635059);
        Mockito.when(ss.f1(30.0)).thenReturn(1.254119185);
    }

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
        assertEquals(Double.NaN, ss.solveSystem(-PI/2 - 10 * PERIOD), PRECISION);

        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(- PI/2 - EPSILON), PRECISION);
        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(- PI/2 + EPSILON), PRECISION);
        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(- PI/2 - EPSILON - PERIOD), PRECISION);
        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(- PI/2 + EPSILON - PERIOD), PRECISION);
    }

    @Test
    public void thirdAreaTest() {
        assertEquals(107.6057931, ss.solveSystem(-2.25), PRECISION);
        assertEquals(107.6057931, ss.solveSystem(-2.25 - PERIOD), PRECISION);

        assertEquals(0.00253828, ss.solveSystem(-2.65), PRECISION);
        assertEquals(0.00253828, ss.solveSystem(-2.65 - PERIOD), PRECISION);

        assertEquals(67.39837551, ss.solveSystem(-2.90), PRECISION);
        assertEquals(67.39837551, ss.solveSystem(-2.90 - PERIOD), PRECISION);
    }

    @Test
    public void zeroAreaTest() {
        assertEquals(Double.NaN, ss.solveSystem(0.0), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(0.0 - PERIOD), PRECISION);

        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(0.0 - EPSILON), PRECISION);
        assertEquals(Double.POSITIVE_INFINITY, ss.solveSystem(0.0 - EPSILON - PERIOD), PRECISION);

        assertEquals(Double.NEGATIVE_INFINITY, ss.solveSystem(0.0 + EPSILON), PRECISION);
    }

    @Test
    public void secondFunctionTest() {
        //Значение между 0 и перегибом
        assertEquals(-0.747549086, ss.solveSystem(0.50), PRECISION);
        // Значение в точке перегиба
        assertEquals(-0.731706554, ss.solveSystem(1.0), PRECISION);
        //Значение в точке пересечения оси Ох
        assertEquals(0.0, ss.solveSystem(11.455), PRECISION);
        //Значения на возрастающей кривой после пересечения
        assertEquals(0.270635059, ss.solveSystem(15.0), PRECISION);
        assertEquals(1.254119185, ss.solveSystem(30.0), PRECISION);
    }
}
