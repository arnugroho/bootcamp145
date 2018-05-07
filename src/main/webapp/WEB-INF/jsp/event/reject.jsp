<!-- Modal -->
<div class="modal fade" id="reject" role="dialog">
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
							<div id="judulupdate" class="box-header with-border">
								<h3 class="box-title">Update Event</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<form role="form">
								<div class="box-body">
									<div class="form-group col-md-6" >
										<label for="code">Reject reason</label> <input
											class="form-control" id="code" name="code"
											placeholder="Auto Generate" type="text" Disabled>
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


