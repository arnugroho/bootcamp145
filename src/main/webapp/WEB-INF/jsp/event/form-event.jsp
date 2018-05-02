<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-form.jsp"%>

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-success btn-lg" data-toggle="modal"
	data-target="#modalFormEvent">add</button>
<hr>
<table id="tableEvent" class="display" width="100%"></table>


<script type="text/javascript">
	$(document).ready(function() {
		//script didalam sini akan dijalankan ketika document telah selesai di load
		//kita menggunakan datatable client side
		// contoh : https://datatables.net/examples/data_sources/js_array.html
		prepareDatatable();

		//mendefinisikan ketika tombol btnInsert diklik memanggil insertData()
		$("#btnInsert").click(function() {
			insertData();
		});

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
					//agar table ter refresh
					$('#tableEvent').DataTable().destroy()
					prepareDatatable()
					// ------ //
					
					//modal di hide 
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

function prepareDatatable() {
	$.ajax({
		url : contextName + '/event/get-data.json',
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				
				// proses merubah array objeck menjadi array array
				//{{},{}} menjadi {[],[]}
				var listEvent = $.map(result.listEvent, function(value, index) {
    				return [Object.values(value)];
				});


				var dataSet = listEvent;
					
				    $('#tableEvent').DataTable( {
				        data: dataSet,
				        columns: [
				        	{title : "Transaction Code"}, 
							{title : "Event Name"},
							{title : "Request By"},
							{title : "Request Date"},
							{title : "Due Date"},
							{title : "Status"},
							{title : "Created Date"},
							{title : "Create By"},
							{title : "Action"}
				           ],
				            "columnDefs": [
				               {
				                   // The `data` parameter refers to the data for the cell (defined by the
				                   // `data` option, which defaults to the column being worked with, in
				                   // this case `data: 0`.
				                   "render": function ( data, type, row ) {
				                	   var s = '<button type="button" class="btn btn-danger btn-add" onClick="deleteEvent('+data+')">'
				   					   s = s + ' <i class="fa fa-trash"></i> </button>'
				                       return s;
				                   },
				                   // column keberapa render diaplikasikan
				                   "targets": 8
				               }
				           ] 
				    } );
				    
				
				notifySuccess('Berhasil Create Table');
			}else {
				notifyError('Gagal Create Table');
			}
		},
		error : function() {
			notifyError('Gagal Create Table');
		}
	});
}
				
function deleteEvent(idEvent){
	$.ajax({
		url : contextName + '/event/delete.json',
		type : 'post',
		data : {
			idEvent : idEvent
		},
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableEvent').DataTable().destroy()
				prepareDatatable()
				// ------ //
				    
				
				notifySuccess('Berhasil Delete Data');
			}else {
				notifyError('Gagal Delete Data');
			}
		},
		error : function() {
			notifyError('Gagal Delete Data');
		}
	});
}				
					
					
	
</script>


















