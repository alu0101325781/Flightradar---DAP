package es.ull.patrones.practica7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class RunPythonScriptWithParameters {
    public static void main(String[] args) {
        try {
            String workingDir = System.getProperty("user.dir");
            // Ruta al script de Python
            String scriptPath = workingDir + "/get_flight_id.py";
            System.out.println(scriptPath);
            // Parámetros para pasar al script de Python
            String[] scriptParameters = {"2", "NT5223"};

            // Crear un proceso para ejecutar el script
            ProcessBuilder processBuilder = new ProcessBuilder("python3", scriptPath);
            processBuilder.command().addAll(Arrays.asList(scriptParameters));

            // Redirigir la salida estándar del proceso
            processBuilder.redirectErrorStream(true);

            // Iniciar el proceso
            Process process = processBuilder.start();

            // Capturar la salida del proceso
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder outputBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outputBuilder.append(line).append(System.lineSeparator());
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Script de Python terminado con código de salida: " + exitCode);

            // Imprimir la salida del script de Python
            String outputContent = outputBuilder.toString();
            System.out.println("Salida del script de Python:");
            System.out.println(outputContent);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
