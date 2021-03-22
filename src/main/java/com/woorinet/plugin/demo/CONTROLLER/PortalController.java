package com.woorinet.plugin.demo.CONTROLLER;

import com.woorinet.plugin.demo.DTO.PORTAL.PortalMember;
import com.woorinet.plugin.demo.Repository.PORTAL.PortalMemberRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PortalController {

    final PortalMemberRepository memberRepository;
    final PasswordEncoder encode;

    @PostMapping("/api/member")
    public String saveMember(@RequestBody MemberDto memberDto) {
        memberRepository.save(PortalMember.createMember(memberDto.getEmail(), encode.encode(memberDto.getPassword())));
        return "success";
    }

}

@Data
class MemberDto {
    private String email;
    private String password;
}