import java.util.Arrays;

public class q29 {
    boolean[][] visited;

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(Arrays.toString(new q29().spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
        this.visited = new boolean[m][n];
        int[] res = new int[m * n];
        spiralOrder(matrix, 0, 0, res, 0);
        return res;
    }

    public int spiralOrder(int[][] matrix, int i, int j, int[] res, int k) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return k;
        if (visited[i][j]) return k;

        for (; j < matrix[0].length && !visited[i][j]; j++) {
            res[k++] = matrix[i][j];
            visited[i][j] = true;
        }
        for (j--,i++; i < matrix.length && !visited[i][j]; i++) {
            res[k++] = matrix[i][j];
            visited[i][j] = true;
        }
        for (i--,j--; j >= 0 && !visited[i][j]; j--) {
            res[k++] = matrix[i][j];
            visited[i][j] = true;
        }
        for (j++,i--; i >= 0 && !visited[i][j]; i--) {
            res[k++] = matrix[i][j];
            visited[i][j] = true;
        }
        return spiralOrder(matrix, i + 1, j + 1, res, k);
    }
}
