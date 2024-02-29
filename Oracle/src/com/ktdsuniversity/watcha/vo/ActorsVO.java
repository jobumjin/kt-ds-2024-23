package com.ktdsuniversity.watcha.vo;

import java.util.List;

public class ActorsVO {
	
	private String actorId;
	private String profle;
	private String name;
	
	private List<CastsVO> casts;
	
	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	public String getProfle() {
		return profle;
	}
	public void setProfle(String profle) {
		this.profle = profle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CastsVO> getCasts() {
		return casts;
	}
	public void setCasts(List<CastsVO> casts) {
		this.casts = casts;
	}
	
	
}
