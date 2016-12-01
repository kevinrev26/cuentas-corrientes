/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function listar(cuentasService, $mdDialog, $scope){
    var vm = this;
    vm.titulo = "Cuentas corrientes en el sistema";
    
    cuentasService.getCuentas()
            .then(function(result){
                console.log(result.status);
                vm.cuentas = result.data;
            }, function(error){
                console.log("Codigo: " + error.status);
                
            });
    
    
    vm.detalle = function ($event, item){
            //$scope.cc = item;
            //console.log(item);
            item ? console.log(item.idcuentacorriente) : console.log("Te jodiste");
            
            $mdDialog.show({
                parent :  angular.element(document.body),
                targetEvent : $event,
                locals : {
                  cc : item  
                },
                templateUrl: 'src/cuentas/views/detalle-cuenta.html',
                controller: detalleController,
                clickOutsideToClose: true
            }).then(function(){
                console.log("Oki doki");
            }, function(){
                console.log("Cerrado");
            });
    };
    
    
    function detalleController($scope, $mdDialog, cc){
        $scope.cc = cc;
        
        function formatearFecha(date){
            
            var meses= ['Enero', 'Febrero', 'Marzo', 'Abril',
                        'Mayo','Junio', 'Julio', 'Agosto', 'Septiembre',
                        'Octubre', 'Noviembre', 'Diciembre'];
            
            if(date){
                var arreglo = date.split('-');
                return arreglo[2] + " de " + meses[parseInt(arreglo[1])-1] + " del " + arreglo[0];
                
            } else {
                var fecha = new Date();
                return fecha.getDate() + " de " + meses[fecha.getMonth()] + " del " + fecha.getFullYear();
            }
        }
        
        
        function formatearFloat(numero){
            return Math.floor(numero*100) / 100;
        }
        
        var docDefinition = {
            pageSize: 'LETTER',
            pageMargins: [ 70, 60, 70, 60 ],
            content: [
                {text: 'San Salvador, '+ formatearFecha(), style: 'encabezado'},
                { text: 'AVISO DE COBRO', style: 'header'},                                
                'Como ciudadano responsable, esperamos que esté conciente' + 
                ' de las necesidades de desarrollo que tiene el municipio' +
                ' que deben ser satisfechas a través del pago de sus tributos.' +
                ' Por nuestra parte, esperamos tener buenas relaciones con Usted a' +
                ' través de nuestros servicios.',
                'En esta oportunidad tenemos la tarea de recordarle que tiene una mora'+
                ' pendiente con respecto al pago de sus tributos, por la cantidad de $ '+ 
                        formatearFloat($scope.cc.saldoacumulado) + ', desde que se realizó el ultimo pago: '+
                        formatearFecha($scope.cc.fechaultimopago),
                'Agradeceríamos su visita lo mas pronto posible y le rogamos traer su último recibo de pago.',
                'Atentamente:',
                {text: 'Jefe de Unidad de Cuentas Corrientes', style: 'despedida'}
          ],
          styles : {
              header: {
                  fontsize: 22,
                  bold: true,
                  alignment: 'center',
                  margin: 50
              },
              encabezado: {
                  alignment: 'right'
              },
              despedida : {
                  alignment: 'center',
                  margin: 70
              }
          }
        };
        
        
        $scope.cancel = function(){
            $mdDialog.cancel();  
        };
        
        $scope.openpdf = function(){
            pdfMake.createPdf(docDefinition).open();
        };
        
    };
}

angular.module('catastro.cuenta')
        .controller('listarCuentasCtrl', ['cuentasService', '$mdDialog', '$scope' , listar]);

