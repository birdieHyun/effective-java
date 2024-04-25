package item6;

public class Deprecation {

    private String name;

    /**
     * @deprecated
     */
    @Deprecated(since = "1.0", forRemoval = true)
    // 여기까지만 하면 뭐로 대체됐는지 알려줄 수 없음
    public Deprecation() {
    }

    public Deprecation(String name) {
        this.name = name;
    }
}
