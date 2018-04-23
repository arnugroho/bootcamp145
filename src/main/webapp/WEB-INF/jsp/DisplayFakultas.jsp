<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/taglibs.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1px>
		<thead>
			<tr>
				<th width="10%">ID</th>
				<th>Nama Fakultas</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fakultas" items="${fakultasCollection }">
				<tr>
					<td class="column_center">${fakultas.idFakultas }</td>
					<td>${fakultas.namaFakultas }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>