/**
 * @Author: WangYang
 * @Date: 2019/5/27 19:32
 * @Description:
 */
public class InsertSort {
    /**
     * 最差 n2
     * 最好 n
     * 平均 nlogn
     * @param a
     */

    public static void insertSort(int a[]){
        int length = a.length;
        for(int i = 1; i < length; i++){
            int j = i;
            int key = a[j];
            while(j > 0 && a[j - 1] > key){
                a[j] = a[j - 1];
                j--;
            }
            a[j] = key;
        }
    }
    public static void main(String[] args){
        int[] a = {3,1,5,7,2,4,9,6};
        SortUtil.print(a);
        InsertSort.insertSort(a);
        SortUtil.print(a);
    }

}
