package com.dong.beta.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationRunnerTest implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("======ApplicationRunnerTest 执行");
    }
}
