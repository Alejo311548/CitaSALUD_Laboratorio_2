# Entorno CI/CD para módulo de agendamiento de citas (EV07-Feature2)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Alejo311548_CitaSALUD_Laboratorio_2&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Alejo311548_CitaSALUD_Laboratorio_2)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Alejo311548_CitaSALUD_Laboratorio_2&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Alejo311548_CitaSALUD_Laboratorio_2)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Alejo311548_CitaSALUD_Laboratorio_2&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Alejo311548_CitaSALUD_Laboratorio_2)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Alejo311548_CitaSALUD_Laboratorio_2&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Alejo311548_CitaSALUD_Laboratorio_2)

### Arquitectura de Software  
**Estudiante:** Alejandro Vargas Ocamoo  
**Asignatura:** Arquitectura de Software  

---

## Descripción

Este proyecto es un backend desarrollado en Java con Spring Boot que expone una API REST para la gestión de especialidades, sedes y autenticación de usuarios. La API está desplegada en una instancia EC2 de AWS y disponible públicamente para consumo.

---

## Endpoints disponibles

| Método | Endpoint                             | Descripción                     |
|--------|------------------------------------|--------------------------------|
| GET    | `http://3.134.90.30:8080/api/especialidades` | Obtiene la lista de especialidades disponibles |
| GET    | `http://3.134.90.30:8080/api/sedes`          | Obtiene la lista de sedes registradas          |
| POST   | `http://3.134.90.30:8080/api/auth/login`     | Autenticación de usuario (login)                |
| POST   | `http://3.134.90.30:8080/api/auth/register`  | Registro de nuevos usuarios                      |

---


## Ejecutar la API localmente con Docker

1. Clone el repositorio:

```bash
git clone <[URL-del-repositorio](https://github.com/Alejo311548/CitaSALUD_Laboratorio_2)>
cd <CitaSALUD_Laboratorio_2>

2. Construya la imagen Docker desde el Dockerfile ubicado en la raíz del proyecto:

```bash
docker build -t citasalud-backend .

3. Ejecute el contenedor
 
```bash
docker run -d -p 8080:8080 --name citasalud-backend alejo311548/citasalud-backend

4. Verifique que el contenedor esté corriendo
```bash
docker ps

5. Realice los llamados a los diferentes endpoints
```bash
http://localhost:8080/api/especialidades
http://localhost:8080/api/sedes
http://localhost:8080/api/auth/login
http://localhost:8080/api/auth/register




### Cuándo y cómo probar cada endpoint

- **GET `/api/especialidades`**  
  Envía una petición GET para obtener la lista de especialidades.  
  Disponible siempre que la API esté activa.

- **GET `/api/sedes`**  
  Envía una petición GET para obtener la lista de sedes.  
  Disponible siempre que la API esté activa.

- **POST `/api/auth/register`**  
  Envía una petición POST con un cuerpo JSON para registrar un nuevo usuario.  
  Ejemplo de cuerpo JSON:

  ```json
  {
  "nombre": "Pepe Perez",
  "email": "Pepe@example.com",
  "telefono": "3214567890",
  "password": "12345678"
}

- **POST `/api/auth/login`**  
  Envía una petición POST con un cuerpo JSON con un usuario registrado.  
  Ejemplo de cuerpo JSON:

  ```json
  {
  
  "email": "Pepe@example.com",
  "password": "12345678"
}
