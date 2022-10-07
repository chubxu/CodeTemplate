package org.chubxu.web.controller;

import org.chubxu.web.dto.TbUserListsRequest;
import org.chubxu.web.listener.entity.TbUser;
import org.chubxu.web.service.TbUserService;
import org.mrxu.utils.PageQueryResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TbUserController
 * @Description TbUser 接口
 * @Author chubxu
 * @Date 2021/1/9 18:03
 * @Version 1.0
 **/
@RestController
@RequestMapping("/tbuser")
public class TbUserController {

    @Resource
    private TbUserService tbUserService;

    @RequestMapping("/lists")
    public PageQueryResult<List<TbUser>> tbUserLists(TbUserListsRequest tbUserListsRequest) {
        List<TbUser> list = tbUserService.tbUserLists(tbUserListsRequest);
        return new PageQueryResult<List<TbUser>>().ok().setData(list);
    }
}
