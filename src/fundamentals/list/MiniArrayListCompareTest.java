package fundamentals.list;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Mini array list compare test.
 */
public class MiniArrayListCompareTest {

  @Test
  public void addTest() {
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 5;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("test" + i);
    }
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("test" + i);
    }
    //test print size
    System.out.println(miniArrayList.size());//stackoverflow before fix #1
    System.out.println(arrayList.size());//5

    //test print out direct
    System.out.println(miniArrayList);//fundamentals.list.MiniArrayList@1376c05c
    System.out.println(arrayList);//[test0, test1, test2, test3, test4]

    //test print out by array
    System.out.println(Arrays.toString(miniArrayList.toArray()));//[test0, test1, test2, test3, test4, null, null, null, null, null]
    System.out.println(Arrays.toString(arrayList.toArray()));//[test0, test1, test2, test3, test4]
  }
}
