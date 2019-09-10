package com.bf.slow;

import com.bf.slow.api.SlowApi;
import com.bf.slow.api.UserInfoApi;
import com.bf.slow.param.QueryUserParam;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.UUID;

@EnableSwagger2
@SpringBootApplication
public class BfSlowApplication {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(url = "dubbo://127.0.0.1:20880")
    UserInfoApi userInfoApi;

    @Reference(url = "dubbo://127.0.0.1:20880")
    SlowApi slowApi;

    public static void main(String[] args) {
        SpringApplication.run(BfSlowApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(){
        Slow slow = new Slow();
        slow.setId(UUID.randomUUID().toString());
        slow.setCode(1234);
        slow.setSynopsis("LoggerFactory");
        slow.setTitle("SpringApplication");
        slow.setStatus(1);
        slow.setFounder("create");
        slow.setBeginTime(new Date());
        slow.setEndTime(new Date());
        slow.setCreateTime(new Date());
        slow.setUpdateTime(new Date());
        return args -> logger.info("S: "+ slowApi.add(slow));

        /*return args -> logger.info("S: "+ userInfoApi.getUser(new QueryUserParam()));*/
    }

}
