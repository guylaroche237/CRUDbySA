var app = angular.module("lycee",[]);
app.controller("lyceectrol",function($scope,$http){
	
	$scope.etudiants= {};
	$scope.visible=false;
	$scope.ecran = true;
	
	
	$scope.save = function(){
		console.log("javascript");
		$http.post("/lycee/save/user?login="+$scope.login+"&password="+$scope.password+"&email="+$scope.email)
		      .success(function(data){
		    	  $scope.reponse = data;
		    	  $scope.reset();
		    	  $scope.allstudent();
		      });
		
	};
	
	$scope.reset = function(){
		$scope.login = "";
		$scope.password = "";
		$scope.email= "";
	};
	
	$scope.allstudent = function(){
		$http.get("/lycee/all/")
		 .success(function(data){
			 $scope.etudiants = data;
			 console.log($scope.etudiants);
		 });
	};
	
	$scope.del = function(id){
		$http.delete("/lycee/delete/"+id)
		 .success(function(data){
			 $scope.allstudent();
		 });
	}
	
	$scope.update = function(id,login,password,email){
		$http.get("/lycee/update/student?id="+id+"&login="+login+"&password="+password+"&email="+email)
		 .success(function(data){
			 
			   $scope.visible=false;
			   $scope.ecran = true;
			   
				$scope.login="";
				$scope.password ="";
				$scope.email = "";
			  $scope.allstudent();
		 });
	}
	
	$scope.aficher = function(id,login,password,email){
		$scope.id = id;
		$scope.login= login;
		$scope.password = password;
		$scope.email = email;
		$scope.ecran = false;
		$scope.visible=true;
	}
	
	$scope.allstudent();
	
	
});
