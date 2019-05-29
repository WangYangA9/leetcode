/**
 * @Author: WangYang
 * @Date: 2019/5/28 22:04
 * @Description:
 */
public class MergeSort {
    public static void mergeSort(int[] a){
        int[] temp = new int[a.length];
        sort(a, 0, a.length - 1, temp);
    }
    public static void sort(int[] a, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            sort(a, left, mid, temp);
            sort(a, mid + 1, right, temp);
            merge(a, left, mid, right, temp);
        }
    }

    public static void merge(int[] a, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right){
            if(a[i] < a[j]){
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        //i没走到末尾
        while(i <= mid){
            temp[t++] = a[i++];
        }
        //j没走到末尾
        while(j <= right){
            temp[t++] = a[j++];
        }
        //将temp赋值到a中
        t = 0;
        for(int k = left; k <= right; k++){
            a[k] = temp[t++];
        }
    }
    public static void main(String[] args){
        int[] a = {3,1,5,7,2,4,9,6};
        SortUtil.print(a);
        mergeSort(a);
        SortUtil.print(a);
    }
}
