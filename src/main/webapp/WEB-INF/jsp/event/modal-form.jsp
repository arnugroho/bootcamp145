<!-- Modal -->
<div class="modal fade" id="modalFormEvent" role="dialog">
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
							<form role="form" id="form">
								<div class="box-body">
									<div class="form-group col-md-6" >
										<label for="code">Transaction Code</label> <input
											class="form-control" id="code" name="code"
											placeholder="Auto Generate" type="text" Disabled>
									</div>
									<div class="form-group col-md-6">
										<label for="eventName">Event Name</label> <input
											class="form-control" id="eventName" name="eventName"
											placeholder="eventName" type="text">
									</div>
									<div class="form-group col-md-6">
										<label for="place">Place</label> <input class="form-control"
											id="place" name="place" placeholder="Place" type="text">
									</div>

									<div class="form-group col-md-6">
										<label for="startDate">StartDate</label> <input
											class="form-control" id="startDate" name="startDate"
											placeholder="startDate" type="date">
									</div>

									<div class="form-group col-md-6">
										<label for="endDate">End Date</label> <input
											class="form-control" id="endDate" name="endDate"
											placeholder="endDate" type="date">
									</div>
									
									<div class="form-group col-md-6">
										<label for="evenetName">budget</label> <input
											class="form-control" pattern="[0-9]+"title=" numeric characters only" id="budget" name="budget"
											placeholder="Budget" type="text">
									</div>
									<div class="form-group col-md-6">
										<label for="requestBy">Request By</label> <input
											class="form-control" id="requestBy" name="requestBy"
											placeholder="requestBy" type="text" disabled>
									</div>
									<div class="form-group col-md-6">
										<label for="requestDate">Request Date</label> <input
											class="form-control" id="requestDate" name="requestDate"
											type="text" disabled>

									</div>
									<div class="col-md-6"></div>
									<div class="form-group col-md-6">
										<label for="note">note</label>
										<textarea rows="6" cols="5px" class="form-control" id="note"
											name="note" placeholder="note" type="text"></textarea>
									</div>
									<div class="col-md-6"></div>
									<div class="form-group col-md-6">
										<label for="status" id="labelstat">Status</label>
										<input rows="12" cols="5px" class="form-control" id="status"
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
				<button type="button" id="btnInsert" class="btn btn-primary">Insert</button>
				<button type="button" id="btnUpdate" class="btn btn-primary">Update</button>
				<button type="button" id="btnClose" class="btn btn-default" data-dismiss="modal" value="reset">Close</button>
			</div>
		</div>
	</div>
</div>


