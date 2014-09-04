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
public class GrupoMuscular implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeGrupo;
    private String descricaoGrupo;
    @OneToMany(mappedBy = "grupo")
    private List<Musculo> musculos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getDescricaoGrupo() {
        return descricaoGrupo;
    }

    public void setDescricaoGrupo(String descricaoGrupo) {
        this.descricaoGrupo = descricaoGrupo;
    }

    public List<Musculo> getMusculos() {
        return musculos;
    }

    public void setMusculos(List<Musculo> musculos) {
        this.musculos = musculos;
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
        if (!(object instanceof GrupoMuscular)) {
            return false;
        }
        GrupoMuscular other = (GrupoMuscular) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.consulti.academics.model.GrupoMuscular[ id=" + id + " ]";
    }
}
