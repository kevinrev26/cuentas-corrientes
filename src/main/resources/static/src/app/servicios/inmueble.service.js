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
    
    /*
    inmueble.setPropietario = function(inmuebleId, prop){
      
        
        inmueble.getInmuebleById(inmuebleId)
            .then(function (response){
                
                var aux = response.data;
                console.log(aux);
                console.log(prop);
                aux.idContribuyente = prop;
                return $http({
                    url: 'http://localhost:3000/api/inmuebles/'+inmuebleId,
                    method: 'PUT',
                    data: aux,
                    headers: {'Content-Type': 'application/json'}                
                });
        }, function(error){
            console.log(eror);
        });
        
    }; */
	
	
}

angular.module('catastro.app')
	.service('inmuebleService',['$http', inmuebleService]);
