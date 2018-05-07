<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-register-user.jsp"%>

<button type="button" id="btnTambah" class="btn btn-success btn-lg"
	data-toggle="modal" data-target="#registerUser2">Add</button>
<hr>
<table id="tableUser" class="display" width="100%"></table>

<script type="text/javascript">
	$(document).ready(function() {
		prepareDatatable();
		$("#btnInsert").click(function() {
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

	function insertData() {
		$.ajax({
			url : contextName + '/member/insert.json',
			data : {
				'username' : $("#username").val(),
				'password' : $("#password").val(),
			},
			type : 'post',
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$('#tableUser').DataTable().destroy()
					prepareDatatable()

					$('#registerUser2').modal('hide');

					notifySuccess('Berhasil Insert Data');
				} else {
					notifyError('Gagal Insert Data');
				}
			},
			error : function() {
				notifyError('Gagal Insert Data');
			}
		});
	}

	function prepareDatatable() {
		$
				.ajax({
					url : contextName + '/member/get-data.json',
					type : 'post',
					dataType : 'json',
					success : function(result) {
						if (result.success) {

							// proses merubah array objeck menjadi array array
							//{{},{}} menjadi {[],[]}
							var listUser = $.map(result.listUser, function(
									value, index) {
								return [ Object.values(value) ];
							});

							var dataSet = listUser;

							$('#tableUser')
									.DataTable(
											{
												data : dataSet,
												columns : [ {
													title : "Employee"
												}, {
													title : "Role"
												}, {
													title : "Username"
												}, {
													title : "Created Date"
												}, {
													title : "Created By"
												}, {
													title : "Action"
												} ],
												"columnDefs" : [ {
													"render" : function(data,
															type, row) {
														var s = '<button type="button" class="btn btn-default" onClick="deleteRole('
																+ data + ')">'
														s = s
																+ ' <i class="fa fa-trash"></i> </button>'
														s += '<button type="button" class="btn btn-default" onClick="updateRole('
																+ data + ')">'
														s = s
																+ ' <i class="fa fa-pencil"></i> </button>'
														s += '<button type="button" class="btn btn-default" onClick="viewRole('
																+ data + ')">'
														s = s
																+ ' <i class="fa fa-search"></i> </button>'
														return s;
													},
													"targets" : 5
												} ]
											});

							notifySuccess('Berhasil Create Table');
						} else {
							notifyError('Gagal Create Table');
						}
					},
					error : function() {
						notifyError('Gagal Create Table');
					}
				});
	}
</script>