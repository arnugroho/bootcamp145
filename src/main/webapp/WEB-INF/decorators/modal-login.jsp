
<div class="modal fade" id="loginUser" role="dialog"
	data-parsley-validate>
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Login User</h4>
			</div>
			<div class="modal-body">
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
			</div>
		</div>

	</div>
</div>