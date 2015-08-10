package com.erp.entity;

@SuppressWarnings("serial")
public class BusTaskProductFlow implements java.io.Serializable {
    private long flowId;
    private int ppid;
    private String figureLib;
    private int artId;
    
	public int getArtId() {
		return artId;
	}
	public void setArtId(int artId) {
		this.artId = artId;
	}
	public String getFigureLib() {
		return figureLib;
	}
	public void setFigureLib(String figureLib) {
		this.figureLib = figureLib;
	}
	public BusTaskProductFlow() {
    }
    public long getFlowId() {
        return flowId;
    }
    public void setFlowId(long flowId) {
        this.flowId =flowId;
    }
    public int getPpid() {
        return ppid;
    }
    public void setPpid(int ppid) {
        this.ppid =ppid;
    }
}

