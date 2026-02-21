/* src/main/resources/static/js/main.js */

// 1. Función Logout (Usará una variable global que definiremos en el HTML)
function logout() {
  const appContainer = document.getElementById("app-container");
  if (appContainer) appContainer.classList.remove("opacity-100");

  setTimeout(() => {
    if (appContainer) appContainer.classList.add("hidden");
    // Usamos una variable global APP_CONFIG para la URL
    // Si no existe, usamos un fallback
    window.location.href =
      typeof APP_CONFIG !== "undefined" ? APP_CONFIG.loginUrl : "/login";
  }, 500);
}

// 2. Lógica de Pestañas (SPA)
function switchView(viewId) {
  // Guardar estado en URL
  history.replaceState(null, null, "#" + viewId);

  // Actualizar Menú
  document
    .querySelectorAll(".nav-item")
    .forEach((item) => item.classList.remove("active"));
  const navItem = document.querySelector(`[data-view="${viewId}"]`);
  if (navItem) navItem.classList.add("active");

  // Actualizar Vistas
  document
    .querySelectorAll(".view-section")
    .forEach((section) => section.classList.remove("active"));
  const target = document.getElementById(`view-${viewId}`);
  if (target) target.classList.add("active");

  // Cerrar sidebar en móvil
  if (
    window.innerWidth < 1024 &&
    document.getElementById("sidebar").classList.contains("open")
  ) {
    toggleSidebar();
  }
}

// 3. Utilidades UI
function toggleSidebar() {
  document.getElementById("sidebar").classList.toggle("open");
}

function openModal(id) {
  const modal = document.getElementById(id);
  if (modal) modal.classList.add("active");
}

function closeModal(id) {
  const modal = document.getElementById(id);
  if (modal) modal.classList.remove("active");
}

function toggleDropdown(id) {
  const dropdown = document.getElementById(id);
  if (dropdown) dropdown.classList.toggle("show");
}

// Cerrar dropdowns al hacer click fuera
window.onclick = function (e) {
  if (!e.target.closest(".relative"))
    document
      .querySelectorAll(".dropdown-content")
      .forEach((d) => d.classList.remove("show"));
};

// 4. Inicialización al cargar
document.addEventListener("DOMContentLoaded", () => {
  const urlParams = new URLSearchParams(window.location.search);
  const hash = window.location.hash.replace("#", "");

  // Detectar éxito (si el modal existe en el DOM)
  if (urlParams.has("exito")) {
    switchView(hash);
    openModal("modal-exito");

    // Limpiar URL después de 1 segundo para que no salga el modal al recargar
    setTimeout(() => {
      const newUrl = window.location.pathname + window.location.hash;
      window.history.replaceState({}, document.title, newUrl);
    }, 1000);
  }
  // Detectar navegación por Hash
  else if (hash) {
    switchView(hash);
  }
});

