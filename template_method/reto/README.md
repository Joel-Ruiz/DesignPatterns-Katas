# Reto (Templade Method)

## Instrucciones

El código en este directorio contiene dos clases, `CsvDataMiner` y `PdfDataMiner`, que realizan un proceso de extracción y análisis de datos.
Aunque los detalles de extracción son diferentes para cada formato, la estructura del algoritmo es idéntica (Abrir -> Extraer -> Analizar -> Cerrar) y el paso de "Análisis" contiene código duplicado.
Tu objetivo es refactorizar este sistema aplicando el Patrón Template Method para definir el esqueleto del algoritmo en un solo lugar y permitir que las subclases solo se preocupen de sus pasos específicos.

## Codigo a refactorizar

**Archivo: `CsvDataMiner.java`**
```java
package template_method.reto;

public class CsvDataMiner {
    
    public void mine(String path) {
        // --- PASO 1: Abrir ---
        System.out.println("Abriendo archivo CSV en: " + path);
        
        // --- PASO 2: Extraer (Específico de CSV) ---
        System.out.println("Leyendo líneas del CSV...");
        System.out.println("Parseando campos separados por comas...");
        String data = "Datos CSV procesados";
        
        // --- PASO 3: Analizar (Común) ---
        // Imagina que esto son 50 líneas de lógica de negocio compleja
        System.out.println("Analizando los datos: " + data);
        System.out.println("Aplicando filtros de negocio...");
        
        // --- PASO 4: Cerrar ---
        System.out.println("Cerrando archivo CSV.");
    }
}
```

**Archivo: `PdfDataMiner.java`**
```java
package template_method.reto;

public class PdfDataMiner {
    
    public void mine(String path) {
        // --- PASO 1: Abrir ---
        System.out.println("Abriendo archivo PDF en: " + path);
        
        // --- PASO 2: Extraer (Específico de PDF) ---
        System.out.println("Leyendo estructura binaria del PDF...");
        System.out.println("Extrayendo texto de las capas...");
        String data = "Datos PDF procesados";
        
        // --- PASO 3: Analizar (Común - ¡CÓDIGO DUPLICADO!) ---
        // El desarrollador copió y pegó la lógica de análisis aquí.
        System.out.println("Analizando los datos: " + data);
        System.out.println("Aplicando filtros de negocio...");
        
        // --- PASO 4: Cerrar ---
        System.out.println("Cerrando archivo PDF.");
    }
}
```

**Archivo: `Main.java`**
```java
package template_method.reto;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Minería de Datos CSV ---");
        CsvDataMiner csvMiner = new CsvDataMiner();
        csvMiner.mine("datos.csv");
        
        System.out.println("\n--- Minería de Datos PDF ---");
        PdfDataMiner pdfMiner = new PdfDataMiner();
        pdfMiner.mine("informe.pdf");
        
        // El cliente no tiene una forma uniforme de tratarlos (no comparten clase padre útil)
        // Y si cambiamos la lógica de "Analizar", tenemos que editar las dos clases.
    }
}
```

## Tips

1. Principio de Hollywood
    - El Template Method sigue el principio: "No nos llames, nosotros te llamamos".
    - Fíjate cómo la clase padre (`DataMiner`) ahora tiene el control. Ella decide cuándo se abre el archivo y cuándo se analizan los datos. Las subclases solo proveen la implementación del "cómo", pero no controlan el flujo.
2. Uso de `final`
    - Pregunta de Reflexión: ¿Por qué es importante que el método mine() sea final?
3. Hooks
    - A veces hay pasos opcionales. Podrías tener un método hook() en la clase padre que no haga nada por defecto, pero que una subclase pueda sobrescribir si necesita inyectar lógica extra en algún punto del algoritmo.
    
## Recursos adicionales

- [Refactoring Guru - Template Method Pattern](https://refactoring.guru/design-patterns/template-method)
- [Source Making - Template Method Pattern](https://sourcemaking.com/design_patterns/template-method)