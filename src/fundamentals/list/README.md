# MiniArrayList Change Log

> This just a Implement process about List interface, I want to record the whole process of Implement the list. 

> 仅仅是想完整记录List整个实现过程,从中去发现问题，学习JDK中ArrayLists,如果对你有帮助那就更好了。

### 0. Clone the repository


```html
git clone https://github.com/sssvip/algorithms4th.git
```
This command will clone the newest code form the repository. 

Then you can do next step.

### 1. Implement Simple 简单实现(暴露问题)

```html 
git checkout `MiniArrayList_V0.1`
```

As you can see a MiniArrayList in the list folder, and this class Implement the List interface.
You should know this MiniArrayList version just a simple Implement of the List interface,a few methon not to Implement really,such as
`spliterator()`,`listIterator()`etc. 

Another important point you should know that this version hadn't test,I want to test and compare with ArrayList(in JDK) at next step.

此次实现的MiniArrayList仅仅是一个简单的版本，如spliterator(),listIterator()等方法未真正实现，因为我想很多在初期实现先不必考虑太多“高级用法”（对目前的我来说），去除一些学习“噪音”。

这个简单版本仅仅是实现，然后提交记录，仅仅是为了暴露出更多问题，下一步进行测试并且和JDK中ArrayList进行对比，找出自己的不足（处理效率和设计上的优化），为什么这么思考。


### 2. Test and Compare with ArrayList 与ArrayList的对比性测试(发现问题并一步一步解决问题)

**MiniArrayListCompareTest.java**show this step all code.this step just to test and compare with ArrayList,need to keep uniform on the function 
,not to consider the performance.

In order to review the situation,this test not to fix the MiniArrayList function or performance error(or bad code),so this step
just find the difference on the function. In order to simplify test case just use String to test.

**MiniArrayListCompareTest.java**存储了次阶段测试代码,这个步骤仅仅考虑与ArrayList的对比测试，该修正的修正，首要保证的是找出在功能上的差异，找出对Api的理解错误导致实现错误的地方，最后达到方法正确性的修正，性能是下一步要纳入考虑范围的事情。

为了方便问题的重现，所以这一步仅仅测试找出差异，找出自己疑问的地方，下一版本针对疑问和在方法的功能性上做出修复，并再次测试。

还值得说一句的是虽用泛型实现，但这里为简化测试同意用String类型做测试。


in practice,I found can't find all issue then fix it, it must to step by step. so I plan to test at the same time fix it.

实践证明，不能等发现所有问题后再进行修复解决，这是一个循序渐进的过程(因为后面很多方法也会依赖前面测试的方法，如果不进行修复，明显就是后面依赖的方法全部会错误，下面的size问题你会看到)，所以我决定一边发现一边修复，不过我会版本控制，希望它可以尽可能好的重现。

### 3. addTest
reference API: 

- MiniArrayList()  --constitution method
- add(T t) --add data
- toArray()  --output data as array
- toString() --output data as String

#### a. addTest() 添加方法对比小测
```html
@Test
public void addTest() {
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 5;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("test" + i);
    }
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("test" + i);
    }
    //test print size
    System.out.println(miniArrayList.size());//stackoverflow before fix #1
    System.out.println(arrayList.size());//5
    
    //test print out direct
    System.out.println(miniArrayList);//fundamentals.list.MiniArrayList@1376c05c  see issue #2
    System.out.println(arrayList);//[test0, test1, test2, test3, test4]
    
    //test print out by array
    System.out.println(Arrays.toString(miniArrayList.toArray()));//[test0, test1, test2, test3, test4, null, null, null, null, null] see issue #3
    System.out.println(Arrays.toString(arrayList.toArray()));//[test0, test1, test2, test3, test4]
}
```

#### b. fix addTest() reference issue 修复addTest方法中涉及的问题 
**issue list:**
 - issue #1: MiniArrayList size() stackoverflow
 - issue #2: MiniArrayList print out direct just the memery address not the data
 - issue #3: MiniArrayList print out by array will output the null value

