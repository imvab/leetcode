import java.io.*;

class GFG {
    public static String removeChars(String string1,
            String string2) {
        // we extract every character of string string 2
        for (int index = 0; index < string2.length(); index++) {
            char i = string2.charAt(index);
            // we find char exit or not
            while (string1.contains(i + "")) {
                int itr = string1.indexOf(i);
                // if char exit we simply remove that char
                string1 = string1.replace((i + ""), "");
            }
        }
        return string1;
    }

    // Driver Code
    public static void main(String[] args) {
        String string1, string2;
        string1 = "geeksforgeeks";
        string2 = "mask";
        System.out.println(removeChars(string1, string2));
    }
}