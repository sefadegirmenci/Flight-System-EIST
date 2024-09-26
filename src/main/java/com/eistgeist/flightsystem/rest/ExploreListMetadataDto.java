package com.eistgeist.flightsystem.rest;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class ExploreListMetadataDto {
    private String uid;
    private boolean visible;
    private String title;
    private String shortDescription;
    private String longDescription;
    private String backgroundColor;
    private String illustrationUrl;
    private String question;
    private String answer;
    private InvestmentType investmentType;
    private CountryType country;
    private ExploreListType type;
    private Integer maxItemCount;
    private Integer itemCount;
    private List<MetadataColumnDto> columns;
    private Set<String> excludedStockUids;
    private Double sortScore;
    private String shareLink;
}


enum InvestmentType {
    MARKET_INSTRUMENTS,
    INVESTMENT_FUNDS
}
@RequiredArgsConstructor
enum CountryType {

    US(CurrencyType.USD),
    TR(CurrencyType.TRY);

    private final CurrencyType currency;

    public boolean isTR() {
        return this.equals(TR);
    }

    public CurrencyType getCurrency() {
        return currency;
    }
}

@Getter
@RequiredArgsConstructor
enum ExploreListType { //todo calculation method ile birebir ilişkili - birleştir

    //todo string'leri key yapıp properties'ten okutabiliriz
    MOST_POPULAR(ColumnMetadata.WEEKLY_CHANGE, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.US, "populer", CountryType.TR, "bist_populer"), SortOrder.DESCENDING, true),
    HIGH_DIVIDEND(ColumnMetadata.DIVIDEND_YIELD, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.US, "temettu", CountryType.TR, "bist_temettu"), SortOrder.DESCENDING, true),
    LOW_PRICE(ColumnMetadata.PRICE_EARNING, ColumnMetadata.INDUSTRY_COMPARING, Map.of(CountryType.US, "uygun", CountryType.TR, "bist_uygun"), SortOrder.ASCENDING, true),
    CUSTOM_TEMPLATE(ColumnMetadata.WEEKLY_CHANGE, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.US, "-", CountryType.TR, "-"), SortOrder.ASCENDING, false),
    LARGEST_MARKET_CAP(ColumnMetadata.MARKET_CAP, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.US, "buyukler", CountryType.TR, "bist_buyukler"), SortOrder.DESCENDING, true),
    PENNY_STOCKS(ColumnMetadata.WEEKLY_CHANGE, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.US, "birdolar"), SortOrder.ASCENDING, true),
    ANALYST_RECOMMENDED(ColumnMetadata.WEEKLY_CHANGE, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.US, "analist", CountryType.TR, "bist_analist"), SortOrder.DESCENDING, true),
    FRACTIONAL_STOCKS(ColumnMetadata.WEEKLY_CHANGE, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.US, "parcali"), SortOrder.DESCENDING, true),
    INDEX_BEATERS(ColumnMetadata.THREE_MONTH_CHANGE, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.US, "endeksyenen", CountryType.TR, "bist_endeksyenen"), SortOrder.DESCENDING, true),
    HIGH_UPSIDE_POTENTIAL(ColumnMetadata.UPSIDE_POTENTIAL, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.US, "potansiyel", CountryType.TR, "bist_potansiyel"), SortOrder.DESCENDING, true),
    YEARLY_EXTREME(ColumnMetadata.YEARLY_CHANGE, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.US, "zirve", CountryType.TR, "bist_zirve"), SortOrder.DESCENDING, true),
    HIGH_EXPORT_RATIO(ColumnMetadata.EXPORT_RATIO, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.TR, "yuksek-ihracat"), SortOrder.DESCENDING, true),
    RETURN_ON_EQUITY(ColumnMetadata.RETURN_ON_EQUITY, ColumnMetadata.STOCK_PRICE, Map.of(CountryType.TR, "ozsermaye-karlilik"), SortOrder.DESCENDING, true);

    private final ColumnMetadata primaryInfo;
    private final ColumnMetadata secondaryInfo;
    private final Map<CountryType, String> shareCodesWithCountry;
    private final SortOrder sortOrder;
    private final boolean sync;
}

@Getter
@Setter
class MetadataColumnDto {

    private String key;
    private String name;
    private UnitType type;
}

enum CurrencyType {

    USD,
    TRY
}

enum UnitType {
    PERCENTAGE,
    PRICE,
    COUNT,
    RATIO,
    LEVEL
}
@Getter
@RequiredArgsConstructor
enum ColumnMetadata {

    FOLLOWERS("Takip Edenler", UnitType.COUNT),
    STOCK_PRICE("Fiyat", UnitType.PRICE),
    DIVIDEND_YIELD("Temettü Verimi", UnitType.PERCENTAGE),
    PRICE_EARNING("F/K", UnitType.RATIO),
    INDUSTRY_COMPARING("Sektöre Göre", UnitType.LEVEL),
    WEEKLY_CHANGE("Haftalık Değişim", UnitType.PERCENTAGE),
    THREE_MONTH_CHANGE("Üç Aylık Değişim", UnitType.PERCENTAGE),
    MARKET_CAP("Piyasa Değeri", UnitType.PRICE),
    UPSIDE_POTENTIAL("Yükseliş Potansiyeli", UnitType.PERCENTAGE),
    YEARLY_CHANGE("Yıllık Değişim", UnitType.PERCENTAGE),
    EXPORT_RATIO("İhracat Oranı", UnitType.PERCENTAGE),
    RETURN_ON_EQUITY("Özsermaye Karlılığı", UnitType.PERCENTAGE);


    private final String columnName;
    private final UnitType columnType;
}

enum SortOrder {
    ASCENDING {
        @Override
        public Double parseScore(String sortScore) {
            return Double.parseDouble(sortScore);
        }
    },
    DESCENDING {
        @Override
        public Double parseScore(String sortScore) {
            return Double.parseDouble(sortScore) * -1;
        }
    };

    public abstract Double parseScore(String value);
}
