'use strict';

controllers.controller('HomeController', ['$scope', 'UserService', 'DeviceService', 'MapService',
    function ($scope, UserService, DeviceService, MapService) {
        $scope.date = new Date();
        MapService.zoom = 14;
        
        function searchLink(nameKey, myArray) {
            for (var i = 0; i < myArray.length; i++) {
                if (myArray[i]['@rel'] === nameKey) {
                    return myArray[i]['@href'];
                }
            }
        }

        $scope.linksArray = $scope.currentUser.links.link;

        var linkDevice = searchLink("devices", $scope.linksArray);

        DeviceService.FindDeviceByLink(linkDevice, function (data,response){
            if (response == 200) {
                $scope.device = data[0].device;
            } else {
                console.log("Erro!");
            }
        });

        debugger;

        MapService.setPosition(-31.754422, -52.3773069);

//        UserService.FindUser(function (data, response) {
//            if (response === 200) {
//                $scope.user = data.user;
//            } else {
//                console.log("ERRROOO!!");
//            }
//        });

    }]);
