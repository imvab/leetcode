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

class Solution {
    static int findMinLength(String strings[], int n) {
        int min = strings[0].length();
        for (int i = 1; i < n; i++) {
            if (strings[i].length() < min) {
                min = strings[i].length();
            }
        }
        return (min);
    }

    public static String longestCommonStarting(String[] strings, int n) {
        // Write your code here
        int minlen = findMinLength(strings, n);
        String result = "";
        char current;

        for (int i = 0; i < minlen; i++) {
            current = strings[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (strings[j].charAt(i) != current) {
                    if (result.length() == 0)
                        result = "-1";
                    return result;
                }
            }
            result += (current);
        }
        if (result.length() == 0)
            result = "-1";
        return (result);
    }
}

class Solution {

    public static void reverse(char[] a) {
        int i, n = a.length;
        char t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    public String AliceLikesItEven(String S) {
        int MAX = 10;
        String maxEven = "";
        int len = S.length();
        int[] freq = new int[MAX];
        int i, minEvenDigit = MAX;
        for (i = 0; i < len; i++) {
            int digit = S.charAt(i) - '0';
            freq[digit]++;
            if (digit % 2 == 0)
                minEvenDigit = Math.min(digit, minEvenDigit);

        }
        if (minEvenDigit == MAX) {
            char tempArray[] = S.toCharArray();
            Arrays.sort(tempArray);
            reverse(tempArray);
            return new String(tempArray);
        }
        freq[minEvenDigit]--;
        i = MAX - 1;
        while (i >= 0) {
            if (freq[i] > 0) {
                maxEven = maxEven + i;
                freq[i]--;
            } else
                i--;
        }
        maxEven = maxEven + minEvenDigit;
        return maxEven;
    }
}