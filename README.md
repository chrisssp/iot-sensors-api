<h1 align="center">IoT Sensors API — REST API for IoT Sensor Data Management</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Spring_Boot-3.1-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/MongoDB-47A248?logo=mongodb&logoColor=white" alt="MongoDB">
  <img src="https://img.shields.io/badge/License-GPL_v3-0298c3?logo=gnu&logoColor=white" alt="GPL v3">
  <img src="https://img.shields.io/badge/Status-Active-2ea44f" alt="Active">
</p>

<p align="center">
  <em>Backend service for managing IoT device states and storing sensor readings from DHT11, LEDs, and servo motors.</em>
</p>

<p align="center">
  <a href="README.md">🇬🇧 English</a> · <a href="README.es.md">🇪🇸 Español</a>
</p>

---

## About IoT Sensors API

REST API backend that serves as the intermediary between Arduino-compatible microcontrollers and the web frontend. It manages device state persistence and sensor reading history using MongoDB.

### Ecosystem

| Component | Repository | Stack |
|-----------|-----------|-------|
| Backend API | [chrisssp/iot-sensors-api](https://github.com/chrisssp/iot-sensors-api) | Spring Boot 3, Java 17, MongoDB |
| Frontend | [chrisssp/iot-sensors](https://github.com/chrisssp/iot-sensors) | Angular 17, TypeScript, Chart.js |

## Features

- CRUD operations for IoT component states (LEDs, servo)
- Sensor data ingestion from DHT11 (temperature and humidity)
- Historical data querying with timestamps
- CORS-enabled for cross-origin frontend access
- Global exception handling with structured error responses

## Quick Start

### Prerequisites

- Java 17+
- MongoDB running on `localhost:27017`
- Maven (or use the provided `mvnw` wrapper)

### Setup

```bash
git clone https://github.com/chrisssp/iot-sensors-api.git
cd iot-sensors-api
./mvnw spring-boot:run
```

The API runs on `http://localhost:8080`.

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/componentes` | Get all component states |
| GET | `/api/componentes/{elemento}/{estado}` | Update a component state |
| GET | `/api/componentes/save-data/{data}` | Ingest sensor data from microcontroller |
| GET | `/api/valores` | Get all sensor readings |
| GET | `/api/valores/{elemento}` | Get readings by sensor |
| POST | `/api/valores` | Add a new sensor reading |

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for branch naming, commit conventions, and PR workflow.

## License

This project is licensed under the GPL v3 — see the [LICENSE](LICENSE) file for details.

---

<p align="center">
  <sub>Built with ❤️ · 2026</sub>
</p>
