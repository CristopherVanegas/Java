package com.example.jsonmanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileManager {
    private final String filePath;

    public JsonFileManager(String filePath) {
        this.filePath = filePath;
    }

    public void guardarClientes(List<Cliente> clientes) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(filePath), clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> cargarClientes() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Cliente> clientes = new ArrayList<>();

        try {
            clientes = objectMapper.readValue(new File(filePath), new TypeReference<List<Cliente>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
