/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener("load", carregar);

//variáveis de verificação
var altera = false;

var pesquisa = false;

var idErrado;

function carregar (evt) {
    //Estado dos campos ao carregar a página
    pesquisa = "false";
    document.getElementById('nomecliente').disabled = true;
    document.getElementById('cpfcliente').disabled = true;
    document.getElementById('telefonecliente').disabled = true;
    document.getElementById('emailcliente').disabled = true;
    document.getElementById('enderecocliente').disabled = true;
    document.getElementById('cidadecliente').disabled = true;
    document.getElementById('estadocliente').disabled = true;
    
    //Habilita campos para digitação
    pesquisa = document.getElementById('habilitado').value;  
    if (pesquisa === "true") {
        document.getElementById('nomecliente').disabled = false;
        document.getElementById('cpfcliente').disabled = false;
        document.getElementById('telefonecliente').disabled = false;
        document.getElementById('emailcliente').disabled = false;
        document.getElementById('enderecocliente').disabled = false;
        document.getElementById('cidadecliente').disabled = false;
        document.getElementById('estadocliente').disabled = false;
    }
    
    //Mensagem caso pesquisa não retorne nada     
    if (document.getElementById('semRegistro').value === "true") {
        document.getElementById("alerta-registro").classList.add("aparecer");
    } else {
        document.getElementById("alerta-registro").classList.add("desaparecer");
    }
    
    //Eventos de clique
    document.getElementById('btn-alterar').addEventListener("click", alteraEVerdadeiro);
    document.getElementById('btn-pesquisar').addEventListener("click", alteraEFalso);
}

function alteraEFalso() {
    altera = false;
    
    //Validar id
    var id = document.getElementById('idcliente').value;
    
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
    var id = document.getElementById('idcliente').value;
    
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

//Função que valida campos
function validarAlterarCliente() {
    if (altera === true && idErrado === false) {
        //Campos
        var id = document.getElementById('idcliente').value;
        var nome = document.getElementById('nomecliente').value; 
    
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

        //Validar nome
        var nomebool;    
        var letters = /^[a-zA-Z\s]*$/;
        if(nome.match(letters)) {
            nomebool = true;
        } else {
            document.getElementById("err-campo-nome").classList.add("aparecer");
            nomebool = false;
        }
        
        if (document.getElementById('nomecliente').hasAttribute('disabled')) {
            document.getElementById("alerta-pes-cliente").classList.add("aparecer");
            document.getElementById("suc-alt-cliente").classList.add("desaparecer");
            document.getElementById("alerta-registro").classList.add("desaparecer");
            return false;
        }

        //Checa todos os campos
        if (nomebool === true && idbool === true) {
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