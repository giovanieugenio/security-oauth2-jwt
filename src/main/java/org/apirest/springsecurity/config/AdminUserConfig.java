package org.apirest.springsecurity.config;

import org.apirest.springsecurity.entities.Role;
import org.apirest.springsecurity.entities.User;
import org.apirest.springsecurity.repository.RoleRepository;
import org.apirest.springsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminUserConfig(RoleRepository roleRepository,
                           UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder){
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());
        var userAdmin = userRepository.findByUsername("ADMIN");
        userAdmin.ifPresentOrElse(
                user -> System.out.println("admin already exists"),
                ()-> {
                    var user = new User();
                    user.setUsername("ADMIN");
                    user.setPassword(bCryptPasswordEncoder.encode("101"));
                    user.setRoles(Set.of(roleAdmin));
                    userRepository.save(user);
                }
        );
    }
}
