/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 function formatearPago(){
     
     return function(fecha){
         var arreglo = fecha.split('-');
         var last = new Date(arreglo[0], arreglo[1]-1, arreglo[2]);
         var today = new Date();
         
         return Math.round((today-last)/(1000*60*60*24));
     };
 }

angular.module('catastro.app')
    .filter('formatearPago', formatearPago);