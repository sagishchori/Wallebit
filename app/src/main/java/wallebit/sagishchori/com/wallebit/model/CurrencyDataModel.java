package wallebit.sagishchori.com.wallebit.model;

public class CurrencyDataModel extends CurrencyBaseDataModel
{
	private String imageUrl;
	private String sortOrder;
	private String totalCoinSupply;
	private String url;
	private String proofType;
	private String preMinedValue;
	private String totalCoinsFreeFloat;
	private String fullyPremined;
	private boolean sponsored;

	@Override
	public String getSymbol()
	{
		return symbol;
	}

	@Override
	protected void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}

	@Override
	protected String getAlgorithm()
	{
		return algorithm;
	}

	@Override
	protected void setAlgorithm(String algorithm)
	{
		this.algorithm = algorithm;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	protected void setName(String name)
	{
		this.name = name;
	}

	@Override
	protected String getFullName()
	{
		return fullName;
	}

	@Override
	protected void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	@Override
	protected String getId()
	{
		return id;
	}

	@Override
	protected void setId(String id)
	{
		this.id = id;
	}

	@Override
	protected String getCoinName()
	{
		return coinName;
	}

	@Override
	protected void setCoinName(String coinName)
	{
		this.coinName = coinName;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setSortOrder(String sortOrder){
		this.sortOrder = sortOrder;
	}

	public String getSortOrder(){
		return sortOrder;
	}

	public void setTotalCoinSupply(String totalCoinSupply){
		this.totalCoinSupply = totalCoinSupply;
	}

	public String getTotalCoinSupply(){
		return totalCoinSupply;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setProofType(String proofType){
		this.proofType = proofType;
	}

	public String getProofType(){
		return proofType;
	}

	public void setPreMinedValue(String preMinedValue){
		this.preMinedValue = preMinedValue;
	}

	public String getPreMinedValue(){
		return preMinedValue;
	}

	public void setTotalCoinsFreeFloat(String totalCoinsFreeFloat){
		this.totalCoinsFreeFloat = totalCoinsFreeFloat;
	}

	public String getTotalCoinsFreeFloat(){
		return totalCoinsFreeFloat;
	}

	public void setFullyPremined(String fullyPremined){
		this.fullyPremined = fullyPremined;
	}

	public String getFullyPremined(){
		return fullyPremined;
	}

	public void setSponsored(boolean sponsored){
		this.sponsored = sponsored;
	}

	public boolean isSponsored(){
		return sponsored;
	}

	@Override
 	public String toString(){
		return 
			"CurrencyDataModel{" + 
			"symbol = '" + symbol + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",sortOrder = '" + sortOrder + '\'' + 
			",totalCoinSupply = '" + totalCoinSupply + '\'' + 
			",algorithm = '" + algorithm + '\'' + 
			",url = '" + url + '\'' + 
			",name = '" + name + '\'' + 
			",proofType = '" + proofType + '\'' + 
			",preMinedValue = '" + preMinedValue + '\'' + 
			",fullName = '" + fullName + '\'' + 
			",totalCoinsFreeFloat = '" + totalCoinsFreeFloat + '\'' + 
			",id = '" + id + '\'' + 
			",fullyPremined = '" + fullyPremined + '\'' + 
			",sponsored = '" + sponsored + '\'' + 
			",coinName = '" + coinName + '\'' + 
			"}";
		}
}
