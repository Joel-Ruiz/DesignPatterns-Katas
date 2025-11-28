# Solución (Templade Method)

:warning: **Intenta resolver el reto antes de ver la solución** :warning:

## Cambios Principales

La refactorización se centró en eliminar la duplicación de código y centralizar el control del algoritmo en una clase padre.

1. **Clase Abstracta (`DataMiner`)**: 
    - Se creó esta clase para definir el Template Method (`mine()`). 
    - El método `mine()` se marcó como `final` para evitar que las subclases alteren la secuencia de ejecución del algoritmo. 
    - Se implementó el método `analyzeData()` (el paso común) directamente en esta clase, eliminando la duplicación.
    - Se definieron métodos abstractos (openFile, extractData, closeFile) para obligar a las subclases a proporcionar sus propias implementaciones.
2. **Subclases (`CsvDataMiner`, `PdfDataMiner`)**: 
    - Ahora extienden de `DataMiner`. 
    - Se eliminó el método `mine()` de estas clases (ahora lo heredan). Se eliminó el código duplicado de análisis. 
    - Solo contienen la lógica específica para abrir, extraer y cerrar su formato de archivo particular.
3. **Cliente (`Main.java`):**: Aunque el cliente sigue instanciando las clases concretas, ahora se beneficia de una estructura unificada. Podría incluso tratar a ambos mineros como tipos `DataMiner` (polimorfismo).

## Salida Esperada

La salida es idéntica a la del reto, lo cual es el objetivo de una refactorización (cambiar la estructura sin cambiar el comportamiento externo):

```
--- Minería de Datos CSV ---
Abriendo archivo CSV en: datos.csv
Leyendo líneas del CSV...
Parseando campos separados por comas...
Analizando los datos: Datos CSV procesados
Aplicando filtros de negocio complejos...
Cerrando archivo CSV.

--- Minería de Datos PDF ---
Abriendo archivo PDF en: informe.pdf
Leyendo estructura binaria del PDF...
Extrayendo texto de las capas...
Analizando los datos: Datos PDF procesados
Aplicando filtros de negocio complejos...
Cerrando archivo PDF.
```

## Extendiendo la funcionalidad
El Template Method ofrece puntos de extensión muy claros:

1. Si queremos añadir un nuevo formato como `JsonDataMiner` simplemente tenemos que crear la clase, hacer que extienda de `DataMiner` e implementar los 3 metodos abstractos.
2. Si la empresa decide cambiar cómo se analizan los datos (ej. nuevos filtros), solo tienes que modificar el método `analyzeData()` en la clase padre `DataMiner`.
3. Se podría agregar un método `hookPostProcess()` vacío en `DataMiner`. y llamarlo al final de `mine()`. Luego, si el `CsvDataMiner` necesita enviar un email al finalizar, puede sobrescribir ese hook. El `PdfDataMiner` puede ignorarlo y no hacer nada.