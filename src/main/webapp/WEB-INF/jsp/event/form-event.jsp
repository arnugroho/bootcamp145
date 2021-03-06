<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-form.jsp"%>
<%@ include file="modal-form2.jsp"%>
<%@ include file="reject.jsp"%>
<!-- Trigger the modal with a button -->
<button type="button" id="btnTambah" class="btn btn-success btn-lg"
	data-toggle="modal" data-target="#modalFormEvent">add</button>
<hr>
<table id="tableEvent" class="display" width="100%"></table>
<div id="notif"></div>

<script type="text/javascript">
	//============RESET===========================		
	$("#btnClose").click(function() {
		document.getElementById("form").reset();
	});

	$("#btnClose2").click(function() {
		document.getElementById("form2").reset();
	});

	$("#closeReject").click(function() {
		document.getElementById("formReject").reset();
	});

	//==========BUTTON REJECT=================	

	$("#btnReject").click(function() {
		$('#rejectForm').modal('show');

	});

	$("#btnSaveReject").click(function() {
		insertReject();

	});

	//===================CLOSE PROJECT========================	
			$("#btnDone").click(function() {
		updateDone();

	});
	
		function updateDone() {
			$.ajax({
				url : contextName + '/event/updateDone.json',
				data : {
					'assignTo' : $("#assignTo").val(),
					'id' : $("#idEvent").val(),
				},
				type : 'post',
				dataType : 'json',
				success : function(result) {
					if (result.success) {
						//agar table ter refresh
						$('#tableEvent').DataTable().destroy()
						prepareDatatable()
						// ------ //

						//modal di hide 
						$('#viewdata').modal('hide');
						// ----//

						notifySuccess('Berhasil Update Data');
					} else {
						notifyError('Gagal Update Data');
					}
				},
				error : function() {
					notifyError('Gagal Update Data');
				}
			});
		}

	
	//==========================APPROVED==============================	
		$("#btnAproved").click(function() {
		updateAproved();

	});
	
		function updateAproved() {
			$.ajax({
				url : contextName + '/event/updateAproved.json',
				data : {
					'assignTo' : $("#assignTo").val(),
					'id' : $("#idEvent").val(),
				},
				type : 'post',
				dataType : 'json',
				success : function(result) {
					if (result.success) {
						//agar table ter refresh
						$('#tableEvent').DataTable().destroy()
						prepareDatatable()
						// ------ //

						//modal di hide 
						$('#viewdata').modal('hide');
						// ----//

						notifySuccess('Berhasil Update Data');
					} else {
						notifyError('Gagal Update Data');
					}
				},
				error : function() {
					notifyError('Gagal Update Data');
				}
			});
		}


		//====================INSERT REJECT============================
		function insertReject() {
			$.ajax({
				url : contextName + '/event/updateReject.json',
				data : {
					'assignTo' : $("#assignTo").val(),
					'rejectReason' : $("#rejectReason").val(),
					'id' : $("#idEvent").val(),
				},
				type : 'post',
				dataType : 'json',
				success : function(result) {
					if (result.success) {
						//agar table ter refresh
						$('#tableEvent').DataTable().destroy()
						prepareDatatable()
						// ------ //

						//modal di hide 
						$('#rejectForm').modal('hide');
						// ----//

						notifySuccess('Berhasil Update Data');
					} else {
						notifyError('Gagal Update Data');
					}
				},
				error : function() {
					notifyError('Gagal Update Data');
				}
			});
		}

		
		
		
		// =========================INSERT DATA=========================

	$("#btnTambah").click(function() {
		prepareForm();
		$("#btnUpdate").hide();
		$('#btnInsert').show();
		$('#judulinsert').show();
		$('#judulupdate').hide();
		$('#status').hide();
		$('#labelstat').hide();
	});

	$(document).ready(function() {
		prepareDatatable();

		//mendefinisikan ketika tombol btnInsert diklik memanggil insertData()
		$("#btnInsert").click(function() {
			$
			insertData();
		});

	});

	function prepareForm() {
		$.ajax({
			url : contextName + '/event/prepare-form.json',
			type : 'post',
			dataType : 'json',
			success : function(result) {

				var requestBy = result.requestBy;
				$('#requestBy').val(requestBy);

				var requestDate = result.requestDate;
				$('#requestDate').val(requestDate);

				notifySuccess('Berhasil Prepare Form');

			},
			error : function() {
				notifyError('Gagal Prepare Form');
			}
		});
	}

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
					$('#notif').html("berhasil hore")
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

	//=====================UPDATE DATA============================
	$("#btnUpdate").click(function() {

		updateData();

	});

	function updateEvent(idEvent) {
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
				if (result.success) {
					$("#code").val(result.event.code)
					$("#eventName").val(result.event.eventName)
					$("#place").val(result.event.place)
					$("#startDate").val(result.event.startDate)
					$("#endDate").val(result.event.endDate)
					$("#budget").val(result.event.budget)
					$("#requestBy").val(result.event.requestBy)
					$("#requestDate").val(result.event.requestDate)
					$("#status").val(result.event.statusDesc.status)
					$("#note").val(result.event.note)
					$("#idEvent").val(result.event.id)

					notifySuccess('Berhasil Menampilkan Data');
				} else {
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
				if (result.success) {
					//agar table ter refresh
					$('#tableEvent').DataTable().destroy()
					prepareDatatable()
					// ------ //

					//modal di hide 
					$('#modalFormEvent').modal('hide');
					// ----//

					notifySuccess('Berhasil Update Data');
				} else {
					notifyError('Gagal Update Data');
				}
			},
			error : function() {
				notifyError('Gagal Update Data');
			}
		});
	}

	//==============================TABEL VIEW=============================	
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
														var s = '<button type="button" onClick="view('
																+ data + ')">'
														s = s
																+ ' <i class="fa fa-search"></i> </button>'

														s += '<button type="button"  onClick="updateEvent('
																+ data + ')">'
														s += '<i class="fa fa-pencil"></i> </button>'

														/* 	s += '<button type="button"  onClick="view('+ data + ')">'
															s += '<i class="fa fa-search"></i> </button>' */
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


	//======================DELETE EVENT===========================
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

	//=================VIEW DATA=========================
	function view(idEvent) {
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

				if (result.event.status == 0) {
					$('#btnAproved').hide();
					$('#btnReject').hide();
					$('#btnDone').hide();
				} else if (result.event.status == 1) {
					$('#btnAproved').show();
					$('#btnReject').show();
					$('#btnDone').hide();
				} else if (result.event.status == 2) {
					$('#btnAproved').hide();
					$('#btnReject').hide();
					$('#btnDone').show();
				}else if (result.event.status == 3) {
					$('#btnAproved').hide();
					$('#btnReject').hide();
					$('#btnDone').hide();
				}

				if (result.success) {
					$("#code2").val(result.event.code)
					$("#eventName2").val(result.event.eventName)
					$("#place2").val(result.event.place)
					$("#startDate2").val(result.event.startDate)
					$("#endDate2").val(result.event.endDate)
					$("#budget2").val(result.event.budget)
					$("#requestBy2").val(result.event.requestBy)
					$("#requestDate2").val(result.event.requestDate)
					$("#note2").val(result.event.note);
					$("#status2").val(result.event.statusDesc.status)
					$("#assignTo").val(result.event.assignTo)
					$("#idEvent").val(result.event.id)

					notifySuccess('Berhasil Menampilkan Data');
				} else {
					notifyError('Gagal Menampilkan Data');
				}
			},
			error : function() {
				notifyError('Gagal Menampilkan Data');
			}
		});
	}
	
	
	
</script>


















