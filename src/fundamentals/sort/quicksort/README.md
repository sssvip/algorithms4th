# QuickSort


> QuickSort Class extends Sortable

You can run main method to test.

```html
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
}
```

More details:[QuickSort.java](QuickSort.java)

