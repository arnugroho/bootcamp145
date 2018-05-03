<!-- Modal -->
<div class="modal fade" id="viewdata" role="dialog">
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
								<h3 class="box-title">View Event</h3>
							</div>
							
							<!-- /.box-header -->
							<!-- form start -->
							<form role="form">
								<div class="box-body">
									<div class="form-group col-md-6" >
										<label for="code">Transaction Code</label> <input
											class="form-control" id="code2" name="code"
											placeholder="Transaction Code" type="text" disabled>
									</div>
									<div class="form-group col-md-6">
										<label for="eventName">Event Name</label> <input
											class="form-control" id="eventName2" name="eventName"
											placeholder="eventName" type="text" disabled>
									</div>
									<div class="form-group col-md-6">
										<label for="place">Place</label> <input class="form-control"
											id="place2" name="place" placeholder="Place" type="text" disabled>
									</div>

									<div class="form-group col-md-6">
										<label for="startDate">StartDate</label> <input
											class="form-control" id="startDate2" name="startDate"
											placeholder="startDate" type="date" disabled>
									</div>

									<div class="form-group col-md-6">
										<label for="endDate">End Date</label> <input
											class="form-control" id="endDate2" name="endDate"
											placeholder="endDate" type="date" disabled>
									</div>
									
									<div class="form-group col-md-6">
										<label for="evenetName">budget</label> <input
											class="form-control"  id="budget2" name="budget"
											placeholder="Budget" type="text" disabled>
									</div>
									<div class="form-group col-md-6">
										<label for="requestBy">Request By</label> <input
											class="form-control" id="requestBy2" name="requestBy"
											placeholder="requestBy" type="text" disabled>
									</div>
									<div class="form-group col-md-6">
										<label for="requestDate">Request Date</label> <input
											class="form-control" id="requestDate2" name="requestDate"
											type="date" disabled>

									</div>
									<div class="col-md-6">
									<label for="assignTo">Assign To</label>
										<input rows="12" cols="5px" class="form-control" id="AssignTo"
											name="assignTo"  type="text" ></input>
									</div>
									<div class="form-group col-md-6">
										<label for="note">note</label>
										<textarea rows="6" cols="5px" class="form-control" id="note2"
											name="note" placeholder="note" type="text" disabled></textarea>
									</div>
									<div class="col-md-6">
									
									</div>
									<div class="form-group col-md-6">
										<label for="status">Status</label>
										<input rows="12" cols="5px" class="form-control" id="status2"
											name="status"  type="text" disabled></input>
									</div>
									<input
											class="form-control" id="idEvent" name="idEvent"
											 type="hidden">
									
								</div>
								<!-- /.box-body -->
							</form>
						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnAproved" class="btn btn-primary">Aproved</button>
				<button type="button" id="btnReject" class="btn btn-danger">Reject</button>
				<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


