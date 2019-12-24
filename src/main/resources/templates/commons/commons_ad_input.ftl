<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<title><#if (record.id)??>编辑<#else>添加</#if></title>
			<meta name="renderer" content="webkit">
    		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    		<meta name="apple-mobile-web-app-status-bar-style" content="black">
    		<meta name="apple-mobile-web-app-capable" content="yes">
    		<meta name="format-detection" content="telephone=no">
    		<link rel="stylesheet" href="${request.contextPath}/plugins/layui/css/layui.css" media="all" />
    		<link rel="stylesheet" href="${request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
	</head>

	<body>
	<form class="layui-form" action="" name="actionForm" method="POST" enctype="multipart/form-data" id="form">
		<input type="hidden" name="id"  id="id" value="${(record.id)!''}">
		<fieldset class="layui-elem-field" style="width: 60%; text-align: center; margin-left: 20%;">
			<legend><#if (record.id)??>编辑<#else>添加</#if></legend>
			<div class="layui-form-item">
		  	</div>
                           <div class="layui-form-item">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="text" name="adName" lay-verify="required" id="adName" value="${(record.adName)!''}" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>

                     <div class="layui-form-item">
            <label class="layui-form-label">跳转url</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="text" name="addJumpurl" lay-verify="required" id="addJumpurl" value="${(record.addJumpurl)!''}" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>
                     <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-inline" style="width:70%">
                <select name="status" lay-verify="required" id="status">
                    <option value="">--请选择--</option>
                    <option value="0" <#if (((record.status)!'') == '0')>selected="selected"</#if>>停用</option>
                    <option value="1"  <#if (((record.status)!'') == '1')>selected="selected"</#if>>启用</option>
                </select>
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>
         <div class="layui-form-item">
            <label class="layui-form-label">排序</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="number" name="sortNum" lay-verify="required" id="sortNum" value="${(record.sortNum)!999}" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>


        <div class="layui-form-item">
                <label class="layui-form-label">广告图片</label>
                <div class="layui-input-inline">
                     <img id="LAY_demo_upload" width="640px" height="278px" <#if record??> src="${request.contextPath}${(record.adImgurl)!''}" </#if>>
                     <input lay-verify="content" type="hidden" name="adImgurl"  <#if record??>value="${(record.adImgurl)!''}"</#if> id="LAY_IMG_URL">
                 </div>

          </div>

            <div class="layui-form-item">
                <label class="layui-form-label">添加图片</label>
                 <div class="layui-input-inline">
                    <input type="file" name="file" lay-type="images" width="90px" class="layui-upload-file">
               </div>
            </div>


            <div class="layui-form-item">
			    <div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
		  	</div>
		</fieldset>
	</form>


 	  <script type="text/javascript" src="${request.contextPath}/plugins/layui/layui.js"></script>
    		<script type="text/javascript" src="${request.contextPath}/js/jquery.min.js"></script>
	<script>

            layui.use(['upload','form','jquery','layedit'], function() {
                var form = layui.form(),
                    layer = layui.layer;
                    layedit = layui.layedit;
                    var imgIndex =  layui.upload({
                        url: '${request.contextPath}/backpage/upload/uploadGoodsImage'
                        ,method: 'post' //上传接口的http类型
                        ,success: function(res){
                          if(res.code!='0'){
                             layer.msg(res.msg,{time:2000})
                             return ;
                           }
                           debugger;
                           LAY_demo_upload.src = "${request.contextPath}"+res.data.src;
                         // LAY_IMG_URL.value=res.data.src;
                          $('#LAY_IMG_URL').val(res.data.src)
                        }
                      });

                    var formurl = '';
                    if($('#id').val()!=''){
                        formurl = "${request.contextPath}/backpage/commonsAd/update";
                    }else{
                         formurl = "${request.contextPath}/backpage/commonsAd/add";
                    }
                    debugger;
                //监听提交
                form.on('submit(formDemo)', function(data) {
                         layedit.sync(imgIndex);
                       $.ajax({
                           url:formurl,
                           type:'post',
                           data:$('#form').serialize(),
                           success:function(data) {
                             if("0000"==data.code){
                               layer.msg('保存成功',{time:2000})
                               setTimeout(function(){window.location="${request.contextPath}/backpage/commonsAd/list"},500);
                              }else{
                                  layer.msg(data.message,{time:2000})
                            }
                         },
                        error : function() {
                           layer.msg("异常！");
                        }
                 })
                    return false;
                });
            });
        </script>

	</body>
</html>