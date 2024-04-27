package item8.finalizer;

import java.math.BigDecimal;

public class BrokenAccount extends Account{

    public BrokenAccount(String accountId) {
        super(accountId);
    }

    @Override
    protected void finalize() throws Throwable {
        this.transfer(new BigDecimal(100), "donghyun");
    }
}
