
dashboard.service('dashboardService', ['$http', '$q', 'Flash', 'apiService', function ($http, $q, Flash, apiService) {

    var dashboardService = {};


    var getEmployeeList = function (parameters) {
        var deferred = $q.defer();
        apiService.get("/employee/list", parameters).then(function (response) {
            if (response)
                deferred.resolve(response);
            else
                deferred.reject("Something went wrong while processing your request. Please Contact Administrator.");
        },
            function (response) {
                deferred.reject(response);
            });
        return deferred.promise;
    };

    var registerEmployee = function (parameters) {
        var deferred = $q.defer();
        apiService.create("/employee/insert", parameters).then(function (response) {
            if (response)
                deferred.resolve(response);
            else
                deferred.reject("Something went wrong while processing your request. Please Contact Administrator.");
        },
            function (response) {
                deferred.reject(response);
            });
        return deferred.promise;
    };
    var updateEmployee = function (parameters) {
        var deferred = $q.defer();
        apiService.create("/employee/update", parameters).then(function (response) {
            if (response)
                deferred.resolve(response);
            else
                deferred.reject("Something went wrong while processing your request. Please Contact Administrator.");
        },
            function (response) {
                deferred.reject(response);
            });
        return deferred.promise;
    };
    
    var deleteEmployee = function (parameters) {
        var deferred = $q.defer();
        apiService.create("/employee/delete", parameters).then(function (response) {
            if (response)
                deferred.resolve(response);
            else
                deferred.reject("Something went wrong while processing your request. Please Contact Administrator.");
        },
            function (response) {
                deferred.reject(response);
            });
        return deferred.promise;
    };
    
    dashboardService.getEmployeeList = getEmployeeList;
    dashboardService.registerEmployee = registerEmployee;
    dashboardService.updateEmployee =updateEmployee;
    dashboardService.deleteEmployee= deleteEmployee;
    return dashboardService;

}]);
