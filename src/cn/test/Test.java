/**
 * FileName: Test
 * Author:   嘉平十七
 * Date:     2020/5/15 16:34
 * Description:
 * History:
 * notes：方案一：使用InputStream将全部要拷贝的内容全部读取到程序中，再拷贝到目标文件。缺点是，当文件过大时，程序运行时间过长，甚至死机。
 *      方案二：采用部分拷贝，读取一部分输出一部分，核心操作为：
 *          InputStream：public int read(byte[] b)throw IOException;
 *          OutputStream:public void write(byte[] b,int off,int len)throw IOException;
 */
package cn.test;
import java.io.*;
public class Test {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {	// 程序执行出错
            System.out.println("命令执行错误，执行结构：java JavaAPIDemo 拷贝源文件路径 拷贝目标文件路径");
            System.exit(1);
        }
        long start = System.currentTimeMillis() ;
        FileUtil fu = new FileUtil(args[0],args[1]) ;
        if (new File(args[0]).isFile()) {	// 文件拷贝
            System.out.println(fu.copy() ? "文件拷贝成功！" : "文件拷贝失败！");
        } else {	// 目录拷贝
            System.out.println(fu.copyDir() ? "文件拷贝成功！" : "文件拷贝失败！");
        }
        long end = System.currentTimeMillis() ;
        System.out.println("拷贝完成的时间：" + (end-start));
    }
}
class FileUtil {	// 定义一个文件操作的工具类
    private File srcFile ; // 源文件路径
    private File desFile ; // 目标文件路径
    public FileUtil(String src,String des) {
        this(new File(src),new File(des)) ;
    }
    public FileUtil(File srcFile,File desFile) {
        this.srcFile = srcFile ;
        this.desFile = desFile ;
    }
    public boolean copyDir() throws Exception {
        try {
            this.copyImpl(this.srcFile) ;
            return true ;
        } catch (Exception e) {
            return false ;
        }
    }
    private void copyImpl(File file) throws Exception {	// 递归操作
        if (file.isDirectory()) {	// 是目录
            File results [] = file.listFiles() ; // 列出全部目录组成
            if (results != null) {
                for (int x = 0 ; x < results.length ; x ++) {
                    copyImpl(results[x]) ;
                }
            }
        } else {	// 是文件
            String newFilePath = file.getPath().replace(this.srcFile.getPath() + File.separator, "") ;
            File newFile = new File(this.desFile,newFilePath) ; // 拷贝的目标路径
            this.copyFileImpl(file, newFile) ;
        }
    }
    private boolean copyFileImpl(File srcFile,File desFile) throws Exception {
        if (!desFile.getParentFile().exists()) {
            desFile.getParentFile().mkdirs() ; // 创建父目录
        }
        InputStream input = null ;
        OutputStream output = null ;
        try {
            input = new FileInputStream(srcFile) ;
            output = new FileOutputStream(desFile) ;
            input.transferTo(output) ;
            return true ;
        } catch (Exception e) {
            throw e ;
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close() ;
            }
        }
    }

    public boolean copy() throws Exception {	// 文件拷贝处理
        if (!this.srcFile.exists()) {	// 源文件必须存在!
            System.out.println("拷贝的源文件不存在！");
            return false ; // 拷贝失败
        }
        return this.copyFileImpl(this.srcFile, this.desFile) ;
    }
}