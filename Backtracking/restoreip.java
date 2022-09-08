class Solution {
    HashSet<String> res = new HashSet<String>();
    
    public List<String> restoreIpAddresses(String s) {
        backTrack(s, "", 0, 0);
        return new ArrayList(res);
    }
    
    public void backTrack(String s, String ip, int idx, int dots) {
        if (ip.length() == s.length() + 3 && ip.charAt(ip.length() - 1) != '.') {
            res.add(ip);
        }
        
        for (int i = idx; i < s.length(); i++) {
            int len = ip.length();
            int j;
            if (dots == 3) {
                j = s.length();
            } else {
                j = i + 1;
            }
            String substr = s.substring(idx, j);
            if (isValid(substr)) {
                ip += substr;
                if (dots < 3)
                    ip += ".";
            }
            backTrack(s, ip, i + 1, dots + 1);
            ip = ip.substring(0, len);
        }
    }
    
    public boolean isValid(String s) {
        if (s.length() == 0) return false;
        if (s.length() > 3) return false;
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        if (Integer.parseInt(s) > 255) return false;
        
        return true;
    }
}