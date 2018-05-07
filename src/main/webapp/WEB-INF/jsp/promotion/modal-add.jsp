<!-- Modal -->
<%@ include file="/taglibs.jsp"%>
<%@ include file="modal-add-next.jsp"%>

<div class="modal fade" id="modalAdd" role="dialog" >
	<div class="modal-dialog modal-md">
		<div class="modal-content" style="border-top-right-radius: 25px; border-top-left-radius: 25px;">
			<div class="modal-header" style="background-color: dodgerblue; border-top-right-radius: 25px; border-top-left-radius: 25px;">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">
					<font color="white">Add Marketing Promotion</font>
				</h4>
			</div>
			<%-- <c:url var="listEventById" value="/getcode" />
			<script type="text/javascript">
    			$(document).ready(function() {
      				  $('#listEvent').change(
           				 function() {
                			$.get('${listEventById}', {
                				listEvent : $(this).val(),
                    		 ajax : 'true'
                			}, function(event) {
                    			var html = '<option value="">Select Event</option>';
                    			var len = event.length;
                    				for ( var i = 0; i < len; i++) {
                        				html += '<option value="' + event[i].id + '">'
                           				 + event[i].code + '</option>';
                    			}
                    				html += '</option>';
                   					$('#listEvent').html(html);
               				 });
            			});
    			});
			</script> --%>
			<div class="modal-body">	
				<div class="row">
					<div class="col-md-12">

						<div class="box box-default">
							<!-- /.box-header -->
							<!-- form start -->
							<br>
							<form class="form-horizontal" id="add">
								<div class="form-group">
									<label class="control-label col-sm-4" for="event">*Select
										Event</label>
									<div class="col-sm-8">
										<select class="form-control" id="listEvent" path="listEvent">
                        					<option value="NONE" label="-Please Select-" />
                    					</select>
									</div>
								</div>
								<div class="form-group" id="fromdesign">
									<label class="control-label col-sm-4" for="fromdesign">*Select
										from Design</label>
									<div class="col-sm-8">
										<select class="form-control" id="fromdesign" name="fromdesign">
											<option value="null">-Please Select-</option>
											<option value="yes">Yes</option>
											<option value="no">No</option>
										</select>
									</div>
								</div>
								<div class="form-group" id="design" style="display: none">
									<label class="control-label col-sm-4" for="design">*Select
										Design</label>
									<div class="col-sm-8">
										<select class="form-control" id="listDesign" path="listDesign">
                        					<option value="NONE" label="-Please Select-" />
                    					</select>
									</div>
								</div>
								<br>
								<!-- <script
									src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
								<script>
									$(document).ready(function() {
										$('#fromdesign')
										.change(
												function() {
										$('yes').click(function() {
											$('#design').hide();
										});
										$('no').click(function() {
											$('#design').show();
										});
												});
									});
								</script> -->
								<script>
									$(function() {
										$('#fromdesign')
												.change(
														function() {
															var value = $(
																	'#fromdesign')
																	.find(
																			':selected')
																	.val()

															if (value == 'yes') {
																$("#design")
																		.show();
															} else {
																$("#design")
																		.hide();
															}
														});
									});
								</script>
								<!-- <script>
									$(document)
											.ready(
													function() {
														$('#fromdesign')
																.on(
																		'change',
																		function() {
																			if (this.value == 'Yes') {
																				$(
																						"#design")
																						.show();
																			} else {
																				$(
																						"#design")
																						.hide();
																			}
																		});
													});
								</script> -->
								<!-- <script>
									$(document)
											.ready(
													function() {
														$('#fromdesign')
																.bind(
																		'change',
																		function(event) {
																			var i = $(
																					'#fromdesign')
																					.val();
																			if (i == "Yes") {
																				$(
																						"#design")
																						.show();
																			} else {
																				$(
																						"#design")
																						.hide();
																						
																			}
																		});
													});
								</script> -->
								<!-- 						</div> -->
								<!-- /.box-body -->

							</form>
						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnNext" class="btn btn-primary"
					data-toggle="modal" data-target="#modalAddNext">Next</button>
				<button type="button" id="btnCancel" class="btn btn-warning"
					data-dismiss="modal" onclick="resetFunction()" value="Reset">Cancel</button>
				<script>
					function resetFunction() {
						document.getElementById("add").reset();
					}
					$("#btnNext").click(function() {
						$('#modalAdd').hide();
					});
					$("#btnCancel").click(function() {
						$('#design').hide();
					});
				</script>


			</div>
		</div>
	</div>
</div>