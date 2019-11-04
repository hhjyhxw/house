package com.icloud.bms.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

public class BmsLogs{


    // 日志类型（access：接入日志；update：修改日志；select：查询日志；loginLogout：登录登出；）
    public static final String TYPE_ACCESS = "access";
    public static final String TYPE_UPDATE = "update";
    public static final String TYPE_SELECT = "select";
    public static final String TYPE_LOGIN_LOGOUT = "loginLogout";

    private Integer id;

    private String logType;//操作类型，如查询，更新，等

    private String logTitle;//日志标题

    private String createBy;//日志创建人

    private Date createTime;//创建时间

    private String requestUri;//请求uri

    private String requestMethod;//请求方法

    private String remoteAddr;//访问者ip

    private String serverAddr;//服务器地址

    private String isException;//是否是异常日志(1是，0否)

    private String userAgent;//用户访问代理，如2345Explorer/9.3.2.17331

    private String deviceName;//用户主机系统

    private String browserName;//浏览器名称

    private Long executeTime;//执行时间，（单位、毫秒）


    private Date endCreateTime;//用于查询

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle == null ? null : logTitle.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod == null ? null : requestMethod.trim();
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr == null ? null : remoteAddr.trim();
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr == null ? null : serverAddr.trim();
    }

    public String getIsException() {
        return isException;
    }

    public void setIsException(String isException) {
        this.isException = isException == null ? null : isException.trim();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName == null ? null : browserName.trim();
    }

    public Long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }


    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}