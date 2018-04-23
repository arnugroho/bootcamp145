<div id="modal-register-dosen" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">
					<span id="modal-title">Konfirmasi Registrasi</span>
				</h4>
			</div>
			<!-- ----------------------------------- -->
			<div class="modal-body">
				<p>Setelah melakukan registrasi, data anda tidak akan bisa dirubah lagi.</p>
				<p>Anda yakin untuk melakukan registrasi?</p>
				<!-- ----------------------------------- -->
			</div>
			
			<div class="modal-footer form-horizontal">
				<button type="button" class="btn btn-danger" data-dismiss="modal">
					<span class="glyphicon glyphicon-remove"></span> Tidak
				</button>
				<button id="btn-submit-register-dosen" type="submit"
					class="btn btn-success " onclick="registerDosen();">
					<span class="glyphicon glyphicon-ok"></span> Ya
				</button>
			</div>


		</div>
	</div>
</div>