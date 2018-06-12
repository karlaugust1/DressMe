<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>DressMe</title>

<!-- Fontfaces CSS-->
<link href="css/font-face.css" rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet"
	media="all">

<!-- Vendor CSS-->
<link href="vendor/animsition/animsition.min.css" rel="stylesheet"
	media="all">
<link
	href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="vendor/wow/animate.css" rel="stylesheet" media="all">
<link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet"
	media="all">
<link href="vendor/slick/slick.css" rel="stylesheet" media="all">
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">
<link href="vendor/vector-map/jqvmap.min.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
<%
if(session.getAttribute("email")==null)
	response.sendRedirect("login.html");%>
	<div class="page-wrapper">
		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar2">
			<div class="logo">
				<a href="#"> <img src="images/icon/logo.png" alt="DressMe" />
				</a>
			</div>
			<div class="menu-sidebar2__content js-scrollbar1">
				<div class="account2">
					<div class="image img-cir img-120">
						<img src="images/icon/avatar-big-01.jpg" alt="John Doe" />
					</div>
					<h4 class="name">john doe</h4>
					<a href="login.html">Sign out</a>
				</div>
				<nav class="navbar-sidebar2">
					<ul class="list-unstyled navbar__list">
						<li><a href="../index2.html"> <i
								class="fas fa-tachometer-alt"></i>Painel Principal
						</a></li>
						<li class="active has-sub"><a class="js-arrow" href="#">
								<i class="fas fa-shopping-basket"></i>Vendas <span class="arrow">
									<i class="fas fa-angle-down"></i>
							</span>
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="index2.html"> <i
										class="fas fa-pencil-square-o"></i>Or�amento
								</a></li>
								<li><a href="ListarPedidoVendaServlet"> <i
										class="fas fa-shopping-cart"></i>Pedido de Venda
								</a></li>
								<li><a href="index2.html"> <i class="fas fa-print"></i>Nota
										Fiscal
								</a></li>
								<li><a href="index2.html"> <i class="fas fa-file"></i>Relat�rios
								</a></li>
							</ul></li>
						<li><a href="../index2.html"> <i class="fas fa-download"></i>Compras
						</a></li>
						<li><a href="../index2.html"> <i class="fas fa-inbox"></i>Estoque
						</a></li>
						<li><a href="../index2.html"> <i class="fas fa-group"></i>Fideliza��o
						</a></li>
					</ul>
				</nav>
			</div>
		</aside>
		<!-- END MENU SIDEBAR-->

		<!-- PAGE CONTAINER-->
		<div class="page-container2">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop2">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="header-wrap2">
							<div class="logo d-block d-lg-none">
								<a href="#"> <img src="images/icon/logo-white.png"
									alt="CoolAdmin" />
								</a>
							</div>
							<div class="header-button2">
								<div class="header-button-item js-item-menu">
									<i class="zmdi zmdi-search"></i>
									<div class="search-dropdown js-dropdown">
										<form action="">
											<input class="au-input au-input--full au-input--h65"
												type="text" placeholder="Search for datas &amp; reports..." />
											<span class="search-dropdown__icon"> <i
												class="zmdi zmdi-search"></i>
											</span>
										</form>
									</div>
								</div>
								<div class="header-button-item has-noti js-item-menu">
									<i class="zmdi zmdi-notifications"></i>
									<div class="notifi-dropdown js-dropdown"></div>
								</div>
								<div class="header-button-item mr-0 js-sidebar-btn">
									<i class="zmdi zmdi-menu"></i>
								</div>
								<div class="setting-menu js-right-sidebar d-none d-lg-block">
									<div class="account-dropdown__body">
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-account"></i>Conta
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-settings"></i>Configura��es
											</a>
										</div>
									</div>
									<div class="account-dropdown__body">
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-globe"></i>Idioma
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-pin"></i>Localiza��o
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-email"></i>Email
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-notifications"></i>Notifica��es
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>
			<aside class="menu-sidebar2 js-right-sidebar d-block d-lg-none">
				<div class="logo">
					<a href="#"> <img src="images/icon/logo-white.png"
						alt="Cool Admin" />
					</a>
				</div>
				<div class="menu-sidebar2__content js-scrollbar2">
					<div class="account2">
						<div class="image img-cir img-120">
							<img src="images/icon/avatar-big-01.jpg" alt="John Doe" />
						</div>
						<h4 class="name">john doe</h4>
						<a href="#">Sign out</a>
					</div>
					<nav class="navbar-sidebar2">
						<ul class="list-unstyled navbar__list">
							<li><a href="../index2.html"> <i
									class="fas fa-tachometer-alt"></i>Painel Principal
							</a></li>
							<li class="active has-sub"><a class="js-arrow" href="#">
									<i class="fas fa-shopping-basket"></i>Vendas <span
									class="arrow"> <i class="fas fa-angle-down"></i>
								</span>
							</a>
								<ul class="list-unstyled navbar__sub-list js-sub-list">
									<li><a href="index2.html"> <i
											class="fas fa-pencil-square-o"></i>Or�amento
									</a></li>
									<li><a href="pedidovenda/listarPedidosVendas.jsp"> <i
											class="fas fa-shopping-cart"></i>Pedido de Venda
									</a></li>
									<li><a href="index2.html"> <i class="fas fa-print"></i>Nota
											Fiscal
									</a></li>
									<li><a href="index2.html"> <i class="fas fa-file"></i>Relat�rios
									</a></li>
								</ul></li>
							<li><a href="../index2.html"> <i class="fas fa-download"></i>Compras
							</a></li>
							<li><a href="../index2.html"> <i class="fas fa-inbox"></i>Estoque
							</a></li>
							<li><a href="../index2.html"> <i class="fas fa-group"></i>Fideliza��o
							</a></li>
						</ul>
					</nav>
				</div>
			</aside>
			<!-- END HEADER DESKTOP-->

			<!-- BREADCRUMB-->
			<section class="au-breadcrumb m-t-25">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12"></div>
						</div>
					</div>
				</div>
			</section>
			<!-- END BREADCRUMB-->

			<!-- STATISTIC-->
			<section class="statistic">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-6 col-lg-3">
								<div class="statistic__item">
									<h2 class="number">10,368</h2>
									<span class="desc">members online</span>
									<div class="icon">
										<i class="zmdi zmdi-account-o"></i>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-lg-3">
								<div class="statistic__item">
									<h2 class="number">388,688</h2>
									<span class="desc">items sold</span>
									<div class="icon">
										<i class="zmdi zmdi-shopping-cart"></i>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-lg-3">
								<div class="statistic__item">
									<h2 class="number">1,086</h2>
									<span class="desc">this week</span>
									<div class="icon">
										<i class="zmdi zmdi-calendar-note"></i>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-lg-3">
								<div class="statistic__item">
									<h2 class="number">$1,060,386</h2>
									<span class="desc">total earnings</span>
									<div class="icon">
										<i class="zmdi zmdi-money"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- END STATISTIC-->

			<section>
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-xl-8">
								<!-- RECENT REPORT 2-->
								<div class="recent-report2">
									<h3 class="title-3">recent reports</h3>
									<div class="chart-info">
										<div class="chart-info__left">
											<div class="chart-note">
												<span class="dot dot--blue"></span> <span>products</span>
											</div>
											<div class="chart-note">
												<span class="dot dot--green"></span> <span>Services</span>
											</div>
										</div>
										<div class="chart-info-right">
											<div class="rs-select2--dark rs-select2--md m-r-10">
												<select class="js-select2" name="property">
													<option selected="selected">All Properties</option>
													<option value="">Products</option>
													<option value="">Services</option>
												</select>
												<div class="dropDownSelect2"></div>
											</div>
											<div class="rs-select2--dark rs-select2--sm">
												<select class="js-select2 au-select-dark" name="time">
													<option selected="selected">All Time</option>
													<option value="">By Month</option>
													<option value="">By Day</option>
												</select>
												<div class="dropDownSelect2"></div>
											</div>
										</div>
									</div>
									<div class="recent-report__chart">
										<canvas id="recent-rep2-chart"></canvas>
									</div>
								</div>
								<!-- END RECENT REPORT 2             -->
							</div>
							<div class="col-xl-4">
								<!-- TASK PROGRESS-->
								<div class="task-progress">
									<h3 class="title-3">task progress</h3>
									<div class="au-skill-container">
										<div class="au-progress">
											<span class="au-progress__title">Web Design</span>
											<div class="au-progress__bar">
												<div class="au-progress__inner js-progressbar-simple"
													role="progressbar" data-transitiongoal="90">
													<span class="au-progress__value js-value"></span>
												</div>
											</div>
										</div>
										<div class="au-progress">
											<span class="au-progress__title">HTML5/CSS3</span>
											<div class="au-progress__bar">
												<div class="au-progress__inner js-progressbar-simple"
													role="progressbar" data-transitiongoal="85">
													<span class="au-progress__value js-value"></span>
												</div>
											</div>
										</div>
										<div class="au-progress">
											<span class="au-progress__title">WordPress</span>
											<div class="au-progress__bar">
												<div class="au-progress__inner js-progressbar-simple"
													role="progressbar" data-transitiongoal="95">
													<span class="au-progress__value js-value"></span>
												</div>
											</div>
										</div>
										<div class="au-progress">
											<span class="au-progress__title">Support</span>
											<div class="au-progress__bar">
												<div class="au-progress__inner js-progressbar-simple"
													role="progressbar" data-transitiongoal="95">
													<span class="au-progress__value js-value"></span>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- END TASK PROGRESS-->
							</div>
						</div>
					</div>
				</div>
			</section>

			<section>
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-xl-6">
								<!-- USER DATA-->
								<div class="user-data m-b-40">
									<h3 class="title-3 m-b-30">
										<i class="zmdi zmdi-account-calendar"></i>user data
									</h3>
									<div class="filters m-b-45">
										<div
											class="rs-select2--dark rs-select2--md m-r-10 rs-select2--border">
											<select class="js-select2" name="property">
												<option selected="selected">All Properties</option>
												<option value="">Products</option>
												<option value="">Services</option>
											</select>
											<div class="dropDownSelect2"></div>
										</div>
										<div
											class="rs-select2--dark rs-select2--sm rs-select2--border">
											<select class="js-select2 au-select-dark" name="time">
												<option selected="selected">All Time</option>
												<option value="">By Month</option>
												<option value="">By Day</option>
											</select>
											<div class="dropDownSelect2"></div>
										</div>
									</div>
									<div class="table-responsive table-data">
										<table class="table">
											<thead>
												<tr>
													<td><label class="au-checkbox"> <input
															type="checkbox"> <span class="au-checkmark"></span>
													</label></td>
													<td>name</td>
													<td>role</td>
													<td>type</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td><label class="au-checkbox"> <input
															type="checkbox"> <span class="au-checkmark"></span>
													</label></td>
													<td>
														<div class="table-data__info">
															<h6>lori lynch</h6>
															<span> <a href="#">johndoe@gmail.com</a>
															</span>
														</div>
													</td>
													<td><span class="role admin">admin</span></td>
													<td>
														<div class="rs-select2--trans rs-select2--sm">
															<select class="js-select2" name="property">
																<option selected="selected">Full Control</option>
																<option value="">Post</option>
																<option value="">Watch</option>
															</select>
															<div class="dropDownSelect2"></div>
														</div>
													</td>
													<td><span class="more"> <i
															class="zmdi zmdi-more"></i>
													</span></td>
												</tr>
												<tr>
													<td><label class="au-checkbox"> <input
															type="checkbox" checked="checked"> <span
															class="au-checkmark"></span>
													</label></td>
													<td>
														<div class="table-data__info">
															<h6>lori lynch</h6>
															<span> <a href="#">johndoe@gmail.com</a>
															</span>
														</div>
													</td>
													<td><span class="role user">user</span></td>
													<td>
														<div class="rs-select2--trans rs-select2--sm">
															<select class="js-select2" name="property">
																<option value="">Full Control</option>
																<option value="" selected="selected">Post</option>
																<option value="">Watch</option>
															</select>
															<div class="dropDownSelect2"></div>
														</div>
													</td>
													<td><span class="more"> <i
															class="zmdi zmdi-more"></i>
													</span></td>
												</tr>
												<tr>
													<td><label class="au-checkbox"> <input
															type="checkbox"> <span class="au-checkmark"></span>
													</label></td>
													<td>
														<div class="table-data__info">
															<h6>lori lynch</h6>
															<span> <a href="#">johndoe@gmail.com</a>
															</span>
														</div>
													</td>
													<td><span class="role user">user</span></td>
													<td>
														<div class="rs-select2--trans rs-select2--sm">
															<select class="js-select2" name="property">
																<option value="">Full Control</option>
																<option value="" selected="selected">Post</option>
																<option value="">Watch</option>
															</select>
															<div class="dropDownSelect2"></div>
														</div>
													</td>
													<td><span class="more"> <i
															class="zmdi zmdi-more"></i>
													</span></td>
												</tr>
												<tr>
													<td><label class="au-checkbox"> <input
															type="checkbox"> <span class="au-checkmark"></span>
													</label></td>
													<td>
														<div class="table-data__info">
															<h6>lori lynch</h6>
															<span> <a href="#">johndoe@gmail.com</a>
															</span>
														</div>
													</td>
													<td><span class="role member">member</span></td>
													<td>
														<div class="rs-select2--trans rs-select2--sm">
															<select class="js-select2" name="property">
																<option selected="selected">Full Control</option>
																<option value="">Post</option>
																<option value="">Watch</option>
															</select>
															<div class="dropDownSelect2"></div>
														</div>
													</td>
													<td><span class="more"> <i
															class="zmdi zmdi-more"></i>
													</span></td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="user-data__footer">
										<button class="au-btn au-btn-load">load more</button>
									</div>
								</div>
								<!-- END USER DATA-->
							</div>
							<div class="col-xl-6">
								<!-- MAP DATA-->
								<div class="map-data m-b-40">
									<h3 class="title-3 m-b-30">
										<i class="zmdi zmdi-map"></i>map data
									</h3>
									<div class="filters">
										<div
											class="rs-select2--dark rs-select2--md m-r-10 rs-select2--border">
											<select class="js-select2" name="property">
												<option selected="selected">All Worldwide</option>
												<option value="">Products</option>
												<option value="">Services</option>
											</select>
											<div class="dropDownSelect2"></div>
										</div>
										<div
											class="rs-select2--dark rs-select2--sm rs-select2--border">
											<select class="js-select2 au-select-dark" name="time">
												<option selected="selected">All Time</option>
												<option value="">By Month</option>
												<option value="">By Day</option>
											</select>
											<div class="dropDownSelect2"></div>
										</div>
									</div>
									<div class="map-wrap m-t-45 m-b-80">
										<div id="vmap" style="height: 284px;"></div>
									</div>
									<div class="table-wrap">
										<div class="table-responsive table-style1">
											<table class="table">
												<tbody>
													<tr>
														<td>United States</td>
														<td>$119,366.96</td>
													</tr>
													<tr>
														<td>Australia</td>
														<td>$70,261.65</td>
													</tr>
													<tr>
														<td>United Kingdom</td>
														<td>$46,399.22</td>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="table-responsive table-style1">
											<table class="table">
												<tbody>
													<tr>
														<td>Germany</td>
														<td>$20,366.96</td>
													</tr>
													<tr>
														<td>France</td>
														<td>$10,366.96</td>
													</tr>
													<tr>
														<td>Russian</td>
														<td>$5,366.96</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<!-- END MAP DATA-->
							</div>
						</div>
					</div>
				</div>
			</section>

			<section>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="copyright">
								<p>
									Copyright � 2018 VSET Sistemas. All rights reserved.<a
										href="https://colorlib.com">Colorlib</a>.
								</p>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- END PAGE CONTAINER-->
		</div>

	</div>

	<!-- Jquery JS-->
	<script src="vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script src="vendor/bootstrap-4.1/popper.min.js"></script>
	<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script src="vendor/slick/slick.min.js">
		
	</script>
	<script src="vendor/wow/wow.min.js"></script>
	<script src="vendor/animsition/animsition.min.js"></script>
	<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
		
	</script>
	<script src="vendor/counter-up/jquery.waypoints.min.js"></script>
	<script src="vendor/counter-up/jquery.counterup.min.js">
		
	</script>
	<script src="vendor/circle-progress/circle-progress.min.js"></script>
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script src="vendor/chartjs/Chart.bundle.min.js"></script>
	<script src="vendor/select2/select2.min.js">
		
	</script>
	<script src="vendor/vector-map/jquery.vmap.js"></script>
	<script src="vendor/vector-map/jquery.vmap.min.js"></script>
	<script src="vendor/vector-map/jquery.vmap.sampledata.js"></script>
	<script src="vendor/vector-map/jquery.vmap.world.js"></script>

	<!-- Main JS-->
	<script src="js/main.js"></script>

</body>

</html>
<!-- end document-->
