# cmall_leaning

# 导航
>[1. git操作](#1-git-操作)  
>>[1.1 常用命令](#11-常用命令)  
>>[1.2 版本修改](#12-版本修改)
>>>[1.2.1 退回到某一版本](#121-退回到某一版本) 

>[2. 配置文件](#2-配置文件) 
>>[2.1 generator](#21-generator) 
>>[2.2 logback](#22-logback)  

>[3. 用户模块](#3-用户模块) 
>>[3.1 登陆功能](#31-登陆功能) 
>>[3.2 登出、注册、校验](#32-登出、注册、校验)
>>[3.3 获取用户登录信息、忘记密码、提示问题与答案](#33-获取用户登录信息、忘记密码、提示问题与答案)
>>[3.4 忘记密码中的重置密码](#34-忘记密码中的重置密码)
>>[3.5 登陆状态中的重置密码](#35-登陆状态中的重置密码)

# 1. git 操作

## 1.1 常用命令

+ 初始化  git init 
+ 添加  git add . 
+ 提交到本地库 git commit -am "注释"
+ 链接远程 git remote add origin  git@github.com:sanhaowuai/cmall_leaning.git
+ 查看本地分支 git branch
+ 本地从远程库更新（第一次链接远程库需要，以后直接git pull）git pull origin master --allow-unrelated-histories
+ 推送到远程 git push -u origim master
+ 查看远程分支 git branch -r
+ 在远程的master基础上创建本地分支 git checkout -b v1.0 origin/master
+ 将本地分支推送到远程 git push origin HEAD -u
+ 将本地分支修改过的代码推送到远程分支 git push -u origin v1.0
+ 从远程下载（只能下载master）git clone git@github.com:sanhaowuai/cmall_leaning.git
+ 从远程分支基础上创建本地分支git checkout -b v1.0 origin/v1.0
+ 从远程只下载分支 git clone -b v1.0 https://github.com/sanhaowuai/cmall_leaning.git
   
## 1.2 版本修改 

+ 回退到上一次提交的状态（本地的源码也会变为上一个版本的内容） git revert HEAD  
+ 回退到某个版本（保留源码,可省略--mixed） git reset 057d
+ 将本地的状态回退到和远程的一样  git reset --hard origin/master   
+ 回退a.py这个文件的版本到上一个版本 git reset HEAD^ a.py 
+ 回退所有内容到上一个版本  git reset HEAD^  

### 1.2.1 退回到某一版本

[参考博客](https://blog.csdn.net/gomeplus/article/details/78241070)：https://blog.csdn.net/gomeplus/article/details/78241070

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

## 2.2 logback

[参考配置详解](https://www.cnblogs.com/cb0327/p/5759441.html)

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

1. 重置密码：forgetResetPassword，将token_前缀放入TokenCache类中

## 3.5 登陆状态中的重置密码

1. 重置密码：resetPassword，使用自动生成的dao方法updateByPrimaryKeySelective，选择性更新