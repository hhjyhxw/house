<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<title><#if (record.id)??>编辑<#else>添加</#if></title>
		<link rel="stylesheet" href="../../plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="../../css/global.css" media="all">
		<link rel="stylesheet" href="../../plugins/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="../../css/table.css" />
		<link rel="stylesheet" href="../../layui/dist/css/layui.css"  media="all">
	</head>

	<body>
	<form class="layui-form" action="" name="actionForm" method="POST" enctype="multipart/form-data" id="form">
		<input type="hidden" name="id"  id="id" value="${(record.id)!''}">
		<fieldset class="layui-elem-field" style="width: 60%; text-align: center; margin-left: 20%;">
			<legend><#if (record.id)??>编辑<#else>添加</#if></legend>
			<div class="layui-form-item">
		  	</div>
                                   <div class="layui-form-item">
            <label class="layui-form-label">house_id</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="text" name="houseId" lay-verify="required" id="houseId" value="${(record.houseId)!''}" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>
                             <div class="layui-form-item">
            <label class="layui-form-label">浏览时间</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="text" name="createTime" lay-verify="required" id="createTime" value="${(record.createTime)!''}" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>
                             <div class="layui-form-item">
            <label class="layui-form-label">用户id</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="text" name="userId" lay-verify="required" id="userId" value="${(record.userId)!''}" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>
            		  	<div class="layui-form-item">
			    <div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
		  	</div>
		</fieldset>
	</form>


 	<script type="text/javascript" src="../../plugins/layui/layui.js?v=2"></script>
	<script type="text/javascript" src="../../js/jquery.min.js"></script>
	<script>
            layui.config({
                base: '${request.contextPath}/plugins/layui/modules/'
            });
            layui.use(['form','jquery'], function() {
                var form = layui.form(),
                    layer = layui.layer;

                    var formurl = '';
                    if($('#id').val()!=''){
                        formurl = "${request.contextPath}/backpage/houseBrowseRecords/update";
                    }else{
                         formurl = "${request.contextPath}/backpage/houseBrowseRecords/add";
                    }
                    debugger;
                //监听提交
                form.on('submit(formDemo)', function(data) {
                       $.ajax({
                           url:formurl,
                           type:'post',
                           data:$('#form').serialize(),
                           success:function(data) {
                             if("0000"==data.code){
                               layer.msg('保存成功',{time:2000})
                               setTimeout(function(){window.location="${request.contextPath}/backpage/houseBrowseRecords/list"},500);
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