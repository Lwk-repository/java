package sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        /**
         * 二维数组转稀疏数组
         */

        // 创建一个原始的二维数组11*11
        // 0：表示没有棋子，1表示黑子，2表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[8][8] = 9;
        System.out.println("原数组-----------------------------------------------");
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        int sum = 0;    // 有效数据个数
        int line = 0;   // 行
        int column = 0; // 列
        for (int[] ints : chessArr1) {
            line++;
            column = ints.length;
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }

        // 2.创建对应的稀疏数组
        /*永远只有三列，行数为有效数据个数+1
        第一行记录原始数组[行数，列数，有效数据个数]
        每个有效数据占一行，[所在行，所在列，有效数据值]*/
        int[][] sparseArray2 = new int[sum + 1][3];
        sparseArray2[0][0] = line;
        sparseArray2[0][1] = column;
        sparseArray2[0][2] = sum;

        int count = 0;
        System.out.println("稀疏数组-----------------------------------------------");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;   // 从第二行开始递增
                    sparseArray2[count][0] = i; // i代表所在行
                    sparseArray2[count][1] = j; // j代表所在列
                    sparseArray2[count][2] = chessArr1[i][j];   // 值
                }
            }
        }

        for (int[] ints : sparseArray2) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }


        /**
         * 稀疏数组转二维数组
         */

        int[][] chessArr2 = new int[sparseArray2[0][0]][sparseArray2[0][1]];
        for (int i = 1; i < sparseArray2.length; i++) {
            // 稀疏数组中第二行开始
            chessArr2[sparseArray2[i][0]][sparseArray2[i][1]] = sparseArray2[i][2];
        }
        System.out.println("恢复原数组-----------------------------------------------");
        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }
}
