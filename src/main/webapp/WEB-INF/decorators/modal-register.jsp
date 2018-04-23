<div class="modal fade" id="registrasiUser" role="dialog"
	data-parsley-validate>
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Registrasi User</h4>
			</div>
			<div class="modal-body">
				<form id="formRegistrasi">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}">
					<div class="form-group has-feedback">
						<input type="text" class="form-control username" name="username"
							placeholder="Username" minlength="6" required> <span
							class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="email" name="email"
							class="form-control email" placeholder="Email" required> 
							<span class="glyphicon glyphicon-envelope form-control-feedback"> </span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" id="registerPassword" name="password"
							class="form-control password" placeholder="Password" minlength="6" required>
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" name="retypePassword"
							class="form-control retypePassword" placeholder="Retype Password"
							data-parsley-equalto="#registerPassword" required> <span
							class="glyphicon glyphicon-lock form-control-feedback"> </span>
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

