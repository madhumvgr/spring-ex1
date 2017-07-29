dashboard.controller("EmployeeController", ['$rootScope', '$scope', '$state', '$location', 'dashboardService', 'Flash', '$http','apiService',
function ($rootScope, $scope, $state, $location, dashboardService, Flash, $http,apiService) {
    var vm = this;
    vm.message = {};
    vm.submitForm = function () {
        console.log(vm.message);
     
        dashboardService.registerEmployee(vm.message).then(function (response) {
            if (response.status.code==200)
            {
            	Flash.create('success', 'Details Saved Succesfully', 'large-text');
                vm.message = {};
              // vm.contactForm.$pristine();
              //  vm.contactForm.$setUntouched();
            }
            else
            {
              Flash.create('danger', 'Error Occured', 'large-text');
            }
        },
        function (response) {
            Flash.create('danger', 'Error Occured', 'large-text');
        });
        dashboardService.getEmployeeList(vm.message).then(function (response) {
        	alert("haii")
        	
            if (response.status.code==200)
            {
            	//Flash.create('success', 'Retrieved Data Succesfully', 'large-text');
                vm.message = {};
                $table = $('#table');
                $('#table').bootstrapTable({
                    data: response.employeeList
                });
                //vm.message.employeeList=response.employeeList;
            }
            else
            {
              Flash.create('danger', 'Error Occured', 'large-text');
            }
        },
        function (response) {
            Flash.create('danger', 'Error Occured', 'large-text');
        });
    };
    console.log("coming to Employee controller");

}]);

dashboard.controller('empListCtrl', function($scope, $http,dashboardService,Flash, $state, $stateParams) {
	var vm = this;
    vm.message = {};
	getEmployeeDetails();
	function getEmployeeDetails(){
		dashboardService.getEmployeeList(vm.message).then(function (response) {
            if (response.status.code==200)
            {
            	//Flash.create('success', 'Retrieved Data Succesfully', 'large-text');
                vm.message = {};
                    $scope.employees= response.employeeList
                
                //vm.message.employeeList=response.employeeList;
            }
            else
            {
              Flash.create('danger', 'Error Occured', 'large-text');
            }
        },
        function (response) {
            Flash.create('danger', 'Error Occured', 'large-text');
        });		
	}
	$scope.updateEmployeeDetails=function(emp)
	{
		//show updateemployee page with emp details.
		 $state.go('app.updateEmp', {emp:emp});
	}
	$scope.deleteEmployeeDetails=function(emp)
	{
		//delete the employee details. 
		dashboardService.deleteEmployee(emp).then(function (response) {
            if (response.status.code==200){
            //	Flash.create('success', 'Deleted Succesfully', 'large-text');
            	alert("Deleted successfully");
            	 $state.reload();
            }
            else{
              Flash.create('danger', 'Error Occured', 'large-text');
            }
        },
        function (response) {
            Flash.create('danger', 'Error Occured', 'large-text');
        });		
		
	}
	
	});

dashboard.controller('addEmployeeCtrl', function($scope, $http,dashboardService,Flash) {
	var vm = this;
    vm = {};
 //  {"id":"1","firstName":"test","middleName":"test","lastName":"test","email":"test","phone":"test","address1":"test","address2":"test","country":"test","state":"test","city":"test","zipcode":"test","hireDate":"12-12-2017"}
    	$scope.addEmployeeDetails = function (){
    		//$scope.details.push({
    		vm.firstName= $scope.firstName,
    		vm.lastName= $scope.middleName,
    		vm.middleName= $scope.lastName,
    		vm.email= $scope.email,
    		vm.phone= $scope.phone
    		dashboardService.registerEmployee(vm).then(function (response) {
                if (response.status.code==200){
                	//Flash.create('success', 'Details Saved Succesfully', 'large-text');
                	alert("Data Inserted Successfully");
                	$state.go('app.employee');
                    vm.message = {};
                }
                else{
                  Flash.create('danger', 'Error Occured', 'large-text');
                }
            },
            function (response) {
                Flash.create('danger', 'Error Occured', 'large-text');
            });		
}
});


dashboard.controller('updateEmployeeCtrl', function($scope, $http,dashboardService,Flash,$stateParams,$state) {
	var vm = this;
    vm = {};
    $scope.emp = $stateParams.emp;
 //  {"id":"1","firstName":"test","middleName":"test","lastName":"test","email":"test","phone":"test","address1":"test","address2":"test","country":"test","state":"test","city":"test","zipcode":"test","hireDate":"12-12-2017"}
    	$scope.updateEmployeeDetails = function (){
    		//$scope.details.push({
    		
    		dashboardService.updateEmployee($scope.emp).then(function (response) {
                if (response.status.code==200){
                	//Flash.create('success', 'Details Update Succesfully', 'large-text');
                	alert("Data Updated Successfully");
                	 $state.go('app.employee');
                }
                else{
                  Flash.create('danger', 'Error Occured', 'large-text');
                }
            },
            function (response) {
                Flash.create('danger', 'Error Occured', 'large-text');
            });		
}
});

