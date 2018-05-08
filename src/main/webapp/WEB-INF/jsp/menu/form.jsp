<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-form.jsp"%>

<!-- Trigger the modal with a button -->
<button type="button" id="btnTambah" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modalFormMenu">Tambah</button>
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
		url : contextName + '/menu/prepare-form.json',
		type : 'post',
		dataType : 'json',
		success : function(result) {
				
			var createdBy = result.createdBy;
			$('#created').val(createdBy);
			
			notifySuccess('Berhasil Prepare Form');
			
		},
		error : function() {
			notifyError('Gagal Prepare Form');
		}
	});
}







function insertData() {
	$.ajax({
		url : contextName + '/menu/insert.json',
		data : {
			'name' : $("#name").val(),
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

function updateData() {
	$.ajax({
		url : contextName + '/menu/update.json',
		data : {
			'name' : $("#name").val(),
			'controller' : $("#controller").val(),
			'mId' : $("#mId").val(),
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
				            { title: "Code" },
				            { title: "Nama Menu" },
				            { title: "Controller" },
				            { title: "Created By" },
				            { title: "Action" }
				           ],
				           "columnDefs": [
				               {
				                   // The `data` parameter refers to the data for the cell (defined by the
				                   // `datac` option, which defaults to the column being worked with, in
				                   // this case `data: 0`.
				                   "render": function ( data, type, row ) {
				                	   var s = '<button type="button" class="btn btn-danger" onClick="deleteMenu('+data+')">'
				   					   s = s + ' <i class="fa fa-trash"></i> </button>'
				   						s += '<button type="button" class="btn btn-warning" onClick="updateMenu('+data+')">'
				   					   s += '<i class="fa fa-edit"></i> </button>'
				   					   
				                       return s;
				                   },
				                   // column keberapa render diaplikasikan
				                   "targets": 4
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


function deleteMenu(mId){
	$.ajax({
		url : contextName + '/menu/delete.json',
		type : 'post',
		data : {
			mId : mId
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


function updateMenu(mId){
	$('#btnInsert').hide();
	$('#btnUpdate').show();
	$('#modalFormMenu').modal('show');
	$.ajax({
		url : contextName + '/menu/view.json',
		type : 'post',
		data : {
			mId : mId
		},
		dataType : 'json',
		success : function(result) {
			if(result.success){
				$("#name").val(result.menu.name)
				$("#controller").val(result.menu.controller)
				$("#mId").val(result.menu.mId)
				
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


















