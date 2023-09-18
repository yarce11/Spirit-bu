
//Modal Inicio
function cerrarModalInicio() {
  modalInicioContent.classList.add("animate-leaving");
  setTimeout(function () {
    modalInicioContent.classList.remove("animate-leaving");
    modalInicio.classList.remove("hidden");
    modalInicio.classList.add("hidden");
  }, 900);
}
function abrirModalInicio() {
  modalInicio.classList.remove("hidden");
  modalInicio.classList.add("block");
}
function cambiarRegistro1() {
  usuarioRegistro.classList.add("-translate-y-28");
  setTimeout(function () {
    usuarioRegistro.classList.add("hidden");
    correoRegistro.classList.remove("hidden");
  }, 500)
}

let modalInicio = document.getElementById("modalInicio");
let modalRegistro = document.getElementById("modalRegistro");
let modalInicioContent = document.getElementById("modalInicioContent");
let usuarioRegistro = document.getElementById("nombreRegistro");
let correoRegistro = document.getElementById("correoRegistro");