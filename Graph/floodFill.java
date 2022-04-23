class Solution {
    public void DFS(int[][] image, int sr, int sc, int init, int newColor) {
        if (sr < 0 || sr >= image.length)
            return; // Going out of bounds
        if (sc < 0 || sc >= image[0].length)
            return;

        if (image[sr][sc] == init) {
            image[sr][sc] = newColor; // Change the pixel color
            DFS(image, sr - 1, sc, init, newColor); // left
            DFS(image, sr + 1, sc, init, newColor); // right
            DFS(image, sr, sc - 1, init, newColor); // up
            DFS(image, sr, sc + 1, init, newColor); // down
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc]; // What is the color of source

        if (newColor == initialColor)
            return image;
        DFS(image, sr, sc, initialColor, newColor);
        return image;
    }
}

// https://leetcode.com/problems/flood-fill/