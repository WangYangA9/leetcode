import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/18 0018.
 */
class Trie {
    //第一种弟弟做法，使用list来做
//    List<String> list = new ArrayList<>();
//    /** Initialize your data structure here. */
//    public Trie() {
//
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        list.add(word);
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        return list.contains(word);
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        for(String elem: list){
//            if(elem.startsWith(prefix)){
//                return true;
//            }
//        }
//        return false;
//    }
    /** Initialize your data structure here. */
    class TreeNode {
        TreeNode[] nextNode;
        boolean isWord;

        public TreeNode(boolean isWord) {
            nextNode = new TreeNode[26];
            this.isWord = isWord;
        }

        public TreeNode[] getNextNode() {
            return nextNode;
        }

        public void setNextNode(TreeNode[] nextNode) {
            this.nextNode = nextNode;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }
    private TreeNode treeNode;
    public Trie() {
        treeNode = new TreeNode(false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = this.treeNode;
        for(int i = 0 ;i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.getNextNode()[c - 'a'] == null) {
                node.getNextNode()[c - 'a'] = new TreeNode(false);
            }
            node = node.getNextNode()[c - 'a'];
        }
        node.setWord(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = this.treeNode;
        for(int i = 0 ;i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.getNextNode()[c - 'a'] == null) {
                return false;
            }
            node = node.getNextNode()[c - 'a'];
        }
        return node.isWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = this.treeNode;
        for(int i = 0 ;i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(node.getNextNode()[c - 'a'] == null) {
                return false;
            }
            node = node.getNextNode()[c - 'a'];
        }
        return true;
    }


    public static void main(String[] args){
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */