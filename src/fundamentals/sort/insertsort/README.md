# InsertSort


> InsertSort Class extends Sortable

You can run main method to test.

```html
/**
* The entry point of application.
*
* @param args the input arguments
*/
public static void main(String[] args) {
    InsertSort insertSort = new InsertSort();
    //sort from 0 to integers.length
    Integer[] integers = new Integer[] {1, 2, 4, 1, 3, 1, 4, 4, 6, 7, 4, 4, 33, 1};
    insertSort.show(integers);//1 2 4 1 3 1 4 4 6 7 4 4 33 1
    insertSort.sort(integers);
    insertSort.show(integers);//1 1 1 1 2 3 4 4 4 4 4 6 7 33
    //sort from 3 to 5
    Double[] doubles = new Double[] {12.2, 212.2, 21.2, 53.1, 777.1, 1232.1, 444.14, 456.6};
    insertSort.show(doubles);//12.2 212.2 21.2 53.1 777.1 1232.1 444.14 456.6
    insertSort.sort(doubles, 3, 5);
    insertSort.show(doubles);//12.2 212.2 21.2 53.1 444.14 456.6 777.1 1232.1
}
```

More details:[InsertSort.java](InsertSort.java)