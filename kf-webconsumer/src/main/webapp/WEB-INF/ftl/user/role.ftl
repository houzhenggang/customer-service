<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <title></title>
<link rel="stylesheet" type="text/css" href="${contextPath!''}/static/mainFrame/css/default.css" />
<link rel="stylesheet" type="text/css" href="${contextPath!''}/static/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${contextPath!''}/static/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${contextPath!''}/static/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="${contextPath!''}/static/easyui/demo/demo.css">
<script type="text/javascript" src="${contextPath!''}/static/easyui/syUtil.js"></script>
<script type="text/javascript" src="${contextPath!''}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${contextPath!''}/static/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath!''}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">

$(function(){
    
	//主列表
$('#dg').datagrid({    
    url:'${contextPath!''}/roles',
	method:'post',
    columns:[[    
        {field:'aa',title:'',width:30,align:'center',checkbox:true},
        {field:'roleName',title:'角色名称',width:100,align:'left',},
        {field:'roleCode',title:'角色编码',width:100,align:'left'},      
        {field:'px',title:'排序',width:100,align:'left'}, 
        {field:'roleDesc',title:'描述',width:100,align:'left'},    
        {field:'cz',title:'操作',width:100,align:'left',
       
			formatter: function(value,row,index){
				
				return "<span class='bj' onclick='bjqx("+index+")'>[编辑权限]</span><span class='gl' onclick='glcy()'>[管理成员]</span><a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-remove' plain='true' onclick='removeUser()'>删除</a>";
			}
		}, 
		
    ]],  
    //fit:true,
    fitColumns:true,
    striped:true,
    pagination:true,
    //singleSelect:true,
    toolbar:'#tb',
    pageSize:3,
    pageList:[3,6,9],
});
	//权限表
	$('#tqx').datagrid({
	    url:'',
	    columns:[[
	        {field:'powerName',title:'菜单',width:100,align:'center'},
	        {field:'powerName',title:'全选',width:100,align:'center'},
	        {field:'powerName',title:'浏览',width:100,align:'center'},
	        {field:'powerName',title:'编辑',width:100,align:'center'},
	        {field:'powerName',title:'删除',width:100,align:'center'},
	        {field:'powerName',title:'查询',width:100,align:'center'},
	        {field:'powerName',title:'刷新',width:100,align:'center'},
	        {field:'powerName',title:'导出',width:100,align:'center'},
	        {field:'powerName',title:'下载',width:100,align:'center'},
	        {field:'powerName',title:'打印',width:100,align:'center'},
	        {field:'powerName',title:'授权',width:100,align:'center'},
	        {field:'powerName',title:'审核',width:100,align:'center'},
	    ]],
	    //fit:true,
	    fitColumns:true,
	    striped:true,
	    pagination:true,
	    //singleSelect:true,
	    pageSize:3,
	    pageList:[3,6,9],
	});


	//编辑权限列表
	$('#ta').datagrid({    
	    url:'',
	    columns:[[    
            {field:'fid',title:'',width:100,checkbox:true},
	        {field:'id',title:'菜单',width:100},
	        {field:'name',title:'编号',width:100},
	        {field:'age',title:'备注说明',width:100,align:'center'},

	    ]],  
	    fit:true,
	    fitColumns:true,
	    striped:true,
	    //pagination:true,
	    singleSelect:true,
	    pageSize:3,
	    pageList:[3,6,9],
	});

//表单 添加
    $('#sb').click(function(){
        alert("添加");
        $('#ff').form('submit', {
            url:'',
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
            },
            success:function(data){
                alert(data);
                if(data>0){
                    alert("添加成功");
                    $("#dd").dialog('close');
                    location.reload();
                }
            }
        });
    });
	//修改
	$('#but').click(function(){
		$('#mm').form('submit', {
		    url:'',
		    onSubmit: function(){
		        // do some check
		        // return false to prevent submit;
		    },
		    success:function(data){
		        alert(data);
		        if(data>0){
		        	alert("修改成功");
		        	$("#up").dialog('close');
		        	location.reload();
		        }
		    }
		});
	});


});

    //添加弹框
	function newUser(){
		$('#ff').form('clear');
		$('#dd').dialog('open');
	}
	//编辑权限
	function bjqx(index){
	    alert("编辑权限");
	    $("#dg").datagrid("selectRow", index);
	    var row = $('#dg').datagrid('getChecked');
	    console.log(row);


		$("#qx").dialog('open');
	}
	//编辑修改
	function editUser(){
	    alert("修改");
	    var row = $('#dg').datagrid('getChecked');
	    if(row==null){
	        alert(请选择);
	    }else{

	    $('#uff').form('clear');
	    $('#uff').form('load',row);
		$("#up").dialog('open');

	    }
	}
	//刷新
	function reloadUser(){
	    location.reload();
	}
	//模糊查询
	$("#ss").click(function(){
		var mohu = serializeObject($("#sf"));
		$('#dg').datagrid('load',mohu);
		var row = $('#dg').datagrid('getChecked');

	});



	//管理成员
	function glcy(){
		alert("管理成员");
		$("#cy").dialog('open');
    }

    //删除
    function removeUser(){
		alert("删除");
		var row = $('#dg').datagrid('getSelected');
	    if(row==null){
			alert("请先选择");
		}else{
	    	var id=row.id;
	    	alert(id);
	    	$.ajax({
	    		url:"",
	    		data:{id:id},
	    		type:"post",
	    		dataType:"text",
	    		success:function(msg){
	    			if(msg>0){
	    				alert("删除成功");
	    				location.reload();
	    			}else{
	    				alert("删除失败");
	    			}
	    		}
	    	});
    	}
    }

    //保存权限
    function saveUser(){
		alert("保存权限");
		var row = $('#tqx').datagrid('getChecked');
		var roleCode = $("#roleCode").val();
		var powerid = row.powerid;
		if(row==null){
			alert("请先选择");
		}else{
	    	$.ajax({
	    		url:"",
	    		data:{
	    		    roleCode:roleCode,
	    		    powerid:powerid,
	    		},
	    		type:"post",
	    		dataType:"json",
	    		success:function(msg){
	    			alert(msg);
	    			if(msg){
	    				alert("赋权成功");
	    				location.reload();
	    			}else{
	    				alert("赋权失败");
	    			}
	    		}
	    	});
    	}
    }



