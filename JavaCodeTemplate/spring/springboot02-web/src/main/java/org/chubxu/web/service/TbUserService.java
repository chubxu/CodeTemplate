package org.chubxu.web.service;

import org.chubxu.web.dto.TbUserListsRequest;
import org.chubxu.web.listener.entity.TbUser;

import java.util.List;

/**
 * @ClassName TbUserService
 * @Description TbUserService 接口
 * @Author MrXu
 * @Date 2021/1/9 18:04
 * @Version 1.0
 **/
public interface TbUserService {
    List<TbUser> tbUserLists(TbUserListsRequest tbUserListsRequest);
}
