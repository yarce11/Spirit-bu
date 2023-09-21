
//Modal Inicio
function cerrarModalInicio() {
  modalInicioContent.classList.add("animate-leaving");
  setTimeout(function () {
    modalInicioContent.classList.remove("animate-leaving");
    modalInicio.classList.add("hidden");
  }, 900);
}
function cerrarModalRegistro() {
  modalRegistro.classList.remove("animate-[fadeIn_0.4s]");
  modalRegistro.classList.add("animate-[fadeOut_0.4s]");
  setTimeout(function () {
    modalRegistro.classList.remove("flex");
    modalRegistro.classList.add("hidden");
    modalRegistro.classList.remove("animate-[fadeOut_0.4s]");
    modalRegistro.classList.add("animate-[fadeIn_0.4s]");
  }, 400);
}
function abrirModalInicio() {
  modalInicio.classList.remove("hidden");
  modalInicio.classList.add("block");
}
function abrirModalRegistro() {
  modalRegistro.classList.remove("hidden");
  modalRegistro.classList.add("flex");
}
function cambiarRegistro1() {
  usuarioRegistro.classList.add("-translate-y-28");
  setTimeout(function () {
    usuarioRegistro.classList.add("hidden");
    correoRegistro.classList.remove("hidden");
  }, 500)
}
function cambiarRegistro2() {
  correoRegistro.classList.add("-translate-y-28");
  setTimeout(function () {
    correoRegistro.classList.add("hidden");
    numeroRegistro.classList.remove("hidden");
  }, 500)
}
function cambiarRegistro3() {
  numeroRegistro.classList.add("-translate-y-28");
  setTimeout(function () {
    numeroRegistro.classList.add("hidden");
    contraRegistro.classList.remove("hidden");
  }, 500)
}

function cerrarBurguer() {
  
  burguerMenu.classList.remove("animate-entrandoIzq");
  burguerMenu.classList.add("animate-leavingIzq");
  setTimeout(() => {
    burguer.classList.add("hidden");
    burguerMenu.classList.remove("animate-leavingIzq");
    burguerMenu.classList.add("animate-entrandoIzq");
  }, 400);
}

function abrirBurguer() {
    burguer.classList.remove("hidden");
}

function abrirMenuUser(menuUser = document.getElementById("menu-user")) {
  (menuUser.classList.contains("hidden"))? menuUser.classList.remove("hidden") : menuUser.classList.add("hidden")
}


let modalInicio = document.getElementById("modalInicio");
let modalRegistro = document.getElementById("modalRegistro");
let modalInicioContent = document.getElementById("modalInicioContent");
let usuarioRegistro = document.getElementById("nombreRegistro");
let correoRegistro = document.getElementById("correoRegistro");
let numeroRegistro = document.getElementById("numeroRegistro");
let contraRegistro = document.getElementById("contraRegistro");
let successRegistro = document.getElementById("successRegistro");
let burguer = document.getElementById("burguer");
let burguerMenu = document.getElementById("burguerMenu");
