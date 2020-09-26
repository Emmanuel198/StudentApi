package Api.StudentApi.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contact")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    private List<TelephoneEntity> telephones;

    public List<TelephoneEntity> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneEntity> telephones) {
        this.telephones = telephones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
