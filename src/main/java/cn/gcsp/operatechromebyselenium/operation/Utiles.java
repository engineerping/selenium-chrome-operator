package cn.gcsp.operatechromebyselenium.operation;

import java.util.function.Supplier;

public class Utiles {
    public static boolean retry(int times, long intervalMilliSec, DoSomething doSomething) throws InterruptedException {
        boolean isRetry = false;
        int retriedTimes = 0;
        while(isRetry && retriedTimes < times) {
            try {

            } catch (Exception e) {
                isRetry = true;
                retriedTimes++;
                Thread.sleep(intervalMilliSec);
            }
        }
        return !isRetry;
    }
}
