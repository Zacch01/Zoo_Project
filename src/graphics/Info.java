package graphics;

import animals.Animal;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Info extends AbstractTableModel {
    private ArrayList<Animal> data;
    public Info(ArrayList<Animal> data){this.data=data;}
    @Override
    public int getRowCount() { return data.size(); }
    @Override
    public int getColumnCount() { return 6; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = data.get(rowIndex);

        switch (columnIndex) {
            case 0: return animal.getClass().getSimpleName();
            case 1: return animal.getColor();
            case 2: return animal.getWeight();
            case 3: return animal.getHorSpeed();
            case 4: return animal.getVerSpeed();
            case 5: return animal.getEatCount();
        }

        return null;
    }

}
