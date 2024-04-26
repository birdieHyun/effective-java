package item7;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * listner 예제
 */
public class ChatRoom {

    private List<WeakReference<User>> users; // 이건 올바른 방법이 아님

    public ChatRoom() {
        // 이런게 Strong Reference
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(new WeakReference<>(user));
    }

    public void sendMessage(String message) {
        users.forEach(wr -> Objects.requireNonNull(wr.get()).receive(message));
    }

    public List<WeakReference<User>> getUsers() {
        return users;
    }
}
