<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<title>房源属性编辑</title>
		<link rel="stylesheet" href="../../plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="../../css/global.css" media="all">
		<link rel="stylesheet" href="../../plugins/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="../../css/table.css" />
		<link rel="stylesheet" href="../../layui/dist/css/layui.css"  media="all">

		<style>
            *{
                margin: 0;
                padding: 0;
            }
            .pattr{
                border-bottom: 1px solid lightgrey;
                height: 32px;
                line-height: 32px;
                #background-color: blue;
            }
            .dataList p:hover{
                 background:#98F5FF;
            }

            .attname{

            }
             .attvalue{

            }
        </style>

	</head>

	<body>
	<form class="layui-form" action="" name="actionForm" method="POST" enctype="multipart/form-data" id="form">
		<input type="hidden" name="id"  id="id" value="${(record.id)!''}">
		<fieldset class="layui-elem-field" style="width: 80%; text-align: center; margin-left: 10%;">
			<legend>房源属性编辑</legend>
			<div class="layui-form-item">
		  	</div>
            <div id="attrubutlist">
                    <#if tagsList??>
                     <#list tagsList as tags>
                     <div class="layui-form-item">
                         <div class="layui-inline" index="0">
                           <label class="layui-form-label">属性名</label>
                           <div class="layui-input-inline" style="position:relative;">
                             <input type="text"  id="attrname" name="name" value="${tags.name}" lay-verify="required" autocomplete="off" class="layui-input"  onfocus="showDiv(this);" oninput="closeDiv(this);" />
                           </div>
                         </div>
                         <div class="layui-inline">
                           <label class="layui-form-label">属性值</label>
                           <div class="layui-input-inline" style="position:relative;">
                             <input type="text" id="attrvalue" name="value"  value="${tags.value}" lay-verify="required" autocomplete="off" class="layui-input">
                           </div>
                               <button type="button" class="layui-btn layui-btn-danger"><i class="layui-icon"></i></button>
                         </div>
                      </div>
                      </#list>
                      </#if>
              </div>

            <div class="layui-form-item">
			    <div class="layui-input-block">
			        <button type="button" class="layui-btn" id="addItem">增加</button>
					<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
					 <a href="javascript:history.go(-1);" class="layui-btn">返回</a>
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
                    var formurl = "${request.contextPath}/backpage/houseHousing/saveAttributList";
                //监听提交
                form.on('submit(formDemo)', function(data) {
                        var listAttributNames = document.getElementsByName("name");
                        var listAttributValues = document.getElementsByName("value");
                        var objArry = new Array();
                        if(listAttributNames==null || listAttributNames.length==0
                            || listAttributValues==null || listAttributValues.length==0
                            || listAttributNames.length!=listAttributValues.length){
                            layer.msg('属性名和值不能为空',{time:2000})
                            return;
                        }
                        for(let i=0;i<listAttributNames.length;i++){
                            let obj = {"name":listAttributNames[i].value,"value":listAttributValues[i].value};
                            objArry.push(obj);
                        }
                        var objJsonString = JSON.stringify(objArry);
                        debugger;
                       $.ajax({
                           url:formurl,
                           type:'post',
                           data:{"tags":objJsonString,"id":$("#id").val()},
                           success:function(data) {
                             if("0000"==data.code){
                               //layer.msg('保存成功',{time:2000})
                               alert("保存成功!");
                                setTimeout(function(){window.location.reload();},500);
                              }else{
                                  //layer.msg(data.message,{time:2000})
                                  alert(data.message);
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
        <script>
                  //添加子项
                 $("#addItem").click(function(){
                        var itemList = '<div class="layui-form-item">';
                                    itemList+='<div class="layui-inline" index="0">';
                                        itemList+='<label class="layui-form-label">属性名</label>';
                                        itemList+='<div class="layui-input-inline" >';
                                             itemList+='<input type="tel"  id="attrname" name="name" lay-verify="required" autocomplete="off" class="layui-input" onfocus="showDiv(this)" oninput="closeDiv(this)">';
                                        itemList+='</div>';
                                    itemList+='</div>';
                                    itemList+='  <div class="layui-inline">';
                                        itemList+='<label class="layui-form-label">属性值</label>';
                                        itemList+='<div class="layui-input-inline">';
                                             itemList+='<input type="text" id="attrvalue"  name="value" lay-verify="required" autocomplete="off" class="layui-input">';
                                        itemList+='</div>';
                                        itemList+='<button type="button" class="layui-btn layui-btn-danger"><i class="layui-icon" onclick="removeNode(this)"></i></button>';
                                    itemList+='</div>';
                             itemList+='</div>';
                             $("#attrubutlist").append(itemList);
                    });


                    //删除子项
                     $(".layui-icon").click(function(){
                        $(this).parent().parent().parent().remove();
                     });
                     function removeNode(obj){
                        $(obj).parent().parent().parent().remove();
                     }

                      //鼠标移开事件
                     $("#dataList").mouseout(function(){
                       $("#dataList").remove();
                     });

                     //搜索
                     function showDiv(obj){

                         var top = $(obj).offset().top;
                         var left = $(obj).offset().left;
                         var selfoutheight = $(obj).outerHeight();
                         var widths = $(obj).width();
                         createSearchDiv(top+selfoutheight,left,widths,obj);
                     }
                      //关闭搜索框
                      function closeDiv(obj){
                          $(obj).siblings().remove();
                      }

                      //选择参数并关闭 搜索框
                     function pushInput(obj){
                        var attname = $(obj).find(".attname").text();
                        var attvalue = $(obj).find(".attvalue").text();
                         debugger;
                         $(obj).parent().siblings("#attrname").val(attname);
                         $(obj).parent().parent().parent().siblings(".layui-inline").find("#attrvalue").val(attvalue);
                         $(obj).parent().remove();
                     }

                      //后台传入的 通用标签数组
                      var arrStr='${attributList}';
                      var searchDiv = "";
                      if(arrStr!=null && arrStr!=''){
                         var arr = JSON.parse(arrStr);
                         for(let i=0;i<arr.length;i++){
                             searchDiv+=' <p class="pattr"  onclick="pushInput(this)"><text class="attname" name="attname">'+arr[i].name+'</text>_<text class="attvalue" name="attvalue">'+arr[i].value+'</text></p>';
                         }
                      }

                      function createSearchDiv(top,left,widths,obj) {
                            var newDiv = '<div class="dataList" id="dataList" style="background:white;position:absolute;top:'+top+';left:'+left+';width:189px;z-index:100000;border:1px solid darkgrey;border-top:0px;" style="display:block;">';
                            newDiv+=searchDiv;
                            newDiv+='</div>';
                            $(obj).parent().append(newDiv);
                      }
        </script>
	</body>
</html>