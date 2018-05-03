<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-register-company.jsp"%>

<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#registerCompany">Add</button>
<hr>
<table id="tableCompany" class="display" width="100%"></table>

<script type="text/javascript">

$(document).ready(function(){
	prepareDatatable();
	$("#btnInsert").click(function(){
		insertData();
	});
	
	$("#btnUpdate").click(function() {
		updateData();
	});
	
	$("#btnTambah").click(function() {
		$("#btnUpdate").hide();
		$('#btnInsert').show();
	});
	
});

function insertData(){
	$.ajax({
		url : contextName + '/company/insert.json',
		data : {
			'code' : $("#code").val(),
			'name' : $("#name").val(),
			'email' : $("#email").val(),
			'phone' : $("#phone").val(),
			'address' : $("#address").val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result){
			if (result.success) {
				$('#tableCompany').DataTable().destroy()
				prepareDatatable()
				
				$('#registerCompany').modal('hide');
				
				notifySuccess('Berhasil Insert Data');
			} else {
				notifyError('Gagal Insert Data');
			}
		},
		error : function(){
			notifyError('Gagal Insert Data');
		}
	});
}

function prepareDatatable() {
	$.ajax({
		url : contextName + '/company/get-data.json',
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				
				// proses merubah array objeck menjadi array array
				//{{},{}} menjadi {[],[]}
				var listCompany = $.map(result.listCompany, function(value, index) {
    				return [Object.values(value)];
				});


				var dataSet = listCompany;
					
				    $('#tableCompany').DataTable( {
				        data: dataSet,
				        columns: [
				            { title: "Company Code" },
				            { title: "Company Name" },
				            { title: "Email" },
				            { title: "Phone" },
				            { title: "Address" },
				            { title: "Action" } 
				           ],
				           "columnDefs" : [{
				        	   "render" : function(data,
										type, row) {
									var s = '<button type="button" class="btn btn-danger" onClick="deleteCompany('
											+ data + ')">'
									s = s
											+ ' <i class="fa fa-trash"></i> </button>'
									s += '<button type="button" class="btn btn-warning" onClick="updateCompany('
											+ data + ')">'
									s = s
											+ ' <i class="fa fa-pencil"></i> </button>'
									s += '<button type="button" class="btn btn-success" onClick="viewCompany('
											+ data + ')">'
									s = s
											+ ' <i class="fa  fa-search"></i> </button>'
									return s;
								},
								"targets" : 5
				           }]
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

function deleteCompany(idCompany) {
	$.ajax({
		url : contextName + '/company/delete.json',
		type : 'post',
		data : {
			idCompany : idCompany
		},
		dataType : 'json',
		success : function(result) {
			if (result.success) {
				$('#tableCompany').DataTable().destroy()
				prepareDatatable()

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

function updateCompany(idCompany) {
	$('#btnInsert').hide();
	$('#btnUpdate').show();
	$('#registerCompany').modal('show');
	$.ajax({
		url : contextName + '/company/view.json',
		type : 'post',
		data : {
			idCompany : idCompany
		},
		dataType : 'json',
		success : function(result) {
			if (result.success) {
				$("#code").val(result.company.code)
				$("#name").val(result.company.name)
				$("#email").val(result.company.email)
				$("#phone").val(result.company.phone)
				$("#address").val(result.company.address)
				$("#idCompany").val(result.company.id)

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

function viewCompany(idCompany) {
	$('#btnInsert').hide();
	$('#btnUpdate').hide();
	$('#registerCompany').modal({
		backdrop : 'static',
		keyboard :false,
		/* show : true, */
			
	});
	$.ajax({
		url : contextName + '/company/view.json',
		type : 'post',
		data : {
			idRole : idRole
		},
		dataType : 'json',
		success : function(result) {
			if (result.success) {
				$("#code").val(result.company.code)
				$("#name").val(result.company.name)
				$("#email").val(result.company.email)
				$("#phone").val(result.company.phone)
				$("#address").val(result.company.address)
				$("#idCompany").val(result.company.id)

			} else {
				notifyError('Gagal Load Data');
			}
		},
		error : function() {
			notifyError('Gagal Load Data');
		}
	});
}
</script> 	