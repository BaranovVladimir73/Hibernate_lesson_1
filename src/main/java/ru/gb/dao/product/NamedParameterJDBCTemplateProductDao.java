package ru.gb.dao.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.gb.entity.Product;

import java.util.HashMap;

//@Component
@RequiredArgsConstructor
public class NamedParameterJDBCTemplateProductDao implements ProductDao{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        String sql = "select product.id, product.title, product.cost, product.manufacture_date, manufacturer.name AS manufacturer\n" +
                "from product\n" +
                "inner join manufacturer\n" +
                "on product.manufacturer_id = manufacturer.id;";


        return namedParameterJdbcTemplate.query(sql, (rs, rn) -> Product.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .cost(rs.getBigDecimal("cost"))
                .date(rs.getDate("manufacture_date").toLocalDate())
                .manufacturer(rs.getString("manufacturer"))
                .build());
    }

    @Override
    public Product findById(Long id) {

        String sql = "select product.id, product.title, product.cost, product.manufacture_date, manufacturer.name AS manufacturer\n" +
                "from product\n" +
                "inner join manufacturer\n" +
                "on product.manufacturer_id = manufacturer.id\n" +
                "where product.id = :productId;";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);

        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, (rs, rn) -> Product.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .cost(rs.getBigDecimal("cost"))
                .date(rs.getDate("manufacture_date").toLocalDate())
                .manufacturer(rs.getString("manufacturer"))
                .build());
    }

    @Override
    public String findNameById(Long id) {
        String sql = "SELECT title FROM product where id = :productId";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);

    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }



}
