<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ include file="/taglibs.jsp"%>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.username" var="username" />
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <sec:authentication property="principal" var="username" />
</sec:authorize>
<!DOCTYPE html>
<!-- main.jsp decorator //-->
<html>
<head>
	<meta name="_csrf" content="${_csrf.token}" />
	<meta name="_csrf_header" content="${_csrf.headerName}" />
	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<!-- Tell the browser to be responsive to screen width -->
  	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<title>BootCamp <decorator:title/></title>
	<!-- Bootstrap -->
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
  	 <!-- Font Awesome -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  	<!-- <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet"> -->
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
	
	<!-- Default required-Jquery -->
	<script src="${contextName}/assets/js/default-jquery.js"></script>
	
	<!-- Parsley.js-2.8.1-->
	<script src="${contextName}/assets/Parsley.js-2.8.1/dist/parsley.min.js"></script>
	<script src="${contextName}/assets/Parsley.js-2.8.1/dist/i18n/id.js"></script>
	<script src="${contextName}/assets/Parsley.js-2.8.1/dist/i18n/id.extra.js"></script>
	<link rel="stylesheet" href="${contextName}/assets/Parsley.js-2.8.1/dist/parsley.css"/>
	
	<!-- -Select2 -->
	<script src="${contextName}/assets/plugins/select2/select2.full.min.js"></script>
	<script src="${contextName}/assets/plugins/select2/i18n/id.js"></script>
	<link rel="stylesheet" href="${contextName}/assets/plugins/select2/select2.min.css"/>
	
	<!-- -Date Picker -->
	<script src="${contextName}/assets/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script src="${contextName}/assets/plugins/datepicker/locales/bootstrap-datepicker.id.js"></script>
	<link rel="stylesheet" href="${contextName}/assets/plugins/datepicker/datepicker3.css"/>
	
	<!-- -Dropzone-  -->
	<link href="${contextName}/assets/plugins/dropzone/dropzone.css" rel="stylesheet"/>
    <script src="${contextName}/assets/plugins/dropzone/dropzone.js"></script>
    
    <!-- -Datatables- -->
    <link href="${contextName}/assets/plugins/datatables/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet"/>
<%--     <link href="${contextName}/assets/plugins/datatables/1.10.7/css/jquery.dataTables.min.css" rel="stylesheet"/> --%>
	<script src="${contextName}/assets/plugins/datatables/1.10.7/js/jquery.dataTables.min.js"></script>
	
	<!-- Register Dosen -->
	<script src="${contextName}/assets/js/form/dosen-register.js"></script>
	
	<script type="text/javascript">
		var header = $("meta[name='_csrf_header']").attr("content");
		var token = $("meta[name='_csrf']").attr("content");
		var contextName = '${contextName}';
		$(document).ajaxSend(function(event, jqxhr, settings){
			jqxhr.setRequestHeader(header, token);
			$.LoadingOverlay("show");
		});
		$(document).ajaxComplete(function(event, jqxhr, settings){
			$.LoadingOverlay("hide");
		});
	</script>
<decorator:head/>
</head>
<body class="hold-transition skin-red sidebar-mini">
	<div class="wrapper">
		<!-- Header -->
		<%@include file="header.jsp" %>
		
		<!-- Sidebar -->
		<%@include file="sidebar.jsp" %>
		
		<!-- content -->
		<div class="content-wrapper">
			 <!-- Content Header (Page header) -->
		    <!-- <section class="content-header">
		      <h1>
		        Dashboard
		        <small>Control panel</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		        <li class="active">Dashboard</li>
		      </ol>
		    </section> -->
		    
		    <!-- Main content -->
	    	<section class="content">
	    		<sec:authorize access="!hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN','ROLE_USERSD')">
				
				<div class="callout callout-warning">
					<h4>Anda Belum Login</h4>
					<p>Sudah punya akun? <a data-toggle="modal" href="#loginUser">Login</a>
					, Belum punya akun? <a data-toggle="modal" href="#registrasiUser">Daftar</a></p>
				</div>
				
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN','ROLE_USERSD')">
					<div class="callout callout-info">
						<h4>Selamat Datang , ${username}</h4>
					</div>
				</sec:authorize>
	    	
	    		<div id="messageRegister"></div>
	    		<decorator:body/>
	    	</section>
		</div>
		<%@include file="modal-login.jsp" %>
		<%@include file="modal-register.jsp" %>
		<%@include file="modal-register-dosen.jsp" %>
		<%@include file="footer.jsp" %>
		
		<%-- <%@include file="controlSidebar.jsp" %> --%>
	</div>
	
	
	<!-- jQuery UI 1.11.4 -->
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script> -->
	<!-- Bootstrap 3.3.7 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- CharJS -->
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.1/Chart.min.js"></script> -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/fastclick/1.0.6/fastclick.min.js"></script>
	
	<!-- PNotify -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pnotify/3.2.1/pnotify.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pnotify/3.2.1/pnotify.buttons.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pnotify/3.2.1/pnotify.nonblock.js"></script>
	
	<!-- AdminLTE App -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/js/app.min.js"></script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/js/demo.js"></script> -->
	
	
	

	
	
	<script type="text/javascript">
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script type="text/javascript">
		var formReg = $("#formRegistrasi").parsley();
		$(function(){
			$("#formLogin").submit(function() {
				var pass = $("#password").val();
				$("#view").val(CryptoJS.MD5(pass).toString());
			});
			$("#registrasiUser").on("hidden.bs.modal", function(){
				$("#formRegistrasi")[0].reset();
			});
			$("#btnDaftar").click(function(){
				var pass = $("#formRegistrasi .password").val();
				var rePass = $("#formRegistrasi .retypePassword").val();
				var user = $("#formRegistrasi .username").val();
				var email = $("#formRegistrasi .email").val();
				if(formReg.validate()){
					if(pass == rePass){
						$.ajax({
							type 	: "POST",
							url 	: '${contextName}/registrasi-user.json',
							data 	: {
										username : user,
										password : CryptoJS.MD5(pass).toString(),
										email : email
							},
							beforeSend : function(xhr){
								xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'));
							},
							success : function(data){
								if(data.success){
									notifySuccess(data.message);
									$("#registrasiUser").modal("hide");
								} else{
									notifyError(data.message);
								}
							}
						});
					} else {
						notifyError("Retype password tidak sama dengan password yang anda masukkan!");
					}	
				}
			});
		});
	</script>
</body>
</html>
