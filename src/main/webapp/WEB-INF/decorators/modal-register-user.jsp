<div class="modal fade" id="registrasiUser2" role="dialog"
	data-parsley-validate>
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Registrasi User</h4>
			</div>
			<div class="modal-body">
				<form id="formRegistrasiUser">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}">
					<div class="form-group has-feedback">
						Role Name <input type="text" class="form-control rolename"
							name="rolename" placeholder="Select Role Name" required>
						<span></span>
					</div>
					<div class="form-group has-feedback">
						Employee Name <input type="text" name="employeename"
							class="form-control employeename" placeholder="Select Employee"
							required> <span></span>
					</div>
					<div class="form-group has-feedback">
						Username<input type="text" class="form-control username" name="username"
							placeholder="Username" minlength="6" required> <span></span>
					</div>
					<div class="form-group has-feedback">
						Password<input type="password" id="registerPassword" name="password"
							class="form-control password" placeholder="Password"
							minlength="6" required> <span></span>
					</div>
					<div class="form-group has-feedback">
						Re-type Password<input type="password" name="retypePassword"
							class="form-control retypePassword" placeholder="Retype Password"
							data-parsley-equalto="#registerPassword" required> <span></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnDaftarUser" class="btn btn-primary">Save</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>

	</div>
</div>

