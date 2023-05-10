/*package com.example.fintbackend.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "modules")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    private Integer idModule;

    @Column(name = "module_title")
    private String moduleTitle;

    private String description;

    @ManyToOne
    @JoinColumn(name = "module_id", insertable = false, updatable = false)
    private UserModule userModule;

    @OneToMany(mappedBy = "module")
    private List<Subject> subject;

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


 */