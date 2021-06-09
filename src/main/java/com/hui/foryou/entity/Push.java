package com.hui.foryou.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Push {


    /**
     * appToken : AT_xxx
     * content : Wxpusher祝你中秋节快乐!
     * summary : 消息摘要
     * contentType : 1
     * topicIds : [123]
     * uids : ["UID_xxxx"]
     * url : http://wxpusher.zjiecode.com
     */

    private String appToken;
    private String content;
    private String summary;
    private int contentType;
    private String url;
    private List<Integer> topicIds;
    private List<String> uids;

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getTopicIds() {
        return topicIds;
    }

    public void setTopicIds(List<Integer> topicIds) {
        this.topicIds = topicIds;
    }

    public List<String> getUids() {
        return uids;
    }

    public void setUids(List<String> uids) {
        this.uids = uids;
    }
}
