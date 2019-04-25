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
				<h2>Total payment: ${totalPrice}</span></h2>
				<form class="form-horizontal" method="POST" action="purchaseCart">
					<input type="hidden" name="id" value="${user.id }" />
					
					</n>
					</n>
					</n>
					</n>
					</n>
					</n>
					
					</n>
					</n>
					</n>
					
					
					
					<div class="form-group">
                        <label class="col-form-label" for="payment_method">Select Payment Method: </label>
                        <select class="form-control" id="payment_method" name="payment_method" value ="${payment_method}">
                            <option value="default">Select a payment method</option>
                            <option value="Visa">Visa</option>
                            <option value="Mastercard">Mastercard</option>
                        </select>
                        <br/>
                        <p> </p>
                    </div>
						
					<div class="form-group">
						<label class="control-label col-md-3">Card Name</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="cardName"
								value="${cardName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Card Number</label>
						<div class="col-md-5">
							<input type="number" class="form-control" name="cardNum"
								value="${cardNum}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Expiry Date</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="expDate"
								value="${expDate}" />
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