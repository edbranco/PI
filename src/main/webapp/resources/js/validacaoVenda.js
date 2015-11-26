/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener("load", carregar);

//variáveis de verificação
var vende = false;

var pesquisa = false;

var idErrado;

function carregar (evt) {
  
    //Mensagem caso pesquisa não retorne nada     
    if (document.getElementById('semRegistro').value === "true") {
        document.getElementById("alerta-registro").classList.add("aparecer");
    } else {
        document.getElementById("alerta-registro").classList.add("desaparecer");
    }
    
    //Eventos de clique
    document.getElementById('btn-alterar').addEventListener("click", vendeEVerdadeiro);
    document.getElementById('btn-pesquisar').addEventListener("click", vendeEFalso);
}


function vendeEFalso() {
    vende = false;
    
    //Validar id
    var id = document.getElementById('idproduto').value;
    
    if (id !== "") {
        var idbool;    
        var numeros = /^\d+$/;
        if(id.match(numeros)) {
            idbool = true;
            idErrado = false;
        } else {
            //alert("teste");
            document.getElementById("err-campo-id").classList.add("aparecer");
            idbool = false;
            idErrado = true;
        }
    }
}

function vendeEVerdadeiro() {
    vende = true;   
    
    //Validar id
    var id = document.getElementById('idproduto').value;
    
    if (id !== "") {
        var idbool;    
        var numeros = /^\d+$/;
        if(id.match(numeros)) {
            idbool = true;
            idErrado = false;
        } else {
            //alert("teste");
            document.getElementById("err-campo-id").classList.add("aparecer");
            idbool = false;
            idErrado = true;
        }
    }
}

//funcao que valida camp
function validarVender() {
    if (vende === true && idErrado === false) {
        //Campos
        var id = document.getElementById('idproduto').value;
    
        //Validar id
        var idbool;    
        var numeros = /^\d+$/;
        if(id.match(numeros)) {
            idbool = true;
        } else {
            //alert("teste");
            document.getElementById("err-campo-id").classList.add("aparecer");
            idbool = false;
        }
        
        if (document.getElementById('nomeproduto').value === "") {
            document.getElementById("alerta-pes-produto").classList.add("aparecer");
            document.getElementById("err-campo-id").classList.add("desaparecer");
            document.getElementById("alerta-registro").classList.add("desaparecer");
            return false;
        }

        //Checa todos os campos
        if (idbool === true) {
            return true;
        }
        else {
            return false;
        }
    }
    else if (vende === false && idErrado === false) {
        return true;
    }
    else {
        return false;
    }
};