<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-register-user.jsp"%>

<button type="button" id="btnTambah" class="btn btn-success btn-lg"
	data-toggle="modal" data-target="#registerUser2">Add</button>
<hr>
<table id="tableUser" class="display" width="100%"></table>

<script type="text/javascript">
	$(document).ready(function() {
		$('#retypePassword').change(function(){
			var pass = $('#regisPassword').val();
			var repass = $('#retypePassword').val();
			if (pass == repass) {
				notifySuccess('Password sesuai');
			} else {
				notifyError('Password Tidak Sama');
			}
		});
		prepareDatatable();
		$("#btnInsert").click(function() {
			var pass = $('#regisPassword').val();
			var repass = $('#retypePassword').val();
			if (pass == repass) {
				insertData();
			} else {
				notifyError('Password Tidak Sama');
			}

		});

		$("#btnUpdate").click(function() {
			updateData();
		});

		$("#btnTambah").click(function() {
			getName();
			$("#btnUpdate").hide();
			$('#btnInsert').show();
		});

		/* 	$("#btnClose").click(function() {
				$("#formAddUser")[0].reset();
			}); */

	});

	function insertData() {
		$.ajax({
			url : contextName + '/member/insert.json',
			data : {
				'username' : $("#username").val(),
				'password' : $("#regisPassword").val(),
				'mRoleId' : $("#listMrole").find(':selected').val(),
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
	
	function updateData() {
		$.ajax({
			url : contextName + '/member/update.json',
			data : {
				'username' : $("#username").val(),
				'password' : $("#regisPassword").val(),
				'mRoleId' : $("#listMrole").find(':selected').val(),
				'id' : $("#idUser").val(),
			},
			type : 'post',
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$('#tableUser').DataTable().destroy()
					prepareDatatable()

					$('#registerUser2').modal('hide');

					notifySuccess('Berhasil Update Data');
				} else {
					notifyError('Gagal Update Table');
				}
			},
			error : function() {
				notifyError('Gagal Update Data');
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
												destroy :true,
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
														var s = '<button type="button" class="btn btn-default" onClick="deleteUser('
																+ data + ')">'
														s = s
																+ ' <i class="fa fa-trash"></i> </button>'
														s += '<button type="button" class="btn btn-default" onClick="updateUser('
																+ data + ')">'
														s = s
																+ ' <i class="fa fa-pencil"></i> </button>'
														s += '<button type="button" class="btn btn-default" onClick="viewUser('
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

	function deleteUser(idUser) {
		$.ajax({
			url : contextName + '/member/delete.json',
			type : 'post',
			data : {
				idUser : idUser
			},
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$('#tableUser').DataTable().destroy()
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
	
	function updateUser(idUser) {
		$('#btnInsert').hide();
		$('#btnUpdate').show();
		$('#registerUser2').modal('show');
		$.ajax({
			url : contextName + '/member/view.json',
			type : 'post',
			data : {
				idUser : idUser
			},
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$("#username").val(result.muser.username)
					$("#password").val(result.muser.password)
					$("#mRoleId").val(result.muser.mRoleId)
					$("#idUser").val(result.muser.id)
				
	/* 	
						'username' : $("#username").val(),
					'password' : $("#regisPassword").val(),
					'mRoleId' : $("#listMrole").find(':selected').val(),
					'id' : $("#idUser").val(),
						
						$("#code").val(result.mrole.code)
						$("#name").val(result.mrole.name)
						$("#description").val(result.mrole.description)
						$("#idRole").val(result.mrole.id) */

					notifySuccess('Berhasil Update Data');
				} else {
					notifyError('Gagal Update Data');
				}
			},
			error : function() {
				notifyError('Gagal Update Data');
			}
		});
	}
	
	function viewUser(idUser) {
		$('#btnInsert').hide();
		$('#btnUpdate').hide();
		$('#registerUser2').modal('show');
		$.ajax({
			url : contextName + '/member/view.json',
			type : 'post',
			data : {
				idUser : idUser
			},
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$("#username").val(result.muser.username)
					$("#password").val(result.muser.password)
					$("#mRoleId").val(result.muser.mRoleId)
					$("#idUser").val(result.muser.id)
					
					/* $("#code").val(result.mrole.code)
					$("#name").val(result.mrole.name)
					$("#description").val(result.mrole.description)
					$("#idRole").val(result.mrole.id) */
				} else {
					notifyError('Gagal Load Data');
				}
			},
			error : function() {
				notifyError('Gagal Load Data');
			}
		});
	}
	function getName() {
		$
				.ajax({
					url : contextName + '/member/getname.json',
					type : 'post',
					dataType : 'json',
					success : function(result) {
						$("#listMrole").html("");
						$
								.each(
										result.listMrole,
										function(index, value) {
											// 							var div_data = "<option value=" + value.id + ">" + value.name + "</option>";							
											// 							$(div_data).appendTo('#listMrole');
											$("#listMrole")
													.append(
															'<option value= '+value.id+' label='+value.name+'/>');
										})
					},
					error : function() {
						notifyError('Gagal Delete Data');
					}
				});
	}
</script>