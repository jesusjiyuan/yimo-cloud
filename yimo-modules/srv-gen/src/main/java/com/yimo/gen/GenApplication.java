package com.yimo.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.yimo.common.security.annotation.EnableCustomConfig;
import com.yimo.common.security.annotation.EnableRyFeignClients;
import com.yimo.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 * 
 * @author yimo
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringBootApplication
public class GenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(GenApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  代码生成模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
