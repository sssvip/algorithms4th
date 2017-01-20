package fundamentals.sort.shellsort;

import fundamentals.sort.common.Sortable;

public class ShellSort extends Sortable{
  @Override
  public void sort(Comparable[] a, int index, int offset) {
    checkOffset(a,index,offset);
  }
}
