/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function servicioTraspasos($http) {
        var st = this;
        st.setTraspaso = function (data, inm){
            var traspaso = {
                idtraspaso : makeid(),
                fechatraspaso : data.fecha,
                numerocontribuyente : data.contr,
                clavecatastral : inm
                
            };
            
            return $http({
                url: '/api/traspasos/',
                method: 'POST',
                data : traspaso,
                headers: {'Content-Type': 'application/json'}
            });
        };
        
        function makeid(){
            var text = "";
            var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

            for( var i=0; i < 5; i++ )
                text += possible.charAt(Math.floor(Math.random() * possible.length));

            return text;
        }
        
        function getDate(){
            var currentDate = new Date();
            var day = currentDate.getDate();
            var month = currentDate.getMonth() + 1;
            var year = currentDate.getFullYear();
            
            //return day + "-" + month + "-" + year;
            return year + "-" + month + "-" + day;
            
        }
}

angular.module('catastro.app')
        .service('traspasoService', ['$http', servicioTraspasos]);
