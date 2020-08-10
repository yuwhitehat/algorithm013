# 学习笔记
## 哈希表 Hash Table
1. 概念
    1. 也叫散列表，根据关键码值直接进行访问
    2. 通过把关键码值映射到表中一个位置来访问
    3. 映射的函数叫哈希函数
    4. 存放记录的数组叫哈希表
2. 工程
    1. 电话簿
    2. 用户信息表
    3. 缓存LRU
    4. Redis
3. 常用
    1. Map 键值对 键不可重复
    2. Set 不重复的元素的集合
## 树
1. 树这个二维结构出现的本质是人类的各种生活形态可以用树描述
2. 树和图的区别就在于是否有环，即没有环的图就是树
3. 链表是特殊的树
4. 树节点的定义
```java
public class TreeNode {
    public int val;
    public TreeNode left,right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```
## 二叉树
1. 二叉树就是每个节点最多只有两个儿子节点
2. 二叉树在遍历的时候一般都用递归
3. 二叉树遍历的方法有三种
```text
前序遍历 根-左-右
中序遍历 左-根-右
后序遍历 左-右-根
```
## 二叉搜索树 BST
1. 性质
    1. 左子树所有节点的值均小于其根节点的值，右子树所有节点的值均大于其根节点的值
    2. 左右子树也都是二叉搜索树
    3. 结论 BST的中序遍历是升序遍历
2. 常见操作
    1. 查询 log(n)
    2. 插入节点 log(n)
    3. 删除 log(n) 
3. 特殊情况
当树只剩下左子树或右子树的时候，树其实就变成了链表，复杂度就变成了链表的复杂度

## 二叉堆
<a name="VSxpP"></a>
### 实现
二叉堆通过数组实现，假设第一个元素在数组中的索引为零的话：

1. 索引为 `i` 的左孩子的索引是 `（2*i+1）` 
1. 索引为 `i` 的右孩子的索引是 `（2*i+2）` 
1. 索引为 `i` 的父节点的索引是 `floor((i-1)/2)` 

将从根节点开始依次从左到右放入每一个节点的值：<br />可以看到满足堆的性质，是一颗完全树（除叶子节点外其他节点都是满的），而且根节点一定大于儿子节点<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1597026275658-9b429d4e-4062-4227-85cb-e50fb82c1a41.png#align=left&display=inline&height=282&margin=%5Bobject%20Object%5D&name=image.png&originHeight=564&originWidth=836&size=103723&status=done&style=none&width=418)
<a name="r9sju"></a>

### `Insert` 的实现细节

1. 新元素一律先插到堆的尾部
1. 依次向上调整整个堆的结构（一直到根即可）

如果要把85插到二叉堆中：<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1597026815300-0f39313e-c10d-4c17-af04-5a0d788ac2e0.png#align=left&display=inline&height=390&margin=%5Bobject%20Object%5D&name=image.png&originHeight=529&originWidth=708&size=106282&status=done&style=none&width=522)<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1597026889013-de359e41-aebd-4e94-bcf7-79dfb579b582.png#align=left&display=inline&height=236&margin=%5Bobject%20Object%5D&name=image.png&originHeight=351&originWidth=767&size=64784&status=done&style=none&width=515)<br />
<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1597027012651-a29aa0b2-012e-4efb-8dcb-feb457672429.png#align=left&display=inline&height=294&margin=%5Bobject%20Object%5D&name=image.png&originHeight=401&originWidth=702&size=74417&status=done&style=none&width=514)
<a name="7488R"></a>
#### 核心代码
```java
    /**
     * Maintains the heap property while inserting an element.
     */
    private void heapifyUp(int i) {
        int insertValue = heap[i];
        while (i > 0 && insertValue > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = insertValue;
    }
```
### `Delete Max` 的实现细节

1. 将堆尾元素替换到顶部
1. 依次从根部向下调整整个堆的结构(一直到堆尾即可)

![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1597027227321-933dd854-76b0-4aa7-b7de-3dcafdea8d5d.png#align=left&display=inline&height=377&margin=%5Bobject%20Object%5D&name=image.png&originHeight=841&originWidth=1666&size=309819&status=done&style=none&width=746)
<a name="C4rq5"></a>
#### 核心代码
```java
    /**
     * Maintains the heap property while deleting an element.
     */
    private void heapifyDown(int i) {
        int child;
        int temp = heap[i];
        while (kthChild(i, 1) < heapSize) {
            child = maxChild(i);
            if (temp >= heap[child]) {
                break;
            }
            heap[i] = heap[child];
            i = child;
        }
        heap[i] = temp;
    }
```
