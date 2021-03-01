/*
ID: diamond11
LANG: JAVA
PROG: year
*/

/*
Farmer John's cows are excited to learn that Chinese New Year was recently celebrated, ushering in the year of the Ox, always a bovine favorite.
As we know, the zodiac animals for Chinese calendar years follow a 12-year cycle: Ox, Tiger, Rabbit, Dragon, Snake, Horse, Goat, Monkey, Rooster, Dog, Pig, Rat, and then Ox again.

Bessie the cow is proud to say she was born in a year of the Ox, many years ago. Her friend Elsie wants to know how many years apart from Bessie she was born, and hopes you can help her deduce this by looking at relationships between the birth years of several cows on the farm.

INPUT FORMAT (input arrives from the terminal / stdin):
The first line of input contains an integer N (1≤N≤100). Each of the next N lines contains an 8-word phrase specifying the relationship between the birth years of two cows. It is of the form
"Mildred born in previous Dragon year from Bessie",

or

"Mildred born in next Dragon year from Bessie"

The last word is the name of a cow on the farm, which is either "Bessie" or a cow that has already been mentioned in a previous line of input.

The first word is the name of a cow on the farm who is not "Bessie" and who has not yet been mentioned in the input. All cow names have at most 10 characters that are in the range a..z or A..Z.

The 5th word is one of the 12 zodiac animals above.

The 4th word is either "previous" or "next". For example, if the phrase is "Mildred born in previous Dragon year from Bessie", then Mildred's year of birth was the Dragon year closest to and strictly before (not equal to) Bessie's birth year.

OUTPUT FORMAT (print output to the terminal / stdout):
Please output the number of years by which Bessie and Elsie's birth years differ. It is guaranteed that this number can be determined by the input given.
SAMPLE INPUT:
4
Mildred born in previous Dragon year from Bessie
Gretta born in previous Monkey year from Mildred
Elsie born in next Ox year from Gretta
Paulina born in next Dog year from Bessie
SAMPLE OUTPUT:
12
In the input above,

Elsie was born 12 years before Bessie.
Mildred was born 9 years before Bessie.
Gretta was born 17 years before Bessie.
Paulina was born 9 years after Bessie.
*/
import java.io.*;
import java.util.*;

class yearofcow {
  public static void main (String [] args) throws IOException {
    
    HashMap<String, Integer> person = new HashMap<>();
    person.put("Bessie", 0);

    HashMap<String, String> personYear = new HashMap<>();
    personYear.put("Bessie", "Ox");

    HashMap<String, Integer> zodiac = new HashMap<>();
    zodiac.put("Ox", 0);
    zodiac.put("Tiger", 1);
    zodiac.put("Rabbit", 2);
    zodiac.put("Dragon", 3);
    zodiac.put("Snake", 4);
    zodiac.put("Horse", 5);
    zodiac.put("Goat", 6);
    zodiac.put("Monkey", 7);
    zodiac.put("Rooster", 8);
    zodiac.put("Dog", 9);
    zodiac.put("Pig", 10);
    zodiac.put("Rat", 11);

    


    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("year.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int numStatements = Integer.parseInt(st.nextToken());
    for (int i = 0; i < numStatements; i++)
    {
        st = new StringTokenizer(f.readLine());
        String person1 = st.nextToken();
        st.nextToken(); //skip born
        st.nextToken(); //skip in
        String PrevNext = st.nextToken();
        String year = st.nextToken();
        st.nextToken(); //skip year
        st.nextToken(); //skipfrom
        String person2 = st.nextToken();

        if (!person.containsKey(person1))
        {
            person.put(person1, 0);
        }
        personYear.put(person1, year);

        if (PrevNext.equals("previous"))
        {
           
            int diff = 12 - zodiac.get(year) + zodiac.get(personYear.get(person2)) + person.get(person2);
            person.put(person1, diff);
        }
        else 
        {
            int diff = 12 + zodiac.get(year) - zodiac.get(personYear.get(person2)) - person.get(person2);
            person.put(person1, diff);
        }
    }
    System.out.println(Math.abs(person.get("Elsie")));



  }
}