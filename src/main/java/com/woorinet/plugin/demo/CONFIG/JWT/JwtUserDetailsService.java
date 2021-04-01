package com.woorinet.plugin.demo.CONFIG.JWT;

import com.woorinet.plugin.demo.DTO.PORTAL.PortalMember;
import com.woorinet.plugin.demo.ROLE.PORTAL.PortalRole;
import com.woorinet.plugin.demo.Repository.PORTAL.PortalMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PortalMemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PortalMember portalMember = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(PortalRole.USER.getValue()));
        if (email.equals("sup2is@gmail.com")) {
            grantedAuthorities.add(new SimpleGrantedAuthority(PortalRole.ADMIN.getValue()));
        }

        return new User(portalMember.getEmail(), portalMember.getPassword(), grantedAuthorities);
    }

    public PortalMember authenticateByEmailAndPassword(String email, String password) {
        PortalMember portalMember = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        if(!passwordEncoder.matches(password, portalMember.getPassword())) {
            throw new BadCredentialsException("Password not matched");
        }

        return portalMember;
    }

}