package com.bf.slow.web;

import com.bf.slow.api.SlowApi;
import com.bf.slow.common.Messenger;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * xx
 *
 * @author kongshuaishuai
 * Created on 2019/5/20 12:48
 * Email is kongshuaishuai@mrfresh.com
 * Copyright is 北京滴哩网络科技有限公司
 */
@Slf4j
@RestController
@RequestMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
public class SlowController {

    @Reference(url = "dubbo://127.0.0.1:20880")
    SlowApi slowApi;

    @PostMapping("/add")
    boolean add(){
        Messenger messenger = new Messenger();
        Map<String, Object> map = new HashMap<>();
        map.put("title", "SpringApplication");
        map.put("synopsis", "LoggerFactory");
        map.put("beginTime", new Date());
        map.put("endTime", new Date());
        map.put("code", "123456");
        map.put("creater", "creater");
        map.put("createTime", new Date());
        map.put("updater", "updater");
        map.put("updateTime", new Date());
        messenger.setMessenger(map);
        boolean add = slowApi.add(messenger);
        log.info("slow-add结果:{}", add);
        return add;
    }

    @DeleteMapping("delete")
    boolean delete(){
        return false;
    }

    @PutMapping("update")
    boolean update(){
        return false;
    }

    @GetMapping("get")
    Messenger get(){
        Messenger messenger = new Messenger();
        messenger.setInfo("id", "ed6d71bb-3870-46d8-9890-cc0d471b6770");
        messenger = slowApi.get(messenger);
        return messenger;
    }

    @GetMapping("page")
    Messenger page(){
        return null;
    }

    @GetMapping("list")
    Messenger list(){
        Messenger messenger = new Messenger();
        messenger = slowApi.list(messenger);
        return messenger;
    }

}
