package com.maven.jee;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.google.common.util.concurrent.ExecutionError;

public class CrewDAO {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    public List<CrewMember> getAllCrew(){
    try {
        userTransaction.begin();
        List<CrewMember> crewMembers = entityManager.createQuery(" SELECT crewMember  FROM CrewMember crewMember", CrewMember.class)
        .getResultList();
        userTransaction.commit();

        return crewMembers;
    }
    catch (Exception e){
        return null;
    }  
}

public CrewMember getOne(String name){
  
        
        var crewMember = entityManager.createQuery(" SELECT crewMember  FROM CrewMember crewMember WHERE crewMember.name=?1", CrewMember.class)
        .setParameter(1, name)
        .getSingleResult();
       
        return crewMember;
  
}


public void insertCrew(CrewMember crewMember){
    try {
        userTransaction.begin();
        entityManager.persist(crewMember);
        userTransaction.commit();
    }
    catch (Exception e){
        return ;
    } 

}
public boolean deleteMember(Integer id){
    try {
    int results = entityManager.createQuery("DELETE FROM CrewMember crewMember WHERE crewMember.id=:id")
    .setParameter("id", id).executeUpdate();
    return results>0;
}
catch(Exception e) {
return false;
}
}
}
