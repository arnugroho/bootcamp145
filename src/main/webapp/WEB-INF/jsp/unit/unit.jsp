<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-register-unit.jsp"%>

<button type="button" id="btnTambah" class="btn btn-success btn-lg"
	data-toggle="modal" data-target="#registerUnit">Add</button>
<hr>
<table id="tableUnit" class="display" width="100%"></table>

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
			url : contextName + '/unit/insert.json',
			data : {
				'code' : $("#code").val(),
				'name' : $("#name").val(),
				'description' : $("#description").val(),
			},
			type : 'post',
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$('#tableUnit').DataTable().destroy()
					prepareDatatable()

					$('#registerUnit').modal('hide');

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
			url : contextName + '/unit/update.json',
			data : {
				'code' : $("#code").val(),
				'name' : $("#name").val(),
				'description' : $("#description").val(),
				'id' : $("#idUnit").val(),
			},
			type : 'post',
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$('#tableUnit').DataTable().destroy()
					prepareDatatable()

					$('#registerUnit').modal('hide');

					notifySuccess('Berhasil Update Data');
				} else {
					notifyError('Gagal show Table');
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
					url : contextName + '/unit/get-data.json',
					type : 'post',
					dataType : 'json',
					success : function(result) {
						if (result.success) {

							// proses merubah array objeck menjadi array array
							//{{},{}} menjadi {[],[]}
							var listUnit = $.map(result.listUnit, function(
									value, index) {
								return [ Object.values(value) ];
							});
							var dataSet = listUnit;
							$('#tableUnit')
									.DataTable(
											{
												data : dataSet,
												columns : [ {
													title : "Unit Code"
												}, {
													title : "Unit Name"
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
														var s = '<button type="button" class="btn btn-default" onclick="deleteUnit('
																+ data + ')">'
														s = s
																+ ' <i class ="fa fa-trash"></i></button>'
														s += '<button type="button" class="btn btn-default" onclick="updateUnit('
																+ data + ')">'
														s += ' <i class ="fa fa-pencil"></i></button>'
														s += '<button type="button" class="btn btn-default" onclick="viewUnit('
																+ data + ')">'
														s += ' <i class ="fa fa-search"></i></button>'
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

	function deleteUnit(idUnit) {
		$.ajax({
			url : contextName + '/unit/delete.json',
			type : 'post',
			data : {
				idUnit : idUnit
			},
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$('#tableUnit').DataTable().destroy()
					prepareDatatable()
					notifySuccess('Data Berhasil Di Delete');
				} else {
					notifyError('Data Gagal Di Delete');
				}
			},
			error : function() {
				notifyError('Data Gagal Di Delete');
			}
		});
	}

	function updateUnit(idUnit) {
		$('#btnInsert').hide();
		$('#btnUpdate').show();
		$('#registerUnit').modal('show');
		$.ajax({
			url : contextName + '/unit/view.json',
			type : 'post',
			data : {
				idUnit : idUnit
			},
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$("#code").val(result.unit.code)
					$("#name").val(result.unit.name)
					$("#description").val(result.unit.description)
					$("#idUnit").val(result.unit.id)

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

	function viewUnit(idUnit) {
		$('#btnInsert').hide();
		$('#btnUpdate').hide();
		$('#registerUnit').modal({
			backdrop : 'static',
			keyboard : false,
		/* show : true, */

		});
		$.ajax({
			url : contextName + '/unit/view.json',
			type : 'post',
			data : {
				idUnit : idUnit
			},
			dataType : 'json',
			success : function(result) {
				if (result.success) {
					$("#code").val(result.unit.code)
					$("#name").val(result.unit.name)
					$("#description").val(result.unit.description)
					$("#idUnit").val(result.unit.id)
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