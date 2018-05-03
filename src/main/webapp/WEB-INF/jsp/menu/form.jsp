<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-form.jsp"%>

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modalFormMenu">Tambah</button>
<hr>
<table id="tableMenu" class="display" width="100%"></table>


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
		url : contextName + '/menu/insert.json',
		data : {
			'namaMenu' : $("#namaMenu").val(),
			'controller' : $("#controller").val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableMenu').DataTable().destroy()
				prepareDatatable()
				// ------ //
				
				//modal di hide 
				$('#modalFormMenu').modal('hide');
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
		url : contextName + '/menu/get-data.json',
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				
				// proses merubah array objeck menjadi array array
				//{{},{}} menjadi {[],[]}
				var listMenu = $.map(result.listMenu, function(value, index) {
    				return [Object.values(value)];
				});


				var dataSet = listMenu;
					
				    $('#tableMenu').DataTable( {
				        data: dataSet,
				        columns: [
				            { title: "Nama Menu" },
				            { title: "Controller" },
				            { title: "Action" }
				           ],
				           "columnDefs": [
				               {
				                   // The `data` parameter refers to the data for the cell (defined by the
				                   // `data` option, which defaults to the column being worked with, in
				                   // this case `data: 0`.
				                   "render": function ( data, type, row ) {
				                	   var s = '<button type="button" class="btn btn-danger btn-add" onClick="deleteMenu('+data+')">'
				   					   s = s + ' <i class="fa fa-trash"></i> </button>'
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


function deleteMenu(idMenu){
	$.ajax({
		url : contextName + '/menu/delete.json',
		type : 'post',
		data : {
			idMenu : idMenu
		},
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableMenu').DataTable().destroy()
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


















