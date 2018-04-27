<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Seleksi Dosen</title>
<meta name="google-site-verification" content="0JMux7ujztTpC1R_z8F4jQ-1Z7erN6HnOz1MGrJgsSc" />
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<!-- ... -->
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap -->
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
  	 <!-- Font Awesome -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  	<!-- Ionicons -->
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  	<!-- Theme style -->
	<link rel="stylesheet" href=https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/css/AdminLTE.min.css>
	<!-- AdminLTE Skins. Choose a skin from the css/skins
	folder instead of downloading all of them to reduce the load. -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/css/skins/_all-skins.min.css">
	<!-- iCheck -->
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/iCheck/1.0.2/skins/flat/blue.css">
  	<!-- Date Picker -->
  	<!-- jQuery 2.2.3 -->
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css"/>

	<!-- PNotify -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/pnotify/3.2.1/pnotify.css" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/pnotify/3.2.1/pnotify.buttons.css" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/pnotify/3.2.1/pnotify.nonblock.css" rel="stylesheet">
	
	
	<%-- <link rel="stylesheet" href="${contextName}/assets/css/header.css"> --%>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>
	<script src="${contextName}/assets/js/default.js"></script>
	
	<!-- Parsley.js-2.8.1-->
	<script src="${contextName}/assets/Parsley.js-2.8.1/dist/parsley.js"></script>
	<script src="${contextName}/assets/Parsley.js-2.8.1/dist/i18n/id.js"></script>
	<script src="${contextName}/assets/Parsley.js-2.8.1/dist/i18n/id.extra.js"></script>
	<link rel="stylesheet" href="${contextName}/assets/Parsley.js-2.8.1/dist/parsley.css"/>
	
	<!-- -Select2 -->
	<script src="${contextName}/assets/plugins/select2/select2.full.min.js"></script>
	<script src="${contextName}/assets/plugins/select2/i18n/id.js"></script>
	<link rel="stylesheet" href="${contextName}/assets/plugins/select2/select2.min.css"/>
	
	<!-- PNotify -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pnotify/3.2.1/pnotify.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pnotify/3.2.1/pnotify.buttons.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pnotify/3.2.1/pnotify.nonblock.js"></script>
	
	<!-- -Date Picker -->
	<script src="${contextName}/assets/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script src="${contextName}/assets/plugins/datepicker/locales/bootstrap-datepicker.id.js"></script>
	<link rel="stylesheet" href="${contextName}/assets/plugins/datepicker/datepicker3.css"/>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.min.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-red login-page layout-top-nav">
	<div class="wrapper">
		<!-- Header -->
		<header class="main-header">
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top"></nav>
		</header>

		<!-- content -->
		<div class="content-wrapper">
		    
		    <!-- Main content -->
	    	<section class="content">
	    		<decorator:body></decorator:body>
	    	</section>
		</div>
		
		<%@include file="footer.jsp" %>
		
	</div>
	
	

	<!-- jQuery 3.2.1 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
