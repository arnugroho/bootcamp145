<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/taglibs.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1px>
		<thead>
			<tr>
				<td>ID</td>
				<td>Nama Ruangan</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ruangan" items="${ruanganCollection }">
				<tr>
					<td class="column_center">${ruangan.idRuangan }</td>
					<td>${ruangan.namaRuangan }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>