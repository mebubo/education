package c04_trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static c04_trees_and_graphs.E04_03.createBinarySearchTree;
import static c04_trees_and_graphs.E04_04.createLevelLists;
import static c04_trees_and_graphs.E04_04.getNodesAtDepth;
import static org.junit.Assert.*;

public class E04_04Test {

    private BinaryTreeNode tree;

    @Before
    public void setUp() throws Exception {
        tree = createBinarySearchTree(new String[]{"1", "2", "3", "4", "5", "6", "7"});
    }

    @Test
    public void testGetNodesAtDepth() throws Exception {
        assertEquals(Arrays.asList("4"), getData(getNodesAtDepth(tree, 0)));
        assertEquals(Arrays.asList("2", "6"), getData(getNodesAtDepth(tree, 1)));
        assertEquals(Arrays.asList("1", "3", "5", "7"), getData(getNodesAtDepth(tree, 2)));
        assertEquals(0, getData(getNodesAtDepth(tree, 3)).size());
        assertEquals(0, getData(getNodesAtDepth(null, 0)).size());
    }

    private List<String> getData(List<BinaryTreeNode<String>> input) {
        return input.stream().map((BinaryTreeNode<String> node) -> node.data).collect(Collectors.toList());
    }

    @Test
    public void testCreateLevelLists() throws Exception {
        List<List<BinaryTreeNode<String>>> levelLists = createLevelLists(tree);
        assertEquals(Arrays.asList("4"), getData(levelLists.get(0)));
        assertEquals(Arrays.asList("2", "6"), getData(levelLists.get(1)));
        assertEquals(Arrays.asList("1", "3", "5", "7"), getData(levelLists.get(2)));
        assertEquals(3, levelLists.size());
        assertEquals(0, createLevelLists(null).size());
    }
}