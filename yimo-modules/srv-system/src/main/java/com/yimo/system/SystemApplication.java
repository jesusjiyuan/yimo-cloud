package com.yimo.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.yimo.common.security.annotation.EnableCustomConfig;
import com.yimo.common.feign.annotation.EnableRyFeignClients;
import com.yimo.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 * 
 * @author yimo
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class SystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" );
    }
}
