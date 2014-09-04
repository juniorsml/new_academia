/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consulti.academics.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Valter
 */
@Entity
public class Musculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeMusculo;
    private String descricaoMusculo;
    @ManyToOne
    private GrupoMuscular grupo;
    @OneToMany(mappedBy = "musculo")
    private List<Video> videos;

    public GrupoMuscular getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoMuscular grupo) {
        this.grupo = grupo;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public String getNomeMusculo() {
        return nomeMusculo;
    }

    public void setNomeMusculo(String nomeMusculo) {
        this.nomeMusculo = nomeMusculo;
    }

    public String getDescricaoMusculo() {
        return descricaoMusculo;
    }

    public void setDescricaoMusculo(String descricaoMusculo) {
        this.descricaoMusculo = descricaoMusculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musculo)) {
            return false;
        }
        Musculo other = (Musculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.consulti.academics.model.Musculo[ id=" + id + " ]";
    }
}
