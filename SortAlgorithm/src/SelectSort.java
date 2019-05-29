import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: WangYang
 * @Date: 2019/5/27 20:39
 * @Description:
 */
public class SelectSort {
    public static void simpleSelectSort(int a[]){
        int length = a.length;
        for(int i = 0; i < length; i++){
            int min = i;
            for(int j = i + 1; j < length; j++){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            if(min != i){
                SortUtil.swap(a, min, i);
            }
        }
    }
    public static void main(String[] args){
        int[] a = {3,1,5,7,2,4,9,6};
        SortUtil.print(a);
        SelectSort.simpleSelectSort(a);
        SortUtil.print(a);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    }
}
