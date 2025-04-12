# 📝 Editor de Texto con Búsqueda y Funciones de Deshacer/Rehacer

## Descripcion

Este proyecto es un **editor de texto interactivo en Java**, desarrollado con la biblioteca **Swing**, que ofrece las siguientes funcionalidades:

- Busqueda de palabras con resaltado en el texto.
- Navegacion entre ocurrencias encontradas.
- Funcionalidades de **deshacer** y **rehacer** cambios realizados en el texto.
- Implementacion de un **Arbol Binario de Busqueda** para almacenar palabras y sus posiciones, ideal para futuras funcionalidades como indices o analisis de texto.

---

## Funcionalidades

- 🔍 **Buscar y Resaltar Palabras**: Busca una palabra y resalta todas sus apariciones en el area de texto.
- ➡️ **Navegar entre Ocurrencias**: Permite moverse entre cada aparicion de la palabra buscada.
- ↩️ **Deshacer Cambios**: Revierte el ultimo cambio realizado.
- ↪️ **Rehacer Cambios**: Restaura un cambio que fue deshecho.
- 🌳 **Arbol Binario de Busqueda**: Estructura que almacena palabras y posiciones (implementación auxiliar).

---

## Estructura del Proyecto

- `Editortexto2.java`: Ventana principal con interfaz grafica y eventos.
- `Buscador.java`: Encargado de buscar y resaltar palabras en el texto.
- `GestorOperaciones.java`: Controla las pilas de deshacer y rehacer.
- `ArbolBinarioDeBusqueda.java`: Permite insertar y buscar palabras con sus posiciones.
- `Nodo.java`: Representa cada nodo del árbol binario, con palabra y lista de posiciones.

---

## Tecnologías Usadas

- **Lenguaje:** Java
- **Librerías GUI:** Swing (javax.swing)
- **Estructuras de Datos:** Pilas (Stack), Listas (ArrayList), Arbol Binario

---



