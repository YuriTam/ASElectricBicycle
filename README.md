#随车行App
ps：由于项目前期架构是mvc，现在正从mvc修改成MVP的过程中，所以包结构有点混乱。并有部分功能尚未完成，正在紧张开发中

> 前期的版本：https://github.com/122627018/ElectricBicycle



##效果图

![这里写图片描述](http://img.blog.csdn.net/20160617130323086)![这里写图片描述](http://img.blog.csdn.net/20160617130338466)![这里写图片描述](http://img.blog.csdn.net/20160617130351153)![这里写图片描述](http://img.blog.csdn.net/20160617130417497)![这里写图片描述](http://img.blog.csdn.net/20160617130630076)![这里写图片描述](http://img.blog.csdn.net/20160617130432212)![这里写图片描述](http://img.blog.csdn.net/20160617130448119)![这里写图片描述](http://img.blog.csdn.net/20160617130454622)![这里写图片描述](http://img.blog.csdn.net/20160617130508701)![这里写图片描述](http://img.blog.csdn.net/20160617130515888)![这里写图片描述](http://img.blog.csdn.net/20160617130522041)

##项目介绍
###背景
开发这款应用的目的是为了适配学校的另外一个创业项目，那个项目开发了一辆代步车(像自行车又像小时候玩的滑板)。所以老师希望独立开发一个可以搭配辆车进行线上线下交互的app(实验室的人都哪去了)，就是随车行app。
###项目特点
+ 基于百度地图api,实现地图功能，提供地点搜索，路线查询，实时路线导航的功能
+ 设计用户模块，实现用户-电动车一对一，用户-用户多对多关系的数据模型实现
+ 基于环信IM实现好友聊天，表情发送，位置共享功能
+ 基于geohash算法实现附近的人查找
+ 基于CoordinatorLayout的多层嵌套原理，通过多层自定义的behavior实现三个控件的联动
+ 基于自定义RxJava操作符，拦截RxJava+Retrofit获取数据过程中的异常，通过一个异常驱动器，优雅地完成了整个项目的异常处理机制
+ 基于自封装的MVP结构，使整体项目代码简洁，业务逻辑清晰



##技术特点
###MVP基础框架
lz自己封装的一个实用性很强的mvp基础框架
> https://github.com/122627018/BaseMVP

###增强版Retrofit+RxJava网络访问框架
在本项目中，P与M的数据交互基本都是发生在RxAndroid的工作流中，那么怎么去处理流中的异常事件呢？具体：
> 优雅地处理服务器返回的错误和客户端访问网络过程中产生的错误
> https://github.com/122627018/Retorfit_RxJava_Exception

###走在潮流前线的动画效果
通过自定义的CoordinatorLayout behavior实现控件联动



![这里写图片描述](https://github.com/122627018/ASElectricBicycle/blob/master/demo1.gif)

双层CoordinatorLayout嵌套(在控件的底部其实还有一个snackBar一起联动)，但是自定义控件的behavior实现方式跟snackBar完全不相同


##其他
###服务器代码
服务器使用JavaWeb+Tomcat7.0，完全自己编写，使用servlet回应，与客户端的交互采用json的数据格式
(服务器也需要集成环信的im，客户端的用户注册功能是由服务器来完成的)

![这里写图片描述](http://img.blog.csdn.net/20160617111507607)

> 传送门：https://github.com/122627018/ElectricBicycleServer

###关于一些其他知识点可以留意lz博客：

> http://blog.csdn.net/qq122627018




