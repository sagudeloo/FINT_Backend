/*package com.example.fintbackend.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer idSubject;

    @Column(name = "subject_title")
    private String subjectTitle;

    @Column(name = "subject_progress")
    private Integer subjectProgress;

    @ManyToOne
    @JoinColumn(name = "module_id", insertable = false, updatable = false)
    private Module module;

    @OneToMany(mappedBy = "subject")
    private List<Content> content;

    public Integer getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public Integer getSubjectProgress() {
        return subjectProgress;
    }

    public void setSubjectProgress(Integer subjectProgress) {
        this.subjectProgress = subjectProgress;
    }
}

 */
