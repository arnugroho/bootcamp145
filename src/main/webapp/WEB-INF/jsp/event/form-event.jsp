<%@ include file="/taglibs.jsp"%>
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
						<label for="startDate">StartDate</label> <input class="form-control"
							id="startDate" name="startDate" placeholder="startDate" type="date">
					</div>
					
					<div class="form-group">
						<label for="endDate">End Date</label> <input class="form-control"
							id="endDate" name="endDate" placeholder="endDate" type="date">
					</div>
					<div class="form-group">
						<label for="evenetName">budget</label> <input class="form-control"
							id="budget" name="budget" placeholder="Budget" type="text">
					</div>
					<div class="form-group">
						<label for="requestDate">Request By</label> <input class="form-control"
							id="requestBy" name="requestBy" placeholder="requestBy" type="text">
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="button" id="btnInsert" class="btn btn-primary">Insert</button>
				</div>
			</form>
		</div>
	</div>

</div>

<script type="text/javascript">
	//mendefinisikan ketika tombol btnInsert diklik memanggil insertData()
	$("#btnInsert").click(function() {
		insertData();
	});

	function insertData() {
			$.ajax({
				url : contextName + '/event/insert.json',
				data : {
					'code' : $("#code").val(),
// 					'eventName' : $("#eventName").val(),
// 					'place':$("#place").val(),
// 					'startDate':$("#startDate").val(),
// 					'endDate':$("#endDate").val(),
// 					'budget':$("#budget").val(),
// 					'requestBy':$("#requestBy").val(),
				},
				type : 'post',
				dataType : 'json',
				success : function(result) {
					if(result.success){
						notifySuccess('Berhasil Insert Data');
					}else {
						notifyError('Gagal Insert Data');
					}
				},
				error : function() {
					notifyError('Gagal Insert Data');
				}
			});
	}
</script>


















