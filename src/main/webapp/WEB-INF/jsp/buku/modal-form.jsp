<!-- Modal -->
<div class="modal fade" id="modalFormBuku" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Form Buku</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">

						<div class="box box-primary">
							<!-- /.box-header -->
							<!-- form start -->
							<form role="form">
								<div class="box-body">
									<div class="form-group">
										<label for="namaBuku">Nama Buku</label> <input
											class="form-control" id="namaBuku" name="namaBuku"
											placeholder="Nama Buku" type="text">
									</div>
									<div class="form-group">
										<label for="pengarang">Pengarang</label> <input
											class="form-control" id="pengarang" name="pengarang"
											placeholder="Pengarang" type="text">
									</div>
									
									<input
											class="form-control" id="idBuku" name="idBuku"
											 type="hidden">

								</div>
								<!-- /.box-body -->

							</form>
						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnInsert" class="btn btn-primary">Insert</button>
				<button type="button" id="btnUpdate" class="btn btn-primary">Update</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>