<%@ include file="/taglibs.jsp"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.min.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<div class="row">
	<div class="col-md-12">

		<div class="box box-solid">
			<div class="box-header with-border">
				<i class="fa fa-text-width"></i>

				<h3 class="box-title">Home</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<blockquote>
						<div>
					 <a data-toggle="modal" href="#loginUser">Login</a>
					<a data-toggle="modal" href="#registrasiUser">Daftar</a></p>
				</div>
				
					<div class="box">
						<ol class="breadcrumb">
							<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
							<li><a href="#">Tables</a></li>
							<li class="active">Simple</li>
						</ol>
						<div class="box-header">
							<h3 class="box-title">Responsive Hover Table</h3>

							<div class="box-tools">
								<div class="input-group input-group-sm" style="width: 150px;">
									<input type="text" name="table_search"
										class="form-control pull-right" placeholder="Search">

									<div class="input-group-btn">
										<button type="submit" class="btn btn-default">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<!-- /.box-header -->
						<div class="box-body table-responsive no-padding">
							<table class="table table-hover">
								<tbody>
									<tr>
										<td>NO.</td>
										<td>Transaction Code</td>
										<td>Request By</td>
										<td>Request Date</td>
										<td>Due Date</td>
										<td>Status</td>
										<td>Created Date</td>
										<td>Crete By</td>
										<td>Action</td>
									</tr>
									<c:forEach var="event" items="${eventCollection }">

										<tr>
											<td></td>
											<td>${event.code}</td>
											<td>${event.requestBy }</td>
											<td>${event.requestDate}</td>
											<td>${event.startDate }</td>
											<td>${event.status }</td>
											<td>${event.createdDate }</td>
											<td>${event.createdBy }</td>
											<td><a href=#>Edit</a> <a href=#> hapus</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.box-body -->
					</div>
				</blockquote>
			</div>
			<!-- /.box-body -->
		</div>
	</div>

</div>


















