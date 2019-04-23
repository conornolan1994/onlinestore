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
				
					<li><a href="/login">Login</a></li>
					<li><a href="/register">Register</a></li>
					<li><a href="/products">Products</a>
					
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME' }">
			<div class="container-expand-sm bg-default navbar-dark"" id="homediv">
				<div class="jumbotron text-center">
					<h1>Welcome</h1>
					<h3></h3>
				</div>
			</div>

		</c:when>

		<c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
				<h3>User Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
					<input type="hidden" name="id" value="${user.id }" />
					
					
					
					
					<div class="form-group">
						<label class="control-label col-md-3">email</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="email"
								value="${user.email }" />
						</div>
					</div>
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
						<input type="submit" class="btn btn-success" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='ALL_USERS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Users</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-dark table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Email Address</th>
								<th>Username</th>
								<th>Password</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users }">
								<tr>
									<td>${user.id}</td>
									<td>${user.email}</td>
									<td>${user.username}</td>
									<td>${user.password}</td>
									
									<td><a href="/delete-user?id=${user.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="/edit-user?id=${user.id }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_SHOPPING_CART' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Products</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-dark table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Title</th>
								<th>Manufacturer</th>
								<th>Category</th>
								<th>Price</th>
								<th>Stock Level</th>
								<th>Image</th>
								<th>Remove from Cart</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${shoppingCart }">
								<tr>
									<td align="left">${product.id}</td>
									<td align="left">${product.title}</td>
									<td align="left">${product.manufacturer}</td>
									<td align="left">${product.category}</td>
									<td align="left">${product.price}</td>
									<td align="left">${product.stockLevel }</td>
									<td align="left"><div style=""><img border="3"  
									        src="resources/images/${product.image}" height="145" width="145" /></div>
									        <td align="left"><a href="/cart?id=${product.id }"><span
											class="glyphicon glyphicon-shopping-cart"  style="font-size:40px"></span></a></td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='ALL_PRODUCTS_CUSTOMER' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Products</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-dark table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Title</th>
								<th>Manufacturer</th>
								<th>Category</th>
								<th>Price</th>
								<th>Stock Level</th>
								<th>Image</th>
								<th>Add to Cart</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${products }">
								<tr>
									<td align="left">${product.id}</td>
									<td align="left">${product.title}</td>
									<td align="left">${product.manufacturer}</td>
									<td align="left">${product.category}</td>
									<td align="left">${product.price}</td>
									<td align="left">${product.stockLevel }</td>
									<td align="left"><div style=""><img border="3"  
									        src="resources/images/${product.image}" height="145" width="145" /></div>
									        <td align="left"><a href="/cart?id=${product.id }"><span
											class="glyphicon glyphicon-shopping-cart"  style="font-size:40px"></span></a></td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		

		<c:when test="${mode=='MODE_UPDATE' }">
			<div class="container text-center">
				<h3>Update User Info</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
					<input type="hidden" name="id" value="${user.id }" />
					
					
					
					<div class="form-group">
						<label class="control-label col-md-3">Email </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="email"
								value="${user.email }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					
					<div class="form-group ">
						<input type="submit" class="btn btn-success" value="Update" />
					</div>
				</form>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3> Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-user">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="email"
								value="${user.email }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
					</form>
					</div>
					</c:when>
	</c:choose>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>