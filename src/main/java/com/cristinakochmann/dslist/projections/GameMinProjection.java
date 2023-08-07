package com.cristinakochmann.dslist.projections;

public interface GameMinProjection {
	
	//métodos getters correspondentes a consulta lá em repositories, gameRepository, no caso
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
}
