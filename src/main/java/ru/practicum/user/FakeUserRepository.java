package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeUserRepository implements UserRepository {
    private static final List<User> FAKE_USERS = createManyFakeUsers(3);

    private static List<User> createManyFakeUsers(int count) {
        List<User> fakeUsers = new ArrayList<>();
        for (long id = 1; id <= count; id++) {
            fakeUsers.add(createFakeUser(id));
        }
        return fakeUsers;
    }

    private static User createFakeUser(long id) {
        User fakeUser = new User();
        fakeUser.setId(id);
        fakeUser.setEmail("fakeUser" + id + "@example.com");
        fakeUser.setName("Akakiy Akakievich #" + id);
        return fakeUser;
    }

    @Override
    public List<User> findAll() {
        return FAKE_USERS;
    }

    @Override
    public User save(User user) {
        throw new UnsupportedOperationException("Save() method not completed.");
    }
}
