package com.hai.las.security.permission;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(ApplicationUserAuthority.STUDENT_READ, ApplicationUserAuthority.STUDENT_WRITE)),
    LECTURER(Sets.newHashSet(ApplicationUserAuthority.LECTURER_READ, ApplicationUserAuthority.LECTURER_WRITE)),
    ADMIN(Sets.newHashSet(ApplicationUserAuthority.STUDENT_READ, ApplicationUserAuthority.STUDENT_WRITE, ApplicationUserAuthority.LECTURER_READ, ApplicationUserAuthority.LECTURER_WRITE));

    private final Set<ApplicationUserAuthority> authorities;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = getAuthorities().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getAuthority()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
