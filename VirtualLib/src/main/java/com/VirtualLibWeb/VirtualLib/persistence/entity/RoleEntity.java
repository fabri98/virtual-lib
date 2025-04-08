package com.VirtualLibWeb.VirtualLib.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id",
                    referencedColumnName = "permissionId"
            )
    )
    private Set<PermissionEntity> permissions;
}