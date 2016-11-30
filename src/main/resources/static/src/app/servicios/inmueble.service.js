/*
* Kevin Rivera - Copyleft 
* [Titulo]
* [Descripcion]
*/
function inmuebleService($http){
    var inmueble = this;
	//inmueble.init();
	
    inmueble.addInmueble = function (inm){
        return $http({
            url: '/api/inmuebles/',
            method: 'POST',
            data : inm,
            headers: {'Content-Type': 'application/json'}
        });
    };
    
    inmueble.getInmuebles = function(){
        return $http.get('/api/inmuebles/');
    };
	
    inmueble.getInmuebleById = function(inmuebleId){
	return $http.get('/api/inmuebles/'+inmuebleId);
    };
    
	
	
}

angular.module('catastro.app')
	.service('inmuebleService', ['$http', inmuebleService]);
