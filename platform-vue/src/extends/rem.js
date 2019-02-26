(function(doc,win){
  var docEl = doc.documentElement,
    resizeEvt = 'orientationchange' in win ? 'orientationchange' : 'resize',
    recalc = function(){
      var clientWidth = docEl.clientWidth;
      if (!clientWidth) return;
      // 1rem = 20px;
      docEl.style.fontSize = 20 * (clientWidth / 375) + 'px';
    };
  if (!doc.addEventListener) return;
  win.addEventListener(resizeEvt,recalc,false);
  doc.addEventListener("DOMContentLoaded",recalc,false);
})(document,window)
