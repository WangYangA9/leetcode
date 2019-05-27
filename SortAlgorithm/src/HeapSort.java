/**
 * @Author: WangYang
 * @Date: 2019/5/27 20:48
 * @Description:
 */
public class HeapSort {

    public static void heapSort(int a[], int left, int right){
    }
    public static void main(String[] args){
        int[] a = {3,1,5,7,2,4,9,6};
        SortUtil.print(a);
        heapSort(a, 0, a.length - 1);
        SortUtil.print(a);
    }
}
