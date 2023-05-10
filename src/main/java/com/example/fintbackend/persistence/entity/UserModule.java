/*package com.example.fintbackend.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users_modules")
public class UserModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_module_id")
    private Integer idUserModule;

    @Column(name = "module_progress")
    private Integer moduleProgress;

    private String status;

    @OneToMany(mappedBy = "userModule")
    private List<User> user;

    @OneToMany(mappedBy = "userModule")
    private List<Module> module;

    public Integer getIdUserModule() {
        return idUserModule;
    }

    public void setIdUserModule(Integer idUserModule) {
        this.idUserModule = idUserModule;
    }

    public Integer getModuleProgress() {
        return moduleProgress;
    }

    public void setModuleProgress(Integer moduleProgress) {
        this.moduleProgress = moduleProgress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

 */
