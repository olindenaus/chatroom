import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
      host: true,
    port: 5137,
    proxy: {
      // All requests starting with /api go to backend
      '/api': {
        target: 'http://192.168.1.3:8080',
        changeOrigin: true,
        secure: false,
      },
  }},
})

