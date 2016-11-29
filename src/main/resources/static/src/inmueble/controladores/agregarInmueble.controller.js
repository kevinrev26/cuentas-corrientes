/*
* Kevin Rivera - Copyleft 
* [agregarInmueble.controller.js]
* [Descripcion]
* Controlador para agregar un nuevo inmueble
*/

function agregarInmueble(inmuebleService, tasaService){
	var vm = this;
        var arrayAux = [];
	vm.titulo = "Agregar inmueble";
        vm.querySearch = querySearch;
       // vm.tasaList = [];
        vm.tasaList = [];
              
        
        vm.itemChanged = function(item){
            item ? vm.tasaList.push(item) : console.log("INDEFINIDO");
            //vm.searchText='';            
            
        };
        
        
        vm.removeTasa = function(item){
            vm.tasaList.splice(vm.tasaList.indexOf(item));
        };
        
        /*Extrayendo las tasas de la base*/
        tasaService.getTasas()
                .then(function(result){
                    console.log("Codigo: " + result.status);
                    //console.log(result.data);
                    vm.tasas = result.data;
                }, function(error){
                    console.log("Codigo:" + error.status);
                });
        
	
	vm.enviarFormulario = function(){
            
            
            if(vm.tasaList.length === 0){
                alert("No se ha ingresado tasas al inmueble");
                return;
            } else {                
                vm.formData.tasaList = vm.tasaList;
                inmuebleService.addInmueble(vm.formData)
                .then(function(result){
                    console.log("Codigo: " + result.status);
                    console.log(result.data);
                }, function(error){
                    console.log(error);
                });
            } 
        
            
		//console.log(vm.formData);
        
	};
        
        
        
        function querySearch(query){
            return query ? vm.tasas.filter(createFilterFor(query)) : vm.tasas;            
            
        }
        
        function createFilterFor(query) {
            //var lowerCaseQuery = angular.lowercase(query);
            return function filterTasas(tasa){
                return (tasa.descripciontasa.indexOf(query) === 0);
            };
        }
}

angular.module('catastro.inmueble')
	.controller('agregarInmuebleCtrl', ['inmuebleService', 'tasaService', agregarInmueble]);
