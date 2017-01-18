package fundamentals.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;


/**
 * The type Mini array list.
 *
 * @param <T> the type parameter
 */
public class MiniArrayList<T> implements List<T> {
  //store data
  private Object[] data;
  //the size of element
  private int size;
  //initial length of data
  private int initialCapacity = 10;

  /**
   * Instantiates a new Array list.
   */
  public MiniArrayList() {
    data = new Object[initialCapacity];
  }

  /**
   * Instantiates a new Array list.
   *
   * @param initialCapacity the initial capacity
   */
  public MiniArrayList(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new RuntimeException("initialCapacity error");
    }
    data = new Object[initialCapacity];
  }

  private void checkSize() {
    checkSize(1);
  }

  private void checkSize(int addSize) {

    if ((size + addSize) > data.length) {
      //resize-- 2 times
      Object[] tempData = new Object[data.length * 2];
      for (int i = 0; i < data.length; i++) {
        tempData[i] = data[i];
      }
      data = tempData;
      tempData = null;
    }
    //in order to confirm arrayoutbounds
    if (data.length < (size + addSize)) {
      checkSize(addSize);
    }
  }

  //test fix commit close issue
  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return size < 1;
  }

  @Override
  public boolean contains(Object object) {
    for (Object element : data) {
      if (element.equals(object)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(data, size);
  }

  @Override
  public <T1> T1[] toArray(T1[] a) {
    return (T1[]) data;
  }

  @Override
  public boolean add(T t) {
    checkSize(1);
    data[size++] = t;
    return true;
  }

  /**
   * move the element,occupy the null index
   *
   * @param
   */
  private void occupyNull() {
    for (int i = 0; i < size; i++) {
      if (data[i] == null) {
        int nextNotNullIndex=nextNotNullIndex(i);
        if (nextNotNullIndex > 0) {
          data[i] = data[nextNotNullIndex];
          data[nextNotNullIndex] = null;
          occupyNull();
        } else {
          return;
        }
      }
    }
  }

  private int nextNotNullIndex(int start) {
    for (int i = start; i < data.length; i++) {
      if (data[i] != null) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean remove(Object o) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(o)) {
        data[i] = null;
        //move null
        occupyNull();
        size--;
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object o : c) {
      boolean isIn = false;
      for (Object element : data) {
        if (element.equals(o)) {
          isIn = true;
          //accelerate travel
          break;
        }
      }
      if (isIn == false) {
        return false;
      }
    }
    return true;
  }

  /**
   * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's Iterator.
   *
   * @param c
   * @return
   */
  @Override
  public boolean addAll(Collection<? extends T> c) {
    for (T t : c) {
      add(t);
    }
    return true;
  }

  /**
   * Inserts all of the elements in the specified collection into this list, starting at the specified position.
   *
   * @param index
   * @param c
   * @return
   */
  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    if (index < 0||index>size-1) {
      return false;
    }
    int newSize = index + c.size();
    this.size = (newSize) > size ? newSize : size;
    if (this.size() > data.length) {
      checkSize(this.size - data.length);
    }
    //relace or add data
    Object[] cData = c.toArray();
    for (int i = 0; i < c.size(); i++) {
      data[i + index] = cData[i];
    }
    return true;
  }

  /**
   * @param c
   * @return
   */
  @Override
  public boolean removeAll(Collection<?> c) {
    for (Object o : c) {
      remove(o);
    }
    return true;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    //get all element need to retain
    for (int i = 0; i < size; i++) {
      if (!c.contains(data[i])) {
        data[i] = null;
        size--;
      }
    }
    occupyNull();
    return false;
  }

  @Override
  public void replaceAll(UnaryOperator<T> operator) {
    //Do not to implements temporarily
  }

  @Override
  public void sort(Comparator<? super T> c) {
    Arrays.sort((T[]) data, c);
  }

  @Override
  public void clear() {
    this.data = new Object[initialCapacity];
    this.size = 0;
  }

  private void rangeCheck(int index) {
    if (index > size || index < 0) {
      throw new RuntimeException("index error");
    }
  }

  @Override
  public T get(int index) {
    rangeCheck(index);
    return (T) data[index];
  }

  @Override
  public T set(int index, T element) {
    rangeCheck(index);
    data[index] = element;
    return element;
  }

  @Override
  public void add(int index, T element) {
    rangeCheck(index);
    data[index] = element;
  }

  @Override
  public T remove(int index) {
    rangeCheck(index);
    T t = (T) data[index];
    for (int i = index; i < size; i++) {
      data[i] = data[i + 1];
    }
    return t;
  }

  @Override
  public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    for (int i = size-1; i >= 0; i--) {
      if (data[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public ListIterator<T> listIterator() {
    //Do not to implements temporarily
    return null;
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    //Do not to implements temporarily
    return null;
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    rangeCheck(fromIndex);
    rangeCheck(toIndex);
    if (toIndex < fromIndex) {
      throw new RuntimeException("index range error");
    }
    List<T> subList = new MiniArrayList<T>(toIndex - fromIndex);
    for (int i = fromIndex; i < toIndex; i++) {
      subList.add((T) data[i]);
    }
    return subList;
  }

  /**
   * Creates a late-binding and fail-fast Spliterator over the elements in this list.
   *
   * @return
   */
  @Override
  public Spliterator<T> spliterator() {
    //Do not to implements temporarily
    return null;
  }

  @Override
  public String toString() {
    if (this.size < 1) {
      return "[]";
    }
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for (int i = 0; i < this.size; i++) {
      stringBuilder.append(data[i].toString());
      if (i != this.size - 1) {
        stringBuilder.append(',').append(' ');
      }
    }
    return stringBuilder.append("]").toString();
  }
}
