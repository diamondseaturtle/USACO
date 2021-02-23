
/*
ID: diamond11
LANG: JAVA
PROG: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    int num = 0;
    int product = 1;
    int final1 = 0;
    int final2 = 0;
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
    
						  // Get line, break into tokens
    String s1 = st.nextToken();

    st = new StringTokenizer(f.readLine());   
    String s2 = st.nextToken();    // second integer

    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();

    for (int i = 0; i < s1.length() && i < 6; i++)
    {
        num = c1[i] - 'A' + 1;
        product *= num;
    }
    final1 = product % 47;
    product = 1;

    for (int i = 0; i < s2.length() && i < 6; i++)
    {
        num = c2[i] - 'A' + 1;
        product *= num;
    }
    final2 = product % 47;
    f.close();
    if (final1 == final2)
    {
        out.println("GO");
    }
    else
    {
        out.println("STAY");
    }                // output result
    out.close();                                  // close the output file
  }
}