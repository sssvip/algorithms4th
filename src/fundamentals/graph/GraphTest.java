package fundamentals.graph;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

  /*
  *
  * 13 vertices,13 edges
    0: 5 1 2 6
    1: 0
    2: 0
    3: 4 5
    4: 3 6 5
    5: 0 4 3
    6: 4 0
    7: 8
    8: 7
    9: 12 10 11
    10: 9
    11: 12 9
    12: 9 11
  * */
  @Test
  public void testGetGraphWithData() {
    Graph G = Graph.getTestGraphWithData();
    Assert.assertNotNull(G);
    Assert.assertEquals(13, G.V());
  }

  @Test
  public void testDegree() {
    Graph G = Graph.getTestGraphWithData();
    Assert.assertEquals(4, Graph.degree(G, 0));
    Assert.assertEquals(3, Graph.degree(G, 9));
    Assert.assertEquals(2, Graph.degree(G, 12));
  }

  @Test
  public void testMaxDegree() {
    Graph G = Graph.getTestGraphWithData();
    Assert.assertEquals(4, Graph.maxDegree(G));
  }

  @Test
  public void testAvgDegree() {
    Graph G = Graph.getTestGraphWithData();
    Assert.assertEquals(2, Graph.avgDegree(G),0);
  }
  @Test
  public void testNumberOfSelfLoops(){
    Graph G = Graph.getTestGraphWithData();
    Assert.assertEquals(0, Graph.numberOfSelfLoops(G));
  }
}
