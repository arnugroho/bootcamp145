<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-register-unit.jsp"%>

<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#registerUnit">Add</button>
<hr>
<table id="tableUnit" class="display" width="100%"></table>

<script type="text/javascript">

$(document).ready(function(){
	prepareDatatable();
	$("#btnInsert").click(function(){
		insertData();
	});
});

function insertData(){
	$.ajax({
		url : contextName + '/unit/insert.json',
		data : {
			'code' : $("#code").val(),
			'name' : $("#name").val(),
			'description' : $("#description").val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result){
			if (result.success) {
				$('#tableUnit').DataTable().destroy()
				prepareDatatable()
				
				$('#registerUnit').modal('hide');
				
				notifySuccess('Berhasil Insert Data');
			} else {
				notifyError('Gagal Inser Data');
			}
		},
		error : function(){
			notifyError('Gagal Insert Data');
		}
	});
}

function prepareDatatable() {
	$.ajax({
		url : contextName + '/unit/get-data.json',
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
				
				// proses merubah array objeck menjadi array array
				//{{},{}} menjadi {[],[]}
				var listUnit = $.map(result.listUnit, function(value, index) {
    				return [Object.values(value)];
				});
				var dataSet = listUnit;
									    $('#tableUnit').DataTable( {
				        data: dataSet,
				        columns: [
				            { title: "Unit Code" },
				            { title: "Unit Name" },
				            { title: "Created Date" },
				            { title: "Created By" },
				            { title: "Description" }
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