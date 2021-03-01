/*
ID: diamond11
LANG: JAVA
PROG: fences
*/

/*
The fence surrounding Farmer John's largest pasture has fallen into disrepair, and he has finally decided to replace it with a new fence.
Unfortunately, as Farmer John is laying out the new fence, a large bee ends up chasing him around the pasture, and as a result, the fence ends up following a rather irregular path. The fence can be described by a string of characters, each either "N" (north), "E" (east), "S" (south), or "W" (west). Each character describes a 1-meter run of the fence. For example, if the string is NESW, this means the fence starts by moving north for 1 meter, then east for 1 meter, then south for 1 meter, then west for 1 meter, returning to its starting point.

The fence ends at the position where it started, and this is the only point visited more than once by the path of the fence (and the starting point is only re-visited once, at the end). As a result, the fence does indeed enclose a single connected region of the grassy pasture, even though this region could have a rather strange shape.

Farmer John is curious if the path in which he laid the fence traveled clockwise (with the enclosed region on the right side of the fence as one walks along the path of the fence in the order specified by the string) or counter-clockwise (with the enclosed region on the left side of the fence).

INPUT FORMAT (input arrives from the terminal / stdin):
The first line of input contains an integer N (1≤N≤20). Each of the next N lines contains a string of length at least 4 and at most 100, describing a single fence path.
OUTPUT FORMAT (print output to the terminal / stdout):
For each of the N fence paths described in the input, output a line containing either "CW" (clockwise) or "CCW" (counterclockwise).
SAMPLE INPUT:
2
NESW
WSSSEENWNEESSENNNNWWWS
SAMPLE OUTPUT:
CW
CCW

The two fence paths with @ denoting the starting point:

*>*
^ v
@<*

  *<*<*<*
  v     ^
*<@     *
v       ^
* *>*>* *
v ^   v ^
* *<* * *
v   ^ v ^
*>*>* *>*

*/
import java.io.*;
import java.util.*;


class fences {

    public static String findDir(String dirs, HashMap<String, String> directions)
    {
        char[] circle = new char[4];
        int[] dcount = new int[4];
        char[] dirsInChar = dirs.toCharArray();

        int k;
        for (k=0; k < 4; k++)
        {
            circle[k] = 'X';
            dcount[k] = 0;
        }

        k = 0;

        for (int i = 0; i < dirsInChar.length; i++)
        {
           if (k == 0)
           {
               circle[k] = dirsInChar[i];
               dcount[k] = 1;
               k++;
           }
           else 
           {
                if (circle[k-1] == dirsInChar[i])
                {
                    dcount[k-1]++;
                }
                else if (circle[k-1] == 'N' && dirsInChar[i] == 'S' ||
                         circle[k-1] == 'S' && dirsInChar[i] == 'N' ||
                         circle[k-1] == 'E' && dirsInChar[i] == 'W' ||
                         circle[k-1] == 'W' && dirsInChar[i] == 'E' )
                {
                    dcount[k-1]--;
                    if (dcount[k-1] == 0)
                    {
                        circle[k-1] = 'X';
                        k--;
                    }
                }
                else
                {
                    boolean stop = false;
                    for (int n = 0; n < k; n++ )
                    {
                        if (circle[n] == dirsInChar[i])
                        {
                            dcount[n]++;
                            stop = true;
                            break;
                        }
                    }
                    if (!stop)
                    {
                        circle[k] = dirsInChar[i];
                        dcount[k] = 1;
                        k++;
                    }
                }
           }
        }

        String loop = new String(circle);

        return directions.get(loop);
    }
    public static void main (String [] args) throws IOException {
        HashMap<String, String> directions = new HashMap<>();
        directions.put("NESW", "CW");
        directions.put("ESWN", "CW");
        directions.put("SWNE", "CW");
        directions.put("WNES", "CW");
        directions.put("NWSE", "CCW");
        directions.put("WSEN", "CCW");
        directions.put("ENWS", "CCW");
        directions.put("SENW", "CCW");

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int numPaths = Integer.parseInt(st.nextToken());
        String[] out = new String[numPaths];

        for (int i = 0; i < numPaths; i++ )
        {
            st = new StringTokenizer(f.readLine());
            String path = st.nextToken();
            out[i]=findDir(path, directions);
        }

        for (int i = 0; i < numPaths; i++ )
        {
            System.out.println(out[i]);
        }

    }
}
