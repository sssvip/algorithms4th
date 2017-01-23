package fundamentals.sort.quicksort;

import fundamentals.sort.common.Sortable;

/**
 * The type Quick sort.
 */
public class QuickSort extends Sortable {
  private int partition(Comparable[] a, int fromIndex, int toIndex) {
    //checkOffset(a, fromIndex, toIndex);
    //define a couple of pointer
    int i = fromIndex;
    int j = toIndex;
    //store value temporarily
    Comparable pivot = a[fromIndex];
    while (true) {
      //compare and move pointer to right
      while (less(a[i++], pivot)) {
        if (i == toIndex) {
          break;
        }
      }
      //compare and move pointer to left
      while (less(pivot, a[--j])) {
        if (j == fromIndex) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      exch(a, i, j);
    }
    exch(a, fromIndex, j);
    return j;
  }

  @Override
  public void sort(Comparable[] a, int fromIndex, int toIndex) {
    checkOffset(a, fromIndex, toIndex);
    if (fromIndex >= toIndex) {
      return;
    }
    int j = partition(a, fromIndex, toIndex);
    sort(a, fromIndex, j);
    sort(a, j, toIndex);
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Integer[] integers = new Integer[] {10,8,3,1,5,4};
    QuickSort quickSort = new QuickSort();
    quickSort.show(integers);
    quickSort.sort(integers);
    quickSort.show(integers);
  }
}
