package org.chubxu.others.jdk.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName MainTest
 * @Description TODO
 * @Since 1.0.0
 * @Date 2022/11/25 22:16
 * @Author chubxu
 */
public class MainTest {
    public static void main(String[] args) {
        ServiceLoader<JdkSpiTestInterface> jdkSpiImpl = ServiceLoader.load(JdkSpiTestInterface.class);
        for (JdkSpiTestInterface jdkSpi : jdkSpiImpl) {
            jdkSpi.test();
        }
    }
}
