package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import delegate.CategoriesServiceDelegate;
import com.pidev.persistence.Sous_Categories;

public class Model extends AbstractTableModel {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String[] entete = {"id","Sous Categories","ID_Ca","Categories"};

		List <Sous_Categories> scs ;
		public Model ()
		{
			scs = CategoriesServiceDelegate.getAll(); 	
		}

		public int getRowCount() {
			// TODO Auto-generated method stub
			return scs.size();
		}


		public int getColumnCount() {
			// TODO Auto-generated method stub
			return entete.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex) {
	       case 0:
	          return scs.get(rowIndex).getId_Sc();
	       case 1:
	           return scs.get(rowIndex).getName();
	       case 2:
	           return scs.get(rowIndex).getCategories().getId_Ca();
	       case 3:
	           return scs.get(rowIndex).getCategories().getName();
	       
	       default:
	           throw new IllegalArgumentException();
			
		}
			
		}
	    public String getColumnName(int column) {
	        return entete[column];
	    }

}
