# MiniArrayList Change Log

> I just want to record the whole process of impletement the list. 

> 仅仅是想完整记录这个整个实现过程,如果对你有帮助那就更好了。


1. Impletement Simple 简单实现

```html 
git checkout MiniArrayList_V0.1
```

As you can see a MiniArrayList in the list folder, and this class impletement the List interface.
You should know this MiniArrayList version just a simple impletement of the List interface,a few methon not to impletement really,such as
`spliterator()`,`listIterator()`etc. 

Anthor important point you should know that this version hadn't test,I want to test and compare with ArrayList(in JDK) at next step.

此次实现的MiniArrayList仅仅是一个简单的版本，如spliterator(),listIterator()等方法未真正实现，因为我想很多在初期实现先不必考虑太多“高级用法”（对目前的我来说），去除一些学习“噪音”。

这个简单版本仅仅是实现，然后提交记录，仅仅是为了暴露出更多问题，下一步进行测试并且和JDK中ArrayList进行对比，找出自己的不足（处理效率和设计上的优化），为什么这么思考。
