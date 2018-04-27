<%@ include file="/taglibs.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.min.js"></script>
<div class="row">
	<div class="col-md-12">

		<div class="box box-solid"
			style="border-top-left-radius: 10px; border-top-right-radius: 10px;">
			<div class="box-header with-border"
				style="background-color: DodgerBlue; border-top-left-radius: 10px; border-top-right-radius: 10px;">
				<h4 style="color: white;">List Marketing Promotion</h4>
			</div>
			<ul class="breadcrumb">
				<li><a href="${contextName}/home.html"> Home</a></li>
				<li><a href="${contextName}/home.html">Master</a></li>
				<li class="active">List Marketing Promotion</li>
			</ul>
			<!-- /.box-header -->
			<div class="box-body">
				<div class="box">
					<div class="box-header"></div>
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-6">
									<div class="dataTables_length" id="example1_length"></div>
								</div>
								<!-- 								<div class="col-sm-6"> -->
								<!-- 									<div id="example1_filter" class="dataTables_filter"> -->
								<!-- 										<label>Search:<input type="search" -->
								<!-- 											class="form-control input-sm" placeholder="" -->
								<!-- 											aria-controls="example1"></label> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
							</div>
							<div class="col-md-11"></div>
							<div class="col-md-1">
									<a data-toggle="modal" href="#loginUser">
									<button type="button" class="btn btn-block btn-primary">Add</button>
							</div>


							<div class="row">
								<div class="col-sm-12">
									<table id="example1"
										class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead>
											<tr role="row">
												<th style="width: 30px;">No</th>
												<th style="width: 120px;">Transaction Code</th>
												<th style="width: 120px;">Request By</th>
												<th style="width: 120px;">Request Date</th>
												<th style="width: 120px;">Assign To</th>
												<th style="width: 120px;">Status</th>
												<th style="width: 120px;">Created By</th>
												<th style="width: 120px;">Created Date</th>
												<th style="width: 120px;">Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="promotion" items="${promotionCollection}">
												<tr>
													<td>${promotion.id}</td>
													<td>${promotion.code}</td>
													<td>${promotion.requestBy}</td>
													<td>${promotion.requestDate}</td>
													<td>${promotion.assignTo}</td>
													<td>${promotion.statusDesc.status}</td>
													<td>${promotion.createdBy}</td>
													<td>${promotion.createdDate}</td>
													<td><a href="#" class="fa fa-search"> &nbsp <a
															href="%" class="fa fa-pencil"></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>


		</div>
		<!-- /.box-body -->
	</div>
</div>

</div>


















