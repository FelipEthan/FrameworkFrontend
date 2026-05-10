# Framework de Automatización Frontend

Framework de automatización de pruebas para aplicaciones web desarrollado con Selenium WebDriver, Cucumber BDD y JUnit.

## Descripción del Proyecto

Este proyecto implementa un framework de pruebas automatizadas para validar funcionalidades de frontend utilizando el patrón Page Object Model (POM).

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación principal
- **Maven**: Gestión de dependencias y construcción del proyecto
- **Selenium WebDriver 4.21.0**: Automatización de navegadores web
- **Cucumber 7.18.0**: Framework BDD para escribir pruebas legibles
- **JUnit 4.13.2**: Framework de testing
- **WebDriverManager 5.8.0**: Gestión automática de drivers de navegadores

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java JDK 17** o superior
- **Navegador Microsoft Edge**
- **Git**

## Instalación

1. **Clonar el repositorio**
   git clone <url-del-repositorio>
2. **Verificar la instalación de dependencias**
   mvn clean install

## Compilación del Proyecto
Para compilar el proyecto y descargar todas las dependencias necesarias:

mvn clean compile

## Ejecución de las Pruebas

mvn test

## Generación de Reportes

Después de ejecutar las pruebas con `mvn test`, se generan automáticamente los siguientes reportes:

### 1. Reporte HTML
- **Ubicación**: `target/report.html`
- **Descripción**: Reporte visual con detalles de la ejecución
- **Visualización**: Abrir el archivo en cualquier navegador web

start target/report.html
open target/report.html

**Última actualización**: Mayo 2026  
**Versión**: 1.0-SNAPSHOT
