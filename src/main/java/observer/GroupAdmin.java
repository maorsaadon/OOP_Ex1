package observer;

import java.util.HashSet;

public class GroupAdmin implements Sender{
    private HashSet<Member> observers;
    private UndoableStringBuilder usb;

    private String messege = "All observers have been updated";

    public GroupAdmin(){
        this.observers = new HashSet<>();
    }

    @Override
    public void register(Member obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Member obj) {
//        if(!observers.contains(obj)) throw new
        observers.remove(obj);

    }

    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset,obj);
        notify(observers);
    }

    @Override
    public void append(String obj) {
        usb.append(obj);
        notify(observers);

    }

    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
        notify(observers);
    }

    @Override
    public void undo() {
        usb.undo();
        notify(observers);
    }

    public void notify(HashSet<Member> observers){
        for (Member mem : observers) {
            mem.update(usb);
        }
        System.out.println(messege);
    }
}
