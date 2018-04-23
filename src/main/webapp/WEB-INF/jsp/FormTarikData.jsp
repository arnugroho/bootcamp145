<%@ include file="/taglibs.jsp"%>



<html>
<head>
</head>

<body>
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<form id="the-form" class="form-horizontal form-label-left"
				data-parsley-validate>
				<div class="x_panel">
					<div class="x_title">
						<h4>
							<i class="fa fa-list"></i> Tarik Data
						</h4>
					</div>

				</div>
				<div class="x_panel">

					<div class="x_title">
						<label for="sel1">Select Quisioner:</label> <select
							class="form-control" id="collectionQuisioner">
							<option value=0>Select...</option>
						</select>
					</div>

				</div>
				
				<div class="x_panel">

					<div class="x_title">
						<label for="sel2">Select Status:</label> <select
							class="form-control" id="statusAnswer">
							<option value="-1">Pilih Status ...</option>
							<option value=0>Belum Verifikasi</option>
							<option value=1>Diterima</option>
							<option value=2>Ditolak</option>
							<option value=4>Dihapus</option>
						</select>
					</div>

				</div>
				
			</form>
		</div>
		
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<br>
				<input class="btn btn-primary" value="Tarik Data" type="submit" id="btnTarikData" onclick="window.exporJsontData()">
			</div>
		</div>
	</div>
	

	
	<script src="https://cdn.jsdelivr.net/alasql/0.3.9/alasql.min.js"></script>
	<script>
	/* var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	}); */
		
	var jsonData;
	$.getJSON("${contextName}/quisionerCollection.json", function(obj) {
        $.each(obj.quisioner, function(key, value) {
            $("#collectionQuisioner").append("<option value="+value.qId+">" + value.qName + "</option>");
        });
    });
		
		
		
		window.exporJsontData = function exporJsontData() {
				if($("#collectionQuisioner").val()>0 && $("#statusAnswer").val()>=0){
					$.ajax({
						type : "POST",
						url : "tarikdata.json",
						data : {
							qId : $("#collectionQuisioner").val(),
							aIsApprove : $("#statusAnswer").val(),
						},
						success : function(data) {
							if (data.success) {
								jsonData = jQuery.parseJSON(data.aJsonString);
								//jsonData = data.aJsonString;
								console.log(jsonData);
								fileName ="Kuesioner" + $('#collectionQuisioner').val()+'_'+pilihStatus($('#statusAnswer').val())+'_'+data.tanggal+'.csv';
								alasql("SELECT * INTO CSV('"+fileName+"',{headers:true}) FROM ?", [jsonData]);
							} else {
								alert("Gagal Tarik Data");
							}
							
						}
					}); 
					}else{
						alert("Lengkapi Informasi terlebih dahulu");
					}
	    }
		
		function pilihStatus(idStatus){
			if(idStatus == 0){
				return "Belum Verifikasi";
			}else if(idStatus == 1){
				return "Diterima";
			}else if(idStatus == 2){
				return "Ditolak";
			}else if(idStatus == 4){
				return "Dihapus";
			}
		}
	</script>
</body>

</html>