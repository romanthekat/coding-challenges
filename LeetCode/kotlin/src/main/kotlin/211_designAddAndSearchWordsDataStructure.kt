import Common.Companion.assertEquals
import java.util.*

/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

    WordDictionary() Initializes the object.
    void addWord(word) Adds word to the data structure, it can be matched later.
    bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example:
```
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
```

Constraints:

    1 <= word.length <= 500
    word in addWord consists lower-case English letters.
    word in search consist of  '.' or lower-case English letters.
    At most 50000 calls will be made to addWord and search.

 */
class WordDictionary {
    private var root: Trie = Trie(Char.MAX_SURROGATE)

    class Trie(val letter: Char) {
        var isWord: Boolean = false
        var children: MutableMap<Char, Trie> = mutableMapOf()
    }

    fun addWord(word: String) {
        var node: Trie = root

        for (c in word) {
            val child = node.children[c]
            if (child == null) {
                val newNode = Trie(c)
                node.children[c] = newNode
                node = newNode
            } else {
                node = child
            }
        }

        node.isWord = true
    }

    fun search(word: String): Boolean {
        return search(word, root)
    }

    fun search(word: String, node: Trie): Boolean {
        if (word.isEmpty()) {
            return node.isWord
        }

        val letter = word[0]

        if (letter == '.') {
            for (child in node.children.values) {
                if (search(word.substring(1), child)) {
                    return true
                }
            }

            return false
        }

        val child = node.children[letter]
        if (child != null) {
            return search(word.substring(1), child)
        }

        return false
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */
fun main() {
    val dict = WordDictionary()
    dict.addWord("bad")
    dict.addWord("dad")
    dict.addWord("mad")
    assertEquals(dict.search("pad"), false)
    assertEquals(dict.search("bad"), true)
    assertEquals(dict.search(".ad"), true)
    assertEquals(dict.search("b.."), true)
}