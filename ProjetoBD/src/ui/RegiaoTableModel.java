/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import database.Regiao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lenovo
 */
public class RegiaoTableModel extends AbstractTableModel  {
    private static final int NAME_COL = 0;
    //private static final int FIRST_NAME_COL = 1;
    //private static final int EMAIL_COL = 2;
    //private static final int SALARY_COL = 3;

    private String[] columnNames = {"NOME"};
    private List<Regiao> regioes;

    public RegiaoTableModel(List<Regiao> theEmployees) {
            regioes = theEmployees;
    }

    @Override
    public int getColumnCount() {
            return columnNames.length;
    }

    @Override
    public int getRowCount() {
            return regioes.size();
    }

    @Override
    public String getColumnName(int col) {
            return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

            Regiao tempEmployee = regioes.get(row);

            switch (col) {
            case NAME_COL:
                    return tempEmployee.getNome();
            /*case FIRST_NAME_COL:
                    return tempEmployee.getFirstName();
            case EMAIL_COL:
                    return tempEmployee.getEmail();
            case SALARY_COL:
                    return tempEmployee.getSalary();*/
            default:
                    return tempEmployee.getNome();
            }
    }

    @Override
    public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
    }

}
