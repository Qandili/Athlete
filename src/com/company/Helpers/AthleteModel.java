package com.company.Helpers;

import com.company.Athlete;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class AthleteModel extends AbstractTableModel {
        public String[] m_colNames = { "firstName", "lastName", "sport","age","taille", "poids" };

        public Class[] m_colTypes = { String.class, String.class, String.class, Integer.class,double.class,double.class,
                 };

        Vector<Athlete> m_macDataVector;

        public AthleteModel(Vector macDataVector) {
            super();
            m_macDataVector = macDataVector;
        }

        public void removeElement(int index){
            m_macDataVector.removeElementAt(index);
        }
        public Boolean editElement(Athlete a,int index){
            if (m_macDataVector.isEmpty()){
                return null;
            }
            Athlete athlete=m_macDataVector.get(index);
            athlete.setAge(a.getAge());
            athlete.setFirstName(a.getFirstName());
            athlete.setLastName(a.getLastName());
            athlete.setSport(a.getSport());

            athlete.setPoids(a.getPoids());
            athlete.setTaille(a.getTaille());
            return true;

        }
        public int getColumnCount() {
            return m_colNames.length;
        }
        public int getRowCount() {
            return m_macDataVector.size();
        }
        public void setValueAt(Object value, int row, int col) {
            Athlete macData = (Athlete) (m_macDataVector.elementAt(row));

            switch (col) {
                case 0:
                    macData.setFirstName((String) value);
                    break;
                case 1:
                    macData.setLastName((String) value);
                    break;
                case 2:
                    macData.setSport((String) value);
                    break;
                case 3:
                    macData.setAge((int) value);
                    break;
                case 4:
                    macData.setTaille((double) value);
                    break;
                case 5:
                    macData.setPoids((double) value);

            }
        }

        public String getColumnName(int col) {
            return m_colNames[col];
        }

        public Class getColumnClass(int col) {
            return m_colTypes[col];
        }
        public Object getValueAt(int row, int col) {
            Athlete macData = (Athlete) (m_macDataVector.elementAt(row));

            switch (col) {
                case 0:
                    return macData.getFirstName();
                case 1:
                    return macData.getLastName();
                case 2:
                    return macData.getSport();
                case 3:
                    return macData.getAge();
                case 4:
                    return macData.getTaille();
                case 5:
                    return macData.getPoids();

            }

            return new String();
        }
    }



