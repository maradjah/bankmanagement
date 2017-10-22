$(document).ready(function() {
	document.getElementById("addCustomerBtn").disabled = false;
	document.getElementById("editCustomerBtn").disabled = true;
	document.getElementById("deleteCustomerBtn").disabled = true;
	document.getElementById("addAccountBtn").disabled = true;
	document.getElementById("clearBtn").disabled = true;

	$('#customerAccountsForm').hide();
	var table = $('#tableCust').dataTable();

	loadCustomersData();

	$('#tableCust tbody').on('click', 'tr', function() {

		if ($(this).hasClass('selected')) {
			$('#customerAccountsForm').hide();
			clearForm();
			$(this).removeClass('selected');
			document.getElementById("addCustomerBtn").disabled = false;
			document.getElementById("editCustomerBtn").disabled = true;
			document.getElementById("deleteCustomerBtn").disabled = true;
			document.getElementById("addAccountBtn").disabled = true;
			document.getElementById("clearBtn").disabled = true;

		} else {
			$('#customerAccountsForm').show();
			document.getElementById("addCustomerBtn").disabled = true;
			document.getElementById("editCustomerBtn").disabled = false;
			document.getElementById("deleteCustomerBtn").disabled = false;
			document.getElementById("addAccountBtn").disabled = false;
			document.getElementById("clearBtn").disabled = false;
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');

			var rowData = table.api().row(this).data();
			window.customerId = rowData.customerId;
			window.firstName = rowData.firstName;
			window.lastName = rowData.lastName;
			window.street = rowData.street;
			window.city = rowData.city;
			window.zip = rowData.zip;
			window.phone = rowData.phone;
			window.email = rowData.email;
			/*********** populate customer info form **************************/

			document.getElementById("inputCustomerCode").value = customerId;
			document.getElementById("inputFirstName").value = firstName;
			document.getElementById("inputLastName").value = lastName;
			document.getElementById("inputAddress").value = street;
			document.getElementById("inputCity").value = city;
			document.getElementById("inputState").value = city;
			document.getElementById("inputZip").value = zip;
			document.getElementById("inputPhone").value = phone;
			document.getElementById("inputEmail").value = email;
			/******************************************************************/
			getCustomerAccounts(customerId, lastName);
		}
	});
});

/************** function to get accounts of selected customer ****************/

function getCustomerAccounts(customerId, lastName) {
	$.ajax({
		url : "custJsonAccounts" + "?customerId=" + customerId,
		type : 'POST',
		contentType : "application/json; charset=utf-8",
		dataType : 'json',

		success : function(response) {
			document.getElementById('tableAccountHeader').innerHTML = lastName
					+ "'s Account(s)";
			document.getElementById('customerFormHeader').innerHTML = lastName
					+ "'s Info";
			$(document).ready(function() {

				$('#tableAccount').DataTable({
					"language" : {
						"emptyTable" : "No Account Added Yet"
					},
					destroy : true,
					searching : false,
					paging : false,
					sorting : false,
					info : false,
					data : response.accounts,

					columns : [ {
						data : 'description'
					}, {
						data : 'balance'
					}, {
						data : 'creationDate'
					}, ]
				});
			});
		},
		error : function(jqXhr, textStatus, errorThrown) {
			document.getElementById('errorMessage').innerHTML = errorThrown;
			setTimeout("fadeInMessageFail();", 1);
			setTimeout("fadeOutMessageFail();", 3000);
		}
	});
}

