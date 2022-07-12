	//JSON - Javascript Object Notation -> Json string which used to transfer data. 
	//It having in the Key-value pair
	var employeeinfo = {
		"fname":"Sachin",
		"lname":"Jaiswal",
		"salary":25000,
		"contactNo":["9876543210","9876231446"],
		"address":[
			{
				"type":"Current Address",
				"addressLine1":"Ward No 3",
				"city" :"Morath",
				"district":"Yavatmal"
			},
			{
				"type":"Permanant Address",
				"addressLine1":"Ward No 3",
				"city" :"Morath",
				"district":"Yavatmal"	
			}
		]
	};
	

	
	function genderChange(){
		var gen = document.getElementById("gender").value;
		//alert("You Have selected : "+gen);
		document.getElementById("genderDiv").innerHTML=gen;
	}
	
	function changeName(obj){
		document.getElementById("fnameDiv").innerHTML = obj.value;
	}
	
	function changeLName(obj){	
		document.getElementById("lnameDiv").innerHTML = obj.value;
	}
	
	function onloadValues(){
		//alert("Form is Ready");
		document.getElementById("gender").value="F";
	}
	
	function onSubmitCheck(){
		var lname = document.getElementById("lname").value;
		if(lname==""){
			alert("Last Name is manadatory field");
			return false;
		}
		
		var fname = document.getElementById("fname").value
		if(fname==""){
			alert("First Name is manadatory field");
			return false;
		}
		
		return true;
	}
	
	var stateAndDistrict = {
		"MH" :["Akola-AK","Amravati-AMT","Yavatmal-YTL","Nagpur-NGP","Nanded-NDD"],
		"MP" :["Bhaidehi-BDH","Baitul-BTL","Indore-IND","Bhopal-BPL"],
		"UP":["Gorakhpur-GRP","Varanasi-VRS"],
		"AP":["Adilabaad-ADL","Hyderbaad-HYD"]
	};
	
		
	function stateChange(obj){
		//alert(obj.value);	
		var selectObj = document.getElementById("district");
				
		while (selectObj.length > 0) {
		  selectObj.remove(selectObj.length-1);
		}
		//alert(stateAndDistrict.MH);
		//stateAndDistrict["UP"]
		
		for(var str of stateAndDistrict[obj.value]){
			console.log(str);
			//alert(str);
			var label = str.split("-")[0];
			var value = str.split("-")[1];
			selectObj.options.add(new Option(label, value));
		}
		
		/*if(obj.value=="MH"){		
			selectObj.options.add(new Option('Yavatmal', 'YTL'));
			selectObj.options.add(new Option('Amravati', 'AMT'));
			selectObj.options.add(new Option('AKOLA', 'AKL'));		
		}else if(obj.value=="MP"){		
			selectObj.options.add(new Option('Burhanpur', 'BRP'));
			selectObj.options.add(new Option('Indore', 'IDR'));
			selectObj.options.add(new Option('Bhopal', 'BPL'));		
		}else if(obj.value=="AP"){		
			selectObj.options.add(new Option('Hyderabaad', 'HYD'));
			selectObj.options.add(new Option('Adilabaad', 'AD'));		
		}else if(obj.value=="UP"){		
			selectObj.options.add(new Option('Gorakhpur', 'GRP'));		
		}*/			
	}