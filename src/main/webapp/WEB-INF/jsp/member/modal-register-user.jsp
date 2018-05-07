<!-- Modal -->
<div class="modal fade" id="registerUser2" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Form Event</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">

						<div class="box box-primary">
							<div id="judulinsert" class="box-header with-border">
								<h3 class="box-title">Adds Event</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<form role="form">
								<div class="box-body">
									<div class="form-group col-md-6">
										<label>Role Name</label> <input class="form-control" id="name"
											name="name" placeholder="Select Role Name" type="text">
									</div>
									<div class="form-group col-md-6">
										<label>Username</label> <input class="form-control"
											id="username" name="username" placeholder="Type Username"
											type="text">
									</div>
									<div class="form-group col-md-6">
										<label>Employee Name</label> <input class="form-control"
											id="employeeName" name="employeeName"
											placeholder="Select Employee" type="text">
									</div>
									<div class="form-group col-md-6">
										<label>Password</label><input class="form-control"
											id="regisPassword" name="regisrPassword"
											placeholder="Password" type="password">
									</div>
									<div class="col-md-6"></div>
									<div class="form-group col-md-6">
										<label>Retype Password</label> <input class="form-control"
											id="retypePassword" name="retypePassword"
											placeholder="Retype Password" type="password">
									</div>
									--> <input class="form-control" id="idUser" name="idUser"
										type="hidden">

								</div>
								<!-- /.box-body -->
							</form>
						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnInsert" class="btn btn-primary">Daftar</button>
				<button type="button" id="btnUpdate" class="btn btn-primary">Update</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>






<%-- <div class="modal fade" id="registerUser2" role="dialog"
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
					<div class="form-group has-feedback col-md-6">
						<input type="text" class="form-control username" name="username"
							placeholder="Username" minlength="6" required>
					</div>
					<div class="form-group has-feedback col-md-6">
						<input type="password" id="registerPassword" name="password"
							class="form-control password" placeholder="Password" minlength="6" required>
					</div>
					
					
					<div class="form-group has-feedback col-md-6">
						<input type="password" name="retypePassword"
							class="form-control retypePassword" placeholder="Retype Password"
							data-parsley-equalto="#registerPassword" required>
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
 --%>
