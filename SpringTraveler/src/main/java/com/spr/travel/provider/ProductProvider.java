package com.spr.travel.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProductProvider {
    public String getListBySearch(Map<String, String> map) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("product");
        String country = map.get("country");
        if (country != null && !country.equals("")) {
            sql.WHERE("proCountry LIKE CONCAT('%', #{country}, '%')");
        }
        String departure = map.get("departure");
        if (departure != null && !departure.equals("")) {
            sql.WHERE("DATE(proDeparture) = DATE(#{departure})");
        }
        String plan = map.get("plan");
        if (plan != null && !plan.equals("")) {
            sql.WHERE("proPlan = #{plan}");
        }
        String seat = map.get("seat");
        if (seat != null && !seat.equals("")) {
            sql.WHERE("(proSeat * 4) >= #{seat}");
        }
        String city = map.get("city");
        if (city != null && !city.equals("")) {
            sql.WHERE("product_city LIKE CONCAT('%', #{city}, '%')");
        }
        String money = map.get("money");
        if (money != null && !money.equals("")) {
            if (seat != null && !seat.equals("")) {
                sql.WHERE("proAdult * #{seat} <= #{money}");
            } else {
                sql.WHERE("proAdult <= #{money}");
            }
        }
        return sql.toString();
    }
}
