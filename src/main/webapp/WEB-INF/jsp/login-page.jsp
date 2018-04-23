<%@ include file="/taglibs.jsp"%>
<html>
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
	<div class="row">
	  	<div class="col-md-12" >
	   		<%@include file="login-box.jsp"%>
	  	</div>
	  	<%-- <div class="col-md-6" >
	   		<%@include file="register-box.jsp"%>
	  	</div> --%>
		
	</div>

</body>
</html>