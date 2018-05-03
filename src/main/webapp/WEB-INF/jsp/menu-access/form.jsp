<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-form.jsp"%>

<!-- Trigger the modal with a button -->
<button type="button" id="btnTambah" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modalFormMenuAccess">Tambah</button>
<hr>
<table id="tableMenuAccess" class="display" width="100%"></table>


<script type="text/javascript">

$(document).ready(function() {
	//script didalam sini akan dijalankan ketika document telah selesai di load
	//kita menggunakan datatable client side
	// contoh : https://datatables.net/examples/data_sources/js_array.html
	prepareDatatable();
	
	//mendefinisikan ketika tombol btnInsert diklik memanggil insertData()
	$("#btnInsert").click(function(){
		
		insertData();
		
	});
	
	$("#btnUpdate").click(function(){
		
		updateData();
		
	});
	
	$("#btnTambah").click(function(){
		
		$("#btnUpdate").hide();
		$('#btnInsert').show();
		
	});

	

} );





function insertData() {
	$.ajax({
		url : contextName + '/menuAccess/insert.json',
		data : {
			'namaMenuAccess' : $("#namaMenuAccess").val(),
			'pengarang' : $("#pengarang").val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableMenuAccess').DataTable().destroy()
				prepareDatatable()
				// ------ //
				
				//modal di hide 
				$('#modalFormMenuAccess').modal('hide');
				// ----//
				
				
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

function updateData() {
	$.ajax({
		url : contextName + '/menuAccess/update.json',
		data : {
			'namaMenuAccess' : $("#namaMenuAccess").val(),
			'pengarang' : $("#pengarang").val(),
			'id' : $("#idMenuAccess").val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableMenuAccess').DataTable().destroy()
				prepareDatatable()
				// ------ //
				
				//modal di hide 
				$('#modalFormMenuAccess').modal('hide');
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
	$.ajax({
		url : contextName + '/menuAccess/get-data.json',
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				
				// proses merubah array objeck menjadi array array
				//{{},{}} menjadi {[],[]}
				var listMenuAccess = $.map(result.listMenuAccess, function(value, index) {
    				return [Object.values(value)];
				});


				var dataSet = listMenuAccess;
					
				    $('#tableMenuAccess').DataTable( {
				        data: dataSet,
				        columns: [
				            { title: "Nama MenuAccess" },
				            { title: "Pengarang" },
				            { title: "Action" }
				           ],
				           "columnDefs": [
				               {
				                   // The `data` parameter refers to the data for the cell (defined by the
				                   // `data` option, which defaults to the column being worked with, in
				                   // this case `data: 0`.
				                   "render": function ( data, type, row ) {
				                	   var s = '<button type="button" class="btn btn-danger" onClick="deleteMenuAccess('+data+')">'
				   					   s = s + ' <i class="fa fa-trash"></i> </button>'
				   						s += '<button type="button" class="btn btn-warning" onClick="updateMenuAccess('+data+')">'
				   					   s += '<i class="fa fa-edit"></i> </button>'
				   					   
				                       return s;
				                   },
				                   // column keberapa render diaplikasikan
				                   "targets": 2
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


function deleteMenuAccess(idMenuAccess){
	$.ajax({
		url : contextName + '/menuAccess/delete.json',
		type : 'post',
		data : {
			idMenuAccess : idMenuAccess
		},
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableMenuAccess').DataTable().destroy()
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


function updateMenuAccess(idMenuAccess){
	$('#btnInsert').hide();
	$('#btnUpdate').show();
	$('#modalFormMenuAccess').modal('show');
	$.ajax({
		url : contextName + '/menuAccess/view.json',
		type : 'post',
		data : {
			idMenuAccess : idMenuAccess
		},
		dataType : 'json',
		success : function(result) {
			if(result.success){
				$("#namaMenuAccess").val(result.menuAccess.namaMenuAccess)
				$("#pengarang").val(result.menuAccess.pengarang)
				$("#idMenuAccess").val(result.menuAccess.id)
				
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


















