 # 排列组合问题

 从m个数里面选n个（m >= n）

 全部用到 栈的存储结构 + 递归方法

 1. 用栈存储选取的那N个数，选取就push，换一个就pop再push
 2. 递归方法：要选取n个数，已经选取了k个，k == n时表示一种组合结果完成
 ，选择一个再之后递归(k+1)

 ## Rank1 解决 m <sup>n</sup>问题

 这是最简单的问题，选择n个数，每个数有m个选择
 每次选择时只需要循环这m个数：
    
   1. push()
   2. 递归(k+1)
   3. pop()
   4. 循环m个数，就是把这位上的数m次选择都做了一遍

```
 /**
     * @Author: ChangSiteng
     * @Description: 
     * @param n: 选取n个数
      * @param k: 已经选取了k个数
      * @param numbers: 存放m个选择的数组
      * @param list: 存放所有选择的list
      * @param stack: 存放已经选取的数的栈结构
     * @return: void
     */
    public void rank(int n, int k, int[] numbers, ArrayList list, Stack stack){
        // 已经做完一次结果组合
        if (n == k) {
            list.add(Arrays.toString(stack.toArray()));
            return;
        }

        // 遍历number，做m次选择
        for (int number : numbers) {
            stack.push(number);
            rank(n,k+1,numbers,list,stack);
            stack.pop();
        }

    }

```

 ## Rank2 解决 Am<sup>n</sup>问题

 依旧使用递归和栈数据结构

 和Rank1不同的是：
 选择n个数，每个数的选择不再是单纯的m个选择，而是未被选择过的m-k个数

 因此使用一个used数组标记是否已被访问，1表示已经被使用，0表示未被使用

 ```
/**
     * @Author: ChangSiteng
     * @Description:
     * @param number:
      * @param used:
      * @param n: 需要选择N个数
      * @param k: 已经选择了K个
      * @param list:
      * @param stack:
     * @return: void
     */
    public void rank(int[] number, int[] used, int n, int k, List list, Stack stack) {

        if( n == k) {
            list.add(Arrays.toString(stack.toArray()));
            return;
        }

        for (int i = 0; i < number.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                stack.push(number[i]);
                rank(number,used,n,k+1,list,stack);
                used[i] = 0;
                stack.pop();
            }
        }
    }
 ```

 ## Rank3 解决解决 Cm<sup>n</sup>问题

 同样和Rank1做对比：
 选择n个数，
 1. 如果是mn每个数的选择是单纯的m个选择
 2. 如果是Amn则是从i=0开始遍历，所有未选择过的数作为选择
 3. 如果是Cmn则是从当前选择的i开始遍历，之前的i都不作为选择，也是如此做法遍历的i都是未选择过的，因此也不需要数组

 ```
/**
     * @Author: ChangSiteng
     * @Description:
     * @param number:
      * @param n: 需要选择n个数
      * @param k: 当前选择了K个数
      * @param index: 当前选择的第K个数的下标时(最大下标，初始化为-1)
      * @param list:
      * @param stack:
     * @return: void
     */
    public void rank(int[] number, int n, int k, int index, List list, Stack stack) {

        if ( n == k) {
            list.add(Arrays.toString(stack.toArray()));
            return;
        }

        for (int i = index + 1 ; i < number.length; i++) {
            stack.push(number[i]);
            rank(number,n,k+1,i,list,stack);
            stack.pop();
        }
    }
 ```

