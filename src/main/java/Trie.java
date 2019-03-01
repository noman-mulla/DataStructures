public class Trie {
    int size;
    Node root;
    class Node{
        Node[] alpha;
        boolean isEnd;
        public Node(){
            alpha = new Node[size];
            isEnd = false;
            for(int i=0;i<size;i++)
                alpha[i] = null;

        }
    }
    public Trie(){
        size = 26;
        root = new Node();
    }

    public void insertKey(String key){
        Node insertNode = root;
        for(int i=0;i<key.length();i++){
            if(insertNode.alpha[key.charAt(i)-'a']==null){
                insertNode.alpha[key.charAt(i)-'a'] = new Node();

            }
            insertNode = insertNode.alpha[key.charAt(i)-'a'];
        }
        insertNode.isEnd = true;

    }

    public boolean searchKey(String key){
        Node searchNode = root;

        for(int i=0;i<key.length();i++){
            if(searchNode.alpha[(key.charAt(i)-'a')]==null)
                return false;
            searchNode = searchNode.alpha[(key.charAt(i)-'a')];
        }
        return searchNode.isEnd;

    }




}
