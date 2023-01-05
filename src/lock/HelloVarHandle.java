package lock;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * @Author think
 * @Date 2021/8/7 9:54
 * @Version 1.0
 */

/**
 * VarHandle 能进行一些原子操作 可以直接操作二进制
 */
public class HelloVarHandle {
    int x = 8;
    private static VarHandle handle;

    static {
        try {
            handle = MethodHandles.lookup().findVarHandle(HelloVarHandle.class, "x", int.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //原子操作  int x= 赋值是原子操作，long 型赋值不是原子操作
        HelloVarHandle h = new HelloVarHandle();
        System.out.println((int) handle.get(h));
        handle.set(h, 9);  //原子操作
        System.out.println(h.x);
        //原子操作
        handle.compareAndSet(h, 9, 10);
        System.out.println(h.x);
        handle.getAndAdd(h, 10);
        System.out.println(h.x);
    }

}
