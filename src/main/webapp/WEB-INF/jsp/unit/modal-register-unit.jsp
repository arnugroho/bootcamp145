 <!-- Modal -->
<div class="modal fade" id="registerUnit" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Insert Unit</h4>
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
										<label for="code">Unit Code</label> <input
											class="form-control" id="code" name="code"
											placeholder="Unit Code" type="text">
									</div>
									<div class="form-group">
										<label for="name">Unit Name</label> <input
											class="form-control" id="name" name="name"
											placeholder="Unit Name" type="text">
									</div>
									<div class="form-group">
										<label for="name">Description</label> <input
											class="form-control" id="description" name="description"
											placeholder="Description" type="text">
									</div>
								</div>
								<!-- /.box-body -->
							</form>
						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnInsert" class="btn btn-primary">Insert</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>