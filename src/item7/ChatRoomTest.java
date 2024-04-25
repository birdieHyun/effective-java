package item7;

import java.lang.ref.WeakReference;
import java.util.List;

public class ChatRoomTest {

    public static void main(String[] args) throws InterruptedException {
        ChatRoom chatRoom = new ChatRoom();
        User user1 = new User();
        User user2 = new User();

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);

        chatRoom.sendMessage("Hello");

        user1 = null;

        System.gc();
        Thread.sleep(5000L);

        List<WeakReference<User>> users = chatRoom.getUsers();
        System.out.println(users.size());
    }
}
