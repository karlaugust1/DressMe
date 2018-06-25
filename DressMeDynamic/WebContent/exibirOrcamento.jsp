<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
<!-- VariÃ¡veis -->
<script>
	var controleProduto = 0; // Para Listagem
	var date = today.getDate() + '/' + (today.getMonth() + 1) + '/'
			+ today.getFullYear(); //Data
</script>

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
								<li><a href="#"> <i
										class="fas fa-pencil-square-o"></i>Or&ccedil;amento
								</a></li>
								<li><a href="ListarPedidoVendaServlet"> <i class="fas fa-shopping-cart"></i>Pedido
										de Venda
								</a></li>
								<li><a href="ListarNotasFiscais"> <i class="fas fa-print"></i>Nota
										Fiscal
								</a></li>
								<li><a href="#"> <i class="fas fa-file"></i>Relat&oacute;rios
								</a></li>
							</ul></li>
						<li><a href="#"> <i class="fas fa-download"></i>Compras
						</a></li>
						<li><a href="#"> <i class="fas fa-inbox"></i>Estoque
						</a></li>
						<li><a href="#"> <i class="fas fa-group"></i>Fideliza&ccedil;&atilde;o
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
											<a href="#"> <i class="zmdi zmdi-pin"></i>Localizaçãoo
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
						alt="Cool Admin" />
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
									<li><a href="#"> <i
											class="fas fa-pencil-square-o"></i>Orçamento
									</a></li>
									<li><a href="ListarPedidoVendaServlet"> <i
											class="fas fa-shopping-cart"></i>Pedido de Venda
									</a></li>
									<li><a href="ListarNotasFiscais"> <i class="fas fa-print"></i>Nota
											Fiscal
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

			<!-- FORMULÃRIO DE PEDIDOS -->
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">
						<strong>Exibir</strong> <small> Orçamento</small>
					</div>

					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label for="npedido" class="control-label mb-1">N&#186;
									Pedido</label> <input id="npedido" name="npedido" type="text"
									class="form-control npedido" placeholder="" disabled=""
									autocomplete="npedido" value="${pedidoVenda.numero}">
							</div>
						</div>
						<div class="col-4">
							<label for="datap" class="control-label mb-1">Data</label>
							<div class="input-group">
								<input id="datap" name="datap" type="text"
									class="form-control datap" value="${pedidoVenda.dataAbertura}"
									placeholder="" autocomplete="off" disabled="">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<div class="form-group">
								<label for="clientecod" class="control-label mb-1">Cliente</label>
								<div class="input-group">
									<input type="text" id="clientecod" name="input1-group2"
										placeholder="Cliente" class="form-control" disabled=""
										value="${pedidoVenda.cliente.id}">
								</div>
							</div>
						</div>
						<div class="col-6">
							<label for="clientenome" class="control-label mb-1">Nome
								do Cliente</label>
							<div class="input-group">
								<input id="clientenome" name="clientenome" type="text"
									class="form-control clientenome" value="${pedidoVenda.cliente.nome}"
									placeholder="Nome do Cliente" autocomplete="off" disabled="">

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-5">
							<div class="form-group">
								<label for="cpfcnpj" class="control-label mb-1">CPF/CNPJ
								</label> <input id="cpfcnpj" name="cpfcnpj" type="text"
									class="form-control cpfcnpj" value="${pedidoVenda.cliente.cpf}"
									placeholder="CPF/CNPJ" disabled="" autocomplete="cpfcnpj">
							</div>
						</div>
						<div class="col-5">
							<label for="ies" class="control-label mb-1">Inscri&#231;&#227;o
								Estadual</label>
							<div class="input-group">
								<input id="ies" name="ies" type="text" class="form-control ies"
									value="${pedidoVenda.cliente.inscricaoEstadual}" placeholder="IES"
									autocomplete="off" disabled="">

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label for="rua" class="control-label mb-1">Rua </label> <input
									id="rua" name="rua" type="text" class="form-control rua"
									value="${pedidoVenda.cliente.rua}" placeholder="Rua" disabled=""
									autocomplete="rua">
							</div>
						</div>
						<div class="col-2">
							<label for="nst" class="control-label mb-1">N&#250;mero</label>
							<div class="input-group">
								<input id="nst" name="nst" type="text" class="form-control nst"
									value="${pedidoVenda.cliente.numero}" placeholder="N&uacute;mero"
									autocomplete="off" disabled="">

							</div>
						</div>

						<div class="col-4">
							<label for="brr" class="control-label mb-1">Bairro</label>
							<div class="input-group">
								<input id="brr" name="brr" type="text" class="form-control brr"
									value="" placeholder="Bairro" autocomplete="off" disabled="">

							</div>
						</div>
					</div>


					<div class="row">
						<div class="col-5">
							<div class="form-group">
								<label for="cdd" class="control-label mb-1">Cidade </label> <input
									id="cdd" name="cdd" type="text" class="form-control cdd"
									value="${pedidoVenda.cliente.cidade}" placeholder="Cidade" disabled=""
									autocomplete="cdd">
							</div>
						</div>
						<div class="col-5">
							<label for="cmp" class="control-label mb-1">Complemento</label>
							<div class="input-group">
								<input id="cmp" name="cmp" type="text" class="form-control ies"
									value="${pedidoVenda.cliente.complemento}" placeholder="Complemento"
									autocomplete="off" disabled="">

							</div>
						</div>
					</div>


					<div class="row">
						<div class="col-5">
							<div class="form-group">
								<label for="condpag" class="control-label mb-1">Condi&#231;&#227;o
									de Pagamento</label>
								<div class="input-group">
									<input type="text" id="condpag" name="condpag"
										placeholder="Condi&ccedil;&atilde;o de Pagamento"
										class="form-control" disabled="" value="${pedidoVenda.condPagamento.descricao}">
								</div>
							</div>
						</div>
						<div class="col-5">
							<label for="vdd" class="control-label mb-1">Vendedor</label>
							<div class="input-group">
								<input id="vendedor" name="vendedor" type="text"
									class="form-control vdd" value="${pedidoVenda.vendedor.nome}"
									placeholder="Vendedor" disabled="" />
							</div>
						</div>
					</div>
				</div>


			</div>


			<!-- LISTAGEM DE Produtos -->
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header" style="text-align: center">
						<strong>Produtos</strong> <small>- Pedido de Venda</small>
					</div>
						<c:choose>
							<c:when test="${not empty pedidoVenda.listaProduto}">
								<div class="table-responsive table-responsive-data2">
									<table class="table table-data2">
										<thead>
											<tr>
												<th>ID</th>
												<th>produto</th>
												<th>cor</th>
												<th>tamanho</th>
												<th>quantidade</th>
												<th>valor unit&aacute;rio</th>
												<th>valor total</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pedidoVenda.listaProduto}">
												<tr class="tr-shadow">
													<td class="desc">${item.id}</td>
													<td>${item.produto.descricao}</td>
													<td class="desc">${item.produto.cor}</td>
													<td>${item.produto.tamanho}</td>
													<td><span class="status--process">${item.quantidade}</span></td>
													<td><span class="block-email">${item.valorUnitario}</span></td>
													<td><span class="block-email">${item.valorUnitario*item.quantidade}</span></td>
												</tr>
												<tr class="spacer"></tr>
												<script>
													controleProduto++;
												</script>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</c:when>
							<c:otherwise>
								<br>
								<div class="alert alert-info">Nenhum Produto Inserido!</div>
							</c:otherwise>
						</c:choose>

					<!-- FinalizaÃ§Ã£o -->

					<div class="row">
						<div class="col-2">
							<div class="form-group">
								<label for="rua" class="control-label mb-1">Subtotal </label> <input
									id="rua" name="rua" type="text" class="form-control subtotal"
									value="${pedidoVenda.valorSubtotal}" placeholder="0.00" disabled=""
									autocomplete="rua">
							</div>
						</div>
						<div class="col-2">
							<label for="nst" class="control-label mb-1">Desconto</label>
							<div class="input-group">
								<form action="PreOrcamentoServlet" method="post">
									<div class="table-data-feature">
										<input id="nst" name="vlrDesconto" type="text" value="${pedidoVenda.desconto}"
											class="form-control nst" value="" placeholder="${pedidoVenda.desconto}"
											autocomplete="off">
									</div>
								</form>
							</div>
						</div>

						<div class="col-2">
							<label for="brr" class="control-label mb-1">Total</label>
							<div class="input-group">
								<input id="brr" name="brr" type="text" class="form-control brr"
									value="${pedidoVenda.valorTotal}" placeholder="${pedidoVenda.valorTotal}"
									autocomplete="off" disabled="">


							</div>
							<div class="col-2"></div>
						</div>
					</div>
				</div>
				<div style="text-align: right; display-inline: block;">
					<a href="ListarOrcamentoServlet" type="button"
						class="btn btn-secondary" data-dismiss="modal">Voltar</a> 
				</div>
			</div>
		</div>
	</div>
	<!-- FIM DO FORMULï¾RIO DE PEDIDOS -->

	<!-- Footer -->
	<section>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="copyright">
						<p>Copyright &#169; 2018 VSET Sistemas. Nenhum direito
							reservado.</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- END PAGE CONTAINER -->
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

	<!-- Scripts -->
	<script>
		$(document)
				.ready(
						function() {
							$("#buscaClientes")
									.on(
											"keyup",
											function() {
												var value = $(this).val()
														.toLowerCase();
												$("#tabelaClientes tr")
														.filter(
																function() {
																	$(this)
																			.toggle(
																					$(
																							this)
																							.text()
																							.toLowerCase()
																							.indexOf(
																									value) > -1)
																});
											});

							$("#buscaVendedores")
									.on(
											"keyup",
											function() {
												var value = $(this).val()
														.toLowerCase();
												$("#tabelaVendedores tr")
														.filter(
																function() {
																	$(this)
																			.toggle(
																					$(
																							this)
																							.text()
																							.toLowerCase()
																							.indexOf(
																									value) > -1)
																});
											});

							$("#buscaCP")
									.on(
											"keyup",
											function() {
												var value = $(this).val()
														.toLowerCase();
												$("#tabelaCP tr")
														.filter(
																function() {
																	$(this)
																			.toggle(
																					$(
																							this)
																							.text()
																							.toLowerCase()
																							.indexOf(
																									value) > -1)
																});
											});

						});
		
		function verUtilizacaoPontos(campo) {
			if(campo.checked){
				location.href="PrePedidoVendaServlet";
			}
		}
	</script>

</body>

</html>
<!-- end document-->