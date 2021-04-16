
/*
ID: diamond11
LANG: JAVA
PROG: milk2
*/
import java.io.*;
import java.util.*;

class Times implements Comparable<Times>{

    private int beginning;
    private int ending;

    public Times(int begin, int end)
    {
        beginning = begin;
        ending = end;
    }

    public int getBeginning()
    {
        return beginning;
    }

    public int getEnding()
    {
        return ending;
    }

    public int compareTo(Times compareTimes) {
    
        int compareQuantity = ((Times) compareTimes).beginning; 
        
        //ascending order
        return this.beginning - compareQuantity;
        
        //descending order
        //return compareQuantity - this.quantity;
        
    }

}

public class milk2 {
    public static void main (String [] args) throws IOException {
        int mergeResultStart = 0;
        int mergeResultEnd = 0;
        boolean isMergeRestart = true;
        int longestmilked = 0;
        int longestNomilked = 0;

        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int slots = Integer.parseInt(st.nextToken());

        Times[] savedTimes = new Times[slots];
        for (int i = 0; i < slots; i++)
        {
            st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Times intervals = new Times(start, end);
            savedTimes[i] = intervals;
        }

        Arrays.sort(savedTimes);
        for (int i = 0; i < savedTimes.length; i++)
        {
            
            
            if (isMergeRestart)
            {
                mergeResultStart = savedTimes[i].getBeginning();
                mergeResultEnd = savedTimes[i].getEnding();
                longestmilked = mergeResultEnd - mergeResultStart;
                isMergeRestart = false;
            }
            else
            {
                

                int nextstart = savedTimes[i].getBeginning();
                if (nextstart <= mergeResultEnd)
                {
                    mergeResultEnd = Math.max(mergeResultEnd, savedTimes[i].getEnding());
  
                }
                else
                {
                    if (longestmilked < (mergeResultEnd - mergeResultStart))
                    {
                        longestmilked = mergeResultEnd - mergeResultStart;
                    }
                    if (longestNomilked < (savedTimes[i].getBeginning() - mergeResultEnd))
                    {
                        longestNomilked = savedTimes[i].getBeginning() - mergeResultEnd;
                    }
                    mergeResultStart = savedTimes[i].getBeginning();
                    mergeResultEnd = savedTimes[i].getEnding();
                }
            }
            
        }
        out.println(longestmilked + " " + longestNomilked);
        f.close();
        out.close();
    }
    
}
