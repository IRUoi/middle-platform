package com.briup.user.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Log {
    private Long logId;

    private String logUsername;

    private String logRealname;

    private String logRequestMethod;

    private String logRequestUri;

    private Date logTime;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getLogUsername() {
        return logUsername;
    }

    public void setLogUsername(String logUsername) {
        this.logUsername = logUsername;
    }

    public String getLogRealname() {
        return logRealname;
    }

    public void setLogRealname(String logRealname) {
        this.logRealname = logRealname;
    }

    public String getLogRequestMethod() {
        return logRequestMethod;
    }

    public void setLogRequestMethod(String logRequestMethod) {
        this.logRequestMethod = logRequestMethod;
    }

    public String getLogRequestUri() {
        return logRequestUri;
    }

    public void setLogRequestUri(String logRequestUri) {
        this.logRequestUri = logRequestUri;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}