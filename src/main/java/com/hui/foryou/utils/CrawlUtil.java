package com.hui.foryou.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.hui.foryou.entity.Hospital;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HUI
 */
@Component
@Slf4j
public class CrawlUtil {

    public final String LIST_URL = "https://wx.scmttec.com/base/department/getDepartments.do";

    public final String USER_AGENT = "Mozilla/5.0 (Linux; Android 7.0; Mi-4c Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043632 Safari/537.36 MicroMessenger/6.6.1.1220(0x26060135) NetType/WIFI Language/zh_CN MicroMessenger/6.6.1.1220(0x26060135) NetType/WIFI Language/zh_CN miniProgram";

    public List<Hospital> getPageList(Integer startIndex, Integer page) {
        Map<String, Object> params = new HashMap<>();
        params.put("offset", startIndex);
        params.put("limit", 20);
        params.put("name", "");
        params.put("regionCode", 5101);
        params.put("isOpen", 1);
        params.put("longitude", "104.147412");
        params.put("latitude", "30.635066");
        params.put("sortType", 1);
        params.put("vaccineCode", "");
        params.put("customId", 3);
        String result = HttpUtil.createPost(LIST_URL)
                .header("user-agent", USER_AGENT).form(params)
                .execute().body();
        JSONObject jsonObject = JSONUtil.parseObj(result);
        log.info("第 {} 页数据已返回-----> 状态码： {}", page, jsonObject.get("code"));
        log.info("第 {} 页数据已返回-----> 详情： {}", page, jsonObject);
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("rows");
        return JSONUtil.toList(jsonArray, Hospital.class);
    }


    public List<Hospital> getList() {
        List<Hospital> hospitals = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            log.info("开始获取第 {} 页数据...", i + 1);
            hospitals.addAll(getPageList(i * 10, i + 1));
        }
        return hospitals;
    }
}
