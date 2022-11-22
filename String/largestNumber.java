class Solution {

    public String largestNumber(int[] nums) {
        String str[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new java.util.Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return yx.compareTo(xy);
            }
        });

        if (str[0].equals("0")) {
            return "0";
        }

        String largestNumberStr = "";
        for (String numAsStr : str) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
}


class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            strings.add(String.valueOf(nums[i]));
        }
        
        Collections.sort(strings, (a, b) -> ((a+b).compareTo(b+a) > 0) ? 2 : -2);
        
        if (strings.get(0).equals("0")) return "0";
        
        String res = "";
        
        for (String s : strings) {
            res += s;
        }
        return res;
    }
}

// https://leetcode.com/problems/largest-number/