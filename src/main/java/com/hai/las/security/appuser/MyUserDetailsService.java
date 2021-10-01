package com.hai.las.security.appuser;


import com.hai.las.data.entity.Admin;
import com.hai.las.data.entity.Lecturer;
import com.hai.las.data.entity.Student;
import com.hai.las.data.repository.AdminRepository;
import com.hai.las.data.repository.LecturerRepository;
import com.hai.las.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final LecturerRepository lecturerRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public MyUserDetailsService(StudentRepository studentRepository, LecturerRepository lecturerRepository, AdminRepository adminRepository) {
        this.studentRepository = studentRepository;
        this.lecturerRepository = lecturerRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> student = studentRepository.findStudentByEmail(username);
        Optional<Lecturer> lecturer = lecturerRepository.findLecturerByEmail(username);
        Optional<Admin> admin = adminRepository.findAdminByUsername(username);

        if(student.isPresent()) {
            return student.map(MyUserDetails::new).get();
        }
        else if(lecturer.isPresent()) {
            return lecturer.map(MyUserDetails::new).get();
        }
        else if(admin.isPresent()) {
            return admin.map(MyUserDetails::new).get();
        }else {
            throw new UsernameNotFoundException(String.format("%s not found", username));
        }
    }
}
