<%@ include file="/taglibs.jsp"%>
<html>
<head>

</head>
<body>

	<!-- <form id="formChangePassword"> -->
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label col-md-2" for="oldPass">Password
						Lama :</label>
					<div class="col-md-10">
						<input type="password" id="oldPass" name="oldPass"
							class="form-control" required>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<br> <label class="control-label col-md-2" for="newPass">Password
						Baru : </label>
					<div class="col-md-10">
						<input type="password" id="newPass" name="newPass"
							class="form-control" required>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<br> <label class="control-label col-md-2" for="konPass">Konfirmasi
						Password Baru : </label>
					<div class="col-md-10">
						<input type="password" id="konPass" name="konPass"
							class="form-control" required>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<input class="btn btn-primary" value="Rubah Password" type="submit"
						id="btnRubah">

				</div>
			</div>
		</div>

	<!-- </form> -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.min.js"></script>
	<script>
		$(function() {
			var header = $("meta[name='_csrf_header']").attr("content");
			var token = $("meta[name='_csrf']").attr("content");
			$(document).ajaxSend(function(e, xhr, options) {
				xhr.setRequestHeader(header, token);
			});
			$("#konPass").change(function() {
				if ($("#konPass").val() != $("#newPass").val()) {
					alert("Konfirmasi Gagal, Password Baru Tidak Sama");
				}
			});
			
			$("#btnRubah").click(function() {
				if ($("#konPass").val() != $("#newPass").val()) {
					alert("Konfirmasi Gagal, Password Baru Tidak Sama");
				}else{
					 $.ajax({
						type : "POST",
						url : "changePassword.json",
						data : {
							oldPass : CryptoJS.MD5($("#oldPass").val()).toString(),
							newPass : CryptoJS.MD5($("#newPass").val()).toString()
						},
						success : function(data) {
							if (data.success) {
								alert("Password Berhasil Diganti");
								window.location.href='${contextName}/home.html';
							} else {
								alert("Password Gagal diganti");
							}
							
						}
					}); 
					
				}
			});
		});
	</script>
</body>

</html>