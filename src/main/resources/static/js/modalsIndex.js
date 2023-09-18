
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





let modalInicio = document.getElementById("modalInicio");
let modalRegistro = document.getElementById("modalRegistro");
let modalInicioContent = document.getElementById("modalInicioContent");
let usuarioRegistro = document.getElementById("nombreRegistro");
let correoRegistro = document.getElementById("correoRegistro");
let numeroRegistro = document.getElementById("numeroRegistro");
let contraRegistro = document.getElementById("contraRegistro");
let successRegistro = document.getElementById("successRegistro");