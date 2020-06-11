/**
 * FileName: RuntimeDemo
 * Author:   嘉平十七
 * Date:     2020/5/18 14:51
 * Description: Runtime
 * History:
 * notes：
 */
package main.test.classlibrary;

public class RuntimeDemo {
    public static void main(String[] args) throws Exception{
        Runtime run=Runtime.getRuntime();
        System.out.println(run);
        System.out.println(run.availableProcessors());
        System.out.println("最大可用内存空间："+run.maxMemory());
        System.out.println("可用内存空间："+run.totalMemory());
        System.out.println("空闲内存空间："+run.freeMemory());
        run.gc();
        System.out.println("最大可用内存空间："+run.maxMemory());
        System.out.println("可用内存空间："+run.totalMemory());
        System.out.println("空闲内存空间："+run.freeMemory());
    }
}