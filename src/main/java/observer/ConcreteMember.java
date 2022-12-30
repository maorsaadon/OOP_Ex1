package observer;

/**
 * <p>
 * This class actualize the functions of the Member that describe the Observer, and we also have function to getData().<br>
 * ConcreteMember contains String that update every time the GroupAdmin notify about a change
 * in other word it's a copy (copy sallow) of the UndoableStringBuilder.<br>
 * </p>
 * @author Matan & Maor
 */
public class ConcreteMember implements Member {
    public UndoableStringBuilder usb;

    /**
     * <p>
     * The constructor take the objects and make new object (empty).<br>
     * </p>
     */
    public ConcreteMember() {
        this.usb = null;
    }

    /**
     * <p>
     * Update the UndoableStringBuilder that ConcreteMember hold according to
     * change of the UndoableStringBuilder of the GroupAdmin.<br>
     * </p>
     * @param usb The UndoableStringBuilder that had been change.
     */
    @Override
    public void update(UndoableStringBuilder usb) {

        this.usb = usb;
    }


    /**
     * <p>
     * Get the data of the member.<br>
     * </p>
     * @return {@code UndoableStringBuilder } that ConcreteMember hold.
     */
    public String getData() {
        return usb.toString();
    }

}


