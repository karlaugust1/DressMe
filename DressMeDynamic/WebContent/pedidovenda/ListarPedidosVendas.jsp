<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<main class="container">
	<h1 class="pb-2 display-4">Lista de pedidos de venda</h1>
	<form action="/DressMeDynamic/ListarPedidoVendaServlet" method="post">
		<c:choose>
			<c:when test="${not empty listaPedidosVendas}">
				<div class="table-responsive table--no-card m-b-30">
					<table class="table table-borderless table-striped table-earning">
						<thead>
							<tr>
								<th>Data Abertura</th>
								<th>Número</th>
								<th>Cliente</th>
								<th class="text-right">Subtotal</th>
								<th class="text-right">Descontos</th>
								<th class="text-right">Total</th>
							</tr>
						</thead>
						<c:forEach var="venda" items="${listaPedidosVendas}">
							<tr>
								<td>${venda.dataAbertura}</td>
								<td>${venda.numero}</td>
								<td>${venda.cliente}</td>
								<td>${venda.subtotal}</td>
								<td>${venda.desconto}</td>
								<td>${venda.total}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<br>
				<div class="alert alert-info">Nenhum registro encontrado!</div>
			</c:otherwise>
		</c:choose>
	</form>
	</main>
</html>