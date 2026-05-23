<h1 align="center">IoT Sensors API — API REST para Gestión de Datos de Sensores IoT</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Spring_Boot-3.1-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/MongoDB-47A248?logo=mongodb&logoColor=white" alt="MongoDB">
  <img src="https://img.shields.io/badge/Licencia-GPL_v3-0298c3?logo=gnu&logoColor=white" alt="GPL v3">
  <img src="https://img.shields.io/badge/Estado-Active-2ea44f" alt="Active">
</p>

<p align="center">
  <em>Servicio backend para gestionar estados de dispositivos IoT y almacenar lecturas de sensores DHT11, LEDs y servomotores.</em>
</p>

<p align="center">
  <a href="README.md">🇬🇧 English</a> · <a href="README.es.md">🇪🇸 Español</a>
</p>

---

## Acerca de IoT Sensors API

API REST que actúa como intermediario entre microcontroladores compatibles con Arduino y la interfaz web. Gestiona la persistencia de estados de dispositivos y el historial de lecturas de sensores usando MongoDB.

### Ecosistema

| Componente | Repositorio | Stack |
|-----------|-----------|-------|
| API Backend | [chrisssp/iot-sensors-api](https://github.com/chrisssp/iot-sensors-api) | Spring Boot 3, Java 17, MongoDB |
| Frontend | [chrisssp/iot-sensors](https://github.com/chrisssp/iot-sensors) | Angular 17, TypeScript, Chart.js |

## Funcionalidades

- Operaciones CRUD para estados de componentes IoT (LEDs, servo)
- Ingesta de datos del sensor DHT11 (temperatura y humedad)
- Consulta de datos históricos con marcas de tiempo
- CORS habilitado para acceso desde el frontend
- Manejo global de excepciones con respuestas estructuradas

## Inicio rápido

### Requisitos previos

- Java 17+
- MongoDB corriendo en `localhost:27017`
- Maven (o usar el wrapper `mvnw`)

### Instalación

```bash
git clone https://github.com/chrisssp/iot-sensors-api.git
cd iot-sensors-api
./mvnw spring-boot:run
```

La API corre en `http://localhost:8080`.

## Endpoints de la API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/componentes` | Obtener todos los estados |
| GET | `/api/componentes/{elemento}/{estado}` | Actualizar estado de un componente |
| GET | `/api/componentes/save-data/{data}` | Recibir datos del microcontrolador |
| GET | `/api/valores` | Obtener todas las lecturas |
| GET | `/api/valores/{elemento}` | Obtener lecturas por sensor |
| POST | `/api/valores` | Agregar una nueva lectura |

## Contribuciones

Lee [CONTRIBUTING.md](CONTRIBUTING.md) para conocer las convenciones de ramas, commits y PRs.

## Licencia

Este proyecto está bajo la licencia GPL v3 — ver [LICENSE](LICENSE) para más detalles.