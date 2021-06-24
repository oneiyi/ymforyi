package com.hui.foryou.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.hui.foryou.entity.Push;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author HUI
 */
@Component
@Slf4j
public class PushUtil {

    public void sendMessageWhenNewHospital(String name, String workTime) {
        ArrayList<Integer> topIds = new ArrayList<>();
        topIds.add(2282);
        String summary = String.format("新医院来了，%n 医院名称：%s %n 上班时间：%s %n 当前时间：%s",
                name, workTime, DateUtil.now());
        Push push = Push.builder()
                .appToken("AT_96FxMqeqQVNrtEXfXwqoJ2iRNQuj2LfL")
                .content("发现一个新医院！")
                .summary(summary)
                .contentType(1)
                .topicIds(topIds).build();
        log.info("发现有新消息推送---------> {}", push);
        HttpUtil.createPost("http://wxpusher.zjiecode.com/api/send/message")
                .body(JSONUtil.toJsonStr(push))
                .execute()
                .body();
    }

    public void sendMessageWhenNoAllowed(String name, String workTime, String total) {
        ArrayList<Integer> topIds = new ArrayList<>();
        topIds.add(2282);
        String summary = String.format("可以预约了！ %n 医院名称：%s %n 上班时间：%s %n 共放出：%s 苗"
                , name, workTime, total);
        Push push = Push.builder()
                .appToken("AT_96FxMqeqQVNrtEXfXwqoJ2iRNQuj2LfL")
                .content("发现一个新医院！")
                .summary(summary)
                .contentType(1)
                .topicIds(topIds).build();
        log.info("发现有新消息推送---------> {}", push);
        HttpUtil.createPost("http://wxpusher.zjiecode.com/api/send/message")
                .body(JSONUtil.toJsonStr(push))
                .execute()
                .body();
    }

    public void sendMessageWhenRedMiCanBy() {
        ArrayList<Integer> topIds = new ArrayList<>();
        topIds.add(2282);
        Push push = Push.builder()
                .appToken("AT_96FxMqeqQVNrtEXfXwqoJ2iRNQuj2LfL")
                .content("RedmiBook上新提醒！！！")
                .summary("RedmiBook上新了，快去看看")
                .contentType(1)
                .topicIds(topIds).build();
        log.info("发现有新消息推送---------> {}", push);
        HttpUtil.createPost("http://wxpusher.zjiecode.com/api/send/message")
                .body(JSONUtil.toJsonStr(push))
                .execute()
                .body();
    }
}
