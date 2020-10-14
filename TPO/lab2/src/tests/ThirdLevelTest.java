package tests;

import functions.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static java.lang.Double.NaN;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

public class ThirdLevelTest {
    static double EPSILON = 1E-10;
    static double PERIOD = 2 * Math.PI;
    static final double PI = Math.PI;
    double PRECISION = 1E-4;
    static Functions f;
    static SystemSolver ss;

    @BeforeClass
    public static void createMock() {

        f = Mockito.mock(Functions.class, CALLS_REAL_METHODS);
        ss = new SystemSolver(f);
        // Значения на Первой части графика + период (до и после экстремума)

        Mockito.when(f.sin(-4.00)).thenReturn(0.756802495);
        Mockito.when(f.cos(-4.00)).thenReturn(-0.653643621);

        Mockito.when(f.sin(-4.00 - PERIOD)).thenReturn(0.756802495);
        Mockito.when(f.cos(-4.00 - PERIOD)).thenReturn(-0.653643621);

        Mockito.when(f.sin(-5.00)).thenReturn(0.958924275);
        Mockito.when(f.cos(-5.00)).thenReturn(0.283662185);

        Mockito.when(f.sin(-5.00 - PERIOD)).thenReturn(0.958924275);
        Mockito.when(f.cos(-5.00 - PERIOD)).thenReturn(0.283662185);

        Mockito.when(f.sin(-6.00)).thenReturn(0.279415498);
        Mockito.when(f.cos(-6.00)).thenReturn(0.960170287);

        Mockito.when(f.sin(-6.00 - PERIOD)).thenReturn(0.279415498);
        Mockito.when(f.cos(-6.00 - PERIOD)).thenReturn(0.960170287);

        // Граничное значение между Первой и Второй частями и окрестности точки -PI
        Mockito.when(f.sin(-PI)).thenReturn(0.0);
        Mockito.when(f.cos(-PI)).thenReturn(-1.0);

        Mockito.when(f.sin(-PI - PERIOD)).thenReturn(0.0);
        Mockito.when(f.cos(-PI - PERIOD)).thenReturn(-1.0);

        Mockito.when(f.sin(-PI - EPSILON)).thenReturn(0.0);
        Mockito.when(f.cos(-PI - EPSILON)).thenReturn(-1.0);;

        Mockito.when(f.sin(-PI - EPSILON - PERIOD)).thenReturn(0.0);
        Mockito.when(f.cos(-PI - EPSILON - PERIOD)).thenReturn(-1.0);

        Mockito.when(f.sin(-PI + EPSILON)).thenReturn(0.0);
        Mockito.when(f.cos(-PI + EPSILON)).thenReturn(-1.0);

        Mockito.when(f.sin(-PI + EPSILON - PERIOD)).thenReturn(0.0);
        Mockito.when(f.cos(-PI + EPSILON - PERIOD)).thenReturn(-1.0);

        // Значения на Второй части графика + период (до и после экстремума)
        Mockito.when(f.sin(-2.25)).thenReturn(-0.778073197);
        Mockito.when(f.cos(-2.25)).thenReturn(-0.628173623);

        Mockito.when(f.sin(-2.25 - PERIOD)).thenReturn(-0.778073197);
        Mockito.when(f.cos(-2.25 - PERIOD)).thenReturn(-0.628173623);

        Mockito.when(f.sin(-2.65)).thenReturn(-0.472030541);
        Mockito.when(f.cos(-2.65)).thenReturn(-0.881582196);

        Mockito.when(f.sin(-2.65 - PERIOD)).thenReturn(-0.472030541);
        Mockito.when(f.cos(-2.65 - PERIOD)).thenReturn(-0.881582196);

        Mockito.when(f.sin(-2.90)).thenReturn(-0.239249329);
        Mockito.when(f.cos(-2.90)).thenReturn(-0.970958165);

        Mockito.when(f.sin(-2.90 - PERIOD)).thenReturn(-0.239249329);
        Mockito.when(f.cos(-2.90 - PERIOD)).thenReturn(-0.970958165);

        // Граничное значение между Второй и Третьей частями и окрестности точки PI/2
        Mockito.when(f.sin(-PI/2)).thenReturn(-1.0);
        Mockito.when(f.cos(-PI/2)).thenReturn(0.0);

        Mockito.when(f.sin(-PI/2 - PERIOD)).thenReturn(-1.0);
        Mockito.when(f.cos(-PI/2 - PERIOD)).thenReturn(0.0);

        Mockito.when(f.sin(-PI/2 - EPSILON)).thenReturn(-1.0);
        Mockito.when(f.cos(-PI/2 - EPSILON)).thenReturn(0.0);

        Mockito.when(f.sin(-PI/2 - EPSILON - PERIOD)).thenReturn(-1.0);
        Mockito.when(f.cos(-PI/2 - EPSILON - PERIOD)).thenReturn(0.0);

        Mockito.when(f.sin(-PI/2 + EPSILON - PERIOD)).thenReturn(-1.0);
        Mockito.when(f.cos(-PI/2 + EPSILON - PERIOD)).thenReturn(0.0);

        // Значения на Третьей части графика + период (до и после экстремума)
        Mockito.when(f.sin(-0.9)).thenReturn(-0.78332691);
        Mockito.when(f.cos(-0.9)).thenReturn(0.621609968);

        Mockito.when(f.sin(-0.9 - PERIOD)).thenReturn(-0.78332691);
        Mockito.when(f.cos(-0.9 - PERIOD)).thenReturn(0.621609968);

        Mockito.when(f.sin(-0.6)).thenReturn(-0.564642473);
        Mockito.when(f.cos(-0.6)).thenReturn(0.825335615);

        Mockito.when(f.sin(-0.6 - PERIOD)).thenReturn(-0.564642473);
        Mockito.when(f.cos(-0.6 - PERIOD)).thenReturn(0.825335615);

        Mockito.when(f.sin(-0.3)).thenReturn(-0.295520207);
        Mockito.when(f.cos(-0.3)).thenReturn(0.955336489);

        Mockito.when(f.sin(-0.3 - PERIOD)).thenReturn(-0.295520207);
        Mockito.when(f.cos(-0.3 - PERIOD)).thenReturn(0.955336489);

        // Значения около 0 и в эпсилон-окрестности от 0 + период
        Mockito.when(f.sin(0.0)).thenReturn(0.0);
        Mockito.when(f.cos(0.0)).thenReturn(1.0);

        Mockito.when(f.sin(0.0 - PERIOD)).thenReturn(0.0);
        Mockito.when(f.cos(0.0 - PERIOD)).thenReturn(1.0);

        Mockito.when(f.sin(0.0 - EPSILON)).thenReturn(0.0);
        Mockito.when(f.cos(0.0 - EPSILON)).thenReturn(1.0);

        Mockito.when(f.sin(0.0 - EPSILON - PERIOD)).thenReturn(0.0);
        Mockito.when(f.cos(0.0 - EPSILON - PERIOD)).thenReturn(1.0);

        // Вторая функция (периода нет)

        // Левая граничная точка стремится к минус бесконечности
        //Mockito.when(ss.f1(0.0 + EPSILON)).thenReturn(Double.NEGATIVE_INFINITY);
        Mockito.when(f.ln(0.0 + EPSILON)).thenReturn(Double.NEGATIVE_INFINITY);

        //Значение между 0 и перегибом
        //          Mockito.when(ss.f1(0.50)).thenReturn(-0.747549086);
        Mockito.when(f.ln(0.5)).thenReturn(-0.69314718);

        // Значение в точке перегиба
        //          Mockito.when(ss.f1(1.0)).thenReturn(-0.731706554);
        Mockito.when(f.ln(1.0)).thenReturn(0.0);

        //Значение в точке пересечения оси Ох
        //          Mockito.when(ss.f1(11.4542)).thenReturn(0.0);
        Mockito.when(f.ln(11.4542)).thenReturn(2.438356474);

        //Значения на возрастающей кривой после пересечения
        //          Mockito.when(ss.f1(15.0)).thenReturn(0.270635059);
        Mockito.when(f.ln(15.0)).thenReturn(2.708050072);

        //          Mockito.when(ss.f1(30.0)).thenReturn(1.254119185);
        Mockito.when(f.ln(30.0)).thenReturn(3.401197122);
    }


