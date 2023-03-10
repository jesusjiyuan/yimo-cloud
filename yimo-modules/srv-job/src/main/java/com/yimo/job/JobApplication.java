package com.yimo.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.yimo.common.security.annotation.EnableCustomConfig;
import com.yimo.common.feign.annotation.EnableRyFeignClients;
import com.yimo.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 * 
 * @author yimo
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringBootApplication
public class JobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(JobApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  定时任务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
