class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '.') {
                    String rowKey = board[i][j] + "in row" + i;
                    String colKey = board[i][j] + "in col" + j;
                    String gridKey = board[i][j] + "in grid" + i / 3 + "-" + j / 3;

                    if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(gridKey)) {
                        return false;
                    }

                    seen.add(rowKey);
                    seen.add(colKey);
                    seen.add(gridKey);
                }
            }
        }

        return true;
    }
}
