package presentacion.adaptadores;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import beans.Contacto;

public class AdaptadorCombo<Contacto> implements ComboBoxModel<Contacto> {
	
	List<Contacto> contactos;
	Contacto seleccion; //guarda el contacto seleccionado en cada momento
	
	public AdaptadorCombo(List<Contacto> contactos){
		this.contactos=contactos;
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contacto getElementAt(int pos) {
		return contactos.get(pos);
	}

	@Override
	public int getSize() {
		return contactos.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getSelectedItem() {
		return seleccion;
	}

	@Override
	public void setSelectedItem(Object arg0) {
		seleccion=(Contacto)arg0;
		
	}

}
