<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-register-role.jsp"%>

<button type="button" id="btnTambah" class="btn btn-success btn-lg"
	data-toggle="modal" data-target="#registerRole">Add</button>
<hr>
<table id="tableRole" class="display" width="100%"></table>

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
			url : contextName + '/role/insert.json',
			data : {
				'code' : $("#code").val(),
				'name' : $("#name").val(),
				'description' : $("#description").val(),
			},
			type : 'post',
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$('#tableRole').DataTable().destroy()
					prepareDatatable()

					$('#registerRole').modal('hide');

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

	function updateData() {
		$.ajax({
			url : contextName + '/role/update.json',
			data : {
				'code' : $("#code").val(),
				'name' : $("#name").val(),
				'description' : $("#description").val(),
				'id' : $("#idRole").val(),
			},
			type : 'post',
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$('#tableRole').DataTable().destroy()
					prepareDatatable()

					$('#registerRole').modal('hide');

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
					url : contextName + '/role/get-data.json',
					type : 'post',
					dataType : 'json',
					success : function(result) {
						if (result.success) {

							// proses merubah array objeck menjadi array array
							//{{},{}} menjadi {[],[]}
							var listRole = $.map(result.listRole, function(
									value, index) {
								return [ Object.values(value) ];
							});

							var dataSet = listRole;

							$('#tableRole')
									.DataTable(
											{
												data : dataSet,
												columns : [ {
													title : "Role Code"
												}, {
													title : "Role Name"
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
														var s = '<button type="button" class="btn btn-danger" onClick="deleteRole('
																+ data + ')">'
														s = s
																+ ' <i class="fa fa-trash"></i> </button>'
														s += '<button type="button" class="btn btn-warning" onClick="updateRole('
																+ data + ')">'
														s = s
																+ ' <i class="fa fa-pencil"></i> </button>'
														s += '<button type="button" class="btn btn-success" onClick="viewRole('
																+ data + ')">'
														s = s
																+ ' <i class="fa fa-pencil"></i> </button>'
														return s;
													},
													"targets" : 4
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

	function deleteRole(idRole) {
		$.ajax({
			url : contextName + '/role/delete.json',
			type : 'post',
			data : {
				idRole : idRole
			},
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$('#tableRole').DataTable().destroy()
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

	function updateRole(idRole) {
		$('#btnInsert').hide();
		$('#btnUpdate').show();
		$('#registerRole').modal('show');
		$.ajax({
			url : contextName + '/role/view.json',
			type : 'post',
			data : {
				idRole : idRole
			},
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$("#code").val(result.mrole.code)
					$("#name").val(result.mrole.name)
					$("#description").val(result.mrole.description)
					$("#idRole").val(result.mrole.id)

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

	function viewRole(idRole) {
		$('#btnInsert').hide();
		$('#btnUpdate').hide();
		$('#registerRole').modal({
			backdrop : 'static',
			keyboard :false,
			/* show : true, */
				
		});
		$.ajax({
			url : contextName + '/role/view.json',
			type : 'post',
			data : {
				idRole : idRole
			},
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$("#code").val(result.mrole.code)
					$("#name").val(result.mrole.name)
					$("#description").val(result.mrole.description)
					$("#idRole").val(result.mrole.id)
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