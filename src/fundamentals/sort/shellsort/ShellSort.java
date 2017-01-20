package fundamentals.sort.shellsort;

import fundamentals.sort.common.Sortable;

/**
 * the importance think about shell sort is that devide the array and use insert sort again and again
 * <p>
 * The type Shell sort.
 */
public class ShellSort extends Sortable {
  @Override
  public void sort(Comparable[] a, int fromIndex, int toIndex) {
    checkOffset(a, fromIndex, toIndex);
    int size = toIndex - fromIndex;//sort size
    int width = 3;//divides width,it can be try to find the best value
    int h = 1;//
    while (h < (size / width)) {
      h = h * width + 1;//1,4,13,40....
    }

    while (h >= 1) { //cautious,must >=1
      for (int i = fromIndex; i < toIndex; i += h) {//cautious i+=h, just the divide thinking
        for (int j = i; j > 0 && less(a[j], a[j - h]); j -= h) {//use insert sort thinking to sort
          exch(a, j, j - h);
        }
      }
      h = h / width;//....40,13,4,1
    }
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    ShellSort shellSort = new ShellSort();
    Integer[] integers = new Integer[] {1, 2, 1, 45, 32, 52, 12, 11, 22, 322, 4, 42, 3, 45, 64, 45, 4};
    shellSort.show(integers);//1 2 1 45 32 52 12 11 22 322 4 42 3 45 64 45 4
    shellSort.sort(integers);
    shellSort.show(integers);//1 1 2 3 4 4 11 12 22 32 42 45 45 45 52 64 322
  }
}
