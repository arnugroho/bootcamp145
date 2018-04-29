<div class="modal fade" id="registrasiRole" role="dialog"
	data-parsley-validate>
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Registrasi Role</h4>
			</div>
			<div class="modal-body">
				<form id="formRegistrasiRole">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}">
					<div class="form-group has-feedback">
						Role Code <input type="text" class="form-control rolecode" id="code"
							name="code" placeholder="Role code" required> <span></span>
					</div>
					<div class="form-group has-feedback">
						Role Name <input type="text" id="roleName" name="name"
							class="form-control rolename" placeholder="Type Role Name"
							required> <span></span>
					</div>
					<div class="form-group has-feedback">
						Description <input type="text" id="description" name="description"
							class="form-control description" placeholder="Type Description">
						<span></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnRole" class="btn btn-primary">Save</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
//mendefinisikan ketika tombol btnInsert diklik memanggil insertData()
$("#btnDaftar").click(function(){
	insertData();
});


function insertData() {
	$.ajax({
		url : contextName + '/role/insert.json',
		data : {
			'code' : $("#code").val(),
			'name' : $("#name").val(),
			'description' : $(#description).val(),
		},
		type : 'post',
		dataType : 'json',
		success : function(result) {
			if(result.success){
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
</script>



