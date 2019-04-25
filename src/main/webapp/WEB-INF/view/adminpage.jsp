<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Conor's Store Home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Conor's Store</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/show-products">Products</a></li>
					<li><a href="/show-users">Customers</a></li>
					<li><a href="/add-product">Add Product</a></li>
					<li><a href="/logout">Logout</a></li>
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

		<c:when test="${mode=='MODE_ADD_PRODUCT' }">
			<div class="container text-center">
				<h3>Add Product</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-product">
					<input type="hidden" name="id" value="${product.id }" />
					
					
					
					
					<div class="form-group">
						<label class="control-label col-md-3">Title</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="title"
								value="${product.title }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Manufacturer</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="manufacturer"
								value="${product.manufacturer }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Category</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="category"
								value="${product.category}" />
						</div>
					</div>
					
					<%--  <div class="form-group">
							<label for="category" class="form-control-label">Category</label> <input
								type="text" class="form-control" value = "${product.category }"
								id="reason" list="reasons" />
							<datalist id="reasons">
								<option value="Home">
								<option value="TV">
								<option value="Phone">
							</datalist>
						</div> --%>
					<div class="form-group">
						<label class="control-label col-md-3">Price</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="price"
								value="${product.price }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Stock Amount</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="stockLevel"
								value="${product.stockLevel }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Image</label>
						<div class="col-md-5">
						<input type="file" name="image" value="${product.image }" />
						</div>
					</div>
					
					
					<div class="form-group ">
						<input type="submit" class="btn btn-success" value="Add Product"/>
					</div>
				</form>
			</div>
		</c:when>
	
		
		<c:when test="${mode=='ALL_PRODUCTS' }">
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
								<th>Delete</th>
								<th>Edit</th>
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
									        <td align="left"><a href="/delete-product?id=${product.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td align="left"><a href="/edit-product?id=${product.id }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
											<td> </td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_PRODUCT_UPDATE' }">
			<div class="container text-center">
				<h3>Update Product Info</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-product">
					<input type="hidden" name="id" value="${product.id }" />
					<input type="hidden" name="image" value="${product.image }" />
					
					
					
					<div class="form-group">
						<label class="control-label col-md-3">Title </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="title"
								value="${product.title }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Manufacturer</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="manufacturer"
								value="${product.manufacturer }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Category</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="category"
								value="${product.category }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Price</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="price"
								value="${product.price }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Stock Level</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="stockLevel"
								value="${product.stockLevel }" />
						</div>
					</div>
					
					<div class="form-group ">
						<input type="submit" class="btn btn-success" value="Update" />
					</div>
				</form>
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
					
				<c:when test="${mode=='ALL_USERS' }">
					<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
					<%@page import="io.conor.model.User"%>
					<%@page import="java.util.Iterator"%> 
					 
					<% ArrayList<User> users = (ArrayList) request.getAttribute("users"); %> <%--Assigning ArrayList object containing Employee data to the local object --%>
					 
					
					 <div class="container text-center" id="tasksDiv">
					 <h3>Users</h3>
					<table class="table table-dark table-hover" align ="center">
					 <thead>
					<tr>
					<th>User ID</th>
					<th>Email</th>
					<th>Username</th>
					<th>Password</th>
					<th>Delete</th>
					<th>Edit</th>
					</tr>
					</thead>
					<tbody>
					<%
					// Iterating through subjectList
					 
					if(request.getAttribute("users") != null)  // Null check for the object
					{
					 Iterator<User> iterator = users.iterator();  // Iterator interface
					 
					 while(iterator.hasNext())  // iterate through all the data until the last record
					 // iterate through all the data until the last record
					  {
					  User user = iterator.next(); //assign individual employee record to the employee class object
					  %>
					  <tr>
					  <td align="left"><%=user.getId()%></td>
					  <td align="left"><%=user.getEmail()%></td>
					  <td align="left"><%=user.getUsername()%></td>
					  <td align="left"><%=user.getPassword()%></td>
					 
					  <td align="left"><a href="/delete-user?id=<%=user.getId()%>"><span
																class="glyphicon glyphicon-trash"></span></a></td>
														<td align="left"><a href="/edit-user?id=<%=user.getId()%>"><span
																class="glyphicon glyphicon-pencil"></span></a></td>
																</tr>
					  <%
					  
					  }
					 }
					 %>
					 </tbody>
					 </table>
					 </div>
			<%-- <div class="container text-center" id="tasksDiv">
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
			</div> --%>
		</c:when>
	</c:choose>


	
	
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>