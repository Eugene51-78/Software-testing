package functions;

public class SystemSolver {
    public static Functions f = new Functions();

    public SystemSolver(Functions f){
        this.f = f;
    }

    public Double solveSystem(Double x) {
        Double result;
        if (x > 0) {
            result = f1(x);
        } else {
            result = f2(x);
        }
        return result;
    }

    public Double f1(Double x) {
        double ans = (((Math.pow((f.log_5(x) * f.log_10(x)), 2) - f.log_10(x)) - f.log_5(x)) / f.log_2(x));
        if (ans > 1E10)
            return Double.NaN;
        else if (ans > 1E9)
            return Double.POSITIVE_INFINITY;
        else
            return ans;
    }

    public Double f2(Double x) {
        double ans = Math.pow((((f.cot(x) + f.sec(x)) - f.tan(x)) / f.cos(x)), 4);
        if (ans > 1E10)
            return Double.NaN;
        else if (ans > 1E9)
            return Double.POSITIVE_INFINITY;
        else
            return ans;
    }
}