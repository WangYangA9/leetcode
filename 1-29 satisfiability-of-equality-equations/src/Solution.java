class Solution {
    class UnionFind {
        //连通分量
        private int count;
        //单个数组存储每个节点的父节点
        private int[] parent;
        //每个节点的子节点数量（包含自己）
        private int[] size;

        UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            for(int i = 0; i < n; i++){
                this.parent[i] = i;//初始自己指向自己
            }
            this.size = new int[n];
            for(int i = 0; i < n; i++){
                this.size[i] = 1;
            }
        }

        public void union(int p, int q){
            int r1 = find(p);
            int r2 = find(q);

            if(r1 == r2){
                return;
            }
            //将长链合并进短链，使树较为平衡，避免退化为链表
            if(size[r1] > size[r2]) {
                parent[r1] = r2;
                size[r2] += size[r1];
            } else {
                parent[r2] = r1;
                size[r1] += size[r2];
            }

            this.count--;
        }

        public int find(int x){
            //指向自己的为根节点
            while(parent[x] != x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int p, int q) {
            int r1 = find(p);
            int r2 = find(q);
            // 处于同一棵树上的节点，相互连通
            return r1 == r2;
        }
    }
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);//26个小写字母
        //第一遍记录所有==的作为条件
        for(String equation: equations){
            boolean isEqual = equation.charAt(1) == '=';
            if(isEqual){
                add(uf, equation);
            }
        }
        //第二遍查看所有!=检查是否满足
        for(String equation: equations){
            boolean isEqual = equation.charAt(1) == '=';
            //如果发现有!=的字符串为连通的，直接返回false
            if(!isEqual && judge(uf, equation)){
                return false;
            }
        }
        return true;

    }

    public void add(UnionFind uf, String equation){
        int a = equation.charAt(0) - 'a';
        int b = equation.charAt(3) - 'a';
        uf.union(a, b);
    }
    public boolean judge(UnionFind uf, String equation){
        int a = equation.charAt(0) - 'a';
        int b = equation.charAt(3) - 'a';
        return uf.connected(a, b);
    }
}