function validarCampos() {
    //Campos
    var email = document.getElementById('emailcliente').value;
    var endereco = document.getElementById('enderecocliente').value;
    var cidade = document.getElementById('cidadecliente').value;
    var estado = document.getElementById('estadocliente').value;
    var nome = document.getElementById('nomecliente').value;
    var cpf = document.getElementById('cpfcliente').value;
    var telefone = document.getElementById('telefonecliente').value;
    
    
    //Mensagem de campos em branco e validacao
    var brancobool;
    if (estado === "0") {
        brancobool = false;
        alert("Todos os campos devem ser preenchidos!");        
        return false;
    } else {
        brancobool = true;
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

    
    //Checa todos os campos
    if (nomebool === true && brancobool === true) {
        return true;
    }
    else {
        return false;
    }
};


function validarIdAlterar() {
    //Campos
    var id = document.querySelector( ".id-pesquisar");value; 
    
    //Validar id
    var idbool;    
    var numeros = /[0-9]/;
    if(id.match(numeros)) {
        idbool = true;
    } else {
        document.querySelector( ".erro-id").classList.add("aparecer");
        idbool = false;
    }
    
    //Checa todos os campos
    if (idbool === true) {
        return true;
    }
    else {
        return false;
    }
};

//Função que valida campos de cadastro
function validarFilialCadastrar() {
    //Campos
    var estado = document.getElementById('uf').value;
    
    
    //Mensagem de campos em branco e validacao
    var brancobool;
    if (estado === "0") {
        brancobool = false;
        document.getElementById("err-campo-estado").classList.add("aparecer");
    } else {
        brancobool = true;
    } 
    
    
    //Checa todos os campos
    if (brancobool === true) {
        return true;
    }
    else {
        return false;
    }
};


//Função que valida campos de cadastro
function validarFuncionarioCadastrar() {
    //Campos
    var nome = document.getElementById('nomefuncionario').value;
    var estado = document.getElementById('estadofuncionario').value;
    var cargo = document.getElementById('cargofuncionario').value;
    
    
    //Mensagem de campos em branco e validacao
    var brancobool;
    if (estado === "0" || cargo === "0") {
        brancobool = false;
        alert("Todos os campos devem ser preenchidos!");
    } else {
        brancobool = true;
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
    
    
    //Checa todos os campos
    if (brancobool === true && nomebool === true) {
        return true;
    }
    else {
        return false;
    }
};