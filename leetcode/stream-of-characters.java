/**
https://leetcode.com/problems/stream-of-characters
Runtime: 276 ms, faster than 32.70% of Java online submissions for Stream of Characters.
Memory Usage: 72.6 MB, less than 100.00% of Java online submissions for Stream of Characters.

n: # words
k: length of longest word

Time build: O(n * k)
Time query: O(k)
Space: O(n * k)

Other alternative:
build a suffix tree
when a query arrives,
either use a String builder to keep track of latest chars or
a circular buffer (with length of longest word in the suffix tree)
this avoids having a lot of iterators, but the time complexity to solve a single query is the same

*/
class StreamChecker {
    Node root;
    Node[] iterators;

    public StreamChecker(String[] words) {
        root = new Node();
        
        int longestWord = 0;
        for (String w : words) {
            Node current = root;
            char[] chars = w.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                current =
                    current.addChildren(
                        chars[i],
                        /* isWord =*/ chars.length == (i + 1));
            }
            longestWord = Math.max(longestWord, chars.length);
        }
        
        iterators = new Node[longestWord + 2];
        //System.out.println("trie " + root);
    }
    
    public boolean query(char letter) {
        // add a new iterator at root
        iterators[0] = root;
        
        // advance all iterators (discarding the ones that go to null)
        boolean result = false;
        Node it;
        for (int i = iterators.length - 2; i >= 0; --i) {
            if (iterators[i] == null) {
                continue;
            }

            it = iterators[i];
            iterators[i] = null;

            it = it.getNext(letter);
            if (it == null) {
                continue;
            }
            iterators[i + 1] = it;
            if (it.isWord) {
                result = true;
            }
        }
        return result;
    }
    
    // Trie node
    private static class Node {
        private Node[] children;
        boolean isWord;

        public Node () {
            children = new Node[26];
        }
        
        public Node addChildren(char c, boolean isWord) {
            int t = c - 'a';
            if (children[t] == null) {
                children[t] = new Node();
            }
            children[t].isWord = children[t].isWord | isWord;
            return children[t];
        }
        
        public Node getNext(char c) {
            return children[c - 'a'];
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (isWord) {
                sb.append("_[");
            } else {
                sb.append(":[");
            }
            for (int i = 0; i < 26; ++i) {
                if (children[i] != null) {
                    char c = (char) ('a' + i);
                    sb.append(c);
                    sb.append(children[i]);
                    sb.append(" ");
                }
            }
            sb.append("] ");
            return sb.toString();
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
