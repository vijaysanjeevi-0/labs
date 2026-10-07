import java.util.*;

public class Crc {
    static String rem(String d, String g) {   // modulo-2 division: returns the last (g-1) bits
        char[] r = d.toCharArray();
        for (int i = 0; i <= r.length - g.length(); i++)
            if (r[i] == '1')
                for (int j = 0; j < g.length(); j++)
                    r[i + j] ^= g.charAt(j) - '0';
        return new String(r, r.length - g.length() + 1, g.length() - 1);
    }

    public static void main(String[] x) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter data bits : ");
        String d = s.next();
        System.out.print("Enter divisor bits : ");
        String g = s.next();
        System.out.println("CRC code : " + d + rem(d + "0".repeat(g.length() - 1), g));
        System.out.print("Enter received code : ");
        System.out.println(rem(s.next(), g).contains("1") ? "Error" : "No Error");
    }
}
