<%--
  Created by IntelliJ IDEA.
  User: yg
  Date: 17/8/21
  Time: 上午9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>留言板</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <script src="js/jquery-3.0.0.js" type="text/javascript"></script>





</head>
<body>
<div class="container">
    <%--导航栏 通过 col-md-6 col-md-offset-1 改变布局--%>
    <%--<button type="button" class="btn btn-primary col-md-6 col-md-offset-1">（首选项）Primary</button>--%>

    <%--输入栏--%>
    <div class="input-group">
        <input id="content" type="text" class="form-control" placeholder="请输入留言...">
        <span class="input-group-btn">
        <button id="btn" class="btn btn-default" type="button">发送</button>
      </span>
    </div>
    <%--表格--%>
    <table id="tab" class="table table-hover">

    </table>
</div>
</body>

<script>
    getAllMessage();
    //展示所有信息


    function addNewTR(id, content, upCount, downCount, how) {
        var tdleft = $("<td></td>").html("<p>" + content + "</p>");
        var tdright = $("<td></td>");
        //父标签 append 子标签
        tdright.append("顶:");
        //子标签 appendTo 父标签
        $("<a href='#'></a>").html(upCount).appendTo(tdright);
        tdright.append("踩:");
        $("<a href='#'></a>").html(downCount).appendTo(tdright);
        //删除
        $("<a href='#'>删除</a>").appendTo(tdright).attr("num", id).click(delfunc);

        //将左右两个td添加到tr中
        //<tr id="ss3"></tr>
        var trOb = $("<tr></tr>").append(tdleft).append(tdright).attr("id", "ss" + id);

        //将生成的tr最终添加到写好的table中
        $("#tab").append(trOb)
    }

    function getAllMessage() {
        //从服务器请求数据到前端界面
        $.ajax({
            url: "/showAllMessage",
            success: function (result) {
                for (var i = 0; i < result.length; i++) {
                    //遍历返回的数据,一次在table中添加一行
                    var msg = result[i];
                    addNewTR(msg.id, msg.content, msg.up, msg.down, 0)
                }
            }
        })

    }


</script>

</html>
