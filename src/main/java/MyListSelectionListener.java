import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyListSelectionListener implements ListSelectionListener {
    public boolean value = false;
    @Override
    public void valueChanged(ListSelectionEvent e) {

        setValue(true);
    }

    public void setValue(boolean tf) {
        value = tf;
    }

    public boolean getValue() {
        return value;
    }
}
