#  Prueba Técnica

[![Made with Kotlin](https://img.shields.io/badge/Made%20with-Kotlin-blueviolet)]()  

Bienvenidos a la prueba técnica de Juan Antonio Rivero, he creado una aplicación simple, en la que se puede ver mi forma de programar,
algunas de las herramientas que conozco, y la forma en la que estructuro el código.

Los datos los he usado de la API publica de Rick & Morty - https://rickandmortyapi.com/

Lo primero que me gustaría comentar es que la aplicación esta solo comprobada en Android, no dispongo de entorno iOs, por lo que no tengo la posibilidad de compilarla. Se podría compilar para iOs, pero me sorprendería que no crashease

---

## ⚡ Instalación
- Clona el repositorio 
- La versión utilizada de Android Studio es Android Studio Otter | 2025.2.1
- Ejecuta en tu emulador o dispositivo.

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

##🐞 ToDo
- **Vista de detalle con mas información**: Solo habría que actualizar los modelos de datos para recuperar mas información de la API.
- **Paginación**: la API lo permite, asi el listado de personajes podría salir entero. 
- **Persistencia de Datos**: Mi primera idea era que el personaje random se guardase en persistencia de datos, para que de primeras siempre apareciese el último que aparecio pero me quede sin tiempo para llevarlo a cabo. 

---

##📜 Explicación del proyecto
Para mostrar la forma en la que estructuro mi código, y según los principio de clean arquitectura y beunas practicas, he creado 3 directorios principales (data, domain, presentación) mas 1 directorio core:
	- **Domain**: capa de dominio, no sabe que esta pasando en las siguientes capas, es donde se encuentra la lógica de negocio, la aplicación es pequeña y no es realmente necesario haber creado ningún caso de uso, pero he creado dos para mostrar conocimientos. En esta capa se encuentra el repositorio
	- **Data**: capa de datos, es la siguiente capa, a través de la implementación del repositorio y el ApiService recoge los datos de la API. Tiene su propio modelo de datos, por lo que tiene que mapearlos al modelo de dominio.
	- **Presentation**: es la capa de UI, en ella se encuentra todas las pantallas, los viewModels, y la navegación. No dispone de modelo de datos propios por que no lo he creído necesario, usa el modelo de datos del dominio.
	- **core**: Es un directorio general para toda la aplicación, en el he metido la inyección de dependencias y un archivo con algunas constantes necesarias para la app.

---

##👀 Nota final
Muchas gracias por la posibilidad de mostrar mis conocimientos.
