<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-form.jsp"%>

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modalFormBuku">Tambah</button>
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

	

} );





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
				            { title: "Pengarang" }
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
</script>


















