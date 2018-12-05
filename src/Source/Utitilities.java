/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author cibervn
 */
public class Utitilities {

    /**
     *
     * @param component
     * @return top level container JFrame that contains component
     */
    public static JFrame findJFrameOf(Component component) {
        Container c = component.getParent();
        while (c.getParent() != null) {
            c = c.getParent();
        }
        if (c instanceof JFrame) {
            return (JFrame) c;
        }
        return null;
    }
}
