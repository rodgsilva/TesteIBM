package br.com.testeibm.domain.enums;

public enum Perfil {
	
	ADMIN(1,"ROLE_ADMIN"),
	PACIENTE(2,"ROLE_PACIENTE");
		
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descrica) {
		this.cod=cod;
		this.descricao=descrica;			
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum (Integer cod) {
		if(cod==null) {
			
			return null;
		}
		
		for (Perfil x :Perfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
				
			}
		}
		throw new IllegalArgumentException("id invalido: "+cod);
			
	}
	

}
