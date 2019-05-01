package com.shyam.clickstream;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Click {
	@JsonProperty
	private String sellerId;
	@JsonProperty
	private Long itemId;
	@JsonProperty
	private String buyerId;
	@JsonProperty
	private Date timestamp;
	@JsonProperty
	private String device;
	@JsonProperty
	private String srcPage;
	@JsonProperty
	private String dstPage;

	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getSrcPage() {
		return srcPage;
	}
	public void setSrcPage(String srcPage) {
		this.srcPage = srcPage;
	}
	public String getDstPage() {
		return dstPage;
	}
	public void setDstPage(String dstPage) {
		this.dstPage = dstPage;
	}	
	
	public String toString() {
		return "sellerId="+sellerId + ";buyerId="+ buyerId + ";item=" + itemId;
	}

}
