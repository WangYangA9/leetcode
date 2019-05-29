import java.nio.file.Files;

/**
 * @Author: WangYang
 * @Date: 2019/5/27 20:49
 * @Description:
 */
public class QuickSort {
    public static int partition(int a[], int left, int right){
        int k = a[left];
        while(left < right){
            while(left < right && a[right] >= k){
                right--;
            }
            if(left < right){
                a[left] = a[right];
            }
            while(left < right && a[left] <= k){
                left++;
            }
            if(left < right){
                a[right] = a[left];
            }
        }
        a[left] = k;
        return left;
    }

    public static void quickSort(int a[], int left, int right){
        if(left < right){
            int key = partition(a, left, right);
            quickSort(a, left, key - 1);
            quickSort(a, key + 1, right);
        }
    }
    public static void main(String[] args){
        int[] a = {3,1,5,7,2,4,9,6};
        SortUtil.print(a);
        QuickSort.quickSort(a, 0, a.length - 1);
        SortUtil.print(a);
    }
}
