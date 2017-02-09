package fundamentals.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * The type Depth first search test.
 */
public class DepthFirstSearchTest {
  /**
   * Test reachable
   */
  @Test
  public void testMarked() {
    Graph G = Graph.getTestGraphWithData();
    //0 as the start vertex
    DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
    Assert.assertFalse(dfs.marked(7));
    Assert.assertFalse(dfs.marked(8));
    Assert.assertFalse(dfs.marked(9));
    Assert.assertFalse(dfs.marked(10));
    Assert.assertFalse(dfs.marked(11));
    Assert.assertFalse(dfs.marked(12));
    Assert.assertTrue(dfs.marked(1));
    Assert.assertTrue(dfs.marked(2));
    Assert.assertTrue(dfs.marked(3));
    Assert.assertTrue(dfs.marked(4));
    Assert.assertTrue(dfs.marked(5));
    Assert.assertTrue(dfs.marked(6));
  }

  /**
   * Test count of reachable vertex .
   */
  @Test
  public void testCount() {
    Graph G = Graph.getTestGraphWithData();
    //0 as the start vertex
    DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
    Assert.assertEquals(7, dfs.count());
  }
}
