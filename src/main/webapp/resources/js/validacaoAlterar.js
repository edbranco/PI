/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener("load", carregar);

var altera = false;

var pesquisa = false;

function carregar (evt) {
    pesquisa = "false";
    document.getElementById('nomecliente').disabled = true;
    document.getElementById('cpfcliente').disabled = true;
    document.getElementById('telefonecliente').disabled = true;
    document.getElementById('emailcliente').disabled = true;
    document.getElementById('enderecocliente').disabled = true;
    document.getElementById('cidadecliente').disabled = true;
    document.getElementById('estadocliente').disabled = true;
    
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
    
    document.getElementById('btn-alterar').addEventListener("click", alteraEVerdadeiro);
    document.getElementById('btn-pesquisar').addEventListener("click", alteraEFalso);
}

function alteraEFalso() {
    altera = false;    
}

function alteraEVerdadeiro() {
    altera = true;
}

function validarAlterarCliente() {
    if (altera === true) {
        //Campos
        var estado = document.getElementById('estadocliente').value;
        var nome = document.getElementById('nomecliente').value;


        //Mensagem de campos em branco e validacao
    //    var brancobool;
    //    if (estado === "0") {
    //        brancobool = false;
    //        alert("Todos os campos devem ser preenchidos!");        
    //        return false;
    //    } else {
    //        brancobool = true;
    //    }    

        //Validar nome
        var nomebool;    
        var letters = /^[A-Za-z]+$/;
        if(nome.match(letters)) {
            nomebool = true;
        } else {
            document.getElementById("err-campo-nome").classList.add("aparecer");
            nomebool = false;
        }

        //Checa todos os campos
        if (nomebool === true) {
            return true;
        }
        else {
            return false;
        }
    }
    else {
        return true;
    }
};

function erroNome() {
    var nome = document.getElementById('nomecliente').value;
    
    //Validar nome
    var nomebool;    
    var letters = /^[A-Za-z]+$/;
    if(nome.match(letters)) {
        
    } else {
        document.getElementById("err-campo-nome").classList.add("aparecer");
    }
}



