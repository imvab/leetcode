class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        l = []
        row1 = 0
        row2 = len(matrix)
        col1 = 0
        col2 = len(matrix[0])
        
        while (row1 < row2 and col1 < col2):
            
            for i in range(col1, col2):
                l.append(matrix[row1][i])
            row1 += 1
            
            for i in range(row1, row2):
                l.append(matrix[i][col2 - 1])
            col2 -= 1
            
            if (row1 < row2):
                for i in range(col2 - 1, col1 - 1, -1):
                    l.append(matrix[row2 - 1][i])
                row2 -= 1
                    
            if (col1 < col2):
                for i in range(row2 - 1, row1 - 1, -1):
                    l.append(matrix[i][col1])
                col1 += 1
        return l