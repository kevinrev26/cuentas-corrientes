/*
* Kevin Rivera - Copyleft 
* [Titulo]
* [Descripcion]
*/
//Tasas para aseo, relleno y alumbrado

function servicioTasas($http){

	var tasa = this;
	
	tasa.getTasas = function(){
		return $http.get('/api/tasas');
	};
	
	
}

angular.module('catastro.app')
	.service('tasaService', ['$http', servicioTasas]);
	
	