/************** Load Data to Customer Table **************/
function loadCustomersData() {
	$
			.ajax({
				url : "loadCustomerData",
				type : 'POST',
				contentType : "application/json; charset=utf-8",
				dataType : 'json',

				success : function(response) {
					document.getElementById('customersTotalnumber').innerHTML = response.customersTotalnumber;

					$('#tableCust').DataTable(
							{
								"columnDefs" : [ {
									"targets" : [ 0 ],
									"visible" : false,
								}, {
									"targets" : [ 3 ],
									"width" : "10%"
								} ],
								info : false,
								"lengthMenu" : [ [ 5, 10, 25, -1 ],
										[ 5, 10, 25, "All" ] ],
								"language" : {
									"emptyTable" : "No Customers Yet."
								},
								destroy : true,
								data : response.customers,
								columns : [ {
									data : 'customerId'
								}, {
									data : 'firstName'
								}, {
									data : 'lastName'
								}, {
									data : 'city'
								}, {
									data : 'street'
								}, {
									data : 'zip'
								}, {
									data : 'phone'
								}, {
									data : 'email'
								} ]
							});
				},
				error : function(jqXhr, textStatus, errorThrown) {
					document.getElementById('errorMessage').innerHTML = errorThrown;
					setTimeout("fadeInMessageFail();", 1);
					setTimeout("fadeOutMessageFail();", 3000);
				}
			});
}
/*********************************************************/
/*************** Add customer function *******************/
function addCustomer() {
	var firstName = $('#inputFirstName').val();
	var lastName = $('#inputLastName').val();
	var city = $('#inputCity').val();
	var street = $('#inputAddress').val();
	var zip = $('#inputZip').val();
	var phone = $('#inputPhone').val();
	var email = $('#inputEmail').val();

	var messageValidation = validate(firstName, lastName, city, phone, street,
			zip, email);
	if (messageValidation == "ok") {
		var json = {
			"data" : [ {
				"firstName" : firstName,
				"lastName" : lastName,
				"street" : street,
				"city" : city,
				"zip" : zip,
				"phone" : phone,
				"email" : email
			} ]
		};
		var data1 = JSON.stringify(json);
		$
				.ajax({
					url : "addCustomer.action",
					data : data1,
					dataType : 'json',
					contentType : 'application/json',
					type : 'POST',
					async : true,
					success : function(response) {
						if (response.message == 'Customer Added Succefully.') {
							loadCustomersData();
							document.getElementById('successMessage').innerHTML = response.message;
							setTimeout("fadeInMessage();", 1);
							clearForm();
							setTimeout("fadeOutMessage();", 3000);
						} else {
							document.getElementById('errorMessage').innerHTML = response.message;
							setTimeout("fadeInMessageFail();", 1);
							setTimeout("fadeOutMessageFail();", 3000);
						}
					}
				});
	} else {
		document.getElementById('errorMessage').innerHTML = messageValidation;
		setTimeout("fadeInMessageFail();", 1);
		setTimeout("fadeOutMessageFail();", 3000);
	}
};
/*****************************************************************************/

 /*************** Edit customer function ***************************/
function editCustomer() {
	var customerId = $('#inputCustomerCode').val();
	var firstNameAfter = $('#inputFirstName').val();
	var lastNameAfter = $('#inputLastName').val();
	var cityAfter = $('#inputCity').val();
	var streetAfter = $('#inputAddress').val();
	var zipAfter = $('#inputZip').val();
	var phoneAfter = $('#inputPhone').val();
	var emailAfter = $('#inputEmail').val();
	var messageValidation = validate(firstNameAfter, lastNameAfter, cityAfter,
			phoneAfter, streetAfter, zipAfter);
	var messageNotSameCustomer = checkNotTheSame(firstNameAfter, lastNameAfter,
			cityAfter, phoneAfter, streetAfter, zipAfter, emailAfter);

	if (messageValidation != "ok") {
		document.getElementById('errorMessage').innerHTML = messageValidation;
		setTimeout("fadeInMessageFail();", 1);
		setTimeout("fadeOutMessageFail();", 3000);
	} else if (messageNotSameCustomer == "same") {
		document.getElementById('errorMessage').innerHTML = "Nothing Changed, No Edit.";
		setTimeout("fadeInMessageFail();", 1);
		setTimeout("fadeOutMessageFail();", 3000);
	} else {
		var json = {
			"data" : [ {
				"customerId" : customerId,
				"firstName" : firstNameAfter,
				"lastName" : lastNameAfter,
				"street" : streetAfter,
				"city" : cityAfter,
				"zip" : zipAfter,
				"phone" : phoneAfter,
				"email" : emailAfter
			} ]
		};
		var data1 = JSON.stringify(json);

		$
				.ajax({
					url : "editCustomer.action",
					data : data1,
					dataType : 'json',
					contentType : 'application/json',
					type : 'POST',
					async : true,
					success : function(response) {
						if (response.message == 'Customer Edited Succefully.') {
							loadCustomersData();
							document.getElementById('successMessage').innerHTML = response.message;
							setTimeout("fadeInMessage();", 1);
							clearForm();
							setTimeout("fadeOutMessage();", 3000);
						} else {
							document.getElementById('errorMessage').innerHTML = response.message;
							setTimeout("fadeInMessageFail();", 1);
							setTimeout("fadeOutMessageFail();", 3000);
						}
					}
				});

	}

};

/********** Validating form fields *************/
function validate(firstNameAfter, lastNameAfter, cityAfter, phoneAfter,
		streetAfter, zipAfter, emailAfter) {
	var message = "";
	if (firstNameAfter == "") {
		message = "First Name Required";
	} else if (lastNameAfter == "") {
		message = "Last Name Required";
	} else if (streetAfter == "") {
		message = "Address Required";
	} else if (phoneAfter == "") {
		message = "Phone Required";
	} else if (cityAfter == "") {
		message = "City Required";
	} else if (zipAfter == "") {
		message = "Zip Required";
	} else {
		message = "ok";
	}
	return message;
}

