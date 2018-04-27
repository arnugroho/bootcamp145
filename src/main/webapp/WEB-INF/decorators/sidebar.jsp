
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<ul class="sidebar-menu">
			<li class="header">MAIN NAVIGATION</li>
			<li><a href="${contextName}/home.html"><i class="fa fa-home"></i><span>Home</span></a></li>				
				
			<!-- <sec:authorize access="!hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')"> -->
				<li><a href="${contextName}/buku/form.html"><i class="fa fa-book"></i><span>Form Buku</span></a></li>
				<li><a href="${contextName}/role"><i class="fa fa-book"></i><span>Role</span></a></li>
				<li><a href="${contextName}/user"><i class="fa fa-book"></i><span>User</span></a></li>
				
				<li class="treeview">
					<a href="#"> 
						<i	class="fa fa-graduation-cap"></i> <span>Pendidikan</span> 
						<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>	</span>
					</a>
					<ul class="treeview-menu">
						<li><a href="${contextName}/form/pendidikan/formal/index.html"><i class="fa fa-circle-o"></i><span>Pendidikan Formal</span></a></li>
						<li><a href="${contextName}/form/pendidikan/nonformal/index.html"><i class="fa fa-circle-o"></i><span>Pendidikan Non Formal</span></a></li>
					</ul>
				</li>
				
			<!-- </sec:authorize>	 -->
			
			<!-- <sec:authorize access="hasAnyRole('ADMIN','SUPERADMIN','USERSD')"> -->
			<li class="treeview">
				<a href="#"> 
					<i	class="fa fa-cog"></i> <span>Profil</span> 
					<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>	</span>
				</a>
				<ul class="treeview-menu">
				
					<li><a href="${contextName}/formChangePassword.html"><i class="fa fa-lock"></i><span>Ubah Password</span></a></li>
					<li><a href="#" onclick="document.getElementById('formLogout').submit()"><i class="fa fa-sign-out"></i><span>Keluar Aplikasi</span></a></li>
					<li>
						<form id="formLogout" action="<c:url value='/j_spring_security_logout' />"method="post">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
					</li>
				</ul>
			</li>
			<!-- </sec:authorize> -->
			
			
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>
