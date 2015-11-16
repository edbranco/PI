/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener("load", carregar);

var exclui = false;

var idErrado = false;

function carregar (evt) {        
    //Mensagem caso pesquisa não retorne nada     
    if (document.getElementById('semRegistro').value === "true") {
        document.getElementById("exc-alert-reg").classList.add("aparecer");
    } else {
        document.getElementById("exc-alert-reg").classList.add("desaparecer");        
    }
    
    //Mostra informações do cliente caso ele exista    
    if (document.getElementById('clienteExiste').value === "true") {
        var clienteInfo = document.getElementsByClassName("consulta-excluir");
        clienteInfo[0].style.display = "block";
    }
    
    document.getElementById('btn-excluir').addEventListener("click", excluiEVerdadeiro);
    document.getElementById('btn-pesquisar').addEventListener("click", excluiEFalso);
}

function excluiEFalso() {
    exclui = false;
    
    //Validar id
    var id = document.getElementById('idcliente').value;
    
    if (id !== "") {
        var idbool;    
        var numeros = /^\d+$/;
        if(id.match(numeros)) {
            idbool = true;
            idErrado = false;
        } else {
            document.getElementById("err-campo-id").classList.add("aparecer");
            idbool = false;
            idErrado = true;
        }
    }
}

function excluiEVerdadeiro() {
    exclui = true;    
}

function validarExcluirCliente() {
    if (exclui === true && idErrado === false) {
        //Campos
        var id = document.getElementById('idcliente').value;
    
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
    else if (exclui === false && idErrado === false) {
        return true;
    }
    else {
        return false;
    }
};



