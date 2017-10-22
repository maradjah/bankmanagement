<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Bank Manager v1.01 By Maradjah</title>

<link rel="stylesheet" type="text/css"
	href="css/dataTables/semantic.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/dataTables/dataTables.semanticui.min.css" />

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<!-- <link href="vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet"> -->


<link rel="stylesheet" type="text/css"
	href="css/dataTables/jquery.dataTables.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/Select/select.dataTables.min.css" />


<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Bank Manager 1.1</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i
						class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-messages">
						<li><a href="#">
								<div>
									<strong>Bank Admin</strong> <span class="pull-right text-muted">
										<em>Yesterday</em>
									</span>
								</div>
								<div>Account created</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>Read
									All Messages</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> <!-- /.dropdown-messages --></li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> Profile</a>
						</li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="index.html"><i class="fa fa-home fa-fw"></i>
								Home</a></li>
						<li><a href="#"><i class="fa fa-dollar fa-fw"></i>
								Accounts<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="flot.html"><span class="fa fa-plus"></span>
										New Account</a></li>
								<li><a href="morris.html"><span class="fa fa-pencil"></span>
										Edit Accounts</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="#"><i class="fa fa-user fa-fw"></i>
								Customers<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="panels-wells.html"><span
										class="fa fa-plus"></span> New Customer</a></li>
								<li><a href="buttons.html"><span class="fa fa-pencil"></span>
										Edit Customer</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Customers</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12 col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3"></div>
								<div class="col-xs-12 text-center">
									<div class="">
										<label id="customersTotalnumber"></label>
									</div>
									<div>Customers</div>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<table class="ui padded table" cellspacing="0" width="100%"
								id="tableCust">
								<thead>
									<tr>
										<th>Customer Id</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>City</th>
										<th>Street</th>
										<th>Zip</th>
										<th>Phone</th>
										<th>Email</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-8">
						<div class="panel panel-danger" id="customerForm">
							<div class="panel-heading ">
								<i class="fa fa-bar-chart-o fa-fw"></i> <label
									id="customerFormHeader"></label>
							</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<form id="formInfo">
									<div class="form-row">
										<div class="form-group col-md-4">
											<label class="col-form-label">Code Customer </label> <input
												type="text" class="form-control" id="inputCustomerCode"
												placeholder="Customer Code" readonly>
										</div>
										<div class="form-group col-md-4">
											<label class="col-form-label">First Name *</label> <input
												type="text" class="form-control" id="inputFirstName"
												placeholder="First Name">
										</div>
										<div class="form-group col-md-4">
											<label class="col-form-label">Last Name *</label> <input
												type="text" class="form-control" id="inputLastName"
												placeholder="Last Name">
										</div>
									</div>
									<div class="form-group">
										<label class="col-form-label">Address *</label> <input
											type="text" class="form-control" id="inputAddress"
											placeholder="1234 Main St">
									</div>
									<div class="form-row">
										<div class="form-group col-md-8">
											<label for="" class="col-form-label">Email </label> <input
												type="email" class="form-control" id="inputEmail"
												placeholder="email">

										</div>
										<div class="form-group col-md-4">
											<label class="col-form-label">Phone *</label> <input
												type="text" placeholder="Phone" class="form-control"
												id="inputPhone">
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-6">
											<label class="col-form-label">City *</label> <input
												type="text" placeholder="City" class="form-control"
												id="inputCity">
										</div>
										<div class="form-group col-md-4">
											<label class="col-form-label">State</label> <input
												type="text" placeholder="State" class="form-control"
												id="inputState">
										</div>
										<div class="form-group col-md-2">
											<label f class="col-form-label">Zip *</label> <input
												type="text" placeholder="Zip" class="form-control"
												id="inputZip">
										</div>
									</div>
									<div class="row">

										<div class=" col-md-12">

											<div class="big ui buttons">
												<a class="ui red basic huge label" id="errorMessage"></a>
												<button type="button" id="addCustomerBtn"
													class="ui green button" onclick="addCustomer()">Add</button>
												<div class="or" data-text=""></div>
												<button type="button" id="editCustomerBtn"
													class="ui yellow button" onclick="editCustomer()">Edit</button>
												<div class="or" data-text=""></div>
												<button type="button" id="deleteCustomerBtn"
													class="ui red button" onclick="deleteCustomer()">Delete</button>
												<div class="or" data-text=""></div>
												<!-- ********************************************************* -->

												<button type="button" id="addAccountBtn"
													class="btn btn-large btn-primary" data-toggle="modal"
													data-target="#myModal" onclick="fillModalForm()">Add
													Account</button>


												<!-- ********************************************************* -->
												<!-- <div class="ui teal button" data-title="Event" 
												data-content="Text Content">Add Account</div> -->

												<div class="or" data-text=""></div>
												<button type="button" id="clearBtn" class="ui purple button"
													onclick="return clearForm()">Clear</button>
												<a class="ui green basic huge label" id="successMessage"></a>
											</div>

											<div id="myModal" class="modal fade">
												<div class="modal-dialog modal-lg">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">&times;</button>
															<h4 class="modal-title">Add Account</h4>
														</div>
														<div class="modal-body">
															<form id="createAccountForm">
																<div class="form-row">
																	<div class="form-group col-md-3">
																		<label class="col-form-label">Code Customer </label> <input
																			type="text" class="form-control"
																			id="inputCustomerCodeForm"
																			placeholder="Customer Code" readonly>
																	</div>
																	<div class="form-group col-md-4">
																		<label class="col-form-label">First Name</label> <input
																			type="text" class="form-control"
																			id="inputFirstNameForm" placeholder="First Name"
																			readonly>
																	</div>
																	<div class="form-group col-md-5">
																		<label class="col-form-label">Last Name</label> <input
																			type="text" class="form-control"
																			id="inputLastNameForm" placeholder="Last Name"
																			readonly>
																	</div>
																</div>
																<div class="form-row">
																	<div class="form-group col-md-3">
																		<label class="col-form-label">Account Type </label> <select
																			class="form-control" id="selectAccountTypeForm">
																			<option>Checking</option>
																			<option>Savings</option>
																			<option>Money Market</option>
																			<option>Retirement</option>
																			<option>Time Deposit</option>
																		</select>
																	</div>
																	<div class="form-group col-md-2">
																		<label class="col-form-label">Solde</label>
																		<div class="form-group input-group">
																			<span class="input-group-addon"><i
																				class="fa fa-eur"></i> </span> <input type="text"
																				class="form-control" id="inputBalanceForm"
																				placeholder="Balance">
																		</div>
																	</div>
																	<div class="form-group col-md-7">
																		<label class="col-form-label">Description</label> <input
																			type="text" class="form-control"
																			id="inputDescriptionForm" placeholder="Description">
																	</div>
																</div>
															</form>
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-default"
																data-dismiss="modal" onclick="emptyFormFields()">Cancel</button>
															<button type="button" data-dismiss="modal"
																class="btn btn-primary" onclick="addAccount()">Add
																Account</button>
														</div>
													</div>
												</div>
											</div>

										</div>

									</div>
								</form>
							</div>
							<!-- /.panel-body -->
						</div>
					</div>
					<!-- /.col-lg-8 -->
					<div class="col-lg-4">
						<div class="panel panel-success" id="customerAccountsForm">
							<div class="panel-heading">
								<i class="fa fa-bell fa-fw"></i> <label id="tableAccountHeader">Customer
									Accounts</label>
							</div>
							<div class="panel-body">
								<table class="ui green table" cellspacing="0" width="100%"
									id="tableAccount">
									<thead>
										<tr>
											<th>Description</th>
											<th>Balance</th>
											<th>Creation Date</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
						<!-- /.panel -->
					</div>

					<!-- /.col-lg-4 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->
	</div>
	<!-- jQuery -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<%-- <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script> --%>


	<!-- Bootstrap Core JavaScript -->
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="vendor/metisMenu/metisMenu.min.js"></script>


	<script type="text/javascript"
		src="js/dataTables/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="js/dataTables/dataTables.semanticui.min.js"></script>
	<script type="text/javascript" src="js/dataTables/semantic.min.js"></script>


	<script type="text/javascript" src="js/Select/dataTables.select.min.js"></script>


	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script src="js/myJs.js"></script>

</body>
</html>