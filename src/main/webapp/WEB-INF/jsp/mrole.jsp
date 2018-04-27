<%@ include file="/taglibs.jsp"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.min.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<div class="row">
	<div class="col-md-12">

		<div class="box box-solid">
			<div class="box-header with-border"></div>
			<!-- /.box-header -->
			<div class="box-body">
				<blockquote>
					<p>Selamat Datang di Role</p>
					<div class="col-md-11"></div>
							<div class="col-md-1">
								<button type="button" class="btn btn-block btn-primary"
									data-toggle="modal" data-target="#registrasiRole">Add</button>
							</div>
					<div class="col-sm-12">
						<table id="example2"
							class="table table-bordered table-hover dataTable" role="grid"
							aria-describedby="example2_info">
							<thead>
								<tr role="row">
									<th>No</th>
									<th>Role Code</th>
									<th>Role Name</th>
									<th>Created Date</th>
									<th>Created By</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="mrole" items="${mroleCollection}">
									<tr>
										<td class="column_center">${mrole.id}</td>
										<td>${mrole.code}</td>
										<td>${mrole.name}</td>
										<td>${mrole.createdDate}</td>
										<td>${mrole.createdBy}</td>
										<td><a href="#" class="fa fa-search"> &nbsp <a
															href="%" class="fa fa-pencil"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</blockquote>

			</div>

			<!-- /.box-body -->
		</div>
	</div>
</div>