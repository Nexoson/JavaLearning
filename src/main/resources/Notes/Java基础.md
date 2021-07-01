

# 一、数据类型

> [Java 基础](https://github.com/CyC2018/CS-Notes/blob/master/notes/Java 基础.md#基本类型)

## 基本类型

- byte/8 bit

- char/16

- short/16

- int/32

- float/32

- long/64

- double/64

- boolean/ ~

  > boolean 只有两个值： true、false，可以使用1 bit来存储，但是具体大小没有明确规定。JVM会在编译期将
  >
  > boolean类型数据转换为int，使用 1来表示true， 0表示false。JVM支持boolean数组，但是是通过读写byte
  >
  > 数组来实现的。

## 包装类型

> 基本类型都有对应的包装类型，基本类型与其对应的包装类型之间的赋值使用自动装箱与拆箱完成。
>
> ```java
> Integer x = 2; // 装箱 调用了 Integer.valueif(2)
> int y = x;     // 拆箱 调用了 X.intValue()
> ```
>
> 

## 缓存池

> new Integer(123) 与 Integer.valueOf(123) 的区别在于：
>
> -  new Integer(123)每次都会新建一个对象;
>
> - Integer.valueOf(123) 会使用缓存池中的对象,多次调用会取得同一个对象的引用;
>
>   ```java
>   Integer x = new Integer(123);
>   Integer y = new Integer(123);
>   System.out.println(x == y);  // false
>   Integer z = Integer.valueOf(123);
>   Integer k = Integer.valueOf(123);
>   System.out.println(z == k); // true
>   ```
>
>   valueOf() 方法的实现比较简单, 就是先判断值是否在缓存池中, 如果在的话就直接返回缓存池的内容
>
>   ```java
>   public static Integer valueOf(int i) {
>       if (i >= IntegerCache.low && i <= IntegerCache.high)
>           return IntegerCache.cache[i + (-IntegerCache.low)];
>       return new Integer(i);
>   }
>   ```
>
>   

