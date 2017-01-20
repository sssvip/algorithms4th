package fundamentals.sort.insertsort;


import fundamentals.sort.common.Sortable;

/**
 * The type Insert sort.
 */
public class InsertSort extends Sortable {


  @Override
  public void sort(Comparable[] a, int index, int offset) {
    checkOffset(a, index, offset);
    int end = index + offset;
    for (int i = index; i < end; i++) {
      //find the min
      for (int j = i; j < end; j++) {
        if (!less(a[i], a[j])) {
          exch(a, i, j);
        }
      }
    }
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    InsertSort insertSort = new InsertSort();
    //sort from 0 to integers.length
    Integer[] integers = new Integer[] {1, 2, 4, 1, 43, 21, 4, 5, 3};
    insertSort.show(integers);
    insertSort.sort(integers);
    insertSort.show(integers);

    //sort from 3 to 5
    Double[] doubles = new Double[] {1.2, 2.1, 4.4, 33.2, 44.1, 41.3, 12.1, 434.2};
    insertSort.show(doubles);
    insertSort.sort(doubles, 3, 5);
    insertSort.show(doubles);

  }
}
