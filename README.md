# cmall_leaning
#git 操作

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
ceshi



