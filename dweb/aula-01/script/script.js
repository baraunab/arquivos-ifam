botao = document.querySelector("#botaoTema");
corpo = document.body;

// document = manipulação do dom e dos valores

function alternarTema() {
    var estaNoModoEscuro = corpo.classList.toggle('dark-mode');
    if (estaNoModoEscuro) {
        botaoTema.textContent = "Modo Claro";
    } else {
        botaoTema.textContent = "Modo Escuro";
    }
}


// botaoTema.addEventListener("click", alternarTema);

/* funcao anonima (sem nome)
botaoTema.addEventListener("click", function () {
    const estaNoModoEscuro = corpo.classList.toggle('dark-mode');
    
    if (estaNoModoEscuro) {
        botaoTema.textContent = "Modo Claro";
    } else {
        botaoTema.textContent = "Modo Escuro";
    }
});
*/

// arrow function => 
botaoTema.addEventListener("click", () => {
    const estaNoModoEscuro = corpo.classList.toggle('dark-mode');
    
    if (estaNoModoEscuro) {
        botaoTema.textContent = "Modo Claro";
    } else {
        botaoTema.textContent = "Modo Escuro";
    }
});