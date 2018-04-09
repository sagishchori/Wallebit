package wallebit.sagishchori.com.wallebit.model;

public class CurrencyDataModel extends CurrencyBaseDataModel
{
	private String ImageUrl;
	private String SortOrder;
	private String TotalCoinSupply;
	private String Url;
	private String ProofType;
	private String PreMinedValue;
	private String TotalCoinsFreeFloat;
	private String FullyPremined;
	private boolean Sponsored;

	@Override
	public String getSymbol()
	{
		return Symbol;
	}

	@Override
	protected void setSymbol(String symbol)
	{
		this.Symbol = symbol;
	}

	@Override
	protected String getAlgorithm()
	{
		return Algorithm;
	}

	@Override
	protected void setAlgorithm(String algorithm)
	{
		this.Algorithm = algorithm;
	}

	@Override
	public String getName()
	{
		return Name;
	}

	@Override
	protected void setName(String name)
	{
		this.Name = name;
	}

	@Override
	protected String getFullName()
	{
		return FullName;
	}

	@Override
	protected void setFullName(String fullName)
	{
		this.FullName = fullName;
	}

	@Override
	protected String getId()
	{
		return Id;
	}

	@Override
	protected void setId(String id)
	{
		this.Id = id;
	}

	@Override
	protected String getCoinName()
	{
		return CoinName;
	}

	@Override
	protected void setCoinName(String coinName)
	{
		this.CoinName = coinName;
	}

	public void setImageUrl(String imageUrl){
		this.ImageUrl = imageUrl;
	}

	public String getImageUrl(){
		return ImageUrl;
	}

	public void setSortOrder(String sortOrder){
		this.SortOrder = sortOrder;
	}

	public String getSortOrder(){
		return SortOrder;
	}

	public void setTotalCoinSupply(String totalCoinSupply){
		this.TotalCoinSupply = totalCoinSupply;
	}

	public String getTotalCoinSupply(){
		return TotalCoinSupply;
	}

	public void setUrl(String url){
		this.Url = url;
	}

	public String getUrl(){
		return Url;
	}

	public void setProofType(String proofType){
		this.ProofType = proofType;
	}

	public String getProofType(){
		return ProofType;
	}

	public void setPreMinedValue(String preMinedValue){
		this.PreMinedValue = preMinedValue;
	}

	public String getPreMinedValue(){
		return PreMinedValue;
	}

	public void setTotalCoinsFreeFloat(String totalCoinsFreeFloat){
		this.TotalCoinsFreeFloat = totalCoinsFreeFloat;
	}

	public String getTotalCoinsFreeFloat(){
		return TotalCoinsFreeFloat;
	}

	public void setFullyPremined(String fullyPremined){
		this.FullyPremined = fullyPremined;
	}

	public String getFullyPremined(){
		return FullyPremined;
	}

	public void setSponsored(boolean sponsored){
		this.Sponsored = sponsored;
	}

	public boolean isSponsored(){
		return Sponsored;
	}

	@Override
 	public String toString(){
		return 
			"CurrencyDataModel{" + 
			"symbol = '" + Symbol + '\'' +
			",imageUrl = '" + ImageUrl + '\'' +
			",sortOrder = '" + SortOrder + '\'' +
			",totalCoinSupply = '" + TotalCoinSupply + '\'' +
			",algorithm = '" + Algorithm + '\'' +
			",url = '" + Url + '\'' +
			",name = '" + Name + '\'' +
			",proofType = '" + ProofType + '\'' +
			",preMinedValue = '" + PreMinedValue + '\'' +
			",fullName = '" + FullName + '\'' +
			",totalCoinsFreeFloat = '" + TotalCoinsFreeFloat + '\'' +
			",id = '" + Id + '\'' +
			",fullyPremined = '" + FullyPremined + '\'' +
			",sponsored = '" + Sponsored + '\'' +
			",coinName = '" + CoinName + '\'' +
			"}";
		}
}
