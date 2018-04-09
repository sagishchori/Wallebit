package wallebit.sagishchori.com.wallebit.model;

public class URLParams
{
    /**
     * From Symbol
     */
    private String fsym;

    /**
     * To Symbols, include multiple symbols
     */
    private String tsyms;

    /**
     * Name of exchange. Default: CCCAGG
     */
    private String exchange;


    public URLParams(String fromCoin, String toCoins)
    {
        this.fsym = fromCoin;
        this.tsyms = toCoins;
    }

    public String getFsym()
    {
        return "fsym=" + fsym;
    }

    public void setFsym(String fsym)
    {
        this.fsym = fsym;
    }

    public String getTsyms()
    {
        return "&tsyms=" + tsyms;
    }

    public void setTsyms(String tsyms)
    {
        this.tsyms = tsyms;
    }

    public String getExchange()
    {
        return "&e=" + exchange;
    }

    public void setExchange(String exchange)
    {
        this.exchange = exchange;
    }

    @Override
    public String toString()
    {
        return "fsym=" + fsym + "tsyms=" + tsyms;
    }
}
