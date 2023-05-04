package com.example.fintbackend.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "multimedia")
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "multimedia_id")
    private Integer idMultimedia;

    @Column(name = "multimedia_title")
    private Integer multimediaTitle;

    @Lob
    @Column(name = "multimedia_content")
    private byte[] multimediaContent;

    private Integer length;

    @ManyToOne
    @JoinColumn(name = "content_id", insertable = false, updatable = false)
    private Content content;

    public Integer getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public Integer getMultimediaTitle() {
        return multimediaTitle;
    }

    public void setMultimediaTitle(Integer multimediaTitle) {
        this.multimediaTitle = multimediaTitle;
    }

    public byte[] getMultimediaContent() {
        return multimediaContent;
    }

    public void setMultimediaContent(byte[] multimediaContent) {
        this.multimediaContent = multimediaContent;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
