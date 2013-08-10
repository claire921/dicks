<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />   
<title>DSG - Cost Calculation Template </title>
<link href="css/common.css" rel="stylesheet" type="text/css" /> 
<script src="js/jquery.min.js" type="text/javascript"> </script>
<script src="js/animation.js" type="text/javascript"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>

function addOtherCost(myDiv) {

  var ni = document.getElementById(myDiv.id);

  var numi = document.getElementById('theValue');

  var num = (document.getElementById('theValue').value -1)+2;

  numi.value = num;

  var newdiv = document.createElement('div');

  var divIdName = 'othercost'+num;

  newdiv.setAttribute('id',divIdName);

  newdiv.innerHTML = '<input type=\'text\' style=\'width:150px;\'placeholder=\'Input Cost Name\'>&nbsp;&#42;&nbsp;&#58;&nbsp;&nbsp;<input type=\'text\' style=\'width:50px;\'>&nbsp;<select style=\'width:240px;\'><option value=\'#\'>dollar per unit</option><option value=\'#\'>&#37; of Net Merchandise Sales</option></select>&nbsp;<a href=\'javascript:;\' onclick=\'removeElement('+divIdName+')\'>Remove</a>';

  ni.appendChild(newdiv);

}

function removeElement(divNum) {
  //var d = document.getElementById("myDiv");

  var olddiv = document.getElementById(divNum.id);

  olddiv.parentNode.removeChild(olddiv);

  //d.removeChild(olddiv);

};
</script>

<script>

  $(function() {
    $( "#tabs" ).tabs({
      //event: "mouseover"
      collapsible: true
    });
  });


</script>
</head>

