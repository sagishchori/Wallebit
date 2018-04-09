package wallebit.sagishchori.com.wallebit.model;

import java.util.ArrayList;

public class CurrencyPriceDataModel extends CurrencyBaseDataModel
{
    /**
     * {@link ArrayList} for all the coins to convert the requested coin to.
     *
     * (Example: convert BTC to USD, ETH etc.)
     */
    private ArrayList<String> currencyConversionCoins;

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

    public ArrayList<String> getCurrencyConversionCoins()
    {
        return currencyConversionCoins;
    }

    public void setCurrencyConversionCoins(ArrayList<String> currencyConversionCoins)
    {
        this.currencyConversionCoins = currencyConversionCoins;
    }

    @Override
    public String toString(){
        return
                "CurrencyDataModel{" +
                        "symbol = '" + Symbol + '\'' +
                        ",algorithm = '" + Algorithm + '\'' +
                        ",name = '" + Name + '\'' +
                        ",fullName = '" + FullName + '\'' +
                        ",id = '" + Id + '\'' +
                        ",coinName = '" + CoinName + '\'' +
                        ",currencyConversionCoins = '" + currencyConversionCoins.toString() + '\'' +
                        "}";
    }
}
