# cmall_leaning

# 导航
>[1. git操作](#1-git-操作)  
>>[1.1 常用命令](#11-常用命令)  
>>[1.2 版本修改](#12-版本修改)
>>>[1.2.1 退回到某一版本](#121-退回到某一版本) 

>[2. 配置文件](#2-配置文件) 
>>[2.1 generator](#21-generator)   
>>[2.2 下载破解mybatis plugin](#22-下载破解mybatis-plugin)   
>>[2.3 logback](#23-logback)  

>[3. 用户模块](#3-用户模块) 
>>[3.1 登陆功能](#31-登陆功能)   
>>[3.2 登出 注册 校验](#32-登出-注册-校验)  
>>[3.3 获取用户登录信息 忘记密码 提示问题与答案](#33-获取用户登录信息-忘记密码-提示问题与答案)  
>>[3.4 忘记密码中的重置密码](#34-忘记密码中的重置密码)  
>>[3.5 登陆状态中的重置密码](#35-登陆状态中的重置密码)    
>>[3.6 更新用户个人信息功能开发](#36-更新用户个人信息功能开发)  
>>[3.7 获取用户详细信息及MD5加密补充](#37-获取用户详细信息及MD5加密补充)  
>>[3.8 测试问题](#38-测试问题)  

>[4. 分类模块](#4-分类模块)    
>>[4.1 添加分类和更新分类名字](#41-添加分类和更新分类名字)  
>>[4.2 查询节点和递归查找](#42-查询节点和递归查找)  
>>[4.3 测试](#43-测试)  

>[5. 商品管理模块](#5-商品管理模块)  
>>[5.1 后台商品新增 更新 上下架](#51-后台商品新增-更新-上下架)  
>>[5.2 后台商品详情 propertiesUtil DateTimeUtil](#52-后台商品详情-propertiesUtil-DateTimeUtil)    
>>[5.3 后台商品列表动态分页](#53-后台商品列表动态分页)    
>>[5.4 后台商品搜索功能](#54-后台商品搜索功能)     
>>[5.5 后台商品图片的springMvc上传与富文本上传FTP](#55-后台商品图片的springMvc上传与富文本上传FTP)   
>>[5.6 前台商品详情 列表 搜索 动态排序](#56-前台商品详情-列表-搜索-动态排序) 

>[6. 购物车模块](#6-购物车模块)   
>>[6.1 加入购物车功能开发1](#61-加入购物车功能开发1 )   
>>[6.2 加入购物车功能开发2](#62-加入购物车功能开发2 )  
>>[6.3 更新删除购物车商品](#63-更新删除购物车商品)    
>>[6.4 全选 全反选 单选 单反选 查询购物车商品数量](#64全选-全反选-单选-单反选-查询购物车商品数量)  

>[7. 收货地址管理模块](#7-收货地址管理模块)    
>>[7.1 收货地址增 删 改 查 分页列表](#71收货地址增-删-改-查-分页列表)  

>[8. 支付模块](#8-支付模块)  
>>[8.1 支付宝文档](#81支付宝文档) 
>>[8.2 支付宝Demo](#82支付宝Demo) 






# 1. git 操作

## 1.1 常用命令

+ [Git安装教程](https://blog.csdn.net/amberom/article/details/79508116)
+ GitHub添加公钥
    + ssh-keygen -t rsa -C "sanhaowuai@163.com",邮箱是github注册邮箱
    + 一直Enter就行，随后提示公钥存放位置，一般是c:\user\.ssh,.pub就是公钥
    + 登录GitHub，点击头像，选择setting，左侧有个SSH and GPG keys ，
    选择new SSH key ,title随便写，将复制pub的内容黏贴上去ok。
    + 测试SSH key是否成功的添加到GitHub：ssh -T git@github.com，
    中途会有如下提示，填写yes即可。
+ 用户名邮箱的设置及修改
    + git config --global user.name "xxxx"   设置用户名
    +  git config --global user.email "xxxx"    设置邮箱
    +  git config user.name     查看用户名
    +  git config user.email    查看邮箱
    +  git config --global user.name "xxxx" 修改用户名
    +  git config --global user.email "xxxx@xxx.com" 修改邮箱
+ [使用Idea从github上获取项目](https://www.cnblogs.com/30go/p/7909246.html)
+ 克隆项目只能克隆master的项目，git branch只有* master,其他分支你在的仓库里面是隐藏的，git branch -a查看，
如果你想在那个分支工作的话，你就需要创建一个本地分支：git checkout -b v1.0 origin/v1.0,现在，此时：git branch
会看到多了v1.0。
+ [git克隆出所有分支](http://zhenhappy.github.io/2015/11/12/Git/git-clone-url-all-branches/)
+  跟踪多个远程分支
    git remote add win32 git://gutup.com/users/joe/myproject-linux-port 
    ```
    $ git branch -a  
     master
    * v1.0
      remotes/origin/HEAD -> origin/master
      remotes/origin/master
      remotes/origin/v1.0
      linux/master  
      linux/new-widgets 
      
      会多出inux/master，linux/new-widgets分支。
    ```
+ 初始化  
    + 普通仓库：git init 
    + 创建裸仓库：git init --bare repo.git
    + 区别：
        + 普通仓库不能被 push，因为可能会有暂存文件，从而导致冲突，所以 git 做了限制
        + bare 仓库可以被 push，因为它禁止在仓库里工作（没有暂存文件），不存在上面的问题。文件夹通常命名为 xxx.git
        + 现在的代码托管服务 github 这些，新建仓库都是 bare，所以见到的克隆地址都是 xxx.git
+ 添加  git add . 
+ 提交到本地库 git commit -m "注释"
    + git commit 可进行详细叙述提交的原因，再出现的编辑页面中什么也不写，退出则不进行提交；若在最后面写入提交内容保存退出，直接自动进行提交
    + -am 可以不先git add 直接 git commit -am即可。
    + -m 是进行简单描述提交的原因。
+ 链接远程 git remote add origin  git@github.com:sanhaowuai/cmall_leaning.git
    + 删除远程链接 git remote rm origin
    + 查看远程链接 git remote -v
+ 查看本地分支 git branch
+ 本地从远程库更新（第一次链接远程库需要，以后直接git pull,在这之前必须保证本地已经提交到本地版本库）git pull origin master --allow-unrelated-histories
+ 推送到远程 git push -u origin master (将本地的master分支推送到origin主机，同时指定origin为默认主机，以后使用git push)
+ 删除远程库文件夹 
    + git rm -r --cache filename （仅仅删除暂存区或分支上的文件夹, 本地保留，若不保留，则去掉--cache）
    + git commit -m 'filename'  
    + git push -u origin master 
+ 查看远程分支 git branch -r
+ 在远程的master基础上创建本地分支 git checkout -b v1.0 origin/master
    + 在当前的分支上创建v1.0分支：git checkout -b v1.0 
+ 将本地分支推送到远程 git push origin HEAD -u
    + 远程分支若没有v1.0,可也直接使用 git push -u origin v1.0
+ 将本地分支修改过的代码推送到远程分支 git push -u origin v1.0
+ 从远程下载（只能下载master）git clone git@github.com:sanhaowuai/cmall_leaning.git
+ 从远程分支基础上创建本地分支git checkout -b v1.0 origin/v1.0
+ 从远程只下载分支 git clone -b v1.0 https://github.com/sanhaowuai/cmall_leaning.git
+ 分支 
    + 查看本地分支：git branch
    + 查看所有分支：git branch -a
    + 查看远程分支：git branch -r
    + 切换本地分支：git checkout v1.0
    + 删除本地分支：git branch -d <分支名称>;git branch -d v1.0
    + 删除远程分支: git push origin --delete <分支名称>;git push origin --delete v1.0
+ 合并分支 
    + 首先切换到 master 分支：git checkout master
    + 创建合并提交：git merge --no-ff v1.0
    + 将编辑器中显示的内容保存，关闭编辑器
+ 以图表形式查看分支：git log --graph    
+ 查看当前仓库的操作日志：git reflog

+ 若是通过http方式与github通信，push填写账号密码出现问题时，需要在搜索框中输入：凭据管理器,然后（windows凭证管理栏）,普通凭证下拉打开有你已存在的git账号密码，删除后继续push
   
## 1.2 版本修改 

+[idea回退方法参考](https://blog.csdn.net/pengdeman/article/details/84788112)

+ 回退到上一次提交的状态（本地的源码也会变为上一个版本的内容） git revert HEAD  
+ 回退到某个版本（保留源码,可省略--mixed） git reset 057d
    + 不保留源码 git reset --hard 057d
+ 将本地的状态回退到和远程的一样  git reset --hard origin/master   
+ 回退a.py这个文件的版本到上一个版本 git reset HEAD^ a.py 
+ 回退所有内容到上一个版本  git reset HEAD^  

### 1.2.1 退回到某一版本

[参考博客：https://blog.csdn.net/gomeplus/article/details/78241070](https://blog.csdn.net/gomeplus/article/details/78241070)：https://blog.csdn.net/gomeplus/article/details/78241070

1. 在“Show History”中找到当前版本（取名：newVersion）和想要回退到的版本（oldVersion）
2. 选择newVersion和oldVersion点击“Copy Revision Number”复制两个版本的版本号：
3. 右击项目依次选中：Git->Repository->Reset HEAD 
4. 选中Reset Type:*Hard, To Commit:6bc5691cbe7304cb185b70fbc0dd975c7de86e8a（oldVersion）；然后点击Reset按钮*
5. 这时本地代码已经回退到oldVersion，这时候如果直接push到远程仓库，会提示版本冲突，点击“cancel”取消
6. 下面有两种解决冲突的方法
    + 方法一 ：不解决，直接强制提交： 
      + 打开Terminal，切换到项目所在目录 
      + 执行：git push -f 
    + 方法二： 
      + 右击项目依次选中：Git->Repository->Reset HEAD 
      + 选中Reset Type:Mixed, To Commit:2746f428a3d3d000bd1b0e886ef8167e1f73ec9c（newVersion）；然后点击Reset按钮 
      + 这时你会发现，最新版本有回到newVersion。但是代码还是oldVersion的代码，这时候重push到远程仓库就不会版本冲突了 
    + 方法一vs方法二 
      + 方法一会将回退的提交记录抹去，而方法二会保留 

# 2. 配置文件

## 2.1 generator

生成后的xml文件修改其中的create_time与update_time赋值，使用自带函数now()。

`注意：`在选择创建的xml语句中，<if test="createTime != null" >和<if test="updateteTime != null" >
是需要去掉的，因为使用了now()函数，创建时更新字段为空,但更新字段不能去除，因为字段性质是非空。同理，更新也一样，但更新
时，创建时间的字段可以去掉。

## 2.2 下载破解mybatis plugin

[下载文件路径：https://github.com/FanVV/mybatis_plus](https://github.com/FanVV/mybatis_plus)

关闭idea(此mybatis plugin的版本为2.9.2)
1. 打开我的电脑，找到路径C:\Users\爱迪生\.IntelliJIdea2018.1\config\plugins
2. 把上面下载后的mybatis_plus文件夹（也就是点击mybatis_plus-master目录里解压mybatis_plus.zip后的文件夹），是文件夹，不要带上ZIP， 复制到第一步的路径下
3. 打开我的电脑，找到路径C:\Users\爱迪生\.IntelliJIdea2018.1\config\options，这是本人的电脑路径，把刚下载的文件夹中的mybatis.xml复制到该文件夹下

`注意：`以上方式在2018.3版本的idea中无法使用，可以直接下载插件Free Mybatis plugin，效果是一样的

## 2.3 logback

[配置详解：https://www.cnblogs.com/cb0327/p/5759441.html](https://www.cnblogs.com/cb0327/p/5759441.html)

# 3. 用户模块

idea创建多级文件夹，先将java文件定义为Sources或者Tests,此时在java文件下可出现package选项，新建时可用.作为分割符号
否则，只能用/符号作为分隔符。

## 3.1 登陆功能

1. 新建一个包portal(门户的意思，给前端用的)，建一个UserController类，建一个login方法（不做任何实现）；在service中新建一个IUserService
接口，创建一个login参数为username,password方法,新建一个impl包->UserServiceImpl实现类（不做任何实现）。
2. 在commen包中创建ServerResponse类（通用数据响应对象）;属性为status，msg,data;其中data为泛型。四种私有构造方法，并提供获取属性方法，
isSuccess方法，获取构造不同对象的五种方法。
3. 在commen中创建ResponseCode（响应编码枚举类）用来响应状态。
4. 创建checkUsername(检查用户是否存在)、selectLogin（登陆查询）
5. 完善service中的login及controller中的login方法。

`注意：`若是在service中使用@Autowired注入UserMapper的时候，出现报错，此时，需配置Setting->Editor->Inspections->Spring Core->Code->点中Autowiting for Bean Class，选择右边Severity为warning

## 3.2 登出 注册 校验

1. 登出方法 logout
2. 注册方法 register：增加checkUsername与checkEmail校验，Const中增加用户分组，默认注册用户是普通用户
3. 校验用户名与email方法：checkValid，增加MD5密码加密，Const中增加type类型，username与email，将注册方法中的校验用checkValid进行复用。

## 3.3 获取用户登录信息 忘记密码 提示问题与答案

1. 获取用户信息：getUserInfo
2. 获取密码提示问题：forgetGetQuestion
3. 校验回答问题是否正确：forgetCheckAnswer，common包中增加TokenCache类，问题回答正确后，将token放在本地缓存。

## 3.4 忘记密码中的重置密码

1. 重置密码：forgetResetPassword，将token_前缀放入TokenCache类中，前端传入的forgetToken
与guava缓存中的token是否一致，一致允许修改密码。

## 3.5 登陆状态中的重置密码

1. 重置密码：resetPassword，使用自动生成的dao方法updateByPrimaryKeySelective，选择性更新

## 3.6 更新用户个人信息功能开发

1. 更新用户个人信息：update_information，根据当前用户id查询email是否存在，更新成功后需更新
session信息。

## 3.7 获取用户详细信息及MD5加密补充

1. 获取用户详细信息:get_information,需要将得到用户的密码置为空
2. 管理员登陆：创建backend包，并创建UserManageController类，需要判断登陆的角色是否是
Const.Role.ROLE_ADMIN，若不是，则登陆不成功，若是，则登陆成功。

## 3.8 测试问题

1. 请求返回的时间戳是Unix的，需要改写。  
    [解决参考方法](http://godfox.iteye.com/blog/658427)
    + 先定义自己需要的格式，在util包中加入CustomDateSerializer类
    + 然后在POJO上找到日期的get方法，加入@JsonSerialize(using = CustomDateSerializer.class) 
    + 以上，科技解决时间格式问题，但在5.2中会写时间处理类来处理此类问题
2. mysql 遇到的问题  
[MYSQL5.7版本sql_mode=only_full_group_by问题]https://www.cnblogs.com/anstoner/p/6414440.html

# 4. 分类模块

## 4.1 添加分类和更新分类名字

1. 新增CategoryManageController、CategoryServiceImpl、ICategoryService类
2. 新增分类：addCategory；更新分类名字：setCategoryName；分别校验用户是否登录并是否是管理员

## 4.2 查询节点和递归查找

1. 获取当前节点的子节点：getChildrenParallelCategory
2. 递归获取当前分类及子节点的id：getCategoryAndDeepChildrenCategory
    + Set<Category>的使用：重写equals和hashCode

[深入详解SetHash的元素为什么要重写hashCode和equals方法](https://blog.csdn.net/w3045872817/article/details/73294491)

## 4.3 测试

# 5. 商品管理模块

## 5.1 后台商品新增 更新 上下架

1. 新增ProductManageController类
    + 新增或更新产品：productSave
2. 新增IProductService,ProductServiceImpl
    + 修改产品销售状态：setSaleStatus
    
## 5.2 后台商品详情 propertiesUtil DateTimeUtil   

1. 新增vo包及ProductDetailVo类
2. 新增PropertiesUtil读取配置文件公共类
3. 新增DateTimeUtil日期转化公共类

## 5.3 后台商品列表动态分页

1. 方法：getList
2. 新增ProductListVo类
3. 使用pagehelper中的PageInfo进行分页

## 5.4 后台商品搜索功能

1. 方法：productSearch
2. sql中含有<where>标签，where标签默认去除离他最近的and逻辑词。

## 5.5 后台商品图片的springMvc上传与富文本上传FTP

0. 打开ftp服务器;mmall.properties配置文件中需填写对应的ftp信息。
1. 方法：upload
2. 创建类：FileServiceImpl与IFileService
3. util中创建FTPUtil类
4. 富文本使用simditor，需按照规定返回success,msg,file_path三个参数；方法：richtextImgUpload

## 5.6 前台商品详情 列表 搜索 动态排序

1. 商品详情：portal包中的ProductController中detail方法
2. 列表、搜索、动态排序：portal包中的ProductController中list方法
    + 排序使用PageHelper.orderBy,Const中增加接口ProductListOrderBy商品排序字段
    
# 6. 购物车模块

## 6.1 加入购物车功能开发1

1. 创建CartController类，增加方法add。
2. 创建IcarService与CarServiceImpl类，增加add与getCartVoLimit方法
3. Const中增加Cart接口，增加CHECKED与UN_CHECKED状态（购物车中的产品是否选中）

## 6.2 加入购物车功能开发2

1. 创建BigDecimalTest测试类,`构造器中的参数一定是String类型`
2. 创建BigDecimalUtil工具类
3. 购物车信息动态显示方法  getCartVoLimit
4. Const中新加入LIMIT_NUM_FAIL与LIMIT_NUM_SUCCESS两个变量（若购物车库存大于实际库存，LIMIT_NUM_FAIL 限制失败）
5. 购物车中的商品是否全部勾选 getAllCheckedStatus

## 6.3 更新删除购物车商品

1. 新增update方法，使用service中核心展示方法getCartVoLimit返回CartVo
2. 新增deleteProduct方法，service中使用guava中的Splitter.on将字符串进行分割，并自动填充到List中，利用foreach进行循环查询，
使用service中核心展示方法getCartVoLimit返回CartVo

## 6.4 全选 全反选 单选 单反选 查询购物车商品数量

1. 全选、全反选、单选、单反选 参考全选selectAll方法
2. 查询购物车商品数量 方法getCartProductCount，其中sql使用ifnull 处理查询是null无法转换成int的问题

# 7. 收货地址管理模块

## 7.1 收货地址增 删 改 查 分页列表

1. 增加ShippingController类，IShippingService、ShippingServiceImpl类，增加add，删除del，修改update，查询select，列表页面list
2. 其中增加地址时，由于前端需要返回新加地址的id，所以，在mapper中加入了useGeneratedKeys="true" keyProperty="id"两个属性，可以向参数对象中注入id的值。

# 8. 支付模块

## 8.1 支付宝文档

1. [沙箱登录](https://openhome.alipay.com/platform/appDaily.htm )
    + 输入用户名密码
    + 选择自研开发者，填写相关信息
    + 开发者中心（点击账户右侧的管理中心即可出现）->研发服务（沙箱/凤蝶/验收/数据实验室）
2. [沙箱环境使用说明](https://docs.open.alipay.com/200/105311)
3. [如何使用沙箱环境](https://support.open.alipay.com/support/hotProblemDetail.htm?spm=a219a.7386793.0.0.uS5uZ6&id=251932&tagId=100248)
4. [当面付产品介绍](https://docs.open.alipay.com/194/105072)
5. [扫码支付接入指引](https://docs.open.alipay.com/194/106078)
6. [当面付快速接入](https://docs.open.alipay.com/194/105170)
7. [当面付接入必读](https://docs.open.alipay.com/194/105322)
8. [当面付进阶功能](https://docs.open.alipay.com/194/105190)
9. [当面付异步通知-仅用于扫码支付](https://docs.open.alipay.com/194/103296)
10. [当面付SDK&DEMO](https://support.open.alipay.com/docs/doc.htm?spm=a219a.7386797.0.0.k0rwWc&treeId=193&articleId=105201&docType=1)
11. [服务端SDK](https://docs.open.alipay.com/54/103419)
12. [生成RSA密钥](https://docs.open.alipay.com/291/105971)
13. [线上创建应用说明](https://docs.open.alipay.com/200/105310)

## 8.2 支付宝Demo

1. 下载当面付sdk&demo,并打开TradePayDemo项目，需配置zfbinfo.properties文件，然后运行Main.java
2. [进入natapp官网](https://natapp.cn/)，注册免费使用，也可以付费。[参考1分钟教程](https://natapp.cn/article/natapp_newbie)或者[如何配置NATAPP](https://blog.csdn.net/m0_37987521/article/details/79525515),
需修改端口为本地端口


`注意：` ctrl+o 查找类中方法





    










