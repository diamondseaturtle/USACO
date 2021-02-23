
/*
ID: diamond11
LANG: JAVA
PROG: beads
*/
import java.io.*;
import java.util.*;

class beads {

    private  static char[] m_beads;
    private  static int beadsCollected(int start)
    {
        int total = 0;
        int collected = 0;
        char color = 'w';
        int i = start;
        for (; total < m_beads.length; total++)
        {
            if (color == 'w')
            {
                collected++;
                color = m_beads[i];
            }
            else if (color == m_beads[i] || m_beads[i] == 'w')
            {
                collected++;
            }
            else
            {
                break;
            }
            i = (i >= m_beads.length-1)
                    ? 0
                    : i + 1;
        }
        if (i == start)
        {
            return collected;
        }
        int j = (start == 0) 
                    ? m_beads.length - 1 
                    : start - 1;
        color = 'w';

        for (; j != i; )
        {
            if (color == 'w')
            {
                collected++; 
                color = m_beads[j];
            }
            else if (color == m_beads[j] || m_beads[j] == 'w')
            {
                collected++;
            }
            else
            {
                break;
            }
            j = (j <= 0)
                    ? m_beads.length - 1
                    : j - 1;
        }

        
        if (color == 'w')
        {
            collected++; 
            color = m_beads[j];
        }
        else if (color == m_beads[j] || m_beads[j] == 'w')
        {
            collected++;
        }
        
    
        return collected;
    }

  public static void main (String [] args) throws IOException {
    int max = 0;

    BufferedReader f = new BufferedReader(new FileReader("beads.in"));                                             
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int numBeads = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(f.readLine());
    String o_beads = st.nextToken();
    m_beads = o_beads.toCharArray();
    assert (m_beads.length == numBeads);

    for (int i = 0; i < m_beads.length; i++)
    {
        int collect = beadsCollected(i);
        if (collect > max)
        {
            max = collect;
        }
    }
    out.println(max);

    f.close();
    out.close();
  }
}