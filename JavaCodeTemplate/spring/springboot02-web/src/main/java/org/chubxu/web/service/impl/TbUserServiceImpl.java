package org.chubxu.web.service.impl;

import com.github.pagehelper.PageHelper;
import org.chubxu.web.dao.TbUserMapper;
import org.chubxu.web.dto.TbUserListsRequest;
import org.chubxu.web.listener.entity.TbUser;
import org.chubxu.web.listener.entity.TbUserExample;
import org.chubxu.web.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TbUserServiceImpl
 * @Description TbUserService 实现类
 * @Author chubxu
 * @Date 2021/1/9 18:06
 * @Version 1.0
 **/
@Service
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> tbUserLists(TbUserListsRequest tbUserListsRequest) {
        PageHelper.startPage(tbUserListsRequest.getPageNum(), tbUserListsRequest.getPageSize());
        TbUserExample tbUserExample = new TbUserExample();
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        return tbUsers;
    }
}
