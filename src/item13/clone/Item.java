package item13.clone;

public class Item implements Cloneable {

    private String name;

//    /**
//     * 이렇게 구현하면 하위 클래스의 clone()이 꺠질 수 있다.
//     * @return
//     */
//    @Override
//    public Item clone() {
//        Item item = new Item();
//        item.name = this.name;
//        return item;
//    }


    @Override
    protected Item clone() {
        Item result = null;

        try{
            result = (Item) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
