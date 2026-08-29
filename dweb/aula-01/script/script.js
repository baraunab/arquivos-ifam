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

botaoTema.addEventListener("click", alternarTema);