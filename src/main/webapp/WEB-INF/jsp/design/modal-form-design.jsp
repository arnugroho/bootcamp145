<!-- Modal -->
<div class="modal fade" id="modalFormDesign" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<!-- <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Add Design Request</h4>
			</div> -->
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">Add Design Request</h3>
							</div>
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">
									<br>

										<form class="form-horizontal">
											<div class="form-group">
													<label class="col-sm-3 control-label"><span class="required">*</span> Transaction Code</label>
												<div class="col-md-3">
													<input type="text" class="form-control" id="transactionCode"
															placeholder="Harusnya Auto Generated" name="transactionCode">
												</div>
												
													<label class="col-sm-2 control-label"><span class="required">*</span> Request By</label>
												<div class="col-md-3">
													<input type="text" class="form-control" id="requestBy"
															placeholder="Harusnya Session User Login" name="requestBy">
												</div>
											</div>
											
											<div class="form-group">
													<label class="col-sm-3 control-label"><span class="required">*</span> Event Code</label>
												<div class="col-md-3">
													<input type="text" class="form-control" id="eventCode"
															placeholder="Dropdown dari t_event" name="eventCode">
												</div>
												
													<label class="col-sm-2 control-label"><span class="required">*</span> Request Dare</label>
												<div class="col-md-3">
													<input type="text" class="form-control" id="requestDate"
															placeholder="Harusnya Tanggal Sekarang" name="requestDate">
												</div>
											</div>
											
											<div class="form-group">
													<label class="col-sm-3 control-label"><span class="required">*</span> Design Title</label>
												<div class="col-md-3">
													<input type="text" class="form-control" id="designTitle"
															placeholder="Type Title" name="designTitle">
												</div>
												
													<label class="col-sm-2 control-label"><span class="required">*</span> Note</label>
												<div class="col-md-3">
													<textarea class="form-control" id="note"
															placeholder="Type Note" name="note"></textarea>
												</div>
											</div>

										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnInsert" class="btn btn-primary">Save</button>
				<button type="button" class="btn btn-warning" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>