package com.boot.schedules;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestSchedule {

    @Scheduled(fixedDelay = 10000L)
    public void testOne() {
        System.out.println("10秒执行一次!!!!");
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void testTwo() {
        System.out.println("1分钟执行一次");
    }

}
