package item8.finalizer;

public class FinalizeIsBad {

    // 9 버전부터 없어졌고, removal == ture

    @Override
    protected void finalize() throws Throwable {
        System.out.println("");
    }
}
