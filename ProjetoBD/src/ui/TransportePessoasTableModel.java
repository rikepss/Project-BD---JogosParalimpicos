/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import database.Transporte_Pessoa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lenovo
 */
public class TransportePessoasTableModel extends AbstractTableModel{


    private String[] columnNames = {"Centro de Pratica", "Endereco", "Membro"};
    private List<Transporte_Pessoa> tp;

    public TransportePessoasTableModel(List<Transporte_Pessoa> theEmployees) {
            tp = theEmployees;
    }

    @Override
    public int getColumnCount() {
            return columnNames.length;
    }

    @Override
    public int getRowCount() {
            return tp.size();
    }

    @Override
    public String getColumnName(int col) {
            return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

            Transporte_Pessoa tempEmployee = tp.get(row);

            switch (col) {
            case 0:
                    return tempEmployee.getCentroDePratica().getNome();
            case 1:
                    return tempEmployee.getCentroDePratica().getEndereco();
            case 2:
                    return tempEmployee.getMembros();
            default:
                    return tempEmployee.getVeiculos();     
            }
    }

    @Override
    public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
    }
}
