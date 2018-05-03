<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-form.jsp"%>
<%@ include file="modal-form2.jsp"%>
<!-- Trigger the modal with a button -->
<button type="button" id="btnTambah" class="btn btn-success btn-lg" data-toggle="modal"
	data-target="#modalFormEvent" >add</button>
<hr>
<table id="tableEvent" class="display" width="100%"></table>


<script type="text/javascript">
$(function(){
	$("#modalFormEvent")[0].reset();
	});
	
	$(document).ready(function() {
		prepareDatatable();

		//mendefinisikan ketika tombol btnInsert diklik memanggil insertData()
		$("#btnInsert").click(function() {
			$
			insertData();
		});

	});

	$("#btnUpdate").click(function() {

		updateData();

	});

	$("#btnTambah").click(function() {
		onclick
		$("#btnUpdate").hide();
		$('#btnInsert').show();
		$('#judulinsert').show();
		$('#judulupdate').hide();
		$('#status').hide();
		$('#labelstat').hide();
	});

	function insertData() {
		$.ajax({
			url : contextName + '/event/insert.json',
			data : {
				'code' : $("#code").val(),
				'eventName' : $("#eventName").val(),
				'place' : $("#place").val(),
				'startDate' : $("#startDate").val(),
				'endDate' : $("#endDate").val(),
				'budget' : $("#budget").val(),
				'note' : $("#note").val(),
			},
			type : 'post',
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$('#tableEvent').DataTable().destroy()
					prepareDatatable()
					// ------ //
					
					$('#modalFormEvent').modal('hide');
					// ----//

					notifySuccess('Berhasil Insert Data');
				} else {
					notifyError('Gagal Insert Data');
				}
			},
			error : function() {
				notifyError('Gagal Insert Data');
			}
		});
	}


		
	
	function updateEvent(idEvent){
		$('#btnInsert').hide();
		$('#btnUpdate').show();
		$('#judulinsert').hide();
		$('#judulupdate').show();
		$('#status').show();
		$('#labelstat').show();
		$('#modalFormEvent').modal('show');
		$.ajax({
			url : contextName + '/event/view.json',
			type : 'post',
			data : {
				idEvent : idEvent
			},
			dataType : 'json',
			success : function(result) {
				if(result.success){
					$("#code").val(result.event.code)
					$("#eventName").val(result.event.eventName)
					$("#place").val(result.event.place)
					$("#startDate").val(result.event.startDate)
					$("#endDate").val(result.event.endDate)
					$("#budget").val(result.event.budget)
					$("#requestBy").val(result.event.requestBy)
					$("#requestDate").val(result.event.requestDate)
					$("#status").val(result.event.statusDesc.status)
					$("#idEvent").val(result.event.id)
					
					notifySuccess('Berhasil Menampilkan Data');
				}else {
					notifyError('Gagal Menampilkan Data');
				}
			},
			error : function() {
				notifyError('Gagal Menampilkan Data');
			}
		});
	}
	
	function updateData() {
		$.ajax({
			url : contextName + '/event/update.json',
			data : {
				'code' : $("#code").val(),
				'eventName' : $("#eventName").val(),
				'place' : $("#place").val(),
				'startDate' : $("#startDate").val(),
				'endDate' : $("#endDate").val(),
				'budget' : $("#budget").val(),
				'note' : $("#note").val(),
				'id' : $("#idEvent").val(),
			},
			type : 'post',
			dataType : 'json',
			success : function(result) {
				if(result.success){
					//agar table ter refresh
					$('#tableEvent').DataTable().destroy()
					prepareDatatable()
					// ------ //
					
					//modal di hide 
					$('#modalFormEvent').modal('hide');
					// ----//
					
					
					notifySuccess('Berhasil Update Data');
				}else {
					notifyError('Gagal Update Data');
				}
			},
			error : function() {
				notifyError('Gagal Update Data');
			}
		});
	}
	
	function prepareDatatable() {
		$
				.ajax({
					url : contextName + '/event/get-data.json',
					type : 'post',
					dataType : 'json',
					success : function(result) {
						if (result.success) {

							// proses merubah array objeck menjadi array array
							//{{},{}} menjadi {[],[]}
							var listEvent = $.map(result.listEvent, function(
									value, index) {
								return [ Object.values(value) ];
							});

							var dataSet = listEvent;

							$('#tableEvent')
									.DataTable(
											{
												data : dataSet,
												columns : [ {
													title : "Transaction Code"
												}, {
													title : "Event Name"
												}, {
													title : "Request By"
												}, {
													title : "Request Date"
												}, {
													title : "Due Date"
												}, {
													title : "Status"
												}, {
													title : "Created Date"
												}, {
													title : "Create By"
												}, {
													title : "Action"
												} ],
												"columnDefs" : [ {
													// The `data` parameter refers to the data for the cell (defined by the
													// `data` option, which defaults to the column being worked with, in
													// this case `data: 0`.
													"render" : function(data,
															type, row) {
														var s = '<button type="button" onClick="deleteEvent('+ data + ')">'															
														s = s+ ' <i class="fa fa-trash"></i> </button>'
														
														s += '<button type="button"  onClick="updateEvent('+ data + ')">'
														s += '<i class="fa fa-edit"></i> </button>'
		
														s += '<button type="button"  onClick="view('+ data + ')">'
														s += '<i class="fa fa-search"></i> </button>'
														return s;
													},
													// column keberapa render diaplikasikan
													"targets" : 8
												} ]
											});

							notifySuccess('Berhasil Create Table');
						} else {
							notifyError('Gagal Create Table');
						}
					},
					error : function() {
						notifyError('Gagal Create Table');
					}
				});
	}

	function deleteEvent(idEvent) {
		$.ajax({
			url : contextName + '/event/delete.json',
			type : 'post',
			data : {
				idEvent : idEvent
			},
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					
					//agar table ter refresh
					$('#tableEvent').DataTable().destroy()
					prepareDatatable()
					// ------ //

					notifySuccess('Berhasil Delete Data');
				} else {
					notifyError('Gagal Delete Data');
				}
			},
			error : function() {
				notifyError('Gagal Delete Data');
			}
		});
	}


	function view(idEvent){
		$('#labelstat').show();
		$('#viewdata').modal('show');
		 			$.ajax({
			url : contextName + '/event/view.json',
			type : 'post',
			data : {
				idEvent : idEvent
			},
			dataType : 'json',
			success : function(result) {
				 if(result.success){
					 $("#code2").val(result.event.code)
					$("#eventName2").val(result.event.eventName)
					$("#place2").val(result.event.place)
					$("#startDate2").val(result.event.startDate)
					$("#endDate2").val(result.event.endDate)
					$("#budget2").val(result.event.budget)
					$("#requestBy2").val(result.event.requestBy)
					$("#requestDate2").val(result.event.requestDate)
					$("#status2").val(result.event.statusDesc.status)
					$("#idEvent").val(result.event.id)
					
				 	notifySuccess('Berhasil Menampilkan Data');
				}else {
					notifyError('Gagal Menampilkan Data');
				}
			},
			error : function() {
				notifyError('Gagal Menampilkan Data');
			}
		}); 
	}
	
	
</script>


















