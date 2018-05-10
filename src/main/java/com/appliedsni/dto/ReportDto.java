package com.appliedsni.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Date;
import java.util.UUID;


public class ReportDto implements Serializable{
	
	private UUID mIdKey;
	
	private String mTradingsymbol;

	private Indicator mIndicator;

	private PviResetStrategy mStrategy;

	private String mType;

	private String mEntryRule;
	
	private Integer mMinutes;
	
	private Integer mParameters;

	private Date mRuleTimestamp;
	
	private BigDecimal mEntryPrice = BigDecimal.ZERO;
	
	private String mRatio;

	private BigDecimal mTargetPrice = BigDecimal.ZERO;

	private BigDecimal mStoplossPrice = BigDecimal.ZERO;

	private Date mEntryTimestamp;

	private BigDecimal mExitPrice = BigDecimal.ZERO;

	private Date mExitTimestamp;

	private BigDecimal mInitialCapital = BigDecimal.ZERO;
	
	private Integer mNumberOfShares = 1;

	private BigDecimal mInvestedCapital = BigDecimal.ZERO;

	private BigDecimal mFreeCapital = BigDecimal.ZERO;

	private BigDecimal mEntryBrokerage = BigDecimal.ZERO;

	private BigDecimal mExitBrokerage = BigDecimal.ZERO;

	private BigDecimal mFinalCapital = BigDecimal.ZERO;

	private BigDecimal mProfitLoss = BigDecimal.ZERO;
	
	private Status mStatus;
	
	@Override
	public String toString() {
		return mRuleTimestamp + " : " + mTargetPrice + " : " + mStoplossPrice + " : " + mMinutes + " : " + mTradingsymbol + " : " + mRatio + " : " + mParameters;
	}

	public UUID getmIdKey() {
		return mIdKey;
	}

	public void setmIdKey(UUID mIdKey) {
		this.mIdKey = mIdKey;
	}

	public String getmTradingsymbol() {
		return mTradingsymbol;
	}

	public void setmTradingsymbol(String mTradingsymbol) {
		this.mTradingsymbol = mTradingsymbol;
	}

	public Indicator getmIndicator() {
		return mIndicator;
	}

	public void setmIndicator(Indicator mIndicator) {
		this.mIndicator = mIndicator;
	}

	public PviResetStrategy getmStrategy() {
		return mStrategy;
	}

	public void setmStrategy(PviResetStrategy mStrategy) {
		this.mStrategy = mStrategy;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getmEntryRule() {
		return mEntryRule;
	}

	public void setmEntryRule(String mEntryRule) {
		this.mEntryRule = mEntryRule;
	}

	public Integer getmMinutes() {
		return mMinutes;
	}

	public void setmMinutes(Integer mMinutes) {
		this.mMinutes = mMinutes;
	}

	public Integer getmParameters() {
		return mParameters;
	}

	public void setmParameters(Integer mParameters) {
		this.mParameters = mParameters;
	}

	public Date getmRuleTimestamp() {
		return mRuleTimestamp;
	}

	public void setmRuleTimestamp(Date mRuleTimestamp) {
		this.mRuleTimestamp = mRuleTimestamp;
	}

	public BigDecimal getmEntryPrice() {
		return mEntryPrice;
	}

	public void setmEntryPrice(BigDecimal mEntryPrice) {
		this.mEntryPrice = mEntryPrice;
	}

	public String getmRatio() {
		return mRatio;
	}

	public void setmRatio(String mRatio) {
		this.mRatio = mRatio;
	}

	public BigDecimal getmTargetPrice() {
		return mTargetPrice;
	}

	public void setmTargetPrice(BigDecimal mTargetPrice) {
		this.mTargetPrice = mTargetPrice;
	}

	public BigDecimal getmStoplossPrice() {
		return mStoplossPrice;
	}

	public void setmStoplossPrice(BigDecimal mStoplossPrice) {
		this.mStoplossPrice = mStoplossPrice;
	}

	public Date getmEntryTimestamp() {
		return mEntryTimestamp;
	}

	public void setmEntryTimestamp(Date mEntryTimestamp) {
		this.mEntryTimestamp = mEntryTimestamp;
	}

	public BigDecimal getmExitPrice() {
		return mExitPrice;
	}

	public void setmExitPrice(BigDecimal mExitPrice) {
		this.mExitPrice = mExitPrice;
	}

	public Date getmExitTimestamp() {
		return mExitTimestamp;
	}

	public void setmExitTimestamp(Date mExitTimestamp) {
		this.mExitTimestamp = mExitTimestamp;
	}

	public BigDecimal getmInitialCapital() {
		return mInitialCapital;
	}

	public void setmInitialCapital(BigDecimal mInitialCapital) {
		this.mInitialCapital = mInitialCapital;
	}

	public Integer getmNumberOfShares() {
		return mNumberOfShares;
	}

	public void setmNumberOfShares(Integer mNumberOfShares) {
		this.mNumberOfShares = mNumberOfShares;
	}

	public BigDecimal getmInvestedCapital() {
		return mInvestedCapital;
	}

	public void setmInvestedCapital(BigDecimal mInvestedCapital) {
		this.mInvestedCapital = mInvestedCapital;
	}

	public BigDecimal getmFreeCapital() {
		return mFreeCapital;
	}

	public void setmFreeCapital(BigDecimal mFreeCapital) {
		this.mFreeCapital = mFreeCapital;
	}

	public BigDecimal getmEntryBrokerage() {
		return mEntryBrokerage;
	}

	public void setmEntryBrokerage(BigDecimal mEntryBrokerage) {
		this.mEntryBrokerage = mEntryBrokerage;
	}

	public BigDecimal getmExitBrokerage() {
		return mExitBrokerage;
	}

	public void setmExitBrokerage(BigDecimal mExitBrokerage) {
		this.mExitBrokerage = mExitBrokerage;
	}

	public BigDecimal getmFinalCapital() {
		return mFinalCapital;
	}

	public void setmFinalCapital(BigDecimal mFinalCapital) {
		this.mFinalCapital = mFinalCapital;
	}

	public BigDecimal getmProfitLoss() {
		return mProfitLoss;
	}

	public void setmProfitLoss(BigDecimal mProfitLoss) {
		this.mProfitLoss = mProfitLoss;
	}

	public Status getmStatus() {
		return mStatus;
	}

	public void setmStatus(Status mStatus) {
		this.mStatus = mStatus;
	}



}
