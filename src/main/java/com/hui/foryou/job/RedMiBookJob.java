package com.hui.foryou.job;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.hui.foryou.utils.PushUtil;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@Slf4j
public class RedMiBookJob extends IJobHandler {

    @Resource
    PushUtil pushUtil;

    @XxlJob(value = "redmiTask")
    @Override
    public void execute() throws Exception {
        log.info("执行获取最新货源开始............");
        String currentTime = String.valueOf(System.currentTimeMillis()).substring(0, 10);
        String getUrl = "https://api2.order.mi.com/product/delivery?goods_ids=2212000071&item_ids=&province_id=24&city_id=272&district_id=2542&area=2542001&t=" + currentTime;
        String result = HttpUtil
                .createGet(getUrl)
                .header("referer", "https://www.mi.com/")
                .execute()
                .body();
        JSONObject jsonObject = JSONUtil.parseObj(result);
        boolean isHave = (boolean) jsonObject.getJSONObject("data").getJSONObject("datas").getJSONObject("2212000071").get("is_local_cos");
        log.info("当前地区货源被锁状态：{}", isHave);
        if (!isHave) {
            log.info("当前商品可以买了。。。。。。。。");
            pushUtil.sendMessageWhenRedMiCanBy();
        }
    }
}
