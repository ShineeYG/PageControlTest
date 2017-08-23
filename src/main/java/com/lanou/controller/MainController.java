package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.MessageService;
import com.lanou.bean.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yg on 17/8/22.
 */
@Controller
public class MainController {

    @Resource
    private MessageService messageService;


    @RequestMapping("/")
    public String page() {
        return "index";
    }


    @RequestMapping(value = "/showAllMessage")
    @ResponseBody
    public List<Message> showAllMessage() {
        System.out.println("走到这了");
        List<Message> massageList = messageService.showAllMessage();
        System.out.println(massageList);
        return massageList;
    }



    @RequestMapping("/pageTest")
    @ResponseBody
    public PageInfo<Message> pageInfo(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("size") Integer size) {
        System.out.println(pageNum+"+"+size);
        return messageService.queryPage(pageNum,size);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String newAdd() {
        return "bbb";
    }


public void test(){
    System.out.println("11111");
}

///
    //12

}
