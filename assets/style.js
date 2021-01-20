// Toggles dark mode and stuff.
// css-tricks.com/a-complete-guide-to-dark-mode-on-the-web

function isActuallyDarkTheme() {
  return (document.documentElement.classList.contains("dark-mode"))
}

function getTheme() {
  return (isActuallyDarkTheme() ? "dark" : "light")
}

function getThemePref() {
  return localStorage.getItem("theme");
}

function getThemeOSPref() {
  return (window.matchMedia("(prefers-color-scheme: dark)").matches ? "dark" : "light")
}

function toggleTheme() {
  document.documentElement.classList.toggle("dark-mode")
  localStorage.setItem("theme", getTheme())
}

if (!getThemePref()) {
  localStorage.setItem("theme", getThemeOSPref())
}

if (getTheme() != getThemePref()) {
  toggleTheme()
}

document.addEventListener(
  "DOMContentLoaded",  // wait for HTML to load, then we can add the button event.
  function () {
    const btn = document.querySelector(".switch");
    btn.addEventListener("click", toggleTheme)
  }
)
