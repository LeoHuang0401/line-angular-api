package tw.com.imsoft.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STORE.STORE_ID
     *
     * @mbg.generated Mon Mar 06 15:47:11 CST 2023
     */
    private BigDecimal storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STORE.STORE_NAME
     *
     * @mbg.generated Mon Mar 06 15:47:11 CST 2023
     */
    private String storeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STORE.LOCATION
     *
     * @mbg.generated Mon Mar 06 15:47:11 CST 2023
     */
    private String location;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column STORE.STORE_CATEGORY_ID
     *
     * @mbg.generated Mon Mar 06 15:47:11 CST 2023
     */
    private BigDecimal storeCategoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table STORE
     *
     * @mbg.generated Mon Mar 06 15:47:11 CST 2023
     */
    private static final long serialVersionUID = 1L;
}