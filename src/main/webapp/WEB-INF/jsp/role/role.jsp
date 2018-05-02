<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-register-role.jsp"%>

<button type="button" class="btn btn-success btn-lg" data-toggle="modal"
	data-target="#registerRole">Add</button>
<hr>
<table id="tableRole" class="display" width="100%"></table>

<script type="text/javascript">

$(document).ready(function(){
	prepareDatatable();
	$("#btnInsert").click(function(){
		insertData();
	});
});

function insertData(){
	$.ajax({
		url : contextName + '/role/insert.json',
		data : {
			'code' : $("#code").val(),
			'name' : $("#name").val(),
			'description' : $("#description").val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result){
			if (result.success) {
				$('#tableRole').DataTable().destroy()
				prepareDatatable()
				
				$('#registerRole').modal('hide');
				
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
		url : contextName + '/role/get-data.json',
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				
				// proses merubah array objeck menjadi array array
				//{{},{}} menjadi {[],[]}
				var listRole = $.map(result.listRole, function(value, index) {
    				return [Object.values(value)];
				});


				var dataSet = listRole;
					
				    $('#tableRole').DataTable( {
				        data: dataSet,
				        columns: [
				            { title: "Role Code" },
				            { title: "Role Name" },
				            { title: "Created Date" },
				            { title: "Created By" },
				            { title :"Action"}
				           ],
				           "columnDefs" : [
				        	   {
				        		   "render": function ( data, type, row ) {
				                	   var s = '<button type="button" class="btn btn-danger btn-add" onClick="deleteRole('+data+')">'
				   					   s = s + ' <i class="fa fa-trash"></i> </button>'
				                       return s;
				                   },
				        		   "targets" : 4
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

function deleteRole(idRole){
	$.ajax({
		url : contextName + '/role/delete.json',
		type : 'post',
		data : {
			idRole : idRole
		},
		dataType : 'json',
		success : function(result){
			if(result.success){
				$('#tableRole').DataTable().destroy()
				prepareDatatable()
				
				notifySuccess('Berhasil Delete Data');
			}else{
				notifyError('Gagal Delete Data');
			}
		},
		error : function(){
			notifyError('Gagal Delete Data');
		}
	});
}
</script>