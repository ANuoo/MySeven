# My seven</br>
<br/>  这是一个根据所给接口制作的小说搜索界面</br>
<br/>  MainActivity中，cardview和recycleview相结合做出卡片式的书列
<br/>  ![avater](http://m.qpic.cn/psb?/V12pRwMy1vBidC/reKJ7i7xqM7ZJYAN6m8mrLl1Bf.hYpzU7av7humXOjw!/b/dLkAAAAAAAAA&bo=bQGKAgAAAAADJ.Y!&rf=viewer_4)
<br/>  网络请求只用了GET，获得的数据通过JSON解析，没有用第三方框架。用户可在Edittxt中输入书名进行搜索
<br/>  如下图，若在Edittxt中输入接口中书名--盗墓笔记薄</br>
<br/>  ![avater](http://m.qpic.cn/psb?/V12pRwMy1vBidC/FWupL0M8d3ywLx9y8HDTMyr1GsqipYNq8u8mHUQnyOg!/b/dMEAAAAAAAAA&bo=bAGHAgAAAAADJ.o!&rf=viewer_4)
<br/>  点击搜索图标后将转到ResultActivity通过cardviwe来显示结果</br>
<br/>  ![avater](http://m.qpic.cn/psb?/V12pRwMy1vBidC/CZVgjTl.qVPPH5ZDUPiXIdzrzeGYb9R0cM*Y5bdY.Fc!/b/dL8AAAAAAAAA&bo=bwGOAgAAAAADJ.A!&rf=viewer_4)
<br/>  但如果输入的并不是所给接口中的书目</br>
<br/> ![avater](http://m.qpic.cn/psb?/V12pRwMy1vBidC/MqqMcTbGJ5woz8902*vsEgis0ass0fLAcNZf3MdZCOk!/b/dDQBAAAAAAAA&bo=bAGMAgAAAAADF9E!&rf=viewer_4)
<br/>  点击图标后将转到NotFindActivity通过textview来显示结果</br>
<br/> ![avater](http://m.qpic.cn/psb?/V12pRwMy1vBidC/LW3FOMrLUpOFUNLR98e6iu0Zbu27qRzDztPerGYz9j8!/b/dFMBAAAAAAAA&bo=bQGEAgAAAAADF9g!&rf=viewer_4)
