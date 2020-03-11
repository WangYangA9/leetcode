import java.util.*;

/**
 * Created by Administrator on 2019/5/30 0030.
 */
public class AllSort {

    public void allSort(int[] a, int n, int[] temp, int[] visit){
        if(n == a.length){
            for(int i = 0; i < temp.length; i++){
                System.out.print(temp[i]);
            }
            System.out.println("");
            return;
        }
        for(int i = 0; i < a.length; i++){
            if(visit[i] != 1){
                temp[n] = a[i];
                visit[i] = 1;
                allSort(a, n + 1, temp, visit);
                visit[i] = 0;
            }
        }

    }


    public static void main(String[] args){
        int[] a = {3,1,5,7,2,4,9,6};
        AllSort allSort = new AllSort();
        int[] temp = new int[a.length];
        int[] visit = new int[a.length];
        allSort.allSort(a, 0, temp, visit);
    }
}
