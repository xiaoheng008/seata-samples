#!/bin/bash
#kito test环境部署脚本
projectDir="/Users/xiaoheng/IdeaProjects/seata-samples/springboot-dubbo-seata"
echo $projectDir

serverDir="xiaoheng@ubuntu-linux:/home/xiaoheng"
echo $serverDir

server="ssh xiaoheng@ubuntu-linux"

mavenUrl="http://nexus3.51hanwan.com/repository/hwm-hosted/"
echo $mavenUrl
mavenLocalDir="/Users/xiaoheng/.m2/repository/com/pita"
echo $mavenLocalDir


businessFun(){
    echo "创建远程目录"
    `eval echo ${server}` "mkdir /home/xiaoheng/app/samples-business"
    echo "删除远程文件"
    `eval echo ${server}` "rm /home/xiaoheng/app/samples-business/samples-business-1.0.0-SNAPSHOT.jar"
    echo "上传business"
    scp "${projectDir}"/samples-business/target/samples-business-1.0.0-SNAPSHOT.jar "${serverDir}/app/samples-business/"
}

storageFun(){
    echo "创建远程目录"
    `eval echo ${server}` "mkdir /home/xiaoheng/app/samples-storage"
    echo "删除远程文件"
    `eval echo ${server}` "rm /home/xiaoheng/app/samples-storage/samples-storage-*.jar"
    echo "上传storage"
    scp "${projectDir}"/samples-storage/target/samples-storage-*.jar "${serverDir}/app/samples-storage/"
}

orderFun(){
    echo "创建远程目录"
    `eval echo ${server}` "mkdir /home/xiaoheng/app/samples-order"
    echo "删除远程文件"
    `eval echo ${server}` "rm /home/xiaoheng/app/samples-order/samples-order-*.jar"
    echo "上传order"
    scp "${projectDir}"/samples-order/target/samples-order-*.jar "${serverDir}/app/samples-order/"
}

accountFun(){
    echo "创建远程目录"
    `eval echo ${server}` "mkdir /home/xiaoheng/app/samples-account"
    echo "删除远程文件"
    `eval echo ${server}` "rm /home/xiaoheng/app/samples-account/samples-account-*.jar"
    echo "上传account"
    scp "${projectDir}"/samples-account/target/samples-account-*.jar "${serverDir}/app/samples-account/"
}

while [ -n "$1" ]
do
    case "$1" in
        -m)
            echo "打包工程"
            cd "${projectDir}"
            mvn clean package -DskipTests -T 1C
            ;;
        -i)
            echo "安装工程"
            cd "${projectDir}"
            mvn clean install -U -DskipTests
            ;;
        -all)
            accountFun
            orderFun
            storageFun
            businessFun
            ;;
        -account)
            accountFun
            ;;
        -order)
            orderFun
            ;;
        -storage)
            storageFun
            ;;
        -business)
            businessFun
            ;;
    esac
    shift
done