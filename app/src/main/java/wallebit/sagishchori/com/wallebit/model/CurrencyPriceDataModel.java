package wallebit.sagishchori.com.wallebit.model;

import java.util.ArrayList;

public class CurrencyPriceDataModel extends CurrencyBaseDataModel
{
    /**
     * {@link ArrayList} for all the coins to convert the requested coin to
     * (Example: convert BTC to USD, ETH etc.)
     */
    private ArrayList<String> currencyConversionCoins;

    @Override
    protected String getSymbol()
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
    protected String getName()
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
                        "symbol = '" + symbol + '\'' +
                        ",algorithm = '" + algorithm + '\'' +
                        ",name = '" + name + '\'' +
                        ",fullName = '" + fullName + '\'' +
                        ",id = '" + id + '\'' +
                        ",coinName = '" + coinName + '\'' +
                        ",currencyConversionCoins = '" + currencyConversionCoins.toString() + '\'' +
                        "}";
    }
}
