/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.klaphat.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author IEUser
 */
@Entity
//@NamedQueries({@NamedQuery(name = "Member.all", query="SELECT e FROM Member e"), @NamedQuery(name = "Member.memberById", query="SELECT e FROM Member e WHERE e.id = :id"), @NamedQuery(name="Member.memberByName", query="SELECT e FROM Member e WHERE e.name LIKE :name")})  //, @NamedQuery(name = "Member.memberById", query="SELECT e FROM Member e WHERE e.id LIKE :id")
@NamedQueries({@NamedQuery(name = "MorgenmadGruppe.all", query="SELECT e FROM MorgenmadGruppe e")})//, @NamedQuery(name = "MorgenmadGruppe.MorgenmadGruppeById", query="SELECT e FROM MorgenmadGruppe e WHERE e.id = :id"), @NamedQuery(name="MorgenmadGruppe.MorgenmadGruppeByName", query="SELECT e FROM MorgenmadGruppe e WHERE e.gruppenavn LIKE :gruppenavn")})  //, @NamedQuery(name = "Member.memberById", query="SELECT e FROM Member e WHERE e.id LIKE :id")
public class MorgenmadGruppe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String gruppeNavn;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        if (!(object instanceof MorgenmadGruppe)) {
            return false;
        }
        MorgenmadGruppe other = (MorgenmadGruppe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.klaphat.entity.MorgenmadGruppe[ id=" + id + " ]";
    }

    public String getGruppeNavn() {
        return gruppeNavn;
    }

    public void setGruppeNavn(String gruppeNavn) {
        this.gruppeNavn = gruppeNavn;
    }
    
}
