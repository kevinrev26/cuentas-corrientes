/*
* Kevin Rivera - Copyleft 
* [Titulo]
* [Descripcion]
*/

function buscar(inmuebleService){
	var vm = this;
	vm.titulo = 'Buscar inmueble';
	inmuebleService.getInmuebles()
        .then(function(response){
            vm.inmuebles = response.data;
        }, function(error){
            console.log(error);
        });
	
}

angular.module('catastro.inmueble')
	.controller('buscarInmuebleCtrl', ['inmuebleService', buscar]);
