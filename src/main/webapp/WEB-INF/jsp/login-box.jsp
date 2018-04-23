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

		<form id="formLogin" action="${contextName}/j_spring_security_check"
			method="post" data-parsley-validate>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}"> <input type="hidden" name="view"
				id="view">
			<div class="form-group has-feedback">
				<input type="text" class="form-control" name="username"
					placeholder="User Name"> <span
					class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" class="form-control" placeholder="Password"
					id="password"> <span
					class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="row">
				<div class="col-md-8"><p>Belum punya akun? <a data-toggle="modal" href="#registrasiUser">Daftar</a></p></div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<button type="submit" id="btnLogin"
						class="btn btn-primary btn-block btn-flat">Sign In</button>
				</div>

			</div>
		</form>
		<div class="modal fade" id="registrasiUser" role="dialog" data-parsley-validate>
		    <div class="modal-dialog">
		    	
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Registrasi User</h4>
		        </div>
		        <div class="modal-body">
		        	<form id="formRegistrasi" >
		        		<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}"> 
		        		<div class="form-group has-feedback">
							<input type="text" class="form-control username" name="username"
								placeholder="Username" required> <span
								class="glyphicon glyphicon-user form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<input type="password" id="registerPassword" name="password" class="form-control password" placeholder="Password" required> 
							<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						</div> 
						<div class="form-group has-feedback">
							<input type="password" name="retypePassword" class="form-control retypePassword" placeholder="Retype Password" data-parsley-equalto="#registerPassword"required> 
							<span class="glyphicon glyphicon-lock form-control-feedback">	</span>
						</div>       	
		        	</form>
		        </div>
		        <div class="modal-footer">
		        	<button type="button" id="btnDaftar" class="btn btn-primary">Daftar</button>
		       		<button type="button" class="btn btn-default" data-dismiss="modal">Batal</button>
		        </div>
		      </div>
		      
		    </div>
		  </div>

		<script type="text/javascript">
		var formReg = $("#formRegistrasi").parsley();
			$(function(){
				$("#formLogin").submit(function() {
					var pass = $("#password").val();
					$("#view").val(CryptoJS.MD5(pass).toString());
				});
				$("#btnDaftar").click(function(){
					var pass = $("#formRegistrasi .password").val();
					var rePass = $("#formRegistrasi .retypePassword").val();
					var user = $("#formRegistrasi .username").val();
					if(formReg.validate()){
						if(pass == rePass){
							$.ajax({
								type 	: "POST",
								url 	: '${contextName}/registrasi-user.json',
								data 	: {
											username : user,
											password : CryptoJS.MD5(pass).toString()
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

	</div>
	<!-- /.login-box-body -->
</div>
<!-- /.login-box -->