function checkNotTheSame(firstNameAfter, lastNameAfter, cityAfter, phoneAfter,
		streetAfter, zipAfter, emailAfter) {
	var message = "";
	if (firstName == firstNameAfter && lastName == lastNameAfter
			&& city == cityAfter && phone == phoneAfter
			&& street == streetAfter && zip == zipAfter && email == emailAfter)
		message = "same";
	return message;
}

/*********** Fade message Label functions ***********/
function fadeOutMessage() {
	$("#successMessage").fadeOut('slow');
}
function fadeInMessage() {
	$("#successMessage").fadeIn();
}
function fadeOutMessageFail() {
	$("#errorMessage").fadeOut('slow');
}
function fadeInMessageFail() {
	$("#errorMessage").fadeIn();
}

/***************** Fill Modal FOrm ************************/

function fillModalForm() {

	document.getElementById("inputCustomerCodeForm").value = document
			.getElementById("inputCustomerCode").value;
	document.getElementById("inputFirstNameForm").value = document
			.getElementById("inputFirstName").value;
	document.getElementById("inputLastNameForm").value = document
			.getElementById("inputLastName").value;

}

/********************** add account *************************/

function addAccount() {
	if ($('#inputCustomerCode').val() != "") {
		var codeCustomer = $('#inputCustomerCodeForm').val();
		var lastName = $('#inputLastNameForm').val();
		var selectElement = document.getElementById("selectAccountTypeForm");
		var accountType = selectElement.options[selectElement.selectedIndex].text;
		var balance = $('#inputBalanceForm').val();

		var json = {
			"accountData" : [ {
				"codeCustomer" : codeCustomer,
				"description" : accountType,
				"balance" : balance
			} ]
		};
		var data1 = JSON.stringify(json);

		console.log(json);
		console.log(data1);

		$
				.ajax({
					url : "addAccount.action",
					data : data1,
					dataType : 'json',
					contentType : 'application/json',
					type : 'POST',
					async : true,
					success : function(response) {
						if (response.message == 'Account Added Succefully.') {
							document.getElementById("inputBalanceForm").value = "";
							document.getElementById('successMessage').innerHTML = response.message;
							getCustomerAccounts(codeCustomer, lastName);
							setTimeout("fadeInMessage();", 1);
							setTimeout("fadeOutMessage();", 3000);
						} else {
							document.getElementById('errorMessage').innerHTML = response.message;
							setTimeout("fadeInMessageFail();", 1);
							setTimeout("fadeOutMessageFail();", 3000);
						}
					}
				});
	} else {
		document.getElementById('successMessage').innerHTML = "Please Select a Customer First.";
		setTimeout("fadeInMessage();", 1);
		setTimeout("fadeOutMessage();", 3000);

	}
};

/*************************Delete Customer*******************************/

function deleteCustomer() {
	var customerCode = $('#inputCustomerCode').val();

	$
			.ajax({
				url : "deleteCustomer" + "?customerId=" + customerCode,
				type : 'POST',
				contentType : "application/json; charset=utf-8",
				dataType : 'json',

				success : function(response) {
					if (response.message == 'Customer Deleted Succefully.') {
						loadCustomersData();
						document.getElementById('successMessage').innerHTML = response.message;
						setTimeout("fadeInMessage();", 1);
						clearForm();
						setTimeout("fadeOutMessage();", 3000);
					} else {
						document.getElementById('errorMessage').innerHTML = response.message;
						setTimeout("fadeInMessageFail();", 1);
						setTimeout("fadeOutMessageFail();", 3000);
					}
				}
			});
}

/**************** Clear Form ************************/
function clearForm() {

	var dataTable = $('#tableAccount').DataTable();
	if ($('#formInfo').length > 0) {
		$('#formInfo')[0].reset();
		dataTable.clear();
		dataTable.draw();
	}
	document.getElementById("addCustomerBtn").disabled = false;
	document.getElementById("editCustomerBtn").disabled = true;
	document.getElementById("deleteCustomerBtn").disabled = true;
	document.getElementById("addAccountBtn").disabled = true;
	document.getElementById("clearBtn").disabled = true;
	$('#customerAccountsForm').hide();
	$('#tableCust tbody tr').removeClass('selected');

}
function emptyFormFields() {
	document.getElementById("inputBalanceForm").value = "";
}