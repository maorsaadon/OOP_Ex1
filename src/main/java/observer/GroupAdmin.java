package observer;
import java.util.HashSet;

/**
 * <p>
 * This class is the Observerbale in this design template.<br>
 * This class actualize the functions of the Sender, and we also have function that notify the observers.<br>
 * GroupAdmin contains the state pool (UndoableStringBuilder) and also contains an HashSet that holds all
 * customers who should receive updates on any changes made to the state pool, the class has a constructor
 * that builds a GroupAdmin from UndoableStringBuilder and HashSet<Member>.<br>
 * </p>
 * @author Matan & Maor
 */
public class GroupAdmin implements Sender{
    public HashSet<Member> members;
    public UndoableStringBuilder usb;

    public int counter;

    /**
     * <p>
     * The constructor take the objects and make new object (empty).<br>
     * </p>
     */
    public GroupAdmin(){
        this.members = new HashSet<>();
        this.usb = new UndoableStringBuilder();
    }

    /**
     * <p>
     * Add the Member to the GroupAdmin.<br>
     * </p>
     * @param obj The Member that need to be added to the GroupAdmin.
     */
    @Override
    public void register(Member obj) {
        if(members.contains(obj)){
           System.err.println("This Member already register to a GroupAdmin");
        }
        else {
            members.add(obj);
            counter++;
            notifyMember();
            System.out.println("The member has been register...");
        }

    }

    /**
     * <p>
     * Remove the Member to the GroupAdmin.<br>
     * </p>
     * @param obj The Member that need to be removed from the GroupAdmin
     */
    @Override
    public void unregister(Member obj) {
            if(members.contains(obj)){
                members.remove(obj);
                counter--;
                System.out.println("The Member has been removed from this GroupAdmin...");
            }
            else System.err.println("The Member is not in this GroupAdmin");
    }

    /**
     * <p>
     * Inserts the string into this character sequence.<br>
     * </p>
     * @param offset The offset.
     * @param obj A string.
     *@throws StringIndexOutOfBoundsException - if the offset is invalid.
     */
    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset,obj);
        notifyMember();
    }

    /**
     * <p>
     * And appends the specified {@code String} to this  character sequence.<br>
     * </p>
     * @param obj The {@code String} to append.
     */
    @Override
    public void append(String obj) {
        usb.append(obj);
        notifyMember();
    }

    /**
     * <p>
     * Removes the characters in a substring of this sequence.<br>
     * If start is equal to end, no changes are made. <br>
     * </p>
     * @param start The beginning index, inclusive.
     * @param end The ending index, exclusive.
     * @throws StringIndexOutOfBoundsException - if start is negative, greater than length(), or greater than end.
     */
    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
        notifyMember();
    }

    /**
     *<p>
     * Performs a return to the previous state.<br>
     *</p>
     */
    @Override
    public void undo() {
        usb.undo();
        notifyMember();
    }

    /**
     * <p>
     * Notify all the member about every change that has been made to the UndoableStringBuilder.<br>
     * </p>
     */
    public void notifyMember() {
        for (Member member : members) {
            member.update(usb);
        }
    }

    public int getSizeMember(){
        return counter;
    }

}
