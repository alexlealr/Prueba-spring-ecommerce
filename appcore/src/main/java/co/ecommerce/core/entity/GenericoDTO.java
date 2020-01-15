package co.ecommerce.core.entity;

import java.util.ArrayList;
import java.util.List;

public class GenericoDTO {

	private Long total;
    // Lista de multiples objetos para transacciones
    private List<Object> lstObjectsDTO;
    /**
     * Constructor de la vacio clase
     */
    public GenericoDTO() {
        super();
        lstObjectsDTO = new ArrayList<>();
    }
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<Object> getLstObjectsDTO() {
		return lstObjectsDTO;
	}
	public void setLstObjectsDTO(List<Object> lstObjectsDTO) {
		this.lstObjectsDTO = lstObjectsDTO;
	}

    
}
