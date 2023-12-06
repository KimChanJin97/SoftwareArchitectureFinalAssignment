package Model.user;

import java.util.*;

public class UserRepository {

    private static Map<String, User> store = new HashMap<>();
    private static int sequence = 1;

    public User save(User user) {
        store.put(user.getInfo().getId(), user);
        return user;
    }

    public Optional<User> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(user -> user.getInfo().getId().equals(loginId))
                .findFirst();
    }

    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
