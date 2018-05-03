<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-register-user.jsp"%>

<a data-toggle="modal" href="#registerUser2">Daftar</a></p>
<!-- <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#registerUser2">Add</button> -->
<hr>
<table id="tableRole" class="display" width="100%"></table>

<script type="text/javascript">
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script type="text/javascript">
		var formReg = $("#formRegistrasiUser").parsley();
		$(function(){
			$("#registrasiUser2").on("hidden.bs.modal", function(){
				$("#formRegistrasiUser")[0].reset();
			});
			$("#btnDaftar").click(function(){
				var pass = $("#formRegistrasiUser .password").val();
				var rePass = $("#formRegistrasiUser .retypePassword").val();
				var user = $("#formRegistrasiUser .username").val();
				if(formReg.validate()){
					if(pass == rePass){
						$.ajax({
							type 	: "POST",
							url 	: '${contextName}/registrasi-user2.json',
							data 	: {
										username : user,
										password : CryptoJS.MD5(pass).toString(),
										email : email
							},
							beforeSend : function(xhr){
								xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'));
							},
							success : function(data){
								if(data.success){
									notifySuccess(data.message);
									$("#registerUser2").modal("hide");
								} else{
									notifyError(data.message);
								}
							}
						});
					} else {
						notifyError("Retype password tidak sama dengan password yang anda masukkan!");
					}	
				}
			});
		});
	</script>

<!-- <script type="text/javascript">

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
</script> -->