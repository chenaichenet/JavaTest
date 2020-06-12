/**
 * FileName: ArraysDemo
 * Author:   嘉平十七
 * Date:     2020/5/19 15:27
 * Description: 数组
 * History:
 * notes：
 */
package main.test.classlibrary;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        /*1*/
//        int dataA[]=new int[]{1,2,3};
//        int dataB[]=new int[]{1,2,3};
//        System.out.println(Arrays.compare(dataA,dataB));
//        System.out.println(Arrays.equals(dataA,dataB));
        /*2*/
//        int data[]=new int[10];
//        Arrays.fill(data,3);//对数组内容进行填充处理
//        System.out.println(Arrays.toString(data));
        /*3*/
//        int data[]=new int[]{1,5,4,7,2,6,3,0};
//        Arrays.sort(data);
//        System.out.println(Arrays.binarySearch(data,6));
        /*4*/
        int data[]=new int[]{0,1,2,2,3,4,5,7,8,11,14,26,34};
        Arrays.sort(data);
        for (int x=0;x<data.length;x++){
            System.out.println(data[x]+"--"+ArrayUtil.binarySearch(data,data[x]));
        }
        System.out.println(ArrayUtil.binarySearch(data,4));
        System.out.println(ArrayUtil.binarySearch(data,-12));
        System.out.println(ArrayUtil.binarySearch(data,110));
        /*5*/

    }
}
/*4*/
class ArrayUtil{    //定义数组操作类
    private static int count=1;
    /**
     * 实现数据的二分查找操作
     * @param data 要查找的原始数组
     * @param num 要比对的数据
     * @return 查询到了返回数据的索引，如果该数据不存在则返回-1
     */
    public static int binarySearch(int[] data, int num){
        return binarySearchImpl(data,0,data.length,num);
    }
    public static int binarySearchImpl(int data[],int strat,int end,int num){
        System.out.println("strat="+strat+"、end="+end);
        if (strat>end)
            return -1;
        if (num>data[data.length-1]||num<data[0])
            return -1;
        int center=(strat+end)/2;
        if (data[center]==num){
            return center;
        }else {
            if (num>data[center])
                return binarySearchImpl(data,(strat+end)%2==0?center:center+1,end,num);
            else
                return binarySearchImpl(data,strat,(strat+end)%2==0?center:center-1,num);
        }
    }
    private static int binarySearch0(int[] a,int formIndex,int toIndex,int key){
        int low=formIndex;
        int high=toIndex-1;
        while (low<=high){
            int mid=(low+high)>>>1;
            int midVal=a[mid];
            if (midVal<key)
                low=mid+1;
            else if (midVal>key)
                high=mid-1;
            else
                return mid;     //找到
        }
        return -(low+1);    //没有找到
    }
}