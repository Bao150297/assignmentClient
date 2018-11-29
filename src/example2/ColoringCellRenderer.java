/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author noobf
 */
public class ColoringCellRenderer extends DefaultTableCellRenderer{
    private final Map<Point, Color> cellColors = new HashMap<Point, Color>();

    void setCellColor(int r, int c, Color color)
    {
        if (color == null)
        {
            cellColors.remove(new Point(r,c));
        }
        else
        {
            cellColors.put(new Point(r,c), color);
        }
    }

    private Color getCellColor(int r, int c)
    {
        Color color = cellColors.get(new Point(r,c));
        if (color == null)
        {
            return Color.WHITE;
        }
        return color;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column)
    {
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        super.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column);
        Color color = getCellColor(row, column);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(color);
        return this;
    }
}
