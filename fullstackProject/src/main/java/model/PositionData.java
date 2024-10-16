package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//最高權限者--新增職位(建立下拉式選單選項)
@Entity
@Table(name="PositionData")
public class PositionData {
	@Id
	private Integer id;
	private String position_name;
	private String position_Code;
	private String createPositionTime;
	
	public PositionData() {
		super();
	}
	public PositionData(String position_name, String createPositionTime) {
		super();
		this.position_name = position_name;
		this.createPositionTime = createPositionTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getCreatePositionTime() {
		return createPositionTime;
	}
	public void setCreatePositionTime(String createPositionTime) {
		this.createPositionTime = createPositionTime;
	}
	public String getPosition_Code() {
		return position_Code;
	}
	public void setPosition_Code(String position_Code) {
		this.position_Code = position_Code;
	}
	
	
}
