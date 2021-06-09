package com.hui.foryou.job;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hui.foryou.entity.Hospital;
import com.hui.foryou.service.IHospitalService;
import com.hui.foryou.utils.CrawlUtil;
import com.hui.foryou.utils.PushUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Configuration
@Slf4j
public class HospitalTesk {
    @Resource
    CrawlUtil crawlUtil;

    @Resource
    PushUtil pushUtil;

    @Resource
    IHospitalService hospitalService;

    // @Scheduled(cron = "0 0/2 * * * ? ")
    private void test1() {
        log.info("定时任务启动：---------------- 当前时间:{}", DateUtil.now());
        List<Hospital> hospitals = crawlUtil.getList();
        AtomicReference<Integer> count = new AtomicReference<>(0);
        hospitals.forEach(hospital -> {
            Hospital result = hospitalService.getOne(new LambdaQueryWrapper<Hospital>().eq(Hospital::getCode, hospital.getCode()));
            //新医院
            if (result == null) {
                hospitalService.save(hospital);
                log.info("新增医院：医院名：{}，总数：{}", hospital.getName(), hospital.getTotal());
                pushUtil.sendMessageWhenNewHospital(hospital.getName(), hospital.getWorktimeDesc());
                count.getAndSet(count.get() + 1);
                return;
            }

            //查看是否需订阅并且total为正
            if (hospital.getIsNoticedUserAllowed() == 0 && Integer.parseInt(hospital.getTotal()) > 0) {
                log.info("检测到苗：医院名：{}，总数：{} ", hospital.getName(), hospital.getTotal());
                pushUtil.sendMessageWhenNoAllowed(hospital.getName(), hospital.getWorktimeDesc(), hospital.getTotal());
            }
        });
        log.info("共发现 {} 条 新增记录。", count);
        log.info("定时任务结束：---------------- 当前时间:{}", DateUtil.now());
    }
}
