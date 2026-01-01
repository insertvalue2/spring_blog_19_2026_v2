package org.example.demo_ssr_v1_1.payment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
public class PaymentResponse {

    @Data
    public static class PrepareDTO {
        private String merchantUid;
        private Integer amount;
        private String impKey;

        public PrepareDTO(String merchantUid, Integer amount, String impKey) {
            this.merchantUid = merchantUid;
            this.amount = amount;
            this.impKey = impKey;
        }
    }

    // 화면(Alert창)에 띄워줄 최소한의 데이터
    @Data
    public static class VerifyDTO {
        private Integer amount;        // 충전 금액
        private Integer currentPoint;  // 현재 잔액

        public VerifyDTO(Integer amount, Integer currentPoint) {
            this.amount = amount;
            this.currentPoint = currentPoint;
        }
    }

    // 포트원 토큰 응답용 내부 DTO
    @Data
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class PortOneTokenResponse {
        private int code;
        private String message;
        private ResponseData response;

        @Data
        @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class ResponseData {
            private String accessToken;
            private int now;
            private int expiredAt;
        }
    }

    // 포트원 결제 조회 응답용 내부 DTO
    @Data
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class PortOnePaymentResponse {
        private int code;
        private String message;
        private PaymentData response;

        @Data
        @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class PaymentData {
            private String impUid;
            private String merchantUid;
            private Integer amount;
            private String status;
            private Long paidAt;
        }
    }
}