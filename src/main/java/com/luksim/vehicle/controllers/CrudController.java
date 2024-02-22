package com.luksim.vehicle.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudController<E, ID> {
    protected final JpaRepository<E, ID> repository;

    protected CrudController(JpaRepository<E, ID> repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<E>> getItems() {
        List<E> items = repository.findAll();

        if (items.isEmpty()) {
            return new ResponseEntity<>(null, null, 204);
        }

        return new ResponseEntity<>(items, null, 200);
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> getItemById(@PathVariable ID id) {
        E item = repository.findById(id).orElse(null);

        if (item == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        return new ResponseEntity<>(item, null, 200);
    }

    @PostMapping
    public ResponseEntity<E> createItem(@RequestBody E item) {
        E newItem = repository.save(item);

        return new ResponseEntity<>(newItem, null, 201);
    }

    @PutMapping("/{id}")
    public ResponseEntity<E> updateItem(@PathVariable ID id, @RequestBody E item) {
        E existingItem = repository.findById(id).orElse(null);

        if (existingItem == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        updateEntity(existingItem, item);

        return new ResponseEntity<>(repository.save(existingItem), null, 200);
    }

    protected abstract void updateEntity(E existingItem, E item);

    @DeleteMapping("/{id}")
    public ResponseEntity<E> deleteItem(@PathVariable ID id) {
        E item = repository.findById(id).orElse(null);

        if (item == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        repository.delete(item);

        return new ResponseEntity<>(null, null, 204);
    }
}
