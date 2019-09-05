//clockwise
class RotateMatrix{
    public void rotateClockWise(int[][] matrix) {
        if(matrix.length == 0 || matrix == null)
            return;
        //upside down
        int row = matrix.length;
        int col = matrix[0].length;
        int temp = 0;
        for(int i=0;i<row/2;i++){
            for(int j=0;j<col;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[row-i-1][j];
                matrix[row-i-1][j] = temp;
            }

        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i<j){
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        System.out.println("Clockwise");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
    public void rotateAntiClockWise(int[][] matrix) {
        if (matrix.length == 0 || matrix == null)
            return;
        //right to left
        int row = matrix.length;
        int col = matrix[0].length;
        int temp = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][col - 1 - j];
                matrix[i][col - 1 - j] = temp;
            }

        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i < j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        System.out.println("Anti Clockwise");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
        public static void main (String[] s){
            int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            RotateMatrix rm = new RotateMatrix();
            rm.rotateClockWise(arr);
            rm.rotateAntiClockWise(arr);
        }
    }
