<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>店员</title>
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
		<div style="margin: 15px;">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>店员<#if shop??>修改<#else>添加</#if></legend>
			</fieldset>

			<form class="layui-form" <#if sales??>action="${request.contextPath}/backpage/hyShopSales/update"<#else>action="${request.contextPath}/backpage/hyShopSales/add"</#if> id="form">
			   <#if sales??><input type="hidden" name="id" value="${(sales.id)!''}"></#if>
				<div class="layui-form-item">
					<label class="layui-form-label">店员姓名</label>
					<div class="layui-input-block">
						<input type="text" name="saleName" <#if sales??>value="${sales.saleName}" </#if>  lay-verify="required" autocomplete="off" placeholder="店员姓名" class="layui-input" style="width:190px;">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">手机号</label>
					<div class="layui-input-block">
						<input type="text" name="phone" <#if sales??>value="${sales.phone!''}" </#if>  lay-verify="phone" autocomplete="off" placeholder="手机号" class="layui-input" style="width:190px;">
					</div>
				</div>
				  <div class="layui-form-item">
					<label class="layui-form-label">关联店铺</label>
					<div class="layui-input-block">
					
					<select id="shopOwned" name="shopOwned"  lay-verify="required">
		                     <option value="">请选择...</option>
		                     <#list shops as shop>
		                      <option value="${shop.id}" <#if (sales?? && shop.id==sales.shopOwned)>selected</#if> >${shop.shopName}</option>
		                     </#list>
		                    </select>
					</div>
				</div>

                  <div class="layui-form-item">
					<label class="layui-form-label">状态</label>
					<div class="layui-input-block">
					
					<select id="bak2" name="bak2"  lay-verify="required">
		                     <option value="">请选择...</option>
		                     <option value="0" <#if (sales?? && !sales.bak2)>selected </#if>>停用</option>
		                     <option value="1" <#if (sales?? && sales.bak2)>selected </#if>>正常</option>
		                    </select>
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					    <a href="javascript:history.go(-1);" class="layui-btn">返回</a>
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript" src="${request.contextPath}/plugins/layui/layui.js"></script>
		<script type="text/javascript" src="${request.contextPath}/js/jquery.min.js"></script>
		<script>
		
			layui.use(['form','jquery'], function() {
				var form = layui.form(),
					layer = layui.layer;
					
				 
				//监听提交
				form.on('submit(demo1)', function(data) {
					   $.ajax({
				           url:$('#form').attr('action'),
				           type:'post',
				           data:$('#form').serialize(),
				           success:function(data) { 
				             if("0000"==data.code){
				               layer.msg('添加成功',{time:2000})
				               setTimeout(function(){window.location="${request.contextPath}/backpage/hyShopSales/list"},500);
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