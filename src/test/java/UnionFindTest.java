import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UnionFindTest {

    int data[];
    UnionFind unionFind;

    @Before
    public void setUp(){
        data = new int[10];
        for(int i=0;i<data.length;i++)
            data[i]=i;

        unionFind = new UnionFind().makeSet(data);

    }
    //we have set as
    //{0} {1} {2} {3} {4} {5} {6} {7} {8} {9}
    //operations to verify results
    // 1. find(0) == 0
    // union(0,3)
    //resulting set- {0,3} {1} {2} {4} {5} {6} {7} {8} {9}
    //2. find(0) == find(3)
    // union(3,6)
    //resulting set - {0,3,6} {1} {2} {4} {5} {7} {8} {9}
    // 3. find(0) == find(3)
    // 4. find(3) == find(6)
    //union (1,2)
    //resulting set - {0,3,6} {1,2} {4} {5} {7} {8} {9}
    //5. find(1) == find(2)
    //6. find(0) != find(2)
    //union(3,1)
    //resulting set - {0,3,6,1,2} {4} {5} {7} {8} {9}
    //7. find(3) == find(2)
    //8. find(0) == find(1)

    @Test
    public void unionFindAlgoTest(){
        assertEquals(unionFind.find(unionFind.nodes[0]),unionFind.nodes[0]);
        unionFind.union(unionFind.nodes[0],unionFind.nodes[3]);
        assertEquals(unionFind.find(unionFind.nodes[0]),unionFind.find(unionFind.nodes[3]));
        unionFind.union(unionFind.nodes[3],unionFind.nodes[6]);
        assertEquals(unionFind.find(unionFind.nodes[0]),unionFind.find(unionFind.nodes[6]));
        assertEquals(unionFind.find(unionFind.nodes[3]),unionFind.find(unionFind.nodes[6]));
        unionFind.union(unionFind.nodes[1],unionFind.nodes[2]);
        assertEquals(unionFind.find(unionFind.nodes[1]),unionFind.find(unionFind.nodes[2]));
        assertNotEquals(unionFind.find(unionFind.nodes[0]),unionFind.find(unionFind.nodes[2]));
        unionFind.union(unionFind.nodes[3],unionFind.nodes[1]);
        assertEquals(unionFind.find(unionFind.nodes[3]),unionFind.find(unionFind.nodes[2]));
        assertEquals(unionFind.find(unionFind.nodes[0]),unionFind.find(unionFind.nodes[1]));
    }

}
