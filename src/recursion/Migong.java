package recursion;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/7   10:27
 */
public class Migong {

    /**
     *
     * @param map 二维数组
     * @param i 第几行
     * @param j 第几列
     * @return 成功与否
     */
    public boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }else {
            if(map[i][j]==0){
                map[i][j]=2;
                if(setWay(map,i+1,j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        //byte[] byted = new byte[1024 * 11 * 1024];
        //创建一个二维数组
        int[][] map = new int[8][7];
        //使用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][2] = 1;
        map[3][1] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        Migong migong=new Migong();
        migong.setWay(map,1,1);
        System.out.println("================");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
