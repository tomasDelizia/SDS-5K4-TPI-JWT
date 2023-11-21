package ar.com.lupibuddies.springapi.libro.controller;

import ar.com.lupibuddies.springapi.libro.dto.LibroDTO;
import ar.com.lupibuddies.springapi.libro.dto.LibroRequest;
import ar.com.lupibuddies.springapi.libro.service.LibroService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/libros")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    @Hidden
    public void save(
            @RequestBody LibroRequest request
    ) {
        libroService.save(request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    @Hidden
    public void delete(
            @PathVariable UUID id
    ) {
        libroService.delete(id);
    }

    @GetMapping
    public List<LibroDTO> findAll() {
        return libroService.findAll();
    }
}
