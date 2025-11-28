# Kata: Template Method

## Contexto

Estás trabajando en una aplicación de Análisis de Datos que extrae información de diferentes formatos (CSV, PDF) y genera un reporte unificado.
El algoritmo para procesar los datos es siempre el mismo en su estructura:

1. Abrir el recurso (archivo).
2. Extraer los datos crudos.
3. Analizar los datos (aplicar filtros y lógica de negocio).
4. Cerrar el recurso.

El código actual (en la Carpeta Reto) tiene dos clases: `CsvDataMiner` y `PdfDataMiner`. El problema es que ambas clases tienen el método `mine()` duplicado. Aunque la extracción de datos es diferente, la estructura del algoritmo (abrir -> extraer -> analizar -> cerrar) y pasos comunes (como analizar) se han copiado y pegado. Cualquier cambio en la lógica de análisis requiere modificar ambas clases.

## El Patrón: Composite

El patrón Template Method define el esqueleto de un algoritmo en una operación, difiriendo algunos pasos a las subclases. Permite que las subclases redefinan ciertos pasos de un algoritmo sin cambiar la estructura del mismo.
El Template Method resuelve el problema de la duplicación de algoritmos al:

- Crear una Clase Abstracta que contiene el "Método Plantilla" (el esqueleto).
- Este método llama a métodos abstractos (step1(), step2()) para las partes que varían.
- Implementar los pasos comunes directamente en la clase abstracta.
- Dejar que las Subclases Concretas implementen solo los pasos específicos (ej. cómo parsear un CSV vs un PDF).

## Beneficios y Principios SOLID

Beneficios:

- **Eliminación de Código Duplicado**: La estructura del algoritmo y las partes comunes se escriben una sola vez en la clase padre.
- **Inversión de Control (Hollywood Principle)**: "No nos llames, nosotros te llamamos". La clase padre (abstracta) controla el flujo y llama a los métodos de las subclases cuando los necesita.
- **Puntos de Extensión Claros**: Permite controlar exactamente qué partes del algoritmo pueden ser modificadas por los clientes.

Principios SOLID:

- **OCP**: Puedes añadir nuevos tipos de mineros de datos (ej. JsonDataMiner) simplemente extendiendo la clase abstracta e implementando los pasos específicos, sin tocar el algoritmo principal.

## ¿Cuándo usar este patrón?

- **Algoritmos Similares**: Cuando tienes varias clases que realizan procesos muy similares pero con pequeñas diferencias en algunos pasos.
- **Código Común en Subclases**: Cuando quieres factorizar el comportamiento común de varias subclases en una sola clase padre para evitar la duplicación.
- **Control de Flujo**: Cuando quieres imponer una estructura estricta sobre cómo se debe ejecutar una tarea.

## Reto

Para poner en práctica el patrón Composite, consulta el [README del reto](./challenge/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - Template Method Pattern](https://refactoring.guru/design-patterns/template-method)
- [Source Making - Template Method Pattern](https://sourcemaking.com/design_patterns/template-method)