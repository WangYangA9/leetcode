import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/5/16 0016.
 */
class LRUCache {
    private Map<Integer, Integer> map = new LinkedHashMap<>();
    private Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int result = map.get(key);
        map.remove(key);
        map.put(key, result);//get后重新插入到末尾，防止被先删除
        return result;
    }

    public void put(int key, int value) {
        //如果有重复key，先删除，否则如果已经满了，就删掉第一个
        if(map.containsKey(key)){
            map.remove(key);
        } else if(map.size() == capacity){
            map.remove(map.entrySet().iterator().next().getKey());
        }
        map.put(key, value);
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */