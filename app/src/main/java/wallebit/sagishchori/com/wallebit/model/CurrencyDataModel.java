package wallebit.sagishchori.com.wallebit.model;

public class CurrencyDataModel{

	private String priceUsd;
	private String symbol;
	private String lastUpdated;
	private String totalSupply;
	private String jsonMember24hVolumeUsd;
	private String priceBtc;
	private String availableSupply;
	private String marketCapUsd;
	private String percentChange1h;
	private String percentChange24h;
	private String name;
	private String rank;
	private String id;
	private String percentChange7d;

	public void setPriceUsd(String priceUsd){
		this.priceUsd = priceUsd;
	}

	public String getPriceUsd(){
		return priceUsd != null && priceUsd.length() > 0 ? priceUsd : "10000";
	}

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol != null && symbol.length() > 0 ? symbol : "BTC";
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setTotalSupply(String totalSupply){
		this.totalSupply = totalSupply;
	}

	public String getTotalSupply(){
		return totalSupply;
	}

	public void setJsonMember24hVolumeUsd(String jsonMember24hVolumeUsd){
		this.jsonMember24hVolumeUsd = jsonMember24hVolumeUsd;
	}

	public String getJsonMember24hVolumeUsd(){
		return jsonMember24hVolumeUsd;
	}

	public void setPriceBtc(String priceBtc){
		this.priceBtc = priceBtc;
	}

	public String getPriceBtc(){
		return priceBtc != null && priceBtc.length() > 0 ? priceBtc : "1";
	}

	public void setAvailableSupply(String availableSupply){
		this.availableSupply = availableSupply;
	}

	public String getAvailableSupply(){
		return availableSupply;
	}

	public void setMarketCapUsd(String marketCapUsd){
		this.marketCapUsd = marketCapUsd;
	}

	public String getMarketCapUsd(){
		return marketCapUsd;
	}

	public void setPercentChange1h(String percentChange1h){
		this.percentChange1h = percentChange1h;
	}

	public String getPercentChange1h(){
		return percentChange1h;
	}

	public void setPercentChange24h(String percentChange24h){
		this.percentChange24h = percentChange24h;
	}

	public String getPercentChange24h(){
		return percentChange24h;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name != null && name.length() > 0 ? name : "Bitcoin";
	}

	public void setRank(String rank){
		this.rank = rank;
	}

	public String getRank(){
		return rank;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPercentChange7d(String percentChange7d){
		this.percentChange7d = percentChange7d;
	}

	public String getPercentChange7d(){
		return percentChange7d;
	}

	@Override
 	public String toString(){
		return 
			"CurrencyDataModel{" + 
			"price_usd = '" + priceUsd + '\'' + 
			",symbol = '" + symbol + '\'' + 
			",last_updated = '" + lastUpdated + '\'' + 
			",total_supply = '" + totalSupply + '\'' + 
			",24h_volume_usd = '" + jsonMember24hVolumeUsd + '\'' + 
			",price_btc = '" + priceBtc + '\'' + 
			",available_supply = '" + availableSupply + '\'' + 
			",market_cap_usd = '" + marketCapUsd + '\'' + 
			",percent_change_1h = '" + percentChange1h + '\'' + 
			",percent_change_24h = '" + percentChange24h + '\'' + 
			",name = '" + name + '\'' + 
			",rank = '" + rank + '\'' + 
			",id = '" + id + '\'' + 
			",percent_change_7d = '" + percentChange7d + '\'' + 
			"}";
		}
}
