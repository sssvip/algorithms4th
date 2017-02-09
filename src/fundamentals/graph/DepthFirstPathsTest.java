package fundamentals.graph;


import org.junit.Assert;
import org.junit.Test;

public class DepthFirstPathsTest {
  @Test
  public void testHasPathTo() {
    Graph G = Graph.getTestGraphWithData();
    //0 as the start vertex
    DepthFirstPaths dfp = new DepthFirstPaths(G, 0);
    Assert.assertTrue(dfp.hasPathTo(1));
  }

  @Test
  public void testPathTo() {
    Graph G = Graph.getTestGraphWithData();
    //0 as the start vertex
    DepthFirstPaths dfp = new DepthFirstPaths(G, 0);
    //assert the path
    Assert.assertEquals("[4, 5, 0]", dfp.pathTo(4).toString());
    //assert unreachable
    Assert.assertEquals(null, dfp.pathTo(9));
  }
}
