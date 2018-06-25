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
	var validaproduto = "vazio";
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
						<li><a href="DashboardServlet"> <i class="fas fa-tachometer-alt"></i>Painel
								Principal
						</a></li>
						<li class="active has-sub"><a class="js-arrow" href="#">
								<i class="fas fa-shopping-basket"></i>Vendas <span class="arrow">
									<i class="fas fa-angle-down"></i>
							</span>
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="#"> <i class="fas fa-pencil-square-o"></i>Or&ccedil;amento
								</a></li>
								<li><a href="ListarPedidoVendaServlet"> <i
										class="fas fa-shopping-cart"></i>Pedido de Venda
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
							<li><a href="DashboardServlet"> <i class="fas fa-tachometer-alt"></i>Painel
									Principal
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
									<li><a href="ListarNotasFiscais"> <i class="fas fa-print"></i>Nota
											Fiscal
									</a></li>
									<li><a href="#"> <i class="fas fa-file"></i>Relatóios
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
										placeholder="Cliente" class="form-control" disabled=""
										value="${cliente.id}">
								</div>
							</div>
						</div>
						<div class="col-6">
							<label for="clientenome" class="control-label mb-1">Nome
								do Cliente</label>
							<div class="input-group">
								<input id="clientenome" name="clientenome" type="text"
									class="form-control clientenome" value="${cliente.nome}"
									placeholder="Nome do Cliente" autocomplete="off" disabled="">

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-5">
							<div class="form-group">
								<label for="cpfcnpj" class="control-label mb-1">CPF/CNPJ
								</label> <input id="cpfcnpj" name="cpfcnpj" type="text"
									class="form-control cpfcnpj" value="${cliente.cpf}"
									placeholder="CPF/CNPJ" disabled="" autocomplete="cpfcnpj">
							</div>
						</div>
						<div class="col-5">
							<label for="ies" class="control-label mb-1">Inscri&#231;&#227;o
								Estadual</label>
							<div class="input-group">
								<input id="ies" name="ies" type="text" class="form-control ies"
									value="${cliente.inscricaoEstadual}" placeholder="IES"
									autocomplete="off" disabled="">

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label for="rua" class="control-label mb-1">Rua </label> <input
									id="rua" name="rua" type="text" class="form-control rua"
									value="${cliente.rua}" placeholder="Rua" disabled=""
									autocomplete="rua">
							</div>
						</div>
						<div class="col-2">
							<label for="nst" class="control-label mb-1">N&#250;mero</label>
							<div class="input-group">
								<input id="nst" name="nst" type="text" class="form-control nst"
									value="${cliente.numero}" placeholder="N&uacute;mero"
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
									value="${cliente.cidade}" placeholder="Cidade" disabled=""
									autocomplete="cdd">
							</div>
						</div>
						<div class="col-5">
							<label for="cmp" class="control-label mb-1">Complemento</label>
							<div class="input-group">
								<input id="cmp" name="cmp" type="text" class="form-control ies"
									value="${cliente.complemento}" placeholder="Complemento"
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
									<div class="input-group-btn">
										<button class="btn btn-primary" data-toggle="modal"
											data-target="#ModalCP">
											<i class="fa fa-search"></i> Buscar
										</button>
									</div>
									<input type="text" id="condpag" name="condpag"
										placeholder="Condi&ccedil;&atilde;o de Pagamento"
										class="form-control" disabled="" value="${condPag.descricao}">
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
								<input id="vendedor" name="vendedor" type="text"
									class="form-control vdd" value="${vendedor.nome}"
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
					<div style="text-align: right; display-inline: block;">
						<button class="au-btn au-btn-icon au-btn--green au-btn--small"
							data-toggle="modal" data-target="#ModalProdutos">
							<i class="zmdi zmdi-plus"></i>Adicionar Produto
						</button>
					</div>
					<c:choose>
						<c:when test="${not empty listaProdutosPedidoVenda}">
							<div class="table-responsive table-responsive-data2">
								<table class="table table-data2" id="tableProdutos">
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
										<c:forEach var="item" items="${listaProdutosPedidoVenda}">
											<tr class="tr-shadow">
												<td class="desc">${item.id}</td>
												<td>${item.produto.descricao}</td>
												<td class="desc">${item.produto.cor}</td>
												<td>${item.produto.tamanho}</td>
												<td><span class="status--process">${item.quantidade}</span></td>
												<td><span class="block-email">${item.valorUnitario}</span></td>
												<td><span class="block-email">${item.valorUnitario*item.quantidade}</span></td>
												<td>
													<div class="table-data-feature">
														<form action="DeletarProdutoServlet?idProduto=${item.id}"
															method="post">
															<button class="item" data-toggle="tooltip"
																data-placement="top" title="Deletar">
																<i class="zmdi zmdi-delete"></i>
															</button>
														</form>

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
							<script>
							validaproduto="produto";
							</script>
						</c:when>
						<c:otherwise>
							<br>
							<div class="alert alert-info">Nenhum Produto Inserido!</div>
							<script>
							validaproduto="vazio";
							</script>
						</c:otherwise>
					</c:choose>

					<!-- Finalização -->

					<div class="row">
						<div class="col-2">
							<div class="form-group">
								<label for="rua" class="control-label mb-1">Subtotal </label> <input
									id="sbtt" name="sbtt" type="text" class="form-control subtotal"
									value="${subTotal}" placeholder="0.00" disabled=""
									autocomplete="rua">
							</div>
						</div>
						<div class="col-2">
							<label for="nst" class="control-label mb-1">Desconto</label>
							<div class="input-group">
								<form action="PrePedidoVendaServlet" method="post">
									<div class="table-data-feature">
										<input id="nst" name="vlrDesconto" type="text"
											value="${desconto}" class="form-control-nst" value=""
											placeholder="${desconto}" autocomplete="off">
									</div>
									<div style="margin-top: 4px; margin-left: 4px">
										<button class="item" data-toggle="tooltip"
											data-placement="top" title="Confirmar desconto" id="desconto">
											<i class="zmdi zmdi-check"></i>
										</button>
									</div>
								</form>
							</div>
						</div>

						<div class="col-2">
							<label for="brr" class="control-label mb-1">Total</label>
							<div class="input-group">
								<input id="brr" name="brr" type="text" class="form-control brr"
									value="${valorTotal}" placeholder="${valorTotal}"
									autocomplete="off" disabled="">


							</div>
							<div class="col-2"></div>
						</div>
					</div>
					<div style="margin: 5px">
						<c:if test="${not empty utilizar}">
							<c:set value="1" scope="request" var="valor" />
						</c:if>
						<input value="1" type="checkbox" name="utilizarPontos"
							onClick="verUtilizacaoPontos(this)"
							<c:if test="${valor != null}">checked="checked"</c:if>>Utilizar
						pontos para gerar desconto
					</div>
				</div>
				<div style="text-align: right; display-inline: block;">
					<a href="ListarPedidoVendaServlet" type="button"
						class="btn btn-secondary" data-dismiss="modal">Cancelar</a>
					<form style="display: inline" action="InserirPedidoVendaServlet"
						method="post">
						<button class="btn btn-primary" type="submit" id="butfin"
							disabled="">Salvar</button>
					</form>
					<form style="display: inline" action="FaturarPedidoVendaServlet?inserir=true"
						method="post">
						<button class="btn btn-success" type="submit" id="butfin1"
							disabled="">Faturar</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- FIM DO FORMULﾁRIO DE PEDIDOS -->


	<!-- modal produtos -->
	<div class="modal fade" id="ModalProdutos" tabindex="-1" role="dialog"
		aria-labelledby="staticModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog modal-sm" role="document"
			style="max-width: 100%; width: auto; display: table;">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticModalLabel">Produtos</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<c:choose>
						<c:when test="${not empty listaProdutos}">
							<div class="table-data__tool">
								<div class="table-data__tool-left">
									<button class="au-btn-filter">
										<i class="zmdi zmdi-filter-list"></i>Filtrar
									</button>
								</div>
							</div>
							<div class="table-responsive table-responsive-data2">
								<table class="table table-data2" id="tableProdutos">
									<thead>
										<tr>
											<th>ID</th>
											<th>Descri&ccedil;&atilde;o</th>
											<th>Cor</th>
											<th>Tamanho</th>
											<th>Estoque</th>
											<th>Pre&ccedil;o</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="produto" items="${listaProdutos}">
											<tr class="tr-shadow">
												<td class="desc">${produto.id}</td>
												<td>${produto.descricao}</td>
												<td class="desc">${produto.cor}</td>
												<td>${produto.tamanho}</td>
												<td><input type="text" id="estoque" name="estoque"
													placeholder="${produto.quantidadeEstoque}" class="estoque"
													align="center" disabled=""></td>
												<td><span class="block-email">${produto.preco}</span></td>
												<td>
													<form
														action="InserirProdutoServlet?idProduto=${produto.id}"
														method="post" id="formProdutos" name="formProdutos">
														<div class="table-data-feature">
															<input type="text" id="qtdProduto" name="qtdProduto"
																placeholder="Quantidade" class="form-control"
																align="center">
															<button class="item" data-toggle="tooltip"
																data-placement="top" title="Adicionar ao Pedido"
																data-toggle="modal" data-target="#modalQuantia"
																disabled="">
																<i class="zmdi zmdi-assignment-check"></i>
															</button>
														</div>
													</form>
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
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>
	<!-- end modal produtos -->

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
								<input class="form-control" id="buscaClientes" type="text"
									placeholder="Buscar cliente..." />
								<table class="table table-borderless table-data3">
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
										</c:forEach>
									</tbody>
								</table>
							</c:when>
							<c:otherwise>
								<div class="alert alert-info">Nenhum Cliente Cadastrado!</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>
	<!-- end modal clientes -->

	<!-- modal vendedor -->
	<div class="modal fade" id="ModalVendedor" tabindex="-1" role="dialog"
		aria-labelledby="staticModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog modal-sm" role="document"
			style="max-width: 100%; width: auto; display: table;">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticModalLabel">Vendedores</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="table-responsive m-b-40">
						<c:choose>
							<c:when test="${not empty listaVendedores}">
								<input class="form-control" id="buscaVendedores" type="text"
									placeholder="Buscar vendedor...">
								<table class="table table-borderless table-data3">
									<thead>
										<tr>
											<th>Cod. Vendedor</th>
											<th>Nome</th>
											<th></th>
										</tr>
									</thead>
									<tbody id="tabelaVendedores">
										<c:forEach var="vendedor" items="${listaVendedores}">
											<tr>
												<td>${vendedor.id}</td>
												<td>${vendedor.nome}</td>
												<td>
													<form
														action="InserirVendedorServlet?idVendedor=${vendedor.id}"
														method="post">
														<div class="table-data-feature">
															<button class="item" data-toggle="tooltip"
																data-placement="top" title="Adicionar" id="idVendedor"
																value="${vendedor.id}">
																<i class="zmdi zmdi-check"></i>
															</button>
														</div>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:when>
							<c:otherwise>
								<div class="alert alert-info">Nenhum Vendedor Cadastrado!</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>
	<!-- end modal Vendedor -->

	<!-- modal CondPag -->
	<div class="modal fade" id="ModalCP" tabindex="-1" role="dialog"
		aria-labelledby="staticModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog modal-sm" role="document"
			style="max-width: 100%; width: auto; display: table;">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticModalLabel">Condi&#231;&otilde;es
						de Pagamento</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="table-responsive m-b-40">
						<c:choose>
							<c:when test="${not empty listaCondPag}">
								<input class="form-control" id="buscaCP" type="text"
									placeholder="Buscar condi&ccedil;&atilde;o...">
								<table class="table table-borderless table-data3">
									<thead>
										<tr>
											<th>Cod. Condi&#231;&atilde;o de Pagamento</th>
											<th>Descri&ccedil;&atilde;o</th>
											<th></th>
										</tr>
									</thead>
									<tbody id="tabelaCP">
										<c:forEach var="cp" items="${listaCondPag}">
											<tr>
												<td>${cp.id}</td>
												<td>${cp.descricao}</td>
												<td>
													<form action="InserirCondPagamentoServlet?idCP=${cp.id}"
														method="post">
														<div class="table-data-feature">
															<button class="item" data-toggle="tooltip"
																data-placement="top" title="Adicionar" id="idCP"
																value="${cp.id}">
																<i class="zmdi zmdi-check"></i>
															</button>
														</div>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:when>
							<c:otherwise>
								<div class="alert alert-info">Nenhuma Condição de
									Pagamento Cadastrada!</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
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
			if (campo.checked) {
				location.href = "PrePedidoVendaServlet?utilizarPontos=true";
			} else {
				location.href = "PrePedidoVendaServlet?utilizarPontos=false";
			}
	
		}
	</script>


	*
	<script type="text/javascript">
		//Script de Validação de Quantidade de Produto
		$(function() {
	
			var $tblrows = $("#tableProdutos tbody tr");
			$tblrows.each(function(index) {
	
				var $tblrow = $(this);
	
				$tblrow.find('.form-control').on('change', function() {
					$tblrow.find('.item').attr('disabled', false);
					var quantidade = $tblrow.find(".form-control").val();
					var quantidade = parseInt(quantidade);
					var estoque = $tblrow.find(".estoque").attr('placeholder');
					var estoque = parseInt(estoque);
	
					if (!isNaN(quantidade) && quantidade != 0) {
	
						if (quantidade > estoque) {
							$('.form-control').val('');
							$tblrow.find('.item').attr('disabled', true);
							alert("Quantia n&atilde;o pode ser maior do que o estoque.");
						}
					}
	
					if (quantidade <= 0 || isNaN(quantidade)) {
	
						$('.form-control').val('');
						$tblrow.find('.item').attr('disabled', true);
						alert("Quantia inválida!");
	
					}
				});
			});
		});
	</script>

	<script type="text/javascript">
	//Script de Validação de Desconto
	
		$(function() {
	
	
			var nst = $('#nst').val();
			var subtotal = $('#sbtt').val();
	
			$('.col-2').on('change', '#nst', function() {
	
				var desconto = $(".form-control-nst").val();
				var desconto = parseFloat(desconto);
	
	
				if (!isNaN(desconto) && desconto != 0 && !isNaN(subtotal) && subtotal != 0) {
	
					if (desconto < 0 || desconto > subtotal) {
						alert("Valor de desconto inv&aacute;lido!");
						$('.form-control-nst').val('');
					}
	
				}
	
	
			});
	
	
	
		});
	</script>

	<script type="text/javascript">
	//Script de Validação de Pedido
	
		$(function() {
	

			var cli = $('#clientecod').val();
			var cpag = $('#condpag').val();
			var vend = $('#vendedor').val();
			
				
				if(cli!="" && cpag!="" && vend!="" && validaproduto!="vazio") {
					$('#butfin').attr('disabled', false);
					$('#butfin1').attr('disabled', false);
				}
				
	
		});
	</script>


</body>

</html>
<!-- end document-->