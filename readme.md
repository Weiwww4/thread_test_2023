### 笔记

* `AtomicInteger`
* AtomicInteger是JDK1.5提供的一个支持原子操作的Integer类。
  AtomicInteger定义：AtomicInteger类是系统底层保护的int类型，通过对int类型的数据进行封装，提供执行方法的控制进行值的原子操作，
  但AtomicInteger≠Integer。AtomicInteger是一个提供原子操作的Integer类，通过线程安全的方式操作加减。
  从JAVA1.5开始，AtomicInteger属于java.util.concurrent.atomic包下的一个类。
  AtomicInteger使用场景：AtomicInteger提供原子操作来进行Integer的使用，适合高并发情况下的使用。
  在Java语言中，++i和i++操作并不是线程安全的，在使用的时候，不可避免的会用到synchronized关键字，
  而AtomicInteger则通过一种线程安全的加减操作接口。