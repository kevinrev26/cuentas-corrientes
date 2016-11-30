/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function formatearFecha(){
    return function(fecha){
        
        var meses = {
            1 : 'Enero',
            2 : 'Febrero',
            3 : 'Marzo',
            4 : 'Abril',
            5 : 'Mayo',
            6 : 'Junio',
            7 : 'Julio',
            8 : 'Agosto',
            9 : 'Septiembre',
            10 : 'Octubre',
            11 : 'Noviembre',
            12 : 'Diciembre'
                 
        };
        
        var arreglo = fecha.split('-');
        return arreglo[2] + " de " + meses[arreglo[1]] + " del " + arreglo[0];
        
    };
}

angular.module('catastro.app')
        .filter('formatearFecha', formatearFecha);