    @Test
    public void firstAreaTest() {
        assertEquals(Double.NaN, ss.solveSystem(-2 * PI - EPSILON), PRECISION);
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

        assertEquals(Double.NaN, ss.solveSystem(- PI - EPSILON), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(- PI + EPSILON), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(- PI - EPSILON - PERIOD), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(- PI + EPSILON - PERIOD), PRECISION);
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

        assertEquals(Double.NaN, ss.solveSystem(0.0 - EPSILON), PRECISION);
        assertEquals(Double.NaN, ss.solveSystem(0.0 - EPSILON - PERIOD), PRECISION);

        assertEquals(Double.NaN, ss.solveSystem(0.0 + EPSILON), PRECISION);
    }

    @Test
    public void secondFunctionTest() {
        //Значение между 0 и перегибом
        assertEquals(-0.748515, ss.solveSystem(0.50), PRECISION);
        // Значение в точке перегиба
        assertEquals(Double.NaN, ss.solveSystem(1.0), PRECISION);
        //Значение в точке пересечения оси Ох
        assertEquals(0.0, ss.solveSystem(11.4542), PRECISION);
        //Значения на возрастающей кривой после пересечения
        assertEquals(0.270635059, ss.solveSystem(15.0), PRECISION);
        assertEquals(1.254119185, ss.solveSystem(30.0), PRECISION);
    }
}
