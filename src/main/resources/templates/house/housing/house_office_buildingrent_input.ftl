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
            <label class="layui-form-label">标题</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="text" name="title" lay-verify="required" id="title" value="${(record.title)!''}" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>

         <div class="layui-form-item">
            <label class="layui-form-label">所在区域</label>

            <div class="layui-input-inline" style="width:70%">
                 <select name="village" lay-verify="required" id="village">
                    <option value="">--请选择--</option>
                    <#if arenList??>
                        <#list arenList as areaObj>
                            <option value="${areaObj.areanName}"  <#if (record.village)?? && record.village==areaObj.areanName>selected="selected"</#if>>${areaObj.areanName}</option>
                        </#list>
                    </#if>
                </select>
              </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>

         <div class="layui-form-item">
            <label class="layui-form-label">租金/平方/月</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="number" name="minUnitPrice" lay-verify="required" id="minUnitPrice" value="${(record.minUnitPrice?c)!''}" placeholder="租金/平方/月" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*(单位/元/平方米/每月)</span></div>
        </div>

         <div class="layui-form-item">
            <label class="layui-form-label">总价</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="number" name="minTotalPrice" lay-verify="required" id="minTotalPrice" value="${(record.minTotalPrice?c)!''}" placeholder="总价" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*(单位/万元)</span></div>
        </div>

       <div class="layui-form-item">
            <label class="layui-form-label">面积</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="number" name="minHouseArea" lay-verify="required" id="minHouseArea" value="${(record.minHouseArea?c)!''}" placeholder="面积" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*(单位/平方米)</span></div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">物业类型</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="text" name="propertyType" lay-verify="required" id="propertyType" value="${(record.propertyType)!''}" placeholder="甲级写字楼、普通写字楼等" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">特色</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="text" name="features" lay-verify="required" id="features" value="${(record.features)!''}" placeholder="近地铁、新品、热销等" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">装修</label>
            <div class="layui-input-inline" style="width:70%">
                <input type="text" name="fitup" lay-verify="required" id="fitup" value="${(record.fitup)!''}" placeholder="豪华装修、精装修等" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block" style="width:70%">
            <select name="status" lay-verify="required">
                <option value="">--请选择--</option>
              <option value="0" <#if (record?? && record.status==0)>selected</#if>>下架</option>
              <option value="1" <#if (record?? && record.status==1)>selected</#if>>上架</option>
            </select>
            </div>
        </div>

         <div class="layui-form-item">
            <label class="layui-form-label">文字详情</label>
            <div class="layui-input-inline" style="width:70%">
                <textarea class="layui-textarea layui-hide" name="describes" lay-verify="" id="describes"><#if record??>${record.describes!''}</#if></textarea>
            </div>
            <div class="layui-form-mid layui-word-aux"><span style="color:red;">*</span></div>
        </div>
       <div class="layui-form-item">
            <label class="layui-form-label">图片详情</label>
            <div class="layui-input-inline" style="width:70%">
                <textarea class="layui-textarea" name="introductionDetail" lay-verify="content" id="introductionDetail"><#if record??>${record.introductionDetail!''}</#if></textarea>
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
            layui.use(['form','jquery','layedit'], function() {

                      var layedit = layui.layedit;
                     //上传图片,必须放在 创建一个编辑器前面
                     layedit.set({
                          uploadImage: {
                               url: '${request.contextPath}/backpage/upload/uploadFileImageEdit' //接口url
                              ,type: 'post', //默认post
                               success: function (data) {
                               }
                          }
                     });
                    //1、包含图片的 文本编辑器
                   var detailIndex = layedit.build('introductionDetail',{
                          tool: [
                         			  'strong' //加粗
                         			  ,'italic' //斜体
                         			  ,'underline' //下划线
                         			  ,'del' //删除线
                         			  ,'|' //分割线
                         			  ,'left' //左对齐
                         			  ,'center' //居中对齐
                         			  ,'right' //右对齐
                         			  ,'link' //超链接
                         			  ,'unlink' //清除链接
                         			  ,'face' //表情
                         			  ,'image' //插入图片 ,'help' //帮助
                         			] ,height: 400
                     });
                       layedit.sync(detailIndex);
                      //2、纯文字描述 文本编辑器
                      var  describesIndex = layedit.build('describes', {
                          tool: ['strong','italic','underline','del','left','center', 'right', '|']
                        });

                    //表单使用
                    var form = layui.form(),
                    layer = layui.layer;
                    var formurl = '';
                    if($('#id').val()!=''){
                        formurl = "${request.contextPath}/backpage/officeBuildingRent/update";
                    }else{
                         formurl = "${request.contextPath}/backpage/officeBuildingRent/add";
                    }
                //监听提交
                form.on('submit(formDemo)', function(data) {
                        layedit.sync(detailIndex);
                        layedit.sync(describesIndex);
                       $.ajax({
                           url:formurl,
                           type:'post',
                           data:$('#form').serialize(),
                           success:function(data) {
                             if("0000"==data.code){
                               layer.msg('保存成功',{time:2000})
                               setTimeout(function(){window.location="${request.contextPath}/backpage/officeBuildingRent/list"},500);
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