package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.MessageService;
import com.lanou.bean.Message;
import com.lanou.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yg on 17/8/22.
 */
@Service
public class MessageServiceImpl implements MessageService {



    @Resource
    private MessageMapper mapper;


    public List<Message> showAllMessage() {
        List<Message> massageList = mapper.showAllMessage();

        return massageList;
    }

    public PageInfo<Message> queryPage(Integer pageNum, Integer size) {
        pageNum = pageNum == null ? 1 : pageNum;
        size = size == null ? 5 : size;
        PageHelper.startPage(pageNum, size);
        List<Message> messageList = mapper.showAllMessage();
        //使用pageinfo 对查询结果进行包装
        PageInfo<Message> pageInfo = new PageInfo<Message>(messageList);
        return pageInfo;
    }
}
