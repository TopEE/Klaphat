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
import javax.ws.rs.PathParam;

/**
 *
 * @author IEUser
 */
@Stateless
@Path("member")

public class MemberResource {
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
        Member m4 = new Member();
        m4.setName("LAJ");
    
                
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
    
    
  
    @GET
    @Path("id/{id}")
    public Member getMemberById(@PathParam("id") String idStr) {
       try {
            long id = Long.parseLong(idStr);
            Query q = em.createNamedQuery("Member.memberById");
            q.setParameter("id", id);           
            List<Member> list = q.getResultList();
            if(list.size() > 0) {               
                return list.get(0);
            }
           
       } catch(Exception e) {
           e.printStackTrace();
       }
       
       //return (Member) q.setParameter("id", id).getSingleResult();
       return null;
    }
    
    @GET
    @Path("name/{name}")
    public Member getMemberByName(@PathParam("name") String name) {
        Query q = em.createNamedQuery("Member.memberByName");
        q.setParameter("name", name);
        List<Member> list = q.getResultList();
        if(list.size()> 0) {
            return list.get(0);
        }
        
        return null;
    }
 
}