<body>
    <div class="header">
    <div class="header-content">
        <div class="logo">
            <a href="orderlist.html"><img src="image/logo.png"/></a></div>
        <div class="top-nav">
            <a href="#" target="_blank" class="trackable">
            <span class="nav-icon help-icon"></span>Help</a>|
            <a href="#" target="_blank" class="trackable">Account</a>|
            <a href="#">Log out</a>
        </div>
    </div>
    </div>
    
   
    <div class="body clearfix">
    
    <!-- menu bar starts -->
    <div class="aside" id="aside-menu">
    <div class="title"><h1></h1>
       <!-- <a href="javascript:void(0)" class="fold recordable" memo="{&quot;id&quot;:&quot;menu-toggle&quot;,&quot;type&quot;:&quot;menu-toggle&quot;,&quot;status&quot;:&quot;0&quot;}" id="menu-toggle"></a>
        -->
    </div>
    <ul class="nav">
        <li class=""><a class="recordable open" id="toggleone" href="#" 
            memo="{id:'21',type:'menu',global:1,status:''}">Manage Category</a>
            <ul class="nav-two" id="navone">
                <li class=""><a href="categorylist.html">Category List</a><span class="normal">&nbsp;</span></li>
                <li class=""><a href="CreateCategory.html">New Category</a><span class="normal">&nbsp;</span></li>  
            </ul>
        </li>
        <li class=""><a class="recordable open" href="#" id="toggletwo"
            memo="{id:'21',type:'menu',global:1,status:''}">Manage Business Rule</a>
            <ul class="nav-two" id="navtwo">
                <li class=""><a href="rulelist.html">Business Rule List</a><span class="normal">&nbsp;</span></li>
                <li class="selected"><a href="newrule.html">New Business Rule</a><span class="normal">&nbsp;</span></li>
                <li class=""><a href="RulePriority.html">Business Rule Priority</a><span class="normal">&nbsp;</span></li> 
            </ul>
        </li>   
        <li class=""><a class="recordable open" href="#" id="togglethree"
            memo="{id:'21',type:'menu',global:1,status:''}">Visualization Dashboard</a>
            <ul class="nav-two" id="navthree">
                <li class=""><a href="orderlist.html">Order List</a><span class="normal">&nbsp;</span></li>
                <li class=""><a href="statistics.html">Statistics</a><span class="normal">&nbsp;</span></li>
                
            </ul>
        </li>  
        <li class=""><a href="placeorder.html" id="togglefour" memo="{id:'21',type:'menu',global:1,status:''}">Place Order</a>
        </li>  
    </ul>
    </div>
    <!-- menu bar ends -->

    <!-- content starts -->
    <div class="minibar recordable" id="minibar" memo="{&quot;id&quot;:&quot;menu-toggle&quot;,&quot;type&quot;:&quot;menu-toggle&quot;,&quot;status&quot;:&quot;1&quot;}" style="display:none;"><a id="menu-untoggle" href="javascript:void(0)" class="unfold" ></a></div> 
    <div class="main"  id="main-body">
    <div class="content clearfix">
                
       <div class="title-bar clearfix">
            <h1 class="l">New Business Rule</h1><div id="Date" class="date l"></div>
            <a id='ReportTipIco' class="report-help open l recordable" memo="{id:'ReportTipIco',type:'page-tip',global:0}" href="javascript:void(0);">&nbsp;</a>
            <br/><br/><div><hr/></div>
        </div>
            <li style="list-style:none;"><span><a href="#">Home</a><span> > </span></span></span>
                <span><a href="#">Manage Business Rule</a><span> > </span></span>
                <span>New Business Rule</span>
            </li>
            
            <!-- Success Message and Error Message -->
            <div class="success_area" style="display:none">successMessage</div>
            <div class="warning" style="display:none">errorMessage</div>
            <!-- Success Message and Error Message -->

            <form action="#">
            <table class="text" style="width:750px;">
                <tr>
                    <td style="width:150px;">Rule Name&#58;</td>
                    <td style="width:600px;">Cost Calculate</td>
                </tr>   
                <tr>
                    <td>Rule Description&#58;</td>
                    <td>Set the formula for fulfillment cost calculation.</td>
                </tr>
                <tr>
                    <td>Category&#58;</td>
                    <td>Clothes&#44;&nbsp;Fishing</td>
                </tr>
                <tr>
                    <td>Stage&#58;</td>
                    <td>Stage2: Candidate Evaluate</td>
                </tr>
                <tr>
                    <td>Rule Template&#58;</td>
                    <td>Cost Calculate</td>
                </tr>
                <tr class="drl-height">
                    <td colspan="2">Rule Editor&#58;</td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                    <div class="drl"> 
                            <div id="tabs">
                                <ul>
                                    <li><a href="#tabs-SFS">Ship from Store</a></li>
                                    <li><a href="#tabs-GSI">Fulfilled by GSI</a></li>
                                    <li><a href="#tabs-Vendor">Vendor Direct</a></li>
                                </ul>
                                <div id="tabs-SFS" style="min-height:250px;">
                                <table >
                                    <tr>
                                        <td style="width:200px;">Transaction Fees&nbsp;&#42;&nbsp;&#58;</td>
                                        <td style="width:400px;"><input type="text" style="width:50px;">&nbsp;&#37;&nbsp;of Net Merchandise Sales</td>
                                    </tr>
                                    <tr>
                                        <td style="width:200px;">Freight In to Store Cost&nbsp;&#42;&nbsp;&#58;</td>
                                        <td style="width:400px;"><input type="text" style="width:50px;">&nbsp;&#37;&nbsp;of Net Merchandise Sales</td>
                                    </tr>
                                    <tr>
                                        <td style="width:200px;">Distribution Center Cost&nbsp;&#42;&nbsp;&#58;</td>
                                        <td style="width:400px;"><input type="text" style="width:50px;">&nbsp;&#37;&nbsp;of Net Merchandise Sales</td>
                                    </tr>
                                    <tr>
                                        <td style="width:200px;">Packaging Cost&nbsp;&#42;&nbsp;&#58;</td>
                                        <td style="width:400px;"><input type="text" style="width:50px;">&nbsp;dollar per unit</td>
                                    </tr>
                                    <tr>
                                        <td style="width:200px;">Labor Cost&nbsp;&#42;&nbsp;&#58;</td>
                                        <td style="width:400px;"><input type="text" style="width:50px;">&nbsp;dollar per unit</td>
                                    </tr>
                                </table>
                                <div>
                                    <input type="hidden" value="0" id="theValue"/>
                                    <a class="button" href="javascript:;" onclick="addOtherCost(SFSDiv);">Add Other Costs</a>
                                    <div id="SFSDiv">
                                    </div>
                                </div>
                                </div>
                                <div id="tabs-GSI" style="min-height:250px;">
                                <table >
                                    <tr>
                                        <td style="width:200px;">Transaction Fees&nbsp;&#42;&nbsp;&#58;</td>
                                        <td style="width:400px;"><input type="text" style="width:50px;">&nbsp;&#37;&nbsp;of Net Merchandise Sales</td>
                                    </tr>
                                    <tr>
                                        <td style="width:200px;">Freight In to Store Cost&nbsp;&#42;&nbsp;&#58;</td>
                                        <td style="width:400px;"><input type="text" style="width:50px;">&nbsp;&#37;&nbsp;of Net Merchandise Sales</td>
                                    </tr>
                                    <tr>
                                        <td style="width:200px;">Distribution Center Cost&nbsp;&#42;&nbsp;&#58;</td>
                                        <td style="width:400px;"><input type="text" style="width:50px;">&nbsp;&#37;&nbsp;of Net Merchandise Sales</td>
                                    </tr>
                                </table>
                                <div>
                                    <input type="hidden" value="0" id="theValue"/>
                                    <a class="button" href="javascript:;" onclick="addOtherCost(GSIDiv);">Add Other Costs</a>
                                    <div id="GSIDiv">
                                    </div>
                                </div>
                                </div>
                                <div id="tabs-Vendor" style="min-height:250px;">
                                    <table >
                                    <tr>
                                        <td style="width:200px;">Transaction Fees&nbsp;&#42;&nbsp;&#58;</td>
                                        <td style="width:400px;"><input type="text" style="width:50px;">&nbsp;&#37;&nbsp;of Net Merchandise Sales</td>
                                    </tr>
                                </table>
                                <div>
                                    <input type="hidden" value="0" id="theValue"/>
                                    <a class="button" href="javascript:;" onclick="addOtherCost(VendorDiv);">Add Other Costs</a>
                                    <div id="VendorDiv">
                                    </div>
                                </div>
                                </div>
                            </div>
                    </div>
                    </td>
                </tr>
                <tr>
                    <td><a class="button" href="rulelist.html">Create</a></td>  
                    <td><a class="button" href="newrule.html">Back</a><a class="button" href="rulelist.html">Cancel</a></td>
                </tr>
            </table>   
            </form>
        </div>
    </div>
  
    </div>
    
    <!-- content ends -->

                
    <!-- footer starts -->
       
        <div class="footer"><span>©2013 eBusiness Team</span>
        </div>
    <!-- footer ends -->
</body>
</html>