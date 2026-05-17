class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (!checkDuplicatesRow(i, board, m)) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!checkDuplicateColumn(i, board, n)) {
                return false;
            }
        }

        for (int i = 0; i < m; i = i + 3) {
            for (int j = 0; j < n; j = j + 3) {
                if (!checkDuplicateGrid(i, j, board)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkDuplicatesRow(int rowidx, char[][] board, int n) {
        int col = 0;
        Set<Character> set = new HashSet<>();

        while (col < n) {
            char current = board[rowidx][col];

            if (current != '.') {
                if (set.contains(current)) {
                    return false;
                }
                set.add(current);
            }
            col++;
        }
        return true;
    }

    public boolean checkDuplicateColumn(int colIdx, char[][] board, int m) {
        int row = 0;
        Set<Character> set = new HashSet<>();

        while (row < m) {
            char current = board[row][colIdx];

            if (current != '.') {
                if (set.contains(current)) {
                    return false;
                }
                set.add(current);
            }
            row++;
        }
        return true;
    }

    public boolean checkDuplicateGrid(int rowIdx, int colIdx, char[][] board) {
        Set<Character> set = new HashSet<>();

        for (int i = rowIdx; i < rowIdx + 3; i++) {
            for (int j = colIdx; j < colIdx + 3; j++) {
                char current = board[i][j];
                if (current != '.') {
                    if (set.contains(current)) {
                        return false;
                    }

                    set.add(current);
                }
            }
        }

        return true;
    }
}
