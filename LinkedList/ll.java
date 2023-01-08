class Solution {
    static ArrayList<Integer> leaders(int arr[], int n) {
        // Write your code here
        ArrayList<Integer> array = new ArrayList<Integer>();
        int current_leader = arr[n - 1];
        array.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (current_leader <= arr[i]) {
                current_leader = arr[i];
                array.add(current_leader);
            }
        }
        Collections.reverse(array);

        return (array);
    }
}

class Accio {
    public static void countCharacter(String str) {
        int upper = 0, lower = 0, number = 0, special = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                upper++;
            else if (ch >= 'a' && ch <= 'z')
                lower++;
            else if (ch >= '0' && ch <= '9')
                number++;
        }

        System.out.println(upper + " " + lower + " " + number);
    }
}

class Solution {

    public static int fourbinacci(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 1;
        } else if (n == 4) {
            return 1;
        } else {
            return fourbinacci(n - 1) + fourbinacci(n - 2) + fourbinacci(n - 3) + fourbinacci(n - 4);
        }
    }
}