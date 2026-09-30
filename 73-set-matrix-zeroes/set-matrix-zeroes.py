class Solution:
    def setZeroes(self, matrix: list[list[int]]) -> None:
        m, n, first_col_has_zero = len(matrix), len(matrix[0]), False
        for i in range(m):
            if matrix[i][0] == 0: first_col_has_zero = True
            for j in range(1, n):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][0] == 0 or matrix[0][j] == 0: matrix[i][j] = 0
        if matrix[0][0] == 0:
            for j in range(n): matrix[0][j] = 0
        if first_col_has_zero:
            for i in range(m): matrix[i][0] = 0
