package com.hai.las.security.appuser;

import com.hai.las.data.entity.Admin;
import com.hai.las.data.entity.Lecturer;
import com.hai.las.data.entity.Student;
import com.hai.las.security.permission.ApplicationUserRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
public class MyUserDetails implements UserDetails {

    private int id;
    private String userName;
    private String name;
    private String password;
    private int status;
    private ApplicationUserRole userRole;

    public MyUserDetails(Student student) {
        this.userName = student.getEmail();
        this.name = student.getName();
        this.status = student.getStatus();
        this.userRole = ApplicationUserRole.STUDENT;
    }

    public MyUserDetails(Lecturer lecturer) {
        this.userName = lecturer.getEmail();
        this.name = lecturer.getName();
        this.status = lecturer.getStatus();
        this.userRole = ApplicationUserRole.LECTURER;
    }

    public MyUserDetails(Admin admin) {
        this.userName = admin.getUsername();
        this.name = admin.getName();
        this.status = 1;
        this.userRole = ApplicationUserRole.ADMIN;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRole.getGrantedAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status != 2;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status != 0;
    }
}
