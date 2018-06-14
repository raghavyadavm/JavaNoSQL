<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.Console"%>	

<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>TPC C Bench Mark</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/simple-sidebar.css" rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>


</head>

<body>

    <div id="wrapper">
       <!-- Page Content -->
		<div id="page-content-wrapper">
		 <div class="container-fluid">
			<div class="container">
				
				<form class="form-horizontal" id="contact-form" role="form"
					action="<%=application.getContextPath() %>/Transaction" method="post">
					<div class="form-group">
					<div class="col-sm-4">
					<h2 >New Order Selection</h2>
					</div>
					</div>
					
					<div class="form-group">
							<label class="col-sm-2 control-label" for="warehouse">Warehouse</label>
							<div class="col-sm-4">
								<select class="selectpicker form-control"
									
									id="warehouse" name="warehouse">
									<option style="cursor: pointer;">Select Warehouse</option>
									
									<option style="cursor: pointer;" value ="1">1</option>
									<option style="cursor: pointer;" value ="2">2</option>
									
								</select>

							</div>
					</div>
					
					<div class="form-group">
							<label class="col-sm-2 control-label" for="district">District</label>
							<div class="col-sm-4">
								<select class="selectpicker form-control"
									
									id="district" name="district">
									<option style="cursor: pointer;">Select District</option>
									
									<option style="cursor: pointer;" value ="1">1</option>
									<option style="cursor: pointer;" value ="2">2</option>
									<option style="cursor: pointer;" value ="3">3</option>
									<option style="cursor: pointer;" value ="4">4</option>
									<option style="cursor: pointer;" value ="5">5</option>
									<option style="cursor: pointer;" value ="6">6</option>
									<option style="cursor: pointer;" value ="7">7</option>
									<option style="cursor: pointer;" value ="8">8</option>
									<option style="cursor: pointer;" value ="9">9</option>
									<option style="cursor: pointer;" value ="10">10</option>
									
								</select>

							</div>
					</div>
					
					<div class="form-group">
						<label for="customer" class="col-sm-2 control-label">Customer</label>
						<div class="col-sm-4">
							<input type="text" id="customer" name="customer"
								placeholder="Customer id"  class="form-control"  >

						</div>
					</div>	
					
					
					
					<div class="form-group">
						<label for="OL_I_ID" class="col-sm-2 control-label">OL_I_ID</label>
						<div class="col-sm-4">
							<input type="text" id="OL_I_ID" name="OL_I_ID"
								placeholder="OL_I_ID"  class="form-control"  >

						</div>
					</div>		
					
					<div class="form-group">
						<label for="OL_Supply_W_ID" class="col-sm-2 control-label">OL_Supply_W_ID</label>
						<div class="col-sm-4">
							<input type="text" id="OL_Supply_W_ID" name="OL_Supply_W_ID"
								placeholder="OL_Supply_W_ID" class="form-control" >

						</div>
					</div>

					<div class="form-group">
						<label for="OL_Quantity" class="col-sm-2 control-label">OL_Quantity</label>
						<div class="col-sm-4">
							<input type="number" id="OL_Quantity" name="OL_Quantity" placeholder="OL_Quantity"
								class="form-control">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-2 col-sm-offset-3">
							<button type="submit" class="btn btn-primary btn-block">Transact</button>
						</div>
					</div>
					
				</form>
				<!-- /form -->
			</div>
			<!-- ./container -->
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	

	<!-- Menu Toggle Script -->
	<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>