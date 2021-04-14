CREATE TABLE `blog` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `title` varchar(255) DEFAULT NULL,
                        `summary` varchar(255) DEFAULT NULL,
                        `content` text,
                        `publish_date` datetime DEFAULT NULL,
                        `blog_column` varchar(255) DEFAULT NULL,
                        `views` int DEFAULT NULL,
                        `tags` varchar(255) DEFAULT NULL,
                        `blog_img` varchar(255) DEFAULT NULL,
                        `blog_state` tinyint DEFAULT NULL,
                        `admire_state` tinyint DEFAULT NULL,
                        `recommend_state` tinyint DEFAULT NULL,
                        `reprint_state` tinyint DEFAULT NULL,
                        `create_time` datetime DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `blog_column` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `name` varchar(45) DEFAULT NULL,
                               `intro` varchar(45) DEFAULT NULL,
                               `blog_count` int DEFAULT NULL,
                               `create_time` datetime DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `blog_user` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `name` varchar(45) DEFAULT NULL,
                             `password` varchar(255) DEFAULT NULL,
                             `icon` varchar(255) DEFAULT NULL,
                             `authorities` varchar(255) DEFAULT NULL,
                             `create_time` datetime DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tags` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` varchar(45) DEFAULT NULL,
                        `blog_count` int DEFAULT NULL,
                        `create_time` datetime DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `blog`.`blog_user` (`id`, `name`, `password`, `icon`, `authorities`, `create_time`) VALUES ('1', 'admin', 'JJJgMw92GlJJl2gs/+ZJNA==', '/images/阿巴.jpg', 'ADMIN', '2021-02-20 00:00:00');

