# Example MVVM App

Esta es una aplicación de ejemplo que utiliza la arquitectura MVVM (Modelo-Vista-VistaModelo) para mostrar citas aleatorias. 
La aplicación consume datos de una API y los muestra en una interfaz de usuario.
También permite obtener una nueva cita aleatoria al hacer clic en la pantalla.

## Características

- Muestra citas aleatorias en la pantalla principal.
- Permite obtener una nueva cita aleatoria al hacer clic en la pantalla.
- Utiliza arquitectura MVVM para separar la lógica de la vista y el modelo de datos.
- Utiliza Dagger Hilt para la inyección de dependencias.
- Almacena y recupera las citas en una base de datos local mediante Room.
- Realiza solicitudes a una API remota para obtener las citas utilizando Retrofit.
- Contiene pruebas unitarias para casos de uso y ViewModel.
- Contiene pruebas instrumentadas para verificar el comportamiento de la interfaz de usuario.

## Estructura del Proyecto

- `app`: Contiene la aplicación principal, incluyendo la interfaz de usuario, ViewModel y lógica de la aplicación.
- `data`: Contiene las clases relacionadas con la obtención y almacenamiento de datos.
- `domain`: Contiene las clases de caso de uso y modelos de dominio.
- `di`: Contiene los módulos de inyección de dependencias utilizando Dagger Hilt.
- `ui`: Contiene las clases de vista y archivos relacionados con la interfaz de usuario.
- `test`: Contiene pruebas unitarias.

---

Proyecto basado en el repositorio [SimpleAndroidMVVM](https://github.com/ArisGuimera/SimpleAndroidMVVM)
