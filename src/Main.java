import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;

public class Main {
    public static void main(String[] args) {
        // Create the drag and drop listener
        MyDragDropListener myDragDropListener = new MyDragDropListener();

        Label hi = new Label();
        Container mc = new Container();
        mc.add(hi);
        mc.setVisible(true);
        hi.setAlignment(Label.CENTER);
        hi.setText("Drag and drop you files here!");

        JFrame frame = new JFrame("Window");

        JButton button = new JButton("I am first");
        frame.getContentPane().add(hi);

        frame.pack();  //Realize the components.
        //This button will have the initial focus.
        button.requestFocusInWindow();
        frame.setVisible(true); //Display the window.


        // Connect the label with a drag and drop listener
        new DropTarget(frame, myDragDropListener);

    }
}