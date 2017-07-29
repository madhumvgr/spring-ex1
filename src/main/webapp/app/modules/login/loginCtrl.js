login.controller("loginCtrl", ['$rootScope', '$scope', '$state', '$location', 'loginService', 'Flash','apiService',
function ($rootScope, $scope, $state, $location, loginService, Flash, apiService,$q) {
        var vm = this;

        vm.getUser = {};
        vm.setUser = {};
        vm.signIn = true;

        //access login
        vm.login = function (data) {

        //  var deferred = $q.defer();
          apiService.verifyLogin("/member/verifyLogin", data).then(function (response) {
              if (response.status.code==200)
              {
                  $state.go('app.dashboard');
            //      deferred.resolve(response);
              }
              else
              {
                Flash.create('danger', 'Invalid Password', 'large-text');
            //    deferred.reject("Something went wrong while processing your request. Please Contact Administrator.");
              }

          },
          function (response) {
              Flash.create('danger', 'Invalid Username', 'large-text');
            //  deferred.reject(response);
          });

          /*  if (data.Username == "admin") {
              $promise=apiService.get("/member/verifyLogin","");
              console.log($promise);
                if (data.Password == "admin") {
                    $state.go('app.dashboard');
                }
                else
                    Flash.create('danger', 'Invalid Password', 'large-text');
            }
            else
                Flash.create('danger', 'Invalid Username', 'large-text');*/
        };

        //get registration details
        vm.register = function () {
            if (vm.setUser.confirmPassword == vm.setUser.Password){
                loginService.registerUser(vm.setUser).then(function (response) {
                    if (response.message == 'success')
                console.log('after post>>',response);
                //if (response.length > 0)
                //    $state.go('app');
                //else
                //    Flash.create('danger', 'Invalid Credentials', 'large-text');
            });
            }
        };

    }]);
