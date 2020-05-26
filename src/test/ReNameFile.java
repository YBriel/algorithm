package test;

import java.io.File;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/3   11:18
 */
public class ReNameFile {

    public static void main(String[] args) {
        File file=new File("D:\\架构\\尚硅谷 韩顺平 Netty核心技术及源码剖析\\1-58");
        File[] files = file.listFiles();
        if (files != null) {
            for (File value : files) {
                String absoluteFile = value.getAbsolutePath();
                String replace1 = absoluteFile.replace("-尚硅谷-Netty核心技术及源码剖析", "");
                File file1 = new File(absoluteFile);
                File re = new File(replace1);
                boolean b = file1.renameTo(re);
                if (b) {
                    System.out.println(replace1 + "重命名成功");
                }
            }
        }
    }
}
