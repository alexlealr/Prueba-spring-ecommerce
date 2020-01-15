package co.ecommerce.web.entity;

import java.util.List;
import java.util.ArrayList;

public class GenericDTO {
	
	private Long total;
    // Lista de multiples objetos para transacciones
    private List<Object> lstObjectsDTO;
    /**
     * Constructor de la vacio clase
     */
    public GenericDTO() {
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
