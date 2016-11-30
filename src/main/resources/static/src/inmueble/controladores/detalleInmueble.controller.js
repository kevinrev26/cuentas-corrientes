/*
* Kevin Rivera - Copyleft 
* [Titulo]
* [Descripcion]
*/

function detalle($scope, $routeParams, $mdDialog, traspasoService, inmuebleService, contribService, $route){
	var vm = this;
	
	vm.inmuebleId = $routeParams.inmuebleid;
	vm.titulo = "Clave catastral: " + vm.inmuebleId;
	//console.log(vm.inmuebleId);
	inmuebleService.getInmuebleById(vm.inmuebleId)
    .then(function (response) {
        vm.Inmueble = response.data;
    }, function (error) {
        console.log(error);
    });
	//Propietarios		
    
  
    
	vm.agregarPropietario = function($event){
		//console.log('Click en boton');
		$mdDialog.show({
			parent :  angular.element(document.body),
			targetEvent : $event,
			templateUrl: 'src/inmueble/views/agregar-propietario-dialogo.html',
			controller: propietarioController,
			clickOutsideToClose: true
			
		})
        .then(function(contribuyente){
            
            //console.log(contribuyente);
            //console.log(vm.Inmueble);
            
            traspasoService.setTraspaso(contribuyente, vm.Inmueble)
                    .then(function(result){
                        alert = $mdDialog.alert({
                            title: '¡Bien!',
                            textContent: 'Traspaso realizado: ' + result.data.mensaje,
                            ok: 'Entendido'
                        });
                        
                        $mdDialog.show(alert)
                                .finally(function(){
                                    alert = undefined;
                                });
                        $route.reload();
                    }, function(error){
                        console.log(error);
                    });
            
        }, function(){
            
            alert = $mdDialog.alert({
            title: '¡Oops!',
            textContent: 'Debe agregar un propietario',
            ok: 'Entendido'
          });

          $mdDialog.show( alert )
            .finally(function() {
              alert = undefined;
            });
            
        });
	
	
    };
    
    
    function propietarioController($scope, $mdDialog, contribService){
        
        $scope.cancel = function(){
          $mdDialog.cancel();  
        };
        
        $scope.propietario = function (contribuyente) {
            $mdDialog.hide(contribuyente);
        };
        
        $scope.buscar = function(){
             contribService.getUsuarioById(parseInt($scope.id))
             .then(function(result){
                 $scope.contr = result.data;
             },function(error){
                 $scope.error = error;
             }); 
            //console.log();
        };
        
    }
    
}



angular.module('catastro.inmueble')
	.controller('detalleInmuebleCtrl', ['$scope', '$routeParams', '$mdDialog', 'traspasoService','inmuebleService', 'contribService', '$route', detalle]);
