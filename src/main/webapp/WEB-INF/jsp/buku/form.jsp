<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-form.jsp"%>

<!-- Trigger the modal with a button -->
<button type="button" id="btnTambah" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modalFormBuku">Tambah</button>
<hr>
<table id="tableBuku" class="display" width="100%"></table>


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
		prepareForm();
		$("#btnUpdate").hide();
		$('#btnInsert').show();
		
	});

	

} );

function prepareForm() {
	$.ajax({
		url : contextName + '/buku/prepare-form.json',
		type : 'post',
		dataType : 'json',
		success : function(result) {
				
			var requestBy = result.requestBy;
			$('#request').val(requestBy);
			
		
			notifySuccess('Berhasil Prepare Form');
			
		},
		error : function() {
			notifyError('Gagal Prepare Form');
		}
	});
}







function insertData() {
	$.ajax({
		url : contextName + '/buku/insert.json',
		data : {
			'namaBuku' : $("#namaBuku").val(),
			'pengarang' : $("#pengarang").val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableBuku').DataTable().destroy()
				prepareDatatable()
				// ------ //
				
				//modal di hide 
				$('#modalFormBuku').modal('hide');
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
		url : contextName + '/buku/update.json',
		data : {
			'namaBuku' : $("#namaBuku").val(),
			'pengarang' : $("#pengarang").val(),
			'id' : $("#idBuku").val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableBuku').DataTable().destroy()
				prepareDatatable()
				// ------ //
				
				//modal di hide 
				$('#modalFormBuku').modal('hide');
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
		url : contextName + '/buku/get-data.json',
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				
				// proses merubah array objeck menjadi array array
				//{{},{}} menjadi {[],[]}
				var listBuku = $.map(result.listBuku, function(value, index) {
    				return [Object.values(value)];
				});


				var dataSet = listBuku;
					
				    $('#tableBuku').DataTable( {
				        data: dataSet,
				        columns: [
				            { title: "Nama Buku" },
				            { title: "Pengarang" },
				            { title: "Action" }
				           ],
				           "columnDefs": [
				               {
				                   // The `data` parameter refers to the data for the cell (defined by the
				                   // `data` option, which defaults to the column being worked with, in
				                   // this case `data: 0`.
				                   "render": function ( data, type, row ) {
				                	   var s = '<button type="button" class="btn btn-danger" onClick="deleteBuku('+data+')">'
				   					   s = s + ' <i class="fa fa-trash"></i> </button>'
				   						s += '<button type="button" class="btn btn-warning" onClick="updateBuku('+data+')">'
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


function deleteBuku(idBuku){
	$.ajax({
		url : contextName + '/buku/delete.json',
		type : 'post',
		data : {
			idBuku : idBuku
		},
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableBuku').DataTable().destroy()
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


function updateBuku(idBuku){
	$('#btnInsert').hide();
	$('#btnUpdate').show();
	$('#modalFormBuku').modal('show');
	$.ajax({
		url : contextName + '/buku/view.json',
		type : 'post',
		data : {
			idBuku : idBuku
		},
		dataType : 'json',
		success : function(result) {
			if(result.success){
				$("#namaBuku").val(result.buku.namaBuku)
				$("#pengarang").val(result.buku.pengarang)
				$("#idBuku").val(result.buku.id)
				
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


















