package com.lanou;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Message;

import java.util.List;

/**
 * Created by yg on 17/8/22.
 */
public interface MessageService {
    List<Message> showAllMessage();


    PageInfo<Message> queryPage(Integer pageNum,Integer size);

}
