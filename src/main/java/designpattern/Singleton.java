package designpattern;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午5:15 2018/10/13
 * @ Description：单例模式
 * @ Modified By：
 * @Version: $
 */
/**
 * 单例模式是保证一个类仅有一个实例，并提供一个访问他的全局访问点
 * 1 需要定义一个静态成员变量
 * 2 构造函数必是为私有
 * 3 访问点函数需要返回这个静态成员变量，故也必是一个静态方法
 */
/*
 * 单线程下的访问
 * 懒汉模式：调用引用时才会初始化
 * 饿汉模式：类初始化时便会调用构造函数初始化
 */
// 1 懒汉模式
class Singleton1 {
        private static Singleton1 singleton;
        private Singleton1() {
            System.out.println("初始化");
        }
        public Singleton1 getInstance() {
            if(singleton == null) {
                singleton = new Singleton1();
            }
            return singleton;
        }
}
// 2 饿汉模式
class Singleton2 {
    private static  Singleton2 singleton2 = new Singleton2();
    private Singleton2() {
        System.out.println("构造函数");
    }
    public Singleton2 getInstance() {
        return singleton2;
    }
}
/**
 * 3 多线程下单例模式
 * 多线程下使用上面的懒汉方式依然有可能返回多个对象，有多个线程
 * 因此在创建对象的时候添加线程锁
 * 创建一个object作为lock
 *  双重锁定的机制
 */
class Singleton3{
    private static Singleton3 singleton3;
    private static Object lock = new Object();//lock作为线程锁
    private Singleton3() {
        System.out.println("构造函数");
    }
    public Singleton3 getInstance() {
        if(singleton3 == null) {
            //如果为null，需要创建对象，加锁
            synchronized(lock) {
               if(singleton3 == null) {
                   //创建锁之后还需要在判断一下
                   //可能有线程在等待锁，即便线程创建了，当这个锁被当前线程获取之后，不判断依然会创建
                   //双重锁定
                   singleton3 = new Singleton3();
               }
            }
        }
        return singleton3;
    }
}
