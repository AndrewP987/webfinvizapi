package com.finvizapi.webfinvizapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Stock {

    @JsonProperty("id")
    private int id;

    @JsonProperty("ticker")
    private String ticker;

    @JsonProperty("index")
    private String index;

    @JsonProperty("pe")
    private String pe;

    @JsonProperty("eps_ttm")
    private String epsTtm;

    @JsonProperty("insider_own")
    private String insiderOwn;

    @JsonProperty("shs_outstand")
    private String shsOutstand;

    @JsonProperty("perf_week")
    private String perfWeek;

    @JsonProperty("market_cap")
    private String marketCap;

    @JsonProperty("forward_pe")
    private String forwardPE;

    @JsonProperty("eps_next_y")
    private String epsNextY;

    @JsonProperty("insider_trans")
    private String insiderTrans;

    @JsonProperty("shs_float")
    private String shsFloat;

    @JsonProperty("perf_month")
    private String perfMonth;

    @JsonProperty("income")
    private String income;

    @JsonProperty("peg")
    private String peg;

    @JsonProperty("eps_next_q")
    private String epsNextQ;

    @JsonProperty("inst_own")
    private String instOwn;

    @JsonProperty("short_float_ratio")
    private String shortFloatRatio;

    @JsonProperty("perf_quarter")
    private String perfQuarter;

    @JsonProperty("sales")
    private String sales;

    @JsonProperty("p_s")
    private String pS;

    @JsonProperty("eps_this_y")
    private String epsThisY;

    @JsonProperty("inst_trans")
    private String instTrans;

    @JsonProperty("short_interest")
    private String shortInterest;

    @JsonProperty("perf_half_y")
    private String perfHalfY;

    @JsonProperty("book_sh")
    private String bookSh;

    @JsonProperty("pb")
    private String pB;

    @JsonProperty("eps_next_y_percent")
    private String epsNextYPercent;

    @JsonProperty("roa")
    private String roa;

    @JsonProperty("target_price")
    private String targetPrice;

    @JsonProperty("perf_year")
    private String perfYear;

    @JsonProperty("cash_sh")
    private String cashSh;

    @JsonProperty("p_c")
    private String pC;

    @JsonProperty("eps_past_5Y_percent")
    private String epsPast5YPercent;

    @JsonProperty("roe")
    private String roe;

    @JsonProperty("52w_range")
    private String range52W;

    @JsonProperty("perf_ytd")
    private String perfYTD;

    @JsonProperty("dividend")
    private String dividend;

    @JsonProperty("p_fcf")
    private String pFCF;

    @JsonProperty("eps_past_5y")
    private String epsPast5Y;

    @JsonProperty("roi")
    private String roi;

    @JsonProperty("52w_high")
    private String high52w;

    @JsonProperty("beta")
    private String beta;

    @JsonProperty("dividend_percent")
    private String dividendPercent;

    @JsonProperty("quick_ratio")
    private String quickRatio;

    @JsonProperty("sales_past_5y")
    private String salesPast5y;

    @JsonProperty("gross_margin")
    private String grossMargin;

    @JsonProperty("52w_low")
    private String low52w;

    @JsonProperty("atr")
    private String atr;

    @JsonProperty("employees")
    private String employees;

    @JsonProperty("current_ratio")
    private String currentRatio;

    @JsonProperty("sales_q_q")
    private String salesQQ;

    @JsonProperty("operating_margin")
    private String opMargin;

    @JsonProperty("rsi")
    private String rsi;

    @JsonProperty("volatility")
    private String volatility;

    @JsonProperty("optionable")
    private String optionable;

    @JsonProperty("debt_equity")
    private String debtEquity;

    @JsonProperty("eps_q_q")
    private String epsQQ;

    @JsonProperty("profit_margin")
    private String profitMargin;

    @JsonProperty("rel_volume")
    private String relVolume;

    @JsonProperty("prev_close")
    private String prevClose;

    @JsonProperty("shortable")
    private String shortable;

    @JsonProperty("lt_debt_eq")
    private String ltDebtEq;

    @JsonProperty("earnings")
    private String earnings;

    @JsonProperty("payout")
    private String payout;

    @JsonProperty("avg_volume")
    private String avgVolume;

    @JsonProperty("price")
    private String price;

    @JsonProperty("recom")
    private String recom;

    @JsonProperty("sma20")
    private String sma20;

    @JsonProperty("sma50")
    private String sma50;

    @JsonProperty("sma200")
    private String sma200;

    @JsonProperty("volume")
    private String volume;

    @JsonProperty("change")
    private String change;

    public Stock(@JsonProperty("id") int id,
            @JsonProperty("ticker") String ticker,
            @JsonProperty("index") String index,
            @JsonProperty("pe") String pe,
            @JsonProperty("eps_ttm") String epsTtm,
            @JsonProperty("insider_own") String insiderOwn,
            @JsonProperty("shs_outstand") String shsOutstand,
            @JsonProperty("perf_week") String perfWeek,
            @JsonProperty("market_cap") String marketCap,
            @JsonProperty("forward_pe") String forwardPE,
            @JsonProperty("eps_next_y") String epsNextY,
            @JsonProperty("insider_trans") String insiderTrans,
            @JsonProperty("shs_float") String shsFloat,
            @JsonProperty("perf_month") String perfMonth,
            @JsonProperty("income") String income,
            @JsonProperty("peg") String peg,
            @JsonProperty("eps_next_q") String epsNextQ,
            @JsonProperty("inst_own") String instOwn,
            @JsonProperty("short_float_ratio") String shortFloatRatio,
            @JsonProperty("perf_quarter") String perfQuarter,
            @JsonProperty("sales") String sales,
            @JsonProperty("p_s") String pS,
            @JsonProperty("eps_this_y") String epsThisY,
            @JsonProperty("inst_trans") String instTrans,
            @JsonProperty("short_interest") String shortInterest,
            @JsonProperty("perf_half_y") String perfHalfY,
            @JsonProperty("book_sh") String bookSh,
            @JsonProperty("pb") String pB,
            @JsonProperty("eps_next_y_percent") String epsNextYPercent,
            @JsonProperty("roa") String roa,
            @JsonProperty("target_price") String targetPrice,
            @JsonProperty("perf_year") String perfYear,
            @JsonProperty("cash_sh") String cashSh,
            @JsonProperty("p_c") String pC,
            @JsonProperty("eps_past_5Y_percent") String epsPast5YPercent,
            @JsonProperty("roe") String roe,
            @JsonProperty("52w_range") String range52W,
            @JsonProperty("perf_ytd") String perfYTD,
            @JsonProperty("dividend") String dividend,
            @JsonProperty("p_fcf") String pFCF,
            @JsonProperty("eps_past_5y") String epsPast5Y,
            @JsonProperty("roi") String roi,
            @JsonProperty("52w_high") String high52w,
            @JsonProperty("beta") String beta,
            @JsonProperty("dividend_percent") String dividendPercent,
            @JsonProperty("quick_ratio") String quickRatio,
            @JsonProperty("sales_past_5y") String salesPast5y,
            @JsonProperty("gross_margin") String grossMargin,
            @JsonProperty("52w_low") String low52w,
            @JsonProperty("atr") String atr,
            @JsonProperty("employees") String employees,
            @JsonProperty("current_ratio") String currentRatio,
            @JsonProperty("sales_q_q") String salesQQ,
            @JsonProperty("operating_margin") String opMargin,
            @JsonProperty("rsi") String rsi,
            @JsonProperty("volatility") String volatility,
            @JsonProperty("optionable") String optionable,
            @JsonProperty("debt_equity") String debtEquity,
            @JsonProperty("eps_q_q") String epsQQ,
            @JsonProperty("profit_margin") String profitMargin,
            @JsonProperty("rel_volume") String relVolume,
            @JsonProperty("prev_close") String prevClose,
            @JsonProperty("shortable") String shortable,
            @JsonProperty("lt_debt_eq") String ltDebtEq,
            @JsonProperty("earnings") String earnings,
            @JsonProperty("payout") String payout,
            @JsonProperty("avg_volume") String avgVolume,
            @JsonProperty("price") String price,
            @JsonProperty("recom") String recom,
            @JsonProperty("sma20") String sma20,
            @JsonProperty("sma50") String sma50,
            @JsonProperty("sma200") String sma200,
            @JsonProperty("volume") String volume,
            @JsonProperty("change") String change) {
        this.id = id;
        this.ticker = ticker;
        this.index = index;
        this.pe = pe;
        this.epsTtm = epsTtm;
        this.insiderOwn = insiderOwn;
        this.shsOutstand = shsOutstand;
        this.perfWeek = perfWeek;
        this.marketCap = marketCap;
        this.forwardPE = forwardPE;
        this.epsNextY = epsNextY;
        this.insiderTrans = insiderTrans;
        this.shsFloat = shsFloat;
        this.perfMonth = perfMonth;
        this.income = income;
        this.peg = peg;
        this.epsNextQ = epsNextQ;
        this.instOwn = instOwn;
        this.shortFloatRatio = shortFloatRatio;
        this.perfQuarter = perfQuarter;
        this.sales = sales;
        this.pS = pS;
        this.epsThisY = epsThisY;
        this.instTrans = instTrans;
        this.shortInterest = shortInterest;
        this.perfHalfY = perfHalfY;
        this.bookSh = bookSh;
        this.pB = pB;
        this.epsNextYPercent = epsNextYPercent;
        this.roa = roa;
        this.targetPrice = targetPrice;
        this.perfYear = perfYear;
        this.cashSh = cashSh;
        this.pC = pC;
        this.epsPast5YPercent = epsPast5YPercent;
        this.roe = roe;
        this.range52W = range52W;
        this.perfYTD = perfYTD;
        this.dividend = dividend;
        this.pFCF = pFCF;
        this.epsPast5Y = epsPast5Y;
        this.roi = roi;
        this.high52w = high52w;
        this.beta = beta;
        this.dividendPercent = dividendPercent;
        this.quickRatio = quickRatio;
        this.salesPast5y = salesPast5y;
        this.grossMargin = grossMargin;
        this.low52w = low52w;
        this.atr = atr;
        this.employees = employees;
        this.currentRatio = currentRatio;
        this.salesQQ = salesQQ;
        this.opMargin = opMargin;
        this.rsi = rsi;
        this.volatility = volatility;
        this.optionable = optionable;
        this.debtEquity = debtEquity;
        this.epsQQ = epsQQ;
        this.profitMargin = profitMargin;
        this.relVolume = relVolume;
        this.prevClose = prevClose;
        this.shortable = shortable;
        this.ltDebtEq = ltDebtEq;
        this.earnings = earnings;
        this.payout = payout;
        this.avgVolume = avgVolume;
        this.price = price;
        this.recom = recom;
        this.sma20 = sma20;
        this.sma50 = sma50;
        this.sma200 = sma200;
        this.volume = volume;
        this.change = change;
    }

    public static List<String> getPropertyNames(Class<?> clazz) {
        List<String> propertyNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
            if (jsonProperty != null) {
                propertyNames.add(jsonProperty.value());
            }
        }

        return propertyNames;
    }

    public Stock(@JsonProperty("ticker") String ticker) {
        this.ticker = ticker;
    }

    public Stock(Stock other) {
        this.id = other.id;
        this.ticker = other.ticker;
        this.index = other.index;
        this.pe = other.pe;
        this.epsTtm = other.epsTtm;
        this.insiderOwn = other.insiderOwn;
        this.shsOutstand = other.shsOutstand;
        this.perfWeek = other.perfWeek;
        this.marketCap = other.marketCap;
        this.forwardPE = other.forwardPE;
        this.epsNextY = other.epsNextY;
        this.insiderTrans = other.insiderTrans;
        this.shsFloat = other.shsFloat;
        this.perfMonth = other.perfMonth;
        this.income = other.income;
        this.peg = other.peg;
        this.epsNextQ = other.epsNextQ;
        this.instOwn = other.instOwn;
        this.shortFloatRatio = other.shortFloatRatio;
        this.perfQuarter = other.perfQuarter;
        this.sales = other.sales;
        this.pS = other.pS;
        this.epsThisY = other.epsThisY;
        this.instTrans = other.instTrans;
        this.shortInterest = other.shortInterest;
        this.perfHalfY = other.perfHalfY;
        this.bookSh = other.bookSh;
        this.pB = other.pB;
        this.epsNextYPercent = other.epsNextYPercent;
        this.roa = other.roa;
        this.targetPrice = other.targetPrice;
        this.perfYear = other.perfYear;
        this.cashSh = other.cashSh;
        this.pC = other.pC;
        this.epsPast5YPercent = other.epsPast5YPercent;
        this.roe = other.roe;
        this.range52W = other.range52W;
        this.perfYTD = other.perfYTD;
        this.dividend = other.dividend;
        this.pFCF = other.pFCF;
        this.epsPast5Y = other.epsPast5Y;
        this.roi = other.roi;
        this.high52w = other.high52w;
        this.beta = other.beta;
        this.dividendPercent = other.dividendPercent;
        this.quickRatio = other.quickRatio;
        this.salesPast5y = other.salesPast5y;
        this.grossMargin = other.grossMargin;
        this.low52w = other.low52w;
        this.atr = other.atr;
        this.employees = other.employees;
        this.currentRatio = other.currentRatio;
        this.salesQQ = other.salesQQ;
        this.opMargin = other.opMargin;
        this.rsi = other.rsi;
        this.volatility = other.volatility;
        this.optionable = other.optionable;
        this.debtEquity = other.debtEquity;
        this.epsQQ = other.epsQQ;
        this.profitMargin = other.profitMargin;
        this.relVolume = other.relVolume;
        this.prevClose = other.prevClose;
        this.shortable = other.shortable;
        this.ltDebtEq = other.ltDebtEq;
        this.earnings = other.earnings;
        this.payout = other.payout;
        this.avgVolume = other.avgVolume;
        this.price = other.price;
        this.recom = other.recom;
        this.sma20 = other.sma20;
        this.sma50 = other.sma50;
        this.sma200 = other.sma200;
        this.volume = other.volume;
        this.change = other.change;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return this.ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getIndex() {
        return this.index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPe() {
        return this.pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getEpsTtm() {
        return this.epsTtm;
    }

    public void setEpsTtm(String epsTtm) {
        this.epsTtm = epsTtm;
    }

    public String getInsiderOwn() {
        return this.insiderOwn;
    }

    public void setInsiderOwn(String insiderOwn) {
        this.insiderOwn = insiderOwn;
    }

    public String getShsOutstand() {
        return this.shsOutstand;
    }

    public void setShsOutstand(String shsOutstand) {
        this.shsOutstand = shsOutstand;
    }

    public String getPerfWeek() {
        return this.perfWeek;
    }

    public void setPerfWeek(String perfWeek) {
        this.perfWeek = perfWeek;
    }

    public String getMarketCap() {
        return this.marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getForwardPE() {
        return this.forwardPE;
    }

    public void setForwardPE(String forwardPE) {
        this.forwardPE = forwardPE;
    }

    public String getEpsNextY() {
        return this.epsNextY;
    }

    public void setEpsNextY(String epsNextY) {
        this.epsNextY = epsNextY;
    }

    public String getInsiderTrans() {
        return this.insiderTrans;
    }

    public void setInsiderTrans(String insiderTrans) {
        this.insiderTrans = insiderTrans;
    }

    public String getShsFloat() {
        return this.shsFloat;
    }

    public void setShsFloat(String shsFloat) {
        this.shsFloat = shsFloat;
    }

    public String getPerfMonth() {
        return this.perfMonth;
    }

    public void setPerfMonth(String perfMonth) {
        this.perfMonth = perfMonth;
    }

    public String getIncome() {
        return this.income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getPeg() {
        return this.peg;
    }

    public void setPeg(String peg) {
        this.peg = peg;
    }

    public String getEpsNextQ() {
        return this.epsNextQ;
    }

    public void setEpsNextQ(String epsNextQ) {
        this.epsNextQ = epsNextQ;
    }

    public String getInstOwn() {
        return this.instOwn;
    }

    public void setInstOwn(String instOwn) {
        this.instOwn = instOwn;
    }

    public String getShortFloatRatio() {
        return this.shortFloatRatio;
    }

    public void setShortFloatRatio(String shortFloatRatio) {
        this.shortFloatRatio = shortFloatRatio;
    }

    public String getPerfQuarter() {
        return this.perfQuarter;
    }

    public void setPerfQuarter(String perfQuarter) {
        this.perfQuarter = perfQuarter;
    }

    public String getSales() {
        return this.sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getPS() {
        return this.pS;
    }

    public void setPS(String pS) {
        this.pS = pS;
    }

    public String getEpsThisY() {
        return this.epsThisY;
    }

    public void setEpsThisY(String epsThisY) {
        this.epsThisY = epsThisY;
    }

    public String getInstTrans() {
        return this.instTrans;
    }

    public void setInstTrans(String instTrans) {
        this.instTrans = instTrans;
    }

    public String getShortInterest() {
        return this.shortInterest;
    }

    public void setShortInterest(String shortInterest) {
        this.shortInterest = shortInterest;
    }

    public String getPerfHalfY() {
        return this.perfHalfY;
    }

    public void setPerfHalfY(String perfHalfY) {
        this.perfHalfY = perfHalfY;
    }

    public String getBookSh() {
        return this.bookSh;
    }

    public void setBookSh(String bookSh) {
        this.bookSh = bookSh;
    }

    public String getPB() {
        return this.pB;
    }

    public void setPB(String pB) {
        this.pB = pB;
    }

    public String getEpsNextYPercent() {
        return this.epsNextYPercent;
    }

    public void setEpsNextYPercent(String epsNextYPercent) {
        this.epsNextYPercent = epsNextYPercent;
    }

    public String getRoa() {
        return this.roa;
    }

    public void setRoa(String roa) {
        this.roa = roa;
    }

    public String getTargetPrice() {
        return this.targetPrice;
    }

    public void setTargetPrice(String targetPrice) {
        this.targetPrice = targetPrice;
    }

    public String getPerfYear() {
        return this.perfYear;
    }

    public void setPerfYear(String perfYear) {
        this.perfYear = perfYear;
    }

    public String getCashSh() {
        return this.cashSh;
    }

    public void setCashSh(String cashSh) {
        this.cashSh = cashSh;
    }

    public String getPC() {
        return this.pC;
    }

    public void setPC(String pC) {
        this.pC = pC;
    }

    public String getEpsPast5YPercent() {
        return this.epsPast5YPercent;
    }

    public void setEpsPast5YPercent(String epsPast5YPercent) {
        this.epsPast5YPercent = epsPast5YPercent;
    }

    public String getRoe() {
        return this.roe;
    }

    public void setRoe(String roe) {
        this.roe = roe;
    }

    public String getRange52W() {
        return this.range52W;
    }

    public void setRange52W(String range52W) {
        this.range52W = range52W;
    }

    public String getPerfYTD() {
        return this.perfYTD;
    }

    public void setPerfYTD(String perfYTD) {
        this.perfYTD = perfYTD;
    }

    public String getDividend() {
        return this.dividend;
    }

    public void setDividend(String dividend) {
        this.dividend = dividend;
    }

    public String getPFCF() {
        return this.pFCF;
    }

    public void setPFCF(String pFCF) {
        this.pFCF = pFCF;
    }

    public String getEpsPast5Y() {
        return this.epsPast5Y;
    }

    public void setEpsPast5Y(String epsPast5Y) {
        this.epsPast5Y = epsPast5Y;
    }

    public String getRoi() {
        return this.roi;
    }

    public void setRoi(String roi) {
        this.roi = roi;
    }

    public String getHigh52w() {
        return this.high52w;
    }

    public void setHigh52w(String high52w) {
        this.high52w = high52w;
    }

    public String getBeta() {
        return this.beta;
    }

    public void setBeta(String beta) {
        this.beta = beta;
    }

    public String getDividendPercent() {
        return this.dividendPercent;
    }

    public void setDividendPercent(String dividendPercent) {
        this.dividendPercent = dividendPercent;
    }

    public String getQuickRatio() {
        return this.quickRatio;
    }

    public void setQuickRatio(String quickRatio) {
        this.quickRatio = quickRatio;
    }

    public String getSalesPast5y() {
        return this.salesPast5y;
    }

    public void setSalesPast5y(String salesPast5y) {
        this.salesPast5y = salesPast5y;
    }

    public String getGrossMargin() {
        return this.grossMargin;
    }

    public void setGrossMargin(String grossMargin) {
        this.grossMargin = grossMargin;
    }

    public String getLow52w() {
        return this.low52w;
    }

    public void setLow52w(String low52w) {
        this.low52w = low52w;
    }

    public String getAtr() {
        return this.atr;
    }

    public void setAtr(String atr) {
        this.atr = atr;
    }

    public String getEmployees() {
        return this.employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getCurrentRatio() {
        return this.currentRatio;
    }

    public void setCurrentRatio(String currentRatio) {
        this.currentRatio = currentRatio;
    }

    public String getSalesQQ() {
        return this.salesQQ;
    }

    public void setSalesQQ(String salesQQ) {
        this.salesQQ = salesQQ;
    }

    public String getOpMargin() {
        return this.opMargin;
    }

    public void setOpMargin(String opMargin) {
        this.opMargin = opMargin;
    }

    public String getRsi() {
        return this.rsi;
    }

    public void setRsi(String rsi) {
        this.rsi = rsi;
    }

    public String getVolatility() {
        return this.volatility;
    }

    public void setVolatility(String volatility) {
        this.volatility = volatility;
    }

    public String getOptionable() {
        return this.optionable;
    }

    public void setOptionable(String optionable) {
        this.optionable = optionable;
    }

    public String getDebtEquity() {
        return this.debtEquity;
    }

    public void setDebtEquity(String debtEquity) {
        this.debtEquity = debtEquity;
    }

    public String getEpsQQ() {
        return this.epsQQ;
    }

    public void setEpsQQ(String epsQQ) {
        this.epsQQ = epsQQ;
    }

    public String getProfitMargin() {
        return this.profitMargin;
    }

    public void setProfitMargin(String profitMargin) {
        this.profitMargin = profitMargin;
    }

    public String getRelVolume() {
        return this.relVolume;
    }

    public void setRelVolume(String relVolume) {
        this.relVolume = relVolume;
    }

    public String getPrevClose() {
        return this.prevClose;
    }

    public void setPrevClose(String prevClose) {
        this.prevClose = prevClose;
    }

    public String getShortable() {
        return this.shortable;
    }

    public void setShortable(String shortable) {
        this.shortable = shortable;
    }

    public String getLtDebtEq() {
        return this.ltDebtEq;
    }

    public void setLtDebtEq(String ltDebtEq) {
        this.ltDebtEq = ltDebtEq;
    }

    public String getEarnings() {
        return this.earnings;
    }

    public void setEarnings(String earnings) {
        this.earnings = earnings;
    }

    public String getPayout() {
        return this.payout;
    }

    public void setPayout(String payout) {
        this.payout = payout;
    }

    public String getAvgVolume() {
        return this.avgVolume;
    }

    public void setAvgVolume(String avgVolume) {
        this.avgVolume = avgVolume;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRecom() {
        return this.recom;
    }

    public void setRecom(String recom) {
        this.recom = recom;
    }

    public String getSma20() {
        return this.sma20;
    }

    public void setSma20(String sma20) {
        this.sma20 = sma20;
    }

    public String getSma50() {
        return this.sma50;
    }

    public void setSma50(String sma50) {
        this.sma50 = sma50;
    }

    public String getSma200() {
        return this.sma200;
    }

    public void setSma200(String sma200) {
        this.sma200 = sma200;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getChange() {
        return this.change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", ticker='" + getTicker() + "'" +
                ", index='" + getIndex() + "'" +
                ", pe='" + getPe() + "'" +
                ", epsTtm='" + getEpsTtm() + "'" +
                ", insiderOwn='" + getInsiderOwn() + "'" +
                ", shsOutstand='" + getShsOutstand() + "'" +
                ", perfWeek='" + getPerfWeek() + "'" +
                ", marketCap='" + getMarketCap() + "'" +
                ", forwardPE='" + getForwardPE() + "'" +
                ", epsNextY='" + getEpsNextY() + "'" +
                ", insiderTrans='" + getInsiderTrans() + "'" +
                ", shsFloat='" + getShsFloat() + "'" +
                ", perfMonth='" + getPerfMonth() + "'" +
                ", income='" + getIncome() + "'" +
                ", peg='" + getPeg() + "'" +
                ", epsNextQ='" + getEpsNextQ() + "'" +
                ", instOwn='" + getInstOwn() + "'" +
                ", shortFloatRatio='" + getShortFloatRatio() + "'" +
                ", perfQuarter='" + getPerfQuarter() + "'" +
                ", sales='" + getSales() + "'" +
                ", pS='" + getPS() + "'" +
                ", epsThisY='" + getEpsThisY() + "'" +
                ", instTrans='" + getInstTrans() + "'" +
                ", shortInterest='" + getShortInterest() + "'" +
                ", perfHalfY='" + getPerfHalfY() + "'" +
                ", bookSh='" + getBookSh() + "'" +
                ", pB='" + getPB() + "'" +
                ", epsNextYPercent='" + getEpsNextYPercent() + "'" +
                ", roa='" + getRoa() + "'" +
                ", targetPrice='" + getTargetPrice() + "'" +
                ", perfYear='" + getPerfYear() + "'" +
                ", cashSh='" + getCashSh() + "'" +
                ", pC='" + getPC() + "'" +
                ", epsPast5YPercent='" + getEpsPast5YPercent() + "'" +
                ", roe='" + getRoe() + "'" +
                ", range52W='" + getRange52W() + "'" +
                ", perfYTD='" + getPerfYTD() + "'" +
                ", dividend='" + getDividend() + "'" +
                ", pFCF='" + getPFCF() + "'" +
                ", epsPast5Y='" + getEpsPast5Y() + "'" +
                ", roi='" + getRoi() + "'" +
                ", high52w='" + getHigh52w() + "'" +
                ", beta='" + getBeta() + "'" +
                ", dividendPercent='" + getDividendPercent() + "'" +
                ", quickRatio='" + getQuickRatio() + "'" +
                ", salesPast5y='" + getSalesPast5y() + "'" +
                ", grossMargin='" + getGrossMargin() + "'" +
                ", low52w='" + getLow52w() + "'" +
                ", atr='" + getAtr() + "'" +
                ", employees='" + getEmployees() + "'" +
                ", currentRatio='" + getCurrentRatio() + "'" +
                ", salesQQ='" + getSalesQQ() + "'" +
                ", opMargin='" + getOpMargin() + "'" +
                ", rsi='" + getRsi() + "'" +
                ", volatility='" + getVolatility() + "'" +
                ", optionable='" + getOptionable() + "'" +
                ", debtEquity='" + getDebtEquity() + "'" +
                ", epsQQ='" + getEpsQQ() + "'" +
                ", profitMargin='" + getProfitMargin() + "'" +
                ", relVolume='" + getRelVolume() + "'" +
                ", prevClose='" + getPrevClose() + "'" +
                ", shortable='" + getShortable() + "'" +
                ", ltDebtEq='" + getLtDebtEq() + "'" +
                ", earnings='" + getEarnings() + "'" +
                ", payout='" + getPayout() + "'" +
                ", avgVolume='" + getAvgVolume() + "'" +
                ", price='" + getPrice() + "'" +
                ", recom='" + getRecom() + "'" +
                ", sma20='" + getSma20() + "'" +
                ", sma50='" + getSma50() + "'" +
                ", sma200='" + getSma200() + "'" +
                ", volume='" + getVolume() + "'" +
                ", change='" + getChange() + "'" +
                "}";
    }

}
