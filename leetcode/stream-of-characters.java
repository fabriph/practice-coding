/**
https://leetcode.com/problems/stream-of-characters

Gets time limit exceeded on a really extreme test case "aaaa.....aaaab"
Possible improvements:
 - deleting from the middle in the linked list of iterators is slow.
 - maybe the creation of the trie is not as fast as it can, and can be improved
*/

class StreamChecker {
    Node root;
    List<Node> iterators;

    public StreamChecker(String[] words) {
        iterators = new LinkedList<>();
        root = new Node();
        
        for (String w : words) {
            Node current = root;
            char[] chars = w.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                current =
                    current.addChildren(
                        chars[i],
                        /* isWord =*/ chars.length == (i + 1));
            }
        }
        //System.out.println("trie " + root);
    }
    
    public boolean query(char letter) {
        // add a new iterator at root
        iterators.add(root);
        
        // advance all iterators (discarding the ones that go to null)
        int i = 0;
        boolean result = false;
        while (i < iterators.size()) {
            Node it = iterators.get(i);
            
            it = it.getNext(letter);
            iterators.set(i, it);
            if (it == null) {
                iterators.remove(i);
                continue;
            }
            if (it.isWord) {
                result = true;
            }
            i++;
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
