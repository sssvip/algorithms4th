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

- **int rank(Key key)**:

This method to find the key's rank in the tree.

similar to select method that the most important thinking is the code `1 + size(node.left) + rank(node.right, key);`, you should know the node's size is node's left subnode and right subnode's size sum. But node's right subnode is greater than current node, you need deal carefully.

- **void delete(Key key)**:

Delete method is the most important method in the `Binary Search Tree`. When you delete a node, you must deal the subnode carefully. 
And whatever how to deal the node, the key point is that you must keep the order of the tree.
Generally, you will meet the few kinds situations as follow:
1. current node don't has any subnode
the most simple situation,just set its parent node relational pointer it to null and update relational node's size.
2. current node has left subnode or right subnode only
set current node's parent node relational pointer to current node's left subnode or right subnode, then current node set to null and update relational node's size.
3. current node has left subnode and right subnode
the key thinking is that set current node's right subtree's min node to current node and delete the min node, meanwhile remain the current node's left node and update relational node's size.

- **Node  deleteMin()**:

This method to delete min node. The key point is to find left subnode until it is null and delete it,meanwhile you need to set the node(left subnode is null) right subnode to the node's parent node's relational pointer.

- **Node  deleteMax()**:

This method similar to `deleteMin` that to delete max node.

- **Iterator<Node> keys()**:

This method is to change the data to a iterator type data. In order to reduce process, I use `toArrayList().iterator()` in this method.

More details:[BinarySearchTree.java](BinarySearchTree.java)

