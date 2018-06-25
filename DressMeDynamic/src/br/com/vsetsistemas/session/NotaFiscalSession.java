package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.NotaFiscalDAO;
import br.com.vsetsistemas.model.NotaFiscal;

public class NotaFiscalSession {

	private NotaFiscalDAO dao = new NotaFiscalDAO();
		
		public List<NotaFiscal> listAll(){
			
			List<NotaFiscal> lista = new ArrayList<>();
			
			try {
				
				lista = dao.select();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return lista;
	}
	
}
