package fundamentals.sort.mergesort;


import fundamentals.sort.common.Sortable;

/**
 * The type Merge sort.
 */
public class MergeSort extends Sortable {

  private void merge(Comparable[] a, int fromIndex, int mid, int toIndex) {
    checkOffset(a, fromIndex, toIndex);
    //get left half data
    Comparable[] left = new Comparable[mid - fromIndex];
    for (int i = 0; i < left.length; i++) {
      left[i] = a[i + fromIndex];
    }
    //get right half data
    Comparable[] right = new Comparable[toIndex - mid];
    for (int i = 0; i < right.length; i++) {
      right[i] = a[i + mid];
    }
    //merge data
    //simulation two queue enter one queue
    int leftDataPointer = 0;
    int rightDataPointer = 0;
    for (int i = fromIndex; i < toIndex; i++) {
      //check when one queen all remove
      if (leftDataPointer >= left.length) {
        a[i] = right[rightDataPointer++];
        continue;
      } else if (rightDataPointer >= right.length) {
        a[i] = left[leftDataPointer++];
        continue;
      }
      //who less who in
      if (less(left[leftDataPointer], right[rightDataPointer])) {
        a[i] = left[leftDataPointer++];
      } else {
        a[i] = right[rightDataPointer++];
      }
    }

  }

  @Override
  public void sort(Comparable[] a, int fromIndex, int toIndex) {
    checkOffset(a, fromIndex, toIndex);
    //stop recursion
    if ((toIndex - fromIndex) <= 1) {
      return;
    }
    int mid = fromIndex + (toIndex - fromIndex) / 2;
    sort(a, fromIndex, mid);//sort left half
    sort(a, mid, toIndex);//sort right half
    merge(a, fromIndex, mid, toIndex);
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Integer[] integers = new Integer[] {1, 4, 2, 4, 2, 4, 5, 44, 2, 3, 2, 1, 43, 1, 23, 12, 3, 1, 23, 34, 2, 4};
    MergeSort mergeSort = new MergeSort();
    mergeSort.show(integers);//1 4 2 4 2 4 5 44 2 3 2 1 43 1 23 12 3 1 23 34 2 4
    mergeSort.sort(integers);
    mergeSort.show(integers);//1 1 1 1 2 2 2 2 2 3 3 4 4 4 4 5 12 23 23 34 43 44
  }
}
