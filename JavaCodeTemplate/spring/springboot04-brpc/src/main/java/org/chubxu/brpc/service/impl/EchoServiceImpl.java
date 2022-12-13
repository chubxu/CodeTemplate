package org.chubxu.brpc.service.impl;

import com.baidu.cloud.starlight.springcloud.server.annotation.RpcService;
import org.chubxu.brpc.domain.EchoRequest;
import org.chubxu.brpc.domain.EchoResponse;
import org.chubxu.brpc.service.EchoService;

/**
 * @ClassName EchoServiceImpl
 * @Description TODO
 * @Since 1.0.0
 * @Date 2022/12/12 22:24
 * @Author chubxu
 */
@RpcService
public class EchoServiceImpl implements EchoService {
    @Override
    public EchoResponse echo(EchoRequest request) {
        System.out.println(request.getMessage());
        return new EchoResponse("Success");
    }
}
