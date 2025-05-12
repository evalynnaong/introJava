package assignment1;

public class MyMatrix {
    private int[][] matrix;

    public MyMatrix(int[][] newMatrix) { // constructor
        this.matrix = newMatrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int length() {
        return matrix.length;
    }

    public int width() {
        return matrix[0].length;
    }

    public int getVal(int row, int col) {
        return matrix[row][col];
    }

    public MyMatrix multiply(MyMatrix matrix2) {
        int row = this.matrix.length;
        int col = this.matrix[0].length;

        if(col != matrix2.length()) {
            throw new IllegalArgumentException("Matrices cannot be multiplied!");
        }

        int col2 = matrix2.width();
        int[][] resultMatrix = new int[row][col2];

        /*
         | 1  2  3 |    | 7   8   9  10 |       | .... |
         | 4  5  6 |    | 11 12  13  14 |   =   | .... |
                        | 15 16  17  18 |
            2 x 3           3 x 4                2 x 4
            i   k               j                i x j

        */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col; k++) {
                    resultMatrix[i][j] += matrix[i][k] * matrix2.getVal(k, j);
                }
            }
        }
        return new MyMatrix(resultMatrix);
    }
    
    public static void main(String[] args) {
        int[][] array1 = {{2,4}, {3,4}};
        MyMatrix matrix1 = new MyMatrix(array1);

        int[][] array2 = {{1,2},{1,3}};
        MyMatrix matrix2 = new MyMatrix(array2);
        MyMatrix resultMatrix = matrix1.multiply(matrix2);

    }
}
