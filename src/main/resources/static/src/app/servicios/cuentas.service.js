/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function service($http){
    
    var cuentas = this;
    
    cuentas.getCuentas = function(){
        return $http.get('/api/cuentas-corrientes/');
    };
    
}

angular.module('catastro.app')
        .service('cuentasService', ['$http', service]);
