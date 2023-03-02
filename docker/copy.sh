#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/ry_20220814.sql ./mysql/db
cp ../sql/ry_config_20220510.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../yimo-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy ruoyi-gateway "
cp ../yimo-gateway/target/yimo-gateway.jar ./yimo/gateway/jar

echo "begin copy ruoyi-auth "
cp ../yimo-auth/target/yimo-auth.jar ./yimo/auth/jar

echo "begin copy ruoyi-visual "
cp ../yimo-visual/yimo-monitor/target/yimo-visual-monitor.jar  ./yimo/visual/monitor/jar

echo "begin copy ruoyi-modules-system "
cp ../yimo-modules/yimo-system/target/yimo-modules-system.jar ./yimo/modules/system/jar

echo "begin copy ruoyi-modules-file "
cp ../yimo-modules/yimo-file/target/yimo-modules-file.jar ./yimo/modules/file/jar

echo "begin copy ruoyi-modules-job "
cp ../yimo-modules/yimo-job/target/yimo-modules-job.jar ./yimo/modules/job/jar

echo "begin copy ruoyi-modules-gen "
cp ../yimo-modules/yimo-gen/target/yimo-modules-gen.jar ./yimo/modules/gen/jar

