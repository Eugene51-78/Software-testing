package functions;

import static java.lang.Math.abs;

public class Functions {
    static double PRECISION = 1E-10;

    public Double cos(Double x) {

        double xn = 1.0, prevSum = 0.0, sum = 1.0;

        for(int n = 0; Math.abs(sum - prevSum) > 1E-16; n++) {
            prevSum = sum;
            xn *= (-1.0 * x*x / (2*n + 2) / (2*n + 1));
            sum += xn;
        }
        return sum;
    }

    public Double sin(Double x) {

        short sign;
        if (((x % (2.0 * Math.PI)) < -Math.PI) && ((x % (2.0 * Math.PI)) > -2 * Math.PI))
            sign = 1;
        else sign = -1;

        return Math.sqrt(1.0 - Math.pow(cos(x), 2)) * sign;
    }

    public Double ln(Double x) {

        Double sum;
        if (x <= 0 || x <= PRECISION || x.isNaN()) {
            return Double.NaN;
        }
        else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }

        else if (x < 1) {
            double z = x - 1;
            double term = z;
            sum = z;
            double i = 2;
            while (abs(term) >= PRECISION) {
                term *= -z;
                sum += term / i;
                i++;
            }
        } else {
            double z = x / (x - 1.0);
            double term = z;
            sum = 0.0;
            double i = 1;
            while (abs(term) > PRECISION) {
                term = 1.0 / (i * Math.pow(z, i));
                sum += term;
                i++;
            }
        }
        return sum;
    }

    public Double tan(Double x) {
        return sin(x) / cos(x);
    }

    public Double cot(Double x) {
        return cos(x) / sin(x);
    }

    public Double sec(Double x) {
        return 1.0 / cos(x);
    }

    public Double log_2(Double x) {
        return ln(x) / ln(2.0);
    }

    public Double log_5(Double x) {
        return ln(x) / ln(5.0);
    }

    public Double log_10(Double x) {
        return ln(x) * 0.4342944819;
    }

}
