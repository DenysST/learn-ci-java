package com.ds.forlearnci.services;

import com.ds.forlearnci.models.User;
import com.ds.forlearnci.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;
    public List<User> getUsers() {
        return repository.findAll();
    }

    public User createUser(User user) {
        user.setNickName(generateNickname(user));
        return repository.save(user);
    }

    private String generateNickname(User user) {
        List<String> nickNames = List.of("Bubbles",
                "Squiggles",
                "FuzzyWuzzy",
                "Snickerdoodle",
                "Fluffernutter",
                "Wobblebottom",
                "Noodlehead",
                "TwinkleToes",
                "Gigglesnort",
                "Dingleberry");

        int indexNumber = (user.getFirstName().toCharArray()[0]) % nickNames.size();
        return nickNames.get(indexNumber);
    }

//    private void testMethod() {
//        ArrayList<Object> objects = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            objects.add(i);
//        }
//    }
}
