/**
 * 
 */
function viewAllTransaction() {
	var app = angular.module("admin_transaction_app", []);
	app.controller("admin_transaction_ctrl", function($scope, $http) {
		
		
		$http.get('viewAllTransaction.htm').success(function(info) {
			$scope.transaction_list = info;
			
		
		
		});
		
		
	});
}



