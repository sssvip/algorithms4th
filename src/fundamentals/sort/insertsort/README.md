# InsertSort


> InsertSort Class extends Sortable

You can run main methon to test.

```html
/**
* The entry point of application.
*
* @param args the input arguments
*/
public static void main(String[] args) {
    InsertSort insertSort = new InsertSort();
    //sort from 0 to integers.length
    Integer[] integers = new Integer[] {1, 2, 4, 1, 43, 21, 4, 5, 3};
    insertSort.show(integers);//1 2 4 1 43 21 4 5 3
    insertSort.sort(integers);
    insertSort.show(integers);//1 1 2 3 4 4 5 21 43
    
    //sort from 3 to 5
    Double[] doubles = new Double[] {1.2, 2.1, 4.4, 33.2, 44.1, 41.3, 12.1, 434.2};
    insertSort.show(doubles);//1.2 2.1 4.4 33.2 44.1 41.3 12.1 434.2
    insertSort.sort(doubles, 3, 5);
    insertSort.show(doubles);//1.2 2.1 4.4 12.1 33.2 41.3 44.1 434.2
}
```

