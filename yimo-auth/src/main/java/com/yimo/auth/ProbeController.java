package com.yimo.auth;

import com.yimo.common.core.domain.R;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @descrition ProbeController
 * @author: jiyuan
 * @date: 2022-11-16
 * @since 0.0.1
 */
@RestController
@AllArgsConstructor
public class ProbeController {
    private final Environment env;

    @GetMapping("/system/version")
    public Object version() {
        return R.ok(new HashMap<String,String>(){{
            put("app",env.getProperty("spring.application.name"));
            put("version","0.0.1");
        }});
    }
}