</script>
</head>
<body>
    <div>   
             <form id="sf" method="post">
			 <label for="name">按照角色名称查找:</label>   
			 <input type="text" name="mohu" data-options="required:true" />   
		     <input type="button" value="搜索" id="ss">
		     </form>
	</div> 
    <table id="dg"></table>
    
    
    <div id="tb">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reloadUser()">刷新</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">批量删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="saveUser()">保存</a>
    </div>
    
    <!-- //新增 -->
		<div id="dd" class="easyui-dialog" title="新增" style="width:400px;height:200px;"   
		    data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true,resizable:true,maximizable:true,minimizable:true,collapsible:true">   
		    <div style="text-align: center;">
		    </br>
		    </br>
			    <form id="ff" method="post">
				    <div>
				        <label for="name">角色名称:</label>
				        <input class="easyui-validatebox" type="text" name="" data-options="required:true" />
				    </div>
				    <div>
				        <label for="name">角色编码:</label>
				        <input class="easyui-validatebox" type="text" name="" data-options="required:true" />
				    </div>
				    <div>
				        <label for="name">排序:</label>
				        <input class="easyui-validatebox" type="text" name="" data-options="required:true" />
				    </div>
				    <div>
				        <label for="name">描述:</label>
				        <input class="easyui-validatebox" type="text" name="" data-options="required:true" />
				    </div>
				    <a id="sb" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>

				</form>
			</div>
		</div>  
        <!-- //编辑-->
        <div id="up" class="easyui-dialog" title="角色授权" style="width:400px;height:200px;"
		    data-options="iconCls:'icon-edit',resizable:true,modal:true,closed:true,resizable:true,maximizable:true,minimizable:true,collapsible:true">
            <div style="text-align: center;">
            </br>
            </br>
			<form id="uff" method="post">
			    <div>
				        <label for="name">角色名称:</label>
				        <input class="easyui-validatebox" type="text" name="" data-options="required:true" />
				    </div>
				    <div>
				        <label for="name">角色编码:</label>
				        <input class="easyui-validatebox" type="text" name="" data-options="required:true" />
				    </div>
				    <div>
				        <label for="name">排序:</label>
				        <input class="easyui-validatebox" type="text" name="" data-options="required:true" />
				    </div>
				    <div>
				        <label for="name">描述:</label>
				        <input class="easyui-validatebox" type="text" name="" data-options="required:true" />
				    </div>
				    <a id="but" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
			    </form>
		    </div>
		</div>

        <!-- // 管理成员-->
        <div id="cy" class="easyui-dialog" title="超级管理员" style="width:400px;height:200px;"
		    data-options="iconCls:'icon-edit',resizable:true,modal:true,closed:true,resizable:true,maximizable:true,minimizable:true,collapsible:true">   
		    
		   <form id="glff" method="post">
		    <div>
			        <label for="name">描述:</label>
			        <input class="easyui-validatebox" type="text" name="" data-options="required:true" />
			    </div>
			    <div>
			        <label for="name">成员:</label>
			        <textarea rows="5" cols="20"></textarea>
			    </div>
		    </form>
		       <div id="glan">
			        <a href="javascript:add(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
			        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">批量删除</a>
			        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="saveUser()">清空</a>
			    </div>
			    
			    <a id="" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
			    <a id="" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
		</div>


		<!-- //编辑权限-->
        <div id="qx" class="easyui-dialog" title="角色授权" style="width:550px;height:400px;"
		    data-options="iconCls:'icon-edit',resizable:true,modal:true,closed:true,resizable:true,maximizable:true,minimizable:true,collapsible:true">   
		    
		<!--//权限选项卡-->
		
			<div id="tt" class="easyui-tabs" style="width:500px;height:500px;">   
			    <div title="菜单权限" style="padding:20px;display:none;">

			        <table id="ta"></table> 
                    <a id="" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
			        <a id="" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
   
			    </div>   
			    <div title="按钮权限" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">   
			        <table id="tqx"></table>
			        <a id="" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
			        <a id="" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
			    </div>   
			    <div title="数据权限" data-options="closable:true" style="padding:20px;display:none;">   
			        <table id="ta"></table> 
			        <a id="" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
			        <a id="" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
			    </div>
			    <div title="字段权限" data-options="closable:true" style="padding:20px;display:none;">   
			        <table id="ta"></table> 
			        <a id="" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
			        <a id="" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
			    </div>   
			</div> 
		       
		</div> 
    <script type="text/javascript">
        
    </script>
  
</body>
</html>