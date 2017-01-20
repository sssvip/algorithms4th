package fundamentals.sort.selectsort;


import fundamentals.sort.common.Sortable;

/**
 * The type Select sort.
 */
public class SelectSort extends Sortable {
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
    SelectSort selectSort = new SelectSort();
    //sort from 0 to integers.length
    Integer[] integers = new Integer[] {1, 2, 4, 1, 43, 21, 4, 5, 3};
    selectSort.show(integers);//1 2 4 1 43 21 4 5 3
    selectSort.sort(integers);
    selectSort.show(integers);//1 1 2 3 4 4 5 21 43

    //sort from 3 to 5
    Double[] doubles = new Double[] {1.2, 2.1, 4.4, 33.2, 44.1, 41.3, 12.1, 434.2};
    selectSort.show(doubles);//1.2 2.1 4.4 33.2 44.1 41.3 12.1 434.2
    selectSort.sort(doubles, 3, 5);
    selectSort.show(doubles);//1.2 2.1 4.4 12.1 33.2 41.3 44.1 434.2

  }
}
