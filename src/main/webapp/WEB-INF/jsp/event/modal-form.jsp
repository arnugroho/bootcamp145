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
							<div class="box-header with-border">
								<h3 class="box-title">Adds Event</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<form role="form">
								<div class="box-body">
									<div class="form-group">
										<label for="code">Transaction Code</label> <input
											class="form-control" id="code" name="code"
											placeholder="Transaction Code" type="text">
									</div>
									<div class="form-group">
										<label for="eventName">Event Name</label> <input
											class="form-control" id="eventName" name="eventName"
											placeholder="eventName" type="text">
									</div>
									<div class="form-group">
										<label for="place">Place</label> <input class="form-control"
											id="place" name="place" placeholder="Place" type="text">
									</div>

									<div class="form-group">
										<label for="startDate">StartDate</label> <input
											class="form-control" id="startDate" name="startDate"
											placeholder="startDate" type="date">
									</div>

									<div class="form-group">
										<label for="endDate">End Date</label> <input
											class="form-control" id="endDate" name="endDate"
											placeholder="endDate" type="date">
									</div>
									<div class="form-group">
										<label for="evenetName">budget</label> <input
											class="form-control" id="budget" name="budget"
											placeholder="Budget" type="text">
									</div>
									<div class="form-group">
										<label for="requestBy">Request By</label> <input
											class="form-control" id="requestBy" name="requestBy"
											placeholder="requestBy" type="text">
									</div>
									<div class="form-group">
										<label for="requestDate">Request Date</label> <input
											class="form-control" id="requestDate" name="requestDate"
											type="date" disabled>

									</div>
									<div class="form-group">
										<label for="note">note</label>
										<textarea rows="12" cols="5px" class="form-control" id="note"
											name="note" placeholder="note" type="text"></textarea>
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

