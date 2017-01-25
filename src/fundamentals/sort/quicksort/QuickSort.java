package fundamentals.sort.quicksort;

import fundamentals.sort.common.Sortable;

/**
 * The type Quick sort.
 */
public class QuickSort extends Sortable {
  private int partition(Comparable[] a, int fromIndex, int toIndex) {
    //define a couple of pointer
    int i = fromIndex;
    int j = toIndex + 1;
    Comparable v = a[fromIndex];
    while (true) {
      //move left pointer
      while (less(a[++i], v)) {
        if (i == toIndex) {
          break;
        }
      }
      //move right pointer
      while (less(v, a[--j])) {
        if (j == fromIndex) {
          break;
        }
      }
      //ensure bound
      if (i >= j) {
        break;
      }
      //exchange and run again
      exch(a, i, j);
    }
    //exchange pivot and return the index
    exch(a, fromIndex, j);
    return j;
  }

  @Override
  public void sort(Comparable[] a, int fromIndex, int toIndex) {
    //checkOffset(a, fromIndex, toIndex);
    if (toIndex <= fromIndex) {
      return;
    }
    int j = partition(a, fromIndex, toIndex);
    sort(a, fromIndex, j - 1);
    sort(a, j + 1, toIndex);
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Integer[] integers = new Integer[] {1000, 84, 35, 1, 5, 4, 3, 5, 22, 1};
    QuickSort quickSort = new QuickSort();
    quickSort.show(integers);//1000 84 35 1 5 4 3 5 22 1
    quickSort.sort(integers, 0, integers.length - 1);
    quickSort.show(integers);//1 1 3 4 5 5 22 35 84 1000
    quickSort.noticeIfNotSorted(integers);
  }
}
