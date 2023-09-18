//Zona de recolección de datos
let modalBorrar = document.getElementById("modalBorrar");
let modalBorrarContent = document.getElementById("modalBorrarContent");
let modalEditar = document.getElementById("modalEditar");
let modalEditarContent = document.getElementById("modalEditarContent");
let modalAgregar = document.getElementById("modalAgregar");
let slide1 = document.getElementById("slide1");
let slide2 = document.getElementById("slide2");
let slide3 = document.getElementById("slide3");
let slide4 = document.getElementById("slide4");

//Botón agregar cita
function botonAgregarFotoCita() {
  let botonFoto = document.getElementById('agregarFoto')
  let checkbox = document.getElementById('span1')
  if (checkbox.classList.contains("invisible"))  {
    botonFoto.classList.remove('hidden');
    checkbox.classList.remove('invisible')
  } else {
    botonFoto.classList.add('hidden');
    checkbox.classList.add('invisible')
  }
  
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
function cerrarModalCita() {
  modalAgregar.classList.add("animate-fadeOut");
  window.scrollTo({
      top: 650,
      behavior: "smooth",
    })
  setTimeout(function () {
    modalAgregar.classList.remove("animate-fadeOut");
    modalAgregar.classList.remove("flex");
    modalAgregar.classList.add("hidden");
  },500)
  
}

function cambiarSlide1() {
  
  slide1.classList.remove("animate-zoomOut");
  slide1.classList.add("animate-zoomIn");
  setTimeout(function () {
    slide1.classList.remove("animate-zoomIn");
    slide1.classList.add("animate-zoomOut");
    slide1.classList.add("hidden");
    slide2.classList.remove("hidden");
  },500)


}
function volverSlide1() {
  
  slide2.classList.remove("animate-zoomOut");
  slide2.classList.add("animate-zoomIn");
  setTimeout(function () {
    slide2.classList.remove("animate-zoomIn");
    slide2.classList.add("animate-zoomOut");
    slide2.classList.add("hidden");
    slide1.classList.remove("hidden");
    slide1.classList.remove("animate-zoomOut");
    slide1.classList.add("animate-zoomOut");
  },500)


}
function volverSlide2() {
  
  slide3.classList.remove("animate-enteringModal");
  slide3.classList.add("animate-zoomIn");
  setTimeout(function () {
    slide3.classList.remove("animate-zoomIn");
    slide3.classList.add("animate-enteringModal");
    slide3.classList.add("hidden");
    slide2.classList.remove("hidden");
    slide2.classList.remove("animate-enteringModal");
    slide2.classList.add("animate-backModal");
  },500)


}
function volverSlide3() {
  
  slide4.classList.remove("animate-enteringModal");
  slide4.classList.add("animate-zoomIn");
  setTimeout(function () {
    slide4.classList.remove("animate-zoomIn");
    slide4.classList.add("animate-enteringModal");
    slide4.classList.add("hidden");
    slide3.classList.remove("hidden");
    slide3.classList.remove("animate-enteringModal");
    slide3.classList.add("animate-backModal");
  },500)


}
function cambiarSlide2() {
  
  slide2.classList.remove("animate-zoomOut");
  slide2.classList.add("animate-zoomIn");
  setTimeout(function () {
    slide2.classList.remove("animate-zoomIn");
    slide2.classList.add("animate-zoomOut");
    slide2.classList.add("hidden");
    slide3.classList.remove("hidden");
  },500)


}
function cambiarSlide3() {
  
  slide3.classList.remove("animate-zoomOut");
  slide3.classList.add("animate-zoomIn");
  setTimeout(function () {
    slide3.classList.remove("animate-zoomIn");
    slide3.classList.add("animate-zoomOut");
    slide3.classList.add("hidden");
    slide4.classList.remove("hidden");
  },400)


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
