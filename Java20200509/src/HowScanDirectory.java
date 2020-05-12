import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class HowScanDirectory {
    public static void main(String[] args) {
        File root = new File("C:\\java project\\Java20200509");

        travelDepth(root);
        System.out.println("====================");
        travelBroad(root);

    }

    private static void travelBroad(File root) {
        Queue<File> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            File front = queue.remove();
            System.out.println(front.getAbsolutePath());
            if (front.isDirectory()){
                File[] files = front.listFiles();
                if(files != null){
                    for (File file : files) {
                        queue.add(file);
                    }
                }
            }
        }
    }

    private static void travelDepth(File node) {
        System.out.println(node.getAbsolutePath());     // 绝对路径
        //判断node是否为叶子
        if (node.isDirectory()){    //判断是否是文件夹
            File[] files = node.listFiles();
            if (files != null){
                for (File file : files) {
                    //只有不是叶子节点，才能走到这个循环中
                    travelDepth(file);
                }
            }
        }
    }
}
