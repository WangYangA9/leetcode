/**
 * @Author: WangYang
 * @Date: 2019/5/27 20:11
 * @Description:
 */
public class BubbleSort {
    public static void bubbkeSort(int a[]){
        int length = a.length;
        for(int i = 0 ; i < length; i++){
            for(int j = 0; j < length - i - 1; j++){
                if(a[j] > a[j + 1]){
                    SortUtil.swap(a, j, j + 1);
                }
            }
        }
    }
    public static void main(String[] args){
        int[] a = {3,1,5,7,2,4,9,6};
        SortUtil.print(a);
        BubbleSort.bubbkeSort(a);
        SortUtil.print(a);
    }
}

