package tw.com.imsoft.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TyOrder implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TY_ORDER.ORDER_NO
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private BigDecimal orderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TY_ORDER.MEM_ID
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private String memId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TY_ORDER.STORE_ID
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private BigDecimal storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TY_ORDER.DISCOUNT
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private BigDecimal discount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TY_ORDER.TOTAL_PRICE
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private BigDecimal totalPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TY_ORDER.ORDER_TIME
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private LocalDateTime orderTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TY_ORDER.GET_TIME
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private LocalDateTime getTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TY_ORDER.STATUS
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TY_ORDER
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private static final long serialVersionUID = 1L;
}