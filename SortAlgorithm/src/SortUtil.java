import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

/**
 * @Author: WangYang
 * @Date: 2019/5/27 19:32
 * @Description:
 */
public class SortUtil {
    public static <T> void swap(T[] a, int i, int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static  void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T> void print(T[] a){
        System.out.println(Arrays.toString(a));
    }

    public static  void print(int[] a){
        System.out.println(Arrays.toString(a));
    }
}
