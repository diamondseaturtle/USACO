
/*
ID: diamond11
LANG: JAVA
PROG: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    ArrayList<String> friends = new ArrayList<String>();  
    HashMap<String, Integer> bank = new HashMap<>();
    
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int numfriends = Integer.parseInt(st.nextToken());
    for (int i = 0; i < numfriends; i++)
    {
        StringTokenizer str = new StringTokenizer(f.readLine());
        String name = str.nextToken();
        friends.add(name);
        bank.put(name, 0);
    }

    while (true)
    {
        String line = f.readLine();
        if (line == null)
        {
            break;
        }
        StringTokenizer tok = new StringTokenizer(line);
        String gifter = tok.nextToken();

        tok = new StringTokenizer(f.readLine());
        int amount = Integer.parseInt(tok.nextToken());
        int numppl = Integer.parseInt(tok.nextToken());
        if (numppl == 0)
        {
            continue;
        }

        int distribute = amount / numppl;
        int leftover = amount % numppl;

        bank.put(gifter, bank.get(gifter) + leftover - amount);

        for (int i = 0; i < numppl; i++)
        {
            tok = new StringTokenizer(f.readLine());
            String giftee = tok.nextToken();
            bank.put(giftee, bank.get(giftee) + distribute);
        }
    }

    for (String s : friends)
    {
        out.println(s + " " + bank.get(s));
    }
    f.close();
    out.close();                                
  }
}