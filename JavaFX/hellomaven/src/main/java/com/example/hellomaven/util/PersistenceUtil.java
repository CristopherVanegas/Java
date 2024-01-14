package com.example.hellomaven.util;

import com.example.hellomaven.model.Tarea;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistenceUtil {
    private static final String JSON_FILE_PATH = "tareas.json";

    public static void guardarTareas(List<Tarea> tareas) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(JSON_FILE_PATH), tareas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Tarea> cargarTareas() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(JSON_FILE_PATH);

        if (file.exists()) {
            try {
                return objectMapper.readValue(file, new TypeReference<List<Tarea>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<>();
    }
}
