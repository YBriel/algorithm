package sparsearray;

/**
 * @Author： yuzq
 * @Description: 稀疏数组
 * @Date: 2019/12/30   10:15
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        for(int[] row:chessArr1){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int sparseArr[][]=new int[sum+1][3];

        sparseArr[0][0]=11; //行
        sparseArr[0][1]=11; //列
        sparseArr[0][2]=sum; //非零的个数

        //将非零的值存放到稀疏数组中
        int count=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        System.out.println("--------------->");
        for(int i=0;i<sparseArr.length;i++){
            System.out.print(sparseArr[i][0]+"  "+sparseArr[i][1]+"  "+sparseArr[i][2]);
            System.out.println();
        }
    }
}
