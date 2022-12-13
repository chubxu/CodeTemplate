package org.chubxu.brpc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName EchoRequest
 * @Description TODO
 * @Since 1.0.0
 * @Date 2022/12/12 22:23
 * @Author chubxu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EchoRequest {
    private String message;
}
