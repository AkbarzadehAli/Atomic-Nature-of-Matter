import java.util.*;
public class Avogadro {
    public static void main( String[] args ){
        Scanner scn = new Scanner(System.in);
        double a=0;
        double sum=0;
        int n = 0;
        while (scn.hasNextLine()) {
            String b = scn.nextLine();

            if (!b.equals("")) {
                if (b.charAt(0) == ' ')
                    b = b.substring(1);
                a = Double.parseDouble(b);
                a*=0.175*1E-6;
                sum += a*a;
                n++;
            }
        }
        double D = sum /(2*n);
        double viscos = 9.135 * 1E-4;
        double T = 297;
        double ro = 0.5 * 1E-6;
        double k = (6 * Math.PI * viscos * ro * D)/T;
        double R = 8.31446;
        double Na = R/k;
        System.out.println("Bultzman : "+k);
        System.out.println("Avogadro : "+Na);
    }
}