**issue detail:**
- issue #1 detail: MiniArrayList's size method incorrect recursion lead to stackoverflow error.
- issue #2 detail: System.out.println(MiniArrayList's instance) will output the memory address not similar to ArrayList just output the data.
- issue #3 detail: System.out.println(Arrays.toString(miniArrayList.toArray())) will output the null value but ArrayList not.

more issue detail see: [https://github.com/sssvip/algorithms4th/issues](https://github.com/sssvip/algorithms4th/issues)

**how to solve the issues:?**
 
- issue #1: **solve incorrect recursion**
  ```html
  public int size() {
      return this.size(); --> return this.size; 
    }
  ```
- issue #2: **thinking and solving process**
    1. I guess it must to override the toString method.
    2. I find the ArrayList class's toString to see its toString()
        > but ArrayList don't have any toString shadow... Then I guess it must extend from his super class.I see toString in his super 
         class AbstractList,AbstractCollection etc. I found the method in the AbstractCollection class.
         
        AbstractCollection class's toString() code as follow:
        ```html
        public String toString() {
            Iterator<E> it = iterator();
            if (! it.hasNext())
                return "[]";
    
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (;;) {
                E e = it.next();
                sb.append(e == this ? "(this Collection)" : e);
                if (! it.hasNext())
                    return sb.append(']').toString();
                sb.append(',').append(' ');
            }
         }
        ```
    3. Analyze this situation I add toString method in MiniArrayList,code as follow:
       ```html
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
       ```

- issue #3: **thinking and solving process**
    1. Now MiniArrayList toArray() will return the all of Object[],it include null space
    2. I must to see ArrayList class's toArray(),I guess it must handled the data array.
    3. After see ArrayList class's toArray(),That's a surprise,oh my god,I didn't think I should copy the value data to user,I just return the Object[].
    4. Let's see the code of ArrayList class's toArray():
        ```html
        public Object[] toArray() {
            return Arrays.copyOf(elementData, size);
        }
        ```
    5. So I update MiniArrayList toArray() as follow:
        ```html
        @Override
        public Object[] toArray() {
           return data; -->Arrays.copyOf(data, size);
        }
        ```
        
#### c. addTest() Run again
    
```html
@Test
public void addTest() {
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 5;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("test" + i);
    }
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("test" + i);
    }
    //test print size
    System.out.println(miniArrayList.size());//5
    System.out.println(arrayList.size());//5
    
    //test print out direct
    System.out.println(miniArrayList);//[test0, test1, test2, test3, test4]
    System.out.println(arrayList);//[test0, test1, test2, test3, test4]
    
    //test print out by array
    System.out.println(Arrays.toString(miniArrayList.toArray()));//[test0, test1, test2, test3, test4]
    System.out.println(Arrays.toString(arrayList.toArray()));//[test0, test1, test2, test3, test4]
}
```

As you can see, in addTest() MiniArrayList's output is consistent with ArrayList.

#### d. Conclusion about addTest()

- forget use System.copyOf() reference API,if it suit you situation, you should use JDK'S API first,not implement again.
  
  reasons as follow:
  
  1. the JDK's API through thousands of people check,error rate lower than your implement.
  2. your implement may be not consider many you didn't consider situation,such as the arguments null.

- about the this.size() issue,this is a mistake,so you know the knowledge may be you will code error.
- Maybe use many times ArrayList,but just know a little knowledge about ArrayList,so should see the source code more and more.



### 4. indexTest
 reference API: 

 - MiniArrayList()  --constitution method
 - indexOf(Object o) --return the index of Object in List,return -1 if not exist
 - lastIndexOf(Object o)  --return the last index of Object in List,return -1 if not exist
 - clear() --clear the data of List
 - isEmpty() --return true if List have data,vice versa 

#### a. indexTest()

first check the code from repository.

```html
git checkout MiniArrayList_indexTest
```

Then in the MiniArrayListCompareTest.java you will find a indexTest method. code as follow:

```html
@Test
public void indexTest() {
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 5;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("indexTest" + i);
    }
    miniArrayList.add("indexTest" + 2);
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("indexTest" + i);
    }
    arrayList.add("indexTest" + 2);
    //test print index direct
    System.out.println(miniArrayList.indexOf("indexTest1"));//1
    System.out.println(arrayList.indexOf("indexTest1"));//1
    
    //test print object last index
    System.out.println(miniArrayList.lastIndexOf("indexTest2"));//NullPointerException 
    System.out.println(arrayList.lastIndexOf("indexTest2"));//5
    
    //test print isEmpty
    System.out.println(miniArrayList.isEmpty());//false
    System.out.println(arrayList.isEmpty());//false
    
    //test clear and print isEmpty again
    miniArrayList.clear();
    arrayList.clear();
    System.out.println(miniArrayList.isEmpty());//true
    System.out.println(arrayList.isEmpty());//true
}
```

run the code you will find a Exception:

the code `miniArrayList.lastIndexOf("indexTest2")` will throw NullPointerException,more detail about this issue see this repository issue #4,so I will Fix it.

#### b. fix indexTest() reference issue
Fortunately,this time just a one issue.

- **issue list:**
MiniArrayList lastIndexOf() NullPointerException

- **issue detail:**
MiniArrayList lastIndexOf() in for cycle had a incorrect usage that control the value of i

- **how to solve the issues:?** 

    Open the lastIndexOf method source code will find the error easy.

    ```html
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size; i > 0; i++) {  //--> for (int i = size-1; i >= 0; i--)
          if (data[i].equals(o)) {
            return i;
          }
        }
        return -1;
    }
    ```
    
    This is clearly mistake to control the value of i. why it will throw NullPointerExcption? Just because first enter for cycle,

    data[size] just a null value,it should be data[size-1].As we know,null value to invoke equals method will throw NullPointerException.

    So fix it via `for (int i = size-1; i >= 0; i--)`

#### c. indexTest() Run again

checkout the fix code use follow command:
```html
check out MiniArrayList_indexTest_fixed
```

run indexTest method in MiniArrayListCompareTest again,you will find the output will consistent with ArrayList's. 

```html
@Test
public void indexTest() {
    MiniArrayList<String> miniArrayList = new MiniArrayList<String>();
    int dataSize = 5;
    for (int i = 0; i < dataSize; i++) {
      miniArrayList.add("indexTest" + i);
    }
    miniArrayList.add("indexTest" + 2);
    ArrayList<String> arrayList = new ArrayList<String>();
    for (int i = 0; i < dataSize; i++) {
      arrayList.add("indexTest" + i);
    }
    arrayList.add("indexTest" + 2);
    //test print index direct
    System.out.println(miniArrayList.indexOf("indexTest1"));//1
    System.out.println(arrayList.indexOf("indexTest1"));//1

    //test print object last index
    System.out.println(miniArrayList.lastIndexOf("indexTest2"));//5
    System.out.println(arrayList.lastIndexOf("indexTest2"));//5

    //test print isEmpty
    System.out.println(miniArrayList.isEmpty());//false
    System.out.println(arrayList.isEmpty());//false

    //test clear and print isEmpty again
    miniArrayList.clear();
    arrayList.clear();
    System.out.println(miniArrayList.isEmpty());//true
    System.out.println(arrayList.isEmpty());//true

}
```


#### d. Conclusion about indexTest()
Although just a little mistake about to control the value of i in the for cycle,but it can show the careless when code.
More careful,more careful.


### 5. The end about MiniArrayList
more test see the MiniArrayListCompareTest.java. I use the method above to research the API of List,include improve impression and code ability.

fixed issues include #5, #6, #7. 

To be honest,This MiniArrayList has many issue,and many not implement method,such as return null value.To complete the MiniArrayList have a simple way that use the method like `addTest` and `indexTest` process.

Just use many time to see ArrayList source code and compare with it. And you fix it.

This time to implement the MiniArrayList can find many issue about mine.I hope their level is getting better and better
about thinking and coding.
