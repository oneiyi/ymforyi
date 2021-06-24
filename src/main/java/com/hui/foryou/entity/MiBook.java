package com.hui.foryou.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MiBook {


    @JsonProperty("code")
    private Integer code;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("regions")
        private RegionsDTO regions;
        @JsonProperty("datas")
        private DatasDTO datas;
        @JsonProperty("first_datas")
        private FirstDatasDTO firstDatas;
        @JsonProperty("second_datas")
        private SecondDatasDTO secondDatas;

        @NoArgsConstructor
        @Data
        public static class RegionsDTO {
            @JsonProperty("province")
            private ProvinceDTO province;
            @JsonProperty("city")
            private CityDTO city;
            @JsonProperty("district")
            private DistrictDTO district;
            @JsonProperty("area")
            private AreaDTO area;

            @NoArgsConstructor
            @Data
            public static class ProvinceDTO {
                @JsonProperty("id")
                private Integer id;
                @JsonProperty("name")
                private String name;
            }

            @NoArgsConstructor
            @Data
            public static class CityDTO {
                @JsonProperty("id")
                private Integer id;
                @JsonProperty("name")
                private String name;
            }

            @NoArgsConstructor
            @Data
            public static class DistrictDTO {
                @JsonProperty("id")
                private Integer id;
                @JsonProperty("name")
                private String name;
            }

            @NoArgsConstructor
            @Data
            public static class AreaDTO {
                @JsonProperty("id")
                private Integer id;
                @JsonProperty("name")
                private String name;
            }
        }

        @NoArgsConstructor
        @Data
        public static class DatasDTO {
            @JsonProperty("2212000071")
            private _$2212000071DTO $2212000071;

            @NoArgsConstructor
            @Data
            public static class _$2212000071DTO {
                @JsonProperty("is_cos")
                private Boolean isCos;
                @JsonProperty("is_local_cos")
                private Boolean isLocalCos;
                @JsonProperty("stock_num")
                private Integer stockNum;
                @JsonProperty("mihome_id")
                private Integer mihomeId;
                @JsonProperty("can_delivery")
                private Integer canDelivery;
                @JsonProperty("remark")
                private String remark;
                @JsonProperty("est_is_show")
                private Boolean estIsShow;
                @JsonProperty("est_delivery_desc")
                private String estDeliveryDesc;
            }
        }

        @NoArgsConstructor
        @Data
        public static class FirstDatasDTO {
            @JsonProperty("2212000071")
            private _$2212000071DTO $2212000071;

            @NoArgsConstructor
            @Data
            public static class _$2212000071DTO {
                @JsonProperty("is_cos")
                private Boolean isCos;
                @JsonProperty("is_local_cos")
                private Boolean isLocalCos;
                @JsonProperty("stock_num")
                private Integer stockNum;
                @JsonProperty("mihome_id")
                private Integer mihomeId;
                @JsonProperty("can_delivery")
                private Integer canDelivery;
                @JsonProperty("remark")
                private String remark;
                @JsonProperty("est_is_show")
                private Boolean estIsShow;
                @JsonProperty("est_delivery_desc")
                private String estDeliveryDesc;
            }
        }

        @NoArgsConstructor
        @Data
        public static class SecondDatasDTO {
        }
    }
}
