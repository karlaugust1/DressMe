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
<!-- Variáveis -->
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
						<li><a href="index2.jsp"> <i
								class="fas fa-tachometer-alt"></i>Painel Principal
						</a></li>
						<li class="active has-sub"><a class="js-arrow" href="#">
								<i class="fas fa-shopping-basket"></i>Vendas <span class="arrow">
									<i class="fas fa-angle-down"></i>
							</span>
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="index2.html"> <i
										class="fas fa-pencil-square-o"></i>Or&ccedil;amento
								</a></li>
								<li><a href="#"> <i class="fas fa-shopping-cart"></i>Pedido
										de Venda
								</a></li>
								<li><a href="index2.jsp"> <i class="fas fa-print"></i>Nota
										Fiscal
								</a></li>
								<li><a href="index2.jsp"> <i class="fas fa-file"></i>Relat&oacute;ios
								</a></li>
							</ul></li>
						<li><a href="index2.jsp"> <i class="fas fa-download"></i>Compras
						</a></li>
						<li><a href="index2.jsp"> <i class="fas fa-inbox"></i>Estoque
						</a></li>
						<li><a href="index2.jsp"> <i class="fas fa-group"></i>Fideliza&ccedil;&atilde;o
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
											<a href="#"> <i class="zmdi zmdi-settings"></i>Configurções
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
							<li><a href="index2.html"> <i
									class="fas fa-tachometer-alt"></i>Painel Principal
							</a></li>
							<li class="active has-sub"><a class="js-arrow" href="#">
									<i class="fas fa-shopping-basket"></i>Vendas <span
									class="arrow"> <i class="fas fa-angle-down"></i>
								</span>
							</a>
								<ul class="list-unstyled navbar__sub-list js-sub-list">
									<li><a href="index2.html"> <i
											class="fas fa-pencil-square-o"></i>Orçamento
									</a></li>
									<li><a href="pedidovenda/listarPedidosVendas.jsp"> <i
											class="fas fa-shopping-cart"></i>Pedido de Venda
									</a></li>
									<li><a href="index2.jsp"> <i class="fas fa-print"></i>Nota
											Fiscal
									</a></li>
									<li><a href="index2.jsp"> <i class="fas fa-file"></i>Relatóios
									</a></li>
								</ul></li>
							<li><a href="index2.jsp"> <i class="fas fa-download"></i>Compras
							</a></li>
							<li><a href="index2.jsp"> <i class="fas fa-inbox"></i>Estoque
							</a></li>
							<li><a href="index2.jsp"> <i class="fas fa-group"></i>Fidelização
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

			<!-- FORMULÁRIO DE PEDIDOS -->
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">
						<strong>Novo</strong> <small> Pedido de Venda</small>
					</div>

					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label for="npedido" class="control-label mb-1">N&#186;
									Pedido</label> <input id="npedido" name="npedido" type="text"
									class="form-control npedido" placeholder="" disabled=""
									autocomplete="npedido" value="${sessionScope.numeroPedido}">
							</div>
						</div>
						<div class="col-4">
							<label for="datap" class="control-label mb-1">Data</label>
							<div class="input-group">
								<input id="datap" name="datap" type="text"
									class="form-control datap" value="${sessionScope.dataPedido}"
									placeholder="" autocomplete="off" disabled="">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<div class="form-group">
								<label for="clientecod" class="control-label mb-1">Cliente</label>
								<div class="input-group">
									<div class="input-group-btn">
										<button class="btn btn-primary" data-toggle="modal"
											data-target="#ModalClientes">
											<i class="fa fa-search"></i> Buscar
										</button>
									</div>
									<input type="text" id="clientecod" name="input1-group2"
										placeholder="Cliente" class="form-control">
								</div>
							</div>
						</div>
						<div class="col-6">
							<label for="clientenome" class="control-label mb-1">Nome
								do Cliente</label>
							<div class="input-group">
								<input id="clientenome" name="clientenome" type="text"
									class="form-control clientenome" value=""
									placeholder="Nome do Cliente" autocomplete="off" disabled="">

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-5">
							<div class="form-group">
								<label for="cpfcnpj" class="control-label mb-1">CPF/CNPJ
								</label> <input id="cpfcnpj" name="cpfcnpj" type="text"
									class="form-control cpfcnpj" value="" placeholder=""
									disabled="" autocomplete="cpfcnpj">
							</div>
						</div>
						<div class="col-5">
							<label for="ies" class="control-label mb-1">Inscri&#231;&#227;o
								Estadual</label>
							<div class="input-group">
								<input id="ies" name="ies" type="text" class="form-control ies"
									value="" placeholder="IES" autocomplete="off" disabled="">

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label for="rua" class="control-label mb-1">Rua </label> <input
									id="rua" name="rua" type="text" class="form-control rua"
									value="" placeholder="Rua" disabled="" autocomplete="rua">
							</div>
						</div>
						<div class="col-2">
							<label for="nst" class="control-label mb-1">N&#250;mero</label>
							<div class="input-group">
								<input id="nst" name="nst" type="text" class="form-control nst"
									value="" placeholder="N&uacute;mero" autocomplete="off"
									disabled="">

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
									value="" placeholder="Cidade" disabled="" autocomplete="cdd">
							</div>
						</div>
						<div class="col-5">
							<label for="cmp" class="control-label mb-1">Complemento</label>
							<div class="input-group">
								<input id="cmp" name="cmp" type="text" class="form-control ies"
									value="" placeholder="Complemento" autocomplete="off"
									disabled="">

							</div>
						</div>
					</div>


					<div class="row">
						<div class="col-5">
							<div class="form-group">
								<label for="condpag" class="control-label mb-1">Condi&#231;&#227;o
									de Pagamento</label>
								<div class="input-group">
									<div class="input-group-btn">
										<button class="btn btn-primary" data-toggle="modal"
											data-target="#ModalCondPag">
											<i class="fa fa-search"></i> Buscar
										</button>
									</div>
									<input type="text" id="condpag" name="condpag"
										placeholder="Condi&ccedil;&atilde;o de Pagamento"
										class="form-control" disabled="">
								</div>
							</div>
						</div>
						<div class="col-5">
							<label for="vdd" class="control-label mb-1">Vendedor</label>
							<div class="input-group">
								<div class="input-group-btn">
									<button class="btn btn-primary" data-toggle="modal"
										data-target="#ModalVendedor">
										<i class="fa fa-search"></i> Buscar
									</button>
								</div>
								<input id="vdd" name="vdd" type="text" class="form-control vdd"
									value="" placeholder="Vendedor" autocomplete="off" disabled="">
							</div>
						</div>
					</div>
				</div>


			</div>


			<!-- LISTAGEM DE Produtos -->
			<h3 class="title-5 m-b-35">Produtos</h3>
			<form action="/ListarProdutosPedidoVendaServlet" method="post">
				<c:choose>
					<c:when test="${not empty listarProdutosPedidoVenda}">
						<div class="table-data__tool">
							<div class="table-data__tool-left"></div>
							<div class="table-data__tool-right">
								<button class="au-btn au-btn-icon au-btn--green au-btn--small">
									<i class="zmdi zmdi-plus"></i>Adicionar Produto
								</button>
							</div>
						</div>
						<div class="table-responsive table-responsive-data2">
							<table class="table table-data2">
								<thead>
									<tr>
										<th>ID</th>
										<th>produto</th>
										<th>cor</th>
										<th>tamanho</th>
										<th>quantidade</th>
										<th>valor unitário</th>
										<th>valor total</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="pedidoVenda"
										items="${listarProdutosPedidoVenda}">
										<tr class="tr-shadow">
											<td class="desc">${pedidovenda.listaProduto[controleProduto].produto.numero}</td>
											<td>${pedidovenda.listaProduto[controleProduto].produto.descricao}</td>
											<td class="desc">${pedidovenda.listaProduto[controleProduto].produto.cor}</td>
											<td>${pedidovenda.listaProduto[controleProduto].produto.tamanho}</td>
											<td><span class="status--process">${pedidovenda.listaProduto[controleProduto].quantidade}</span></td>
											<td><span class="block-email">${pedidovenda.listaProduto[controleProduto].valorunitario}</span></td>
											<td><span class="block-email">${pedidovenda.listaProduto[controleProduto].subtotal}</span></td>
											<td>
												<div class="table-data-feature">
													<button class="item" data-toggle="tooltip"
														data-placement="top" title="Editar">
														<i class="zmdi zmdi-edit"></i>
													</button>
													<button class="item" data-toggle="tooltip"
														data-placement="top" title="Deletar">
														<i class="zmdi zmdi-delete"></i>
													</button>
													<button class="item" data-toggle="tooltip"
														data-placement="top" title="Visualizar">
														<i class="zmdi zmdi-eye"></i>
													</button>
												</div>
											</td>
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
						<div class="table-data__tool">
							<div class="table-data__tool-left"></div>
							<div class="table-data__tool-right">
								<button class="au-btn au-btn-icon au-btn--green au-btn--small"
									data-toggle="modal" data-target="#ModalProdutos">
									<i class="zmdi zmdi-plus"></i>Adicionar Produto
								</button>
							</div>
						</div>
						<div class="alert alert-info">Nenhum Produto Inserido!</div>
					</c:otherwise>
				</c:choose>
			</form>

		</div>
		<!-- FIM DO FORMULﾁRIO DE PEDIDOS -->


		<!-- modal produtos -->
		<div class="modal fade" id="ModalProdutos" tabindex="-1" role="dialog"
			aria-labelledby="staticModalLabel" aria-hidden="true"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticModalLabel">Produtos</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="/ListarProdutosServlet" method="post">
							<c:choose>
								<c:when test="${not empty listarProdutos}">
									<div class="table-data__tool">
										<div class="table-data__tool-left">
											<button class="au-btn-filter">
												<i class="zmdi zmdi-filter-list"></i>Filtrar
											</button>
										</div>
									</div>
									<div class="table-responsive table-responsive-data2">
										<table class="table table-data2">
											<thead>
												<tr>
													<th>ID</th>
													<th>Descrição</th>
													<th>Cor</th>
													<th>Tamanho</th>
													<th>Estoque</th>
													<th>Preço</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="pedidoVenda" items="${listarProdutos}">
													<tr class="tr-shadow">
														<td class="desc">${produto.id}</td>
														<td>${produto.descricao}</td>
														<td class="desc">${produto.cor}</td>
														<td>${produto.tamanho}</td>
														<td><span class="status--process">${produto.quantidadeEstoque}</span></td>
														<td><span class="block-email">${produto.preco}</span></td>
														<td>
															<div class="table-data-feature">
																<button class="item" data-toggle="tooltip"
																	data-placement="top" title="Adicionar ao Pedido"
																	data-toggle="modal" data-target="#modalQuantia">
																	<i class="zmdi zmdi-assignment-check"></i>
																</button>
															</div>
														</td>
													</tr>
													<tr class="spacer"></tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</c:when>
								<c:otherwise>
									<div class="alert alert-info">Nenhum Produto Cadastrado!</div>
								</c:otherwise>
							</c:choose>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-primary">Confirmar</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end modal produtos -->

		<!-- modal quantiaProdutos -->
		<div class="modal fade" id="modalQuantia" tabindex="-1" role="dialog"
			aria-labelledby="staticModalLabel" aria-hidden="true"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticModalLabel">Quantia</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="quantia" class="control-label mb-1">Quantia </label>
							<input id="quantia" name="quantia" type="text"
								class="form-control npedido" value=""
								placeholder="Insira Quantia de Produto">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-primary">Confirmar</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end modal CondPag -->

		<!-- modal clientes -->
		<div class="modal fade" id="ModalClientes" tabindex="-1" role="dialog"
			aria-labelledby="staticModalLabel" aria-hidden="true"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" role="document"
				style="max-width: 100%; width: auto; display: table;">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticModalLabel">Clientes</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="table-responsive m-b-40">
							<c:choose>
								<c:when test="${not empty listaClientes}">
									<table class="table table-borderless table-data3">
										<input class="form-control" id="buscaClientes" type="text"
											placeholder="Buscar cliente...">
										<thead>
											<tr>
												<th>Cod. Cliente</th>
												<th>Nome</th>
												<th>CPF</th>
												<th></th>
											</tr>
										</thead>
										<tbody id="tabelaClientes">
											<c:forEach var="cliente" items="${listaClientes}">
												<script>
													$(document)
															.ready(
																	function() {
																		$(
																				"#buscaClientes")
																				.on(
																						"keyup",
																						function() {
																							var value = $(
																									this)
																									.val()
																									.toLowerCase();
																							$(
																									"#tabelaClientes tr")
																									.filter(
																											function() {
																												$(
																														this)
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
												</script>
												<tr>
													<td>${cliente.id}</td>
													<td>${cliente.nome}</td>
													<td>${cliente.cpf}</td>
													<td>
														<form
															action="InserirClienteServlet?idCliente=${cliente.id}"
															method="post">
															<div class="table-data-feature">
																<button class="item" data-toggle="tooltip"
																	data-placement="top" title="Adicionar" id="idCliente"
																	value="${cliente.id}">
																	<i class="zmdi zmdi-check"></i>
																</button>
															</div>
														</form>
													</td>
												</tr>
										</tbody>
										</c:forEach>
									</table>
								</c:when>
							</c:choose>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end modal clientes -->

		<!-- modal vendedor -->
		<div class="modal fade" id="ModalVendedor" tabindex="-1" role="dialog"
			aria-labelledby="staticModalLabel" aria-hidden="true"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticModalLabel">Vendedores</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p>This is a static modal, backdrop click will not close it.</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-primary">Confirmar</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end modal Vendedor -->

		<!-- modal CondPag -->
		<div class="modal fade" id="ModalCondPag" tabindex="-1" role="dialog"
			aria-labelledby="staticModalLabel" aria-hidden="true"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticModalLabel">Condi&#231;&#245;es
							de Pagamento</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p>This is a static modal, backdrop click will not close it.</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-primary">Confirmar</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end modal CondPag -->


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

</body>

</html>
<!-- end document-->