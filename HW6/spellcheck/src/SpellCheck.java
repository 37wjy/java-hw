import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

//package session09;

/**
 * @author dkruger
 */
public class SpellCheck {

    private HashMap<String, Integer> dic;

    public SpellCheck() {
        dic = new HashMap<String, Integer>();
        readInDic();
        check();
    }

    public void check() {
        BufferedReader reader = null;
        String temp = null;
        int f = 0;
        File file = new File("treasureisland.txt");
        System.out.println("");

        try {
            reader = new BufferedReader(new FileReader(file));
            // temp = reader.readLine();
            while ((temp = reader.readLine()) != null) {

                String[] str = temp.split("[^a-zA-Z0-9']+");
                for (String s : str) {
                    if (s.matches("[a-zA-Z']+")) {
                        if (s.substring(0, 1).matches("[A-Z]")) {
                            if (!s.substring(1).matches("[a-z']+")) {
                                if (f < 100)
                                    System.out.println(s);
                                f++;
                            }

                        } else if (s.substring(0, 1).matches("[']+")
                                || dic.get(s.toLowerCase().replace("'", "")) == null && s.length() > 1) {

                            if (f < 100)
                                System.out.println(s);
                            f++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("\nincorrect:" + f);
    }

    public void readInDic() {
        BufferedReader reader = null;
        String temp = null;
        int f = 0;
        File file = new File("usen-spelling-dict.txt");
        try {
            reader = new BufferedReader(new FileReader(file));
            // temp = reader.readLine();

            while ((temp = reader.readLine()) != null) {
                dic.put(temp.toLowerCase(), f++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        // https://raw.githubusercontent.com/StevensDeptECE/Dictionaries/master/usen-spelling-dict.txt
        // read the file into a HashMap where the key is the word
        // the value is the number
        // ex. "aa" --> 0
        // "aal" --> 1

        // read the file treasureisland.txt from the data directory
        /*
         * strip all punctuation. Words are capital or lowercase letter followed by
         * letters (no digits)
         * 
         * ignore ALLCAPS
         * 
         * for any word that starts with a capital letter spell check the word without
         * the capital letter.
         * 
         * Cat --> cat
         * 
         * if that is not a word, search for the capitalized version John --> john (not
         * found) search HashMap for John (found) ok.
         * 
         * display a count of all the words found spelled incorrectly print the first
         * 100 incorrect words
         */

        SpellCheck s = new SpellCheck();
    }
}
