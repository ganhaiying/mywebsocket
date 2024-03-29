package com.mywebsocket.controller;

import com.mywebsocket.websocket.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import response.Result;

import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public Result pushToWeb(@PathVariable String cid, String message) {
        try {
            ModelAndView mav=new ModelAndView("/socket");
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail(cid+"#"+e.getMessage());
        }
        return Result.success(cid);
    }
}
