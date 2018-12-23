package array;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.print("Wrong");
            return;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        if (height != width) {
            System.out.print("Wrong");
        } else {
            double zero_point = (width-1)/2.0;
            int tmp;
            for (int i=0; i<= zero_point; ++i) {
                for (int j=0; j< zero_point; ++j) {
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[(int)(2 * zero_point - j)][i];
                    matrix[(int)(2 * zero_point - j)][i] = matrix[(int)(2 * zero_point - i)][(int)(2 * zero_point - j)];
                    matrix[(int)(2 * zero_point - i)][(int)(2 * zero_point - j)] = matrix[j][(int)(2 * zero_point - i)];
                    matrix[j][(int)(2 * zero_point - i)] = tmp;
                }
            }
        }
        this.showAll(matrix);
    }

    public void showAll(int[][] matrix) {
        for (int i=0; i<matrix.length; ++i){
            for (int j=0; j< matrix[0].length; ++j){
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }
    }
}
