import FastClick from 'fastclick';

//解决vue-video-player和fastclick不兼容的问题
FastClick.prototype.needsClick = function(target) {
  switch (target.nodeName.toLowerCase()) {
    case 'button':
    case 'select':
    case 'textarea':
      if (target.disabled) {
        return true;
      }
      break;
    case 'input':
      if ((deviceIsIOS && target.type === 'file') || target.disabled) {
        return true;
      }
      break;
    case 'label':
    case 'iframe': // iOS8 homescreen apps can prevent events bubbling into frames
    case 'video':
      return true;
  }
  return ((/\bneedsclick\b/).test(target.className) || (/\bvjs/).test(target.className));
};

if ('addEventListener' in document) {
  document.addEventListener('DOMContentLoaded',()=>{
    FastClick.attach(document.body);
  },false)
}
