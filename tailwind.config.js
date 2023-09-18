/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/resources/**/*.{html,js}"],
  theme: {
        extend: {
      
      animation: {
        enteringModal: "enteringModal 0.5s ease-in-out",
        backModal: "backModal 0.5s ease-in-out",
        fadeIn: "fadeIn 2s ease-in-out",
        fadeOut: "fadeOut 0.5s ease-in-out",
        zoomIn: "zoomIn 0.5s ease-in-out",
        zoomOut: "zoomOut 0.5s ease-in-out",
        leaving: "leaving 1s ease-in-out",
        entrando: "entrando 1s ease-in-out",
        leavingIzq: "leavingIzq 0.5s ease-in-out",
        entrandoIzq: "entrandoIzq 0.5s ease-in-out",
      },
      keyframes: {
        enteringModal: {
          "0%": {
                transform: "translateX(-100%)"
              },
          "100%": {
            transform: "translateX(0)"
          },
        },
        backModal: {
          "0%": {
                transform: "translateX(100%)"
              },
          "100%": {
            transform: "translateX(0)"
          },
        },
        leaving: {
          "0%": {
            top: 0,
            right: 0,
          },
          "100%": {
            top: 0,
            right: "-20rem",
          },
        },
        entrando: {
          "0%": {
            top: 0,
            right: "-20rem",
          },
          "100%": {
            top: 0,
            right: "0",
          },
        },
        leavingIzq: {
          "0%": {
            top: 0,
            left: 0,
          },
          "100%": {
            top: 0,
            left: "-20rem",
          },
        },
        entrandoIzq: {
          "0%": {
            top: 0,
            left: "-20rem",
          },
          "100%": {
            top: 0,
            left: "0",
          },
        },
        fadeIn: {
          "0%": {
            opacity: 0,
          },
          "100%": { opacity: 100 },
        },
        fadeOut: {
          "0%": {
            opacity: 100,
          },
          "100%": { opacity: 0 },
        },
        zoomIn: {
          "0%": { transform: "scale(1)" },
          "100%": { transform: "scale(0)" },
        },
        zoomOut: {
          "0%": { transform: "scale(0)" },
          "100%": { transform: "scale(1)" },
        },
      },
    },
  },
  plugins: [],
}

