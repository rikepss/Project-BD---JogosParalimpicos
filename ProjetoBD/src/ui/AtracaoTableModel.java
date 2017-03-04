/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import database.Atracao;
import database.Regiao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lenovo
 */
public class AtracaoTableModel extends AbstractTableModel  {
    private String[] columnNames = {"Atracao", "Endereco"};
    private List<Atracao> atracoes;

    public AtracaoTableModel(List<Atracao> theEmployees) {
            atracoes = theEmployees;
    }

    @Override
    public int getColumnCount() {
            return columnNames.length;
    }

    @Override
    public int getRowCount() {
            return atracoes.size();
    }

    @Override
    public String getColumnName(int col) {
            return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

            Atracao tempEmployee = atracoes.get(row);

            switch (col) {
            case 0:
                    return tempEmployee.getNome();
            case 1:
                    return tempEmployee.getEndereco();
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
