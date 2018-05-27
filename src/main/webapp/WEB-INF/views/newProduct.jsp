<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/views/Layout/TagLib.jsp"%>

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

	<div>
		<c:choose>
			<c:when test='${title=="New Product"}'>
				<spring:url value="/admin/product/add" var="url" />
			</c:when>
			<c:when test='${title=="Edit Product"}'>
				<spring:url value="/admin/product/edit" var="url" />
			</c:when>
		</c:choose>
		<div class="row sign" style="padding-bottom: 30px;">
			<div class="container col-lg-4 col-lg-offset-9 "
				style="text-align: center;">

				<div class="input-text">
					<h2>${headerMSG}</h2>
					<br /> <br />
					<form:form commandName="product" cssClass="form-horizontal"
						action="${url}" method="POST">

						<c:if test='${title=="Edit Product"}'>
							<form:hidden path="id" class="form-control"></form:hidden>
						</c:if>
						<div class="form-group col-lg-12 col-lg-offset-5 act">
							<form:label class="form-group col-lg-4 col-lg-offset-0 "
								path="name">Name</form:label>
							<form:input path="name"
								cssClass="form-group col-lg-6 col-lg-offset-5 act"
								placeholder="Type your name" />
						</div>

						<div class="form-group col-lg-12 col-lg-offset-5">
							<form:errors path="name" cssStyle="color:#f00;"></form:errors>
						</div>

						<div class="form-group col-lg-12 col-lg-offset-0 act">
							<form:label class="form-group col-lg-4 col-lg-offset-0 "
								path="description">Description</form:label>
							<form:input path="description"
								cssClass="form-group col-lg-6 col-lg-offset-5 act"
								placeholder="Type your description" />
						</div>

						<div class="form-group col-lg-12 col-lg-offset-5">
							<form:errors path="description" cssStyle="color:#f00;"></form:errors>
						</div>

						<div class="form-group col-lg-12 col-lg-offset-0 act">
							<form:label class="form-group col-lg-4 col-lg-offset-0 "
								path="price">Price</form:label>
							<form:input path="price"
								cssClass="form-group col-lg-6 col-lg-offset-5 act"
								placeholder="Type your price" />
						</div>

						<div class="form-group col-lg-12 col-lg-offset-5">
							<form:errors path="price" cssStyle="color:#f00;"></form:errors>
						</div>


						<div class="form-group col-lg-12 col-lg-offset-0 act">
							<form:label class="form-group col-lg-4 col-lg-offset-0 "
								path="quantity">Quantity</form:label>
							<form:input path="quantity"
								cssClass="form-group col-lg-6 col-lg-offset-5 act"
								placeholder="Type your quantity" />
						</div>

						<div class="form-group col-lg-12 col-lg-offset-5">
							<form:errors path="quantity" cssStyle="color:#f00;"></form:errors>
						</div>

						<div class="form-group col-lg-12 col-lg-offset-0 act">
							<form:label class="form-group col-lg-4 col-lg-offset-0 "
								path="inStock">Stock</form:label>
							<form:input path="inStock"
								cssClass="form-group col-lg-6 col-lg-offset-5 act"
								placeholder="is in Stock" />
						</div>

						<div class="form-group col-lg-12 col-lg-offset-5">
							<form:errors path="inStock" cssStyle="color:#f00;"></form:errors>
						</div>

						<div class="size12 trans-0-4 m-t-10 m-b-10 m-r-10">
							<button type="submit"
								class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
								new Product</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>



	</div>

	<jsp:include page="footer.jsp" />


	<!-- 	=============================================================================================== -->

	<spring:url value="/resources/vendor/jquery/jquery-3.2.1.min.js"
		var="kmhome1"></spring:url>
	<script src="${kmhome1}"></script>
	<!-- 	=============================================================================================== -->
	<spring:url value="/resources/vendor/animsition/js/animsition.min.js"
		var="kmhome2"></spring:url>
	<script src="${kmhome2}"></script>
	<!-- 	=============================================================================================== -->
	<spring:url value="/resources/vendor/bootstrap/js/popper.js"
		var="kmhome3"></spring:url>
	<script src="${kmhome3}"></script>
	<!-- 	=============================================================================================== -->
	<spring:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"
		var="kmhome4"></spring:url>
	<script src="${kmhome4}"></script>
	<!-- 	=============================================================================================== -->
	<spring:url value="/resources/vendor/select2/select2.min.js"
		var="kmhome5"></spring:url>
	<script src="${kmhome5}"></script>

	<!-- 	<script type="text/javascript"> -->
	<!-- // $(".selection-1").select2({ // minimumResultsForSearch : 20, // -->
	<!-- dropdownParent : $('#dropDownSelect1') // }); -->
	<!-- 	</script> -->
	<!-- 	=============================================================================================== -->
	<spring:url value="/resources/vendor/slick/slick.min.js" var="kmhome6"></spring:url>
	<script src="${kmhome6}"></script>


	<spring:url value="/resources/js/slick-custom.js" var="kmhome7"></spring:url>
	<script src="${kmhome7}"></script>
	<!-- 	=============================================================================================== -->
	<spring:url value="/resources/vendor/countdowntime/countdowntime.js"
		var="kmhome8"></spring:url>
	<script src="${kmhome8}"></script>
	<!-- 	=============================================================================================== -->
	<spring:url value="/resources/vendor/lightbox2/js/lightbox.min.js"
		var="kmhome9"></spring:url>
	<script src="${kmhome9}"></script>
	<!-- 	=============================================================================================== -->
	<spring:url value="/resources/vendor/sweetalert/sweetalert.min.js"
		var="kmhome11"></spring:url>
	<script src="${kmhome11}"></script>

	<!-- 	<script type="text/javascript"> -->
	<!-- 	// $('.block2-btn-addcart').each( // function() { // var nameProduct = -->
	<!-- 	$(this).parent().parent().parent().find( // '.block2-name').html(); // -->
	<!-- 	$(this).on('click', function() { // swal(nameProduct, "is added to cart -->
	<!-- 	!", "success"); // }); // }); // $('.block2-btn-addwishlist').each( // -->
	<!-- 	function() { // var nameProduct = -->
	<!-- 	$(this).parent().parent().parent().find( // '.block2-name').html(); // -->
	<!-- 	$(this).on('click', function() { // swal(nameProduct, "is added to -->
	<!-- 	wishlist !", "success"); // }); // }); -->
	<!-- 	</script> -->

	<!-- 	=============================================================================================== -->
	<spring:url value="/resources/vendor/parallax100/parallax100.js"
		var="kmhome12"></spring:url>
	<script src="${kmhome12}"></script>

	<script type="text/javascript">
		// $('.parallax100').parallax100();
	</script>
	<!-- 	=============================================================================================== -->
	<spring:url value="/resources/js/main.js" var="kmhome13"></spring:url>
	<script src="${kmhome13}"></script>
</body>
</html>