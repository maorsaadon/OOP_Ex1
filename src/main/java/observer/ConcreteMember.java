package observer;

public class ConcreteMember implements Member{
    private String str;

    public ConcreteMember(){
        this.str = null;
    }


    @Override
    public void update(UndoableStringBuilder usb) {

        str = usb.toString();
    }
}
