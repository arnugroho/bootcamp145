 <!-- Modal -->
<div class="modal fade" id="registerCompany" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Insert Company</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div class="box box-primary">
							<!-- /.box-header -->
							<!-- form start -->
							<form role="form">
								<div class="box-body">
									<div class="form-group">
										<label for="code">Company Code</label> <input
											class="form-control" id="code" name="code"
											placeholder="Company Code" type="text">
									</div>
									<div class="form-group">
										<label for="name">Company Name</label> <input
											class="form-control" id="name" name="name"
											placeholder="Company Name" type="text">
									</div>
									<div class="form-group">
										<label for="name">Email</label> <input
											class="form-control" id="email" name="email"
											placeholder="Email" type="text">
									</div>
									<div class="form-group">
										<label for="name">Phone</label> <input
											class="form-control" id="phone" name="phone"
											placeholder="Phone" type="text">
									</div>
									<div class="form-group">
										<label for="name">Address</label> <input
											class="form-control" id="address" name="address"
											placeholder="Address" type="text">
									</div>
									<input
											class="form-control" id="idCompany" name="idCompany" 
											type="hidden">
								</div>
								<!-- /.box-body -->
							</form>
						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnInsert" class="btn btn-primary">Save</button>
				<button type="button" id="btnUpdate" class="btn btn-primary">Update</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>