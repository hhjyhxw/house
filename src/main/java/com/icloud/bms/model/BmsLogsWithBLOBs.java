package com.icloud.bms.model;


import com.icloud.basecommon.util.collect.MapUtils;
import com.icloud.basecommon.util.lang.StringUtils;

import java.util.Map;

public class BmsLogsWithBLOBs extends BmsLogs {
    private String requestParams;

    private String diffModifyData;

    private String exceptionInfo;


    private Map<String, String[]> paramsMap; 		// 操作提交的数据，临时存储用

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams == null ? null : requestParams.trim();
    }

    public String getDiffModifyData() {
        return diffModifyData;
    }

    public void setDiffModifyData(String diffModifyData) {
        this.diffModifyData = diffModifyData == null ? null : diffModifyData.trim();
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo == null ? null : exceptionInfo.trim();
    }

    public Map<String, String[]> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(Map<String, String[]> paramsMap) {
        this.paramsMap = paramsMap;
    }

    /**
     * 设置请求参数
     * @param paramsMap
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void setRequestParams(Map paramsMap){
        if (paramsMap == null){
            return;
        }
        if (this.paramsMap == null){
            this.paramsMap = MapUtils.newHashMap();
        }
        StringBuilder params = new StringBuilder();
        for (Map.Entry<String, String[]> param : ((Map<String, String[]>)paramsMap).entrySet()){
            params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
            String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
            params.append(StringUtils.abbr(StringUtils.endsWithIgnoreCase(param.getKey(), "password") ? "*" : paramValue, 1000));
            this.paramsMap.put(param.getKey(), param.getValue());
        }
        this.requestParams = params.toString();
    }

    /**
     * 根据名称获取参数（只有先执行setParams(Map)后才有效）
     * @param name
     * @return
     */
    public String getRequestParam(String name) {
        if (paramsMap == null){
            return null;
        }
        String[] values = (String[])paramsMap.get(name);
        return values != null && values.length > 0 ? values[0] : null;
    }

}