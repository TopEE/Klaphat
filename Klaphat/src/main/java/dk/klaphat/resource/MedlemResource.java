/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.klaphat.resource;

import dk.klaphat.entity.Member;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author IEUser
 */
@Stateless
@Path("member")

public class MedlemResource {
    @PersistenceContext(name="default")
    EntityManager em;
    
    @GET
    @Path("init")
    public String init() {        
        Member m1 = new Member();
        m1.setName("KIT");
        Member m2 = new Member();
        m2.setName("ACG");
        Member m3 = new Member();
        m3.setName("EKY");
                
        em.merge(m1);
        em.merge(m2);
        em.merge(m3);
        return "done init";
    }
    
    @GET
    @Path("/")
    public List<Member> getMembers() {
        Query q = em.createNamedQuery("Member.all");
        return q.getResultList();
    }
}
