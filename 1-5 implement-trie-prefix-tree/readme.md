实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
```
示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
```
执行用时 : 177 ms, 在Implement Trie (Prefix Tree)的Java提交中击败了66.86% 的用户

内存消耗 : 60.7 MB, 在Implement Trie (Prefix Tree)的Java提交中击败了82.23% 的用户
