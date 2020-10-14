package functions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    static final String HEADER = "x;f(x);cos(x);sin(x);tan(x);cot(x);sec(x);log_2(x);log_5(x);log_10(x);ln(x)\n";

    static Functions f = new Functions();
    static SystemSolver ss = new SystemSolver(f);

    public static void createCSV(double from, double to, double step) throws IOException {
        String str;
        String fStr;
        double x = from;
        File file = new File("out/SolvedSystem.csv");
        file.createNewFile();
        try {
            FileWriter writer = new FileWriter(file);
            writer.append(HEADER);
            while (x < to) {

                double ans = ss.solveSystem(x);

                if (ans == Double.NaN || ans == Double.POSITIVE_INFINITY)
                    fStr = "";
                else fStr = ans + "";

                str =   x + ";" + fStr + ";" +
                        f.cos(x) + ";"+ f.sin(x) + ";" + f.tan(x) + ";" +
                        f.cot(x) + ";" + f.sec(x) + ";" +
                        f.log_2(x) + ";" + f.log_5(x) + ";" +
                        f.log_10(x) + ";" + f.ln(x) + ";\n";
                writer.append(str);
                x += step;
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        createCSV(-2*Math.PI, 3,0.001);
    }
}
