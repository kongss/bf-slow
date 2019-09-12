package com.bf.slow;

import com.bf.slow.api.UserInfoApi;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class BfSlowApplication {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(url = "dubbo://127.0.0.1:20880")
    UserInfoApi userInfoApi;



    public static void main(String[] args) {
        SpringApplication.run(BfSlowApplication.class, args);
    }


}
