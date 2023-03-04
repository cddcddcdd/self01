
CREATE DATABASE  self01 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use self01;
SET NAMES utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE `user`  (
    `id` int(0) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `age` int(0) NULL DEFAULT NULL,
    `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `create_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
    `update_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

