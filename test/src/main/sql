<!-- 用户表  -->
DROP TABLE IF EXISTS `myuser`;
CREATE TABLE `myuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT, //用户id
  `name` varchar(20) NOT NULL, //用户名字
  `money` decimal(10,0) DEFAULT NULL, //金额
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
<!-- 用户金额详情表  -->
DROP TABLE IF EXISTS `sh_user`;
CREATE TABLE `sh_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT, //金额表id
  `uid` int(11) DEFAULT NULL, //用户id
  `sid` int(11) DEFAULT NULL, //商品id
  `detail` varchar(50) DEFAULT NULL, //金额变动详情表
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
