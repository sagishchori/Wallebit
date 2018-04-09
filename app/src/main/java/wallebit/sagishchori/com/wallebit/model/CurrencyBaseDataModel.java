package wallebit.sagishchori.com.wallebit.model;

public abstract class CurrencyBaseDataModel
{
    protected String symbol;
    protected String algorithm;
    protected String name;
    protected String fullName;
    protected String id;
    protected String coinName;

    public abstract String getSymbol();

    protected abstract void setSymbol(String symbol);

    protected abstract String getAlgorithm();

    protected abstract void setAlgorithm(String algorithm);

    public abstract String getName();

    protected abstract void setName(String name);

    protected abstract String getFullName();

    protected abstract void setFullName(String fullName);

    protected abstract String getId();

    protected abstract void setId(String id);

    protected abstract String getCoinName();

    protected abstract void setCoinName(String coinName);
}
