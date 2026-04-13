# Gestión de Gimnasio - FitZone Murcia

Proyecto en Java que simula la gestión de un gimnasio, permitiendo trabajar con socios, actividades y reservas.

---

## Requisitos

* Java 25
* Maven

---

## Instalación

1. Clonar el repositorio:

```bash
git clone <URL_DEL_REPOSITORIO>
```

2. Abrir el proyecto en Intelij

---

## Ejecución

Ejecutar la clase `Main`

---

## Funcionalidades

* Añadir socios con distintos tipos de cuota
* Crear actividades con aforo limitado
* Realizar reservas de actividades
* Controlar el aforo (no permite reservas si está lleno)
* Cancelar reservas
* Obtener listados:

    * Actividades de un socio
    * Actividades completas
    * Ranking de socios
    * Reservas ordenadas por distintos criterios

---

##  Estructura

* `App` → clase `Main`
* `Entidades` → Socio, Actividad, Reserva, etc.
* `Servicios` → clase `Gimnasio`

---

## Autor

Daniel Fernandez
