package com.assignment.favourite.recipes.dto;

public class RoleDTO {

	private Long roleId;
	private String role;
	
	public RoleDTO(Long roleId, String role) {
		this.roleId = roleId;
		this.role = role;
	}

	public RoleDTO() {
		
	}
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
