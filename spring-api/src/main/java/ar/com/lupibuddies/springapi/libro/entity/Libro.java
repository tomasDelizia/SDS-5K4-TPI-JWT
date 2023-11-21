package ar.com.lupibuddies.springapi.libro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String isbn;

    private String titulo;

    private String autor;

    private String editorial;

    private LocalDate fechaLanzamiento;

    @CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;


    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private UUID createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private UUID lastModifiedBy;
}
