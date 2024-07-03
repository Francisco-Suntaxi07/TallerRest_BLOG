package com.api.blog.model.entity.rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ROL")
public class RolEntity {

    @Id
    @Column(name = "IDROL", length = 8, nullable = false)
    private String idRol;

    @Column(name = "NOMBREROL", length = 16)
    private String nombreRol;

}
