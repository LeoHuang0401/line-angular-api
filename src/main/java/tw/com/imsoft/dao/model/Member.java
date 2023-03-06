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
public class Member implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEMBER.MEM_ID
     *
     * @mbg.generated Mon Mar 06 15:11:59 CST 2023
     */
    private BigDecimal memId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEMBER.LINE_ID
     *
     * @mbg.generated Mon Mar 06 15:11:59 CST 2023
     */
    private String lineId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEMBER.MEM_NAME
     *
     * @mbg.generated Mon Mar 06 15:11:59 CST 2023
     */
    private String memName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table MEMBER
     *
     * @mbg.generated Mon Mar 06 15:11:59 CST 2023
     */
    private static final long serialVersionUID = 1L;
}