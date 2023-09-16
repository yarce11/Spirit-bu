
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


//Modal agregar cita
function modalAgregarCita() {
  modalAgregar.classList.remove("hidden");
  modalAgregar.classList.add("flex");
  window.scrollTo({
    top: 0,
    behavior: "smooth",
  });
}
function cambiarSlide1() {
  slide1.classList.remove("animation-zoomOut")
  slide1.classList.add("animation-fadeOut")
  setTimeout(function () {
    slide1.classList.add("animation-zoomOut")
    modalEditar.classList.add("hidden");
  },500)

}
//Modal editar Citas
function abrirModalEditar() {
  modalEditar.classList.remove("hidden");
  modalEditar.classList.add("flex");
}
function cerrarModalEditar() {
  modalEditarContent.classList.remove("animate-zoomOut");
  modalEditarContent.classList.add("animate-zoomIn");
  setTimeout(function () {
    modalEditarContent.classList.remove("animate-zoomIn");
    modalEditarContent.classList.add("animate-zoomOut");
    modalEditar.classList.remove("flex");
    modalEditar.classList.add("hidden");
  }, 500);
}
//Modal Borrar citas
function abrirModalBorrar() {
  modalBorrar.classList.remove("hidden");
  modalBorrar.classList.add("flex");
}

function cerrarModalBorrar() {
  modalBorrarContent.classList.remove("animate-zoomOut");
  modalBorrarContent.classList.add("animate-zoomIn");
  setTimeout(function () {
    modalBorrarContent.classList.remove("animate-zoomIn");
    modalBorrarContent.classList.add("animate-zoomOut");
    modalBorrar.classList.remove("flex");
    modalBorrar.classList.add("hidden");
  }, 500);
}

let modalBorrar = document.getElementById("modalBorrar");
let modalBorrarContent = document.getElementById("modalBorrarContent");
let modalInicio = document.getElementById("modalInicio");
let modalRegistro = document.getElementById("modalRegistro");
let modalInicioContent = document.getElementById("modalInicioContent");
let modalEditar = document.getElementById("modalEditar");
let modalEditarContent = document.getElementById("modalEditarContent");
let modalAgregar = document.getElementById("modalAgregar");
let slide1 = document.getElementById("slide1");