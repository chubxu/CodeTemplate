package org.chubxu.web.dto;

import lombok.Data;

/**
 * @ClassName TbUserListsRequest
 * @Description TbUser列表请求参数
 * @Author chubxu
 * @Date 2021/1/9 18:05
 * @Version 1.0
 **/
@Data
public class TbUserListsRequest {
    private Integer pageSize;
    private Integer pageNum;
}
