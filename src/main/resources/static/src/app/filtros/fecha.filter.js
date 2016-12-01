/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function formatearFecha(){
    return function(fecha){
        
        var meses = {
            01 : 'Enero',
            02 : 'Febrero',
            03 : 'Marzo',
            04 : 'Abril',
            05 : 'Mayo',
            06 : 'Junio',
            07 : 'Julio',
            08 : 'Agosto',
            09 : 'Septiembre',
            10 : 'Octubre',
            11 : 'Noviembre',
            12 : 'Diciembre'
                 
        };
        
        var arreglo = fecha.split('-');
        if(parseInt(arreglo[1]) < 10){
            arreglo[1] = parseInt(arreglo[1]);
        }        
        return arreglo[2] + " de " + meses[arreglo[1]] + " del " + arreglo[0];
        
    };
}

angular.module('catastro.app')
        .filter('formatearFecha', formatearFecha);
