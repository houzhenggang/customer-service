<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <title></title>
    <#include "base.ftl">  

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
    <!-- 用户查询 -->
    <div region='north' split='true' style="height:250px;padding-top: 20px;">
	    <form id="from" method="post" action=""> 
	    <div style="margin: auto;"> 
		    <div class="col">   
		        <label class="col-label">登录名:</label>   
		        <input type="text" name="loginName" style="width: 200px;padding: 2px;" id="loginName"/>   
		     </div>
		     <div class="col"> 
		        <label class="col-label">状态:</label>
	              <select name="status" style="width: 200px;" id="status">   
				    <option value="">请选择用户状态</option>   
				    <option value="0">停用</option>  
				    <option value="1">启用</option>   
				    <option value="2">冻结</option>   
	              </select>
		    </div>
		   </div>  
		    <div class="col-sm-12" style="text-align: center;">
	            <input type="submit" value="提交" onclick="doSearch();" style="width: 150px;height: 30px;margin-top: 50px;" />
			</div>  
	    </form>
	      
     <style type="text/css">
       .col{width:500px;height: 50px;margin-right: 100px;float: left;margin-left: 100px;}
       .col-sm-12{margin: 5px auto;width: 200px;}
     </style>
     
    </div>  
    <!-- 用户查询end -->
    <!-- 用户信息展示 --> 
    <div region='south' split='true' style="height:650px;padding-top: 20px;">
	    
      <table id="table"> </table>
      
      <!--     弹窗 -->
	    <div id="window" class="easyui-dialog" style="width:450px;height:400px;"   
	        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:'#btns'"> 
	     <div>
		    <form id="form" method="post">   
			         
			         <input class="easyui-validatebox" type="hidden" name="id" data-options="required:true" /><br><br>   
			     登录名： <input class="easyui-validatebox" type="text" name="loginName" data-options="required:true" /><br><br>   
			     状态：   <select name="status" style="width: 150px;">   
				    <option value="">请选择用户状态</option>   
				    <option value="0">停用</option>  
				    <option value="1">启用</option>   
				    <option value="2">冻结</option>   
	              </select>
			     <br><br>   
			  <!--    角色描述：  <input class="easyui-validatebox" type="text" name="rdesc" data-options="required:true" /><br><br>  -->  
		   </form>    
	    </div>
		  <div id="btns">
		  <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="doAdd()" id="btn-add">添加</a> 
		  <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="doUpdate()" id="btn-update">修改</a>  
		  <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="doClose()">取消</a>  
		  </div>
	   </div>
	   <!--    弹窗end --> 
    </div>
  


     
    
    <script type="text/javascript">
  
		$(function(){
			
		    $('#table').datagrid({    
			    url:'list.do',    
			    columns:[[    
			        {field:'id',title:'ID',width:1,align:'center'},
			        {field:'loginName',title:'登录名',width:1,align:'center'},    
			        {field:'status',title:'状态',width:1,align:'center',
			        	/* formatter: function(value,row,index){
							if (row.status){
								return row.bb.name;
							} else {
								return value;
							}
						}	 */
			        },    
			        {field:'o',title:'操作',width:1,align:'center',
			        	formatter: function(value,row,index){
			        	  var btn = '<input type="button" value="修改" onclick="toUpdate('+index+')">'+'<input type="button" value="删除" onclick="doDelete('+row.id+')">';
			        	  return btn;
						}	
			        },   
			    ]],
			    fitColumns:true,
			    rownumbers:true,//行号 
			    pagination:true,
			    pageSize:10,
			    pageList:[3,5,10,20,50],
			    toolbar: [{
					iconCls: 'icon-add',
					text:'添加',
					handler: function(){
						$("#form").form('clear');
						$("#btn-update").hide();
						$("#btn-add").show();
						$('#window').dialog('open');
					}
				},'-',{
					iconCls: 'icon-no',
					text:'批删',
					handler: function(){
						var rows = $("#table").datagrid('getChecked');
						 if(rows != null && rows != ""){
						    var array = [];
							for(var i in rows){
								array.push(rows[i].id);
							}
							ids = array.join();
			            	if(confirm("确定删除ID为"+ids+"的信息")){
			            	  deleteAll(ids);
			           	    }
			             }else{
			            	 alert("请选择需要删除的选项");
			             }
					}
				}]
	    	});
		  //设置分页控件 
		    var p = $('#table').datagrid('getPager'); 
		    $(p).pagination({ 
		        beforePageText: '第',//页数文本框前显示的汉字 
		        afterPageText: '页    共 {pages} 页', 
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
		    }); 
		})
		
	
     </script>
     <script type="text/javascript">
   //添加
     function doAdd(){
     	$.ajax({url:"",type:"post",data:$("form").serialize(),dataType:"json",
     	      success:function(msg){
     	    	  if(msg){
     	    		  alert("添加成功");
     	    		  $("#form").form('clear');
     	    		  $("#window").dialog('close');
     	    		  $("#table").datagrid('reload');
     	    	  }else{
     	    		  alert("添加失败");
     	    	  }
     	      }	
     	});
     }
     //修改
     function toUpdate(index){
    	 $("#table").datagrid("selectRow", index);
    	 $("#form").form('clear');
		 var r =$('#table').datagrid('getSelected');
		 $("#form").form('load',r);
    	 $("#btn-add").hide();
     	 $("#btn-update").show();
    	 $('#window').dialog('open');
     }
     function doUpdate(){
     	$.ajax({url:"",type:"post",data:$("form").serialize(),dataType:"json",
     	      success:function(msg){
     	    	  if(msg){
     	    		  alert("修改成功");
     	    		  $("#form").form('clear');
     	    		  $("#window").dialog('close');
     	    		  $("#table").datagrid('reload');
     	    		  
     	    	  }else{
     	    		  alert("修改失败");
     	    	  }
     	      }	
     	});
     }
   //批删
     function deleteAll(ids){
     		$.ajax({url:"",type:"post",dataType:"json",data:{ids:ids},
     	    	success:function(j){
     	    		if(j){
     	    			alert("删除成功");
     	    			$("#table").datagrid('reload');
     	    		}else{
     	    			alert("删除失败");
     	    		}
     	    	}
     	    });
     }
     //删除
     function doDelete(id){
    	 if(confirm("确定删除编号为"+id+"的信息")){
    		 $.ajax({url:"",type:"post",data:{id:id},dataType:"json",
        	      success:function(msg){
        	    	  if(msg){
        	    		  alert("删除成功");
        	    		  $("#table").datagrid('reload');
        	    		  
        	    	  }else{
        	    		  alert("删除失败");
        	    	  }
        	      }	
        	});
      	}
     }
     //取消
     function doClose(){
     	$("#form").form('clear');
     	  $("#window").dialog('close');
     }
     //查询
     function doSearch(){
    	 var loginName=$("#loginName").val();
    	 var status=$("#status").val(); 
    	 $("#table").datagrid('load',[{loginName:loginName},{status,status}]);
      }
    </script>
    <!-- 用户信息展示end -->
    
</body>
</html>