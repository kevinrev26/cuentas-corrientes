/*
* Kevin Rivera - Copyleft 
* [contribuyente.service]
* [Descripcion]
* Especifica los metodos para tratar con los servicios a traves de la web
*/

function contribService($http, $base64){
    
    
    //var auth = $base64.encode('user:123456');
    //var headers = {'Authorization' : 'Basic ' + auth};
    
	var contrib = this;
	//creando array de usuarios;
	//contrib.usuarios = [];	
	//Obteniendo los usuarios
	contrib.getUsuarios = function(){
		return $http.get('/api/contribuyentes/');
	};
	
	
	//Metodo para agregar usuario
	contrib.addUsuario = function(user){
		//contrib.usuarios.push(user);
            return $http({
                url: '/api/contribuyentes/',
                method: 'POST',
                data : user,
                headers: {'Content-Type': 'application/json'}
            });
	}
	
    
    contrib.getUsuarioById = function (id) {
        
        return $http.get('/api/contribuyentes/'+id);
        
        
    };
	//return contrib;
	
}

//Registrando el servicios
angular.module('catastro.app')
	.service('contribService', ['$http', '$base64', contribService]);


