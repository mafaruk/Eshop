const state = ["Choose...",
	"Andhra Pradesh",
	"Arunachal Pradesh",
	"Assam",
	"Bihar",
	"Chhattisgarh",
	"Goa",
	"Gujarat",
	"Haryana",
	"Himachal Pradesh",
	"Jammu and Kashmir",
	"Jharkhand",
	"Karnataka",
	"Kerala",
	"Madhya Pradesh",
	"Maharashtra",
	"Manipur",
	"Meghalaya",
	"Mizoram",
	"Nagaland",
	"Odisha",
	"Punjab",
	"Rajasthan",
	"Sikkim",
	"Tamil Nadu",
	"Telangana",
	"Tripura",
	"Uttarakhand",
	"Uttar Pradesh",
	"West Bengal",
	"Andaman and Nicobar Islands",
	"Chandigarh",
	"Dadra and Nagar Haveli",
	"Daman and Diu",
	"Delhi",
	"Lakshadweep",
	"Puducherry"
];
function loadstate() {
	state.map((i) => {
		var x = document.getElementById("state");
		var option = document.createElement("option");
		var att = document.createAttribute("value");       // Create a "class" attribute
		att.value = i; 
		option.setAttributeNode(att);  
		option.text = i;
		x.appendChild(option);
	}, 0);
}



function confirmPassword() {


	let pass = document.forms["regform"]["pass"];
	let cpass = document.forms["regform"]["cpass"];
	if (pass.value != cpass.value) {
		alert("password does not match");
	}



}

function validateForm(){
	
	let state = document.forms["regform"]["state"];
	var strState = state.value;
	if(strState=="Choose..."){
		alert("Please select the state");
		return false;
	}
	
}











