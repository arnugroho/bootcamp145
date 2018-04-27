<div class="modal fade" id="modalAdd" role="dialog"
	data-parsley-validate>
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Add Marketing Promotion</h4>
			</div>
			<div class="modal-body">
				<form id="formAdd">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}">
					<div class="form-group has-feedback">
						<input type="text" class="form-control username" name="event"
							placeholder="Code Event"> <span
							class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="email" name="email" class="form-control email"
							placeholder="Email" required> <span
							class="glyphicon glyphicon-envelope form-control-feedback">
						</span>
					</div>
					<div class="form-group has-feedback">
						<input type="hidden" id="registerPassword" name="password"
							placeholder="Password" minlength="6" required> <span></span>
					</div>
					<button type="button" id="btnDaftar" class="btn btn-primary">Next</button>
					<button type="reset" class="btn btn-warning" data-dismiss="modal" value="reset">Cancel</button>
				</form>
			</div>
			<div class="modal-footer">
<!-- 				<button type="button" id="btnDaftar" class="btn btn-primary">Next</button> -->
<!-- 				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button> -->
			</div>
		</div>

	</div>
</div>

