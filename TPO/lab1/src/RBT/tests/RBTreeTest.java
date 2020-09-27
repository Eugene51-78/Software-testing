package RBT.tests;

import RBT.RBTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RBTreeTest {
    RBTree rbt = new RBTree();
    RBTree.Node node;

    @Test
    public void insertTest() {
        for (int i = 0; i <= 4; i++) {
            node = new RBTree.Node(i);
            rbt.insert(node);
        }

        for (int i = 9; i >= 5; i--) {
            RBTree.Node x = new RBTree.Node(i);
            rbt.insert(x);
        }

        assertEquals(3, rbt.root.key);
        assertEquals(RBTree.BLACK, rbt.root.color);
        //
        assertEquals(1, rbt.root.left.key);
        assertEquals(RBTree.BLACK, rbt.root.left.color);
        //
        assertEquals(8, rbt.root.right.key);
        assertEquals(RBTree.BLACK, rbt.root.right.color);
        //
        assertEquals(0, rbt.root.left.left.key);
        assertEquals(RBTree.BLACK, rbt.root.left.left.color);
        //
        assertEquals(2, rbt.root.left.right.key);
        assertEquals(RBTree.BLACK, rbt.root.left.right.color);
        //
        assertEquals(6, rbt.root.right.left.key);
        assertEquals(RBTree.RED, rbt.root.right.left.color);
        //
        assertEquals(9, rbt.root.right.right.key);
        assertEquals(RBTree.BLACK, rbt.root.right.right.color);
        //
        assertEquals(4, rbt.root.right.left.left.key);
        assertEquals(RBTree.BLACK, rbt.root.right.left.left.color);
        //
        assertEquals(7, rbt.root.right.left.right.key);
        assertEquals(RBTree.BLACK, rbt.root.right.left.right.color);
        //
        assertEquals(5, rbt.root.right.left.left.right.key);
        assertEquals(RBTree.RED, rbt.root.right.left.left.right.color);
    }

    @Test
    public void keyExistTest() {
        for (int i = 1; i < 4; i++) {
            RBTree.Node node = new RBTree.Node(i);
            rbt.insert(node);
            assertEquals(rbt.findNode(node, rbt.root).key, node.key);
        }
    }

    @Test
    public void deleteNodeTest() {
        for (int i = 40; i <= 70; i += 5) {
            RBTree.Node node = new RBTree.Node(i);
            rbt.insert(node);
        }
        node = new RBTree.Node(40);
        rbt.delete(node);

        assertEquals(55, rbt.root.key);
        assertEquals(RBTree.BLACK, rbt.root.color);

        assertEquals(45, rbt.root.left.key);
        assertEquals(RBTree.BLACK, rbt.root.left.color);

        assertEquals(50, rbt.root.left.right.key);
        assertEquals(RBTree.RED, rbt.root.left.right.color);

        assertEquals(65, rbt.root.right.key);
        assertEquals(RBTree.BLACK, rbt.root.right.color);

        assertEquals(60, rbt.root.right.left.key);
        assertEquals(RBTree.RED, rbt.root.right.left.color);

        assertEquals(70, rbt.root.right.right.key);
        assertEquals(RBTree.RED, rbt.root.right.right.color);
    }

    @Test
    public void deleteAllNodesTest() {

        for (int i = 40; i <= 70; i += 5) {
            RBTree.Node node = new RBTree.Node(i);
            rbt.insert(node);
        }
        for (int i = 40; i <= 70; i += 5) {
            RBTree.Node node = new RBTree.Node(i);
            rbt.delete(node);
        }

        assertEquals(-1 ,rbt.root.key);
    }

    @Test
    public void findNodeTest() {
        for (int i = 40; i <= 70; i += 5) {
            RBTree.Node node = new RBTree.Node(i);
            rbt.insert(node);
        }
        RBTree.Node node70 = new RBTree.Node(70);
        assertEquals("Node{key=70}", rbt.find(node70, rbt.root));

        RBTree.Node node60 = new RBTree.Node(60);
        rbt.delete(node60);
        assertEquals("Node 60 doesn't exist", rbt.find(node60, rbt.root));


        rbt.deleteTree();
        assertEquals("Tree doesn't exist" , rbt.find(node70, rbt.root));
    }

}