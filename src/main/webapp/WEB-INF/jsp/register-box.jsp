<div class="login-box">
	<!-- /.login-logo -->
	<div class="login-logo">
		<img
			src="https://upload.wikimedia.org/wikipedia/id/2/25/LogoUNHAN.png"
			alt="Logo Image" height="130" class="img-responsive center-block"
			alt="Responsive image">
	</div>
	<div class="login-box-body">
		<p class="login-box-msg">Seleksi Dosen</p>
		<div align="center">
			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="MvB">${msg}</div>
			</c:if>
		</div>

		<form id="formRegister" >
			<div class="form-group has-feedback">
				<input type="text" class="form-control" name="usernameReg"
					placeholder="Username"> <span
					class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" class="form-control" placeholder="Password"
					id="passwordReg"> <span
					class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" class="form-control" placeholder="Repeat Password"
					id="repeatPasswordReg"> <span
					class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<button type="button" id="btnRegister"
						class="btn btn-primary btn-block btn-flat">Register</button>
				</div>

			</div>
		</form>

		<script type="text/javascript">
		$(function () {
			  var token = $("meta[name='_csrf']").attr("content");
			  var header = $("meta[name='_csrf_header']").attr("content");
			  $(document).ajaxSend(function(e, xhr, options) {
			    xhr.setRequestHeader(header, token);
			  });
		});
		$("#repeatPasswordReg").change(function() {
			if ($("#repeatPasswordReg").val() != $("#passwordReg").val()) {
				alert("Konfirmasi Gagal, Password Tidak Sama");
			}
		});
		
		$("#btnRegister").click(function() {
			if ($("#repeatPasswordReg").val() != $("#passwordReg").val()) {
				alert("Konfirmasi Gagal, Password Tidak Sama");
			}else{
				 $.ajax({
					type : "post",
					url : 'user-register.json',
					data : {
						password : CryptoJS.MD5($("#passwordReg").val()).toString(),
						username : "agus",
					},
					success : function(data) {
						if (data.success) {
							alert("Registrasi Berhasil");
							window.location.href='${contextName}/home.html';
						} else {
							alert("Register Gagal");
						}
						
					}
				}); 
				
			}
		});
		</script>

	</div>
	<!-- /.login-box-body -->
</div>
<!-- /.login-box -->