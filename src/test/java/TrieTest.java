import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieTest {
    Trie trie;
    List<String> data;
    List<String> searchData;

    @Before
    public void before(){
        trie = new Trie();
        data = new ArrayList<String>();
        searchData = new ArrayList<String>();
        data.addAll(Arrays.asList("abc","abd","def","efg","efjk","jklmn","jklmno"));
        searchData.addAll(Arrays.asList("abcd","abc","efg","efjklmn","jklmn","jklmno"));

        for(int i=0;i<data.size();i++){
            System.out.println("Inserting key - "+data.get(i));
            trie.insertKey(data.get(i));
        }
    }

    @Test
    public void testSearchData(){

        for(int i=0;i<searchData.size();i++){

            System.out.println("Searching data - "+searchData.get(i) + " Result- "+trie.searchKey(searchData.get(i)));

        }



    }


}
