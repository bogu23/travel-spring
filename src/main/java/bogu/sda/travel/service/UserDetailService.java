package bogu.sda.travel.service;

import bogu.sda.travel.entity.UserModel;
import bogu.sda.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserModel> userOptional = userRepository.findByUsername(username);
        UserModel userModel = userOptional.get();

        String name = userModel.getUsername();
        String encodedPassword = userModel.getPassword();
        String role = userModel.getRole();

        //Datele din baza de date care corespund userului cu username ul dat ca si parametru
        UserDetails userDetails = new User(name, encodedPassword, Collections.singletonList(new SimpleGrantedAuthority(role)));

        return userDetails;
    }


}
