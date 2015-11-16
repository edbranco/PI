/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener("load", carregar);

var altera = false;

var pesquisa = false;

var idErrado;

function carregar (evt) {
    pesquisa = "false";
    document.getElementById('nomeFilial').disabled = true;
    document.getElementById('cnpj').disabled = true;
    document.getElementById('uf').disabled = true;
    
    pesquisa = document.getElementById('habilitado').value;  
    if (pesquisa === "true") {
        document.getElementById('nomeFilial').disabled = false;
        document.getElementById('cnpj').disabled = false;
        document.getElementById('uf').disabled = false;
    }
    
    //Mensagem caso pesquisa não retorne nada     
    if (document.getElementById('semRegistro').value === "true") {
        document.getElementById("alerta-registro").classList.add("aparecer");
    } else {
        document.getElementById("alerta-registro").classList.add("desaparecer");
    }
    
    document.getElementById('btn-alterar').addEventListener("click", alteraEVerdadeiro);
    document.getElementById('btn-pesquisar').addEventListener("click", alteraEFalso);
}

function alteraEFalso() {
    altera = false;
    
    //Validar id
    var id = document.getElementById('idFilial').value;
    
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

function alteraEVerdadeiro() {
    altera = true;
    
    //Validar id
    var id = document.getElementById('idFilial').value;
    
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

function validarAlterarFilial() {
    if (altera === true && idErrado === false) {
        //Campos
        var id = document.getElementById('idFilial').value;
    
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

        //Checa todos os campos
        if (idbool === true) {
            return true;
        }
        else {
            return false;
        }
    }
    else if (altera === false && idErrado === false) {
        return true;
    }
    else {
        return false;
    }
};



