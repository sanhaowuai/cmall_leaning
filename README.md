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
>>[3.2 登出、注册、校验](#32-登出、注册、校验)  
>>[3.3 获取用户登录信息、忘记密码、提示问题与答案](#33-获取用户登录信息、忘记密码、提示问题与答案)  
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
>>[5.1 后台商品新增、更新、上下架](#51-后台商品新增、更新、上下架)  
>>[5.2 后台商品详情、propertiesUtil、DateTimeUtil](#52-后台商品详情、propertiesUtil、DateTimeUtil)   
>>[5.3 后台商品列表动态分页](#53-后台商品列表动态分页)   
>>[5.4 后台商品搜索功能](#54-后台商品搜索功能)   





# 1. git 操作

## 1.1 常用命令

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
+ 查看本地分支 git branch
+ 本地从远程库更新（第一次链接远程库需要，以后直接git pull）git pull origin master --allow-unrelated-histories
+ 推送到远程 git push -u origim master
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
    
   
## 1.2 版本修改 

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

## 2.3 logback

[配置详解：https://www.cnblogs.com/cb0327/p/5759441.html](https://www.cnblogs.com/cb0327/p/5759441.html)

# 3. 用户模块

## 3.1 登陆功能

1. 新建一个包portal(门户的意思，给前端用的)，建一个UserController类，建一个login方法（不做任何实现）；在service中新建一个IUserService
接口，创建一个login参数为username,password方法,新建一个impl包->UserServiceImpl实现类（不做任何实现）。
2. 在commen包中创建ServerResponse类（通用数据响应对象）;属性为status，msg,data;其中data为泛型。四种私有构造方法，并提供获取属性方法，
isSuccess方法，获取构造不同对象的五种方法。
3. 在commen中创建ResponseCode（响应编码枚举类）用来响应状态。
4. 创建checkUsername(检查用户是否存在)、selectLogin（登陆查询）
5. 完善service中的login及controller中的login方法。

`注意：`若是在service中使用@Autowired注入UserMapper的时候，出现报错，此时，需配置Setting->Editor->Inspections->Spring Core->Code->点中Autowiting for Bean Class，选择右边Severity为warning

## 3.2 登出、注册、校验

1. 登出方法 logout
2. 注册方法 register：增加checkUsername与checkEmail校验，Const中增加用户分组，默认注册用户是普通用户
3. 校验用户名与email方法：checkValid，增加MD5密码加密，Const中增加type类型，username与email，将注册方法中的校验用checkValid进行复用。

## 3.3 获取用户登录信息、忘记密码、提示问题与答案

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

## 5.1 后台商品新增、更新、上下架

1. 新增ProductManageController类
    + 新增或更新产品：productSave
2. 新增IProductService,ProductServiceImpl
    + 修改产品销售状态：setSaleStatus
    
## 5.2 后台商品详情、propertiesUtil、DateTimeUtil   

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










