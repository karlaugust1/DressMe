<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<img src="images/icon/avatar-big-01.jpg" alt="Bad Taco" />
					</div>
					<h4 class="name">Bad Taco</h4>
					<a href="login.html">Sair</a>
				</div>
				<nav class="navbar-sidebar2">
					<ul class="list-unstyled navbar__list">
						<li><a href="DashboardServlet"> <i
								class="fas fa-tachometer-alt"></i>Painel Principal
						</a></li>
						<li class="active has-sub"><a class="js-arrow" href="#">
								<i class="fas fa-shopping-basket"></i>Vendas <span class="arrow">
									<i class="fas fa-angle-down"></i>
							</span>
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="#"> <i class="fas fa-pencil-square-o"></i>Orçamento
								</a></li>
								<li><a href="ListarPedidoVendaServlet"> <i
										class="fas fa-shopping-cart"></i>Pedido de Venda
								</a></li>
								<li><a href="ListarNotasFiscais"> <i
										class="fas fa-print"></i>Nota Fiscal
								</a></li>
								<li><a href="#"> <i class="fas fa-file"></i>Relatórios
								</a></li>
							</ul></li>
						<li><a href="#"> <i class="fas fa-download"></i>Compras
						</a></li>
						<li><a href="#"> <i class="fas fa-inbox"></i>Estoque
						</a></li>
						<li><a href="#"> <i class="fas fa-group"></i>Fidelização
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
											<a href="#"> <i class="zmdi zmdi-settings"></i>Configurações
											</a>
										</div>
									</div>
									<div class="account-dropdown__body">
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-globe"></i>Idioma
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-pin"></i>Localização
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-email"></i>Email
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-notifications"></i>Notificações
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
						alt="DressMe" />
					</a>
				</div>
				<div class="menu-sidebar2__content js-scrollbar2">
					<div class="account2">
						<div class="image img-cir img-120">
							<img src="images/icon/avatar-big-01.jpg" alt="Bad Taco" />
						</div>
						<h4 class="name">Bad Taco</h4>
						<a href="#">Sair</a>
					</div>
					<nav class="navbar-sidebar2">
						<ul class="list-unstyled navbar__list">
							<li><a href="DashboardServlet"> <i
									class="fas fa-tachometer-alt"></i>Painel Principal
							</a></li>
							<li class="active has-sub"><a class="js-arrow" href="#">
									<i class="fas fa-shopping-basket"></i>Vendas <span
									class="arrow"> <i class="fas fa-angle-down"></i>
								</span>
							</a>
								<ul class="list-unstyled navbar__sub-list js-sub-list">
									<li><a href="#"> <i class="fas fa-pencil-square-o"></i>Orçamento
									</a></li>
									<li><a href="ListarPedidoVendaServlet"> <i
											class="fas fa-shopping-cart"></i>Pedido de Venda
									</a></li>
									<li><a href="ListarNotasFiscais"> <i
											class="fas fa-print"></i>Nota Fiscal
									</a></li>
									<li><a href="#"> <i class="fas fa-file"></i>Relatórios
									</a></li>
								</ul></li>
							<li><a href="#"> <i class="fas fa-download"></i>Compras
							</a></li>
							<li><a href="#"> <i class="fas fa-inbox"></i>Estoque
							</a></li>
							<li><a href="#"> <i class="fas fa-group"></i>Fidelização
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

			<!-- LISTAGEM DE PEDIDOS -->

			<br>
			<h3 class="title-5 m-b-35">Relatórios - Exportação</h3>
			<!-- 
			<div class="table-data__tool">
							<div class="table-data__tool-left">
							</div>
							<div class="table-data__tool-right">
								<a href="PrePedidoVendaServlet" class="au-btn au-btn-icon au-btn--green au-btn--small" align="center">
									<i class="zmdi zmdi-plus"></i>Novo Pedido
								</a>
							</div>
						</div>
			-->
			<c:choose>
				<c:when test="${not empty listarPedidosVendas}">
				<div style="display:none">
					<div class="table-responsive table-responsive-data2">
						<table id="export_table" class="table table-data2">
							<thead>
								<tr>
									<th>número</th>
									<th>data</th>
									<th>cod. cliente</th>
									<th>cliente</th>
									<th>situação</th>
									<th>total</th>
								</tr>
							</thead>
							<tbody id="listaPedidos">
								<c:forEach var="pedidoVenda" items="${listarPedidosVendas}">
									<tr class="tr-shadow">
										<td class="desc">${pedidoVenda.numero}</td>
										<td>${pedidoVenda.dataAbertura}</td>
										<td class="desc">${pedidoVenda.cliente.id}</td>
										<td>${pedidoVenda.cliente.nome}</td>
										<td><span class="status--process">${pedidoVenda.situacao}</span></td>
										<td><span class="block-email">${pedidoVenda.valorTotal}</span></td>
									</tr>
									<tr class="spacer"></tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					</div>
					<button id="export" data-export="export" class="btn btn-primary">Exportar</button>
				</c:when>
				<c:otherwise>
					<br>
					<div class="alert alert-info">Sem dados para exportar!</div>
				</c:otherwise>
			</c:choose>
			<!-- FIM DA LISTAGEM DE PEDIDOS -->


			<!-- Footer -->
			<section>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="copyright">
								<p>Copyright © 2018 VSET Sistemas. Nenhum direito reservado.
								</p>
							</div>
						</div>
					</div>
				</div>
			</section>

			<!-- END PAGE CONTAINER -->
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
	<script src="js/jquery.tabletoCSV.js"></script>

	<!-- Scripts -->
	
	<script>
        $(function(){
            $("#export").click(function(){
                $("#export_table").tableToCSV();
            });
        });
    </script>

</body>

</html>
<!-- end document-->