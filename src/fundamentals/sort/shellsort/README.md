# ShellSort


> ShellSort Class extends Sortable

the important thinking about shell sort is that divide the array and use insert sort again and again

You can run main method to test.

```html
/**
* The entry point of application.
*
* @param args the input arguments
*/
public static void main(String[] args) {
    ShellSort shellSort = new ShellSort();
    Integer[] integers = new Integer[] {1, 2, 1, 45, 32, 52, 12, 11, 22, 322, 4, 5, 1, 3, 3, 3, 2, 2};
    shellSort.show(integers);//1 2 1 45 32 52 12 11 22 322 4 5 1 3 3 3 2 2
    shellSort.sort(integers);
    shellSort.show(integers);//1 1 1 2 2 2 3 3 3 4 5 11 12 22 32 45 52 322
}
```

More details:[ShellSort.java](ShellSort.java)
