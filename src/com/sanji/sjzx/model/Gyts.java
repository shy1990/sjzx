  package com.sanji.sjzx.model;

import java.sql.Timestamp;
import java.util.Date;

import com.sanji.sjzx.pojo.Base;

public class Gyts extends Base{
    /**
	 * @Fields serialVersionUID:TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String mail;
    
    private String item;

    private String price;

    private String sku;

    private String nums;

    private String receiverName;

    private String receiverAddress;

    private String receiverState;

    private String receiverCity;

    private String receiverDistrict;

    private String logisticsType;

    private String outerTid;

    private String outerShopCode;

    private String receiverPhone;

    private String receiverMobile;

    private String outerDdly;

    private String buyerMessage;

    private String storeCode;

    private String receiverZip;

    private String logisticsFee;

    private String fptt;

    private String syfp;

    private String lxdm;

    private String ticketNo;

    private String payCodes;

    private String payMoneys;

    private String payDatatimes;

    private String autosplit;

    private String tradeMemo;

    private String toverify;

    private String isCod;

    private String ygdm;

    private String invoiceContent;

    private String invoiceAmount;

    private String invoiceNumber;

    private String invoiceDate;

    private String yfrq;

    private String tbBz;

    private String codFee;

    private String totalDiscountFee;

    private String payTradeIds;

    private String payAccounts;

    private String payMemos;

    private String created;

    private String tid;

    private String error;
    
    private Timestamp addTime;
    //辅助字段订单推送时间
    private Date _orderStartTime;
    private Date _orderEndTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverState() {
		return receiverState;
	}

	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverDistrict() {
		return receiverDistrict;
	}

	public void setReceiverDistrict(String receiverDistrict) {
		this.receiverDistrict = receiverDistrict;
	}

	public String getLogisticsType() {
		return logisticsType;
	}

	public void setLogisticsType(String logisticsType) {
		this.logisticsType = logisticsType;
	}

	public String getOuterTid() {
		return outerTid;
	}

	public void setOuterTid(String outerTid) {
		this.outerTid = outerTid;
	}

	public String getOuterShopCode() {
		return outerShopCode;
	}

	public void setOuterShopCode(String outerShopCode) {
		this.outerShopCode = outerShopCode;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getOuterDdly() {
		return outerDdly;
	}

	public void setOuterDdly(String outerDdly) {
		this.outerDdly = outerDdly;
	}

	public String getBuyerMessage() {
		return buyerMessage;
	}

	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getReceiverZip() {
		return receiverZip;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	public String getLogisticsFee() {
		return logisticsFee;
	}

	public void setLogisticsFee(String logisticsFee) {
		this.logisticsFee = logisticsFee;
	}

	public String getFptt() {
		return fptt;
	}

	public void setFptt(String fptt) {
		this.fptt = fptt;
	}

	public String getSyfp() {
		return syfp;
	}

	public void setSyfp(String syfp) {
		this.syfp = syfp;
	}

	public String getLxdm() {
		return lxdm;
	}

	public void setLxdm(String lxdm) {
		this.lxdm = lxdm;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getPayCodes() {
		return payCodes;
	}

	public void setPayCodes(String payCodes) {
		this.payCodes = payCodes;
	}

	public String getPayMoneys() {
		return payMoneys;
	}

	public void setPayMoneys(String payMoneys) {
		this.payMoneys = payMoneys;
	}

	public String getAutosplit() {
		return autosplit;
	}

	public void setAutosplit(String autosplit) {
		this.autosplit = autosplit;
	}

	public String getTradeMemo() {
		return tradeMemo;
	}

	public void setTradeMemo(String tradeMemo) {
		this.tradeMemo = tradeMemo;
	}

	public String getToverify() {
		return toverify;
	}

	public void setToverify(String toverify) {
		this.toverify = toverify;
	}

	public String getIsCod() {
		return isCod;
	}

	public void setIsCod(String isCod) {
		this.isCod = isCod;
	}

	public String getYgdm() {
		return ygdm;
	}

	public void setYgdm(String ygdm) {
		this.ygdm = ygdm;
	}

	public String getInvoiceContent() {
		return invoiceContent;
	}

	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getTbBz() {
		return tbBz;
	}

	public void setTbBz(String tbBz) {
		this.tbBz = tbBz;
	}

	public String getCodFee() {
		return codFee;
	}

	public void setCodFee(String codFee) {
		this.codFee = codFee;
	}

	public String getTotalDiscountFee() {
		return totalDiscountFee;
	}

	public void setTotalDiscountFee(String totalDiscountFee) {
		this.totalDiscountFee = totalDiscountFee;
	}

	public String getPayTradeIds() {
		return payTradeIds;
	}

	public void setPayTradeIds(String payTradeIds) {
		this.payTradeIds = payTradeIds;
	}

	public String getPayAccounts() {
		return payAccounts;
	}

	public void setPayAccounts(String payAccounts) {
		this.payAccounts = payAccounts;
	}

	public String getPayMemos() {
		return payMemos;
	}

	public void setPayMemos(String payMemos) {
		this.payMemos = payMemos;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public String getPayDatatimes() {
		return payDatatimes;
	}

	public void setPayDatatimes(String payDatatimes) {
		this.payDatatimes = payDatatimes;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getYfrq() {
		return yfrq;
	}

	public void setYfrq(String yfrq) {
		this.yfrq = yfrq;
	}

	public Date get_orderStartTime() {
		return _orderStartTime;
	}

	public void set_orderStartTime(Date _orderStartTime) {
		this._orderStartTime = _orderStartTime;
	}

	public Date get_orderEndTime() {
		return _orderEndTime;
	}

	public void set_orderEndTime(Date _orderEndTime) {
		this._orderEndTime = _orderEndTime;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

}