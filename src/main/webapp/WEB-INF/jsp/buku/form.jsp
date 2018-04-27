<%@ include file="/taglibs.jsp"%>
<div class="row">
	<div class="col-md-12">

		<div class="box box-primary">
			<div class="box-header with-border">
				<h3 class="box-title">Form Buku</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form role="form">
				<div class="box-body">
					<div class="form-group">
						<label for="namaBuku">Nama Buku</label> 
						<input class="form-control" id="namaBuku" name="namaBuku" placeholder="Nama Buku" type="text">
					</div>
					<div class="form-group">
						<label for="[engarang]">Pengarang</label> 
						<input class="form-control" id="pengarang" name="pengarang" placeholder="Pengarang" type="text">
					</div>
					
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="button" id="btnInsert" class="btn btn-primary">Insert</button>
				</div>
			</form>
		</div>
	</div>

</div>

<script type="text/javascript">
//mendefinisikan ketika tombol btnInsert diklik memanggil insertData()
$("#btnInsert").click(function(){
	insertData();
});


function insertData() {
	$.ajax({
		url : contextName + '/buku/insert.json',
		data : {
			'namaBuku' : $("#namaBuku").val(),
			'pengarang' : $("#pengarang").val(),
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


















