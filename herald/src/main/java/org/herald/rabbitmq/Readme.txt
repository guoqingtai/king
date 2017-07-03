rabbit mq 安装
修改
/etc/hosts文件
加入 127.0.0.1 主机名
cd sbin
./rabbitmq_server start
//新增admin 密码admin
rabbitmqctl add_user admin admin　　　　
//将admin用户设置为administrator
rabbitmqctl set_user_tags admin administrator


打开ui管理
./rabbitmq-plugins enable rabbitmq_management

rabbitmqctl set_permissions -p "/" fanfou ".*" ".*" ".*"
