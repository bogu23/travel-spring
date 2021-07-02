package bogu.sda.travel;

import bogu.sda.travel.entity.UserModel;
import bogu.sda.travel.repository.UserRepository;
import bogu.sda.travel.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testAdd() {
        UserModel userModel = new UserModel();
        userModel.setUsername("cbogu");
        userModel.setRole("user");
        userModel.setPassword("bogu");

        userService.addUser(userModel);

        verify(userRepository, times(1)).save(userModel);
    }
}
