# Getting Started

实现单点登录的思路：

1、首次登录成功的时候：

    把sessionID作为key

	把登录成功的用户对象作为value存储

2、保证回话的一致性：

	把会话ID保存到redis中

	key=会话ID

	value=用户对象对应的json字符串

3、第二次访问的时候

  3.1 获取cookie中保存的会话ID
  
  3.2 通过获取会话ID从redis中获取对应用户对象

4、 单点登录有个问题，会话失效

	session默认有效时间：30分钟
	
cookie是不能跨浏览器访问的