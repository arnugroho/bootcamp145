<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-form-design.jsp"%>

<!-- <script>
	src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.min.js"></script> -->
<!-- <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modalFormDesign">Tambah</button>
<hr>
<table id="tableDesign" class="display" width="100%"></table> -->

<div class="row">
	<div class="col-md-12">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">List Design Request</h3>
			</div>
			<ul class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li><a href="#">Master</a></li>
				<li><a class="active">List Design Request</a></li>
			</ul>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-11"></div>
					<div class="col-md-1">
						<button id="btnTambah" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#modalFormDesign">Add</button>
					</div>
					<!-- <div class="col-md-11"></div>
					<div class="col-md-1">
						<button type="button" class="btn btn-warning btn-block" data-toggle="modal" data-target="#modalFormDesign">Search</button>					
					</div> -->
				</div>
				<br>
				<div class="row">
					<div class="col-sm-12">
						<table id="tableDesign"
							class="table table-bordered table-striped dataTable" width="100%">

						</table>
					</div>
				</div>
			</div>

		</div>
	</div>

</div>

<script type="text/javascript"> 
$(document).ready(function() {
	
	prepareDatatable();
	
	$("#btnCancel").click(function(){
		$("#formAddDesign")[0].reset();
	});
	
	$("#btnUpdate").click(function(){
		updateData();
	});

	$("#btnInsert").click(function(){
		insertData();
	});
	
	$("#btnTambah").click(function(){
		$("#btnUpdate").hide();
		$('#btnInsert').show();
	});
} );

function insertData() {
	$.ajax({
		url : contextName + '/design/insert.json',
		data : {
			'code' : $("#transactionCode").val(),
			'titleHeader' : $("#designTitle").val(),
			'note' : $("#note").val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableDesign').DataTable().destroy()
				prepareDatatable()
				// ------ //
				
				//modal di hide 
				$('#modalFormDesign').modal('hide');
				// ----//
				
				
				notifySuccess('Berhasil Insert Data');
			}else {
				notifyError('Gagal Insert Datas');
			}
		},
		error : function() {
			notifyError('Gagal Function');
		}
	});
}

function updateData() {
	$.ajax({
		url : contextName + '/design/update.json',
		data : {
			'code' : $("#transactionCode").val(),
			'titleHeader' : $("#designTitle").val(),
			'note' : $("#note").val(),
			'id' : $("#idDesign").val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				//agar table ter refresh
				$('#tableDesign').DataTable().destroy()
				prepareDatatable()
				// ------ //
				
				//modal di hide 
				$('#modalFormDesign').modal('hide');
				// ----//
				
				
				notifySuccess('Berhasil Update Data');
			}else {
				notifyError('Gagal Update Datas');
			}
		},
		error : function() {
			notifyError('Gagal Update Data');
		}
	});
}

function prepareDatatable() {
	$.ajax({
		url : contextName + '/design/get-data.json',
		type : 'post',
		dataType : 'json',
		success : function(result) {
			console.log(result.success);
			if(result.success){
				
				// proses merubah array objeck menjadi array array
				//{{},{}} menjadi {[],[]}
				var listDesign = $.map(result.listDesign, function(value, index) {
    				return [Object.values(value)];
				});


				var dataSet = listDesign;
					
				    $('#tableDesign').DataTable( {
				        data: dataSet,
				        columns: [
				            { title: "Transaction Code" },
				            { title: "Request By" },
				            { title: "Request Date" },
				            { title: "Assign To" },
				            { title: "Status" },
				            { title: "Created Date" },
				            { title: "Created By" },
				            { title: "Action" },
				           ],
				           "columnDefs": [
				               {
				                   // The `data` parameter refers to the data for the cell (defined by the
				                   // `data` option, which defaults to the column being worked with, in
				                   // this case `data: 0`.
				                   "render": function ( data, type, row ) {
				                	   var s = '<button type="button" class="btn btn-default btn-sm" onClick="viewDesign('
											+ data + ')">'
									s = s
											+ ' <i class="fa fa-search"></i> </button>'
									s += '<button type="button" class="btn btn-default btn-sm" onClick="updateDesign('
											+ data + ')">'
									s = s
											+ ' <i class="fa fa-pencil"></i> </button>'
				   					   
				                       return s;
				                   },
				                   // column keberapa render diaplikasikan
				                   "targets": 7
				               }
				           ]
				    } );
				    
				
				notifySuccess('Berhasil Create Table');
			}else {
				notifyError('Gagal Create wawa');
			}
		},
		error : function() {
			notifyError('Gagal Create hh');
		}
	});
				   
}

function updateDesign(idDesign) {
	$('#btnInsert').hide();
	$('#btnUpdate').show();
	$('#modalFormDesign').modal('show');
	$.ajax({
		url : contextName + '/design/view.json',
		type : 'post',
		data : {
			idDesign : idDesign
		},
		dataType : 'json',
		success : function(result) {
			if (result.success) {
				$("#transactionCode").val(result.design.code)
				$("#eventCode").val(result.design.tEventId)
				$("#designTitle").val(result.design.titleHeader)
				$("#requestBy").val(result.design.createdBy)
				$("#requestDate").val(result.design.createdDate)
				$("#note").val(result.design.note)		
				$("#idDesign").val(result.design.id)

				 notifySuccess('Berhasil Update Data'); 
			} else {
				notifyError('Gagal Update Datas');
			}
		},
		error : function() {
			notifyError('Gagal Update Data');
		}
	});
}

function viewDesign(idDesign) {
	$('#btnInsert').hide();
	$('#btnUpdate').hide();
	$('#modalFormDesign').modal('show');
	$.ajax({
		url : contextName + '/design/view.json',
		type : 'post',
		data : {
			idDesign : idDesign
		},
		dataType : 'json',
		success : function(result) {
			if (result.success) {
				$("#transactionCode").val(result.design.code)
				$("#requestBy").val(result.design.createdBy)
				$("#eventCode").val(result.design.tEventId)
				$("#requestDate").val(result.design.createdDate)
				$("#designTitle").val(result.design.titleHeader)
				$("#note").val(result.design.note)
				$("#idDesign").val(result.design.id)					
			} else {
				notifyError('Gagal Load Datas');
			}
		},
		error : function() {
			notifyError('Gagal Function');
		}
	});
}
</script>
