<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("form").submit(function() {
			var id = $("#id").val();
			var name = $("#userName").val();
			alert(name);
			$.ajax({
				"url" : "${pageContext.request.contextPath}/updateUsers",
				"data" : {
					"id" : id,
					"userName" : name
				},
				"type" : "post",
				"dataType" : "text",
				success : function(result) {
					if (result == 1) {
						alert("修改成功!");
						//location.href="index.html";
					} else {
						alert("修改失败!");
					}
				},
				error : function() {
					alert("请求出错了");
				}
			})
		})

	});
</script>
</head>
<body>
	<h4>修改用户</h4>
	<br />
	<br />
	<br />
	<form action="javascript:;" method="post" id="addForm">
		<table border="1" width="20%" bgcolor="#e9faff" cellpadding="2">
			<tr>
				<td>ID</td>
				<td><input type="text" id="id" readonly name="id"
					value="${users.id}"></td>
			</tr>
			<tr>
				<td>用户名称</td>
				<td><input type="text" id="userName" name="userName"
					value="${users.userName}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="修改"/><input type="button" value="取消" id="return"/></td>
			</tr>
		</table>
	</form>
</body>
</html>