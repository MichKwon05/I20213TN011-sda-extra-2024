package mx.edu.utez.extra.services;

import mx.edu.utez.extra.models.User;
import mx.edu.utez.extra.models.UserRepository;
import mx.edu.utez.extra.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public CustomResponse<List<User>> getAll(){
        return new CustomResponse<>(
                this.userRepository.findAll(),
                false,
                200,
                "Green light"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<User> getById(Long id){
        return new CustomResponse<>(
                this.userRepository.getById(id),
                false,
                200,
                "Green light"
        );
    }


    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<User> save(User user){
        return new CustomResponse<>(
                this.userRepository.saveAndFlush(user),
                false,
                200,
                "Green light"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<User>> getUsersOver18() {
        LocalDate eighteenYearsAgo = LocalDate.now().minusYears(18);
        List<User> usersOver18 = userRepository.findByBirthdayBefore(eighteenYearsAgo);

        return new CustomResponse<>(
                usersOver18,
                false,
                200,
                "Users con 18 años "
        );
    }


}
