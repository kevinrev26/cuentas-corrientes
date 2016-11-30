/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function listar(cuentasService){
    var vm = this;
    vm.titulo = "Cuentas corrientes en el sistema";
    
    cuentasService.getCuentas()
            .then(function(result){
                console.log(result.status);
                vm.cuentas = result.data;
            }, function(error){
                console.log("Codigo: " + error.status);
                
            });
    
}

angular.module('catastro.cuenta')
        .controller('listarCuentasCtrl', ['cuentasService' , listar]);

