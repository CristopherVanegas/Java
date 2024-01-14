package com.example.hellomaven.controller;

import com.example.hellomaven.model.Tarea;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TareasController {
    private List<Tarea> listaTareas;
    private final String filePath = "src/main/resources/com/example/hellomaven/data/tareas.json";

    public TareasController() {
        try {
            cargarTareas();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Cargar tareas al instanciar el controlador
    }

    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
        try {
            guardarTareas();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Guardar tareas cada vez que se agrega una nueva
    }

    public void marcarTareaComoCompletada(int indice) {
        if (indice >= 0 && indice < listaTareas.size()) {
            Tarea tarea = listaTareas.get(indice);
            tarea.setCompletada(!tarea.isCompletada()); // Alternar estado completado
            try {
                guardarTareas();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void eliminarTarea(Tarea tarea) {
        listaTareas.remove(tarea);
        try {
            guardarTareas();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Guarda la lista actualizada después de eliminar la tarea
    }

    public List<Tarea> getListaTareas() {
        return new ArrayList<>(listaTareas);
    }

    public void cargarTareas() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
    
        if (file.exists()) {
            listaTareas = objectMapper.readValue(file, new TypeReference<List<Tarea>>() {});
        } else {
            System.out.println("No se encontró el archivo de tareas. Se creará uno nuevo.");
            listaTareas = new ArrayList<>();
        }
    }    

    public void guardarTareas() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), listaTareas);
    }

    public void setListaTareas(List<Tarea> tareasCargadas) {
        this.listaTareas = new ArrayList<>(tareasCargadas);
    }    
}
