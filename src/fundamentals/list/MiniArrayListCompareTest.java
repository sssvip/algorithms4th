package fundamentals.list;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    System.out.println(miniArrayList.lastIndexOf("indexTest2"));//5
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

  @Test
  public void setAndGetTest() {
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 5;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("indexTest" + i);
    }
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("indexTest" + i);
    }
    //set at 3 index
    miniArrayList.set(3, "setData");
    arrayList.set(3, "setData");
    //print the set data
    System.out.println(miniArrayList.get(3));//setData
    System.out.println(arrayList.get(3));//setData
  }

  @Test
  public void addAllTest() {
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 2;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("indexTest" + i);
    }
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("indexTest" + i);
    }
    //prepare data collection
    ArrayList<String> data = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      data.add("addAll Data"+i);
    }
    //set data collection
    miniArrayList.addAll(data);
    arrayList.addAll(data);
    //print
    System.out.println(miniArrayList);//[indexTest0, indexTest1, addAll Data0, addAll Data1]
    System.out.println(arrayList);//[indexTest0, indexTest1, addAll Data0, addAll Data1]
    //set data collection at a specific index
    miniArrayList.addAll(4,data);
    arrayList.addAll(4,data);
    //after set data print again
    System.out.println(miniArrayList);//[indexTest0, indexTest1, addAll Data0, addAll Data1, addAll Data0, addAll Data1]
    System.out.println(arrayList);//[indexTest0, indexTest1, addAll Data0, addAll Data1, addAll Data0, addAll Data1]
  }

  @Test
  public void removeTest(){
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 5;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("indexTest" + i);
    }
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("indexTest" + i);
    }
    //remove a data
    miniArrayList.remove("indexTest0");
    arrayList.remove("indexTest0");
    //print
    System.out.println(miniArrayList);//[indexTest1, indexTest2, indexTest3, indexTest4]
    System.out.println(arrayList);//[indexTest1, indexTest2, indexTest3, indexTest4]

    //prepare removeAll data
    ArrayList<String> removeData=new ArrayList<String>();
    removeData.add("indexTest1");
    removeData.add("indexTest2");
    removeData.add("indexTest3");

    //removeAll data
    miniArrayList.removeAll(removeData);
    arrayList.removeAll(removeData);

    //print to show
    System.out.println(miniArrayList);//[indexTest4]
    System.out.println(arrayList);//[indexTest4]
  }

  @Test
  public void retainTest(){
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 5;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("indexTest" + i);
    }
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("indexTest" + i);
    }

    //prepare retain data
    ArrayList<String> retainData=new ArrayList<String>();
    retainData.add("indexTest1");
    retainData.add("indexTest2");
    retainData.add("indexTest3");
    retainData.add("indexTest4");

    //retain data
    miniArrayList.retainAll(retainData);
    arrayList.retainAll(retainData);

    //print to show

    System.out.println(miniArrayList);//[indexTest1, indexTest2, indexTest3, indexTest4]
    System.out.println(arrayList);//[indexTest1, indexTest2, indexTest3, indexTest4]
  }

  @Test
  public void subListTest(){
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 5;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("indexTest" + i);
    }
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("indexTest" + i);
    }
    //get subList
    List<String> subMiniArrayList=miniArrayList.subList(2,4);
    List<String> subArrayList=arrayList.subList(2,4);
    //print to show
    System.out.println(subMiniArrayList);//[indexTest2, indexTest3]
    System.out.println(subArrayList);//[indexTest2, indexTest3]
  }

}
