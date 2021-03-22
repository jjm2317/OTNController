package com.woorinet.plugin.demo.Repository.PORTAL;

import com.woorinet.plugin.demo.DTO.PORTAL.PortalMember;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PortalMemberRepository extends CrudRepository<PortalMember, Long> {
    Optional<PortalMember> findByEmail(String email);
}