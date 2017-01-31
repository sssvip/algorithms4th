# BinarySearchTree

The binary search tree search and put efficiency depending on the order of data input.


e.g.

data: 100 90 80 50 110

the tree will be this behaviour
```
          100
       90    110
    80
 50
``` 
data2: 90 80 50 100 110

the tree will be this behaviour

```
           90
       80     100
    50            110

```


The tree is not balanced and exist problems of efficiency about search and insert.


#### simple conclusion about BinarySearchTree operation

- **int size()**: 

get node's size via recursive method

- **Value get(Key key)**: 

return the Value if key equal current node's key; if key less than current node's key find continue in the left subtree vice versa. 

- **void put(Key key,Value value)**: 

put from root node,if root node is null then create a new instance of node as root node. if the key greater than current node's key, put it in left subtree vice versa.

- **Key max()**:

find current node's right node until current node's right node is null, now current node's left node is null return current node otherwise return current node's left nod.

- ** Key min()**:

similar to max method but reverse. 

- **Key floor(Key key)**:

this method indicate that return return the key that greater than or equal it, and it must be in the tree

if current node's key equal then return current node's key. if current node's key greater than key find continue in the left subtree. They both are not true,then find in the right subtree.

- **Key ceiling(Key key)**:

similar to floor method but reverse. 

- **Key select(int k)**:

This method to find the k-th node's key.

The most important thinking come from this line code `select(node.right, k - size - 1);`. It can indicate the relationship about `k` with `size` clearly.

To be continued...

More details:[BinarySearchTree.java](BinarySearchTree.java)

