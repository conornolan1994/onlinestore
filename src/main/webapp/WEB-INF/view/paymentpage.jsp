<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Conor's Store</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-expand-sm bg-default navbar-light">
			<a href="/welcome" class="navbar-brand">Conor's Shop</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				
					<li><a href="/logout">Log Out</a></li>
					<li><a href="/products">Products</a>
					<li><a href="/cart">Cart</a>
					
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		

		<c:when test="${mode=='MODE_PAYMENT' }">
			<div class="container text-center">
				<h3>Payment</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="purchaseCart">
					<input type="hidden" name="id" value="${user.id }" />
					
					
					
					
					<tr>
									<td align="left"><b>Total Price = </b></td>
									<td align="left"><b>${totalPrice}</b></td>
									</tr>
									<tr>
									<td align="left">${user.username}</td>
									</tr>
					<div class="form-group">
						<label class="control-label col-md-3">username</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Shipping Address</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="shippingAddress"
								value="${user.shippingAddress }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-5">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					
					
					<div class="form-group ">
						<input type="submit" class="btn btn-success" value="Purchase" />
					</div>
				</form>
			</div>
		</c:when>
		</c:choose>
		
		</body>

	
	
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>