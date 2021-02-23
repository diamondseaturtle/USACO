
/*
ID: diamond11
LANG: JAVA
PROG: friday
*/
import java.io.*;
import java.util.*;

class friday {

    public static boolean isLeapYear(int year)
    {
        if (year % 100 == 0 && year % 400 == 0)
        {
            return true;
        }
        else if (year % 100 == 0)
        {
            return false;
        }
        else if (year % 4 == 0)
        {
            return true;
        }
        return false;
    }


  public static void main (String [] args) throws IOException {
    HashMap<Integer, Integer> hz = new HashMap<>();
    int[] doy = new int[]{13, 44, 72, 103, 133, 164, 194, 225, 256, 286, 317, 347};
    int[] doy_leap =  new int[]{13, 44, 73, 104, 134, 165, 195, 226, 257, 287, 318, 348};
    int totaldays_year = 0;
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int yrs = Integer.parseInt(st.nextToken());
    for (int i = 0; i < 7; i++)
    {
        hz.put(i, 0);
    }
    for (int i = 0; i < yrs; i++)
    {
        for (int j = 0; j < doy.length; j++)
        {
            int daysweek = 0;
            if (isLeapYear(i + 1900))
            {
                daysweek = totaldays_year + doy_leap[j];
            }
            else
            {
                daysweek = totaldays_year + doy[j];
            }
            daysweek %= 7;
            hz.put(daysweek, hz.get(daysweek) + 1);
        }
        if (isLeapYear(i + 1900))
        {
            totaldays_year += 366;
        }
        else
        {
            totaldays_year += 365;
        }
    }
    out.println(hz.get(6) + " " + hz.get(0) + " " + hz.get(1) + " " + hz.get(2) + " " + hz.get(3) + " " + hz.get(4) + " " + hz.get(5)); 

    f.close();
    out.close();                               
  }
}
