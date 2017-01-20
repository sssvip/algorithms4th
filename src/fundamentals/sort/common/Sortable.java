package fundamentals.sort.common;

/**
 * The interface Sortable.
 */
public abstract class Sortable {
  /**
   * compare value of v and w,if v less than w return true, vice versa
   *
   * @param v the v
   * @param w the w
   * @return the boolean
   */
  public boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  /**
   * exchange index of i,j 's data of array a
   *
   * @param a the a
   * @param i the
   * @param j the j
   */
  public void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  /**
   * print the array to show data
   *
   * @param a the a
   */
  public void show(Comparable[] a) {
    for (Comparable c : a) {
      System.out.print(c + " ");
    }
    System.out.println();
  }

  /**
   * if array a has been sorted(ASC) return true vice versa.
   *
   * @param a the a
   * @return the boolean
   */
  public boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }


  /**
   * sort array a from 0 to a.length
   *
   * @param a the a
   */
  public void sort(Comparable[] a) {
    sort(a, 0, a.length);
  }

  /**
   * sort array a from i to j
   *
   * @param a      the a
   * @param index  the
   * @param offset the offset
   */
  public abstract void sort(Comparable[] a, int index, int offset);


  /**
   * index can't less than 0;
   * <p>
   * index+offset can't greater than a.length
   *
   * @param a         the a
   * @param fromIndex the index
   * @param toIndex   the offset
   */
  public void checkOffset(Comparable[] a, int fromIndex, int toIndex) {
    if (fromIndex < 0) {
      throw new RuntimeException("fromIndex not be allowed less than zero");
    }
    if (toIndex > a.length) {
      throw new RuntimeException("toIndex can't greater than a.lenght");
    }
  }
}
