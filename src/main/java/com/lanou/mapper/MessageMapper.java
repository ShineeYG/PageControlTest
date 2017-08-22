package com.lanou.mapper;

import com.lanou.bean.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yg on 17/8/22.
 */
@Repository
public interface MessageMapper {



    List<Message> showAllMessage();

}
