<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
		function del(id) {
			alert(id);
			if (confirm("确认删除吗？")) {
				$.ajax({
					type : "GET",
					url : "${pageContext.request.contextPath}/delUsers",
					data : {"id" : id},
					dataType : "text",
					success : function(result) {
						if (1 == result) {
							alert("删除成功!");
						} else {
							alert("删除失败!");
						}
					}
				});
			}
		}
		
		

</script>

</head>
<body>
	<a href="${pageContext.request.contextPath}/add">添加用户</a>
	<br />
	<br />
	<br />
	<table border="1" width="20%" bgcolor="#e9faff" cellpadding="2">
		<tr>
			<td>ID</td>
			<td>用户名字<br /></td>
			<td>操作</td>
		</tr>
		<c:forEach var="users" items="${list}">
			<tr>
				<td>${users.id}</td>
				<td>${users.userName}</td>
				<td><a href="${pageContext.request.contextPath}/getById?id=${users.id}">修改</a>/<button onclick="del('${users.id}')">删除</button><br/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>