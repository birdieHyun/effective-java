package item8.finalizer;

import java.math.BigDecimal;

public class Account { // class에 final 을 붙이면 상속이 안되기 때문에

    private String accountId;

    public Account(String accountId) {
        this.accountId = accountId;

        if (accountId.equals("푸틴")) {
            throw new IllegalArgumentException("푸틴은 허용되지 않습니다.");
        }
    }

    public void transfer(BigDecimal amount, String to) {
        System.out.println("Transfer " + amount + " from " + accountId + " to " + to);
    }

//    @Override
//    protected final void finalize() throws Throwable { // 이렇게 되면 오버라이딩이 허용되지 않게 된다.
//    }
}
