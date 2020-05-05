package com.entity;

public class Yonggongbumen {
    private Integer id;
	private String bumenzhanghao;	private String mima;	private String bumenmingcheng;	private String fuzeren;	private String lianxidianhua;	private String dizhi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBumenzhanghao() {
        return bumenzhanghao;
    }
    public void setBumenzhanghao(String bumenzhanghao) {
        this.bumenzhanghao = bumenzhanghao == null ? null : bumenzhanghao.trim();
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? null : mima.trim();
    }	public String getBumenmingcheng() {
        return bumenmingcheng;
    }
    public void setBumenmingcheng(String bumenmingcheng) {
        this.bumenmingcheng = bumenmingcheng == null ? null : bumenmingcheng.trim();
    }	public String getFuzeren() {
        return fuzeren;
    }
    public void setFuzeren(String fuzeren) {
        this.fuzeren = fuzeren == null ? null : fuzeren.trim();
    }	public String getLianxidianhua() {
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua == null ? null : lianxidianhua.trim();
    }	public String getDizhi() {
        return dizhi;
    }
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? null : dizhi.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
