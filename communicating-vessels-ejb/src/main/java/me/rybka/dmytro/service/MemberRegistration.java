package me.rybka.dmytro.service;

import me.rybka.dmytro.model.Member;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Logic for member registration.
 *
 */
@Stateless
public class MemberRegistration {

   @Inject
   private Logger log;

   @Inject
   private EntityManager em;

   @Inject
   private Event<Member> memberEventSrc;

   public void register(Member member) {
      log.info("Registering " + member.getName());
      em.persist(member);
      memberEventSrc.fire(member);
   }
}
