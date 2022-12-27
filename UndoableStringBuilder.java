package observer;
import java.util.Stack;

/**
 * This class use the StringBuilder class methods to make our UndoableStringBuilder class
 * We crate methods using the methods that StringBuilder have
 * The idea of this class is to give us the latest thing that the object had
 * This UndoableStringBuilder class take a StringBuilder and give us the perv word or sentence that this StringBuilder had with using stack
 * @author Matan & Maor
 */

public class UndoableStringBuilder {
    private StringBuilder sb;
    private Stack<StringBuilder> stack;

    /**
     * The constructor take the objects and make new object (empty)
     */
    public UndoableStringBuilder() {
        this.sb = new StringBuilder();
        this.stack = new Stack<>();
    }

    /**
     * <p>
     * Push the current {@code StringBuilder} to {@code undoStack}. <br>
     * And appends the specified {@code String} to this  character sequence.<br>
     * If str is null, then the four characters "null" are appended.<br>
     * </p>
     * <p>
     * @param str The {@code String} to append
     * @return The {@code StringBuilder} that changed
     * </p>
     */
    public UndoableStringBuilder append(String str) {
        StringBuilder prev = new StringBuilder(sb);
        stack.push(prev);
        sb.append(str);
        return this;
    }

    /**
     * <p>
     * Push the current {@code StringBuilder} to {@code undoStack}. <br>
     * Removes the characters in a substring of this sequence. <br>
     * If start is equal to end, no changes are made. <br>
     * </p>
     * @param start The beginning index, inclusive.
     * @param end The ending index, exclusive.
     * @return The {@code StringBuilder} that changed.
     * @throws StringIndexOutOfBoundsException - if start is negative, greater than length(), or greater than end.
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            StringBuilder prev = new StringBuilder(sb);
            sb.delete(start, end);
            stack.push(prev);
        } catch (StringIndexOutOfBoundsException err) {
            System.err.println(err);
            err.printStackTrace();
        }
        finally {
            return this;
        }
    }

    /**
     * <p>
     * Push the current {@code StringBuilder} to {@code undoStack}. <br>
     * Inserts the string into this character sequence.<br>
     * If str is null, then the four characters "null" are inserted into this sequence.<br>
     * </p>
     * @param offset The offset.
     * @param str A string.
     * @return The {@code StringBuilder} that changed.
     * @throws StringIndexOutOfBoundsException - if the offset is invalid.
     */
    public UndoableStringBuilder insert(int offset, String str){
        try {
            StringBuilder prev = new StringBuilder(sb);
            sb.insert(offset, str);
            stack.push(prev);
        } catch (StringIndexOutOfBoundsException err) {
            System.err.println("your offset of:" + offset + " is out of bounds, the offset need to be: 0<=offset");
            err.printStackTrace();
        }
        finally {
            return this;
        }
    }

    /**
     *<p>
     * Push the current {@code StringBuilder} to {@code undoStack}. <br>
     * Replaces the characters in a substring of this sequence with characters in the specified String. <br>
     * The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists.<br>
     *</p>
     * @param start The beginning index, inclusive.
     * @param end The ending index, exclusive.
     * @param str String that will replace previous contents.
     * @return The {@code StringBuilder} that changed.
     * @throws StringIndexOutOfBoundsException - if start is negative, greater than length(), or greater than end.
     * @throws NullPointerException - if the input for String is 'null'.
     */

    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            StringBuilder prev = new StringBuilder(sb);
            sb.replace(start, end, str);
            stack.push(prev);
        } catch (StringIndexOutOfBoundsException err) {
            System.err.println("the index cant lower then 0");
        }
        catch(NullPointerException err){
            System.err.println("cant use null for replace method!");
            err.printStackTrace();
        }
        finally {
            return this;
        }

    }

    /**
     * <p>
     *  Push the current {@code StringBuilder} to {@code undoStack}. <br>
     *  Causes this character sequence to be replaced by the reverse of the sequence. <br>
     *  If there are any surrogate pairs included in the sequence, these are treated as single characters for the reverse operation. <br>
     *  Thus, the order of the high-low surrogates is never reversed. <br>
     * </p>
     *
     * @return The {@code StringBuilder} that changed.
     */
    public UndoableStringBuilder reverse() {
        StringBuilder reverseSB = new StringBuilder(sb);
        sb.reverse();
        stack.push(reverseSB);

        return this;
    }

    /**
     *<p>
     * Performs a return to the previous state by pop the previous {@code StringBuilder} from the {@code undoStack}.
     *</p>
     */
    public void undo() {
        if (stack.isEmpty()) return;
        sb = stack.pop();
    }

    /**
     * <p>
     * Returns a string representing the data in this sequence.
     * </p>
     * @return a string representation of this sequence of characters.
     */
    @Override
    public String toString() {
        return sb.toString();
    }

    /**
     *<p>
     * A boolean function that checks if two objects are equals.
     *</p>
     * @param o The comparing Object.
     * @return True or False.
     */
    @Override
    public boolean equals(Object o) {
        return sb.toString().equals(o);
    }

}