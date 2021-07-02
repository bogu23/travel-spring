package bogu.sda.travel.service;

import bogu.sda.travel.entity.UserModel;
import bogu.sda.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Optional<UserModel> userModelOptional = userRepository.findByUsername(currentPrincipalName);
        if(userModelOptional.isEmpty()) {
            throw new RuntimeException("No user found!");
        }

        UserModel user = userModelOptional.get();
        return user;
    }

    public void addUser(UserModel userModel) {
        String password = userModel.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        userModel.setRole("ROLE_USER");
        userModel.setPassword(encodedPassword);

        userRepository.save(userModel);
    }


}
