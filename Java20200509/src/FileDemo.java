import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
           //传入路径，构造文件对象
            //路径可以是绝对路径，可以是相对路径
        {
            //File对象的实际文件不存在
            String path = "C:\\java project\\Java20200509\\没有这个文件.txt";
            File file = new File(path);
            System.out.println(file);
        }

        {
            //File对象的实际文件存在的
            String path = "C:\\java project\\Java20200509\\我是一个文件.txt";
            File file = new File(path);
            System.out.println(file);
        }

        {
            //传入一个父路径
            String parent = "C:\\java project\\Java20200509";
            String path = "没有这个文件.txt";

            File file = new File(parent,path);
            System.out.println(file);


            //获取常见的属性
            System.out.println(file.exists());      //判断是否存在
            System.out.println(file.getAbsolutePath()); //获取绝对路径
            System.out.println(file.getName()); //获取文件名
            System.out.println(file.getParent());   //只保留父亲的部分
            System.out.println(file.isAbsolute());  //判断是否是一个绝对路径
            System.out.println(file.isDirectory());     //判断是否是一个目录
            System.out.println(file.isFile());      //判断是否是一个普通的文件
            System.out.println(file.isHidden());        //判断是否是一个隐藏文件
            System.out.println(file.canRead());         //是否拥有读的权限
            System.out.println(file.canWrite());        //是否拥有写的权限
            System.out.println(file.canExecute());      //是否可执行（程序）
        }

        {
            //演示文件的创建（普通文件）
            String parent = "C:\\java project\\Java20200509";
            String filename = "即将拥有的世界.txt";

            File file = new File(parent,filename);
            System.out.println(file.exists());
            boolean success = file.createNewFile();
            if (success) {
                System.out.println(filename + "被创建成功");
            }else {
                System.out.println(filename+"已经存在");
            }
        }

        {
            //演示文件夹的创建过程
            String parent = "C:\\java project\\Java20200509";
            String filename = "一个事先不存在的文件夹\\一个新的文件夹";

            File file = new File(parent,filename);
            System.out.println(file.exists());

            //mkdir：创建文件夹的缩写        make  directory
            //boolean success = file.mkdir();
            //mkdirs：会把需要创建的中间文件夹一并创建出来
            boolean success = file.mkdirs();
            if(success){
                System.out.println(filename+"   文件夹创建成功");
            }else{
                System.out.println(filename+"   文件夹原来就存在");
            }
        }

        {
            String parent = "C:\\java project\\Java20200509";
            String filename = "一个事先不存在的文件夹";

            //只能删除一个空的文件夹
            //file.deleteOnExit();      也是把文件删掉，但不是马上删，而是等到JVM进程结束后才删除
            File file = new File(parent,filename);
            System.out.println(file.exists());

            boolean delete = file.delete();//不是移动到回收站，而是直接删除
            if (delete){
                System.out.println("删除了");
            }else{
                System.out.println("就不存在，没删");
            }
        }

        {
            String path = "C:\\java project\\Java20200509";
            File dir = new File(path);
            File[] files = dir.listFiles();
            //可能files == null
            //可能files.length == 0
            if (files != null){
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}
