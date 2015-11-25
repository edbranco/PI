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
    document.getElementById('nomefuncionario').disabled = true;
    document.getElementById('rafuncionario').disabled = true;
    document.getElementById('cpffuncionario').disabled = true;
    document.getElementById('filialfuncionario').disabled = true;
    document.getElementById('telefonefuncionario').disabled = true;
    document.getElementById('emailfuncionario').disabled = true;
    document.getElementById('enderecofuncionario').disabled = true;
    document.getElementById('cargofuncionario').disabled = true;
    document.getElementById('estadofuncionario').disabled = true;
    document.getElementById('cidadefuncionario').disabled = true;
    
    pesquisa = document.getElementById('habilitado').value;  
    if (pesquisa === "true") {
        document.getElementById('nomefuncionario').disabled = false;
    document.getElementById('rafuncionario').disabled = false;
    document.getElementById('cpffuncionario').disabled = false;
    document.getElementById('filialfuncionario').disabled = false;
    document.getElementById('telefonefuncionario').disabled = false;
    document.getElementById('emailfuncionario').disabled = false;
    document.getElementById('enderecofuncionario').disabled = false;
    document.getElementById('cargofuncionario').disabled = false;
    document.getElementById('estadofuncionario').disabled = false;
    document.getElementById('cidadefuncionario').disabled = false;
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
    var id = document.getElementById('idfuncionario').value;
    
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
    var id = document.getElementById('idfuncionario').value;
    
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

function validarAlterarFuncionario() {
    if (altera === true && idErrado === false) {
        //Campos
        var id = document.getElementById('idfuncionario').value;
        var nome = document.getElementById('nomefuncionario').value;
    
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
        
        if (document.getElementById('nomefuncionario').hasAttribute('disabled')) {
            document.getElementById("alerta-pes-funcionario").classList.add("aparecer");
            document.getElementById("suc-alt-funcionario").classList.add("desaparecer");
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

function erroNome() {
    var nome = document.getElementById('nomefuncionario').value;
    
    //Validar nome
    var nomebool;    
    var letters = /^[A-Za-z]+$/;
    if(nome.match(letters)) {
        
    } else {
        document.getElementById("err-campo-nome").classList.add("aparecer");
    }
}



