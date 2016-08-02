<!DOCTYPE html>
<html>
<head id="Head1">
    <title></title>
    <#include "base.ftl">
    <script type="text/javascript" src='${contextPath!''}/static/mainFrame/js/outlook2.js'> </script>
    <script type="text/javascript">
	 var _menus = {"menus":[
						{"menuid":"1","icon":"icon-sys","menuname":"系统管理",
							"menus":[{"menuname":"菜单管理","icon":"icon-nav","url":"http://www.16sucai.com"},
									{"menuname":"添加用户","icon":"icon-add","url":"demo.html"},
									{"menuname":"用户管理","icon":"icon-users","url":"UserManagerPage.do"},
									{"menuname":"角色管理","icon":"icon-role","url":"${contextPath!''}/rolesPage"},
									{"menuname":"权限设置","icon":"icon-set","url":"demo.html"},
									{"menuname":"系统日志","icon":"icon-log","url":"demo.html"}
								]
						},{"menuid":"8","icon":"icon-sys","menuname":"员工管理",
							"menus":[{"menuname":"员工列表","icon":"icon-nav","url":"demo.html"},
									{"menuname":"视频监控","icon":"icon-nav","url":"demo1.html"}
								]
						},{"menuid":"56","icon":"icon-sys","menuname":"部门管理",
							"menus":[{"menuname":"添加部门","icon":"icon-nav","url":"demo1.html"},
									{"menuname":"部门列表","icon":"icon-nav","url":"demo2.html"}
								]
						},{"menuid":"28","icon":"icon-sys","menuname":"财务管理",
							"menus":[{"menuname":"收支分类","icon":"icon-nav","url":"demo.html"},
									{"menuname":"报表统计","icon":"icon-nav","url":"demo1.html"},
									{"menuname":"添加支出","icon":"icon-nav","url":"demo.html"}
								]
						},{"menuid":"39","icon":"icon-sys","menuname":"商城管理",
							"menus":[{"menuname":"商品分","icon":"icon-nav","url":"/shop/productcatagory.aspx"},
									{"menuname":"商品列表","icon":"icon-nav","url":"/shop/product.aspx"},
									{"menuname":"商品订单","icon":"icon-nav","url":"/shop/orders.aspx"}
								]
						},{"menuid":"39","icon":"icon-sys","menuname":"流程管理",
							"menus":[{"menuname":"流程管理","icon":"icon-nav","url":"/activitiManager/getActivitiListPage"},
									{"menuname":"商品列表","icon":"icon-nav","url":"/shop/product.aspx"},
									{"menuname":"商品订单","icon":"icon-nav","url":"/shop/orders.aspx"}
								]
						}
				]};
    </script>
</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
	<noscript>
	<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    	<img src="${contextPath!''}/static/mainFrame/images/noscript.gif" alt='抱歉，请开启脚本支持！' />
	</div>
	</noscript>
	
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;background: url(${contextPath!''}/static/mainFrame/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head">欢迎 <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 16px; "><img src="${contextPath!''}/static/mainFrame/images/blocks.gif" width="20" height="20" align="absmiddle" /> 16素材网  www.16sucai.com</span>
    </div>
    
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
    </div>
    
    <div region="west" split="true" title="导航菜单" style="width:180px;" id="west">
		<div class="easyui-accordion" fit="true" border="false"></div>
    </div>
    
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;overflow:hidden;" id="home">
				<h1>欢迎您!</h1>
			</div>
		</div>
    </div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>

</body>
</html>