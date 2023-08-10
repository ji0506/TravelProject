package com.spr.travel.dao;

import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
import com.spr.travel.provider.ProductProvider;
import com.spr.travel.reservation.ReservationVO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductDAO {
    @Select("SELECT * FROM product")
    List<Product> getAllList();
    @Select("SELECT * FROM product WHERE proContinent = #{continent}")
    List<Product> getListByContinent(String continent);

    @Select("SELECT * FROM product WHERE proCity = #{city}")
    List<Product> getListByCity(String city);

    @Select("SELECT p.*, d.detail_info, /*d.detail_schedule,*/ d.detail_image, d.detail_viewcnt FROM product AS p INNER JOIN product_detail AS d ON p.pro_no = d.pro_no WHERE p.pro_no = #{id}")
    ProductDetail getFullProductById(String id);

    @Select("SELECT * FROM product WHERE pro_no = #{id}")
    Product getProductById(String id);

    @SelectProvider(type = ProductProvider.class, method = "getListBySearch")
    List<Product> getListBySearch(Map<String, String> map);

    @Insert("INSERT INTO product VALUES (NULL, #{proContinent}, #{proCountry}, #{proCity}, #{pro_name}, #{proAirplane}, #{proDeparture}, #{proArrive}, (Date(#{proArrive}) - Date(#{proDeparture})), #{proAdult}, #{proMinor}, #{proSeat})")
    int createProduct(ProductDetail vo);

    @Insert("INSERT INTO product_detail VALUES (NULL, LAST_INSERT_ID(), #{detail_info}, #{detail_schedule}, #{detail_title_image}, 0)")
    int createDetail(ProductDetail vo);

    @Insert("INSERT INTO reservation VALUES (NULL, #{user_id}, #{rev_name}, #{rev_birth}, #{rev_phone}, #{rev_email}, #{pro_no}, #{rev_adult}, #{rev_minor})")
    int reserve(ReservationVO rvo);

    @Update("UPDATE product SET proSeat = proSeat - 1 WHERE pro_no = #{pro_no}")
    int seatMinus(ReservationVO rvo);

    @Select("SELECT LAST_INSERT_ID()")
    int getLastInsertId();

    @Update("UPDATE product AS p, product_detail AS d SET p.proContinent = #{proContinent}, p.proCountry; = #{proCountry;}, p.proCity = #{proCity}, p.pro_name = #{pro_name}, p.proAirplane = #{proAirplane}, p.proDeparture = #{proDeparture}, p.proArrive = #{proArrive}, p.product_plan = (Date(#{proArrive}) - Date(#{proDeparture})), p.proAdult = #{proAdult}, p.proMinor = #{proMinor}, p.proSeat = #{proSeat}, d.detail_info = #{detail_info}, d.detail_schedule = #{detail_schedule}, d.detail_title_image = #{detail_title_image} WHERE p.pro_no = #{pro_no} AND d.pro_no = #{pro_no}")
    int updateProduct(ProductDetail dto);

    @Update("UPDATE product_detail SET detail_viewcnt = detail_viewcnt + 1 WHERE pro_no = #{id}")
    int updateViewcntById(String id);

    @Select("SELECT * FROM reservation WHERE user_id = #{user_id} AND pro_no = #{pro_no}")
    ReservationVO getReservationOfMember(@Param("user_id") String user_id, @Param("pro_no") String pro_no);

    @Delete("DELETE FROM product WHERE pro_no = #{id}")
    int deleteProduct(int id);

    @Update("UPDATE product_html SET pro_no = #{id} WHERE file_name = #{fileName}")
    int createHtmlList(@Param("id") int id, @Param("fileName") String fileName);

    @Select("SELECT file_name FROM product_html WHERE pro_no = #{id}")
    List<String> getFileNameList(int id);

    @Delete("DELETE FROM product_html WHERE pro_no = #{id}")
    void deleteFileNameList(int id);

    @Insert("INSERT INTO product_html (file_name) VALUES (#{uploadedName})")
    int addHTMLImage(String uploadedName);

    @Select("SELECT file_name FROM product_html WHERE pro_no IS NULL")
    List<String> getTrashList();

    @Delete("DELETE FROM product_html WHERE pro_no IS NULL")
    void deleteTrashList();

}
