package item1.staticfactorymethod.helloservice.disadvantage;

/**
 * 이 클래스의 인스턴스는 #getInstance() 메서드를 통해서만 생성할 수 있다.
 * @see #getInstance()
 */
public class Setting {

    private boolean useAutoSteering;
    private boolean useABS;
    private Difficulty difficulty;
    private Setting() {}

 private static final Setting DEFAULT = new Setting();

    public static Setting getInstance() {
        return DEFAULT;
    }
}

/**
 * 정적 팩터리 메서드만 사용하게 할 경우, private 생성자를 만들게 된다.
 * 이렇게 되면 하위 클래스를 만들 수 없게 된다.(상속 불가)
 */