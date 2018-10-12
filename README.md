# cmall_leaning

# 导航
>[1. git操作](#1-git-操作)  
>>[1.1 常用命令](#11-常用命令)  
>>[1.2 版本修改](#12-版本修改)
>>>[1.2.1 退回到某一版本](#121-退回到某一版本) 

>[2. 配置文件](#2-配置文件) 
>>[2.1 logback](#21-logback)  
>>>[1.2.1 退回到某一版本](#121-退回到某一版本) 

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

## 2.1 logback

[参考配置详解](https://www.cnblogs.com/cb0327/p/5759441.html)

