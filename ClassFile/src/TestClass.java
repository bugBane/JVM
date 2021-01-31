/*
    简单的Java代码
 */
public class TestClass {
    public static void main(String[] args) {
        String s = "Hello World";
    }
}
//用Javap命令计算字节码指令 F:\Project\JVM\out\production\JVM>javap -v TestClass.class
/*
Classfile /F:/Project/JVM/out/production/JVM/TestClass.class
  Last modified 2021年1月31日; size 429 bytes
  SHA-256 checksum e369bdd0dfd243b0b4cb9ed0fbfda125e73b47df9a9a0043b93a20c100069727
  Compiled from "TestClass.java"
public class TestClass
  minor version: 0                                                                      次版本
  major version: 59                                                                     主版本
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER                                                 访问标志
  this_class: #9                          // TestClass                                  类信息
  super_class: #2                         // java/lang/Object                           父类信息
  interfaces: 0, fields: 0, methods: 2, attributes: 1                                   接口方法表集合,字段表集合,方法表集合,属性表集合
Constant pool:                                                                          常量池
   #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
   #2 = Class              #4             // java/lang/Object
   #3 = NameAndType        #5:#6          // "<init>":()V
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = String             #8             // Hello World
   #8 = Utf8               Hello World
   #9 = Class              #10            // TestClass
  #10 = Utf8               TestClass
  #11 = Utf8               Code
  #12 = Utf8               LineNumberTable
  #13 = Utf8               LocalVariableTable
  #14 = Utf8               this
  #15 = Utf8               LTestClass;
  #16 = Utf8               main
  #17 = Utf8               ([Ljava/lang/String;)V
  #18 = Utf8               args
  #19 = Utf8               [Ljava/lang/String;
  #20 = Utf8               s
  #21 = Utf8               Ljava/lang/String;
  #22 = Utf8               SourceFile
  #23 = Utf8               TestClass.java
{
  public TestClass();                                                                   简单名称
    descriptor: ()V                                                                     描述符
    flags: (0x0001) ACC_PUBLIC                                                          访问标志
    Code:                                                                               code表(代码在这里边,重中之重)
      stack=1, locals=1, args_size=1                                                        操作数栈,本地变量表(单位:变量槽slot)
         0: aload_0                                                                         将一个局部变量加载到操作栈
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V       用于调用一些需要特殊处理的实例方法，包括实例初始化方法、私有方法和父类方法。
         4: return                                                                          正常调用完成
      LineNumberTable:                                                                      描述Java源码行号与字节码行号(非必需，默认会生成到Class文件之中，可以在Javac中使用-g：none或-g：lines选项来取消或要求生成这项信息)
        line 4: 0
      LocalVariableTable:                                                                   描述栈帧中局部变量表的变量与Java源码中定义的变量之间的关系(非必需，默认会生成到Class文件之中，可以在Javac中使用-g：none或-g：vars选项来取消或要求生成这项信息)
        Start  Length  Slot  Name   Signature                                               局部变量的生命周期开始的字节码偏移量,及其作用范围覆盖的长度,局部变量在栈帧的局部变量表中变量槽的位置,局部变量的名称,局部变量的描述符(记录泛型签名信息)
            0       5     0  this   LTestClass;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=2, args_size=1
         0: ldc           #7                  // String Hello World
         2: astore_1
         3: return
      LineNumberTable:
        line 6: 0
        line 7: 3
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       4     0  args   [Ljava/lang/String;
            3       1     1     s   Ljava/lang/String;
}
SourceFile: "TestClass.java"                                                                记录生成这个Class文件的源码文件名称

实例构造器<init>()方法和类构造器<clinit>()方法就是在这个阶段被添加到语法树之中的。请注意这里的实例构造器并不等同于默认构造函数，如果用户代码中没有提供任何构造函数，那编译器将会添加一个没有参数的、可访问性（public、protected、private或<package>）与当前类型一致的默认构造函数，这个工作在填充符号表阶段中就已经完成。
<init>()和<clinit>()这两个构造器的产生实际上是一种代码收敛的过程，编译器会把语句块（对于实例构造器而言是“{}”块，对于类 构造器而言是“static{}”块）、变量初始化（实例变量和类变量）、调用父类的实例构造器（仅仅是实例构造器，<clinit>()方法中无须调用父类的<clinit>()方法，Java虚拟机会自动保证父类构造器的正确执行，但在<clinit>()方法中经常会生成调用java.lang.Object的<init>()方法的代码）等操作收敛到<init>()和 <clinit>()方法之中，并且保证无论源码中出现的顺序如何，都一定是按先执行父类的实例构造器，然后初始化变量，最后执行语句块的顺序进行，上面所述的动作由Gen::normalizeDefs()方法来实现。
 */
