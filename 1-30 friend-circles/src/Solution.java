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

        public int count(){
            return this.count;
        }
    }
    //N 在[1,200]的范围内
    public int findCircleNum(int[][] M) {
        int N = M.length;
        UnionFind uf = new UnionFind(N);
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++){
                if(i == j || M[i][j] == 0){
                    continue;
                }
                uf.union(i, j);
            }
        }
        return uf.count;
    }

}