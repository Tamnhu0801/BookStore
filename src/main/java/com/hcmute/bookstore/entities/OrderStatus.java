package com.hcmute.bookstore.entities;

public enum OrderStatus {
    NEW {
        @Override
        public String defaultDescription() {
            return "Chờ xác nhận";
        }

    },

    VERIFIED {
        @Override
        public String defaultDescription() {
            return "Chờ lấy hàng";
        }

    },

    CANCELLED {
        @Override
        public String defaultDescription() {
            return "Đã hủy";
        }
    },

    SHIPPING {
        @Override
        public String defaultDescription() {
            return "Đang giao";
        }
    },

    DELIVERED {
        @Override
        public String defaultDescription() {
            return "Giao thành công";
        }
    },

    RETURNED {
        @Override
        public String defaultDescription() {
            return "Trả hàng";
        }
    };

    public abstract String defaultDescription();
}
