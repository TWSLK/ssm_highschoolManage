package com.entity;

public class Banjixinxi {
    private Integer id;
	private String banji;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBanji() {
        return banji;
    }
    public void setBanji(String banji) {
        this.banji = banji == null ? null : banji.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
