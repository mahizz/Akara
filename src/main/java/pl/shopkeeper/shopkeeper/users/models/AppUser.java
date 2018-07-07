package pl.shopkeeper.shopkeeper.users.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users" , schema="auth")
@EntityListeners(AuditingEntityListener.class)

//  !!seems not to work properly!!
//@JsonIgnoreProperties(value = {"created_at", "updated_at"},  allowGetters = true)

public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String username;

    private String passwd;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created_at;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    @JsonIgnore
    public String getPasswd() {
        return passwd;
    }

    @JsonSetter
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @JsonIgnore
    public Date getCreatedAt() {
        return created_at;
    }

    @JsonSetter
    public void setCreatedAt(Date createdAt) {
        this.created_at = createdAt;
    }

    @JsonIgnore
    public Date getUpdatedAt() {
        return updated_at;
    }

    @JsonSetter
    public void setUpdatedAt(Date updatedAt) {
        this.updated_at = updatedAt;
    }
}

