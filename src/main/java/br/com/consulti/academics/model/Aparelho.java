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
import javax.persistence.OneToMany;

/**
 *
 * @author Valter
 */
@Entity
public class Aparelho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeAparelho;
    private String descricaoAparelho;
    @OneToMany(mappedBy = "aparelho")
    private List<Video> videos;

    public String getNomeAparelho() {
        return nomeAparelho;
    }

    public void setNomeAparelho(String nomeAparelho) {
        this.nomeAparelho = nomeAparelho;
    }

    public String getDescricaoAparelho() {
        return descricaoAparelho;
    }

    public void setDescricaoAparelho(String descricaoAparelho) {
        this.descricaoAparelho = descricaoAparelho;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
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
        if (!(object instanceof Aparelho)) {
            return false;
        }
        Aparelho other = (Aparelho) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.consulti.academics.model.Aparelho[ id=" + id + " ]";
    }
    
}
