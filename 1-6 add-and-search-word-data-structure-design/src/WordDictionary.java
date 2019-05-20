/**
 * @Author: WangYang
 * @Date: 2019/5/19 17:36
 * @Description:
 */
class WordDictionary {
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
    /** Initialize your data structure here. */
    public WordDictionary() {
        treeNode = new TreeNode(false);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return true;
        }
        return search(word, this.treeNode);
    }

    public boolean search(String subWord, TreeNode treeNode){
        if(subWord.length() == 0){
            return treeNode.isWord();
        }
        char c = subWord.charAt(0);
        if(c == '.'){
            for(int i = 0;i < 26; i++){
                if(treeNode.getNextNode()[i] != null){
                    return search(subWord.substring(1), treeNode.getNextNode()[i]);
                }
            }
        } else {
            return treeNode.getNextNode()[c - 'a'] != null
                    && search(subWord.substring(1), treeNode.getNextNode()[c - 'a']);
        }
        return false;
    }
    public static void main(String[] arg){
        WordDictionary obj = new WordDictionary();
        obj.addWord("bat");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search(".at"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */