package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author think
 * @Date 2021/8/7 15:08
 * @Version 1.0
 */
public class TestAQS {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
