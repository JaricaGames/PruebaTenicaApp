#  Prueba Técnica

[![Made with Kotlin](https://img.shields.io/badge/Made%20with-Kotlin-blueviolet)]()  

Bienvenidos a la prueba técnica de Juan Antonio Rivero, he creado una aplicación simple, en la que se puede ver mi forma de programar,
algunas de las herramientas que conozco, y la forma en la que estructuro el código.

Los datos los he usado de la API publica de Rick & Morty - https://rickandmortyapi.com/

Lo primero que me gustaría comentar es que la aplicación esta solo comprobada en Android, no dispongo de entorno iOs, por lo que no es
posible compilarla. Se podría compilar para iOs, pero me sorprendería que no crashease

---

## ⚡ Instalación

Clona el repositorio 
La versión utilizada de Android Studio es Android Studio Otter | 2025.2.1
Ejecuta en tu emulador o dispositivo.

---

## 📱 Tecnologías utilizadas
- **Lenguaje**: Kotlin
- **UI Framework**: Compose Multiplatform  
- **Arquitectura**: 
	- Clean Arquitecture
	- MVVM (Model-View-ViewModel)
	- Koin, para la inyección de dependencias.
	- Coil, para la carga de imágenes de internet.
	- Ktor, framework HTTP para APIs RESTful
	
---

## 🚀 Features
- **Listado de Personajes**: Se listan los 20 primeros personajes de la API, al no tener paginación la app y hacer una llamada completa.  
- **Detalle del listado**: Al pulsar sobre cualquier elemento del listado muestra la información completa de cada elemento.  
- **Mostrar personaje aleatorio**: Al pulsar un botón se muestra la información un personaje aleatorio de entre toda la API

---

## 🐞 ToDo

algunas implementaciones que me hubiese gustado implementar pero me ha faltado tiempo:
- **Vista de detalle con mas información**: Solo habría que actualizar los modelos de datos para recuperar mas información de la API.
- **Paginación**: la API lo permite, asi el listado de personajes podría salir entero. 
- **Persistencia de Datos**: Mi primera idea era que el personaje random se guardase en persistencia de datos, para que de primeras siempre apareciese el último que aparecido pero me quede sin tiempo para llevarlo a cabo. 


##📜 Licencia
Este proyecto está bajo la licencia MIT.
O sea: úsalo, compártelo, modifícalo... pero si tu grupo se pelea por culpa de la app, no es responsabilidad nuestra. 😅

##👀 Nota final
Recuerda: una amistad rota por 3€ no vale la pena... pero una app que te los recuerda sí.
