package org.chubxu.others.jdk.spi.impl;

import org.chubxu.others.jdk.spi.JdkSpiTestInterface;

/**
 * @ClassName JdkSpiTest01
 * @Description TODO
 * @Since 1.0.0
 * @Date 2022/11/25 22:14
 * @Author chubxu
 */
public class JdkSpiTest01 implements JdkSpiTestInterface {
    @Override
    public void test() {
        System.out.println("test01");
    }
}
