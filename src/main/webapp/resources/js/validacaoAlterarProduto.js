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
    document.getElementById('nomeproduto').disabled = true;
    document.getElementById('marcaproduto').disabled = true;
    document.getElementById('precoproduto').disabled = true;
    document.getElementById('qtdeproduto').disabled = true;
    
    //Habilita campos para digitação
    pesquisa = document.getElementById('habilitado').value;  
    if (pesquisa === "true") {
        document.getElementById('nomeproduto').disabled = false;
        document.getElementById('marcaproduto').disabled = false;
        document.getElementById('precoproduto').disabled = false;
        document.getElementById('qtdeproduto').disabled = false;
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

function alteraEVerdadeiro() {
    altera = true;   
    
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

//Função que valida campos
function validarAlterarProduto() {
    if (altera === true && idErrado === false) {
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
        
        //Se usuário clica em alterar sem pesquisar
        if (document.getElementById('nomeproduto').hasAttribute('disabled')) {
            document.getElementById("alerta-pes-produto").classList.add("aparecer");
            document.getElementById("suc-alt-produto").classList.add("desaparecer");
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
    else if (altera === false && idErrado === false) {
        return true;
    }
    else {
        return false;
    }
};



