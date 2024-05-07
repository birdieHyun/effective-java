package item13.clone;

public class SubItem extends Item implements Cloneable{

    private String name;

    @Override
    public SubItem clone() {
        return (SubItem) super.clone();
    }

    public static void main(String[] args) {
        SubItem item = new SubItem();
        SubItem clone = item.clone();

        System.out.println(clone != null);
        System.out.println(clone.getClass() == item.getClass());
        System.out.println(clone.equals(item));
    }
}
