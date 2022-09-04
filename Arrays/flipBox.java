class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        char[][] flippedBox = new char[box[0].length][box.length];
        
        for(int i = 0; i < box.length; i++) {
            
            int crystals = 0;
            int lastEmpty = flippedBox.length-1;
            
            for(int j = flippedBox.length-1; j > -1; j--) {
                
                flippedBox[j][flippedBox[0].length-1-i]  = '.';

                if(box[i][j] == '#') {
                    crystals++;
                    
                    flippedBox[lastEmpty][flippedBox[0].length-1-i] = '#';
                    lastEmpty--;
                    
                } else if(box[i][j] == '*') {
                    
                    lastEmpty = j-1;
                    flippedBox[j][flippedBox[0].length-1-i] = '*';
                }                 
            }
        }
        
        return flippedBox;
    }
}

// https://leetcode.com/problems/rotating-the-box/