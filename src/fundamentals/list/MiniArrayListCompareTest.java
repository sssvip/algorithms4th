package fundamentals.list;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Mini array list compare test.
 */
public class MiniArrayListCompareTest {

  /**
   * Add test.
   */
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
    System.out.println(miniArrayList.size());//5
    System.out.println(arrayList.size());//5

    //test print out direct
    System.out.println(miniArrayList);//[test0, test1, test2, test3, test4]
    System.out.println(arrayList);//[test0, test1, test2, test3, test4]

    //test print out by array
    System.out.println(Arrays.toString(miniArrayList.toArray()));//[test0, test1, test2, test3, test4]
    System.out.println(Arrays.toString(arrayList.toArray()));//[test0, test1, test2, test3, test4]
  }


  /**
   * Index test.
   */
  @Test
  public void indexTest() {
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 5;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("indexTest" + i);
    }
    miniArrayList.add("indexTest" + 2);
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("indexTest" + i);
    }
    arrayList.add("indexTest" + 2);
    //test print index direct
    System.out.println(miniArrayList.indexOf("indexTest1"));//1
    System.out.println(arrayList.indexOf("indexTest1"));//1

    //test print object last index
    System.out.println(miniArrayList.lastIndexOf("indexTest2"));//NullPointerException
    System.out.println(arrayList.lastIndexOf("indexTest2"));//5

    //test print isEmpty
    System.out.println(miniArrayList.isEmpty());//false
    System.out.println(arrayList.isEmpty());//false

    //test clear and print isEmpty again
    miniArrayList.clear();
    arrayList.clear();
    System.out.println(miniArrayList.isEmpty());//true
    System.out.println(arrayList.isEmpty());//true

  }
}
