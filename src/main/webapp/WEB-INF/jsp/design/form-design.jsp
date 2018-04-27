<%@ include file="/taglibs.jsp"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.min.js"></script>
<div class="row">
	<div class="col-md-12">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">List Design Request</h3>
			</div>
			<ul class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li><a href="#">Master</a></li>
				<li><a class="active">List Design Request</a></li>
			</ul>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-11"></div>
					<div class="col-md-1">
						<a class="btn btn-block btn-primary" href="#" role="button">Add</a>
					</div>
					<div class="col-md-11"></div>
					<div class="col-md-1">
						<a class="btn btn-block btn-warning" href="#" role="button">Search</a>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<table id="example1"
							class="table table-bordered table-striped dataTable" role="grid"
							aria-describedby="example1_info">
							<thead>
								<tr role="row class="text-center"">
									<th style="width: 30px;">No</th>
									<th style="width: 120px;">Transaction Code</th>
									<th style="width: 120px;">Request By</th>
									<th style="width: 120px;">Request Date</th>
									<th style="width: 120px;">Assign To</th>
									<th style="width: 120px;">Status</th>
									<th style="width: 120px;">Created Date</th>
									<th style="width: 120px;">Created By</th>
									<th style="width: 120px;">Action</th>
								</tr>
							</thead>
<!-- 							<tbody> -->
<%-- 								<c:forEach var="promotion" items="${promotionCollection}"> --%>
<!-- 									<tr> -->
<%-- 										<td>${promotion.id}</td> --%>
<%-- 										<td>${promotion.code}</td> --%>
<%-- 										<td>${promotion.requestBy}</td> --%>
<%-- 										<td>${promotion.requestDate}</td> --%>
<%-- 										<td>${promotion.assignTo}</td> --%>
<%-- 										<td>${promotion.statusDesc.status}</td> --%>
<%-- 										<td>${promotion.createdBy}</td> --%>
<%-- 										<td>${promotion.createdDate}</td> --%>
<!-- 										<td><a href="#" class="fa fa-search"> &nbsp <a -->
<!-- 												href="%" class="fa fa-pencil"></td> -->
<!-- 									</tr> -->
<%-- 								</c:forEach> --%>
<!-- 							</tbody> -->
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>

</div>


















