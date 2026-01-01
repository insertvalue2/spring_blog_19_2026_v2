package org.example.demo_ssr_v1_1.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 결제 내역 Repository 인터페이스
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    /**
     * imp_uid로 결제 내역 조회
     *
     * @param impUid 포트원 결제 고유 번호
     * @return 결제 내역 (Optional)
     */
    Optional<Payment> findByImpUid(String impUid);

    /**
     * merchant_uid로 결제 내역 조회
     *
     * @param merchantUid 가맹점 주문 번호
     * @return 결제 내역 (Optional)
     */
    Optional<Payment> findByMerchantUid(String merchantUid);

    /**
     * merchant_uid 중복 확인
     *
     * @param merchantUid 가맹점 주문 번호
     * @return 존재 여부
     */
    @Query("SELECT COUNT(p) > 0 FROM Payment p WHERE p.merchantUid = :merchantUid")
    boolean existsByMerchantUid(@Param("merchantUid") String merchantUid);

}