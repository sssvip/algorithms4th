# MergeSort

> MergeSort Class extends Sortable

the important thinking about merge sort that divide and merge. 

```html
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
```

