<!-- Modal -->
<div class="modal fade" id="modalFormMenu" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Form Menu</h4>
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
										<label for="code">Code</label> <input
											class="form-control" id="code" name="code"
											placeholder="Auto Generated" type="text" disabled>
									</div>								

									<div class="form-group">
										<label for="name">Nama Menu</label> <input
											class="form-control" id="name" name="name"
											placeholder="Nama Menu" type="text">
									</div>
									<div class="form-group">
										<label for="controller">Controller</label> <input
											class="form-control" id="controller" name="controller"
											placeholder="Controller" type="text">
									</div>
									
									<div class="form-group">
										<label for="controller">Created By</label> <input
											class="form-control" id="created" name="created"
											placeholder="Created By" type="text" disabled>
									</div>
									
									<input
											class="form-control" id="mId" name="mId"
											 type="hidden">

								</div>
								<!-- /.box-body -->

							</form>
						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnInsert" class="btn btn-primary">Insert</button>
				<button type="button" id="btnUpdate" class="btn btn-primary">Update</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>