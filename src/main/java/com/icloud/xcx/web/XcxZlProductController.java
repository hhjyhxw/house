//package com.icloud.xcx.web;
//
//import com.alibaba.fastjson.JSONObject;
//import com.github.pagehelper.PageInfo;
//import com.icloud.common.util.StringUtil;
//import com.icloud.model.imsm.ZlProduct;
//import com.icloud.service.imsm.ZlProductService;
//import com.icloud.web.xcx.service.XcxUserSessionService;
//import com.icloud.web.xcx.util.RequestUtil;
//import com.icloud.web.xcx.util.XcxUserSession;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//
//@Controller
//@RequestMapping(value = "${xcxPath}/xcxZlProduct")
//public class XcxZlProductController {
//
//
//    private Logger log = LoggerFactory.getLogger(getClass());
//    @Autowired
//    private ZlProductService zlProductService;
//    @Autowired
//    private XcxUserSessionService xcxUserSessionService;
//
//    /**产品列表**/
//    @ResponseBody
//    @RequestMapping(value = "/list")
//    public Object list(HttpServletRequest request) {
//        JSONObject resultJson = new JSONObject();
//        try {
//            String paramText = RequestUtil.readPostContent(request);
//            log.error("paramText==="+paramText);
//            if(!StringUtil.checkStr(paramText)){
//                resultJson.put("errCode", "1000");
//                resultJson.put("resultMsg", "参数不能为空");
//                return resultJson;
//            }
//            JSONObject params = JSONObject.parseObject(paramText);
//            String sid = params.getString("sid");
//            if(!StringUtil.checkStr(sid)){
//                resultJson.put("errCode", "1000");
//                resultJson.put("resultMsg", "用户未登陆");
//                return resultJson;
//            }
//            //根据sid判断用户是否存在
//            XcxUserSession user = xcxUserSessionService.getUserSessionBysid(sid);
//            if(null == user){
//                resultJson.put("errCode", "2000");
//                resultJson.put("resultMsg", "用户不存在，sid无效");
//                return resultJson;
//            }
//            JSONObject productBean = params.getJSONObject("productBean");
//            ZlProduct zlProductParm =null;
//            if(params.containsKey("productBean")){
//                 zlProductParm = JSONObject.parseObject(params.toJSONString(productBean),ZlProduct.class);
//            }
//            if(zlProductParm==null){
//                zlProductParm = new ZlProduct();
//            }
//            PageInfo<ZlProduct> page = zlProductService.findByPage(zlProductParm.getPageNo()!=null?zlProductParm.getPageNo():1,
//                    zlProductParm.getPageSize()!=null?zlProductParm.getPageSize():1,zlProductParm);
//
//            JSONObject resultData = new JSONObject();
//            resultData.put("dataList", page.getList());
//            resultData.put("hasMore", page.getPageNum()<page.getPages());
//            resultData.put("totalCount", page.getTotal());
//            resultData.put("pageNo", page.getPageNum());
//            resultData.put("pageSize", page.getPageSize());
//
//            resultJson.put("errCode", "0000");
//            resultJson.put("resultMsg", "获取数据成功");
//            resultJson.put("resultData",resultData);
//        } catch (Exception ex) {
//            log.error("error=====", ex);
//            ex.printStackTrace();
//            resultJson.put("errCode", "0001");
//            resultJson.put("resultMsg", "获取数据失败");
//        }
//        log.error("resultJson====="+resultJson);
//        return resultJson;
//    }
//
//    /**产品详情**/
//    @ResponseBody
//    @RequestMapping(value = "/detail")
//    public Map<String,Object> detail(HttpServletRequest request) {
//        JSONObject resultJson = new JSONObject();
//        try {
//            String paramText = RequestUtil.readPostContent(request);
//            if(!StringUtil.checkStr(paramText)){
//                resultJson.put("errCode", "1000");
//                resultJson.put("resultMsg", "参数不能为空");
//                return resultJson;
//            }
//            JSONObject params = JSONObject.parseObject(paramText);
//            String sid = params.getString("sid");
//            String productId = params.getString("productId");
//            if(!StringUtil.checkStr(sid)){
//                resultJson.put("errCode", "1000");
//                resultJson.put("resultMsg", "用户未登陆");
//                return resultJson;
//            }
//            if(!StringUtil.checkStr(productId)){
//                resultJson.put("errCode", "3000");
//                resultJson.put("resultMsg", "产品参数为空");
//                return resultJson;
//            }
//            //根据sid判断用户是否存在
//            XcxUserSession user = xcxUserSessionService.getUserSessionBysid(sid);
//            if(null == user){
//                resultJson.put("errCode", "2000");
//                resultJson.put("resultMsg", "用户不存在，sid无效");
//                return resultJson;
//            }
//            ZlProduct product = zlProductService.findByKey(Long.valueOf(productId));
//            resultJson.put("errCode", "0000");
//            resultJson.put("resultMsg", "获取数据成功");
//            resultJson.put("errCode", "0000");
//            resultJson.put("resultMsg", "获取数据成功");
//            resultJson.put("resultData",product);
//        } catch (Exception ex) {
//            log.error("error=====", ex);
//            resultJson.put("errCode", "0001");
//            resultJson.put("resultMsg", "获取数据失败");
//        }
//        return resultJson;
//    }
//
//
//}
