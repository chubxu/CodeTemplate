package org.chubxu.brpc.service;

import org.chubxu.brpc.domain.EchoRequest;
import org.chubxu.brpc.domain.EchoResponse;

/**
 * @ClassName EchoService
 * @Description TODO
 * @Since 1.0.0
 * @Date 2022/12/12 22:22
 * @Author chubxu
 */
public interface EchoService {
    EchoResponse echo(EchoRequest request);
}
