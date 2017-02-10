package fundamentals.graph;


import org.junit.Assert;
import org.junit.Test;

/**
 * The type Breadth first paths test.
 */
public class BreadthFirstPathsTest {
  /**
   * Test has path to.
   */
  @Test
  public void testHasPathTo() {
    Graph G = Graph.getTestGraphWithData();
    //0 as the start vertex
    BreadthFirstPaths bfp = new BreadthFirstPaths(G, 0);
    Assert.assertTrue(bfp.hasPathTo(1));
  }

  /**
   * Test path to.
   */
  @Test
  public void testPathTo() {
    Graph G = Graph.getTestGraphWithData();
    //0 as the start vertex
    BreadthFirstPaths bfp = new BreadthFirstPaths(G, 0);
    //assert the path
    Assert.assertEquals("[4, 5, 0]", bfp.pathTo(4).toString());
    //assert unreachable
    Assert.assertEquals(null, bfp.pathTo(9));
  }
}
