/*
* Kevin Rivera - Copyleft 
* [list-contrib.controller.js]
* [Descripcion]
* Controlador para buscar y listar los contribuyentes en el sistema
*/
function listarContribuyentes(contribService){
	 var vm = this;
	 vm.titulo = "Buscar contribuyentes";
	 contribService.getUsuarios()
        .then(function(result){
         vm.contribuyentes = result.data;
     }, function(error){
         console.log('ERROR: ' + error);
     });
     
     vm.imprimir = function(contribuyente){
            pdfMake.createPdf(documento(contribuyente)).open();  
     };
     
     
     
     
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
            return (Math.floor(numero*100) / 100).toString();
        }
     
     function documento(contrib){
         
         var numeroContribuyente = contrib.numerocontribuyente;         
         var numeroCC = contrib.cuentaCorrienteList[0].idcuentacorriente;         
         var NIT = contrib.nit;
         var nombreCompleto = contrib.nombre + " " + contrib.apellido;
         var direccion = contrib.direccion;
         var ultimoPago = formatearFecha(contrib.cuentaCorrienteList[0].fechaultimopago);
         var saldoAcumulado = contrib.cuentaCorrienteList[0].saldoacumulado;
         var tasaMensual = contrib.cuentaCorrienteList[0].tasamensual;
         var interes = contrib.cuentaCorrienteList[0].interes;
         var total = saldoAcumulado + interes;
         var inmuebles = contrib.inmuebleList;
         var tasas = [];
         
         /*var listaInmuebles = [];*/
         
         if(inmuebles.length!==0){
             for(i=0; i<contrib.inmuebleList.length; i++){
                 //tasas[i] = contrib.inmuebleList[i].tasalist;
                 tasas.push(contrib.inmuebleList[i].tasaList);
                 //console.log(contrib.inmuebleList[i].tasaList);
                 /*for(j=0; j<contrib.inmuebleList.tasaList.length; j++){
                     console.log(contrib.inmuebleList[i].tasalist[j]);
                 }*/
             }
         }
         console.log(tasas);
         console.log(inmuebles);
         
         
         
        function parseColumnas(columns, bandera){
            var propiedades = {
                clavecatastral : 'Clave catastral',
                direccioninmueble: 'Direccion',
                observacion: 'Observaciones',                
                valor: 'Valor del inmueble',
                areasuperficial : 'Area superficial'
                
            };
            
            if(bandera===true){
                return [propiedades[columns[0]], propiedades[columns[1]], propiedades[columns[2]]];
            } else {
                return [propiedades[columns[0]], propiedades[columns[1]]];
            } 
        }
         
        function buildTableBody(data, columns,bandera) {
            var body = [];
            //console.log(parseColumnas(columns,bandera));
            body.push(parseColumnas(columns,bandera));

            data.forEach(function(row) {
                var dataRow = [];

                columns.forEach(function(column) {
                    dataRow.push(row[column].toString());
                });

                body.push(dataRow);
            });

            return body;
        }
         
         
         
         

        function tableInmueble(data, columns,bandera) {
            return {
                style: 'table',
                table: {
                    headerRows: 1,
                    body: buildTableBody(data, columns,bandera)
                }
                , layout: 'headerLineOnly'
            };
        }
         
        return {
            pageMargins: [ 70, 60, 70, 60 ],
            content: [
                
		{text: 'Alcaldía de San Salvador', style: 'header'},
		{text: 'Valores en dólares', style: 'subheader'},
		{table : {
		   headerRows: 1,
		   widths: [ '*', '*', '*', '*' ],
            body: [
                ['N° Contribuyente','N° Cuenta Corriente',{text:'NIT', alignment:'center'},'Fecha de emisión'],
                [{text:numeroContribuyente.toString(), alignment:'center'},{text: numeroCC.toString(), alignment:'center'},{text: NIT, alignment:'center'},{text: formatearFecha(), alignment:'center'}]
            ]    
		}, style: 'table'},
		
		{text: 'Nombre del contribuyente: ' + nombreCompleto},
	    {text: 'Direccion del contribuyente: ' + direccion},
	    
	    tableInmueble(inmuebles,['clavecatastral','direccioninmueble','observacion'],true),
	    
	    tableInmueble(inmuebles,['areasuperficial','valor'],false),
	    
	    {text: 'Fecha de ultimo pago: ' + ultimoPago},
	    
	    //tableInmueble(tasas,['codigo','descripciontasa','valor']),    
	    
	    {   style: 'table',
	        table : {
	        headerRows: 1,
	        widths: [ '*', '*', '*', '*'],
	        body: [
                ['Saldo acumulado','Tasa mensual','Intereses', 'Total a pagar'],
                [formatearFloat(saldoAcumulado),formatearFloat(tasaMensual), formatearFloat(interes), {text : formatearFloat(total), style: 'resultado' }]
            ] 
	        
	    }, layout: 'lightHorizontalLines'}
	],
	
            styles : {
                header : {
                    bold: true,
                    alignment: 'center',
                    fontSize: 25
                },
                subheader : {
                    bold: true,
                    alignment: 'center',
                    fontSize: 20,
                    margin : [0,0,0,20]
                },
                table : {
                    margin : [0,20,0,10]
                },
                resultado : {
                    bold: true,
                    fontSize: 15
                }
            }
        };
     }
     
}

angular.module('catastro.contribuyente')
	.controller('listContribCtrl', ['contribService', listarContribuyentes]);

