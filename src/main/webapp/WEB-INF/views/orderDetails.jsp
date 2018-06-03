<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/views/Layout/TagLib.jsp"%>
<title>Product</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="<spring:url value="/resources/images/icons/favicon.png"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/fonts/themify/themify-icons.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/fonts/elegant-font/html-css/style.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/vendor/animate/animate.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/vendor/css-hamburgers/hamburgers.min.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/vendor/animsition/css/animsition.min.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/vendor/select2/select2.min.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/vendor/daterangepicker/daterangepicker.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/vendor/slick/slick.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/vendor/lightbox2/css/lightbox.min.css"/>"
	type="text/css" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="<spring:url value="/resources/css/main.css"/>" type="text/css" />

<link rel="stylesheet"
	href="<spring:url value="/resources/css/util.css"/>" type="text/css" />
<spring:url value="/resources/css/util.css" var="kmhome16"></spring:url>
<script src="${kmhome16}"></script>
<!--===============================================================================================-->
<spring:url value="/resources/css/main.css" var="kmhome15"></spring:url>
<script src="${kmhome15}"></script>
<!--===============================================================================================-->


</head>
<body class="animsition">

	<jsp:include page="header.jsp" />

	<section class="cart bgwhite p-t-70 p-b-100">
		<div class="container">
			<table class="table-shopping-cart">
				<tr class="table-head">
					<%-- 			<c:forEach items="${orders}" var="order"> --%>
					<c:forEach items="${orders.cart.cartItemList}" var="cartItem">

						<td class="column-7">${cartItem.product.price * cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.quantity}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.product.id}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>
						<td class="column-7">${cartItem.name}</td>

					</c:forEach>
				</tr>
			</table>
		</div>
	</section>

</body>


<jsp:include page="footer.jsp" />
</html>
