import java.util.*;

/**
 * @Author: WangYang
 * @Date: 2019/5/19 19:01
 * @Description:
 */
class Solution {
    class TrieNode {
        TrieNode[] nextNode;
        boolean isWord;

        public TrieNode(boolean isWord) {
            nextNode = new TrieNode[26];
            this.isWord = isWord;
        }

        public TrieNode[] getNextNode() {
            return nextNode;
        }

        public void setNextNode(TrieNode[] nextNode) {
            this.nextNode = nextNode;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }
    class Trie{
        private TrieNode treeNode;
        public Trie() {
            treeNode = new TrieNode(false);
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = this.treeNode;
            for(int i = 0 ;i < word.length(); i++) {
                char c = word.charAt(i);
                if(node.getNextNode()[c - 'a'] == null) {
                    node.getNextNode()[c - 'a'] = new TrieNode(false);
                }
                node = node.getNextNode()[c - 'a'];
            }
            node.setWord(true);
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0)
            return result;

        Trie trie = new Trie();
        for (String temp : words)
            trie.insert(temp);

        TrieNode root = trie.treeNode;
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> tempResult = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.nextNode[board[i][j] - 'a'] != null ) {
                    dfs(board, visited, i, j, root.nextNode[board[i][j] - 'a'], tempResult, sb);
                }
            }
        }

        // 需要把tempResult这个set拷贝到真正的result List中进行返回
        result.addAll(tempResult);
        return result;
    }

    private void dfs(char[][] board, boolean[][] visited, int startIInBoard, int startJInBoard
            , TrieNode curNode, Set<String> resultSet, StringBuilder curStrBuilder) {
        curStrBuilder.append(board[startIInBoard][startJInBoard]);
        visited[startIInBoard][startJInBoard] = true;
        if (curNode.isWord()) {
            resultSet.add(curStrBuilder.toString());
        }
        // 向上搜索, 如果上面的格子没有被搜索过的话
        if (startIInBoard > 0 && !visited[startIInBoard - 1][startJInBoard]
                && curNode.nextNode[board[startIInBoard - 1][startJInBoard] - 'a'] != null) {
            dfs(board, visited,startIInBoard - 1, startJInBoard
                    , curNode.nextNode[board[startIInBoard - 1][startJInBoard] - 'a'], resultSet, curStrBuilder);
        }
        // 向下搜索
        if (startIInBoard < board.length - 1 && !visited[startIInBoard + 1][startJInBoard]
                && curNode.nextNode[board[startIInBoard + 1][startJInBoard] - 'a'] != null) {
            dfs(board, visited,startIInBoard + 1, startJInBoard
                    , curNode.nextNode[board[startIInBoard + 1][startJInBoard] - 'a'], resultSet, curStrBuilder);
        }
        // 向左搜索
        if (startJInBoard > 0 && !visited[startIInBoard][startJInBoard - 1]
                && curNode.nextNode[board[startIInBoard][startJInBoard - 1] - 'a'] != null) {
            dfs(board, visited, startIInBoard, startJInBoard - 1
                    , curNode.nextNode[board[startIInBoard][startJInBoard - 1] - 'a'], resultSet, curStrBuilder);
        }
        // 向右搜索
        if (startJInBoard < board[0].length - 1 && !visited[startIInBoard][startJInBoard + 1]
                && curNode.nextNode[board[startIInBoard][startJInBoard + 1] - 'a'] != null) {
            dfs(board, visited, startIInBoard, startJInBoard + 1
                    , curNode.nextNode[board[startIInBoard][startJInBoard + 1] - 'a'], resultSet, curStrBuilder);
        }
        // 恢复现场
        curStrBuilder.setLength(curStrBuilder.length() - 1);
        visited[startIInBoard][startJInBoard] = false;
    }

}